package it.fox.app.lexer.implementation;

import it.fox.app.lexer.IStateTransitionsLexer;
import it.fox.app.stateMachineComponents.Pair;
import it.fox.app.stateMachineComponents.State;

import java.util.HashMap;
import java.util.Map;

/**
 * The class map defining transitions between states
 */
public class StateTransitionsLexer implements IStateTransitionsLexer {

    private final Map<Pair<State, Character>, State> states = new HashMap<>();

    /**
     * The map state transitions for lexer
     */
    public StateTransitionsLexer() {
//        states = new HashMap<>();
        states.put(new Pair<>(new State("default"), ' '), new State("spacing"));
        states.put(new Pair<>(new State("spacing"), ' '), new State("spacing"));
    }

    @Override
    public State getNextState(final State state, final char c) {
        State nextState = states.get(new Pair<>(state, c));
        if (nextState == null) {
            nextState = states.get(new Pair<>(state, (Character) null));
        }
        return nextState;
    }

    /**
     *
     * @param state
     * @param input
     * @param newState
     */
    public void put(final State state, final Character input, final State newState) {
        states.put(new Pair<>(state, input), newState);
    }
}
