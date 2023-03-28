import com.example.se_opdracht.DBHandlers.TransactionDBHandler;
import com.example.se_opdracht.Products.TransactionProduct;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

class DatabaseHandlerTest {

    @Test
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



}
