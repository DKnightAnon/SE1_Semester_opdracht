import com.example.se_opdracht.InputCheckers.NewTimelinePurchaseCheck;
import com.example.se_opdracht.ProductMaker.Products.Category;
import com.example.se_opdracht.ProductMaker.Products.ICategory;
import com.example.se_opdracht.ProductMaker.Products.IProduct;
import com.example.se_opdracht.ProductMaker.Products.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

public class NewTimelinePurchaseCheckTest {

    IProduct testProduct = new Product("TestTimelineProduct","Empty",1,new Category("TestTimelineCategory",1));
    IProduct faultyTestProduct = new Product("TestTimelineProduct","Empty",1,new Category("TestTimelineCategory",1));
    ICategory testCategory = new Category("TestTimelineCategory",1);
    ICategory faultyTestCategory = new Category("Test",1);


    //----------<Pair 1>----------------

//    @Test
//    public void inputCheckIfPriceIsPostitiveAndAllValid() throws ClassNotFoundException, SQLException {
//        NewTimelinePurchaseCheck check = new NewTimelinePurchaseCheck();
//        int actual = check.inputCheck("80.50",testCategory,testProduct,"10-05-2023");
//        Assertions.assertEquals(0,actual);
//    }
//
//    @Test
//    public void inputCheckIfPriceIsPositiveAndNoneAreValid() throws ClassNotFoundException, SQLException {
//        NewTimelinePurchaseCheck check = new NewTimelinePurchaseCheck();
//        int actual = check.inputCheck("80.50",faultyTestCategory,testProduct,"12-30-2023");
//        Assertions.assertEquals(4,actual);
//    }
//
//    //----------<Pair 2>----------------
//    @Test
//    public void inputCheckIfPriceIsZeroAndAllAreValid() throws ClassNotFoundException, SQLException {
//        NewTimelinePurchaseCheck check = new NewTimelinePurchaseCheck();
//        int actual = check.inputCheck("0.0",faultyTestCategory,testProduct,"10-05-2023");
//        Assertions.assertEquals(3,actual);
//    }
//
//    @Test
//    public void inputCheckIfPriceIsZeroAndNoneAreValid() throws ClassNotFoundException, SQLException {
//        NewTimelinePurchaseCheck check = new NewTimelinePurchaseCheck();
//        int actual = check.inputCheck("0.0",testCategory,faultyTestProduct,"12-30-2023");
//        Assertions.assertEquals(4,actual);
//    }
//
//    //----------<Pair 2>----------------
//
//    @Test
//    public void inputCheckIfPriceIsNegativeAndAllAreValid() throws ClassNotFoundException, SQLException {
//        NewTimelinePurchaseCheck check = new NewTimelinePurchaseCheck();
//        int actual = check.inputCheck("-80.50",faultyTestCategory,testProduct,"12-30-2023");
//        Assertions.assertEquals(4,actual);
//    }
//
//    @Test
//    public void inputCheckIfPriceIsNegativeAndNoneAreValidExceptCategory() throws ClassNotFoundException, SQLException {
//        NewTimelinePurchaseCheck check = new NewTimelinePurchaseCheck();
//        int actual = check.inputCheck("-80.50",testCategory,faultyTestProduct,"18-05-2023");
//        Assertions.assertEquals(3,actual);
//    }



}
