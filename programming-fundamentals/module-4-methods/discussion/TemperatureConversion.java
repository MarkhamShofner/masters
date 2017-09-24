import java.util.Scanner;

public class TemperatureConversion
{
  public static void main( String [] args )
  {
    int userChoice = 0;                           // User selection: 1, 2, 3
    float temperatureFahrenheit = 0;              // Fahrenheit temperature
    float temperatureCelsius = 0;                 // Celsius temperature

    Scanner input = new Scanner( System.in );     // Create a Scanner to obtain user input

    while( userChoice != 3 )
    {
      System.out.print( "Enter 1 to convert F->C, 2 to convert C->F, 3 to quit: " );
      userChoice = input.nextInt();              // Read user input

      switch( userChoice )
      {
        case 1:     // Convert Fahrenheit to Celsius
                    fahrenheitToCelsius(temperatureFahrenheit, temperatureCelsius, input);
                    break;
        case 2:     // Convert Celsius to Fahrenheit
                    celsiusToFahrenheit(temperatureFahrenheit, temperatureCelsius, input);
                    break;
        case 3:     // End Program
                    System.out.println( "Bye Bye" );
                    break;
        default:    // Invalid Data Entered
                    System.out.println( "Invalid Data: You must enter 1, 2, or 3" );
      }
    }
  }
  public static void fahrenheitToCelsius(float temperatureFahrenheit, float temperatureCelsius, Scanner input)
  {
    System.out.print( "Enter a Fahrenheit temperature: " );
    temperatureFahrenheit = input.nextFloat();
    temperatureCelsius = 5F/9F * ( temperatureFahrenheit - 32F );
    System.out.println( temperatureFahrenheit + " degrees Fahrenheit is " + temperatureCelsius + " degrees Celsius" );
  }
  public static void celsiusToFahrenheit(float temperatureFahrenheit, float temperatureCelsius, Scanner input)
  {
    System.out.print( "Enter a Celsius temperature: " );
    temperatureCelsius = input.nextFloat();
    temperatureFahrenheit = 9F/5F * temperatureCelsius + 32F;
    System.out.println( temperatureCelsius + " degrees Celsius is " + temperatureFahrenheit + " degrees Fahrenheit" );
  }
}
