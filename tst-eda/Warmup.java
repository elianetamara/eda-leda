import java.util.Scanner;

class Warmup {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int x = Integer.parseInt(sc.nextLine());
		String[] y = sc.nextLine().split(" ");
		String saida = "";

		for(int i = 0; i < y.length; i++){
			int z = Integer.parseInt(y[i]);
			saida += Integer.toString(x*z) + " ";

		}
		System.out.println(saida.trim());
	}

}