package com.morosystems.restapplication.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users", schema = "public", catalog = "MorosystemsUloha")
public class UserEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;


    @NotNull
    @Size(min = 2, message = "Name field should contain at least 2 characters.")
    @Basic
    @Column(name = "name", unique = true)
    private String name;


    @Basic
    @JsonIgnore
    @Column(name = "username")
    private String username;


    @Basic
    @JsonIgnore
    @Column(name = "password")
    private String password;

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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserEntity userEntity = (UserEntity) o;

        if (id != userEntity.id) return false;
        if (name != null ? !name.equals(userEntity.name) : userEntity.name != null) return false;
        if (username != null ? !username.equals(userEntity.username) : userEntity.username != null) return false;
        if (password != null ? !password.equals(userEntity.password) : userEntity.password != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }
}
