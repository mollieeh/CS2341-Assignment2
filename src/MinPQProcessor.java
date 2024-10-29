import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MinPQProcessor {
    // READ TASK INTO PRIORITY QUEUE: 1, 2, 3
    public MinPriorityQueue<Job> readTask1IntoPQ(String fileName) {

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
                Job jobObject = new Job(jobInfo); // create a job for task 1
                jobQueue.insert(jobObject);
            }

            return jobQueue; // returns the jobQueue
        } catch (FileNotFoundException e) {
            System.out.println("Error occurred while reading File");
            e.printStackTrace();
            return null;
        }

    }
    public MinPriorityQueue<PriorityJob> readTask2IntoPQ(String fileName) {
        try {
            File jobData = new File(fileName);
            Scanner scannerCap = new Scanner(jobData);
            Scanner scannerLines = new Scanner(jobData);
            int jobAmount = 0; //size of the queue
            while(scannerCap.hasNextLine()) {
                jobAmount++;
                scannerCap.nextLine();
            }
            MinPriorityQueue<PriorityJob> jobQueue = new MinPriorityQueue<PriorityJob>(jobAmount);
            while(scannerLines.hasNextLine()) {
                String jobInfo = scannerLines.nextLine();
                PriorityJob jobObject = new PriorityJob(jobInfo); // create a job for task 1
                jobQueue.insert(jobObject);
            }
            return jobQueue; // returns the jobQueue
        } catch (FileNotFoundException e) {
            System.out.println("Error occurred while reading File");
            e.printStackTrace();
            return null;
        }
    }
    public MinPriorityQueue<ArrivalJob> readTask3IntoPQ(String fileName) {
        try {
            File jobData = new File(fileName);
            Scanner scannerCap = new Scanner(jobData);
            Scanner scannerLines = new Scanner(jobData);
            int jobAmount = 0; //size of the queue
            while(scannerCap.hasNextLine()) {
                jobAmount++;
                scannerCap.nextLine();
            }

            // all the jobs sorted by arrival time
            MinPriorityQueue<ArrivalJob> allArrivalJobsQueue = new MinPriorityQueue<ArrivalJob>(jobAmount);
            while(scannerLines.hasNextLine()) {
                String jobInfo = scannerLines.nextLine();
                ArrivalJob jobObject = new ArrivalJob(jobInfo); // create a job for task 1
                allArrivalJobsQueue.insert(jobObject);
            }
            System.out.println("\nTask 3: ");
            System.out.print("Execution Order: [");
            int clock = 0;
            MinPriorityQueue<ArrivalProcessJob> ArrivedJobs = new MinPriorityQueue<ArrivalProcessJob>(jobAmount);
            ArrivalJob firstJob = allArrivalJobsQueue.delMin();
            System.out.print(firstJob.getJobID() + ", ");
            int nextJobEndingTime = firstJob.getProcessTime();

            while (!allArrivalJobsQueue.isEmpty()) {
                clock++;
                // only want to delMin if arrivalJob
                ArrivalJob nextJobInQueue = allArrivalJobsQueue.readMin();
                if (nextJobInQueue.getArrival() == clock) {
                    ArrivalJob nextArrivalJob = allArrivalJobsQueue.delMin();
                    ArrivalProcessJob arrivalProcessJob = new ArrivalProcessJob(nextArrivalJob);
                    ArrivedJobs.insert(arrivalProcessJob);
                }
                if (clock >= nextJobEndingTime && !ArrivedJobs.isEmpty()) {
                    ArrivalProcessJob nextJobToRun = ArrivedJobs.delMin();
                    nextJobEndingTime = clock + nextJobToRun.getProcessTime();
                    System.out.print(nextJobToRun.getJobID() + ", ");
                }
            }
            System.out.print("]");

            return allArrivalJobsQueue; // returns the jobQueue


        } catch (FileNotFoundException e) {
            System.out.println("Error occurred while reading File");
            e.printStackTrace();
            return null;
        }
    }

    // PRINT OUT EACH TASK: 1, 2
    public void printTask1ExecutionOrder(MinPriorityQueue<Job> jobQueue){
        int sum = 0, average = 0, count = 0;
        System.out.print("Execution order: [");
        while (!jobQueue.isEmpty()) {
            Job deletedMin = jobQueue.delMin();
            System.out.print(deletedMin.getJobID() + ", ");
            sum += deletedMin.getProcessTime();
            count++;
        }
        System.out.print("]");
        average = sum/count;
        System.out.println("\nAverage Completion Time: " + average);
    }
    public void printTask2ExecutionOrder(MinPriorityQueue<PriorityJob> jobQueue){
        int sum = 0, average = 0, count = 0;
        System.out.print("Execution order: [");
        while (!jobQueue.isEmpty()) {
            PriorityJob deletedMin = jobQueue.delMin();
            System.out.print(deletedMin.getJobID() + ", ");
            sum += deletedMin.getProcessTime();
            count++;
        }
        System.out.print("]");
        average = sum/count;
        System.out.println("\nAverage Completion Time: " + average);
    }
//    public void printTask3ExecutionOrder(MinPriorityQueue<ArrivalJob> jobQueue){
//        int sum = 0, average = 0, count = 0, clock = 0;
//        System.out.print("Execution order: [");
//        while (!jobQueue.isEmpty()) {
//            // deletes the minimum processing time from the queue
//
//            ArrivalJob deletedMin = jobQueue.delMin();
//            System.out.print(deletedMin.getJobID() + ", ");
//            sum += deletedMin.getProcessTime();
//            count++;
//        }
//        System.out.print("]");
//        //average = sum/count;
//        System.out.println("\nAverage Completion Time: " + average);
//    }
}
