package com.victoria.app.web.dto;


public class UserClientDto {

    private String login;
    private String password;

    private String surname;
    private String name;
    private String lastname;
    private String passportId;
    private String identityNumber;
    private String telephoneNumber;
    private String email;

    public UserClientDto() {
    }

    public UserClientDto(String login, String password, String surname, String name, String lastname, String passportId, String identityNumber, String telephoneNumber, String email) {
        this.login = login;
        this.password = password;
        this.surname = surname;
        this.name = name;
        this.lastname = lastname;
        this.passportId = passportId;
        this.identityNumber = identityNumber;
        this.telephoneNumber = telephoneNumber;
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPassportId() {
        return passportId;
    }

    public void setPassportId(String passportId) {
        this.passportId = passportId;
    }

    public String getIdentityNumber() {
        return identityNumber;
    }

    public void setIdentityNumber(String identityNumber) {
        this.identityNumber = identityNumber;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
