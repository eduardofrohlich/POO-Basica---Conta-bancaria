package conta;
public class ContaC {
    public int numeroConta;
    protected String tipo;
    private String dono;
    private float saldo;
    private boolean status;

    public ContaC(int n, String d, String t) {
        this.numeroConta = n;
        this.dono = d;
        this.tipo = t;
        this.setSaldo(0);
        this.setStatus(false);
    }
 
    public int getNumeroConta() {
        return numeroConta;
    }

    public String getTipo() {
        return tipo;
    }

    public String getDono() {
        return dono;
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
    
    public void abrirConta(){
        this.setStatus(true);
        if ("CC".equals(tipo)){
            this.setSaldo(50);
        } else if ("CP".equals(tipo)){
            this.setSaldo(150);          
        }
        System.out.println("CONTA ABERTA COM SUCESSO!");
    }
    
    public void fecharConta(){
        if (this.getSaldo()==0){
            this.setStatus(false);
            System.out.println("CONTA FECHADA COM SUCESSO!");
        } else if(this.getSaldo()<0){
            System.out.println("\nErro! Conta possui saldo negativo!");
        } else{
            System.out.println("Erro! A conta ainda possui saldo!");
        } 
    }
    
    public void depositar(float dep){
        if (this.isStatus() == true){
             this.setSaldo(this.getSaldo() + dep);
             System.out.println("DEPÓSITO DE R$"+dep+" EFETUADO COM SUCESSO NA CONTA DE "+this.getDono());
        } else{
            System.out.println("ERRO!! CONTA FECHADA!");
        }
    }
    
    public void sacar(float saque){
        if (this.isStatus()){
            if (saque<=this.getSaldo()){
                this.setSaldo(this.getSaldo()-saque);
                System.out.println("SAQUE DE R$"+saque+" EFETUADO COM SUCESSO NA CONTA DE "+this.getDono());
            } else {
                System.out.println("ERRO! Voce nao possui saldo suficiente para efetuar o saque.");
            }

        } else {
            System.out.println("CONTA FECHADA! IMPOSSÍVEL SACAR");
        }
    }
    
    public void pagarMensal(){
        int valor = 0;
        if(this.getTipo().equals("CC")){
            valor = 12;
        } else if(this.getTipo().equals("CP")){
            valor = 20;
        }
        if (this.isStatus()==true){
            if(this.getSaldo() > valor){
                this.setSaldo(this.getSaldo()-valor);
                System.out.println("MENSALIDADE DE R$ "+valor+".00 PAGA POR "+this.getDono());
            } else {
                System.out.println("SALDO INSUFICIENTE");
            }
            
        } else {
            System.out.println("ERRO! CONTA FECHADA");
        }
    }

    @Override
    public String toString() {
        return """
               ---------------------------
               ContaC{
               NUMERO DA CONTA=""" + numeroConta + "\nTIPO=" + tipo + "\nDONO=" + dono + "\nSALDO= R$" + saldo +  "\nESTADO=" + status + '}';
    }
}