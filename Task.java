public class Task {
    private String subject;
    private String description;
    private String deadline;

    public Task(String subject, String description, String deadline) {
        this.subject = subject;
        this.description = description;
        this.deadline = deadline;
    }

    public String toFileString() {
        return subject + "|" + description + "|" + deadline;
    }

    public static Task fromFileString(String line) {
        String[] parts = line.split("\\|");
        return new Task(parts[0], parts[1], parts[2]);
    }

    @Override
    public String toString() {
        return "Subject: " + subject +
               ", Task: " + description +
               ", Deadline: " + deadline;
    }
}