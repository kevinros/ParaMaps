package src.Box_Tools;

public class Head {
    // The Head class holds a String variable that represents the subject of the sentence.

    // Class Variables
    private String head;

    // Head() is a constructor that takes no arguments; instantiates the head variable as
    //  an empty string.
    protected Head() {
        this.head = "";
    }

    // Head(String) is a constructor that takes in a String and instantiates the head variable as
    //  the value of that string.
    protected Head(String head) {
        this.head = head;
    }

    // getHead() returns the value of the head variable.
    protected String getHead() {
        return this.head;
    }

    // setHead(String) sets the current head variable to the value of the given String.
    protected void setHead(String head) {
        this.head = head;
    }
}
