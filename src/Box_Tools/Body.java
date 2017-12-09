package src.Box_Tools;

import java.util.ArrayList;

public class Body {
    // The Body class holds an ArrayList of Strings that represent the predicates/descriptions
    //  of a particular subject.

    // Class Variables
    private ArrayList<String> body;

    // Body() is a constructor that takes in no arguments and instantiates the body variable as
    //  an empty ArrayList<String>.
    protected Body() {
        this.body = new ArrayList<>();
    }

    // Body(ArrayList<String>) takes in an ArrayList<String> and instantiates the body variable as
    //  the value of that list.
    protected Body(ArrayList<String> descriptions) {
        this.body = descriptions;
    }

    // addDescriptionToBody(String) adds a String to the body variable.
    protected void addDescriptionToBody(String description) {
        this.body.add(description);
    }

    // addManyDescriptionsToBody(ArrayList<String>) adds a collection of descriptions to the body
    //  variable
    protected void addManyDescriptionsToBody(ArrayList<String> descriptions) {
        this.body.addAll(descriptions);
    }

    // getbody() returns the body variable.
    protected ArrayList<String> getBody() {
        return this.body;
    }

    // removeDescriptionFromBody(String) removes the String from the body variable.
    protected void removeDescriptionFromBody(String body) {
        this.body.remove(body);
    }

    // removeAllDescriptionsFromBody() essentially clears the body variable.
    protected void removeAllDescriptionsFromBody() {
        this.body.clear();
    }

    // printBody() outputs the contents of the body variable.
    protected void printBody() {
        System.out.println("Body: ");

        for (Object s : this.body) {
            System.out.println((String)s);
        }

        System.out.println("-------------------------------");

    }
}
