package br.fiocruz.servico;

import java.util.List;

import br.fiocruz.exc.AkulaRuntimeException;
import br.fiocruz.servico.dto.CicloDto;
import br.fiocruz.servico.dto.FiltroDto;

public interface RelatorioService {
	public List<CicloDto> listCiclos() throws AkulaRuntimeException;
	public byte[] gerarRelatorioGerencial(FiltroDto filtro) throws AkulaRuntimeException;
	public byte[] gerarRelatorioExecutivo(FiltroDto filtro) throws AkulaRuntimeException;
}