import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MinPQProcessor {

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
                PriorityJob jobObject = new PriorityJob(jobInfo);
                jobQueue.insert(jobObject);
            }
            return jobQueue; // returns the jobQueue
        } catch (FileNotFoundException e) {
            System.out.println("Error occurred while reading File");
            e.printStackTrace();
            return null;
        }
    }
    public ArrayList<ArrivalJob> readTask3IntoPQ(String fileName) {
        int jobsCompleted = 0;
        ArrayList<ArrivalJob> jobExecutionOrder = new ArrayList<ArrivalJob>();
        try {
            File jobData = new File(fileName);
            Scanner scannerCap = new Scanner(jobData);
            Scanner scannerLines = new Scanner(jobData);
            int jobAmount = 0;
            while(scannerCap.hasNextLine()) {
                jobAmount++;
                scannerCap.nextLine();
            }

            //initialize and load all jobs into Array of incoming jobs
            ArrayList<ArrivalJob> incomingJobs = new ArrayList<ArrivalJob>();
            while(scannerLines.hasNextLine()) {
                String jobInfo = scannerLines.nextLine();
                ArrivalJob jobObject = new ArrivalJob(jobInfo); // create a job for task 1
                incomingJobs.add(jobObject);
            }

            MinPriorityQueue<ArrivalJob> jobQueue = new MinPriorityQueue<ArrivalJob>(jobAmount);
            int currTime = 0, currProcessTime = 0;

            while(!(jobsCompleted==jobAmount)) {
                for (ArrivalJob incomingJob : incomingJobs) { // check arrival of objects withing the queue
                    if (incomingJob.getArrival() == currTime) {
                        jobQueue.insert(incomingJob);// put into PQ
                    }
                }

                if (currProcessTime == 0 && !(jobsCompleted==jobAmount)) {
                    currProcessTime = jobQueue.readMin().getProcessTime();
                    jobExecutionOrder.add(jobQueue.readMin()); // when you print it out do .getJobID
                    ArrivalJob deletedJob = jobQueue.delMin();
                    jobsCompleted++;
                }
                currTime++;
                currProcessTime--;
            }
            return jobExecutionOrder; // returns the jobQueue

        } catch (FileNotFoundException e) {
            System.out.println("Error occurred while reading File");
            e.printStackTrace();
            return null;
        }
    }

    // PRINT OUT EACH TASK: 1, 2
    public void printTask1ExecutionOrder(MinPriorityQueue<Job> jobQueue){
        ArrayList<Integer> jobEndingTimes = new ArrayList<Integer>();
        int sum = 0, averageProcTimeOfEachJob = 0, count = 0;
        System.out.print("Execution order: [");
        while (!jobQueue.isEmpty()) {
            Job deletedMin = jobQueue.delMin();
            System.out.print(deletedMin.getJobID() + ", ");
            sum += deletedMin.getProcessTime();
            jobEndingTimes.add(sum);
            count++;
        }
        int sumOfJobCompletionTime = 0;
        for (Integer endingtime : jobEndingTimes) {
            sumOfJobCompletionTime += endingtime;
        }
        System.out.print("]");
        averageProcTimeOfEachJob = sum / count;
        System.out.println("\nAverage Completion Time: " + sumOfJobCompletionTime/count + "   (Of All Jobs After All Jobs Finished Processing)");
        System.out.println("Average Completion Time (for individual jobs): " + averageProcTimeOfEachJob);
    }

    public void printTask2ExecutionOrder(MinPriorityQueue<PriorityJob> jobQueue){
        ArrayList<Integer> jobEndingTimes = new ArrayList<Integer>();
        int sum = 0, count = 0;
        System.out.print("Execution order: [");
        while (!jobQueue.isEmpty()) {
            PriorityJob deletedMin = jobQueue.delMin();
            System.out.print(deletedMin.getJobID() + ", ");
            sum += deletedMin.getProcessTime();
            jobEndingTimes.add(sum);
            count++;
        }
        System.out.print("]");

        // AVERAGES
        int sumOfJobCompletionTime = 0;
        for (Integer endingtime : jobEndingTimes) {
            sumOfJobCompletionTime += endingtime;
        }
        System.out.println("\nAverage Completion Time: " + sumOfJobCompletionTime/count + "   (Of All Jobs After All Jobs Finished Processing)");
        System.out.println("Average Completion Time (for individual jobs): " + sum/count);
    }

    public void printTask3ExecutionOrder(ArrayList<ArrivalJob> orderedJobs){
        ArrayList<Integer> jobEndingTimes = new ArrayList<Integer>();
        int sum = 0, count =0;
        System.out.print("Execution Order: [");
        for (ArrivalJob job : orderedJobs) {
            System.out.print(job.getJobID() + ", ");
            sum +=  job.getProcessTime();
            jobEndingTimes.add(sum);
            count++;
        }
        System.out.print("]");

        // AVERAGES
        int sumOfJobCompletionTime = 0;
        for (Integer endingtime : jobEndingTimes) {
            sumOfJobCompletionTime += endingtime;
        }
        System.out.println("\nAverage Completion Time: " + sumOfJobCompletionTime/count + "   (Of All Jobs After All Jobs Finished Processing)");
        System.out.println("Average Completion Time (for individual jobs): " + sum/count + "\n");
    }
}
