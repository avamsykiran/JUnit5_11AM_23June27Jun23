JUnit 5
--------------------------------------------------------------------------------------------------

Aspects Of Testing
1. Functional
2. Non Functional

Types of testing
1. White Box Testing          Non Functional Testing    performence tuning, test the code coverage and execution paths.  
2. Black Box Testing          Functional Testing        for a given input do we get an expected result.
3. Grey Box Teting            Non Functional Testing    identifing vulnerabilities, layering where
                                                        simualted known attacks are made and the resutls are analyzed.
4. Smoke Test                 Functional Testing        

Test Executions
1. Manual
2. Automated

Testing Levels
1. Unit Testing
2. Integration Testing
3. System Testing
4. Component Testing
5. QAT (Quality Assurence Testing)
    5.1. Regresssion Testing
    5.2. Performence Testing
6. UAT (User Acceptence Testing)

Unit Testing

    A unit refers to a single block or component in a software system, like function for OP based and class for OOP based
    system.

    As far as Java is concerned- A class is a Unit.

    Unit Testing referes to testing all the operations (methods) belonging to a class being tested.

    Unit Testing classes having dependency is carreid over through Mock Testing / Stub Testing.

Integration Testing

    is where a unit is tested after integrating it with all of its dependencies.

    JUnit is used for automated Unit Testing and Integration Testing.

    Lab Setup
    --------------------------------------
        Eclipse IDE for JavaEE
        JDK 1.8
        Maven 3.x
        MySQL

  
    JUnit 5 Components
    ---------------------------------------
        1. Testing API          jupiter api
        2. Testing Engine       junit-jupiter
        3. Vintage Support      junit vintage
        4. Test Runner          junit-eclispe-runner / surefire

    JUnit 5 API Annotations
    ----------------------------------------------
    
	@BeforeEach
	@AfterEach
	
    @Test
	@DisplayName("any name to be displayed for current test case")
	@Tag("is any string that can be used to pick the current test case while executing selective test cases.")

    @ParameterizedTest
   
    @ValueSource
    @CsvSource
    @EnumSource
    @NullSource
    @MethodSource

    @Suite
    @SuiteDisplayName("")
    @SelectPackages("")
    @IncludeTags("")
    @ExcludeTags("")
    @InludePackages("")
    @ExcludePackages("")
    
    Assertions
    ----------------------------------------------

    Is a code break point thet declare wheather a test is passed or failed.

    org.junit.jupiter.api.Assertions
	

    To Run Junit on maven
    ----------------------------------------
    <plugin>
        <artifactId>maven-surefire-plugin</artifactId>
        <version>2.19.1</version>
        <dependencies>
            <dependency>
                <groupId>org.junit.platform</groupId>
                <artifactId>junit-platform-surefire-provider</artifactId>
                <version>1.0.1</version>
            </dependency>
        </dependencies>
    </plugin>
    
    Mockito
    ----------------------------------------

        <dependency>
            <groupId>org.mockito</groupId>
            <artifactId>mockito-core</artifactId>
            <version>2.21.0</version>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.mockito</groupId>
            <artifactId>mockito-junit-jupiter</artifactId>
            <version>2.23.0</version>
            <scope>test</scope>
        </dependency>

        @ExtendWith(MockitoExtension.class)             JUnit 5
        @RunWith(JUnitPlatform.class)                   JUnit 4

        @Mock



   