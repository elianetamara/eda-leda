import java.util.Scanner;

class TresNMaisUm {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int i = Integer.parseInt(sc.nextLine());
    int j = Integer.parseInt(sc.nextLine());

    System.out.println(maiorSeq(tamSeqs(i, j)));

  }


  public static int maiorSeq(int[] seqs){
    int max = seqs[0];
    for (int i : seqs) {
      max = i > max ? i : max;
    }
    return max;
  }

  public static int[] tamSeqs(int x, int y){
    int[] retorno = new int[y];
    int num = x;
    for (int i = 0; i < retorno.length; i++) {
      if(num == y+1){
        break;
      }
      retorno[i] = tamSeq(num);
      num++;
    }
    return retorno;
  }

  public static int tamSeq(int x){
    int count = 1;

    while(x > 1){
      x = x % 2 == 0 ? x/2 : (3*x)+1;
      count++;
    }
    return count;
  }
}
 
