package inappropriateintimacy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LicenseTest {

    License license;
    Motorist driver;

    @BeforeEach
    void setUp() {
        license = new License();
        driver = new Motorist(license, "Doe", "John", "Mr.");
        license.setMotorist(driver);
    }

    @Test
    void addPoints() {
        license.addPoints(3);
        assertEquals(3, license.getPoints());
    }

    @Test
    void riskFactorShouldReturnHighRisk() {
        license.addPoints(4);
        assertEquals(RiskFactor.HIGH_RISK, driver.getRiskFactor());
    }

    @Test
    void riskFactorShouldReturnModerateRisk() {
        license.addPoints(2);
        assertEquals(RiskFactor.MODERATE_RISK, driver.getRiskFactor());
    }

    @Test
    void riskFactorShouldReturnLowRisk() {
        assertEquals(RiskFactor.LOW_RISK, driver.getRiskFactor());
    }

    @Test
    void getSummary() {
        license.addPoints(1);
        String result = "Mr. John Doe, 1 points";
        assertEquals(result, license.getSummary());
    }
}