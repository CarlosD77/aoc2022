import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.TreeSet;


public class Day09{

    public static class Coordinate {

        private int x;
        private int y;
        public Coordinate(int x, int y){
            this.x = x;
            this.y = y;
        }

        public int getX(){
            return this.x;
        }

        public int getY(){
            return this.y;
        }
        public void setX(int x){
            this.x = x;
        }
        public void setY(int y){
            this.y = y;
        }
    }

    public static void part1() throws IOException {
        Scanner in = new Scanner(new File("sampleInput.txt"));
        Coordinate head = new Coordinate(0,0);
        Coordinate tail = new Coordinate(0,0);
        TreeSet visited = new TreeSet();
        visited.add(head);
        visited.add(tail);
        
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