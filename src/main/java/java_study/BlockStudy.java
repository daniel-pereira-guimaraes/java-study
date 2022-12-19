package java_study;

public class BlockStudy {

	{ 
		System.out.println("Printed by first block.");
	}
	
	static {
		System.out.println("Printed by first static block.");
	}
	
	public static void main(String[] args) {
		System.out.println("Printed by static main method.");
		
		System.out.println("Creating instance of " + BlockStudy.class.getSimpleName());
		BlockStudy sbs = new BlockStudy();
		System.out.println("Instance created!");
	}

	static {
		System.out.println("Printed by second static block.");
	}

	{ 
		System.out.println("Printed by last block.");
	}
	
}
