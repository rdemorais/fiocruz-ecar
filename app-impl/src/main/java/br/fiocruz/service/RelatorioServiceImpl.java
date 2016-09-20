package br.fiocruz.service;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import br.fiocruz.dao.RelatorioDao;
import br.fiocruz.exc.AkulaRuntimeException;
import br.fiocruz.exc.AkulaServiceRuntimeException;
import br.fiocruz.file.EcarFileSystem;
import br.fiocruz.model.AcompReferenciaAref;
import br.fiocruz.model.Nivel;
import br.fiocruz.report.EcarReport;
import br.fiocruz.servico.RelatorioService;
import br.fiocruz.servico.TipoRelatorio;
import br.fiocruz.servico.dto.CicloDto;
import br.fiocruz.servico.dto.FiltroDto;
import br.fiocruz.servico.dto.IettDto;
import br.fiocruz.servico.dto.IndicadorDto;
import br.fiocruz.servico.dto.RelatorioJasperDto;

public class RelatorioServiceImpl implements RelatorioService {
	
	@Autowired
	private EcarFileSystem ecarFileSystem;
	
	@Autowired
	private EcarReport ecarReport;
	
	@Autowired
	private RelatorioDao relatorioDao;
	
	public List<CicloDto> listCiclos() throws AkulaRuntimeException {
		return relatorioDao.listCiclos();
	}
	
	private Map<String, Object> gerarParametros() throws IOException {
		Map<String, Object> parametros = new HashMap<String, Object>();
		SimpleDateFormat sdfDataH = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		BufferedImage logoHeader = ecarFileSystem.getImageFromContext("cabecalho_fiocruz.png");
		
		//parametros.put("logo", image);
		parametros.put("logoHeader", logoHeader);
		parametros.put("dataAtual", sdfDataH.format(new Date()));
		
		return parametros;
	}
	
	public byte[] gerarRelatorioGerencial(FiltroDto filtro) throws AkulaRuntimeException {
		Map<String, Object> parametros = new HashMap<String, Object>();
		List<Object> conteudo = new ArrayList<Object>();
		
		try {
			parametros = gerarParametros();
			List<IettDto> listaItens = listaEixos(filtro, TipoRelatorio.GERENCIAL);
			AcompReferenciaAref aref = relatorioDao.find(AcompReferenciaAref.class, filtro.getCodAref());
					
			RelatorioJasperDto relGerencial = new RelatorioJasperDto();
			relGerencial.setListaItens(listaItens);
			relGerencial.setCiclo(aref.getNome());
			
			conteudo.add(relGerencial);
			
			byte[] bytes = ecarReport.generateReportPDF("resumo-gerencial.jasper",  parametros, conteudo);
			
			return bytes;
		} catch (IOException e) {
			throw new AkulaServiceRuntimeException(e.getMessage(), e);
		}
	}
	
	public byte[] gerarRelatorioExecutivo(FiltroDto filtro) throws AkulaRuntimeException {
		Map<String, Object> parametros = new HashMap<String, Object>();
		List<Object> conteudo = new ArrayList<Object>();
		
		try {
			parametros = gerarParametros();
			List<IettDto> listaItens = listaEixos(filtro, TipoRelatorio.EXECUTIVO);
			RelatorioJasperDto relExecutivo = new RelatorioJasperDto();
			relExecutivo.setListaItens(listaItens);
			
			conteudo.add(relExecutivo);
			
			byte[] bytes = ecarReport.generateReportPDF("resumo-executivo.jasper",  parametros, conteudo);
			
			return bytes;
		} catch (IOException e) {
			throw new AkulaServiceRuntimeException(e.getMessage(), e);
		}
	}
	
	private List<IettDto> listaEixos(FiltroDto filtro, TipoRelatorio tipoRelatorio) throws IOException {
		List<IettDto> eixos;
		
		switch (tipoRelatorio) {
		case EXECUTIVO:
			eixos = relatorioDao.listItens(filtro);
			break;
		case GERENCIAL:
			eixos = relatorioDao.listItensCiclo(filtro);
			break;
		default:
			eixos = new ArrayList<IettDto>();
			break;
		}
		
		for (IettDto eixo : eixos) {
			filtro.setCodIettPai(eixo.getId());
			filtro.setNivel(Nivel.OE);
			if(eixo.getNomeCor() == null) {
				eixo.setImgStatus(ecarFileSystem.getImageFromContext("branco.gif"));
				eixo.setSignificadoCor("Não Monitorado");
			}else {
				eixo.setImgStatus(ecarFileSystem.getImageFromContext(eixo.getNomeCor().toLowerCase() + ".gif"));
			}
			
			List<IettDto> oes;
			
			switch (tipoRelatorio) {
			case EXECUTIVO:
				oes = relatorioDao.listItens(filtro);
				break;
			case GERENCIAL:
				oes = relatorioDao.listItensCiclo(filtro);
				break;
			default:
				oes = new ArrayList<IettDto>();
				break;
			}
			
			
			eixo.setDescendentes(oes);
			for (IettDto oe : oes) {
				filtro.setCodIettPai(oe.getId());
				filtro.setNivel(Nivel.INICIATIVA);
				
				if(oe.getNomeCor() == null) {
					oe.setImgStatus(ecarFileSystem.getImageFromContext("branco.gif"));
					oe.setSignificadoCor("Não Monitorado");
				}else {
					oe.setImgStatus(ecarFileSystem.getImageFromContext(oe.getNomeCor().toLowerCase() + ".gif"));
				}
				
				List<IettDto> inicis;
				
				switch (tipoRelatorio) {
				case EXECUTIVO:
					inicis = relatorioDao.listItens(filtro);
					break;
				case GERENCIAL:
					inicis = relatorioDao.listItensCiclo(filtro);
					break;
				default:
					inicis = new ArrayList<IettDto>();
					break;
				}
				
				oe.setDescendentes(inicis);
				
				for (IettDto ini : inicis) {
					if(ini.getNomeCor() == null) {
						ini.setImgStatus(ecarFileSystem.getImageFromContext("branco.gif"));
						ini.setSignificadoCor("Não Monitorado");
					}else {
						ini.setImgStatus(ecarFileSystem.getImageFromContext(ini.getNomeCor().toLowerCase() + ".gif"));
					}
				}
				
				if(tipoRelatorio.equals(TipoRelatorio.GERENCIAL)) {
					List<IndicadorDto> inds = relatorioDao.listIndicadoresIett(oe.getId());
					
					oe.setIndicadores(inds);
				}
			}
		}
		return eixos;
	}
}