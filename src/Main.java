import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        MinPQProcessor task1Processor = new MinPQProcessor();
        MinPriorityQueue<Job> task1Queue = task1Processor.readTask1IntoPQ("task1-input.txt"); // returns jobQueue
        System.out.println("\nTask 1:");
        task1Processor.printTask1ExecutionOrder(task1Queue);

        MinPQProcessor task2Processor = new MinPQProcessor();
        MinPriorityQueue<PriorityJob> task2Queue = task2Processor.readTask2IntoPQ("task2-input.txt");
        System.out.println("\nTask 2:");
        task2Processor.printTask2ExecutionOrder(task2Queue);

        MinPQProcessor task3Processor = new MinPQProcessor();
        ArrayList<ArrivalJob> task3List = task3Processor.readTask3IntoPQ("task3-input.txt");
        System.out.println("\nTask 3:");
        task3Processor.printTask3ExecutionOrder(task3List);
    }
}
