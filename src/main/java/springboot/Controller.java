package springboot;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springboot.entity.Betriebsstelle;
import springboot.entity.Betriebsstellen;

import javax.annotation.PostConstruct;
import java.io.File;

@RestController
public class Controller {

    Betriebsstellen betriebsstellen;

    @PostConstruct
    public void initialize() {
        File csvFile = new File("src/resources/DBNetz-Betriebsstellenverzeichnis-Stand2021-10.csv");
        betriebsstellen = Betriebsstellen.createBetriebsstellenFromCsvFile(csvFile);
    }

    @RequestMapping("/")
    public String index() {
        return "Rest-API for DBNetz-Betriebsstellenverzeichnis";
    }

    @RequestMapping("/betriebsstelle/{shortname}")
    public String betriebsstelle(@PathVariable String shortname) {
        for (Betriebsstelle betriebsstelle : betriebsstellen.getBetriebsstellenSet()) {
            if (betriebsstelle.getRlCode().equals(shortname.toLowerCase())) {
                return betriebsstelle.toJson();
            }
        }
        return "Error: No Betriebsstelle found with shortcut \"" + shortname + "\"";
    }

}
