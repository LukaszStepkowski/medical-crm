package pl.sda.medicalcrm.dto;

public class UserQueryDto {

    private String login;
    private String password;
    private String npwz;
    private String name;
    private String surname;
    private String pesel;

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

    public String getNpwz() {
        return npwz;
    }

    public void setNpwz(String npwz) {
        this.npwz = npwz;
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

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }
}
