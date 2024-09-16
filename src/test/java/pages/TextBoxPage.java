package pages;

import aquality.selenium.core.elements.ElementState;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.elements.interfaces.ITextBox;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class TextBoxPage extends Form {
    private static final By userNameLocator = By.id("userName");
    private static final By emailLocator = By.id("userEmail");
    private static final By submitBtnLocator = By.id("submit");
    private static final By outputNameLocator = By.xpath("//div[@id='output']//p[@id='name']");
    private static final By outputEmailLocator = By.xpath("//div[@id='output']//p[@id='email']");
    private final ITextBox userNameTextBox = getElementFactory().getTextBox(userNameLocator, "Username TextBox", ElementState.EXISTS_IN_ANY_STATE);
    private final ITextBox emailTextBox = getElementFactory().getTextBox(emailLocator, "Email TextBox", ElementState.EXISTS_IN_ANY_STATE);
    private final IButton submitBtn = getElementFactory().getButton(submitBtnLocator, "Submit Button",ElementState.EXISTS_IN_ANY_STATE);
    private final ILabel outputNameLabel = getElementFactory().getLabel(outputNameLocator, "Output Name");
    private final ILabel outputEmailLabel = getElementFactory().getLabel(outputEmailLocator, "Output Email");

    public TextBoxPage() {
        super(By.id("userForm"), "Text Box");
    }

    public void enterUserName(String fullName) {
        userNameTextBox.clearAndType(fullName);
    }

    public void enterEmail(String email) {
        emailTextBox.clearAndType(email);
    }

    public void clickSubmitBtn() {
        submitBtn.getJsActions().scrollIntoView();
        submitBtn.click();
    }

    public void enterUserData(String fullName, String email) {
        enterUserName(fullName);
        enterEmail(email);
    }

    public String getDisplayedFullName() {
        return outputNameLabel.getText();
    }

    public String getDisplayedEmail() {
        return outputEmailLabel.getText();
    }

}
