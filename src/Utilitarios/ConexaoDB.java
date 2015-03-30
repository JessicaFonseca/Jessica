package Utilitarios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ConexaoDB {
    public PreparedStatement pst = null;
    private String caminho="jdbc:derby://localhost:1527/Dados";
    private String user="Jessica";
    private String pass="123";
    private String driver="org.apache.derby.jdbc.EmbeddedDriver";
    public Statement st;
    public ResultSet rs;
    public Connection cn;
    
    public void coneta (){
        try {
            System.setProperty("jdbc.Driver",driver);
            cn=DriverManager.getConnection(caminho, user, pass);
            JOptionPane.showMessageDialog(null,"Conectado com sucesso");
        } catch (SQLException ex) {
            Logger.getLogger(ConexaoDB.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao conetar: "+ex);
        }
    }
    public void desconeta (){
        try {
            cn.close();
            JOptionPane.showMessageDialog(null, "Conexão fechado com sucesso");
        } catch (SQLException ex) {
            Logger.getLogger(ConexaoDB.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao fechar a conexão: "+ex);
        }
    }
    public void update(String query){
        try {
            st = cn.createStatement();
            st.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(ConexaoDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ResultSet consultaDB(){
        try {
            String query="select * from Jessica.Dados where nome=?";
            st=cn.createStatement();
            rs=st.executeQuery(query);
        } catch (SQLException ex) {
            Logger.getLogger(ConexaoDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    public ResultSet consulta(String query){
        try {
            st = cn.createStatement();
            rs=st.executeQuery(query);
        } catch (SQLException ex) {
            Logger.getLogger(ConexaoDB.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao consultar: "+ex);
        }
        return rs;
    }

public ResultSet VerificaLogin (String nome, String password){
        try {
            String query="select * from Jessica.Login where nome=? and password=?";
            pst=cn.prepareStatement (query);
            pst.setString (1, nome);
            pst.setString (2, password);
            rs=pst.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(ConexaoDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
}

public ResultSet ExportarFactura(String nome, int quantidade, double preco){
        
        try {
            String query = "select * from Jessica.Produtos where nome=? ,quantidade=? and preco=?";
            pst=cn.prepareStatement(query,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
            pst.setString(1, nome);
            pst.setInt(2, quantidade);
            pst.setDouble(2, preco);
            rs=pst.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(ConexaoDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
}