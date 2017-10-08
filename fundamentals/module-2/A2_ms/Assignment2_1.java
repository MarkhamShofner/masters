import java.util.Scanner;

public class Assignment2_1
{
  public static void main( String [] args )
  {
    // Define and initialize variables for values to be input
    int v1 = 0;      // First value to be input
    int v2 = 0;      // Second value to be input
    int v3 = 0;      // Third value to be input
    int v4 = 0;      // Fourth value to be input
    int v5 = 0;      // Fifth value to be input
    int v6 = 0;      // Sixth value to be input

    // Use a Scanner to input integer values
    Scanner input = new Scanner( System.in );
    System.out.println( "\n\n" );
    System.out.print( "Enter 6 integers separated by a blank space:" );
    v1 = input.nextInt();     // Input first value
    v2 = input.nextInt();     // Input second value
    v3 = input.nextInt();     // Input third value
    v4 = input.nextInt();     // Input fourth value
    v5 = input.nextInt();     // Input fifth value
    v6 = input.nextInt();     // Input sixth value

    // Sum across the inputs where needed
    int columnOneTotal = v1 + v3 + v5;
    int columnTwoTotal = v2 + v4 + v6;
    int rowOneTotal = v1 + v2;
    int rowTwoTotal = v3 + v4;
    int rowThreeTotal = v5 + v6;
    int allInputsTotal = columnOneTotal + columnTwoTotal; // could also calculate this by adding all inputs individually, or by adding the three row totals

    // Output using System.out.println()
    System.out.println( "\n\n" );
    System.out.println( "\t" + "Value" + "\t" + "Value" + "\t" + "Total");
    System.out.println( "\t" + v1 + "\t" + v2 + "\t" + rowOneTotal);
    System.out.println( "\t" + v3 + "\t" + v4 + "\t" + rowTwoTotal);
    System.out.println( "\t" + v5 + "\t" + v6 + "\t" + rowThreeTotal);
    System.out.println( "\t---\t---\t---");
    System.out.println( "Total" + "\t" + columnOneTotal + "\t" + columnTwoTotal + "\t" + allInputsTotal);
    System.out.println( "\n\n" );
  }
}
