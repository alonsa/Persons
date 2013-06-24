package SpringTest;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created with IntelliJ IDEA.
 * User: alon.shalom
 * Date: 7/7/13
 * Time: 2:19 PM
 * To change this template use File | Settings | File Templates.
 */
public class SpringMain {

    String   DbBbook = "DbBbook";
    String   NormalBook = "NormalBook";
    String   DbManager = "DbManager";
    String   personsManager = "PersonsManager";


    @Autowired
    public static void main(String[] args)  {
//        ApplicationContext springBean = new ClassPathXmlApplicationContext("/Beans.xml");
//        Book book =(Book)springBean.getBean("NormalBook");
//        System.out.println(book.toString());
//
//        ApplicationContext springAnotationBean = new ClassPathXmlApplicationContext("/AnnotationBeans.xml");
//        BookManager bookManager =(BookManager)springAnotationBean.getBean("BookManager");
//        System.out.println(bookManager.toString());
//
////        DbManager DbManager =(DbManager)springBean.getBean("DbManager");
//        System.out.println(DbManager.toString());

//        PersonsManager personsManager =(PersonsManager)springAnotationBean.getBean("PersonsManager");
//        System.out.println(personsManager.toString());


    }

}
