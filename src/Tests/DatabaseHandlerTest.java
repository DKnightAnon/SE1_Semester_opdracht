import com.example.se_opdracht.DBHandlers.TimelineDBHandler;
import com.example.se_opdracht.DBHandlers.TransactionDBHandler;
import com.example.se_opdracht.Products.Timeline.TimelineProductPurchase;
import com.example.se_opdracht.Products.Transaction.TransactionProduct;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;

class DatabaseHandlerTest {

    @Test
            /*
            Bij deze test wordt gecheckt of data van een entry in de database(specifiek uit  correct opgehaald wordt.
            De variabelen die onder //prepare staan komen overeen met een entry, en de opgehaalde variabelen worden hiertegen getest.
             */
    void Transaction() throws SQLException, ClassNotFoundException {
        //Prepare

        var dbhandler = new TransactionDBHandler();
        int purchaseID = 2;
        String date = "26-03-2022";
        String item = "testitem";
        String description = "testdescription";
        String category = "testcategory1";//category

        //Act
        TransactionProduct product = dbhandler.getSingularProduct(2);

        //Assert
        Assertions.assertEquals(purchaseID,product.getID());
        Assertions.assertEquals(date,product.getDate());
        Assertions.assertEquals(description,product.getDescription());
        Assertions.assertEquals(item,product.getName());
        Assertions.assertEquals(category,product.getCategory());
    }


    @Test
    void selectPurchaseFromTimelineProduct() throws ClassNotFoundException {
        //Prepare
        var DBhandler = new TimelineDBHandler();
        int purchaseid = 3;
        String date = "29-03-2023";
        BigDecimal price = new BigDecimal("13.49");
        int productid = 1;

        //Act
        ObservableList<TimelineProductPurchase> result = TimelineDBHandler.getPurchases(productid);

        //Assert
        Assertions.assertEquals(purchaseid,result.get(2).getPurchaseID());
        Assertions.assertEquals(date,result.get(2).getPurchaseDate());
        Assertions.assertEquals(price,result.get(2).getPurchasePrice());
        Assertions.assertEquals(productid,result.get(2).getPurchaseProductID());

    }
}
