import java.util.Scanner;
import java.io.File;

public class Day01 {

    private final static String DATA_FILE = "input.txt";

    public static void part1() {
        Scanner in;
        try{
            in = new Scanner(new File(DATA_FILE));
        } catch(Exception e) {
            System.out.println(e);
            return;
        }

        int largest = 0;
        while(in.hasNext()){
            String line = in.nextLine();
            int calories = 0;
            // get total calories not separated by a space
            while(in.hasNext() && !line.equals("")){
                calories += Integer.parseInt(line);
                line = in.nextLine();
                
            }
            if(calories > largest){
                largest = calories;
            }


        }
        System.out.println(largest);
        
    }


    public static void part2() {
        
    }

    public static void main(String[] args) {
        part1();
    }



}