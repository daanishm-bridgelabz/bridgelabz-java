package EmployeeWage;

public class EmployeeWageMain {
    public static void main(String[] args) {

        System.out.println("Welcome to Employee Wage Computation Program");

        EmployeeWageCompute empWage = new EmployeeWageCompute();
        empWage.calculateMonthlyWage();
        empWage.displayTotalWage();
    }
}
