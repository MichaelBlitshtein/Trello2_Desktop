package manage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class AtlassianHelper extends HelperBase{


    public AtlassianHelper(WebDriver wd) {
        super(wd);
    }

    public void initChangePhoto() {
        Actions actions = new Actions(wd);
        actions.moveToElement(wd.findElement(By.cssSelector("[data-test-selector='profile-avatar']"))).click().perform();
        pause(2000);
        click(By.xpath("//*[@role='menuitem'][1]"));
    }

    public void uploadPhoto(String path) {
        wd.findElement(By.cssSelector("#image-input")).sendKeys(path);
        click(By.cssSelector(".css-1mq3qcb"));
    }
}
