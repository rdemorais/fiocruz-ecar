package br.fiocruz.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.fiocruz.model.Nivel;
import br.fiocruz.servico.RelatorioService;
import br.fiocruz.servico.dto.FiltroDto;

@ContextConfiguration("/META-INF/peFiocruz-app-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class RelatorioServiceTest {
	
	private static final Logger logger = LoggerFactory.getLogger(RelatorioServiceTest.class);
	
	@Autowired
	private RelatorioService relatorioService;
	
	@Test
	public void gerarReportGerencialTest() throws IOException {
		logger.debug("Gerando relatorio gerencial...");
		
		FiltroDto filtro = new FiltroDto();
		filtro.setNivel(Nivel.EIXO);
		filtro.setCodAref(11l);
		
		byte[] bytes = relatorioService.gerarRelatorioGerencial(filtro);
		
		File reportFile = new File("/Users/rafaeldemorais/ecar-fiocruz-gerencial.pdf");
		reportFile.createNewFile();
		
		FileOutputStream stream = new FileOutputStream(reportFile);
		stream.write(bytes);
		stream.flush();
        stream.close();
	}
	
	//@Test
	public void gerarReportExecutivoTest() throws IOException {
		logger.debug("Gerando relatorio executivo...");
		
		FiltroDto filtro = new FiltroDto();
		filtro.setNivel(Nivel.EIXO);
		
		byte[] bytes = relatorioService.gerarRelatorioExecutivo(filtro);
		
		File reportFile = new File("/Users/rafaeldemorais/ecar-fiocruz-Executivo.pdf");
		reportFile.createNewFile();
		
		FileOutputStream stream = new FileOutputStream(reportFile);
		stream.write(bytes);
		stream.flush();
        stream.close();
	}
	
}