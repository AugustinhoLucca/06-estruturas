package entidades;

public class Animais {

    private String nome;
    private String especie;
    private String raca;
    private int idade;

    public Animais(String nome, String especie, String raca, int idade) {
        this.nome = nome;
        this.especie = especie;
        this.raca = raca;
        this.idade = idade;
    }

    public Animais(String nome, String especie) {
        this.nome = nome;
        this.especie = especie;
        this.raca = "Desonhecido/Vira-Lata";
        this.idade = -1;
    }

    public String verificarCondicao () {

        if (idade == -1) {
            return "Desconhecido";

        }
        else if (idade <= 1) {

            return "Filhote";

        }
        else if (idade <= 4) {

            return "Jovem";

        }
        else if (idade < 10) {

            return "Adulto";

        }
        else {

            return "Idoso";

        }
    }

    public String idadeFinal () {
        if (idade == -1) {
            return "Desconhecida";
        }
        else {
            return "Idade: " + idade + " anos";
        }
    }

    public String getNome() {
        return nome;
    }

    public String getEspecie() {
        return especie;
    }

    public String getRaca() {
        return raca;
    }

    public int getIdade() {
        return idade;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
}
