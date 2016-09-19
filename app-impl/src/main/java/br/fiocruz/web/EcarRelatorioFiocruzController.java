package br.fiocruz.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.fiocruz.exc.AkulaRuntimeException;
import br.fiocruz.model.Nivel;
import br.fiocruz.servico.RelatorioService;
import br.fiocruz.servico.dto.CicloDto;
import br.fiocruz.servico.dto.FiltroDto;

@Controller
@CrossOrigin(value="*", maxAge=3600)
@RequestMapping(value="/ecar/api")
public class EcarRelatorioFiocruzController {
	
	private static final Logger logger = LoggerFactory.getLogger(EcarRelatorioFiocruzController.class);
	
	@Autowired
	private RelatorioService relatorioService;
	
	@RequestMapping(value="/lista-ciclos", 
			method=RequestMethod.POST)
	@ResponseBody
	public List<CicloDto> listCiclos() {
		try {
			logger.debug("Emitindo lista de ciclos...");
			List<CicloDto> ciclos = relatorioService.listCiclos();
			
			return ciclos;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return null;
		}
	}
	
	@RequestMapping(value="/download-rel-gerencial", 
			method=RequestMethod.POST)
	public void downloadRelatorioGerencial(HttpServletResponse response, @RequestBody FiltroDto filtro) {
		
	    try {
	    	logger.debug("Gerando relatorio gerencial...");
	    	filtro.setNivel(Nivel.EIXO);
	    	byte[] data = relatorioService.gerarRelatorioGerencial(filtro);
			
			response.setContentType("application/pdf");
			response.setHeader("Content-disposition", "attachment; filename=relatorioGerencial.pdf");
		    response.setContentLength(data.length);
		    
			response.getOutputStream().write(data);
			response.getOutputStream().flush();
			response.getOutputStream().close();
		} catch (IOException e) {
			logger.error(e.getMessage(), e);
		} catch (AkulaRuntimeException e) {
			logger.error(e.getMessage(), e);
		}
	}
	
	@RequestMapping(value="/download-rel-executivo", 
			method=RequestMethod.POST)
	public void downloadRelatorioExecutivo(HttpServletResponse response) {
		
	    try {
	    	FiltroDto filtro = new FiltroDto();
	    	filtro.setNivel(Nivel.EIXO);
	    	byte[] data = relatorioService.gerarRelatorioExecutivo(filtro);
			
			response.setContentType("application/pdf");
			response.setHeader("Content-disposition", "attachment; filename=relatorioExecutivo.pdf");
		    response.setContentLength(data.length);
		    
			response.getOutputStream().write(data);
			response.getOutputStream().flush();
			response.getOutputStream().close();
		} catch (IOException e) {
			logger.error(e.getMessage(), e);
		} catch (AkulaRuntimeException e) {
			logger.error(e.getMessage(), e);
		}
	}
}