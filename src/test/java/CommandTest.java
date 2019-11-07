package test.java;

import main.java.Component;
import main.java.Solution;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class CommandTest {

    @Before
    public void reset() {
        Component.getAll().clear();
    }

    @Test
    public void testInstall() throws Exception {
        String[] input = {
                "DEPEND TELNET TCPIP NETCARD",
                "INSTALL TELNET",
                "END",
        };

        Solution.doIt(input);

        Set<Component> expected = new HashSet<Component>(Arrays.asList(Component.getInstance("NETCARD"), Component.getInstance("TCPIP"), Component.getInstance("TELNET")));
        assertEquals(expected, Component.getInstalled());
    }

}
