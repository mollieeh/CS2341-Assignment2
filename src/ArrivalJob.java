public class ArrivalJob extends BaseJob implements Comparable<ArrivalJob> {
    protected int arrival;

    public ArrivalJob(String jobData) {
        super(jobData);
        String[] jobAttributes = jobData.split(" ");
        try {
            this.arrival = Integer.parseInt(jobAttributes[2]);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    public int getArrival() {
        return arrival;
    }


    public int compareTo(ArrivalJob arrivalJob) {
        if (this.processTime < arrivalJob.processTime) {
            return -1;
        }
        else if (this.processTime > arrivalJob.processTime) {
            return 1;
        }
        else {
            return 0;
        }
    }
}

