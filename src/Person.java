import java.util.*;

public class Person {
    private String name;
    private Person father;
    private Person mother;
    private ArrayList<Person> children;

    public Person(String name) {
        this.name=name;
        children=new ArrayList<Person>();
    }
    //Set data
    public void setName(String name) {
        this.name=name;
    }
    public void setFather(Person father) {
        this.father=father;
    }
    public void setMother(Person mother) {
        this.mother=mother;
    }
    public void addChildren(Person child) {
        children.add(child);
    }

    //Pull data
    public String getName() {
        return name;
    }
    public Person getFather() {
        return father;
    }
    public Person getMother() {
        return mother;
    }
    public ArrayList<Person> getChildren() {
        return children;
    }
}
