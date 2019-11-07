package main.java.command;

import main.java.Component;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * ListCommand.java
 * List installed components
 */
public class ListCommand implements Command {
    @Override
    public Map<String, Object> process(List<String> items) {
        Map<String, Object> result = new LinkedHashMap<String, Object>();
        Component.getInstalled().forEach(m -> result.put(m.getName(),""));
        return result;
    }

}
