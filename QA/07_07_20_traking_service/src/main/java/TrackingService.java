
import java.util.ArrayList;
import java.util.List;

public class TrackingService {

    private static final String NUMBER_IS_NEGATIVE_MESSAGE = "number is negative";
    private int total;

    private int goal;
    private int historyId;
    private List<HistoryItem> history = new ArrayList();

    public void addCalories(int amount) {
//        if (amount < 0)
//            throw new NumberFormatException(NUMBER_IS_NEGATIVE_MESSAGE);

        total += amount;

        history.add(new HistoryItem(++historyId, amount, "add", total));
    }

    public void removeCalories(int amount) {
//        if (amount < 0)
//            throw new NumberFormatException(NUMBER_IS_NEGATIVE_MESSAGE);

        total -= amount;

        if (total < 0)
            total = 0;

        history.add(new HistoryItem(++historyId, amount, "add", total));
//        history.add(new HistoryItem(++historyId, amount, "remove", total));
    }

    public boolean isGoalMe() {
        return total >= goal;
    }

    public int getTotal() {
        return total;
    }

    public int getGoal() {
        return goal;
    }

    public void setGoal(int goal) {
        this.goal = goal;
    }

    public List<HistoryItem> getHistory() {
        return history;
    }
}
