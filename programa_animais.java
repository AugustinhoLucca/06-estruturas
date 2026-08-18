import entidades.Animais;

import java.util.Scanner;

public class progama_animais {

    static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String nome, especie, raca;
        int idade;

        System.out.println("Quantos animais serão cadastrados?");
        int qtdAnimais = sc.nextInt();

        sc.nextLine();

        Animais[] animal = new Animais[qtdAnimais];

        for (int cont = 0; cont< qtdAnimais; cont++) {

            System.out.println("É de conhecimento a raça e idade do animal? [S/N] ");
            String respostaRacaIdade = sc.nextLine();

            if(respostaRacaIdade.equalsIgnoreCase("S")) {

                System.out.println("-=-=-=-=-=-=-");
                System.out.println("Nome: ");
                nome = sc.nextLine();
                System.out.println("Espécie: ");
                especie = sc.nextLine();
                System.out.println("Raça: ");
                raca = sc.nextLine();
                System.out.println("Idade: ");
                idade = sc.nextInt();
                sc.nextLine();

                animal[cont] = new Animais(nome, especie, raca, idade);
            }

            else {


                System.out.println("-=-=-=-=-=-=-");
                System.out.println("Nome: ");
                nome = sc.nextLine();
                System.out.println("Espécie: ");
                especie = sc.nextLine();

                animal[cont] = new Animais(nome, especie);
            }

        }

        for (int cont = 0; cont< qtdAnimais; cont++) {

            System.out.println("-=-=-=-=-=-=-");
            System.out.println("Nome: " + animal[cont].getNome());
            System.out.println("Espécie: " + animal[cont].getEspecie());
            System.out.println("Raça: " + animal[cont].getRaca());
            System.out.println(animal[cont].idadeFinal());
            System.out.println("Condição: " + animal[cont].verificarCondicao());

        }

    }

}
