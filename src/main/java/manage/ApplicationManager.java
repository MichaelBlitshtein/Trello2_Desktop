package manage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class ApplicationManager {
   Logger logger = LoggerFactory.getLogger(ApplicationManager.class);
    WebDriver wd;

    UserHelper user;
    BoardHelper board;
    ListHelper list;
    CardHelper card;
    AtlassianHelper atlassian;

    public void init(){
        wd = new ChromeDriver();
        WebDriverListener listener = new MyListener();
        wd=new EventFiringDecorator<>(listener).decorate(wd);
        logger.info("Tests start in Chrome--");
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        wd.navigate().to("https://trello.com/");

        user= new UserHelper(wd);
        board = new BoardHelper(wd);
        list = new ListHelper(wd);
        card = new CardHelper(wd);
        atlassian = new AtlassianHelper(wd);

        user.login("michael.blitshtein@gmail.com","Tommy743!!");

    }

    public void quit(){
    //    wd.close();
    //    wd.quit();
    }

    public UserHelper getUser() {
        return user;
    }

    public BoardHelper getBoard() {
        return board;
    }

    public ListHelper getList() {
        return list;
    }

    public CardHelper getCard() {
        return card;
    }
    public String getUrl(){
        return wd.getCurrentUrl();
    }

    public AtlassianHelper getAtlassian() {
        return atlassian;
    }
}