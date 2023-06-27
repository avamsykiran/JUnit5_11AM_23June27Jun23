package com.cts.junitdemo.suites;

import org.junit.platform.suite.api.ExcludeTags;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

@Suite
@SuiteDisplayName("All But Validation Logic Test Cases")
@SelectPackages("com.cts.junitdemo.test")
@ExcludeTags("validationLogic")
public class AllButValidationLogicTestCases {

}
