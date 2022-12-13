import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.TreeSet;


public class Day09{

    public static double getDistance(int x1, int y1, int x2, int y2){
        double dx = Math.abs(x1-x2);
        double dy = Math.abs(y1-y2);
        return Math.sqrt(dx*dx + dy*dy);
    }

    public static void moveHead(Coordinate head, String direction){
        if(direction.equals("R")){
            head.setX(head.getX() + 1);
        } else if(direction.equals("L")){
            head.setX(head.getX() - 1);
        } else if(direction.equals("U")){
            head.setY(head.getY() + 1);
        } else {
            head.setY(head.getY() - 1);
        }
    }

    public static void moveTail(Coordinate head, Coordinate tail){
        double dist = getDistance(head.getX(), head.getY(), tail.getX(), tail.getY());
        if(dist <= 1){
            return;
        } else if(dist <= Math.sqrt(2)){
            return;
        } else if(dist == 2){
            if(head.getX() > tail.getX()){
                tail.setX(tail.getX() + 1);
            }
            else if(head.getX() < tail.getX()){
                tail.setX(tail.getX() - 1);
            } 
            else if(head.getY() > tail.getY()){
                tail.setY(tail.getY() + 1);
            } else {
                tail.setY(tail.getY() - 1);
            }
        } else {
            if(head.getX() - tail.getX() >= 2){
                tail.setX(tail.getX() + 1);
                tail.setY(head.getY());
            }
            else if(head.getX() - tail.getX() <= -2){
                tail.setX(tail.getX() - 1);
                tail.setY(head.getY());
            }
            else if(head.getY() - tail.getY() >= 2){
                tail.setY(tail.getY() + 1);
                tail.setX(head.getX());
            }
            else if(head.getY() - tail.getY() <= -2){
                tail.setY(tail.getY() - 1);
                tail.setX(head.getX());
            } else {
                System.out.println(head + " " + tail);
                System.out.println("BAD");
                Scanner in = new Scanner(System.in);
                in.nextLine();
            }
        }
    }

    public static class Coordinate implements Comparable<Coordinate> {

        private int x;
        private int y;
        public Coordinate(int x, int y){
            this.x = x;
            this.y = y;
        }

        public String toString() {
            return "(" + x +", " + y + ")";
        }
        

        public int compareTo(Coordinate other){
            if(this.x == other.getX() && this.y == other.getY()){
                return 0;
            }

            else if(this.getX() > other.getX()){
                return 1;
            } else if(this.getX() < other.getX()) {
                return -1;
            } else if(this.getY() > other.getY()){
                return 1;
            } else {
                return -1;
            }
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
        Scanner in = new Scanner(new File("input.txt"));
        Coordinate head = new Coordinate(0,0);
        Coordinate tail = new Coordinate(0,0);
        TreeSet<Coordinate> visited = new TreeSet<Coordinate>();
        visited.add(new Coordinate(0,0));
        while(in.hasNext()){
            String[] line = in.nextLine().split(" ");
            int count = Integer.valueOf(line[1]);
            for(int i = 0; i < count; i++){
                if(line[0].equals("R")){
                    head.setX(head.getX() + 1);
                } else if(line[0].equals("L")){
                    head.setX(head.getX() - 1);
                } else if(line[0].equals("U")){
                    head.setY(head.getY() + 1);
                } else {
                    head.setY(head.getY() - 1);
                }
                moveTail(head, tail);
                visited.add(new Coordinate(tail.getX(), tail.getY()));
            }
        }
        System.out.println(visited.size());
        
        
    }

    public static void part2() throws IOException {
        Scanner in = new Scanner(new File("sampleInput2.txt"));
        ArrayList<Coordinate> coordinateList = new ArrayList<Coordinate>();
        for(int i = 0; i < 10; i++){
            coordinateList.add(new Coordinate(0,0));
        }
        TreeSet<Coordinate> visited = new TreeSet<Coordinate>();
        visited.add(new Coordinate(0,0));
        while(in.hasNext()){
            String[] line = in.nextLine().split(" ");
            int count = Integer.valueOf(line[1]);
            for(int i = 0; i < count; i++){
                moveHead(coordinateList.get(0), line[0]);
                for(int j = 0; j < 9; j++){
                    moveTail(coordinateList.get(j), coordinateList.get(j+1));
                }
                
                visited.add(new Coordinate(coordinateList.get(9).getX(), coordinateList.get(9).getY()));
            }
        }
        System.out.println(visited.size());
        //System.out.println(coordinateList);
        //System.out.println(visited);
        //for(Coordinate c : visited){
        //    System.out.println(c.getX() + " " + c.getY());
        //}
    }

    public static void main(String[] args){
        try{
            part2();
        } catch(Exception e){
            System.out.println(e);
        }
    }
}