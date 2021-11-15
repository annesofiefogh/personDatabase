package com.company;

//Comparable gets implemented in the class Person as an interface
public class Person implements Comparable {

    private String firstName;
    private String lastName;

    public Person (String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public int compareTo(Object otherObject) {
        Person otherPerson = (Person) otherObject;

        String ourFirstName = firstName;
        String otherFirstName = otherPerson.firstName;

        //if ourFirstName has a value less than '0' it's above the otherFirstName according to order
        if (ourFirstName.compareTo(otherFirstName) <= 0){
            return -1;
        } else {
            return 1;
        }
    }

    public String toString(){
        return firstName + " " + lastName;
    }

}
