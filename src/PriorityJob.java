public class PriorityJob extends Job{
    private int priority;

    public PriorityJob(String jobData) {
        super(jobData);
        String[] jobAttributes = jobData.split(" ");
        try {
            this.priority = Integer.parseInt(jobAttributes[2]);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    public int getPriority() {
        return priority;
    }
}
