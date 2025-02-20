/*
package MyTestRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/AppFeatures"},
        glue = {"stepdefinitions", "AppHooks"},
        plugin = {"pretty",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        }

)
public class MyTestRunner {

}
*/

package MyTestRunner;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import java.lang.reflect.Method;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = {"src/test/resources/AppFeatures"}, // Specify the path to your feature files
        glue = {"stepdefinitions","AppHooks"}, // Specify your step definitions and hooks packages
        plugin = {"pretty",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "rerun:target/failedrerun.txt"
        }
        //tags = "@Login"


)
public class MyTestRunner extends AbstractTestNGCucumberTests {
        // This class will enable parallel execution automatically if TestNG is configured to run tests in parallel
        @BeforeMethod
        public void beforeMethod(Method method) {
            System.out.println( Thread.currentThread().getId() + " is running method: " + method.getName());
        }

        @Override
        @DataProvider(parallel = true)
        public Object[][] scenarios() {
                return super.scenarios();
        }
// added a comment

// added a comment 2

// added a comment from github portal


}
