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
    public void isNotCaseSensitive() throws Exception {
        assertThat(queryProcessor.process("shakespeare"), containsString("playwright"));
    }

    @Test
    public void plusNumber() throws Exception {
        String actualQuery = "39a6cd50: what is 9 plus 11";
        assertThat(queryProcessor.process(actualQuery), containsString("20"));
    }

    @Test
    public void largestNumber() throws Exception {
        String actualQuery = "04d10d80: which of the following numbers is the largest: 98, 684, 927, 83";
        assertThat(queryProcessor.process(actualQuery), containsString("927"));
    }
}
