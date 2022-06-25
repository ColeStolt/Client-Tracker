package AlgorithmsAndDataStructures;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/* Data Parser
    - Hashes a given string
    - Stores it in a specified file
    - File doesn't exist, create it
    - Reads a given string
    - Unhashes file line by line
    - Finds matching string
    - Informs of match or no match
*/

public class DataParser {
    
    public DataParser(){
        System.out.println("Hello from git!");
    }

    // Creates a file if one doesn't exist and then searchs the file for the requested item
    public void hashAndStore(String item, String file){
        // Try / catch incase file creation fails
        try {
            File newFile = new File(file);
            if(newFile.createNewFile()){ // Checks if file is already created
                System.out.println("File created " + file + "\n");
            }else{
                System.out.println("File already created.\n");
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


        // Read file and store
        try {
            BufferedWriter write = new BufferedWriter(new FileWriter(file, true));
            write.write(hash(item));
            write.newLine();
            write.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
      
    }

    // Obviously not a secure way of hashing something but
    // Uhhhhhhhh its fine for now
    public String hash(String item){

        // Converts to a char array for parsing
        char[] itemArr = item.toCharArray();

        // Basically a caesar cipher
        for(int i = 0; i < item.length(); i++){
          itemArr[i] = (char)(itemArr[i] - 10);
        }

        // Convert back to string
        item = String.valueOf(itemArr);

        // Returns updated string
        return item;
    }

    // Obviously not a secure way of hashing something but
    // Uhhhhhhhh its fine for now
    public String decode(String item){

        // Converts to a char array for parsing
        char[] itemArr = item.toCharArray();

        // Basically a caesar cipher
        for(int i = 0; i < item.length(); i++){
          itemArr[i] = (char)(itemArr[i] + 10);
        }

        // Convert back to string
        item = String.valueOf(itemArr);

        // Returns updated string
        return item;
    }

    // Decodes the hashed data and checks if it matches
    public boolean hashAndRetrieve(String item, String file){

        String line = "";
        try {
            // Read file
            BufferedReader read = new BufferedReader(new FileReader(file));
            while((line = read.readLine()) != null){
                if(item.equals(decode(line))){
                    read.close();
                    return true;
                }
            }
            read.close(); // This is done so if a match is not found then
                          // Still close the file
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return false;
    }
}
