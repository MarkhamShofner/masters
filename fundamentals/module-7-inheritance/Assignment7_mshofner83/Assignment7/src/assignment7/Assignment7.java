/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment7;

/**
 *
 * @author mark8604
 */
public class Assignment7 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {                        
        Assignment7 employeeSalaries = new Assignment7();
        employeeSalaries.init();
    }
    
    public void init() {
        SalariedEmployee salaryTodd = new SalariedEmployee (120000);
        HourlyEmployee hourlyJim = new HourlyEmployee (45, 35);
        HourlyEmployee hourlySally = new HourlyEmployee (95, 45); 
        salaryTodd.displayInfo();
        hourlyJim.displayInfo();
        hourlySally.displayInfo();
    }
    
    public abstract class Employee {
        public abstract void displayInfo();
    }
    
    public class SalariedEmployee extends Employee {
        private int salary;
        
        SalariedEmployee (int salary) {
            this.salary = salary;
        }
        
        public void displayInfo(){
            System.out.println("My annual salary is: " + salary);
        }
    }
    
    public class HourlyEmployee extends Employee {
        private float rate;
        private float hoursWorked;
        private double earnings;

        HourlyEmployee (float rate, float hoursWorked) {
            this.rate = rate;
            this.hoursWorked = hoursWorked;
            this.earnings = rate*hoursWorked;
            if (hoursWorked > 40) this.earnings = rate*hoursWorked*1.5;
        }
        
        public void displayInfo(){
            System.out.println("My hourly rate is: " + rate + ", and my hours worked are: " + hoursWorked + ", so my earnings over that period are: " + earnings);
        }
    }
    
}
