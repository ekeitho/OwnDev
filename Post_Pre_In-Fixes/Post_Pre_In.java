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
        
        String output = "";
        
        System.out.println("Please enter what kind of notation you'd like to generator your equation to.");
        System.out.print("Postfix, Prefix, or Infix: ");
        
        Scanner scan2 = new Scanner(System.in);
        String notation = scan.nextLine();
        
        if( notation.equals("Postfix") || notation.equals("postfix") ){
        
            while( equation_scan.hasNext() ){
        
                int count = 0;
        
                String s = equation_scan.next();
            
                //if s equals to any of these symbols add them onto the stack
                if( s.equals("/") || s.equals("*") || s.equals("+") || s.equals("-") ||
                        s.equals("(") ){
                    
                    stack.push( s );
                    count++;
                }            
            
            
                else if( s.equals( ")" )){
            
                    while ( ! stack.peek().equals("(")){
                        output += stack.pop();
                    }
                
                    //this will pop of the "(" symbol
                    stack.pop();
                
                    //this will keep track of order of operations
                    //so if something was multiplied or divded to, we need to make sure that
                    //we pop off * or /, to keep track of order of operation
                    if(stack.empty()){
                        //this is called to make sure that java.util.EmptyStackException is not thrown
                    }
                
                    else if( stack.peek().equals("*") || stack.peek().equals("/") ){
                        output = output +stack.pop();
                    }
                
                    count++;
            
                }
        
                else{
                    //this will print any number or letter
                    output = output + s;
                    count=2;      
                }
            
               //the reason behind setting count 2, is if we added a letter and
               //something was added in the stack recently, we need to look into
               //it and see whether or not if what was added in it was a * or /
               //IF * or / was found, pop it, to keep order of operations
               if(!stack.empty() && count ==2){
            
                   if( stack.peek().equals("*") || stack.peek().equals("/") ){
               
                       output = output + stack.pop();
                   }
               }
             
            }
       
            //add on to output with whatever is left on the stack
            if( !stack.empty()){
                while(!stack.empty()){
                    output += stack.pop();
                }
            }

            System.out.println(output);
        }
        
        else if( notation.equals("Prefix") || notation.equals("prefix") ){
        
            System.out.println("This is prefix");
        }
        
        else if( notation.equals("Infix") || notation.equals("infix") ){
        
            System.out.println(equation);
        }
    
    
    
    
    }





}