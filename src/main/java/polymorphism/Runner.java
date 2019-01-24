package polymorphism;

public class Runner {

	public static void main(String[] args) {
		
		A a1 = new A();
		A a2 = new B();

		B b = new B();
		C c = new C();
		D d = new D();
		
		/*
		 * the easiest part
		 * 
		 * both ref and var of a1 is Class A
		 * and a1 can only call method from Class A
		 * hence the result will be either "A and A" or "A and D"
		 *  
		 * for a1.print(b)
		 * as print(B b) is not found in Class A's method
		 * it would look for parent class of b (Class A), and execute print(A a)
		 * the same would apply for a1.print(c)
		 */
		a1.print(a1); // A n A
		a1.print(a2); // A n A
		a1.print(b);  // A n A
		a1.print(c);  // A n A
		a1.print(d);  // A n D
		System.out.println();
		
		/*
		 * getting confusing
		 * ref is Class A but actual var is Class B
		 * can only invoke methods from Class A
		 * and methods from Class B is invisible for a2
		 * 
		 * for a2.print(a1)
		 * it would invoke print(A a) from Class A
		 * but the actual executing instance is Class B
		 * so it would actually implement print(A a) of Class B
		 * in short a2.print(a1) call print(A a) from Class A which is overridden in Class B
		 * 
		 * for a2.print(a2)
		 * the passed in parameter is of ref Class A but var Class B
		 * in this case it would only look at the ref, and treat print.(a2) as print(A a)
		 * and the rest follows as discussed above
		 */
		a2.print(a1); // B n A
		a2.print(a2); // B n A
		a2.print(b);  // B n A
		a2.print(c);  // B n A
		a2.print(d);  // A n D
		System.out.println();

		/*
		 * It would makes more sense to apply the previous technique on this part
		 */
		b.print(a1); // B n A
		b.print(a2); // B n A
		b.print(b);  // B n B
		b.print(c);  // B n B
		b.print(d);  // A n D
		System.out.println();

		/*
		 * for c.print(b)
		 * it would first check for print(B b) in Class C
		 * and found no matching method, hence it search for its superclass (Class B)
		 * then print(B b) from Class B is called
		 */
		c.print(a1); // C n A
		c.print(a2); // C n A
		c.print(b);  // B n B
		c.print(c);  // C n C
		c.print(d);  // A n D
		System.out.println();
		
		/*
		 * for d.print(b)
		 * as print(B b) is not defined in Class D, it search for the superclass and found from Class B
		 * so print(B b) from Class B is called
		 * 
		 * for d.print(c)
		 * print(C c) is not defined in Class D
		 * hence it search in the sequence of Class B, Class A, Object, and no results found
		 * 
		 * then it would widen the input parameter (C->B), and looks for print(B b), starts from Class D
		 * and finally find print(B b) in Class B
		 */
		d.print(a1); // D n A
		d.print(a2); // D n A
		d.print(b);  // B n B
		d.print(c);  // B n B
		d.print(d);  // D n D
		
		/*
		 * to conclude, there's 3 rules for this polymorphism problem:
		 * 1) order of method searching: this.do(refClass) -> super.do(refClass) -> this.((super)refClass) -> super.((super)refClass)
		 * 2) visibility of method is subject to refClass
		 * 3) actual implementation is subject to varClass
		 */
	}

}
