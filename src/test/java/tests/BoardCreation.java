package tests;

import manage.MyDataProvider;
import model.Board;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BoardCreation extends TestBase{
    @Test(dataProvider = "BoardModelData",dataProviderClass = MyDataProvider.class)
    public void boardCreation1(Board board){

       // Board board = Board.builder().title("qa36").build();
        logger.info("Test board creation 1 --"+board.getTitle());

        app.getBoard().initBoardCreation();
        app.getBoard().fillInBoardCreationForm("qa36");
        app.getBoard().scrollDownTheForm();
        app.getBoard().pause(2000);
        app.getBoard().submitBoardCreation();
        app.getBoard().pause(2000);
        app.getBoard().isCreated();

        Assert.assertTrue(app.getBoard().isCreated());
        logger.info("Board is created---");

        app.getBoard().pause(2000);
        app.getBoard().returnToHomePage();
    }

    @Test
    public void boardCreation2(){
        Board board = Board.builder().title("qa36").build();

        int boardCountBeforeCreation = app.getBoard().getBoardCount();


        app.getBoard().initBoardCreation();
        app.getBoard().fillInBoardCreationForm("qa36");
        app.getBoard().scrollDownTheForm();
        app.getBoard().pause(2000);
        app.getBoard().submitBoardCreation();
        app.getBoard().pause(2000);

        int boardCountAfterCreation = app.getBoard().getBoardCount();
        Assert.assertEquals(boardCountAfterCreation,boardCountBeforeCreation+1);

    }

    @Test
    public void boardCreation3(){
        Board board = Board.builder().title("qa36").build();

        int boardCountBeforeCreation = app.getBoard().getBoardCount();

        app.getBoard().initBoardCreation();
        app.getBoard().chooseBackgroung();

        app.getBoard().fillInBoardCreationForm("qa36");
        app.getBoard().scrollDownTheForm();
        app.getBoard().pause(2000);
        app.getBoard().submitBoardCreation();
        app.getBoard().pause(2000);

        int boardCountAfterCreation = app.getBoard().getBoardCount();
        Assert.assertEquals(boardCountAfterCreation,boardCountBeforeCreation+1);

    }


    @Test(dataProvider =  "boardData",dataProviderClass = MyDataProvider.class)
    public void boarCreation4(String title){

        app.getBoard().initBoardCreation();
        app.getBoard().fillInBoardCreationForm(title);
        app.getBoard().scrollDownTheForm();
        app.getBoard().pause(2000);
        app.getBoard().submitBoardCreating();
        app.getBoard().pause(2000);
        app.getBoard().isCreated();

        Assert.assertTrue(app.getBoard().isCreated());

        app.getBoard().pause(2000);
        app.getBoard().returnToHomePage();
    }
}
