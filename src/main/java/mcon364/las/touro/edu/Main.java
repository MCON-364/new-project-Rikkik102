import java.util.Optional;

public class Main{
    public static void main(String[] args){

    }

    public static Optional<String> getUserName(String envVariable) {
        System.getenv(envVariable);
        return Optional.ofNullable(envVariable);
    }

    public static String getGreeting(String envVarName){
        Optional<String> greeting = getUserName(envVarName);


    }
}