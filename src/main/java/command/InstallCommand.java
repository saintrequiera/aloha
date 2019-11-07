package main.java.command;

import main.java.Component;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * InstallCommand.java
 * Install a main.component and those on which it depends if possible
 */
public class InstallCommand implements Command {
    @Override
    public Map<String, Object> process(List<String> items) {
        Map<String, Object> result = new LinkedHashMap<>();
        String componentName = items.get(0);
        Component component = Component.getInstance(componentName);
        install(component, result);

        return result;
    }

    private Map<String, Object> install(Component component, Map<String, Object> result) {
        if (component.isInstalled()) {
            //Nothing to do, main.component is already installed
            result.put(component.getName(), "is already installed");
        } else {
            component.setInstalled(true);

            // Install the dependencies of the main.component
            for (Component dependency : component.getDependencies()) {
                install(dependency, result);
            }
            result.put("Installing", component.getName());
        }
        return result;
    }
}
