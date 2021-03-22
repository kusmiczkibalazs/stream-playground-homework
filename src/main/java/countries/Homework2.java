package countries;

import java.io.IOException;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static java.util.stream.Collectors.*;

import java.time.ZoneId;

import static countries.MyMethods.*;

public class Homework2 {

    private List<Country> countries;

    public Homework2() {
        countries = new CountryRepository().getAll();
    }

    /**
     * Returns the longest country name translation.
     */
    public Optional<String> streamPipeline1() {
        return countries.stream()
                .flatMap(c -> c.getTranslations().values().stream())
                .max(Comparator.comparing(c -> c.length()));
    }

    /**
     * Returns the longest Italian (i.e., {@code "it"}) country name translation.
     */
    public Optional<String> streamPipeline2() {
        return countries.stream()
                .filter(c -> c.getTranslations().get("it") != null)
                .map(c -> c.getTranslations().get("it"))
                .max(Comparator.comparing(c -> c.length()));
    }

    /**
     * Prints the longest country name translation together with its language code in the form language=translation.
     */
    public void streamPipeline3() {
        // TODO
    }

    /**
     * Prints single word country names (i.e., country names that do not contain any space characters).
     */
    public void streamPipeline4() {
        countries.stream()
                .filter(c -> !c.getName().contains(" "))
                .map(c -> c.getName())
                .forEach(System.out::println);
    }

    /**
     * Returns the country name with the most number of words.
     */
    public Optional<String> streamPipeline5() {
        return countries.stream()
                .map(c -> c.getName())
                .max(Comparator.comparingInt(c -> c.split(" ").length));
    }

    /**
     * Returns whether there exists at least one capital that is a palindrome.
     */
    public boolean streamPipeline6() {
        return countries.stream()
                .map(c -> c.getCapital())
                .filter(c -> !c.equals(""))
                .anyMatch(c -> c.toLowerCase().equals(new StringBuilder(c.toLowerCase()).reverse().toString()));
    }

    /**
     * Returns the country name with the most number of {@code 'e'} characters ignoring case.
     */
    public Optional<String> streamPipeline7() {
        return countries.stream()
                .map(c -> c.getName())
                .max(Comparator.comparing(c -> charCount(c.toLowerCase(),'e')));
    }

    /**
     *  Returns the capital with the most number of English vowels (i.e., {@code 'a'}, {@code 'e'}, {@code 'i'}, {@code 'o'}, {@code 'u'}).
     */
    public Optional<String> streamPipeline8() {
        return countries.stream()
                .map(c -> c.getCapital())
                .max(Comparator.comparing(c -> vowelCount(c.toLowerCase()))); // A feladat nem kérte külön a toLowerCase
        // ()-t.
    }

    /**
     * Returns a map that contains for each character the number of occurrences in country names ignoring case.
     */
    public Map<Character, Long> streamPipeline9() {
        return countries.stream()
                .map(c -> c.getName())
                .flatMap(c -> c.toLowerCase().chars().mapToObj(i -> (char) i))
                .collect(groupingBy(c -> c, counting()));
    }

    /**
     * Returns a map that contains the number of countries for each possible timezone.
     */
    public Map<ZoneId, Long> streamPipeline10() {
        return countries.stream()
                .flatMap(c -> c.getTimezones().stream())
                .collect(groupingBy(c -> c, counting()));
    }

    /**
     * Returns the number of country names by region that starts with their two-letter country code ignoring case.
     */
    public Map<Region, Long> streamPipeline11() {
        // TODO
        return null;
    }

    /**
     * Returns a map that contains the number of countries whose population is greater or equal than the population average versus the the number of number of countries with population below the average.
     */
    public Map<Boolean, Long> streamPipeline12() {
        // TODO
        return null;
    }

    /**
     * Returns a map that contains for each country code the name of the corresponding country in Portuguese ({@code "pt"}).
     */
    public Map<String, String> streamPipeline13() {
        // TODO
        return null;
    }

    /**
     * Returns the list of capitals by region whose name is the same is the same as the name of their country.
     */
    public Map<Region, List<String>> streamPipeline14() {
        // TODO
        return null;
    }

    /**
     *  Returns a map of country name-population density pairs.
     */
    public Map<Region, Double> streamPipeline15() {
        // TODO
        return null;
    }

}
