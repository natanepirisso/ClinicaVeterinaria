import InputExceptions.InputValidators;
import InputExceptions.NotANumberException;
import InputExceptions.NotAStringException;
import InputExceptions.NotAZeroOrMinorException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ClinicaLista {
    private List<Animal> lista;
    private Scanner sc;
    public ClinicaLista(){
        this.lista = new ArrayList<>(); this.sc = new Scanner(System.in);
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
    public void addAnimal(){
        while (true){
            try {
                System.out.println("Digite o nome do Animal");
                String nomeAnimal = sc.next();
                InputValidators.notString(nomeAnimal);
                System.out.println("Digite a idade do Animal");
                String idadeStr = sc.next();
                InputValidators.notANumber(idadeStr);
                int idadeReal = Integer.parseInt(idadeStr);
                InputValidators.notAZeroOrMinor(idadeReal);
                System.out.println("Digite a raça do Animal");
                String animalRace = sc.next();
                InputValidators.notString(animalRace);
                System.out.println("Digite o peso do animal");
                String pesoParcial = sc.next();
                InputValidators.notANumber(pesoParcial);
                double pesoReal = Double.parseDouble(pesoParcial);
                InputValidators.notAZeroOrMinor(pesoReal);
                while(true){
                    System.out.println("Qual o tipo de animal?\n");
                    System.out.println("1: Gato");
                    System.out.println("2: Cachorro");
                    int escolha = sc.nextInt();
                    if (escolha == 1){
                        Animal gato = new Gato(nomeAnimal,idadeReal,animalRace,pesoReal);
                        lista.add(gato);
                        break;
                    } else if (escolha == 2) {
                        Animal cachorro = new Cachorro(nomeAnimal,idadeReal,animalRace,pesoReal);
                        lista.add(cachorro);
                        break;
                    }
                    else{
                        System.out.println("Número incorreto. Tente novamente");
                    }
                }
            break;

            }catch (NotAStringException | NotANumberException | NotAZeroOrMinorException e){
                System.out.println(e.getMessage());
            };
        }
    }
}
