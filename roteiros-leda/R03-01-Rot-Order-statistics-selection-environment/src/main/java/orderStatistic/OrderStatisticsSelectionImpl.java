package orderStatistic;

public class OrderStatisticsSelectionImpl<T extends Comparable<T>> implements OrderStatistics<T> {

	/**
	 * Esta eh uma implementacao do calculo da estatistica de ordem seguindo a estrategia 
	 * de usar o selection sem modificar o array original. Note que seu algoritmo vai 
	 * apenas aplicar sucessivas vezes o selection ate encontrar a estatistica de ordem 
	 * desejada sem modificar o array original. 
	 * 
	 * Restricoes:
	 * - Voce NÃO pode modificar o aray original
	 * - Voce NÃO pode usar memória extra: nenhum array auxiliar deve ser criado e utilizado.
	 * - Você NÃO pode usar métodos já prontos de manipulação de arrays
	 * - Voce NÃO pode encontrar a k-esima estatistica de ordem por contagem de
	 *   elementos maiores/menores, mas sim aplicando sucessivas selecoes (selecionar um elemento
	 *   usando a ideia do selection sort).
	 * - Considere que k varia de 1 a N 
	 * - Voce DEVE usar recursão para resolver o problema. Nenhum laço poderá ser utilizado.
	 * - Você pode implementar métodos auxiliares, desde que seja apenas nesta classe.
	 * - Os métodos auxiliares NÃO PODEM ter mais que três parâmetros.
	 *
	 * Dica: procure pensar como usar a ideia do selection sort para resolver esse problema,
     *       identifique que métodos você precisará para resolver o problema 
	 *       e pense no template da recursão em cada método que voce vai implementar.
	 */
	@Override
	public T getOrderStatistics(T[] array, int k) {
		T out = null;
		if(array.length > 0){
			int j = 0;
			int idxSmallest = findIndexFirstOrder(array, 0, array.length-1);
			for (int i = 0; i <= k; i++) {
				j = findIndexOrder(array, 0, idxSmallest);
			}
			out = array[j];
		}
		return out;
	}

	private boolean isKOrderEst(T[]array, int idxSmallest, int idxK){
		boolean out = true;
		int i = 0;
		if((array[idxK].compareTo(array[idxSmallest]) > 0 && i < array.length-1)){
			if(array[i].compareTo(array[idxK]) < 0){
				out = false;	
			}
		}
		i++;
		return out;

	}

	private int findIndexOrder(T[] array, int leftIndex, int idxSmallest){
		int smallest = leftIndex;
		int smallestIndex;
		if(leftIndex < array.length-1){
			if((array[smallest].compareTo(array[smallest+1]) > 0) && isKOrderEst(array, idxSmallest, smallest+1)){
					smallestIndex = smallest+1;
			}
			smallestIndex = findIndexOrder(array, leftIndex+1, smallest);
		}else{
			smallestIndex = smallest;
		}
		return smallestIndex;
	}

	private int findIndexFirstOrder(T[] array, int leftIndex, int smallest){
		int smallestIndex;
		if(leftIndex < array.length-1){
			if(array[smallest].compareTo(array[leftIndex+1]) > 0){
					smallest = leftIndex+1;
			}
			smallestIndex = findIndexFirstOrder(array, leftIndex+1, smallest);
		}else{
			smallestIndex = smallest;
		}
		return smallestIndex;
	}
	

}
