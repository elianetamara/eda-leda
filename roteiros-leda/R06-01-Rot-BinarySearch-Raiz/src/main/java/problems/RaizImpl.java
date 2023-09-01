package problems;

/**
 * Classe com metodos para calcular raiz n-esima de um numero com aproximacao
 * e para encontrar os limites que dividem um array em partes de mesmo tamanho
 * 
 * @author adalbertocajueiro
 *
 */
public class RaizImpl implements Raiz {

  public double raiz(int numero, int raiz, double erro) {
    return buscaBinaria(0, numero, numero, raiz, erro);
  }

  private static double buscaBinaria(double ini, double fim, int numero, int raiz, double erro) {
    double out = -1;
    if (ini < fim) {
      double meio = (ini + fim) / 2;
      double resultPotencia = potencia(meio, raiz, 0);
      if ((resultPotencia == numero) || margemDeErro(resultPotencia, erro, numero)) {
        out = meio;
      } else if (resultPotencia > numero) {
        out = buscaBinaria(ini, meio, numero, raiz, erro);
      } else if (resultPotencia < numero) {
        out = buscaBinaria(meio, fim, numero, raiz, erro);
      }
    }
    return out;
  }

  private static boolean margemDeErro(double resultPotencia, double erro, int numero) {
    double margem = 0;
    boolean dentroMargem = false;
    if (resultPotencia > numero) {
      margem = resultPotencia - numero;
    } else {
      margem = numero - resultPotencia;
    }
    if (margem <= erro) {
      dentroMargem = true;
    }
    return dentroMargem;
  }

  private static double potencia(double raiz, int exp, int i) {
    double out;
    if (i < exp) {
      i++;
      out = raiz * potencia(raiz, exp, i);
    } else {
      out = 1;
    }
    return out;
  }

}
