import java.util.*;

public class Post_Pre_In{


    public static void main(String[] args){
    
        Stack<String> stack = new Stack<String>();
    
    
        System.out.println("Please enter an algebraic equation that you would like to generate a fixation out of.");
        System.out.println("Please leave spaces inbetween every symbol and character.");
        System.out.println("Such as: ( A + B ) - D * ( C + D )");
        
        Scanner scan = new Scanner(System.in);
        String equation = scan.nextLine();        
        Scanner equation_scan = new Scanner(equation).useDelimiter(" ");
        
        while( equation_scan.hasNext() ){
        
            String s = equation_scan.next();
            
            if( s.equals("/") || s.equals("*") || s.equals("+") || s.equals("-") ||
                    s.equals("(") || s.equals(")")){
                    
                stack.push( s );
            }
        
            else{
                
                System.out.print(s);
            }
            
        }
        
        stack.pop();
        System.out.print( stack );
        
        
        
            
        /*System.out.println("Please enter what kind of notation you'd like to generator your equation to.");
        System.out.print("Postfix, Prefix, or Infix: ");
        
        Scanner scan2 = new Scanner(System.in);
        String notation = scan.nextLine();
        
        if( notation.equals("Postfix") || notation.equals("postfix") ){
        
            System.out.println("This is postfix");
        }
        
        else if( notation.equals("Prefix") || notation.equals("prefix") ){
        
            System.out.println("This is prefix");
        }
        
        else if( notation.equals("Infix") || notation.equals("infix") ){
        
            System.out.println("This is infix");
        }*/
    
    
    
    
    }





}