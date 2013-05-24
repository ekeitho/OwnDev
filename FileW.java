import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.io.File;


public class FileW{

    public static void main(String[] args) throws IOException{
    
        System.out.println("Please write what you would like your file to be called.");
        Scanner in = new Scanner(System.in);
        
        String hi = in.nextLine();
        
    
        File files = new File(hi+".txt");

        FileWriter file = new FileWriter(files);
    
        file.write("1,     Hello,    Keith,        3, true");
    
        file.close();
    
        FileReader read = new FileReader(files);
    
        Scanner scan = new Scanner(read);
    
        scan.useDelimiter(", * ");
    
        while ( scan.hasNext()){
        
            if( scan.hasNextInt() ){
            
                System.out.println("Int: " + scan.nextInt() );
            }
        
            else if( scan.hasNextDouble() ){
            
                System.out.println("Double: " + scan.nextDouble() );
            }
            
            else if( scan.hasNextBoolean() ){
            
                System.out.println("Boolean: " + scan.nextBoolean() ) ;
            }
            
            else if( scan.hasNextLine() ){
            
            
                System.out.println("String: " + scan.next() );
            }
            
            else{
                break;
            }
    
        
        }
        
    read.close();
    
    }
        
}   