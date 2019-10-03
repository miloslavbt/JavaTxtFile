/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kódování: Příliš žluťoučký kůň úpěl ďábelské ódy. */


import java.util.StringTokenizer;
import java.io.*;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*******************************************************************************
 * Třída {@code Test} je hlavní třídou projektu,
 * který ...
 *
 * @author    jméno autora
 * @version   0.00.000
 */
public class Test
{

    public static void main(String[] args)throws FileNotFoundException, UnsupportedEncodingException, IOException 
    {
    
        String filePath = "testovani.txt";
        String fileEncoding = "UTF-8";
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Chcete číst(r) nebo přepsat(w)?");
        String vyber = sc.next();
        
        if(vyber.equals("r")){
        int wordCount = 0;
        int lineCount = 0;
        int characterCount = 0;

        //vytvorime novou bufferovanou ctecku s danym kodovanim z FileInputStreamu
        BufferedReader bReader = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), fileEncoding));
        String line = null;
        while((line = bReader.readLine()) != null){ //dokud mame k dispozici dalsi radek
            characterCount += line.length();
            lineCount++;

            //tokenizer rozlozi text na jednolive symboly (tokeny) dle uvedenych oddelovacu (delimiter)
            StringTokenizer tokenizer = new StringTokenizer(line, " \\u0009"); //oddelovace jsou mezera a \\u0009 == tabulator
            wordCount += tokenizer.countTokens();
        }
        
        bReader.close(); //i Readery (a Writery) musime zavrit
        
        System.out.println("Pocet znaku: " + characterCount);
        System.out.println("Pocet slov: " + wordCount);
        System.out.println("Pocet radku: " + lineCount);
    }
    else if(vyber.equals("w")){    
        
       BufferedWriter bWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filePath),fileEncoding));
        Scanner sc1 = new Scanner(System.in);
        System.out.println("Zadej text:");
        String text = sc1.nextLine();
        System.out.println("Zadal jsi text: "+ text);
        bWriter.write(text);
        bWriter.close();
        System.out.println("text se přepsal");
    }
    else {System.out.println("Špatný znak");}
    }
}
