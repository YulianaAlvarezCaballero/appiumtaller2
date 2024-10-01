package com.automation;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;

import java.net.MalformedURLException;
import java.net.URL;

public class StepDefinitions {

    private AndroidDriver<MobileElement> driver;

    @Before
    public void setUp() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11.0"); // Cambia según tu emulador
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        caps.setCapability("appPackage", "com.android.calculator2");
        caps.setCapability("appActivity", "com.android.calculator2.Calculator");

        driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
    }

    @Given("The calculator app is open")
    public void the_calculator_app_is_open() {
        // App está abierta por el @Before
    }

    @When("I press {int}")
    public void i_press_number(int number) {
        String elementId = "com.android.calculator2:id/digit_" + number;
        driver.findElementById(elementId).click();
    }

    @When("I press plus")
    public void i_press_plus() {
        MobileElement plus = driver.findElementByAccessibilityId("plus");
        plus.click();
    }

    @When("I press minus")
    public void i_press_minus() {
        MobileElement minus = driver.findElementByAccessibilityId("minus");
        minus.click();
    }

    @When("I press multiply")
    public void i_press_multiply() {
        MobileElement multiply = driver.findElementByAccessibilityId("multiply");
        multiply.click();
    }

    @When("I press divide")
    public void i_press_divide() {
        MobileElement divide = driver.findElementByAccessibilityId("divide");
        divide.click();
    }

    @When("I press equals")
    public void i_press_equals() {
        MobileElement equals = driver.findElementByAccessibilityId("equals");
        equals.click();
    }

    @Then("The result should be {int}")
    public void the_result_should_be(int expectedResult) {
        MobileElement result = driver.findElementById("com.android.calculator2:id/result");
        Assert.assertEquals(result.getText(), String.valueOf(expectedResult));
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}