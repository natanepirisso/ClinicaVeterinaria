public class Gato extends Animal{
    public Gato(String nome, int idade, String race, double peso){
        super(nome,idade,race,peso);
    }

    @Override
    public String toString(){
        return "Nome do Gato: "+ getNome() + " | Idade: "+ getIdade() + " | Peso do Gato: "+ getPeso()+"kg"+ " | Raça: "+ getRace();
    }
}
