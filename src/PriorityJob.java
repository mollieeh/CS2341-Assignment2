public class PriorityJob extends BaseJob implements Comparable<PriorityJob> {
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

    public int compareTo(PriorityJob priorityJob) { // how to implement this?
        //super(job);
        if (this.priority < priorityJob.priority) {
            return -1;
        }
        else if (this.priority > priorityJob.priority) {
            return 1;
        }
        else { // if they're equal
            if (this.processTime < priorityJob.processTime) {
                return -1;
            }
            else if (this.processTime > priorityJob.processTime) {
                return 1;
            }
            else {
                return 0;
            }
        }

    }
}


//// how do you know what type it is
//        for (int i = 0; i < 10; i++) { // scan as the priority goes up
//        while (job.jobType == i) { // need to look at all the ones at 1
//        if (this.processTime < job.processTime) {
//        return -1;
//        }
//        else if (this.processTime > job.processTime) {
//        return 1;
//        }
//        else {
//        return 0;
//        }
//        }
//        }
