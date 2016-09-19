package br.fiocruz.report;

import java.util.List;
import java.util.Map;

import br.fiocruz.exc.AkulaServiceRuntimeException;

public interface EcarReport {
	public byte[] generateReportPDF(String reportName, List<Object> conteudo) throws AkulaServiceRuntimeException;
	public byte[] generateReportPDF(String reportName, Map<String, Object> parametros, List<Object> conteudo) throws AkulaServiceRuntimeException;
}