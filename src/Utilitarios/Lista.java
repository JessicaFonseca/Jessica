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
    public List<Produto> preencherLista(ResultSet rs){
        List<Produto> ls = new ArrayList<Produto>();
        try {
            rs.beforeFirst();
            while(rs.next()){
                Produto produto = new Produto(rs.getString("nome"), rs.getDouble("preço"));
                produto.setquantidade(rs.getInt("quantidade"));
                ls.add(produto);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Lista.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ls;
    }
}
