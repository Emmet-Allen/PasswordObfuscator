import java.util.Scanner;
import java.util.Random;

public class App {
    public static void main(String[] args) {
        obfuscatePassword();
    }

    public static void obfuscatePassword(){
        String OldPassword;
        System.out.println("Please enter a password, we will then obfuscate it:");
       
        //! Creates a userInput object via heap memory 
        Scanner userInput = new Scanner(System.in);
        OldPassword = userInput.next();
        int length = OldPassword.length();
        char[] newCharArr = new char[length];
        
        int numValidChars = 62; //* 0-9, a-z, A-Z Valid Chars; 
        char[] validChars = new char[numValidChars];
        int numCount = 48; //* from 48 - 58 0-9 
        int lowerChar = 97; //* from 97 - 122 a-z
        int upperChar = 65; //* from 65 - 90 A-Z 

        //* This populates the valid Chars array, with the most common usable chars 
        for(int i = 0; i < numValidChars; i++){
            if(numCount < 59){
                validChars[i] = (char)numCount;
                numCount++;
            }
            if(numCount >= 59 && lowerChar < 124){
                validChars[i] = (char)lowerChar;
                lowerChar++;
            }
            if( (numCount >= 59 && lowerChar >= 124) && (upperChar < 91) ){
                validChars[i] = (char)upperChar;
                upperChar++;
            }
        }

        //* This populates cyphered password array from the array of all valid chars
        for(int i = 0; i < length; i++){
            Random rand = new Random();
            int n = rand.nextInt(62);
            char randomCh = (validChars[n]);
            newCharArr[i] = randomCh;
        }

        //* This prints cyphered password array
        System.out.println("Your cyphered password is:");
        for(int i = 0; i < length; i++){
            System.out.print(newCharArr[i]);
        }
        System.out.println();

        System.out.println("Please remember your decyphered password before exiting the program.");
        //! Frees userInput memory 
         userInput.close();
    }
}


