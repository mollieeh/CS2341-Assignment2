public class ArrivalProcessJob extends BaseJob implements Comparable<ArrivalProcessJob> {
    protected int arrival;

    public ArrivalProcessJob(String jobData) {
        super(jobData);
        String[] jobAttributes = jobData.split(" ");
        try {
            this.arrival = Integer.parseInt(jobAttributes[2]);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    // converts arrivalJob to ArrivalProcessJob (another job type)
    // for the purpose of comparing based off process time
    public ArrivalProcessJob(ArrivalJob arrivalJob) {
        super(arrivalJob.jobID, arrivalJob.processTime);
        this.arrival = arrivalJob.arrival;
    }

    public int getArrival() {
        return arrival;
    }

    public int compareTo(ArrivalProcessJob arrivalProcessJob) {
        if (this.processTime < arrivalProcessJob.processTime) {
            return -1;
        }
        else if (this.processTime > arrivalProcessJob.processTime) {
            return 1;
        }
        else {
            return 0;
        }
    }
}

