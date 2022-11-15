package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith; // Junit tercih etmemizin sebebi RunnerWith notasyonudur.


@RunWith(Cucumber.class) // bu notasyon sayesinde TestRunner classi calisma ozelligi kazanir.
@CucumberOptions(

        plugin={"html:target/cucumber-reports.html",
                "json:target/json-reports/cucumber.json",
                "junit:target/xml-report/cucumber.xml" },
        features = "src/test/resources/features",
        glue = "stepdefinitions",
        tags ="@a",
        dryRun =false
        // dryRun true yazarsak sadece eksik adimlati bize bildirir.
        //calistirmadan eksik adimlar varmi bunu kontrol eder sadece calismadan. ve bu cok kisa surer
)

public class TestRunner {
}
