import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MainUser {

    public static void main(String[] args) throws FileNotFoundException {

        final String keyword = "END";
        File personFile = new File("tudor.dat");

        //Creating person objects





        //Finding Inheritance of the person

        Scanner file = new Scanner(personFile);

        while(file.hasNext()) {
            String personRead = file.nextLine();
            int index;
            //End file detector
            if (personRead.equals(keyword))
                break;
            //implement arraylist
            //scan arraylist to find the person
            for (int x :) {
                if (personRead.equals()) {
                    index = x;
                    break;
                }
            }

            //Add in mother
            personRead = file.nextLine();

            //Add in father
            personRead = file.nextLine();


        }

    }
}
