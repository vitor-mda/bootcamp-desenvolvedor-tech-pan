import java.util.Scanner;

public class Pergunta05 {
    public static void main(String[] args) {
        Scanner ent = new Scanner(System.in);
        int[] numeros = new int[10];

        for(int i = 0; i < 10; i++) {
            System.out.printf("Digite o %dº número: \n", i+1);
            numeros[i] = ent.nextInt();
        }
    }
}
