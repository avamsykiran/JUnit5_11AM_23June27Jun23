package com.cts.junitdemo.suites;

import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

@Suite
@SuiteDisplayName("All Bussiness Logic Test Cases")
@SelectPackages("com.cts.junitdemo.test")
@IncludeTags("bussinessLogic")
public class AllBussinessLogicTestCases {

}
