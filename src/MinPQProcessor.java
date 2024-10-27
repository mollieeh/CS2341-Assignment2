import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MinPQProcessor {
    public MinPriorityQueue<Job> readIntoPQ(String fileName) {
        // setting cap at 10 for now
        try {
            File jobData = new File(fileName);
            Scanner scannerCap = new Scanner(jobData);
            Scanner scannerLines = new Scanner(jobData);
            int jobAmount = 0;
            while(scannerCap.hasNextLine()) {
                jobAmount++;
                scannerCap.nextLine();
            }
            MinPriorityQueue<Job> jobQueue = new MinPriorityQueue<Job>(jobAmount);
            while(scannerLines.hasNextLine()) {
                String jobInfo = scannerLines.nextLine();
                Job jobObject = new Job(jobInfo);
                jobQueue.insert(jobObject);
            }
            return jobQueue; // returns the jobQueue
        } catch (FileNotFoundException e) {
            System.out.println("Error occurred while reading File");
            e.printStackTrace();
            return null;
        }
    }
//
//    public MinPriorityQueue<Job> createExecutionOrder(MinPriorityQueue<Job> jobQueue) {
//        MinPriorityQueue<Job> jobOrder = new MinPriorityQueue<Job>();
//        while (!jobQueue.isEmpty()) {
//            jobOrder.insert(jobQueue.delMin());
//        }
//    }

    // - "Execution Order: [first job completed index, next...]"
    public void printExecutionOrder(MinPriorityQueue<Job> jobQueue){
        System.out.print("Execution order: [");
        while (!jobQueue.isEmpty()) {
            System.out.print(jobQueue.delMin().getJobID() + ", ");
        }
        System.out.print("]");
    }

    public void printAvgCompletionTime() {
        // - "Average completion time: " 9 (for example)
    }
}
