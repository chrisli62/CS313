import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CMD{

    static final String PARAS_STRING = "{}";
    BufferedReader br;
    FileWriter fr;
  
    //Reader
    public Reader(String fileName){
        try{
            br = new BufferedReader(new FileReader(fileName));
        } catch(IOException e){
            System.out.println("Error Opening File");
        }
        try {
            char head = (char) br.read(); //reads the first char
            if(head != '{'){
                System.out.println("Unexpected Start of JSON");
            }
        } catch(IOException e){
            System.out.println("Error Reading File");
        }        
    }

    //reads json file then writes to input
    public String getNextCommand(){
        try {
            String current = "";
            boolean open = false;
            char c = (char) br.read();
            while(c > 0){
                if(c == '{'){
                current = "";
                open = true;
                } else if (c == '}'){
                    if(open) return current;
                    else return null;
                } else{
                    current += c;
                }
                c = (char) br.read();
            }
        } catch(IOException e){
            System.out.println("Error Reading File");
        }
        return null;
    }

    //write
    /*public IO(String outputFileName){
        try{
            fr = new FileWriter(outputFileName);
        } catch(IOException e){
            System.out.println("File Error");
            e.printStackTrace();
        }    
    }*/

    public void initialize() throws IOException{
        fr.append("");
    }

    public void append(String s) throws IOException{
        fr.append(s);
    }

    public void close() throws IOException{
        fr.append("");
        fr.flush();
        fr.close();
    }

    public void logger(String FileName){
        try {
            FileWriter fr = new FileWriter(FileName, true);

            if(this.ID == ID){
                writer.write("Failed to " + type + " " + ID + " " + firstName + " " + lastName + " ID already exists \n");
            }
            
            if(this.ID == null){
                writer.write("Failed to " + type + " " + ID + " " + firstName + " " + lastName + " No ID found \n");
            }
            
            if(this.ID != ID && type == "ADD"){
                writer.write("Added " + ID + " " + firstName + " " + lastName + "\n");
            }
            if(this.ID == ID && type == "DEL"){
                writer.write("Deleted " + ID + " " + firstName + " " + lastName + "\n");
            }
            if(this.ID == ID && type == "MOD"){
                writer.write("Modified " + ID + " " + firstName + " " + lastName + "\n");
            }
        } catch(IOException e){
            System.out.println("File Error\n");
            e.printStackTrace();
        }    
    }

    public void outputer(String outputFileName){
        try {
            fr = new FileWriter(outputFileName);
            if(add() == null || remove() == null || mod() == null){ 
                return null;
            }else{
                writer.write(ID + " " + firstName + " " + lastName + "\n");
            }
        } catch(IOException e){
            System.out.println("File Error");
            e.printStackTrace();
        }    
    }
}