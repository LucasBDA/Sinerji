package sinerji_test_users;

import sinerji_test_role.Role;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class Users extends Role {
    private String name;
    private String hireDate;
    private double soldMoney;
    private String sellingDate;

    public Users(){}

    public Users(String role, double salary2, String name, String hireDate) {
        super(role, salary2);
        this.name = name;
        this.hireDate = hireDate;
    }

    public Users(String role, double salary2, String name, String hireDate, double soldMoney, String sellingDate) {
        super(role, salary2);
        this.name = name;
        this.hireDate = hireDate;
        this.soldMoney = soldMoney;
        this.sellingDate = sellingDate;
    }

    public Users(String name, String hireDate, double soldMoney, String sellingDate) {
        this.name = name;
        this.hireDate = hireDate;
        this.soldMoney = soldMoney;
        this.sellingDate = sellingDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHireDate() {
        return hireDate;
    }

    public void setHireDate(String hireDate) {
        this.hireDate = hireDate;
    }

    public double getSoldMoney() {
        return soldMoney;
    }

    public void setSoldMoney(double soldMoney) {
        this.soldMoney = soldMoney;
    }

    public String getSellingDate() {
        return sellingDate;
    }

    public void setSellingDate(String sellingDate) {
        this.sellingDate = sellingDate;
    }

    @Override
    public double getSalary() {
        double salary = 0;
        if(getRole()=="Secretário"){
            salary = super.getSalary() + 1000*calculateTimeInYears(this.getHireDate());
        }
        else if(getRole()=="Vendedor"){
            salary = super.getSalary() + 1800*calculateTimeInYears(this.getHireDate()); 
        }
        else if(getRole()=="Gerente"){
            salary = super.getSalary() + 3000*calculateTimeInYears(this.getHireDate());
        }
        return salary;
    }

    public int calculateTimeInYears(String date){
        int year = Integer.parseInt(date.substring(3));
        int month = Integer.parseInt(date.substring(0,2));
        LocalDate iniciDate = LocalDate.of(year, month, 1);
        LocalDate finalDate = LocalDate.now();
        long difference = ChronoUnit.YEARS.between(iniciDate, finalDate);
        return (int) (difference);
    }
    public static void calculateSalaries_Benefits(List<Users> list){
        double newSalary = 0;
        for(Users user : list){
            if(user.getRole() == "Secretário"){
                newSalary = user.getSalary() + user.getSalary()*0.2;
            }
            else if(user.getRole()=="Vendedor"){
                newSalary = user.getSalary() + user.getSoldMoney()*0.3; 
            }
            else if(user.getRole()=="Gerente"){
                newSalary = user.getSalary();
            }
            System.out.printf("Salário do funcionário " + user.getName() + " (salário + benefícios): R$ %.2f%n", newSalary);
        }
    }

    public static void calculateSalaries_Without_Benefits(List<Users> list){
        for(Users user : list){
            System.out.printf("Salário do funcionário " + user.getName() + " (somente salário): R$ %.2f%n", user.getSalary());
        }
    }

    public static void calculateBenefits(List<Users> list){
        double newSalary = 0;
        for(Users user : list){
            if(user.getRole() == "Secretário"){
                newSalary = user.getSalary()*0.2;
            }
            else if(user.getRole()=="Vendedor"){
                newSalary = user.getSoldMoney()*0.3; 
            }
            else if(user.getRole()=="Gerente"){
                throw new IllegalArgumentException("O cargo descrito não possui benefícios!");
            }
            System.out.printf("Benefícios do funcionário " + user.getName() + " : R$ %.2f%n", newSalary);
        }
    }

    public static void calculateHigherSalary(List<Users> list){
        double higherSalary = 0;
        String higherSalaryName = "";
        for(Users user : list){
            if(user.getRole() == "Secretário"){
                if(higherSalary == 0){
                    higherSalary = user.getSalary() + user.getSalary()*0.2;
                    higherSalaryName = user.getName();
                }
                if((user.getSalary() + user.getSalary()*0.2) > higherSalary){
                    higherSalary = user.getSalary() + user.getSalary()*0.2;
                    higherSalaryName = user.getName();
                }
            }
            else if(user.getRole()=="Vendedor"){
                if(higherSalary == 0){
                    higherSalary = user.getSalary() + user.getSoldMoney()*0.3;
                    higherSalaryName = user.getName(); 
                }
                if((user.getSalary() + user.getSoldMoney()*0.3) > higherSalary){
                    higherSalary = user.getSalary() + user.getSoldMoney()*0.3;
                    higherSalaryName = user.getName();
                }
            }
            else if(user.getRole()=="Gerente"){
                if(higherSalary == 0){
                    higherSalary = user.getSalary();
                    higherSalaryName = user.getName();
                }
                if((user.getSalary()) > higherSalary){
                    higherSalary = user.getSalary();
                    higherSalaryName = user.getName();
                }
            }
        }
        System.out.printf("Salário mais alto: R$ %.2f do funcionário %s %n", higherSalary, higherSalaryName);
    }

    public static void calculateHigherBenefit(List<Users> list){
        double higherSalary = 0;
        String higherSalaryName = "";
        for(Users user : list){
            if(user.getRole() == "Secretário"){
                if(higherSalary == 0){
                    higherSalary = user.getSalary()*0.2;
                    higherSalaryName = user.getName();
                }
                if((user.getSalary()*0.2) > higherSalary){
                    higherSalary = user.getSalary()*0.2;
                    higherSalaryName = user.getName();
                }
            }
            else if(user.getRole()=="Vendedor"){
                if(higherSalary == 0){
                    higherSalary = user.getSoldMoney()*0.3;
                    higherSalaryName = user.getName(); 
                }
                if((user.getSoldMoney()*0.3) > higherSalary){
                    higherSalary = user.getSoldMoney()*0.3;
                    higherSalaryName = user.getName();
                }
            }
            else if(user.getRole()=="Gerente"){
                throw new IllegalArgumentException("O cargo descrito não possui benefícios!");
            }
        }
        System.out.printf("Benefício mais alto: R$ %.2f do funcionário %s %n", higherSalary, higherSalaryName);
    }

    public static void calculateMostSells(List<Users> list){
        double higherSells = 0;
        String higherSellsName = "";
        for(Users user : list){
            if(user.getRole() != "Vendedor"){throw new IllegalArgumentException("O cargo descrito não é de Vendedor!");}
            if(higherSells == 0){
                higherSells = user.getSoldMoney();
                higherSellsName = user.getName();
            }
            if(user.getSoldMoney() > higherSells){
                higherSells = user.getSoldMoney();
                higherSellsName = user.getName();
            }
        }
        System.out.printf("Quem mais vendeu no mês foi o funcionário %s com R$ %.2f%n", higherSellsName, higherSells);
    }
}
