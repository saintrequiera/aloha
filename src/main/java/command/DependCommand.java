package main.java.command;


import main.java.Component;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * Depend main.component.command
 * component1 depends on component2, component3, ...
 */
public class DependCommand implements Command {
    @Override
    public Map<String, Object> process(List<String> items) {
        String componentName = items.get(0);

        Component component = Component.getInstance(componentName);
        // for each item, add a dependency to the main.component
        for(String dependencyName: items.subList(1, items.size())) {
            Component dependency = Component.getInstance(dependencyName);
            component.addDependency(dependency);
        }
        return Collections.emptyMap();
    }
}
