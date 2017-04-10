import java.io.*;

/**
 * Created by Taron on 04/10/17.
 */
public class Contact {

    TimeZone timeZone = new TimeZone();
    Country country = new Country();

    public void addTimeZone() throws FileNotFoundException {
        timeZone.createTimeZones();
        country.createCountry();
        for (int i = 0; i < timeZone.timeZoneArrayList.size(); i++){
            for (int j = 0; j < country.countries.size(); j++){
                if(timeZone.timeZoneArrayList.get(i).getCountryCode().equals(country.countries.get(j).getCountryCode()))
                    country.countries.get(j).setTimeZone(timeZone.timeZoneArrayList.get(i).getTimeZone());
            }
        }
    }

    public void printInConsole(){
        for (Country element : country.countries)
            System.out.println(element);
    }

    public void writeInFile() throws IOException {
        FileWriter fileWriter = new FileWriter("D:\\projects\\CountryTimeZone\\src\\writeHere.csv");
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        for (Country element : country.countries){
            bufferedWriter.write(String.format("%d, %s, %s, %s",element.getId(),element.getCountryCode(),element.getEnglishName(),element.getTimeZone()));
            bufferedWriter.write("\n");
        }

    }

    public void start() throws IOException {
        addTimeZone();
        printInConsole();
        writeInFile();
    }


}
