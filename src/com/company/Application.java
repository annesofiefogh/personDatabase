package com.company;

import java.util.ArrayList;
import java.util.Collections;

public class Application {

    UserInterface ui = new UserInterface();
    private ArrayList<Person> personList = new ArrayList<>();


    public Application() {
        personList.add(new Person("Perry", "Lennies"));
        personList.add(new Person("Jim", "Flipper"));
        personList.add(new Person("Gary", "Wayne"));
        personList.add(new Person("Kinsley", "Conrad"));
        personList.add(new Person("Finnegan", "Wake"));
    }

    public void start() {
        boolean goAgain = true;

        while (goAgain) {
            ui.seeOptions();
            switch (ui.scannerInt()) {
                case 1 -> createPerson();
                case 2 -> {
                    Collections.sort(personList);
                    ui.seeListOfPersons(personList);
                    ui.deletePersonPrint(Prints.DELETE_PERSON_SELECTION);
                    ui.deletePersonPrint(deletePersonFromList(ui.scannerDelete()));
                }
                case 3 -> {
                    Collections.sort(personList);
                    ui.seeListOfPersons(personList);
                }
                case 0 -> {
                    ui.switchPrints(Prints.STOP_PROGRAM);
                    goAgain = false;
                }
                default -> ui.switchPrints(Prints.INPUT_NOT_REGISTERED);
            }
        }
    }

    public void createPerson() {
        ui.createPersonPrint(Prints.WRITE_FIRSTNAME_INFO);
        String firstName = ui.scannerString();
        ui.createPersonPrint(Prints.WRITE_LASTNAME_INFO);
        String lastName = ui.scannerString();
        ui.createPersonPrint(Prints.CREATION_DONE);

        personList.add(new Person(firstName, lastName));
    }

    private Prints deletePersonFromList(int userInput) {
        Prints printMessage = null;

        try {
            int personChoice = userInput;
            personList.remove(personChoice-1);
            printMessage = Prints.DELETE_PERSON_APPROVED;
        } catch (IndexOutOfBoundsException e) {
            printMessage = Prints.NO_SUCH_PERSON_EXIST;
        }
        return printMessage;
    }
}
