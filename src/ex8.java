import java.util.Scanner;

public class ex8 {
    public static void main(String[] args) {
        int X, Y, Z;
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite um valor ---> ");
        X = sc.nextInt();
        System.out.print("Digite um segundo valor ---> ");
        Y = sc.nextInt();
        System.out.print("Digite um terceiro valor ---> ");
        Z = sc.nextInt();

        if (X != Y && Z != Y && Z != X) {
            if (X > Y && Z > Y){
                System.out.println("O menor número é " + Y);
            }
            else if (Y > X && Z > X) {
                System.out.println("O menor número é " + X);
            }
            else if (Y > Z && X > Z) {
                System.out.println("O menor número é " + Z);
            }
        }
        else {
            System.out.println("Não pode haver repetição!");
        }
    }
}
