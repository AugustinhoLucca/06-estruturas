import java.util.Scanner;

public class ex9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double A, B, C, Z;

        System.out.print("Digite o valor de A --> ");
        A = sc.nextFloat();
        System.out.print("Digite o valor de B --> ");
        B = sc.nextFloat();
        System.out.print("Digite o valor de C --> ");
        C = sc.nextDouble();

        if (A == 0){
            System.out.println("Não é uma equação do Segundo Grau");
        }
        else {
            Z = (B * B) - 4 * A * C;

            if (Z < 0) {
                System.out.println("A equação não possui raiz real");
            }
            else {


                double x1;
                x1 = (-B + Math.sqrt(Z)) / (2 * A);

                double x2;
                x2 = (-B - Math.sqrt(Z)) / (2 * A);

                System.out.println("A raiz de X1 é:" + x1);
                System.out.println("A raiz de X2 é:" + x2);
            }
        }
    }
}
