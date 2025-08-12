public abstract class Animal {
    private String nome;
    private int idade;
    private String race;
    private double peso;

    protected Animal(String nome, int idade, String race, double peso){
        this.nome = nome;
        this.idade = idade;
        this.race = race;
        this.peso = peso;

    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public String getRace() {
        return race;
    }

    public double getPeso() {
        return peso;
    }
}
