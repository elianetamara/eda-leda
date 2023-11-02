package problems;

import java.util.PriorityQueue;

public class ProfitMaximizationImpl implements ProfitMaximization {

    /**
     * Implementacao de heap sobrejacente. PriorityQueue é uma min-heap que
     * pode trabalhar com um comparator interno e permite elementos duplicados
     *
     * O método poll() é semelhante a extrair o root da PriorityQueue
     * O método add(elem) insere in elemento na heap
     */
    private PriorityQueue<Integer> heap;

    public ProfitMaximizationImpl(PriorityQueue<Integer> heap) {
        this.heap = new PriorityQueue<>((i, j) -> j - i);
    }

    public int maximize(Integer[] array, int amount) {
        Integer out = 0;
        if (array != null && amount > 0) {
            fillHeap(array);
            for (int i = 0; i < amount; i++) {
                Integer bigger = heap.poll();
                out += bigger;
                heap.add(bigger - 1);
            }
        }
        return out;
    }

    private void fillHeap(Integer[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null) {
                heap.add(array[i]);
            }

        }
    }
}
