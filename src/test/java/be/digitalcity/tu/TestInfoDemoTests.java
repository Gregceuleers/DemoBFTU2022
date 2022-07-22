package be.digitalcity.tu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

public class TestInfoDemoTests {

    private Logger logger = Logger.getLogger(TestInfoDemoTests.class.getName());

    static List<Integer> integers = Arrays.asList(1,2,3,4,5,6,7,8,9);

    @BeforeEach
    void beforeEachTest(TestInfo testInfo, RepetitionInfo repetitionInfo) {
        logger.info(String.format("Répétition %d / %d pour %s",
                repetitionInfo.getCurrentRepetition(),
                repetitionInfo.getTotalRepetitions(),
                testInfo.getTestMethod().get().getName()));
    }

    @RepeatedTest(value = 9)
    void repeatTest() {

    }


}
