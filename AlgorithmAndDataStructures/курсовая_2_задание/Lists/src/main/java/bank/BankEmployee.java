package bank;

public class BankEmployee {
    private String surname;
    private String position;

    public BankEmployee() {
    }

    public BankEmployee(String surname, String position) {
        this.surname = surname;
        this.position = position;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "surname= " + surname +
                ", position= " + position;
    }
}
