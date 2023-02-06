package manage;

import model.Board;
import model.Card;
import org.testng.annotations.DataProvider;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MyDataProvider {
    @DataProvider
    public static Iterator<Object[]>dataCardCSV() throws IOException {
        List<Object[]>list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/data.csv")));
        String line = reader.readLine();
        while (line!=null){
            String[] split = line.split(",");
            list.add(new Object[]{Card.builder().cardName(split[0]).color(split[1])});
            line= reader.readLine();
        }
        return list.iterator();
    }

    @DataProvider
    public static Iterator<Object[]>boardModelData(){
        List<Object[]>list = new ArrayList<>();
        list.add(new Object[]{Board.builder().title("testData1")});
        list.add(new Object[]{Board.builder().title("testData2")});
        list.add(new Object[]{Board.builder().title("testData3")});

        return list.iterator();
    }

    @DataProvider
    public static Iterator<Object[]>boardData()  {
        List<Object[]> list = new ArrayList<>();
        list.add(((new Object[]{"test1qa36"})));
        list.add(((new Object[]{"test2qa36"})));
        list.add(((new Object[]{"test3qa36"})));

        return list.iterator();
    }

}
