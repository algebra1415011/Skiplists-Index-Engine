/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package skiplist2;

import java.awt.Component;
import java.io.*;

/**
 *
 * @author algebra1415011
 */
public class TestProg2
{


  
   public static void main(String[] args)
   {

        String[] var;  
        SkipList S = new SkipList();
        Interface in= new Interface(S);
        in.setVisible(true);
        // The name of the file to open.
        String fileName = "input.txt";

        // This will reference one line at a time
        String line = null;

        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = 
                new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
                
                var = line.split(" ");
                if(S.get(var[0])!=null)
                {
                    System.out.println("duplicate");
                } 
                else 
                {
                    S.put(var[0], Integer.parseInt(var[1]));
                    in.addName(var[0], Integer.parseInt(var[1]));
                 }
                
                //System.out.println(var[0]+" "+Integer.parseInt(var[1]));
            }   
            
            // Always close files.
            bufferedReader.close();         
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                fileName + "'");                
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + fileName + "'");                  
            // Or we could just do this: 
            // ex.printStackTrace();
        }
       
      
          
   }

}
