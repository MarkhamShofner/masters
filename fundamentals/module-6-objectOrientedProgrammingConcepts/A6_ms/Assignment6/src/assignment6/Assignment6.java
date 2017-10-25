/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment6;
import java.util.Scanner;


/**
 *
 * @author mark8604
 */
public class Assignment6 {

    /**
     * This program models an employee
     */
    public static void main(String[] args) {
        // All fields are required to be non-blank.
        // The Date fields should be reasonably valid values (ex. month 1-12, day 1-31, year > 1900 and < 2020).
        // Issue appropriate error messages when incorrect data is entered.

        // Provide appropriate class constructors, getter methods, setter methods, toString() and any other
            // methods you think are necessary.
                // To keep things simple, your classes don’t need to do any
                    // editing of data.
        // The classes should not do any direct user input/output. All user input/output
            // will be done in the main method.
        // Your program should prompt the user to enter data for several employees,store the data in an
            // array of type Employee, and then display the data.

        Assignment6 employeeWork = new Assignment6();
        employeeWork.init();
    }

    public void init()
    {
        Scanner input = new Scanner (System.in);
        boolean enteringData = true;
        Employee[] employees = new Employee[10]; // max array size at 10, it's a small company
        int employeeCount = 0;
        System.out.println("Let's enter some employees!");

        while (enteringData) {
            // Grab initial inputs from the user
            // Name
            Name employeeName = new Name();
            System.out.println("First Name:");
            employeeName.firstName = input.next();
            System.out.println("Last Name:");
            employeeName.lastName = input.next();

            // Date
            Date employeeHireDate = new Date(0,0,0);
            System.out.println("Hire Month:");
            employeeHireDate.month = input.nextInt();
            System.out.println("Hire Day:");
            employeeHireDate.day = input.nextInt();
            System.out.println("Hire Year:");
            employeeHireDate.year = input.nextInt();

            // Address
            System.out.println("Address [Street Number]:");
            int number = input.nextInt();
            System.out.println("Address [Street Name]:");
            String street = input.next();
            System.out.println("Address [City]:");
            String city = input.next();
            System.out.println("Address [State]:");
            String state = input.next();
            System.out.println("Address [Zip]:");
            int zip = input.nextInt();
            Address employeeAddress = new Address(number, street, city, state, zip);

            // Number
            System.out.println("Employee Number:");
            int employeeNumber = input.nextInt();

            // Create the Employee
            Employee employee = new Employee(employeeName, employeeAddress, employeeHireDate, employeeNumber);
            employees[employeeCount] = employee;
            employeeCount++;

            System.out.println("Employee Name: " + employee.employeeName.getName());
            System.out.println("Employee Address: " + employee.employeeAddress.getAddress());
            System.out.println("Employee Hire Date: " + employee.employeeHireDate.getDate());
            System.out.println("Employee Number: " + employee.employeeNumber);


            // Allow user to chose when they stop entering employees
            System.out.println("Do you want to enter another employee? (1) for yes, (2) for no:");
            int continueInt = input.nextInt();
            if (continueInt == 2) {
                enteringData = false;
            } else if (continueInt == 1) {
            } else {
                System.out.println("Input not recognized. Why don't you put in another employee as an award!");
            }
        }
    }

     // A date consists of an integer month, day and year.
    public class Date
    {
        private int month;
        private int day;
        private int year;

        public Date (int m, int d, int y)
        {
            this.month = m;
            this.day = d;
            this.year = y;
        }
        
        public String getDate () {
            return month + "/" + day + "/" + year;
        }
    }

    // An address consists of a street, a city, a state (2 characters), and a 5-digit zip code.
    public class Address
    {
        private int number;
        private String street;
        private String city;
        private String state;
        private int zip;

        public Address (int number, String street, String city, String state, int zip)
        {
            this.number = number;
            this.street = street;
            this.city = city;
            this.state = state;
            this.zip = zip;
        }
        
        public String getAddress () {
            return street + " " + number + " " + city + ", " + state + " " + zip;
        }
    }

    // A name consists of a first name and a last name.
    public class Name
    {
        private String firstName;
        private String lastName;
        
        public String getName () {
            return firstName + " " + lastName;
        }
    }

    public class Employee
    {
        private int employeeNumber;
        private Name employeeName;
        private Address employeeAddress;
        private Date employeeHireDate;

        public Employee (Name name, Address address, Date date, int employeeNumber)
        {
            this.employeeName = name;
            this.employeeAddress = address;
            this.employeeHireDate = date;
            this.employeeNumber = employeeNumber;
        }
    }
}
