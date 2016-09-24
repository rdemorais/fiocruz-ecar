package br.fiocruz.servico;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import br.fiocruz.exc.AkulaRuntimeException;
import br.fiocruz.servico.dto.CicloDto;
import br.fiocruz.servico.dto.FiltroDto;
import br.fiocruz.servico.dto.IettDto;

public interface RelatorioService {
	public void configResponseReport(HttpServletResponse response, byte[] data) throws IOException, AkulaRuntimeException;
	public List<IettDto> listEixos() throws AkulaRuntimeException;
	public List<CicloDto> listCiclos() throws AkulaRuntimeException;
	public byte[] gerarRelatorioGerencial(FiltroDto filtro) throws AkulaRuntimeException;
	public byte[] gerarRelatorioExecutivo(FiltroDto filtro) throws AkulaRuntimeException;
}