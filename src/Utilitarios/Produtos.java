/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilitarios;

/**
 *
 * @author Jéssica
 */
public class Produtos {
    private String nome;
    private int quantidade;
    private double preço;
    
    public String getnome(){
        return nome;
    }
    public void setnome(String nome){
        this.nome=nome;
    }
    public int getquantidade(){
        return quantidade;
    }
    public void setquantidade(int quantidade){
        this.quantidade=quantidade;
    }
    public double getpreço(){
        return preço;
    }
    public void setpreço(double preço){
        this.preço=preço;
    }
}
