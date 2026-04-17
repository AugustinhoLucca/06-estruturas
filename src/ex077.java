import java.util.Scanner;

public class ex077 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int diaria;
        double taxa;

        System.out.print("Quantos dias de hospedagem? ");
        diaria = sc.nextInt();

        if (diaria > 15) {
            taxa = 15.50;
            System.out.println("O preço da hospedagem será: R$" + (250 + (taxa * diaria)));
        }
        else if (diaria == 15) {
            taxa = 36;
            System.out.println("O preço da hospedagem será: R$" + (250 + (taxa * diaria)));
        }
        else {
            taxa = 58;
            System.out.println("O preço da hospedagem será: R$" + (250 + (taxa * diaria)));
        }


    }
}
