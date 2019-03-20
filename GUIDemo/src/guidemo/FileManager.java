/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package guidemo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.io.File;
import java.io.FileReader;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author Ronnie Joubert
 */
public class FileManager 
{
    //I set the file path here as well as declaring an arraylist.
    private static String fileName = "salesRep.txt";
    private static File newFile;
    private ArrayList<SalesRep> reps = new ArrayList<SalesRep>();
    private static Scanner input;
    
    public void addRep(SalesRep rep)
    {
        reps.add(rep);
        //System.out.println("Record added to list");
        System.out.println();
    }
    
    public void testMethod()
    {
        try{
        BufferedReader in = new BufferedReader(new FileReader("stars.txt"));
        System.out.println(in);
        }
        catch (Exception e)
        {
            System.out.println("Error");
        }
               
        
    }
     
       
    //This method writes the sales rep data to the file.
    public static void addRecords(SalesRep rep, String fName)
    {
        boolean fileCreated = false;
        boolean isValid = false;
        String contact = rep.setContact();
        String outputString = String.format("%s %s %s %s %s %s %s %s\n", rep.getRepID(), rep.getfName(), rep.getlName(), rep.getOfficeSold(), rep.getBooksSold(), rep.getPaperSold(), rep.getSalesDistrict(), contact);
        try
        {
            try
            {
                
                fileName = fName;
                
                //Create new file if file does not exist
                newFile = new File(fileName);
                fileCreated = newFile.createNewFile();
                if (fileCreated)
                {
                    //System.out.println("File Created.");
                    isValid = true;
                }else
                {
                    //System.out.println("File already exists.");
                    isValid = true;
                }
            } 
            catch (Exception e)
            {
                //System.out.println("Error: " + e);
                isValid = false;
            }
            
            if(isValid)
            {
                FileWriter fw = new FileWriter(fileName, true); //Selecting the true boolean flag forces the filewriter to append the record.  False would overwright.
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write(outputString);
                bw.close();
                
                
            }
        } 
        catch (IOException e)
        {
            System.out.println("Write to external file failed.");
            
        }
    }
    
    public ArrayList<SalesRep> evaluate(String salesFile)
    {
        
        ArrayList<SalesRep> stars = new ArrayList<SalesRep>();
        File file = new File(salesFile);
        try{
            FileReader reader = new FileReader(file);
            BufferedReader br = new BufferedReader(reader);
            
            SalesRep star;
            String line = br.readLine();
            while(line != null)
                    {
                        //System.out.println("Here");
                        star = parseLine(line);
                        
                        double total = Double.parseDouble(star.getOfficeSold()) + Double.parseDouble(star.getBooksSold()) + Double.parseDouble(star.getPaperSold());
            
                        if(total >= 8000)
                        {
                            addRecords(star, "stars.txt");
                            stars.add(star);
                        }
            
                        //System.out.println("Returned");
                        line = br.readLine();
                        //System.out.println("Read New Line");
                    }
        }
        catch (Exception e)
                {
                    //System.out.println("Cannot read file. " + e);;
                }
        
               
        return stars;
    }

    private SalesRep parseLine(String line)
    {
        //System.out.println("Starting Parse");
        String iD;
        String fName; 
        String lName;
        String oSold;
        String bSold;
        String pSold;
        String district;
        String contact;
        //System.out.println("Declared Variables");
        
        StringTokenizer st = new StringTokenizer(line);
        //System.out.println("Created Tokenizer");
                
        SalesRep rep = new SalesRep();
        //System.out.println("Created New Rep");
        
        //Fill Fields
        iD = st.nextToken().trim();
        fName = st.nextToken().trim();
        lName = st.nextToken().trim();
        oSold = st.nextToken().trim();
        bSold = st.nextToken().trim();
        pSold = st.nextToken().trim();
        district = st.nextToken().trim();
        contact = st.nextToken().trim();
        //System.out.println("Filled Fields");
        
        rep.setRepID(iD);
        rep.setfName(fName);
        rep.setlName(lName);
        rep.setOfficeSold(oSold);
        rep.setBooksSold(bSold);
        rep.setPaperSold(pSold);
        rep.setSalesDistrict(district);
        rep.setContactMethod(contact);
        //System.out.println("Set Rep Fields");
                
        return rep;
        
    }
    
}
