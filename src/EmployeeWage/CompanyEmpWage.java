package EmployeeWage;

public class CompanyEmpWage {

    public final String companyName;
    public final int wagePerHour;
    public final int maxWorkingDays;
    public final int maxWorkingHours;

    public int totalWage;

    public CompanyEmpWage(String companyName, int wagePerHour,
                          int maxWorkingDays, int maxWorkingHours) {
        this.companyName = companyName;
        this.wagePerHour = wagePerHour;
        this.maxWorkingDays = maxWorkingDays;
        this.maxWorkingHours = maxWorkingHours;
    }

    public void setTotalWage(int totalWage) {
        this.totalWage = totalWage;
    }
}
