package br.com.voidstar.personCompany;

public class Person {
    private String name;
    private String surname;
    private double salary;
    private Company company;

    public Person() {
        this.name = "";
        this.surname = "";
        this.salary = 0.0;
        this.company = null;
    }

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Person(String name, String surname, double salary, Company company) {
        this.name = name;
        this.surname = surname;
        this.salary = salary;
        this.company = company;
        this.company.incrementNumberOfEmployees();
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return this.surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public double getSalary() {
        return this.salary;
    }

    public Company getCompany() {
        return this.company;
    }

    public void selfHire(Company company, double salary) {
        this.company = company;
        this.salary = salary;
        company.incrementNumberOfEmployees();
    }

    public void selfDismiss() {
        company.decrementNumberOfEmployees();
        this.company = null;
        this.salary = 0;
    }
}
