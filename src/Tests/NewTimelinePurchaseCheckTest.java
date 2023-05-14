import com.example.se_opdracht.InputCheckers.NewTimelinePurchaseCheck;
import com.example.se_opdracht.Products.Timeline.TimelineProduct;
import com.example.se_opdracht.Products.Timeline.TimelineProductCategory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NewTimelinePurchaseCheckTest {

    TimelineProduct testProduct = new TimelineProduct("TestTimelineProduct","Empty","TestTimelineCategory",1);
    TimelineProduct faultyTestProduct = new TimelineProduct("Testing","TestDescription","Test",1);
    TimelineProductCategory testCategory = new TimelineProductCategory(1,"TestTimelineCategory");
    TimelineProductCategory faultyTestCategory = new TimelineProductCategory(1,"Test");


    //----------<Pair 1>----------------

    @Test
    public void inputCheckIfPriceIsPostitiveAndAllValid() throws ClassNotFoundException {
        NewTimelinePurchaseCheck check = new NewTimelinePurchaseCheck();
        int actual = check.inputCheck("80.50",testCategory,testProduct,"10-05-2023");
        Assertions.assertEquals(0,actual);
    }

    @Test
    public void inputCheckIfPriceIsPositiveAndNoneAreValid() throws ClassNotFoundException {
        NewTimelinePurchaseCheck check = new NewTimelinePurchaseCheck();
        int actual = check.inputCheck("80.50",faultyTestCategory,testProduct,"12-30-2023");
        Assertions.assertEquals(4,actual);
    }

    //----------<Pair 2>----------------
    @Test
    public void inputCheckIfPriceIsZeroAndAllAreValid() throws ClassNotFoundException {
        NewTimelinePurchaseCheck check = new NewTimelinePurchaseCheck();
        int actual = check.inputCheck("0.0",faultyTestCategory,testProduct,"10-05-2023");
        Assertions.assertEquals(3,actual);
    }

    @Test
    public void inputCheckIfPriceIsZeroAndNoneAreValid() throws ClassNotFoundException {
        NewTimelinePurchaseCheck check = new NewTimelinePurchaseCheck();
        int actual = check.inputCheck("0.0",testCategory,faultyTestProduct,"12-30-2023");
        Assertions.assertEquals(4,actual);
    }

    //----------<Pair 2>----------------

    @Test
    public void inputCheckIfPriceIsNegativeAndAllAreValid() throws ClassNotFoundException {
        NewTimelinePurchaseCheck check = new NewTimelinePurchaseCheck();
        int actual = check.inputCheck("-80.50",faultyTestCategory,testProduct,"12-30-2023");
        Assertions.assertEquals(4,actual);
    }

    @Test
    public void inputCheckIfPriceIsNegativeAndNoneAreValidExceptCategory() throws ClassNotFoundException {
        NewTimelinePurchaseCheck check = new NewTimelinePurchaseCheck();
        int actual = check.inputCheck("-80.50",testCategory,faultyTestProduct,"18-05-2023");
        Assertions.assertEquals(3,actual);
    }



}
