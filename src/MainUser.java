import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MainUser {

    public static void main(String[] args) throws FileNotFoundException {

        final String keyword = "END";
        File personFile = new File("tudor.dat");

        //Creating person objects





        //Finding Inheritance of the person

        Scanner file = new Scanner(personFile);
        ArrayList<Person> temp = new ArrayList<>();

        while(file.hasNext()) {
            String personRead = file.nextLine();
            if (personRead.equals(keyword))
                break;

            //replace temp with the People Array
            //scan arraylist to find the person.
            for (Person personMain : temp) {
                if (personMain.getName().equals(personRead)) {

                    for (int x = 0; x < 2 ; x++) {
                        personRead = file.nextLine();
                        for (Person parent : temp) {
                            if (parent.getName().equals(personRead)) {
                                if (x == 0)
                                    personMain.setMother(parent);
                                else
                                    personMain.setFather(parent);
                            }
                        }
                    }
                }
            }
        }
    }
}


