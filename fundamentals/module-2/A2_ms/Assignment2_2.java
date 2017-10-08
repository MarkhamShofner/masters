import java.util.Scanner;

public class Assignment2_2
{
  public static void main( String [] args )
  {
    // Use a Scanner to input integer values
    Scanner input = new Scanner( System.in );
    System.out.println( "\n\n" );
    System.out.print( "Enter a weight (in pounds) and a height (in inches), separated by a blank space:" );

    int weightPounds = input.nextInt();     // Input first value
    int heightInches = input.nextInt();     // Input second value

    // convert the inputs to their needed units
    double weightKilograms = 0.45359237 * weightPounds;
    double heightMeters = .0254 * heightInches;

    // calculate the BMI based on the converted inputs
    double calcBMI = weightKilograms / (heightMeters * heightMeters);

    // Output the BMI as well as relevant BMI ranges
    System.out.println( "\n\n" );
    System.out.println( "The resultant BMI is -- " + calcBMI);
    System.out.println( "\n\n" );
    System.out.println( "Underweight:" + "\t" + "less than 18.5");
    System.out.println( "Normal:" + "\t\t" + "18.5 – 24.9");
    System.out.println( "Overweight:" + "\t" + "25 – 29.9");
    System.out.println( "Obese:" + "\t\t" + "30 or greater ");
    System.out.println( "\n\n" );
  }
}
