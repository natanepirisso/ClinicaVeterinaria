import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ClinicaLista<Animal> {
    private List<Animal> lista;
    private Scanner sc = new Scanner(System.in);
    public ClinicaLista(){
        this.lista = new ArrayList<>();
    }
    public void run(){
        int opt;
        do {
            System.out.println("Bem vindo.\n");
            System.out.println("1: Adicionar Animal");
            System.out.println("2: Atualizar Cadastro");
            System.out.println("3: Excluir Animal");
            System.out.println("4: Mostrar Lista");
            System.out.println("0: Encerrar.");
            switch (opt){
                case 1:
                    addAnimal();
                    break;
                case 2:
                    attCadastro();
                    break;
                case 3:
                    delAnimal();
                    break;
                case 4:
                    showList();
                    break;
            }

        }while (opt != 0);{
            System.out.println("Sistema encerrado.");
            sc.close();
        }
    }
}
