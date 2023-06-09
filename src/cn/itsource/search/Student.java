package cn.itsource.search;
/**
 * 定义一个student类重写比较方法
 * @author zhangchujie
 *
 */
public class Student {
	private String name;
	private int id;
	public Student(String name, int id) {
		this.name = name;
		this.id = id;
	}
	@Override
	public boolean equals(Object student) {
		if(this == student)
			return true;
		if(student == null)
			return false;
		if(this.getClass()!=student.getClass())
			return false;
		Student another = (Student)student;
		return this.name.equals(another.name)&&this.id==another.id;
	}

}
