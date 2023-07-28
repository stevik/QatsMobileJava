package com.essai.testautomation.calculator.pages.calculator;

import com.essai.testautomation.calculator.core.page.BasePage;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import static com.essai.testautomation.calculator.constants.GeneralConstants.HYPHEN_MINUS;
import static com.essai.testautomation.calculator.constants.GeneralConstants.MINUS_SIGN;

public class CalculatorHomePage extends BasePage {

    private static final String CALC_PKG = "com.google.android.calculator";
    private static final String SELECTOR_AS_ID = CALC_PKG + ":id/";
    private static final Map<Integer, By> BTN_NUMBERS;
    private static final By BTN_ADDITION = By.id(SELECTOR_AS_ID + "op_add");
    private static final By BTN_SUBTRACTION = By.id(SELECTOR_AS_ID + "op_sub");
    private static final By BTN_MULTIPLICATION = By.id(SELECTOR_AS_ID + "op_mul");
    private static final By BTN_DIVISION = By.id(SELECTOR_AS_ID + "op_div");
    private static final By BTN_EQUALS = By.id(SELECTOR_AS_ID + "eq");
    private static final By BTN_DEL = By.id(SELECTOR_AS_ID + "del");
    private static final By BTN_DEC_POINT = By.id(SELECTOR_AS_ID + "dec_point");
    private static final By BTN_CLR = By.id(SELECTOR_AS_ID + "clr");

    private static final By TEXT_FORMULA = By.id(SELECTOR_AS_ID + "formula");
    private static final By TEXT_RESULT_FINAL = By.id(SELECTOR_AS_ID + "result_final");
    private static final By TEXT_PREVIEW = By.id(SELECTOR_AS_ID + "result_preview");


    static {
        BTN_NUMBERS = new HashMap<>();
        BTN_NUMBERS.put(0, By.id(SELECTOR_AS_ID + "digit_0"));
        BTN_NUMBERS.put(1, By.id(SELECTOR_AS_ID + "digit_1"));
        BTN_NUMBERS.put(2, By.id(SELECTOR_AS_ID + "digit_2"));
        BTN_NUMBERS.put(3, By.id(SELECTOR_AS_ID + "digit_3"));
        BTN_NUMBERS.put(4, By.id(SELECTOR_AS_ID + "digit_4"));
        BTN_NUMBERS.put(5, By.id(SELECTOR_AS_ID + "digit_5"));
        BTN_NUMBERS.put(6, By.id(SELECTOR_AS_ID + "digit_6"));
        BTN_NUMBERS.put(7, By.id(SELECTOR_AS_ID + "digit_7"));
        BTN_NUMBERS.put(8, By.id(SELECTOR_AS_ID + "digit_8"));
        BTN_NUMBERS.put(9, By.id(SELECTOR_AS_ID + "digit_9"));
    }

    public CalculatorHomePage(AppiumDriver driver) {
        super(driver);
    }

    public CalculatorHomePage tapOnBtnNumber(Integer number) {

        if (BTN_NUMBERS.containsKey(number)) {
            tapOnBtn(BTN_NUMBERS.get(number));
            return this;
        } else {
            throw new IllegalArgumentException(String.format("Number {%s} is not supported", number));
        }
    }

    public CalculatorHomePage inputNumber(BigDecimal number) {

        number.toString().chars().forEach(c -> {
            switch (c) {
                case '.' -> tapOnBtnDecimalPoint();
                case '-' -> tapOnBtnSubtraction();
                case '+' -> tapOnBtnAddition();
                default -> tapOnBtnNumber(Character.getNumericValue(c));
            }
        });
        return this;
    }


    public CalculatorHomePage tapOnBtnAddition() {
        tapOnBtn(BTN_ADDITION);
        return this;
    }

    public CalculatorHomePage tapOnBtnSubtraction() {
        tapOnBtn(BTN_SUBTRACTION);
        return this;
    }

    public CalculatorHomePage tapOnBtnMultiplication() {
        tapOnBtn(BTN_MULTIPLICATION);
        return this;
    }

    public CalculatorHomePage tapOnBtnDivision() {
        tapOnBtn(BTN_DIVISION);
        return this;
    }

    public CalculatorHomePage tapOnBtnEquals() {
        tapOnBtn(BTN_EQUALS);
        return this;
    }

    public CalculatorHomePage tapOnBtnDelete() {
        tapOnBtn(BTN_DEL);
        return this;
    }

    public CalculatorHomePage tapOnBtnDecimalPoint() {
        tapOnBtn(BTN_DEC_POINT);
        return this;
    }

    public CalculatorHomePage tapOnBtnClear() {
        tapOnBtn(BTN_CLR);
        return this;
    }


    public String getFormulaText() {
        return getText(getElement(TEXT_FORMULA)).replace(MINUS_SIGN, HYPHEN_MINUS);
    }

    public String getResultFinalText() {
        return getText(getElement(TEXT_RESULT_FINAL)).replace(MINUS_SIGN, HYPHEN_MINUS);
    }

    public String getPreviewText() {
        return getText(getElement(TEXT_PREVIEW)).replace(MINUS_SIGN, HYPHEN_MINUS);
    }
}
