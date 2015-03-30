/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilitarios;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jéssica
 */
public class Lista {
    public List preencherLista(ResultSet rs){
        List ls = new ArrayList();
        try {
            rs.beforeFirst();
            while(rs.next()){
                Produtos produto = new Produtos();
                produto.setnome(rs.getString("nome"));
                produto.setquantidade(rs.getInt("quantidade"));
                produto.setpreço(rs.getDouble("preço"));
                ls.add(produto);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Lista.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ls;
    }
}
