package it.fox.app.stateMachineComponents;

/**
 * State of finite state machines
 */
public final class State {

    private final String name;

    /**
     * @param name name state
     */
    public State(final String name) {
        this.name = name;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        State that = (State) o;

        return name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public String toString() {
        return "State{" +
                "name='" + name + '\'' +
                '}';
    }
}
