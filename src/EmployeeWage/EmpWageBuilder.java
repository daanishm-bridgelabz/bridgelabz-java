package EmployeeWage;

import java.util.ArrayList;
import java.util.List;

public class EmpWageBuilder implements IEmployeeWage {

    private static final int IS_ABSENT = 0;
    private static final int IS_PART_TIME = 1;
    private static final int IS_FULL_TIME = 2;

    private static final int FULL_DAY_HOUR = 8;
    private static final int PART_TIME_HOUR = 4;

    private final List<CompanyEmpWage> companyList;

    public EmpWageBuilder() {
        companyList = new ArrayList<>();
    }

    @Override
    public void addCompany(String companyName, int wagePerHour,
                           int maxWorkingDays, int maxWorkingHours) {

        companyList.add(new CompanyEmpWage(
                companyName, wagePerHour, maxWorkingDays, maxWorkingHours
        ));
    }

    @Override
    public void computeEmployeeWage() {
        for (CompanyEmpWage company : companyList) {
            int totalWage = computeCompanyWage(company);
            company.setTotalWage(totalWage);

            System.out.println("Total Wage for "
                    + company.companyName + " : " + company.totalWage);
        }
    }

    private int computeCompanyWage(CompanyEmpWage company) {

        int totalHours = 0;
        int totalDays = 0;
        int totalWage = 0;

        while (totalDays < company.maxWorkingDays &&
                totalHours < company.maxWorkingHours) {

            totalDays++;

            int empType = (int) (Math.random() * 3);
            int empHours;

            switch (empType) {
                case IS_FULL_TIME:
                    empHours = FULL_DAY_HOUR;
                    break;
                case IS_PART_TIME:
                    empHours = PART_TIME_HOUR;
                    break;
                default:
                    empHours = 0;
            }

            totalHours += empHours;
            totalWage += empHours * company.wagePerHour;
        }
        return totalWage;
    }
}
