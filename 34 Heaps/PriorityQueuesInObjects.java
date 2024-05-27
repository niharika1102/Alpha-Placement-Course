import java.util.*;

public class PriorityQueuesInObjects {
    static class Student implements Comparable<Student> {    //Comparable interface is used to compare two objects of a class
        String name;
        int rank;

        public Student(String name, int rank) {
            this.name = name;
            this.rank = rank;
        }

        @Override    //method overriding
        public int compareTo(Student s2) {     //Comparison based on rank
            return this.rank - s2.rank;
        }
    }
    public static void main(String[] args) {
        PriorityQueue<Student> pq = new PriorityQueue<>();

        pq.add(new Student("A", 5));
        pq.add(new Student("B", 2));
        pq.add(new Student("C", 1));
        pq.add(new Student("D", 60));
        pq.add(new Student("E", 9));

        while(!pq.isEmpty()) {
            System.out.println(pq.peek().name + "," + pq.peek().rank);
            pq.remove();
        }
    }
}
