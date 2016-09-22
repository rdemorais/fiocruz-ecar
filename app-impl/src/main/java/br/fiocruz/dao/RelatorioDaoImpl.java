package br.fiocruz.dao;

import java.util.List;

import javax.persistence.Query;

import br.fiocruz.exc.AkulaDaoRuntimeException;
import br.fiocruz.exc.AkulaRuntimeException;
import br.fiocruz.model.Nivel;
import br.fiocruz.servico.dto.CicloDto;
import br.fiocruz.servico.dto.FiltroDto;
import br.fiocruz.servico.dto.IettDto;
import br.fiocruz.servico.dto.IndicadorDto;
import br.fiocruz.servico.dto.OEDto;

public class RelatorioDaoImpl extends DaoImpl implements RelatorioDao{
	
	@SuppressWarnings("unchecked")
	public List<CicloDto> listCiclos() throws AkulaRuntimeException {
		try {
			StringBuffer hql = new StringBuffer();
			hql.append("SELECT new br.fiocruz.servico.dto.CicloDto( ");
			hql.append("aref.id, ");
			hql.append("aref.nome) ");
			hql.append("FROM AcompReferenciaAref aref ");
			hql.append("ORDER BY aref.ano, aref.mes ");
			
			Query q = em.createQuery(hql.toString());
			
			return q.getResultList();
		} catch (Exception e) {
			throw new AkulaDaoRuntimeException(e.getMessage(), e);
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<IndicadorDto> listIndicadoresIett(Long codIett) throws AkulaRuntimeException {
		try {
			StringBuffer hql = new StringBuffer();
			hql.append("SELECT new br.fiocruz.servico.dto.IndicadorDto( ");
			hql.append("ind.nome) ");
			hql.append("FROM IettIndicador ind ");
			hql.append("WHERE ind.ativo = 'S' ");
			hql.append("AND ind.iett.id = :codIett ");
			hql.append("ORDER BY ind.nome ");
			Query q = em.createQuery(hql.toString());
			q.setParameter("codIett", codIett);
			return q.getResultList();
		} catch (Exception e) {
			throw new AkulaDaoRuntimeException(e.getMessage(), e);
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<IettDto> listItensCiclo(FiltroDto filtro) throws AkulaRuntimeException {
		try {
			StringBuffer hql = new StringBuffer();
			hql.append("SELECT new br.fiocruz.servico.dto.IettDto(");
			hql.append("iett.id, ");
			hql.append("iett.sigla, ");
			hql.append("iett.nome, ");
			hql.append("resp.nome, ");
			hql.append("resp.email, ");
			hql.append("cor.significado, ");
			hql.append("cor.nome, ");
			hql.append("sit.descricao, ");
			hql.append("arel.parecer) ");
			hql.append("FROM AcompReferenciaItemAri ari ");
			hql.append("JOIN ari.iett iett ");
			hql.append("LEFT JOIN ari.pareceres arel ");
			hql.append("LEFT JOIN arel.cor cor ");
			hql.append("LEFT JOIN arel.situacao sit ");
			hql.append("LEFT JOIN ari.aref aref ");
			hql.append("LEFT JOIN iett.usuarios ususIett ");
			hql.append("LEFT JOIN ususIett.usuarioEcar resp ");
			hql.append("WHERE iett.nivel = :nv ");
			hql.append("AND iett.ativo = 'S' ");
			hql.append("AND aref.id = :codAref ");
			if(filtro.getNivel() != Nivel.EIXO) {
				hql.append("AND iett.iettPai.id = :idPai ");
			}
			hql.append("ORDER BY iett.sigla, iett.nome");
			
			Query q = em.createQuery(hql.toString());
			q.setParameter("nv", filtro.getNivel().getNv());
			q.setParameter("codAref", filtro.getCodAref());
			
			if(filtro.getNivel() != Nivel.EIXO) {
				q.setParameter("idPai", filtro.getCodIettPai());
			}
			
			return q.getResultList();
		} catch (Exception e) {
			throw new AkulaDaoRuntimeException(e.getMessage(), e);
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<IettDto> listItens(FiltroDto filtro) throws AkulaRuntimeException {
		try {
			StringBuffer hql = new StringBuffer();
			
			hql.append("SELECT new br.fiocruz.servico.dto.IettDto(");
			hql.append("iett.id, ");
			hql.append("iett.sigla, ");
			hql.append("iett.nome, ");
			hql.append("resp.nome, ");
			hql.append("resp.email) ");
			hql.append("FROM Iett iett ");
			hql.append("JOIN iett.usuarios ususIett ");
			hql.append("LEFT JOIN ususIett.usuarioEcar resp ");
			hql.append("WHERE iett.nivel = :nv ");
			hql.append("AND iett.ativo = 'S' ");
			if(filtro.getNivel() != Nivel.EIXO) {
				hql.append("AND iett.iettPai.id = :idPai ");
			}
			hql.append("ORDER BY iett.sigla, iett.nome");
			
			Query q = em.createQuery(hql.toString());
			q.setParameter("nv", filtro.getNivel().getNv());
			if(filtro.getNivel() != Nivel.EIXO) {
				q.setParameter("idPai", filtro.getCodIettPai());
			}
			
			return q.getResultList();
		} catch (Exception e) {
			throw new AkulaDaoRuntimeException(e.getMessage(), e);
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<IettDto> listaEixos() throws AkulaRuntimeException {
		try {
			StringBuffer hql = new StringBuffer();
			
			hql.append("SELECT new br.fiocruz.servico.dto.OEDto(");
			hql.append("eixo.id, ");
			hql.append("eixo.sigla, ");
			hql.append("eixo.nome) ");
			hql.append("FROM Iett eixo ");
			hql.append("WHERE eixo.nivel = :nv ");
			hql.append("AND eixo.ativo = 'S' ");
			
			Query q = em.createQuery(hql.toString());
			
			q.setParameter("nv", Nivel.EIXO.getNv());
			
			return q.getResultList();
		} catch (Exception e) {
			throw new AkulaDaoRuntimeException(e.getMessage(), e);
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<OEDto> listaOEs() throws AkulaRuntimeException {
		try {
			StringBuffer hql = new StringBuffer();
			
			hql.append("SELECT new br.fiocruz.servico.dto.OEDto(");
			hql.append("eixo.id, ");
			hql.append("eixo.sigla, ");
			hql.append("oe.id, ");
			hql.append("oe.sigla, ");
			hql.append("oe.nome) ");
			hql.append("FROM OE oe ");
			hql.append("JOIN oe.eixo eixo ");
			hql.append("WHERE oe.nivel = 2 ");
			hql.append("AND eixo.nivel = 1 ");
			
			Query q = em.createQuery(hql.toString());
			
			return q.getResultList();
		} catch (Exception e) {
			throw new AkulaDaoRuntimeException(e.getMessage(), e);
		}
	}
}