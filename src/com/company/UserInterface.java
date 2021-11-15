package com.company;

import java.util.List;
import java.util.Scanner;

public class UserInterface {

    Scanner scInt = new Scanner(System.in);
    Scanner scString = new Scanner(System.in);
    Scanner scDelete = new Scanner(System.in);

    public void seeOptions(){
        String options = """
                \n–––––––––––––––––––––––––––––––––––––
                Welcome to little person database!
                Press '1' to create a new person
                Press '2' to delete a person
                Press '3' to see a list of persons
                Press '0' to exit the program
                –––––––––––––––––––––––––––––––––––––""";

        System.out.println(options);
    }

    public int scannerInt(){
        return scInt.nextInt();
    }

    public String scannerString(){
        return scString.nextLine();
    }

    public int scannerDelete(){
        return scDelete.nextInt();
    }

    public void switchPrints(Prints print){
        switch (print){
            case STOP_PROGRAM -> System.out.println("The program has ended.");
            case INPUT_NOT_REGISTERED -> System.out.println("Invalid input");
        }
    }

    public void createPersonPrint(Prints print){
        switch (print){
            case WRITE_FIRSTNAME_INFO -> System.out.print("Write first name: ");
            case WRITE_LASTNAME_INFO -> System.out.print("Write last name: ");
            case CREATION_DONE -> System.out.println("You've added one new person to the list");
        }
    }

    public void deletePersonPrint(Prints print){
        switch (print){
            case DELETE_PERSON_SELECTION -> System.out.print("\nType the number of the person you wish to delete: ");
            case DELETE_PERSON_APPROVED -> System.out.println("The person has been removed from the list.");
            case NO_SUCH_PERSON_EXIST -> System.out.println("No such person exist on the list.");
        }
    }

    public void seeListOfPersons(List list){
        int counter = 0;
        for (Object person : list) {
            counter++;
            System.out.println(counter + ")" + " " + person);
        }
    }


}
