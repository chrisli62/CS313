import java.io.*;
import java.io.IOException;
import java.io.FileWriter;

class Main{
        
    public final static int numberofCommand = 10;
    public final static String fileName = "input.txt";
    public final static String fileName1 = "log.txt";
    public final static String fileName2 = "output.txt";

    public static void main(String[] args) {
        IO input = new IO(fileName);
        IO log = new logger(fileName1);
        IO output = new outputer(fileName2);
        FileWriter out = new FileWriter(fileName);
        CMD jsonInput = new CMD("input.json");
        int count = 1;

    //Clears out text file so old data isn't repeated if run again
    try{
        FileWriter writer = new FileWriter(fileName);
        writer.write("");
        writer.close();
    }catch(Exception e){System.out.println(e);}    
        System.out.println("Removed old data in input.txt");

    //Read and input type, firstName and lastName into Array
    while(true){
        String nextCMD = jsonInput.getNextCommand();      
        if(nextCMD != null){
        try{
            FileWriter fw=new FileWriter(fileName, true);
            fw.write((count++) + ") " + nextCMD + "\n\n");
            fw.close();
        }catch(Exception e){System.out.println(e);}    
            System.out.println("Added data to input.txt");
        } else {
            break;
        }
    }

    //Move data into ArrayList and obtain ID to access index

    //Check if fail or pass and write to log.txt
    //Clear out log file so new log data doesn't mix with old log file data
    try{
        FileWriter writer = new FileWriter(fileName1);
        writer.write("");
        writer.close();
    }catch(Exception e){System.out.println(e);}    
        System.out.println("Removed old data in log.txt");
    //Output all successful data into output.txt
    //Clear out output file so new output data doesn't mix with old output file data
    try{
        FileWriter writer = new FileWriter(fileName2);
        writer.write("");
        writer.close();
    }catch(Exception e){System.out.println(e);}    
        System.out.println("Removed old data in output.txt");

        /*try{
            input.initialize();
            for(int i = 0; i < numberOfCommands; i++){
                Command c = new Command();
                input.append(c.toString());
                if(i < numberOfCommands - 1){
                    input.append(",");
                }
            }
            input.close();
            System.out.println("Input Complete.");
        } catch(IOException e){
            System.out.println("File IO Error");
            e.printStackTrace();
        }*/

        //Writing to log.txt
        /*try{
            log.initialize();
            for(int i = 0; i < numberOfCommands; i++){
                Command c = new Command();
                log.append(c.toString());
                if(i < numberOfCommands - 1){
                    log.append(",");
                }
            }
            log.close();
            System.out.println("Log Complete.");
        } catch(IOException e){
            System.out.println("File IO Error");
            e.printStackTrace();
        }

        //Writing to output.txt
        try{
            output.initialize();
            for(int i = 0; i < numberOfCommands; i++){
                Command c = new Command();
                output.append(c.toString());
                if(i < numberOfCommands - 1){
                    output.append(",");
                }
            }
            outsput.close();
            System.out.println("Input Complete.");
        } catch(IOException e){
            System.out.println("File IO Error");
            e.printStackTrace();
        }*/

    }
}
        
