package it.fox.app.lexer;


import it.fox.app.stateMachineComponents.State;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotSame;

public class StateTest {

    @Test
    public void testEqualStates() {
        State state1 = new State("A");
        State state2 = new State("A");

        assertNotSame(state1, state2);
        assertEquals(state1, state2);
        assertEquals(state1.hashCode(), state2.hashCode());
    }

    @Test
    public void testNotEqualStates() {
        State state1 = new State("A");
        State state2 = new State("B");

        assertNotSame(state1, state2);
        assertNotEquals(state1, state2);
        assertNotEquals(state1.hashCode(), state2.hashCode());
    }
}
