package zadatak13;

class ProgrammingLanguage implements Language {
		

	  // implementation of abstract method
	  public void getName(String name) {
	    System.out.println("Programming Language: " + name);
	  }
	  
	  public void getType(String type) {
		System.out.println("Programming Language type: " + type);
	  }
	  
	  
	  public static void main(String[] args) {
	    ProgrammingLanguage language = new ProgrammingLanguage();
	    language.getName("Java");
	    language.getType("OOP");
	  }

	
}
