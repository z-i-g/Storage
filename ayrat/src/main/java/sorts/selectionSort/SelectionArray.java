package sorts.selectionSort;

public class SelectionArray {

	private int nElements;
	private int[] a;

	public SelectionArray(int max) { //констуктор, создается массив с переданным размером
		a = new int[max];
		nElements = 0;
	}

	public void insert(int value) { // вставка нового элемента
		a[nElements] = value;
		nElements++;
	}

	public void selectionSort() { // сортировка методом выбора
		int out, in, min;

		for (out = 0; out < nElements - 1; out++) {
			min = out;
			for (in = out+1; in < nElements; in++) {
				if (a[min] > a[in]) { //если найден элемент меньше сравниваемого
					min = in;
				}
			}
			swap(out, min); //поменять местами
		}
	}

	public void swap(int one, int two) { // метод перестановки 2-х элементов
		int temp = a[one];
		a[one] = a[two];
		a[two] = temp;
	}

}
