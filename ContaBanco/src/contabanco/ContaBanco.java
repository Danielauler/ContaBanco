package contabanco;

import java.util.Scanner;

public class ContaBanco {
    public int numConta;
    protected String tipo;
    private String dono;
    private float saldo;
    private boolean status;
    
    Scanner s = new Scanner(System.in);
    public void estadoAtual(){
        System.out.println("-------------------------------------");
        System.out.println("Conta: "+this.getNumConta());
        System.out.println("Tipo: "+this.getTipo());
        System.out.println("Dono: "+this.getDono());
        System.out.println("Saldo: "+this.getSaldo());
        System.out.println("Status: "+this.isStatus());
    }

    public ContaBanco() {
        this.saldo = 0;
        this.status = false;
        
    }

    public int getNumConta() {
        return numConta;
    }

    public void setNumConta(int numConta) {
        this.numConta = numConta;
    }
    

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDono() {
        return dono;
    }

    public void setDono(String dono) {
        this.dono = dono;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
    public void abrirConta(String t){
        this.setTipo(t);
        if(t=="cc"){
            this.setSaldo(50f);
            System.out.println("Conta aberta com sucesso!");
            this.setStatus(true);
        }else if(t=="cp"){
            this.setSaldo(150f);
            System.out.println("Conta aberta com sucesso!");
            this.setStatus(true);
        }else{
            System.out.println("ERRO, tipo de conta inválido");
        }
        
    }
    
    public void fecharConta(){
        
        if(this.getSaldo()>0){
            System.out.println("ERRO, seu saldo não está zerado, saque "+this.getSaldo()+" reais");
        }else if(this.getSaldo()<0){
            System.out.println("ERRO, seu saldo está negativo em "+this.getSaldo()+" reais");
        }else{
            this.setStatus(false);
            System.out.println("Conta Fechada com Sucesso");
        }
        
    }
    
    public void depositar(float v){
        if(this.isStatus()==true){
            this.setSaldo(this.getSaldo()+v);
            System.out.println("Depósito realizado na conta de "+this.dono);
        }else{
            System.out.println("ERRO, Impossível depositar, a conta está fechada");
        }
    }
    
    public void sacar(float v){
        if(this.isStatus()==true){
            if(this.getSaldo()>=v){
                this.setSaldo(this.getSaldo() - v);
                System.out.println("Saque realizado na conta de "+this.dono);
            }else{
                System.out.println("ERRO, saldo insuficiente");
            }
        }else{
            System.out.println("ERRO, conta fechada");
        }
    }
    
    public void pagarMensal(){
        int v = 0;
        if(this.getTipo()=="cc"){
            v = 12;
        }else if(this.getTipo() == "cp"){
            v = 20;
        }
        if(this.isStatus()==true){
            if(this.getSaldo()>v){
                this.setSaldo(this.getSaldo()-v);
                System.out.println("Mensalidade paga com sucesso!");
            }else{
                System.out.println("ERRO, saldo insuficiente");
            }
        }else{
            System.out.println("ERRO, conta inexistente");
        }
    }
}
