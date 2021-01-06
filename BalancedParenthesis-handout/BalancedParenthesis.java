import java.util.*;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Author: Roll No: Date:
 */

public class BalancedParenthesis {

    public static boolean checkbalanced(String braces){
        Deque<String> stack = new ArrayDeque<String>();
        for (int i=0;i<braces.length();i++){
            char c= braces.charAt(i);
            if (c=='{' || c=='(' || c=='['){
                stack.push(c+"");
                // break;
            }

            if (stack.isEmpty()){
                // System.out.println("0");
                return false;
            }
            if (c==')'){
                char check = stack.pop().charAt(0);
                if (check == '{' || check == '['){
                    return false;
                }
                // System.out.println("1");
            }
            else if (c=='}'){
                char check = stack.pop().charAt(0);
                if (check == '(' || check == '['){
                    return false;
                }
                // System.out.println("2");
            }
            else if (c==']'){
                char check = stack.pop().charAt(0);
                if (check == '{' || check == '('){
                    return false;
                }
                // System.out.println("3");
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String braces= sc.nextLine();
        // your code goes here
        if (checkbalanced(braces)){
            System.out.println("YES");
        }
        else{
            System.out.println("NO");
        }

        sc.close();
    }
}
