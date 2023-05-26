/*
package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.time.Duration;

public class DriverManager {

    private static WebDriver getChromeDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.setImplicitWaitTimeout(Duration.ofSeconds(15));
        options.setPageLoadTimeout(Duration.ofSeconds(15));
        return new ChromeDriver(options);
    }

    private static WebDriver getFirefoxDriver() {
        return null;
    }

    private static WebDriver getEdgeDriver() {
        return null;
    }

    public static WebDriver getDriver(Config config) {
        return switch (config != null ? config : Config.CHROME) {
            case CHROME -> getChromeDriver();
            case FF -> getFirefoxDriver();
            case EDGE -> getEdgeDriver();
        };
    }
}
*/
