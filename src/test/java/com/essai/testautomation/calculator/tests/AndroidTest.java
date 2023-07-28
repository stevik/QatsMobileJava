package com.essai.testautomation.calculator.tests;

import com.essai.testautomation.calculator.common.BaseTest;
import com.essai.testautomation.calculator.constants.GeneralConstants;
import com.essai.testautomation.calculator.pages.calculator.CalculatorHomePage;
import com.essai.testautomation.calculator.teststeps.CalculatorTestSteps;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.junit5.AllureJunit5;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.math.BigDecimal;

@Tag(GeneralConstants.ANDROID)
@Epic("Calculator application")
@Feature("Jira CLC-635")
@ExtendWith({AllureJunit5.class})
public class AndroidTest extends BaseTest {

    private static final CalculatorTestSteps CALCULATOR_TEST_STEPS = new CalculatorTestSteps();
    private CalculatorHomePage homePage;

    @BeforeEach
    public void testSetUp() {
        homePage = new CalculatorHomePage(driver);
    }

    @AfterEach
    public void testCleanUp() {
        homePage.tapOnBtnClear();
    }

    @ParameterizedTest
    @CsvSource(value = {"-33.15;+19", "16.55;48.6", "5;4"}, delimiter = ';')
    @Description("Verification of operation addition")
    public void additionTest(String a, String b) {

        // prepare
        BigDecimal numA = new BigDecimal(a);
        BigDecimal numB = new BigDecimal(b);

        // execute
        homePage.inputNumber(numA)
                .tapOnBtnAddition()
                .inputNumber(numB);

        // verify
        CALCULATOR_TEST_STEPS.verifyAdditionOperationBeforeEquals(numA, numB, homePage.getPreviewText(), homePage.getFormulaText());

        // execute
        homePage.tapOnBtnEquals();

        // verify
        CALCULATOR_TEST_STEPS.verifyAdditionOperationAfterEquals(numA, numB, homePage.getResultFinalText());
    }

    @ParameterizedTest
    @CsvSource(value = {"5.15;+19", "-16.55;12.6", "5;5"}, delimiter = ';')
    @Description("Verification of operation subtraction")
    public void subtractionTest(String a, String b) {

        // prepare
        BigDecimal numA = new BigDecimal(a);
        BigDecimal numB = new BigDecimal(b);

        // execute
        homePage.inputNumber(numA)
                .tapOnBtnSubtraction()
                .inputNumber(numB);

        // verify
        CALCULATOR_TEST_STEPS.verifySubtractionOperationBeforeEquals(numA, numB, homePage.getPreviewText(), homePage.getFormulaText());

        // execute
        homePage.tapOnBtnEquals();

        // verify
        CALCULATOR_TEST_STEPS.verifySubtractionOperationAfterEquals(numA, numB, homePage.getResultFinalText());
    }

    @ParameterizedTest
    @CsvSource(value = {"5.15;+11", "-16.24;12.6", "0;5"}, delimiter = ';')
    @Description("Verification of operation multiplication")
    public void multiplicationTest(String a, String b) {

        // prepare
        BigDecimal numA = new BigDecimal(a);
        BigDecimal numB = new BigDecimal(b);

        // execute
        homePage.inputNumber(numA)
                .tapOnBtnMultiplication()
                .inputNumber(numB);

        // verify
        CALCULATOR_TEST_STEPS.verifyMultiplicationOperationBeforeEquals(numA, numB, homePage.getPreviewText(), homePage.getFormulaText());

        // execute
        homePage.tapOnBtnEquals();

        // verify
        CALCULATOR_TEST_STEPS.verifyMultiplicationOperationAfterEquals(numA, numB, homePage.getResultFinalText());
    }

    @ParameterizedTest
    @CsvSource(value = {"9.15;+11", "-12.33;1.6", "10;1"}, delimiter = ';')
    @Description("Verification of operation division")
    public void divisionTest(String a, String b) {

        // prepare
        BigDecimal numA = new BigDecimal(a);
        BigDecimal numB = new BigDecimal(b);

        // execute
        homePage.inputNumber(numA)
                .tapOnBtnDivision()
                .inputNumber(numB);

        // verify
        CALCULATOR_TEST_STEPS.verifyDivisionOperationBeforeEquals(numA, numB, homePage.getPreviewText(), homePage.getFormulaText());

        // execute
        homePage.tapOnBtnEquals();

        // verify
        CALCULATOR_TEST_STEPS.verifyDivisionOperationAfterEquals(numA, numB, homePage.getResultFinalText());
    }
}