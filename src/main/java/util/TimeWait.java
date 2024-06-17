package util;


import net.thucydides.model.environment.SystemEnvironmentVariables;
import net.thucydides.model.util.EnvironmentVariables;


public class TimeWait {
    private static final EnvironmentVariables variables = SystemEnvironmentVariables.createEnvironmentVariables();
    private static final String TIME_IMPLICIT_WAIT = "webdriver.wait.for.timeout";
    public static final String TIME_DEFAULT = "25000";

    private TimeWait() {
        throw new IllegalStateException("Clase Utilitaria");
    }

    public static int waitImplicitSeconds() {
        return getTimeInSeconds(TIME_IMPLICIT_WAIT);
    }

    private static int getTimeInSeconds(String attribute) {
        String time = variables.getProperty(attribute) == null ? TIME_DEFAULT : variables.getProperty(attribute);
        return Integer.parseInt(time) / 1000;
    }

}
