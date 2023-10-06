package vetor;

import java.util.Comparator;

/**
 * Implementação de um vetor de objetos simples para exercitar os conceitos de
 * Generics.
 * 
 * @author Adalberto
 *
 */
public class Vetor<T extends Comparable<T>> {

	// O array interno onde os objetos manipulados são guardados
	private T[] arrayInterno;

	// O tamanho que o array interno terá
	private int tamanho;

	// Indice que guarda a proxima posição vazia do array interno
	private int indice;

	// O Comparators a serem utilizados
	private Comparator<T> comparadorMaximo;
	private Comparator<T> comparadorMinimo;

	public Vetor(int tamanho) {
		super();
		this.tamanho = tamanho;
		this.indice = -1;
		this.arrayInterno = (T[]) new Comparable[tamanho];
	}

	public void setComparadorMaximo(Comparator<T> comparadorMaximo) {
		this.comparadorMaximo = comparadorMaximo;
	}

	public void setComparadorMinimo(Comparator<T> comparadorMinimo) {
		this.comparadorMinimo = comparadorMinimo;
	}

	// Insere um objeto no vetor
	public void inserir(T o) {
		indice = indice+1;
		this.arrayInterno[indice] = o;
	}

	// Remove um objeto do vetor
	public T remover(T o) {
		T out = null;
    for (int i = 0; i < arrayInterno.length; i++) {
      if (arrayInterno[i].equals(o)) {
        out = arrayInterno[i];
        arrayInterno[i] = arrayInterno[indice];
        arrayInterno[indice] = null; 
        indice = indice-1;;
      }
    } 
    return out;
	}

	// Procura um elemento no vetor
	public T procurar(T o) {
		T out = null;
		for (int i = 0; i < arrayInterno.length; i++) {
			if(arrayInterno[i].equals(o)){
				out = arrayInterno[i];
				break;
			}
		}
		return out;
	}

	// Diz se o vetor está vazio
	public boolean isVazio() {
		return this.indice == -1;
	}

	// Diz se o vetor está cheio
	public boolean isCheio() {
		return indice == arrayInterno.length - 1;
	}

}
