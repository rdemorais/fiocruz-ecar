package br.fiocruz.dao;

import java.util.List;

import br.fiocruz.exc.AkulaRuntimeException;
import br.fiocruz.servico.dto.CicloDto;
import br.fiocruz.servico.dto.FiltroDto;
import br.fiocruz.servico.dto.IettDto;
import br.fiocruz.servico.dto.IndicadorDto;
import br.fiocruz.servico.dto.OEDto;

public interface RelatorioDao extends Dao{
	public List<CicloDto> listCiclos() throws AkulaRuntimeException;
	public List<IndicadorDto> listIndicadoresIett(Long codIett) throws AkulaRuntimeException;
	public List<IettDto> listItensCiclo(FiltroDto filtro) throws AkulaRuntimeException;
	public List<IettDto> listItens(FiltroDto filtro) throws AkulaRuntimeException;
	public List<OEDto> listaOEs() throws AkulaRuntimeException;
}