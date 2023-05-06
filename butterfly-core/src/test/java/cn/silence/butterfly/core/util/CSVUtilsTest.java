package cn.silence.butterfly.core.util;

import org.junit.jupiter.api.Test;

import static cn.silence.butterfly.core.util.CSVUtils.DEFAULT_QUOTE;
import static cn.silence.butterfly.core.util.CSVUtils.DEFAULT_SEPARATOR;

/**
 * @author rainofsilence
 * @version 1.0.0
 * @since 2023/05/06 22:32:50
 */
class CSVUtilsTest {

    @Test
    void test() {
        System.out.println("test start\n==>");
        CSVUtils.parseLine("A,B,C").forEach(System.out::println);
        System.out.println("==>");
        CSVUtils.parseLine("A,B,,C").forEach(System.out::println);
        System.out.println("==>");
        CSVUtils.parseLine("A,B,C,").forEach(System.out::println);
        System.out.println("==>");
        CSVUtils.parseLine(",A,B,C").forEach(System.out::println);
    }

    @Test
    void testSeparator() {
        System.out.println("testSeparator start\n==>");
        CSVUtils.parseLine("A,B,C", DEFAULT_SEPARATOR).forEach(System.out::println);
        System.out.println("==>");
        CSVUtils.parseLine("A,B,,C", DEFAULT_SEPARATOR).forEach(System.out::println);
        System.out.println("==>");
        CSVUtils.parseLine("A,B,C,", DEFAULT_SEPARATOR).forEach(System.out::println);
        System.out.println("==>");
        CSVUtils.parseLine(",A,B,C", DEFAULT_SEPARATOR).forEach(System.out::println);
    }

    @Test
    void testSeparatorAndQuote() {
        System.out.println("testSeparatorAndQuote start\n==>");
        CSVUtils.parseLine("'A','B','C'", DEFAULT_SEPARATOR, '\'').forEach(System.out::println);
        System.out.println("==>");
        CSVUtils.parseLine("'A',,'B','C'", DEFAULT_SEPARATOR, '\'').forEach(System.out::println);
        System.out.println("==>");
        CSVUtils.parseLine("'A','B','C',", DEFAULT_SEPARATOR, '\'').forEach(System.out::println);
        System.out.println("==>");
        CSVUtils.parseLine("'A','B','C',", DEFAULT_SEPARATOR, '\'').forEach(System.out::println);

        System.out.println("==>");
        CSVUtils.parseLine("\"A\",\"B\",\"C\",", DEFAULT_SEPARATOR, DEFAULT_QUOTE).forEach(System.out::println);
    }
}