/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author aluno
 */
public class Servidores {
    
           String nome;
           private String cpf;
           private double salário;
           private String rg;
            public String getNome() {
               return nome; 
            }
           public void setNome(String nome){
               this.nome= nome;
           }
           public void setCPF(String cpf){
               this.nome= cpf;
           }
           public double getSalario(){
               return salário;
           } 
           public void setRg(String rg){
               this.nome= rg;
           }
           public void setSalario(double salario) {
        this.salário = salario;
    }
     
    public double calcularBonus(){
        return this.salário * 0.5;
    }
}
 


        
    
    

