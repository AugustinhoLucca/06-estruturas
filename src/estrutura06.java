import java.util.Scanner;

public class estrutura06 {
    public static void main(String[] args) {
        float n1, n2;
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite o primeiro número:");
        n1 = sc.nextFloat();
        System.out.println("Digite o segundo número:");
        n2 = sc.nextFloat();

        float media = (n1 + n2) / 2.0f;

        if (media >= 6.0f) {
            System.out.println("Passou de ano, sua média foi " + media);
        }
        else if (media < 6.0f) {
            System.out.println("Reprovado!!! Sua média foi " + media);
        }
    }
}
