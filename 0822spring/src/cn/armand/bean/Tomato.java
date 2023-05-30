package cn.armand.bean;
// 交给spring管理的对象通常为Bean
public class Tomato {
	public Tomato() {
		System.out.println("havest a little tomato");
	}
	public void execute(){
		System.out.println("there is a little tomato");
	}
}
