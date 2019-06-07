package Tables;

public class Users {
    public String User_id;
    private void setUser_id(String user_id) {
        User_id = user_id;
    }

    public String getUser_id() {
        return User_id;
    }

    public String Login;
    private void setLogin(String login) {
        Login = login;
    }

    public String getLogin() {
        return Login;
    }

    public String Name;
    private void setName(String name) {
        Name = name;
    }

    public String getName() {
        return Name;
    }

    public String Surname;
    private void setSurname(String surname) {
        Surname = surname;
    }

    public String getSurname() {
        return Surname;
    }

    public String FathersName;
    private void setFathersName(String fathersName) {
        FathersName = fathersName;
    }

    public String getFathersName() {
        return FathersName;
    }

    public String Email;
    private void setEmail(String email){
        Email = email;
    }

    public String getEmail() {
        return Email;
    }

    public String Phone;
    private void setPhone(String phone) {
        Phone = phone;
    }

    public String getPhone() {
        return Phone;
    }
    public String Country;
    public String City;
    public String Gender;
    public String DateOfBirth;

    public String getCity() {
        return City;
    }

    public String getCountry() {
        return Country;
    }

    public String getGender() {
        return Gender;
    }

    public String getDateOfBirth() {
        return DateOfBirth;
    }

    private void setCity(String city) {
        City = city;
    }

    private void setCountry(String country) {
        Country = country;
    }

    private void setGender(String gender) {
        Gender = gender;
    }

    private void setDateOfBirth(String dateOfBirth) {
        DateOfBirth = dateOfBirth;
    }
     public Users(){}
     public Users(String user_id, String login, String name, String surname, String fathersName,
                  String email, String phone, String country, String city, String gender, String dateOfBirth){
        User_id = user_id;
        Login = login;
        Name = name;
        Surname = surname;
        FathersName = fathersName;
        Email = email;
        Phone = phone;
        Country = country;
        City = city;
        Gender = gender;
        DateOfBirth = dateOfBirth;
     }
}

