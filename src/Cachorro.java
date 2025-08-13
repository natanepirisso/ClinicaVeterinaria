public class Cachorro extends Animal{
    public Cachorro(String nome, int idade, String race, double peso){
        super(nome,idade,race,peso);
    }
    @Override
    public String toString(){
        return "Nome do Cachorro: "+ getNome() + " | Idade: "+ getIdade() + " | Peso do Cachorro: "+ getPeso()+"kg"+ " | Raça: "+ getRace();
    }
}
