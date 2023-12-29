//here we will use FileWriter class which is used to write characters from file. Writer in name
//so obviously for Character stream data.

//NOTE: TO KNOW ALL THE METHOD AND CONSTRUCTORS AND EVERYTHINIG ABOUT ANYTHING USE DOCUMENTATION
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Write2 {
    public static void main(String[] args) {
        try(FileWriter fw = new FileWriter("note.txt")) {
            fw.write("My name in anurag jaiswal");
            //here if the given file name does not exist in FileHandling first directory then it
            //it will create its own file there and write the given data.
            //and if it found the file then it over write the given data erasing the old one.

            //but what if you want to append the data and not overwrite it
            //use constructor FileWrite(file name, boolean append)
        } catch(IOException e) {
            System.out.println(e.getMessage());
        }


        //but what if you want to append the data and not overwrite it
        //use constructor FileWrite(file name, boolean append)
        try(FileWriter fw = new FileWriter("note.txt", true)) {
            fw.write("\nit should be appended.");
        } catch(IOException e) {
            System.out.println(e.getMessage());
        }

        //BufferedWriter (again do same thing but more efficient than FileWriter and come up with
        //various useful methods)

        try(BufferedWriter bw = new BufferedWriter(new FileWriter("anything.txt"))) {
            bw.write("Hare Krishna");
            //there are other methods like newLine() and other which you can try
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
