package sort;

public interface SortMethod {
	
	<E extends Comparable<E>>void sort(E[] arr);
}
