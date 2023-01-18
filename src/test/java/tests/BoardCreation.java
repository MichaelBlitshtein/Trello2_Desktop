package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class BoardCreation extends TestBase{
    @Test
    public void boardCreation1(){
        app.getBoard().initBoardCreation();
        app.getBoard().fillInBoardCreationForm("qa36");
        app.getBoard().scrollDownTheForm();
        app.getBoard().pause(2000);
        app.getBoard().submitBoardCreation();
        app.getBoard().pause(2000);
        app.getBoard().isCreated();

        Assert.assertTrue(app.getBoard().isCreated());

        app.getBoard().pause(2000);
        app.getBoard().returnToHomePage();
    }
}
