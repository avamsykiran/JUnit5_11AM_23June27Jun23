package com.cts.junitdemo.suites;

import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

@Suite
@SuiteDisplayName("All Repo Test Cases")
@SelectPackages("com.cts.junitdemo.test.repo")
public class AllRepoTestCases {

}
