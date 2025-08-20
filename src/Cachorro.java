import enums.Sexo;

public class Cachorro extends Animal{
    public Cachorro(String nome, int idade, String race, double peso, Sexo sexo){
        super(nome,idade,race,peso,sexo);

    }
    @Override
    public String toString(){
        return "Nome do Cachorro: "+ getNome() + " | Idade: "+ getIdade() + " | Peso do Cachorro: "+ getPeso()+"kg"+ " | Raça: "+ getRace() + " | Sexo: "+ getSexo() + " | ID: "+ getId();
    }
}
