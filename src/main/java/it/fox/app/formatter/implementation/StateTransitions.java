package it.fox.app.formatter.implementation;

import com.sun.tools.javac.util.Pair;
import it.fox.app.formatter.IStateTransitions;
import it.fox.app.lexer.IToken;
import it.fox.app.stateMachineComponents.State;

import java.util.HashMap;
import java.util.Map;

/**
 * The class map defining transitions between states
 */
public class StateTransitions implements IStateTransitions {

    private final Map<Pair<State, String>, State> transitions = new HashMap<>();

    /**
     * The map state transitions for formatter
     */
    StateTransitions() {
        transitions.put(new Pair<>(new State("default"), "char"), new State("default"));
        transitions.put(new Pair<>(new State("default"), "semicolon"), new State("linestart"));
        transitions.put(new Pair<>(new State("linestart"), "newline"), new State("linestart"));
        transitions.put(new Pair<>(new State("linestart"), "space"), new State("linestart"));
        transitions.put(new Pair<>(new State("linestart"), "char"), new State("default"));
        transitions.put(new Pair<>(new State("default"), "openbracket"), new State("default"));
        transitions.put(new Pair<>(new State("default"), "closebracket"), new State("default"));
        transitions.put(new Pair<>(new State("default"), "space"), new State("default"));
        transitions.put(new Pair<>(new State("default"), "newline"), new State("default"));
    }

    @Override
    public State getNextSate(final State state, final IToken token) {
        State nextState = transitions.get(new Pair<>(state, token.getName()));
        if (nextState == null) {
            nextState = transitions.get(new Pair<>(state, (String) null));
        }
        return nextState;
    }
}
