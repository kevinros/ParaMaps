package Box_Tools;

import java.util.ArrayList;

public class Box {

    private Head boxHead;
    private Body boxBody;

    public Box() {
        this.boxHead = new Head();
        this.boxBody = new Body();
    }

    public Box(Head boxHead, Body boxBody) {
        this.boxHead = boxHead;
        this.boxBody = boxBody;
    }

    public String getHead() {
        return this.boxHead.getHead();
    }

    public ArrayList<String> getBody() {
        return this.boxBody.getBody();
    }

    public void setHead(String head) {
        this.boxHead.setHead(head);
    }

    public void addElementToBody(String element) {
        this.boxBody.addDescriptionToBody(element);
    }

    public void addManyElementsToBody(ArrayList<String> elements) {
        this.boxBody.addManyDescriptionsToBody(elements);
    }

    public void removeElementFromBody(String element) {
        this.boxBody.removeDescriptionFromBody(element);
    }

    public void removeAllElementsFromBody() {
        this.boxBody.removeAllDescriptionsFromBody();
    }

    public void clearBox() {
        this.boxHead.setHead("");
        this.boxBody.removeAllDescriptionsFromBody();
    }

    public void printBoxContents() {
        System.out.printf("Head: %s\n", this.getHead());
        this.boxBody.printBody();
    }

}
