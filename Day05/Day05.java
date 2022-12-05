import java.util.Scanner;
import java.io.File;
import java.io.IOException;
public class Day05{
    public static void part1() throws IOException {
        Scanner in = new Scanner(new File("sampleInput.txt"));
        for(int i = 0; i < 10; i++){
            System.out.println(in.next());
        }
        
    }

    public static void part2() throws IOException {

    }

    public static void main(String[] args){
        try {
            part1();
        } catch(Exception e){
            System.out.println(e);
        }
    }
}