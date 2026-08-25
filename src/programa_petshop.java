import entidades.Petshop;

import java.util.Scanner;

public class programa_petshop {
    static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Quantos animais serão cadastrados: ");
        int qtdAnimais = sc.nextInt();
        sc.nextLine();

        Petshop[] animal = new Petshop[qtdAnimais];

        System.out.println("É de conhecimento a idade e nome do animal? [S/N]");
        String verifConhecimento = sc.nextLine();

        if (verifConhecimento.equalsIgnoreCase("S")) {

            for (int cont = 0; cont < animal.length; cont++) {

                System.out.println("-=-=-=-=-=-");
                System.out.println("Animal " + (cont + 1) + ":");
                System.out.println("Espécie --> ");
                String especie = sc.nextLine();
                System.out.println("Raça --> ");
                String raca = sc.nextLine();
                System.out.println("Nome --> ");
                String nome = sc.nextLine();
                System.out.println("Idade --> ");
                int idade = sc.nextInt();
                sc.nextLine();

                animal[cont] = new Petshop(especie, raca, nome, idade);

                System.out.println("Deseja alterar a raça, nome, espécie ou idade do animal? [espécie/raça/nome/idade]");
                String verificarAlterar = sc.nextLine();

                if (verificarAlterar.equalsIgnoreCase("raça")){
                    System.out.println("Raça Atualizada --> ");
                    animal[cont].setRaca(sc.nextLine());
                }
                else if (verificarAlterar.equalsIgnoreCase("nome")) {
                    System.out.println("Nome Atualizado --> ");
                    animal[cont].setNome(sc.nextLine());
                }
                else if (verificarAlterar.equalsIgnoreCase("espécie")) {
                    System.out.println("Espécie Atualizada --> ");
                    animal[cont].setEspecie(sc.nextLine());
                }
                else if (verificarAlterar.equalsIgnoreCase("idade")) {
                    System.out.println("Idade Atualizada --> ");
                    animal[cont].setIdade(sc.nextInt());
                    sc.nextLine();
                }

            }
        }
        else {
            for (int cont = 0; cont < animal.length; cont++) {

                System.out.println("-=-=-=-=-=-");
                System.out.println("Animal " + (cont + 1) + ":");
                System.out.println("Espécie --> ");
                String especie = sc.nextLine();
                System.out.println("Raça --> ");
                String raca = sc.nextLine();

                animal[cont] = new Petshop(especie, raca);
            }
        }

        for (int cont = 0; cont < animal.length; cont++){

            System.out.println("-=-=-=-=-=-=-");
            System.out.println("Animal " + (cont + 1) + ":");
            System.out.println(animal[cont].getEspecie());
            System.out.println(animal[cont].getRaca());
            System.out.println(animal[cont].getNome());
            System.out.println(animal[cont].getIdade());
            System.out.println(animal[cont].verifcarCondicao());
        }
    }
}
