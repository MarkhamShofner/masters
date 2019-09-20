
public class ProductInt {

    /**
     * @param args the command line arguments
     */
	public static void main(String[] args) {
        System.out.println("-------------Start Of Main Method-------------");
        int firstArg = Integer.parseInt(args[0]);
        int secondArg = Integer.parseInt(args[1]);
        System.out.println("Converted first argument: " + firstArg);
        System.out.println("Converted second argument: " + secondArg);

        int intProduct = intProduct(firstArg, secondArg);
        // If the number is negative
        if (intProduct < 0) {
        	intProduct = intProduct * -1;
        	String negativeString = "(" + intProduct + ")";
        	// print out a negative amount as a number in parenthesis () rather than have a negative sign.
        	System.out.println("Your product is: " + negativeString);
        } else {
        	// otherwise print the number
        	System.out.println("Your product is: " + intProduct);
        }
        System.out.println("-------------End Of Main Method-------------");
	}

	// input two integers and return the product of the integers
	public static int intProduct (int x, int y) {
		return x * y;
	}
}
