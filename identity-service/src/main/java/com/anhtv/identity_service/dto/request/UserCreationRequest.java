package com.anhtv.identity_service.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class UserCreationRequest {
    @NotNull
    @Size(min = 5, message = "USERNAME_INVALID")
    private String username;

    @NotNull
    @Size(min = 8, message = "PASSWORD_INVALID")
    private String password;

    @Size(min = 1, message = "Please enter your first name.")
    private String firstName;

    @Size(min = 1, message = "Please enter your last name.")
    private String lastName;

    @Past(message = "Enter your birthday!")
    private LocalDate birthDate;

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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
}
