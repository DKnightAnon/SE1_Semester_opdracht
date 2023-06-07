import com.example.se_opdracht.DBHandlers.TimelineDBHandler;
import com.example.se_opdracht.DBHandlers.TransactionDBHandler;
import com.example.se_opdracht.ProductMaker.Products.Timeline.TimelineProductPurchase;
import com.example.se_opdracht.ProductMaker.Products.Transaction.TransactionProduct;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import java.sql.SQLException;

class DatabaseHandlerTest {

    @Test
            /*
            Bij deze test wordt gecheckt of data van een entry in de database(specifiek uit Purchase) correct opgehaald wordt.
            De variabelen die onder //prepare staan komen overeen met een entry, en de opgehaalde variabelen worden hiertegen getest.
             */
    void Transaction() throws SQLException, ClassNotFoundException {
        //Prepare

        var dbhandler = new TransactionDBHandler();
        int purchaseID = 1;
        String date = "29-03-2023";
        String item = "TestItem";
        String description = "Testing with database in projectroot";
        String category = "Testcategory";//category

        //Act
        TransactionProduct product = dbhandler.getSingularProduct(1);

        //Assert
        Assertions.assertEquals(purchaseID,product.getID());
        Assertions.assertEquals(date,product.getDate());
        Assertions.assertEquals(description,product.getDescription());
        Assertions.assertEquals(item,product.getName());
        Assertions.assertEquals(category,product.getCategory());
    }


    @Test
    /*
    Bij deze test wordt gecheckt of een product goed uit de database for timelineproducten gehaald wordt.
     */
    void selectPurchaseFromTimelineProduct() throws ClassNotFoundException {
        //Prepare
        var DBhandler = new TimelineDBHandler();
        int purchaseid = 1;
        String date = "29-03-2023";
        BigDecimal price = new BigDecimal("12.34");
        int productid = 1;

        //Act
        ObservableList<TimelineProductPurchase> result = DBhandler.getPurchases(productid);

        //Assert
        Assertions.assertEquals(purchaseid,result.get(0).getPurchaseID());
        Assertions.assertEquals(date,result.get(0).getPurchaseDate());
        Assertions.assertEquals(price,result.get(0).getPurchasePrice());
        Assertions.assertEquals(productid,result.get(0).getPurchaseProductID());

    }

    //@Test
    /*
    This tests if an exception is thrown when the database is in use. To properly test it, you should open the database with the H2 Console.
    To do this, Navigate to the folder that contains h2-2.1.214.jar in the command terminal
    and use the command  [java -jar h2-2.1.214.jar]
     */

//    void assertDatabaseInUse () {
//        //Prepare
//        String jdcbURL = "jdbc:h2:~/bptDB";
//        String user = "Admin";
//        String password = "admin";
//
//        //Act
//
//        JdbcSQLNonTransientConnectionException thrown = Assertions.assertThrows(JdbcSQLNonTransientConnectionException.class, () -> {
//            Connection con = DriverManager.getConnection(jdcbURL, user,password);}, "SQL exception was expected");
//        }








    }

