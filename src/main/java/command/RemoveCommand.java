package main.java.command;


import main.java.Component;

import java.util.*;

/**
 * RemoveCommand.class
 * Implement a remove main.component.command
 * Remove a component and those on which it depends if possible
 */
public class RemoveCommand implements Command {
    @Override
    public Map<String, Object> process(List<String> items) {
        Map<String, Object> result = new HashMap<>();
        String componentName = items.get(0);
        Component component = Component.getInstance(componentName);
        if (component.isInstalled()) {
            return remove(component);
        }
        result.put(componentName, "is not installed");
        return result;
    }

    private Map<String, Object> remove(Component component) {
        Map<String, Object> result = new HashMap<>();

        // Get all installed dependents of the main.component
        Set<Component> installedDependents = new HashSet<Component>();
        for(Component dependent: component.getDependents()) {
            if (dependent.isInstalled()) {
                installedDependents.add(dependent);
            }
        }
        // if the main.component is not need for other components, remove it
        if (installedDependents.isEmpty()) {
            component.setInstalled(false);
            result.put(component.getName(), "is uninstalled");

            // Try to remove all dependencies of the main.component
            for (Component dependency: component.getDependencies()) {
                if (dependency.isInstalled()){
                    result.putAll(remove(dependency));
                }
            }
        }
         else {
            // at least one main.component needs this main.component, we can't remove it
            result.put(component.getName(), "is still needed");
         }

         return result;
    }
}
