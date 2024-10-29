public class Job extends BaseJob implements Comparable<Job> {
    // implements Comparable<Job>

    public Job(String jobData) {
        super(jobData);
    }

    public int compareTo(Job job) {
        if (this.processTime < job.processTime) {
            return -1;
        }
        else if (this.processTime > job.processTime) {
            return 1;
        }
        else {
            return 0;
        }
    }

}
