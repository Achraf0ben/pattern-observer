package obs;

import java.util.ArrayList;
import java.util.List;

public class ObservableImpl implements Observable {

    private List<Observer> observers = new ArrayList<>();
    private int state;


    @Override
    public void subscribe(Observer o) {
        observers.add(o);
    }

    @Override
    public void unsubscribe(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer o : observers) {
            o.update(state);
        }
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getState() {
        return state;
    }
}
