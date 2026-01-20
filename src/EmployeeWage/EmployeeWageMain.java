package EmployeeWage;

public class EmployeeWageMain {

    public static void main(String[] args) {

        System.out.println("Welcome to Employee Wage Computation Program");

        IEmployeeWage empWageBuilder = new EmpWageBuilder();

        empWageBuilder.addCompany("TCS", 20, 20, 100);
        empWageBuilder.addCompany("Infosys", 25, 22, 120);
        empWageBuilder.addCompany("Wipro", 18, 20, 90);

        empWageBuilder.computeEmployeeWage();
    }
}
