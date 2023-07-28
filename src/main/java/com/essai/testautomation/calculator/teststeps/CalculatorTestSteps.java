package com.essai.testautomation.calculator.teststeps;

import com.essai.testautomation.calculator.constants.GeneralConstants;
import org.hamcrest.Matchers;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertAll;

public class CalculatorTestSteps {

    private static final String PREVIEW = "preview";
    private static final String FORMULA = "formula";
    private static final String FINAL_RESULT = "final result";
    private static final MathContext MC = new MathContext(11, RoundingMode.DOWN);


    public void verifyAdditionOperationBeforeEquals(BigDecimal a, BigDecimal b, String previewText, String formulaText) {
        assertAll("Verification of Addition before Equals is clicked",
                () -> assertThat(PREVIEW, new BigDecimal(previewText), is(a.add(b))),
                () -> assertThat(FORMULA, formulaText, is(a + "+" + b)));
    }

    public void verifyAdditionOperationAfterEquals(BigDecimal a, BigDecimal b, String finalResult) {
        assertAll("Verification of Addition after Equals is clicked",
                () -> assertThat(FINAL_RESULT, new BigDecimal(finalResult), is(a.add(b))));
    }

    public void verifySubtractionOperationBeforeEquals(BigDecimal a, BigDecimal b, String previewText, String formulaText) {
        assertAll("Verification of Subtraction before Equals is clicked",
                () -> assertThat(PREVIEW, new BigDecimal(previewText), is(a.subtract(b))),
                () -> assertThat(FORMULA, formulaText, Matchers.is("" + a + GeneralConstants.HYPHEN_MINUS + b)));
    }

    public void verifySubtractionOperationAfterEquals(BigDecimal a, BigDecimal b, String finalResult) {
        assertAll("Verification of Subtraction after Equals is clicked",
                () -> assertThat(FINAL_RESULT, new BigDecimal(finalResult), is(a.subtract(b))));
    }

    public void verifyMultiplicationOperationBeforeEquals(BigDecimal a, BigDecimal b, String previewText, String formulaText) {
        assertAll("Verification of Multiplication before Equals is clicked",
                () -> assertThat(PREVIEW, new BigDecimal(previewText), is(a.multiply(b))),
                () -> assertThat(FORMULA, formulaText, Matchers.is("" + a + GeneralConstants.UNICODE_MULTIPLICATION + b)));
    }

    public void verifyMultiplicationOperationAfterEquals(BigDecimal a, BigDecimal b, String finalResult) {
        assertAll("Verification of Multiplication after Equals is clicked",
                () -> assertThat(FINAL_RESULT, new BigDecimal(finalResult), is(a.multiply(b))));
    }

    public void verifyDivisionOperationBeforeEquals(BigDecimal a, BigDecimal b, String previewText, String formulaText) {
        assertAll("Verification of Division before Equals is clicked",
                () -> assertThat(PREVIEW, new BigDecimal(previewText), is(a.divide(b, MC))),
                () -> assertThat(FORMULA, formulaText, Matchers.is("" + a + GeneralConstants.UNICODE_DIVISION + b)));
    }

    public void verifyDivisionOperationAfterEquals(BigDecimal a, BigDecimal b, String finalResult) {
        assertAll("Verification of Division after Equals is clicked",
                () -> assertThat(FINAL_RESULT, new BigDecimal(finalResult), is(a.divide(b, MC))));
    }
}
