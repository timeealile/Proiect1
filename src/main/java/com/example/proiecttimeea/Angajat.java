package com.example.proiecttimeea;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Connection;
import java.util.Date;

public class Angajat {
    private BigDecimal cnp;
    private String firstname;
    private String lastname;
    private String email;
    private Date hire_date;
    private BigDecimal salary;

    public Angajat(BigDecimal cnp, String firstname, String lastname, String email, Date hire_date, BigDecimal salary) {
        this.cnp = cnp;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.hire_date = hire_date;
        this.salary = salary;
    }

    public BigDecimal getCnp() {
        return cnp;
    }

    public void setCnp(BigDecimal cnp) {
        this.cnp = cnp;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Angajat() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getHire_date() {
        return hire_date;
    }

    public void setHire_date(Date hire_date) {
        this.hire_date = hire_date;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }
}
