package problems;
2   
3   /**
4    * Classe com metodos para calcular raiz n-esima de um numero com aproximacao
5    * e para encontrar os limites que dividem um array em 3 partes de mesmo tamanho
6    * 
7    * @author adalbertocajueiro
8    *
9    */
10  public class RaizImpl implements Raiz {
11  
12  	public double raiz(int numero, int raiz, double erro){
13  		return buscaBinaria(0, numero, numero, raiz, erro);
14  	}
15  
16  	private static double buscaBinaria(double ini, double fim, int numero, int raiz, double erro){
17  		double out = -1;
18  		if(ini < fim){
19  			double meio = (ini + fim)/2;
20  			double resultPotencia = potencia(meio, raiz, 0);
21  			if((resultPotencia == numero) || margemDeErro(resultPotencia, erro, numero)) {
22  				out = meio;
23  			}else if(resultPotencia > numero){
24  				out = buscaBinaria(ini, meio, numero, raiz, erro);
25  			}else if (resultPotencia < numero){
26  				out = buscaBinaria(meio, fim, numero, raiz, erro);
27  			}
28  		}
29  		return out;
30  	}
31  
32  	private static boolean margemDeErro(double resultPotencia, double erro, int numero){
33  		double margem = 0;
34  		boolean dentroMargem = false;
35  		if(resultPotencia > numero){
36  			margem = resultPotencia - numero;
37  		} else {
38  			margem = numero - resultPotencia;
39  		}
40  		if(margem <= erro){
41  			dentroMargem = true;
42  		}
43  		return dentroMargem;
44  	}
45  
46  
47  	 private static double potencia(double raiz, int exp, int i){
48  		double out;
49  		if(i < exp){                                                            
50  			i++;
51  			out = raiz * potencia(raiz, exp, i);
52  		}else{
53  			out = 1;
54  		}
55  		return out;
56  	}
57  
58  }
