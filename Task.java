public class Task implements TaskInterface, Comparable<TaskInterface> {

    private int priorityLevel;
    private TaskType taskType;
    private int waitingTime;
    private int hourCreated;
    private String description;

    /**
     * Creates a Stardew valley task with all fields specified.
     * 
     * @param priorityLevel
     * @param taskType
     * @param waitingTime
     * @param hourCreated
     * @param description
     */
    public Task(int priorityLevel, TaskInterface.TaskType taskType, int waitingTime, int hourCreated,
            String description) {
        this.priorityLevel = priorityLevel;
        this.taskType = taskType;
        this.waitingTime = waitingTime;
        this.hourCreated = hourCreated;
        this.description = description;
    }

    /**
     * (non-Javadoc)
     * 
     * @see TaskInterface#getPriority()
     */
    @Override
    public int getPriority() {
        return priorityLevel;
    }

    /**
     * No data validation performed because provided code appears to handle it.
     * 
     * @see TaskInterface#setPriority(int)
     */
    @Override
    public void setPriority(int priority) {
        this.priorityLevel = priority;
    }

    /**
     * (non-Javadoc)
     * 
     * @see TaskInterface#getTaskType()
     */
    @Override
    public TaskInterface.TaskType getTaskType() {
        return this.taskType;
    }

    /**
     * (non-Javadoc)
     * 
     * @see TaskInterface#getTaskDescription()
     */
    @Override
    public String getTaskDescription() {
        return description;
    }

    /**
     * (non-Javadoc)
     * 
     * @see TaskInterface#incrementWaitingTime()
     */
    @Override
    public void incrementWaitingTime() {
        this.waitingTime++;
    }

    /**
     * (non-Javadoc)
     * 
     * @see TaskInterface#resetWaitingTime()
     */
    @Override
    public void resetWaitingTime() {
        this.waitingTime = 0;
    }

    /**
     * (non-Javadoc)
     * 
     * @see TaskInterface#getWaitingTime()
     */
    @Override
    public int getWaitingTime() {
        return this.waitingTime;
    }

    /**
     * 
     * A Task is bigger than another Task if its priority is higher. If the priority
     * of two Task objects is the same, then the Task with an earlier (smaller) hour
     * created is considered bigger.
     * 
     * @see java.lang.Comparable#compareTo(java.lang.Object)
     */
    @Override
    public int compareTo(TaskInterface o) {
        TaskInterface otherObject = (TaskInterface) o;
        if (priorityLevel > otherObject.getPriority()) {
            return 1;
        } else if (priorityLevel < otherObject.getPriority()) {
            return -1;
        } else {
            // need to use time as a tiebreaker
            return (hourCreated < otherObject.getPriority()) ? 1 : -1;
        }
    }

}
