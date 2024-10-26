import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PriorityQueueProcessor {
    public PriorityQueue<Integer> readIntoPQ(String fileName) {
        try {
            PriorityQueue<Integer> jobQueue = new PriorityQueue<Integer>(10); // setting cap at 10 for now
            File jobData = new File(fileName);
            Scanner scanner = new Scanner(jobData);
            scanner.nextLine();
            while(scanner.hasNextLine()) {
                String jobInfo = scanner.nextLine();

                //jobQueue.insert(jobInfo);
            }
            return jobQueue; // returns the jobQueue as a priority queue

        } catch (FileNotFoundException e) {
            System.out.println("Error occurred while reading File");
            e.printStackTrace();
            return null;
        }

    }
}
