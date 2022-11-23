package conta;

public class Conta {
    public static void main(String[] args) {
        ContaC c1 = new ContaC(1111, "Eduardo", "CC");
        c1.abrirConta();
        c1.depositar(100);
        c1.sacar(150);
        
        
        ContaC c2 = new ContaC(2222, "Vinicius", "CP");
        c2.abrirConta();
        c2.depositar(200);
        c2.sacar(350);
        
        c1.fecharConta();
        c2.fecharConta();
        
        System.out.println(c1 +"\n");
        System.out.println(c2);
    }
}