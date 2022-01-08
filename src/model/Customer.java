package model;

import model.constants.Delegations;

import java.util.Date;

public class Customer {
    private String name;
    private String phone;
    private String dob;
    private String address;
    private boolean first_order;
    private Delegations delegation;

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setDoB(String dob) {
        this.dob = dob;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setFirst_order(boolean first_order) {
        this.first_order = first_order;
    }

    public void setDelegation(String delegation) {
        this.delegation = Delegations.valueOf(delegation);
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getDoB() {
        return dob;
    }

    public String getAddress() {
        return address;
    }

    public boolean isFirst_order() {
        return first_order;
    }

    public Delegations getDelegation() {
        return delegation;
    }
}
