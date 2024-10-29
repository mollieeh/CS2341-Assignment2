public abstract class BaseJob {
    protected int jobID, processTime;
    public BaseJob(String jobData) {
        String[] jobAttributes = jobData.split(" ");
        try {
            this.jobID = Integer.parseInt(jobAttributes[0]);
            this.processTime = Integer.parseInt(jobAttributes[1]);

        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }
    public BaseJob(int jobID, int processTime) {
        this.jobID = jobID;
        this.processTime = processTime;
    }
    public int getJobID() {
        return jobID;
    }
    public int getProcessTime() {
        return processTime;
    }
}
