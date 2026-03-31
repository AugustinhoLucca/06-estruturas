import java.util.Scanner;

public class ex05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        float valor, desconto, valorfinal;

        System.out.println("Qual foi o valor total das compras?");
        valor = sc.nextFloat();

        if (valor > 1000) {
            desconto = valor * (15 / 100);

        } else if (valor <= 1000) {
            desconto = valor * (8 / 100);

            valorfinal = valor - desconto;
            System.out.println("O valor a ser pago é: R$" + valorfinal);
        }
    }
}
