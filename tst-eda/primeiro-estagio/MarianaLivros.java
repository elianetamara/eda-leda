import java.util.Scanner;

class MarianaLivros {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String[] livros = sc.nextLine().split(",");
    System.out.println(formataSaida(livros));
    inserePrimeiro(livros);
  }

  public static void inserePrimeiro(String[] livros){
    for (int i = 1; i < livros.length; i++) { 
      int j = i;
      while (j > 0 && (livros[j].compareTo(livros[j-1]) < 0) ) {
        swap(livros, j);
        j -= 1;
      }
      System.out.println(formataSaida(livros));
    }	
  }

  private static void swap(String[] livros, int j){
    String aux = livros[j];
    livros[j] = livros[j - 1];
    livros[j - 1] = aux;
  } 

  public static String formataSaida(String[] v) {
    String output = "";
    for (int i = 0; i < v.length; i++) {
        if (i == v.length - 1) {
            output += v[i];
        } else {
            output += v[i] + ", ";
        }
    }
    return output;
}
  
}
