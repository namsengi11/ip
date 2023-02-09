public class Event extends Task {
    private String startDate;
    private String endDate;

    public Event(String content, String startDate, String endDate) {
        super(content);
        this.startDate = startDate;
        this.endDate = endDate;
    }

    static Event createEvent(String[] commandByWord) throws IllegalArgumentException, ArrayIndexOutOfBoundsException {

        if (commandByWord.length < 2) {
            throw new IllegalArgumentException();
        }

        int index = 1;
        String taskToDo = "";
        String startDate = "";
        String endDate = "";

        // traverse array until /from is found
        while (commandByWord[index].charAt(0) != '/') {
            // add space between words
            if (index != 1) {
                taskToDo += " ";
            }

            taskToDo += commandByWord[index];
            ++index;
        }
        ++index; // move past the /from
        int indexOfFrom = index;

        while (commandByWord[index].charAt(0) != '/') {
            if (index != indexOfFrom) {
                startDate += " ";
            }

            startDate += commandByWord[index];
            ++index;
        }

        for (int i = index + 1; i < commandByWord.length; ++i) {
            // add space between words
            if (i != index + 1) {
                endDate += " ";
            }
            endDate += commandByWord[i];
        }

        return new Event(taskToDo, startDate, endDate);
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + " (from: " + this.startDate + " to: " + this.endDate + ")";
    }
}
