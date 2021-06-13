
package Petmodule.Petmodule;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(plugin = { "pretty","json:target/cucumber.json","junit:target/cucumber-reports/Cucumber.xml",
"html:target/cucumber-reports" }
, features = "src/test/java/features/"
,glue={"StepDefinitions"},monochrome = true)

public class AppTest extends AbstractTestNGCucumberTests {
}