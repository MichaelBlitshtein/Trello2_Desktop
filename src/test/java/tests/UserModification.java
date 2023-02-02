package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class UserModification extends TestBase{
    @Test
    public void testNewTab(){
        app.getUser().openTabAndSwitch();
        app.getUser().pause(1000);
    }

    @Test
    public void changeAvatar(){
        app.getUser().clickOnAvatar();
        app.getUser().pause(2000);
        app.getUser().openUserProfile();
        app.getUser().goToTheAtlassionAccount();
        app.getUser().pause(2000);
        Assert.assertTrue(app.getUrl().contains("https://id.atlassian.com/manage-profile/profile-and-visibility"));

        app.getAtlassian().initChangePhoto();
        app.getAtlassian().uploadPhoto("C:\\Users\\Michael Blitshtein\\Documents\\GitHub\\Trello2_Desktop\\src\\test\\resources\\1675038212447.jpg");
        app.getAtlassian().pause(3000);
        app.getUser().returnToTrello();
        Assert.assertTrue(app.getUrl().contains("https://trello.com/"));
    }


}
