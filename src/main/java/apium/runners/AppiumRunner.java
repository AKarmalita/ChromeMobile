package apium.runners;

import apium.config.AppiumDriverConfig;
import apium.steps.BaseAppiumSteps;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/main/java/apium/features/Main.feature",
        glue = "apium.steps",
        tags = "@MainPageFeature",
        dryRun = false,
        snippets = CucumberOptions.SnippetType.CAMELCASE)

public class AppiumRunner {
    @BeforeClass
    public static void start() {
        BaseAppiumSteps.driver = AppiumDriverConfig.initAndroidChrome();

    }

    @AfterClass
    public static void end() throws InterruptedException {
       Thread.sleep(10000);
       BaseAppiumSteps.driver.close();
        }
    }

