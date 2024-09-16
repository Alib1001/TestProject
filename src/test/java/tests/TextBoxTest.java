package tests;

import models.TestData;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.TextBoxPage;
import utils.SettingsTestData;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class TextBoxTest extends BaseTest {
    private final TextBoxPage textBoxPage = new TextBoxPage();

    @DataProvider(name = "testData")
    public Object[][] testData() {
        System.out.println(SettingsTestData.getEnvData().getHost());
        List<TestData> testDataList = SettingsTestData.getTestDataList();
        Object[][] data = new Object[testDataList.size()][2];
        for (int i = 0; i < testDataList.size(); i++) {
            data[i][0] = testDataList.get(i).getFullName();
            data[i][1] = testDataList.get(i).getEmail();
        }
        return data;
    }

    @Test(dataProvider = "testData")
    public void testSubmitForm(String fullName, String email) {
        textBoxPage.enterUserData(fullName, email);
        textBoxPage.clickSubmitBtn();

        String displayedFullName = textBoxPage.getDisplayedFullName().replace("Name:", "").trim();
        String displayedEmail = textBoxPage.getDisplayedEmail().replace("Email:", "").trim();

        assertEquals(displayedFullName, fullName, "Output name is not equal to Input Name");
        assertEquals(displayedEmail, email, "Output email is not equal to Input email");
    }
}

