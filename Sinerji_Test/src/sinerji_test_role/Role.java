package sinerji_test_role;

public class Role {
    private String role;
    protected double salary;

    /* ## RELAÇÃO BENEFÍCIO ##
     * 1 --> Secretário --> 20% sobre salário
     * 2 --> Vendedor   --> 30% sobre vendas
     * 3 --> Gerente    --> N/A
     */
    public Role(String role, double salary2) {
        this.role = role;
        this.salary = salary2;
    }
    public Role() {} //Construtor vazio

    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
    public double getSalary() {
        return salary;
    }
    public void setSalary(float salary) {
        this.salary = salary;
    }
}
    
    
