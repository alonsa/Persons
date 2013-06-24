package SpringTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * User: alon.shalom
 * Date: 7/8/13
 * Time: 9:49 AM
 * To change this template use File | Settings | File Templates.
 */

@Service("BookManager")
public class BookManager {

    @Autowired
    Book book;

//    public void setBOok(Book book) {
//        this.book = book;
//    }

    public void run() {
        String s = "This is my test";
        System.out.println(book.toString());
    }

    public String toString(){
        return  ("This is my test : " + book.toString());
    }
}
