package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class BoardDeletion  extends TestBase{
    @Test
    public void boardDeletion1(){
       int boardCountBeforeDeletion = app.getBoard().getBoardCount();

        app.getBoard().clickOnTheFirstBoard();
        app.getBoard().openSideMenu();
        app.getBoard().openMore();
        app.getBoard().closeBoard();
        app.getBoard().deleteBoard();

        int boardCountAfterDeletion = app.getBoard().getBoardCount();
      //  Assert.assertEquals(boardCountAfterDeletion,boardCountBeforeDeletion-1);

    }
}
