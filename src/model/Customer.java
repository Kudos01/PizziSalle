package model;

import java.util.Date;

public class Customer {
    private String name;
    private String phone;
    private Date dob;
    private String address;
    private boolean first_order;
    private String delegation;

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAge(Date dob) {
        this.dob = dob;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setFirst_order(boolean first_order) {
        this.first_order = first_order;
    }

    public void setDelegation(String delegation) {
        this.delegation = delegation;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public Date getDob() {
        return dob;
    }

    public String getAddress() {
        return address;
    }

    public boolean isFirst_order() {
        return first_order;
    }

    public String getDelegation() {
        return delegation;
    }
}
