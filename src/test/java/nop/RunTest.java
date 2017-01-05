package nop;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = ".", tags = "@smoke", plugin =
        // {"pretty","html:target/report.html","json:target/report.json"},dryRun = false, strict = false)
        {"pretty","html:target/whisper-html-report", "json:target/whisper_report.json"})

public class RunTest {

}
