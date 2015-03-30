/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilitarios;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 *
 * @author Jéssica
 */
public class ExportarFactura {
     public void exportar(String caminhoRelatorio,String caminhoFactura,List lista){
        try {
            JasperReport report = JasperCompileManager .compileReport(caminhoRelatorio);
            JasperPrint print = JasperFillManager.fillReport(report,null, new JRBeanCollectionDataSource(lista));
            JasperExportManager.exportReportToPdfFile(print,caminhoFactura);
        } catch (JRException ex) {
            Logger.getLogger(ExportarFactura.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
