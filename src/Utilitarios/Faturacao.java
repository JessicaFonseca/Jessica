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
public class Faturacao {
    private String nf;
    private String nome;
    private String morada;
    private String contribuinte;
    private String produto;
    private int quantidade;
    private double preço;
    
    public String getnf(){
        return nf;
    }
    public void setnf(String nf){
        this.nf=nf;
    }
    public String getnome(){
        return nome;
    }
    public void setnome(String nome){
        this.nome=nome;
    }
    public String getmorada(){
        return morada;
    }
    public void setmorada(String morada){
        this.morada=morada;
    }
    public String getcontribuinte(){
        return contribuinte;
    }
    public void setcontribuinte(String contribuinte){
        this.contribuinte=contribuinte;
    }
    public String getproduto(){
        return produto;
    }
    public void setproduto(String produto){
        this.produto=produto;
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