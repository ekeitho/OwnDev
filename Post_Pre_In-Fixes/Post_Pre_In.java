import java.util.*;

public class Post_Pre_In{


    public static void main(String[] args){
    
        Stack<String> stack = new Stack<String>();
        
        //Used for Prefix Notation only since it's data structure
        //allows me to add items first or last, in which in this case I chose to add items
        //to the beginning of the list to allow a easier loop to print the linked list
        LinkedList<String> linked = new LinkedList<String>();
        
        System.out.println("\nPlease enter what kind of notation you'd like to generator your equation to.");
        System.out.print("Postfix, Prefix, or Infix: ");
        
        Scanner scan2 = new Scanner(System.in);
        String notation = scan2.nextLine();

        System.out.println("Please enter the algebraic equation that you would like to generate a fixation out of.");
        System.out.println("Supports expressions such as, (A+B)*(C-D), but"+ 
            " won't work for multiple parantheses such as, A*(B(C+D)).");
        
        Scanner scan = new Scanner(System.in);
        String equation = scan.nextLine();  
        
        String output = "";
        
        
        
        if( notation.equals("Postfix") || notation.equals("postfix") ){    
        
            Scanner equation_scan = new Scanner(equation).useDelimiter("\\s*");
                
            while( equation_scan.hasNext() ){        
                boolean seen = false;        
                String s = equation_scan.next();
            
                //if s equals to any of these symbols add them onto the stack
                if( s.equals("/") || s.equals("*") || s.equals("+") || s.equals("-") ||
                        s.equals("(") ){                    
                    stack.push( s );
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
                }
        
                else{
                    //this will print any number or letter
                    output = output + s;
                    seen = true;      
                }
            
               //the reason behind setting seen is true, is if we added a letter and
               //something was added in the stack recently, we need to look into
               //it and see whether or not if what was added in it was a * or /
               //IF * or / was found, pop it, to keep order of operations
               //Then have to check whether the next peek is - or + 
               if(!stack.empty() && seen){            
                   if( stack.peek().equals("*") || stack.peek().equals("/") ){               
                       output += stack.pop();
                       
                       if(stack.empty()){
                       
                       }
                       
                       else if(stack.peek().equals("-") || stack.peek().equals("+")){
                           output += stack.pop();
                       }
                   }
               }             
            }
       
            //add on to output with whatever is left on the stack(A+B)*(C-D)
            if( !stack.empty()){
                while(!stack.empty()){
                    output += stack.pop();
                }
            }
            
            System.out.println("\n" + "Postfix Notation: " + output);
        }
        
        else if( notation.equals("Prefix") || notation.equals("prefix") ){  
        
            //Needed to reverse the string so that I could use similar code as
            //postfix, but in this case the operators are on the left of the operands
            String backwards = new StringBuilder(equation).reverse().toString();
            Scanner equation_scan = new Scanner(backwards).useDelimiter("\\s*");
              
            while( equation_scan.hasNext() ){        
                    boolean seen = false;        
                    String s = equation_scan.next();

                    if( s.equals("/") || s.equals("*") || s.equals("+") || s.equals("-") ||
                            s.equals(")") ){                    
                        stack.push( s );
                    }                        
                
                    else if( s.equals( "(" )){            
                        while ( ! stack.peek().equals(")")){
                            linked.addFirst( stack.pop());  
                        }
                        stack.pop();               
                    }
            
                    else{
                        linked.addFirst( s);
                        seen = true;      
                    }

                   if(!stack.empty() && seen){            
                       if( stack.peek().equals("*") || stack.peek().equals("/") ){               
                           linked.addFirst( stack.pop() );
                       }
                   }             
                }
        
                if( !stack.empty()){
                    while(!stack.empty()){
                        linked.addFirst( stack.pop() );
                    }
                }
                
                for(int i=0; i< linked.size(); i++){                
                    output += linked.get(i)+"";
                }
                
                System.out.println("\n" + "Prefix Notation: " + output );
            }
    
            
            else if( notation.equals("Infix") || notation.equals("infix") ){
                //this prints whatever was entered
                //this shoud make sense why if not, check out:
                //http://givemeacscjob.tumblr.com/post/52611623786/prefix-infix-and-postfix-notation
                System.out.println(equation);
            }   
    }   
}                           