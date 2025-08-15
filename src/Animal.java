public abstract class Animal {
    private String nome;
    private int idade;
    private String race;
    private double peso;
    private final String id;

    private static int contador = 1;

    protected Animal(String nome, int idade, String race, double peso){
        this.nome = nome;
        this.idade = idade;
        this.race = race;
        this.peso = peso;
        this.id = gerarId();
    }
    private String gerarId(){
        return String.format("AN-%03d", contador++);
    }

    public String getId() {return id;}
    public String getNome() {return nome;}
    public int getIdade() {return idade;}
    public String getRace() {return race;}
    public double getPeso() {return peso;}
    public void setNome(String nome){ this.nome = nome;}
    public void setIdade(int idade){this.idade = idade;}
    public void setRace(String race){this.race = race;}
    public void setPeso(double peso){this.peso = peso;}
    public abstract String toString();
}
