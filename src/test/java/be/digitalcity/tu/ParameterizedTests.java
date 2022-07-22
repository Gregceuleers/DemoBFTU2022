package be.digitalcity.tu;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class ParameterizedTests {

    enum JourSemaine {
        LUNDI,
        MARDI,
        MERCREDI,
        JEUDI
    }

    @ParameterizedTest
    @ValueSource(strings = {"lundi", "mardi", "mercredi", "jeudi"})
    void estPresentDanEnum(String jour) {
        assertNotNull(JourSemaine.valueOf(jour.toUpperCase()));
    }

    @ParameterizedTest
    @EnumSource(JourSemaine.class)
    void estPresent(JourSemaine jour) {
        assertNotNull(jour);
    }

    @ParameterizedTest
    @EnumSource(names = {"LUNDI", "JEUDI"})
    void estInclusDansEnum(JourSemaine jour) {
        assertTrue(EnumSet.of(JourSemaine.LUNDI, JourSemaine.JEUDI).contains(jour));
    }

    @ParameterizedTest
    @MethodSource("fournisseur2")
    void estInjecteParMethode(String args) {
        assertTrue(args.endsWith("e"));
    }
    static Stream<String> fournisseur() {
        return Stream.of("pomme", "poire", "banane");
    }
    static List<String> fournisseur2() {
        return Arrays.asList("pomme", "poire");
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/jours.csv", delimiterString = "|", numLinesToSkip = 1)
    void testAvecInjectionViaFichier(String jour, int index) {
        assertNotNull(jour);
        assertNotEquals(-1, index);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/jours.csv", delimiterString = "|", numLinesToSkip = 1)
    void testAvecInjectionViaFichierAvecObjet(ArgumentsAccessor args) {
        Jour j = new Jour();
        j.setName(args.getString(0));
        j.setIndex(args.getInteger(1));
        assertNotNull(j.getName());
        assertNotEquals(-1, j.getIndex());
    }

    static class Jour {
        private String name;
        private int index;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }
    }
}
