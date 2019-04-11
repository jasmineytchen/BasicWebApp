package com.develogical;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class QueryProcessorTest {

    QueryProcessor queryProcessor = new QueryProcessor();

    @Test
    public void returnsEmptyStringIfCannotProcessQuery() throws Exception {
        assertThat(queryProcessor.process("test"), is(""));
    }

    @Test
    public void knowsAboutShakespeare() throws Exception {
        assertThat(queryProcessor.process("Shakespeare"), containsString("playwright"));
    }

    @Test
    public void knowsAboutName() throws Exception {
        assertThat(queryProcessor.process("name"), containsString("mexico-bandido"));
    }

    @Test
    public void knowsAboutBanana() throws Exception {
        assertThat(queryProcessor.process("banana"), containsString("yellow"));
    }

    @Test
    public void knowsAboutEiffel() throws Exception {
        String actualQuery = "44385080: which city is the Eiffel tower in";
        assertThat(queryProcessor.process(actualQuery), containsString("Paris"));
    }


    @Test
    public void isNotCaseSensitive() throws Exception {
        assertThat(queryProcessor.process("shakespeare"), containsString("playwright"));
    }

    @Test
    public void plusNumber() throws Exception {
        String actualQuery = "39a6cd50: what is 9 plus 11";
        assertThat(queryProcessor.process(actualQuery), containsString("20"));
    }
    @Test
    public void multiplyNumber() throws Exception {
        String actualQuery = "16b2d5d0: what is 10 multiplied by 5";
        assertThat(queryProcessor.process(actualQuery), containsString("50"));
    }

    @Test
    public void largestNumber() throws Exception {
        String actualQuery = "490b2c00: which of the following numbers is the largest: 96, 46, 586, 790";
        assertThat(queryProcessor.process(actualQuery), containsString("790"));
    }

    @Test
    public void squreAndCubeNumber() throws Exception {
        String actualQuery = "999bd690: which of the following numbers is both a square and a cube: 729, 34, 503, 1000000";
        assertThat(queryProcessor.process(actualQuery), containsString("729"));
    }

    @Test
    public void primeNumber() throws Exception {
        String actualQuery = "de873070: which of the following numbers are primes: 29, 41, 718, 733";
        assertThat(queryProcessor.process(actualQuery), containsString("29"));
    }

}
