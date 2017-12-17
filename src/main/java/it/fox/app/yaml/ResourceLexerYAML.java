package it.fox.app.yaml;

import it.fox.app.App;
import it.fox.app.lexerCommand.ICommandLexer;
import it.fox.app.lexer.implementation.CommandRepositoryLexer;
import it.fox.app.lexer.implementation.StateTransitionsLexer;
import it.fox.app.stateMachineComponents.State;
import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

/**
 *
 */
public class ResourceLexerYAML {

    static final String COMMAND_PACKAGE = "it.fox.app.lexerCommand.implementation";
    public static CommandRepositoryLexer commands;

    public ResourceLexerYAML() throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        commands = new CommandRepositoryLexer();
        InputStream file = App.class.getResourceAsStream("/lexerCommand.yaml");
        Yaml yaml = new Yaml();
        List statesDefs = (List) yaml.load(file);
        for(Object stateDefObject : statesDefs) {
            Map stateDef = (Map) stateDefObject;
            String stateName = stateDef.get("state").toString();
            List actionsDefs = (List) stateDef.get("actions");
            for (Object actionDefObject : actionsDefs) {
                Map actionDef = (Map) actionDefObject;
                Object input1 = actionDef.get("input");
//                wtf??? magic) don't touch otherwise wil not work
                Character input;
                if (input1 == null) {
                    input = null;
                } else {
                    input = input1.toString().charAt(0);
                }
                String command = actionDef.get("command").toString();
                String state = actionDef.get("state").toString();

                commands.put(new State(stateName), input, createCommand(command));
            }
        }
    }

    public ICommandLexer createCommand(final String className) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        String fullName = COMMAND_PACKAGE + "." + className;
        ICommandLexer commandLexer = (ICommandLexer) Class.forName(fullName).newInstance();
        return commandLexer;
    }
}