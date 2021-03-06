package com.p2.simpletest.multitestcase;

import com.p2.simpletest.runner.SimpleTestRunner;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by I335831 on 4/15/2018.
 */
public class SimpleTestRunnerMultipleUnitCaseTest {

    private static SimpleTestRunner testRunner;
    private static String packageName1 = "com.p2.simpletest.testcases.multitest";
    private static String packageName2 = "com.p2.simpletest.testcases.multipassandfail";

    @Test
    public void countNoOfMethodsWithMultiTestCaseAnnotation() throws IllegalAccessException, InvocationTargetException, InstantiationException {
        testRunner = new SimpleTestRunner();
        testRunner.setPackageToBeScanned(packageName1);
        testRunner.runTest();
        Assert.assertEquals(4, testRunner.getTestCount());
    }

    @Test
    public void testAndAssertWithMultiTestCaseAnnotationOnePassOneFail() throws IllegalAccessException, InvocationTargetException, InstantiationException {
        testRunner = new SimpleTestRunner();
        testRunner.setPackageToBeScanned(packageName2);
        testRunner.runTest();
        Assert.assertEquals(2, testRunner.getTestCases().size());
        //Assert.assertEquals(1, testRunner.getPassedTestCases().size());
        Assert.assertEquals(1, testRunner.getFailedTestCases().size());
    }
}
