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
}
