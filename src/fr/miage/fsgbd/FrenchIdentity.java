package fr.miage.fsgbd;

import java.util.Objects;

public class FrenchIdentity {

    private String numeroSecuriteSociale;
    private String firstName;
    private String name;
    private int age;

    public FrenchIdentity() {
        numeroSecuriteSociale = null;
        firstName = null;
        name = null;
        age = -1;
    }

    public FrenchIdentity(String numeroSecuriteSociale, String firstName, String name, int age) {
        this.numeroSecuriteSociale = numeroSecuriteSociale;
        this.firstName = firstName;
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "FrenchIdentity{" +
                "numeroSecuriteSociale='" + numeroSecuriteSociale + '\'' +
                ", firstName='" + firstName + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FrenchIdentity that = (FrenchIdentity) o;
        return age == that.age && Objects.equals(numeroSecuriteSociale, that.numeroSecuriteSociale) && Objects.equals(firstName, that.firstName) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numeroSecuriteSociale, firstName, name, age);
    }

    public String getNumeroSecuriteSociale() {
        return numeroSecuriteSociale;
    }

    public void setNumeroSecuriteSociale(String numeroSecuriteSociale) {
        this.numeroSecuriteSociale = numeroSecuriteSociale;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
