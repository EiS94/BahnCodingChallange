package springboot.entity;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class Betriebsstellen {

    private final Set<Betriebsstelle> betriebsstellenSet;

    private Betriebsstellen(Set<Betriebsstelle> betriebsstellenSet) {
        this.betriebsstellenSet = betriebsstellenSet;
    }

    public static Betriebsstellen createBetriebsstellenFromCsvFile(File csvFile) {
        Set<Betriebsstelle> betriebsstellenSet = new HashSet<>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(csvFile));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] csvValues = line.split(";");
                betriebsstellenSet.add(new Betriebsstelle(csvValues));
            }
        } catch (FileNotFoundException e) {
            System.err.println("FileNotFoundException: File \"" + csvFile.getAbsolutePath() + "\" not found");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (CsvReaderException e) {
            System.err.println(e.getMessage());
        }
        return new Betriebsstellen(betriebsstellenSet);
    }

    public Set<Betriebsstelle> getBetriebsstellenSet() {
        return betriebsstellenSet;
    }
}
