import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.util.Stack;
import java.util.ArrayList;
public class Day05{
    public static void part1() throws IOException {
        Scanner in = new Scanner(new File("input.txt"));
        Stack<String> stack1 = new Stack<String>();
        Stack<String> stack2 = new Stack<String>();
        Stack<String> stack3 = new Stack<String>();
        Stack<String> stack4 = new Stack<String>();
        Stack<String> stack5 = new Stack<String>();
        Stack<String> stack6 = new Stack<String>();
        Stack<String> stack7 = new Stack<String>();
        Stack<String> stack8 = new Stack<String>();
        Stack<String> stack9 = new Stack<String>();
        ArrayList<Stack> stackList = new ArrayList<Stack>();
        stackList.add(stack1);
        stackList.add(stack2);
        stackList.add(stack3);
        stackList.add(stack4);
        stackList.add(stack5);
        stackList.add(stack6);
        stackList.add(stack7);
        stackList.add(stack8);
        stackList.add(stack9);

        stack1.push("R");
        stack1.push("P");
        stack1.push("C");
        stack1.push("D");
        stack1.push("B");
        stack1.push("G");

        stack2.push("H");
        stack2.push("V");
        stack2.push("G");

        stack3.push("N");
        stack3.push("S");
        stack3.push("Q");
        stack3.push("D");
        stack3.push("J");
        stack3.push("P");
        stack3.push("M");

        stack4.push("P");
        stack4.push("S");
        stack4.push("L");
        stack4.push("G");
        stack4.push("D");
        stack4.push("C");
        stack4.push("N");
        stack4.push("M");

        stack5.push("J");
        stack5.push("B");
        stack5.push("N");
        stack5.push("C");
        stack5.push("P");
        stack5.push("F");
        stack5.push("L");
        stack5.push("S");

        stack6.push("Q");
        stack6.push("B");
        stack6.push("D");
        stack6.push("Z");
        stack6.push("V");
        stack6.push("G");
        stack6.push("T");
        stack6.push("S");

        stack7.push("B");
        stack7.push("Z");
        stack7.push("M");
        stack7.push("H");
        stack7.push("F");
        stack7.push("T");
        stack7.push("Q");

        stack8.push("C");
        stack8.push("M");
        stack8.push("D");
        stack8.push("B");
        stack8.push("F");

        stack9.push("F");
        stack9.push("C");
        stack9.push("Q");
        stack9.push("G");

        for(int i = 0; i < 10; i++){
            in.nextLine();
        }
        
        
        while(in.hasNext()){
            String[] line = in.nextLine().split(" ");
            int moving = Integer.parseInt(line[1]);
            int from = Integer.parseInt(line[3]);
            int to = Integer.parseInt(line[5]);
            for(int i = 0; i < moving; i++){
                stackList.get(to-1).push(stackList.get(from-1).pop());
            }
            
            
        }
        
        for(int i = 0; i < stackList.size(); i++){
            System.out.print(stackList.get(i).pop());
        }

        
    }

    public static void part2() throws IOException {
        Scanner in = new Scanner(new File("input.txt"));
        Stack<String> stack1 = new Stack<String>();
        Stack<String> stack2 = new Stack<String>();
        Stack<String> stack3 = new Stack<String>();
        Stack<String> stack4 = new Stack<String>();
        Stack<String> stack5 = new Stack<String>();
        Stack<String> stack6 = new Stack<String>();
        Stack<String> stack7 = new Stack<String>();
        Stack<String> stack8 = new Stack<String>();
        Stack<String> stack9 = new Stack<String>();
        ArrayList<Stack> stackList = new ArrayList<Stack>();
        stackList.add(stack1);
        stackList.add(stack2);
        stackList.add(stack3);
        stackList.add(stack4);
        stackList.add(stack5);
        stackList.add(stack6);
        stackList.add(stack7);
        stackList.add(stack8);
        stackList.add(stack9);

        stack1.push("R");
        stack1.push("P");
        stack1.push("C");
        stack1.push("D");
        stack1.push("B");
        stack1.push("G");

        stack2.push("H");
        stack2.push("V");
        stack2.push("G");

        stack3.push("N");
        stack3.push("S");
        stack3.push("Q");
        stack3.push("D");
        stack3.push("J");
        stack3.push("P");
        stack3.push("M");

        stack4.push("P");
        stack4.push("S");
        stack4.push("L");
        stack4.push("G");
        stack4.push("D");
        stack4.push("C");
        stack4.push("N");
        stack4.push("M");

        stack5.push("J");
        stack5.push("B");
        stack5.push("N");
        stack5.push("C");
        stack5.push("P");
        stack5.push("F");
        stack5.push("L");
        stack5.push("S");

        stack6.push("Q");
        stack6.push("B");
        stack6.push("D");
        stack6.push("Z");
        stack6.push("V");
        stack6.push("G");
        stack6.push("T");
        stack6.push("S");

        stack7.push("B");
        stack7.push("Z");
        stack7.push("M");
        stack7.push("H");
        stack7.push("F");
        stack7.push("T");
        stack7.push("Q");

        stack8.push("C");
        stack8.push("M");
        stack8.push("D");
        stack8.push("B");
        stack8.push("F");

        stack9.push("F");
        stack9.push("C");
        stack9.push("Q");
        stack9.push("G");

        for(int i = 0; i < 10; i++){
            in.nextLine();
        }
        
        
        while(in.hasNext()){
            String[] line = in.nextLine().split(" ");
            int moving = Integer.parseInt(line[1]);
            int from = Integer.parseInt(line[3]);
            int to = Integer.parseInt(line[5]);
            Stack<String> temp = new Stack<String>();
            for(int i = 0; i < moving; i++){
                String let = String.valueOf(stackList.get(from-1).pop());
                temp.push(let);
            }
            for(int i = 0; i < moving; i++){
                stackList.get(to-1).push(temp.pop());
            }
            
            
        }
        
        for(int i = 0; i < stackList.size(); i++){
            System.out.print(stackList.get(i).pop());
        }
    }

    public static void main(String[] args){
        try {
            part2();
        } catch(Exception e){
            System.out.println(e);
        }
    }
}