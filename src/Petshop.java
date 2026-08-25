package entidades;

public class Petshop {

    private String especie;
    private String raca;
    private String nome;
    private int idade;

    public Petshop(String especie, String raca, String nome, int idade) {
        this.especie = especie;
        this.raca = raca;
        this.nome = nome;
        this.idade = idade;
    }

    public Petshop(String especie, String raca) {
        this.especie = especie;
        this.raca = raca;
    }

    public String verifcarCondicao() {
        if (idade < 2) {
            return "Jovem";
        }
        else if (idade < 6) {
            return "Jovem Adulto";
        }
        else if (idade < 11) {
            return "Adulto";
        }
        else {
            return "Idoso";
        }
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
}
