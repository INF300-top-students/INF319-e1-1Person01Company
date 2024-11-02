package br.com.voidstar.personCompany;

public class Company {

    private String name;
    private int numberOfEmployees;

    public Company() {
        this.name = "";
        this.numberOfEmployees = 0;
    }

    public Company(String name) {
        this.name = name;
        this.numberOfEmployees = 0;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfEmployees() {
        return this.numberOfEmployees;

    }

    public void setNumberOfEmployees(int numberOfEmployees) {
        this.numberOfEmployees = numberOfEmployees;
    }

    public void incrementNumberOfEmployees() {
        this.numberOfEmployees++;
    }

    public void decrementNumberOfEmployees() {
        if (this.numberOfEmployees > 0) {
            this.numberOfEmployees--;
        }
    }
}
