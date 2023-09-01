package problems;

public class FloorBinarySearchImpl implements Floor {

	@Override
	public Integer floor(Integer[] array, Integer x) {
		int ini = 0;
		int fim = array.length-1;
		Integer idxFloor = this.binarySearch(array, x, ini, fim);
		if(idxFloor == -1){
			idxFloor = this.findNextToFloor(array, x);
		}
		return array[idxFloor];
	}

	private Integer binarySearch(Integer[] array, Integer x, int ini, int fim){
		Integer out = -1;

		if(ini < fim){
			int meio = (ini+fim)/2;

			if(array[meio] == x) {
				out = meio;
			}
			else if(x < array[meio]) {
				out = binarySearch(array, x, ini, meio-1);
			} else {
				out = binarySearch(array, x, meio+1, fim);
			} 
		}

		return out;
	}

	private Integer findNextToFloor(Integer[] array, Integer x){
		Integer nextToFloor = 0;
		for (int i = 0; i < array.length; i++) {
			if(array[i] < x && array[i] > nextToFloor) nextToFloor = i;
		}
		return nextToFloor;
	}

}
