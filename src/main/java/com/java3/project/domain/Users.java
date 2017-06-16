package com.java3.project.domain;

import javax.persistence.Entity;
import javax.persistence.*;

/**
 * Created by John Lazaro on 16/06/2017.
 */
@Entity
public class Users {
    private int userId;
    private String userPass;
    private String givenName;
    private String email;
    private String address;
    private String gender;
    private String contact;
    private int role;



    @Basic
    @Column(name = "Role")
    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    @Id
    @Column(name = "UserID")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "UserPass")
    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    @Basic
    @Column(name = "GivenName")
    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    @Basic
    @Column(name = "Email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "Address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "Gender")
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Basic
    @Column(name = "Contact")
    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Users users = (Users) o;

        if (userId != users.userId) return false;
        if (role != users.role) return false;
        if (userPass != null ? !userPass.equals(users.userPass) : users.userPass != null) return false;
        if (givenName != null ? !givenName.equals(users.givenName) : users.givenName != null) return false;
        if (email != null ? !email.equals(users.email) : users.email != null) return false;
        if (address != null ? !address.equals(users.address) : users.address != null) return false;
        if (gender != null ? !gender.equals(users.gender) : users.gender != null) return false;
        return contact != null ? contact.equals(users.contact) : users.contact == null;
    }

    @Override
    public int hashCode() {
        int result = userId;
        result = 31 * result + (userPass != null ? userPass.hashCode() : 0);
        result = 31 * result + (givenName != null ? givenName.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        result = 31 * result + (contact != null ? contact.hashCode() : 0);
        result = 31 * result + role;
        return result;
    }
}

