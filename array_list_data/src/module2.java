import java.io.File;
import java.io.IOException;

public class module2 {

    public static void main(String[] args) throws IOException {    
        VigenereBreaker vb = new VigenereBreaker();
        File secretmessage = new File("Array-list-data/messages/secretmessage4.txt");
        vb.breakVigenere(secretmessage);
        
        
    }
}
