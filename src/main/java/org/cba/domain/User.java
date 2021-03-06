package org.cba.domain;

import org.cba.domain.finder.UserFinder;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.util.List;

/**
 * Created by adam on 26/02/2017.
 */
@Entity
public class User {

    public static final UserFinder find = new UserFinder();
    @Id
    private int id;
    @NotNull
    private String name;
    @NotNull
    private String surname;
    @NotNull
    private Date createdAt;
    @NotNull
    private int status;
    @NotNull
    private int type;
    @NotNull
    private String email;
    @NotNull
    private String password;
    @NotNull
    private String salt;

    @OneToMany(mappedBy = "customer")
    private List<Purchase> purchaseList;

    public List<Purchase> getPurchaseList() {
        return purchaseList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }
}
