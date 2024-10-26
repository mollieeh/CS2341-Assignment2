public class Job {
    private int jobID, processTime;

    public Job(String jobData) {
        String[] jobAttributes = jobData.split(" ");
        try {
            this.jobID = Integer.parseInt(jobAttributes[0]);
            this.processTime = Integer.parseInt(jobAttributes[1]);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }
    public int getJobID() {
        return jobID;
    }
    public int getProcessTime() {
        return processTime;
    }
}
