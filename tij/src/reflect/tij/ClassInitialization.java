package reflect.tij;

import java.util.*;


/*
 * 
 * There are actually three steps in preparing a class for use:

1. Loading, which is performed by the class loader. This finds the bytecodes (usually, but not necessarily, on your disk in your classpath) and creates a Class object from those bytecodes.
2. Linking. The link phase verifies the bytecodes in the class, allocates storage for static fields, and if necessary, resolves all references to other classes made by this class.
3. Initialization. If there’s a superclass, initialize that. Execute static initializers and static initialization blocks.

Initialization is delayed until the first reference to a static method (the constructor is implicitly static) or to a non-constant static field:
 */

class Initable {
	static final int staticFinal = 47;
	static final int staticFinal2 = ClassInitialization.rand.nextInt(1000);
	static {
		System.out.println("Initializing Initable");
	}
}

class Initable2 {
	static int staticNonFinal = 147;
	static {
		System.out.println("Initializing Initable2");
	}
}

class Initable3 {
	static int staticNonFinal = 74;
	static {
		System.out.println("Initializing Initable3");
	}
}

public class ClassInitialization {
	public static Random rand = new Random(47);

	public static void main(String[] args) throws Exception {
		Class initable = Initable.class;
		System.out.println("After creating Initable ref");
// Does not trigger initialization:
		System.out.println(Initable.staticFinal);
// Does trigger initialization:
		System.out.println(Initable.staticFinal2);
// Does trigger initialization:
		System.out.println(Initable2.staticNonFinal);
	}
}