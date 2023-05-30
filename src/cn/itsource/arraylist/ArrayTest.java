package cn.itsource.arraylist;
import sort.Student;
public class ArrayTest {

	public static void main(String[] args) {
		Array<Student> arr1 = new Array<>();
		arr1.addLast(new Student("Rean", 3432));
		arr1.addLast(new Student("Alisa", 2342));
		arr1.addLast(new Student("Laura", 5464));
		arr1.addLast(new Student("Eliot", 3536));
		System.out.println(arr1);
		
		Array<Integer> arr2 = new Array<>(20);
		for(int i=0; i<10; i++)
			arr2.addLast(i);
		System.out.println(arr2);
		arr2.add(1, 100);
		System.out.println(arr2);
		arr2.remove(2);
		System.out.println(arr2);
		arr2.removeElement(4);
		arr2.removeFirst();
		System.out.println(arr2);
	}

}
