import enums.Sexo;

public class Gato extends Animal{
    public Gato(String nome, int idade, String race, double peso, Sexo sexo){
        super(nome,idade,race,peso,sexo);
    }

    @Override
    public String toString(){
        return "Nome do Gato: "+ getNome() + " | Idade: "+ getIdade() + " | Peso do Gato: "+ getPeso()+"kg"+ " | Raça: "+ getRace() + " | Sexo: "+ getSexo() + " | ID: " + getId();
    }
}
