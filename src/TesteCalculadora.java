import java.util.Scanner;

public class TesteCalculadora {
    public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		CalculadoraCientificaBuffada calcCienBuff = new CalculadoraCientificaBuffada();
		
		String nextLine = sc.nextLine();
		while(!nextLine.isEmpty()) {
			calcCienBuff.calcular(nextLine);
			nextLine = sc.nextLine();
		}
		
		System.out.println("Fim");
		sc.close();	
	}
}
