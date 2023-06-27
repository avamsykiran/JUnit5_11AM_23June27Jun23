package com.cts.junitdemo.suites;

import org.junit.platform.suite.api.ExcludePackages;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

@Suite
@SuiteDisplayName("All Service Test Cases")
@SelectPackages("com.cts.junitdemo.test")
@ExcludePackages("com.cts.junitdemo.test.repo")
public class AllServiceTestCases {

}
