import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainUser {

    private static Object s;

    public static void main(String[] args) throws FileNotFoundException {

        final String keyword = "END";
        File personFile = new File("tudor.dat");
        Scanner input = new Scanner(new File("tudor.dat"));

        //Creating person objects
        List<Person> people = new ArrayList<>();

        // Read each line
        while (input.hasNextLine()) {
            String line = input.nextLine();
            if (line.equals(keyword))
                break;
            Person p = new Person(line);
            people.add(p);
        }

        for (Person p : people) {
            System.out.println(p.getName());
        }


        //Finding Inheritance of the person


        ArrayList<Person> temp = new ArrayList<>();

        while (input.hasNext()) {
            String personRead = input.nextLine();
            if (personRead.equals(keyword))
                break;

            //replace temp with the People Array
            //scan arraylist to find the person.
            for (Person personMain : people) {
                if (personMain.getName().equals(personRead)) {
                    for (int x = 0; x < 2; x++) {
                        personRead = input.nextLine();
                        for (Person parent : people) {
                            if (parent.getName().equals(personRead)) {
                                if (x == 0)
                                    personMain.setMother(parent);
                                else
                                    personMain.setFather(parent);
                                parent.addChildren(personMain);
                            }
                        }
                    }
                }
            }
        }
        output(people);
        //System.out.println(people.get(1).getFather());
    }
    //User interface
    public static void output(List<Person> list) {
        Scanner console = new Scanner(System.in);
        System.out.println("Person's name?");
        String input = console.next();
        int num=searchList(input,list);
        while(num==-1){
            System.out.println("Sorry! I cannot find this name in the list. Please type again.");
            input = console.next();
            num=searchList(input,list);
        }
        if(num!=-1) {
            Person p = list.get(num);
            int count = 1;
            Person temp = p;
            System.out.println("Maternal line: ");
            System.out.println("    " + p.getName());
            while (temp.getFather() != null) {
                for (int i = 0; i <= count; i++) {
                    System.out.print("    ");
                }
                System.out.print(temp.getFather().getName());
                System.out.println();
                temp = temp.getFather();
                count++;
            }
            temp = p;
            count = 1;
            System.out.println("Paternal line: ");
            System.out.println("    " + p.getName());
            while (temp.getMother() != null) {
                for (int i = 0; i <= count; i++) {
                    System.out.print("    ");
                }
                System.out.print(temp.getMother().getName());
                System.out.println();
                temp = temp.getMother();
                count++;
            }
            temp = p;
            count = 1;
            System.out.println("Children: ");
            for (int i = p.getChildren().size() - 1; i >= 0; i--) {
                String child = p.getChildren().get(i).getName();
                System.out.println("    " + child);
            }
        }
    }
    //Method to search the person arraylist for the person the user asked for
    //Method takes in the user provided name and list of names as parameters
    //Method returns the index number of the name provided
    public static int searchList(String person, List<Person> list) {
        String result = "";
        int indexNum = -1;
        for(int i = 0; i < list.size(); i++) {
            result = list.get(i).getName();
            if(result.contains(person)) {
                indexNum = i;
            }
        }
        return indexNum;
    }
}


