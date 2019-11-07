package main.java;

import java.util.*;

/**
 * Component.class
 * Define a main.component
 */
public class Component {

    protected static Map<String, Component> dependencyMap = new HashMap<String, Component>();

    private String name; // Name of the main.component
    private Set<Component> dependencies =  new HashSet<Component>(); // dependencies of a main.component
    private Set<Component> dependents = new HashSet<Component>(); // dependents of a main.component

    private boolean installed;

    /**
     * Instantiate a new main.component
     * @param name of the main.component
     */
    private Component(String name) {
        this.name = name;
    }

    public static Component getInstance(String name){
        Component component = dependencyMap.get(name);
        if (component == null) {
            component = new Component(name);
            dependencyMap.put(name, component);
        }
        return component;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addDependency(Component component) {
        dependencies.add(component);
    }

    public Set<Component> getDependencies() {
        return dependencies;
    }

    public boolean hadDependencies() {
        return !dependencies.isEmpty();
    }

    public Set<Component> getDependents() {
        return dependents;
    }

    public boolean hasDependents() {
        return !dependents.isEmpty();
    }

    public void setInstalled(boolean installed) {
        this.installed = installed;
    }

    public boolean isInstalled() {
        return installed;
    }

    public static Set<Component> getInstalled() {
        Set<Component> installed = new HashSet<Component>();
        for (Component component : dependencyMap.values()) {
            if (component.isInstalled())
                installed.add(component);
        }
        return installed;
    }

    public static Collection<Component> getAll() {
        return dependencyMap.values();
    }
}
