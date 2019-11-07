package main.java;


import main.java.command.*;
import java.util.*;

public class Solution {

    /*
     * Complete the function below.
     */

    private static Map<String, Command> COMMANDS = new HashMap<>();
    static {
        COMMANDS.put("DEPEND", new DependCommand());
        COMMANDS.put("INSTALL", new InstallCommand());
        COMMANDS.put("REMOVE", new RemoveCommand());
        COMMANDS.put("LIST", new ListCommand());
    }

    public static void doIt(String[] input) {
        for (String s:input) {
            List<String> items = new LinkedList<String>(Arrays.asList(s.split(" ")));
            String commandName = items.get(0);
            if(commandName == "END") {
                System.out.println("END");
                break;
            }
            Command command = COMMANDS.get(commandName);
            items.remove(0); //Remove the command from items
            Map<String, Object> success = command.process(items);
            success.entrySet().stream().forEach(e -> System.out.println(e.getKey() + " " + e.getValue()));
        }
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        int _input_size = 0;
        _input_size = Integer.parseInt(in.nextLine().trim());
        String[] _input = new String[_input_size];
        String _input_item;
        for(int _input_i = 0; _input_i < _input_size; _input_i++) {
            try {
                _input_item = in.nextLine();
            } catch (Exception e) {
                _input_item = null;
            }
            _input[_input_i] = _input_item;
        }

        doIt(_input);

    }
}
