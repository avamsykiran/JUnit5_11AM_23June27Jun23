package com.cts.junitdemo.suites;

import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

@Suite
@SuiteDisplayName("All Test Cases")
@SelectPackages("com.cts.junitdemo.test")
public class AllTestCases {

}
