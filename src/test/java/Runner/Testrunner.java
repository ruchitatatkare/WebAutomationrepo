package Runner;


import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.DataProvider;


@CucumberOptions (features = "src/test/resource/feactures",
        glue = {"org.example.stepdefine"},
        plugin={"pretty","html:target/cucumber-reports" ,"json:target/cucumber.json"},
        monochrome =true)

public class Testrunner extends AbstractTestNGCucumberTests {
     @Override
    @DataProvider(parallel = true)
    public Object[][] Scenario(){
                return super.scenarios();
            }
}
