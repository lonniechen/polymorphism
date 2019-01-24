package polymorphism;

public class D extends B{
	public void print(D d){
		System.out.println("D and D");
	}
	
	public void print(A a){
		System.out.println("D and A");
	}
	
	/*
	//method inherited from B	
	public void print(B b){
		System.out.println("B and B");
	}*/
}
