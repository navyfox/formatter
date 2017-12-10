package it.fox.app.lexer.implementation;

import it.fox.app.lexer.IStateTransitionsLexer;

import java.util.HashMap;
import java.util.Map;

public class StateTransitionsLexer implements IStateTransitionsLexer {

    private final Map<Pair<StateLexer, Character>, StateLexer> states = new HashMap<>();

    public StateTransitionsLexer() {
        states.put(new Pair<>(new StateLexer("default"), ' '), new StateLexer("spacing"));
        states.put(new Pair<>(new StateLexer("spacing"), ' '), new StateLexer("spacing"));
    }

    @Override
    public StateLexer getNextState(final StateLexer state, char c) {
        StateLexer nextState = states.get(new Pair<>(state, c));
        if (nextState == null) {
            nextState = states.get(new Pair<>(state, (Character)null));
        }
        return nextState;
    }
}
