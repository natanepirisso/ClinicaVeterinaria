import InputExceptions.InputValidators;
import InputExceptions.NotANumberException;
import InputExceptions.NotAStringException;
import InputExceptions.NotAZeroOrMinorException;
import enums.Sexo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class ClinicaLista {
    private final List<Animal> lista;
    private final Scanner sc;
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
            opt = sc.nextInt();
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
    private void addAnimal(){
        while (true){
            try {
                System.out.println("Digite o nome do Animal");
                sc.nextLine();
                String nomeAnimal = sc.nextLine();
                InputValidators.notString(nomeAnimal);
                System.out.println("Digite a idade do Animal");
                String idadeStr = sc.next();
                sc.nextLine();
                InputValidators.notANumber(idadeStr);
                int idadeReal = Integer.parseInt(idadeStr);
                InputValidators.notAZeroOrMinor(idadeReal);
                System.out.println("Digite a raça do Animal");
                String animalRace = sc.nextLine();
                InputValidators.notString(animalRace);
                System.out.println("Digite o peso do animal");
                String pesoParcial = sc.next();
                sc.nextLine();
                InputValidators.notANumber(pesoParcial);
                double pesoReal = Double.parseDouble(pesoParcial);
                InputValidators.notAZeroOrMinor(pesoReal);
                System.out.println("Qual o sexo do animal? (F) para Feminino e (M) para Masculino.");
                String sexoEscolhido = sc.next();
                sc.nextLine();
                InputValidators.notString(sexoEscolhido);
                Sexo getSexo = sexoDoAnimal(sexoEscolhido);

                while(true){
                    System.out.println("Qual o tipo de animal?\n");
                    System.out.println("1: Gato");
                    System.out.println("2: Cachorro");
                    int escolha = sc.nextInt();
                    if (escolha == 1){
                        Animal gato = new Gato(nomeAnimal,idadeReal,animalRace,pesoReal,getSexo);
                        lista.add(gato);
                        break;
                    } else if (escolha == 2) {
                        Animal cachorro = new Cachorro(nomeAnimal,idadeReal,animalRace,pesoReal, getSexo);
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
            }
        }
    }
    // Mét0do para atualizar algum animal
    private void attCadastro(){
        System.out.println("Digite o ID do animal que quer atualizar o cadastro");
        String animalOpt = sc.next();
        Animal animal = animalFinder(animalOpt);
        if(animal == null){
            System.out.println("Animal não encontrado. Voltando para o menu principal....\n");
            return;
        }
        int opt;
        do {
            System.out.println("\nO que você gostaria de atualizar? \n");
            System.out.println("1: Nome");
            System.out.println("2: Idade");
            System.out.println("3: Raça");
            System.out.println("4: Peso");
            System.out.println("5: Sexo");
            System.out.println("0: Encerrar");
            opt = sc.nextInt();
            switch (opt){
                case 1:
                    while (true){
                        try{
                            System.out.println("Digite o novo nome do animal: ");
                            String novoNome = sc.next();
                            InputValidators.notString(novoNome);
                            animal.setNome(novoNome);
                            System.out.println("Nome atualizado para: "+ animal.getNome());
                            break;
                        }catch (NotAStringException | NotANumberException | NotAZeroOrMinorException e){
                            System.out.println(e.getMessage());
                        }
                    }
                    break;
                case 2:
                    while (true){
                        try {
                            System.out.println("Digite a idade do animal: ");
                            String novaIdadeParcial = sc.next();
                            InputValidators.notANumber(novaIdadeParcial);
                            int novaIdade = Integer.parseInt(novaIdadeParcial);
                            InputValidators.notAZeroOrMinor(novaIdade);
                            animal.setIdade(novaIdade);
                            System.out.println("Idade atualizada para: "+ animal.getIdade());
                            break;
                        }catch (NotAStringException | NotANumberException | NotAZeroOrMinorException e){
                            System.out.println(e.getMessage());
                        }
                    }
                case 3:
                    while (true){
                        try{
                            System.out.println("Digite a raça do animal: ");
                            sc.nextLine();
                            String newRace = sc.nextLine();
                            InputValidators.notString(newRace);
                            animal.setRace(newRace);
                            System.out.println("Raça atualizada para: " + animal.getRace());
                            break;
                        }catch (NotAStringException | NotANumberException | NotAZeroOrMinorException e){
                            System.out.println(e.getMessage());}
                    }
                    break;
                case 4:
                    while (true){
                        try {
                            System.out.println("Digite o peso do animal: ");
                            String novoPesoParcial = sc.next();
                            InputValidators.notANumber(novoPesoParcial);
                            double novoPeso = Double.parseDouble(novoPesoParcial);
                            InputValidators.notAZeroOrMinor(novoPeso);
                            animal.setPeso(novoPeso);
                            System.out.println("Peso atualizado para: "+ animal.getPeso());
                            break;
                        }catch (NotAStringException | NotANumberException | NotAZeroOrMinorException e){
                            System.out.println(e.getMessage());}
                    }
                    break;
                case 5:
                    while(true){
                        try{
                            System.out.println("Digite o Sexo do animal. (F) para Feminino e (M) para Masculino");
                            String novoSexo = sc.next();
                            InputValidators.notString(novoSexo);
                            Sexo sexoAtualizado = sexoDoAnimal(novoSexo);
                            animal.setSexo(sexoAtualizado);
                            break;
                        }catch (NotAStringException e){
                            System.out.println(e.getMessage());
                        }
                    }
                    break;
                case 0 :
                    System.out.println("Voltando para o menu principal...\n");
                    break;
                default :
                    System.out.println("Opção invalida.");
            }
        }while(opt != 0);

    }
    // Excluir Animal
    private void delAnimal(){
        System.out.println("\nDigite o ID do animal que deseja excluir: ");
        String animalID = sc.next();
        Animal animalEncontrado = animalFinder(animalID);
        if(animalEncontrado == null){
            System.out.println("Animal não encontrado. Voltando para o menu principal...");
            return;
        }
        while(true){
        System.out.println(animalEncontrado.getNome() + " foi encontrado. Deseja mesmo exclui-lo?\n");
        System.out.println("Sim (Y)");
        System.out.println("Não (N)");
        String escolha = sc.next();
            if (Objects.equals(escolha, "y")){
                lista.remove(animalEncontrado);
                System.out.println("Animal excluido da lista com sucesso.");
                break;
            } else if (Objects.equals(escolha, "n")) {
                System.out.println("Exclusão cancelada...");
                break;
            }
            else{
                System.out.println("Algo deu errado. Tente novamente.");
            }
        }
    }
    // Printa a lista de animais
    private void showList(){
        while (true){
            System.out.println("Quais animais você quer que seja listado?");
            System.out.println("1: somente gatos.");
            System.out.println("2: somente cachorros.");
            System.out.println("3: todos os animais.");
            int opt = sc.nextInt();
            if(opt == 1){
                lista.stream().filter(a -> a instanceof Gato).forEach(System.out::println);
                break;
            } else if (opt == 2) {
                lista.stream()
                        .filter(a -> a instanceof Cachorro)
                        .forEach(System.out::println);
                break;
            } else if (opt == 3) {
                lista.forEach(System.out::println);
                break;
            }
            else {
                System.out.println("Digito errado. Tente novamente");
            }
        }
    }
    //Função auxiliar. Serve para auxiliar o mét0do attCadastro
    private Animal animalFinder(String animalID){
        return lista.stream().filter(a -> a.getId().equalsIgnoreCase(animalID)).findFirst().orElse(null);
    }
    private Sexo sexoDoAnimal(String sexo){
        Sexo sexoEscolhido;
        if (Objects.equals(sexo, "m")){
            sexoEscolhido = Sexo.Masculino;
        } else if (Objects.equals(sexo,"f")) {
            sexoEscolhido = Sexo.Feminino;
        }
        else{
            sexoEscolhido = Sexo.Indefinido;
        }
        return sexoEscolhido;
    }
}
