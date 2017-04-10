import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Taron on 04/10/17.
 */
public class Country {
    public int id;
    public String countryCode;
    public String englishName;
    public String franchName;
    public String timeZone;

    ArrayList<Country> countries;

    public Country() {
        countries = new ArrayList<>();
    }

    public Country(int id, String countryCode, String englishName, String franchName) {
        this.id = id;
        this.countryCode = countryCode;
        this.englishName = englishName;
        this.franchName = franchName;
        countries = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEnglishName() {
        return englishName;
    }

    public void setEnglishName(String englishName) {
        this.englishName = englishName;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    public void createCountry() throws FileNotFoundException {
        int idNumber = 0;
        Scanner scanner = new Scanner(new File("D:\\projects\\CountryTimeZone\\src\\countryes.csv"));
        while (scanner.hasNext()){
            String[] strings = scanner.nextLine().split(",");
            for (int i = 0;i < strings.length; i++){
                for (int j = 0;j < strings[i].length(); j++){
                    if(strings[i].charAt(j) == '"') {
                        strings[i] = strings[i].replace('"',' ').trim();
                    }
                }
            }
            countries.add(new Country(idNumber++,strings[0],strings[1],strings[2]));
        }
    }

    @Override
    public String toString() {
        return String.format("Country id: %d, countryCode: %s, englishName: %s, time zone: %s.",id,countryCode,englishName,timeZone);
    }
}
