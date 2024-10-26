public class ArrivalJob extends Job {
    private int arrival;

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
}
