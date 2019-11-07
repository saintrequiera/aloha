package main.java.command;

import java.util.List;
import java.util.Map;

/**
 * Command.java
 * Interface class that define the process a main.component.command with a list of items
 */

public interface Command {

    /**
     * Process a main.component.command
     * @param items a list of items
     */
    Map<String, Object> process(List<String> items);
}
