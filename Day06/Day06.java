import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class Day06 {
    public static void part1() throws IOException {
        Scanner in = new Scanner(new File("input.txt"));
        String line = in.nextLine();
        int count = 0;
        boolean notFound = true;
        while(notFound){
            notFound = false;
            String test = line.substring(count, count+14);
            for(int i = 0; i < test.length()-1; i++){
                for(int j = i+1; j < test.length();j++){
                    if(test.substring(i, i+1).equals(test.substring(j,j+1))){
                        notFound = true;
                    }
                }
            }
            count++;
        }
        System.out.println(count + 13);
    }

    public static void part2() throws IOException {

    }

    public static void main(String[] args){
        try{
            part1();
        } catch(Exception e){
            System.out.println(e);
        }
    }
}