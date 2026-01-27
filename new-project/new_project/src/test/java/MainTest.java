import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
public class MainTest {
    @Test
    public void testGetUserNameNoEnv () {
        var userNameOpt = Main.getUserName("NON_EXISTENT_ENV_VAR");
        assertTrue(userNameOpt.isEmpty());
    }

    @Test
    public void testGetUserNameWithEnv () {
        var originalValue = System.getenv("USER");
        var userNameOpt = Main.getUserName("USER");
        assertTrue(userNameOpt.isPresent() && userNameOpt.get().equals(originalValue));
    }
    @Test
    public void testGetGreetingNoEnv () {
        var greeting = Main.getGreeting("NON_EXISTENT_ENV_VAR");
        assertTrue(greeting.equals("Hello, Guest"));
    }
    @Test
    public void testGetGreetingWithEnv () {
        var originalValue = System.getenv("USER");
        var greeting = Main.getGreeting("USER");
        assertTrue(greeting.equals("Hello, " + originalValue));
    }

}
