package EmployeeWage;

public class EmployeeWageCompute {

    // Constants
    private static final int IS_ABSENT = 0;
    private static final int IS_PART_TIME = 1;
    private static final int IS_FULL_TIME = 2;

    private static final int WAGE_PER_HOUR = 20;
    private static final int FULL_DAY_HOUR = 8;
    private static final int PART_TIME_HOUR = 4;

    private static final int MAX_WORKING_DAYS = 20;
    private static final int MAX_WORKING_HOURS = 100;

    // Instance variables
    private int totalWorkingDays;
    private int totalWorkingHours;
    private int totalWage;

    // Constructor
    public EmployeeWageCompute() {
        this.totalWorkingDays = 0;
        this.totalWorkingHours = 0;
        this.totalWage = 0;
    }

    // UC1: Attendance check
    private int getEmployeeType() {
        return (int) (Math.random() * 3);
    }

    // UC4: Calculate daily working hours
    private int getWorkingHours(int empType) {
        switch (empType) {
            case IS_FULL_TIME:
                return FULL_DAY_HOUR;
            case IS_PART_TIME:
                return PART_TIME_HOUR;
            default:
                return 0;
        }
    }

    // UC2 & UC3: Daily wage calculation
    private int calculateDailyWage(int hoursWorked) {
        return hoursWorked * WAGE_PER_HOUR;
    }

    // UC5 & UC6: Monthly wage computation
    public void calculateMonthlyWage() {

        while (totalWorkingDays < MAX_WORKING_DAYS &&
                totalWorkingHours < MAX_WORKING_HOURS) {

            totalWorkingDays++;

            int empType = getEmployeeType();
            int hoursWorked = getWorkingHours(empType);

            totalWorkingHours += hoursWorked;
            int dailyWage = calculateDailyWage(hoursWorked);
            totalWage += dailyWage;

            System.out.println(
                    "Day " + totalWorkingDays +
                            " | Hours Worked: " + hoursWorked +
                            " | Daily Wage: " + dailyWage
            );
        }
    }

    public void displayTotalWage() {
        System.out.println("\nTotal Working Days : " + totalWorkingDays);
        System.out.println("Total Working Hours: " + totalWorkingHours);
        System.out.println("Total Monthly Wage: " + totalWage);
    }
}
