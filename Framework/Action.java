package Framework;

public abstract class Action {
    public abstract void faire();
    public abstract void faire(String value);
}

abstract class ActionWithValue extends Action {
    public void faire() {};
    public abstract void faire(String value);
}

abstract class ActionWithoutValue extends Action {
    public abstract void faire();
    public void faire(String value){};
}