import com.example.se_opdracht.BudgetHandlers.MonthlyBudget;
import com.example.se_opdracht.InputCheckers.DescriptionChecker;
import com.example.se_opdracht.InputCheckers.NewTimelinePurchaseCheck;
import com.example.se_opdracht.ProductMaker.Products.Category;
import com.example.se_opdracht.ProductMaker.Products.ICategory;
import com.example.se_opdracht.ProductMaker.Products.IProduct;
import com.example.se_opdracht.ProductMaker.Products.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

public class OPT3_Tests {

    @Nested
    class MonthlyBudgetTest {

        @Nested
        class ConditionCoverage{
            @Test
            public void testForFitInBudgetATrue(){
                var budget = new MonthlyBudget(600);
                Assertions.assertFalse(budget.fitsInBudget(580,1,10,false));
            }

            @Test
            public void testForFitInBudgetBTrue(){
                var budget = new MonthlyBudget(600);
                Assertions.assertFalse(budget.fitsInBudget(600,1,0,false));
            }

            @Test
            public void testForFitInBudgetCTrue(){
                var budget = new MonthlyBudget(600);
                Assertions.assertFalse(budget.fitsInBudget(800,1,10,true));
            }
        }

        @Nested
        class DecisionCoverage{
            @Test
            public void testForFitInBudgetDecisionTrue(){
                var budget = new MonthlyBudget(600);
                Assertions.assertTrue(budget.fitsInBudget(540,1,10,false));
            }

            @Test
            public void testForFitInBudgetDecisionFalse(){
                var budget = new MonthlyBudget(600);
                Assertions.assertFalse(budget.fitsInBudget(800,1,0,false));
            }
        }

        @Nested
        class ModifiedConditionDecisionCoverage{
            @Test
            public void testForFitInBudgetValidPriceButHitsLowerLimit(){
                var budget = new MonthlyBudget(600);
                Assertions.assertFalse(budget.fitsInBudget(580,1,10,false));
            }

            @Test
            public void testForFitInBudgetValidPriceHitsLowerLimitButIsEssential(){
                var budget = new MonthlyBudget(600);
                Assertions.assertTrue(budget.fitsInBudget(580,1,10,true));
            }

            @Test
            public void testForFitInBudgetPriceHigherThanBudget(){
                var budget = new MonthlyBudget(600);
                Assertions.assertFalse(budget.fitsInBudget(700,1,10,true));
            }

            @Test
            public void testForFitInBudgetValidPriceHigherThanLowerLimitIsEssential(){
                var budget = new MonthlyBudget(600);
                Assertions.assertTrue(budget.fitsInBudget(300,1,10,true));
            }
        }

        @Nested
        class MultipleConditionCoverage{
            @Test
            public void testForFitInBudgetAllFalse(){
                var budget = new MonthlyBudget(600);
                Assertions.assertFalse(budget.fitsInBudget(700,1,10,false));
            }

            @Test
            public void testForFitInBudgetATrue(){
                var budget = new MonthlyBudget(600);
                Assertions.assertFalse(budget.fitsInBudget(580,1,10,false));
            }

            @Test
            public void testForFitInBudgetBTrue(){
                var budget = new MonthlyBudget(600);
                Assertions.assertFalse(budget.fitsInBudget(800,1,0,false));
            }

            @Test
            public void testForFitInBudgetCTrue(){
                var budget = new MonthlyBudget(600);
                Assertions.assertFalse(budget.fitsInBudget(800,1,10,true));
            }

            @Test
            public void testForFitInBudgetAandBTrue(){
                var budget = new MonthlyBudget(600);
                Assertions.assertFalse(budget.fitsInBudget(500,1,10,true));
            }

            @Test
            public void testForFitInBudgetAandCTrue(){
                var budget = new MonthlyBudget(600);
                Assertions.assertFalse(budget.fitsInBudget(580,1,10,true));
            }

            @Test
            public void testForFitInBudgetBandCTrue(){
                var budget = new MonthlyBudget(600);
                Assertions.assertFalse(budget.fitsInBudget(600,1,0,true));
            }

            @Test
            public void testForFitInBudgetAllTrue(){
                var budget = new MonthlyBudget(600);
                Assertions.assertFalse(budget.fitsInBudget(500,1,10,true));
            }
        }


    }

    @Nested
    class DescriptionCheckerTest {

        DescriptionChecker DesCheck = new DescriptionChecker(250);

        @Test
        public void checkDescriptionIfLengthIsNegative10Return1(){
            Assertions.assertEquals(1,DesCheck.checkDescription(-10));
        }

        @Test
        public void checkDescriptionIfLengthIsSmallerThan0Return1(){
            Assertions.assertEquals(1,DesCheck.checkDescription(-1));
        }

        @Test
        public void checkDescriptionIfLengthIs0Return1(){

            Assertions.assertEquals(1,DesCheck.checkDescription(0));
        }

        @Test
        public void checkDescriptionIfLengthIs1Return2(){
            Assertions.assertEquals(2,DesCheck.checkDescription(1));
        }

        @Test
        public void checkDescriptionIfLengthIs249Return2(){
            Assertions.assertEquals(2,DesCheck.checkDescription(249));
        }

        @Test
        public void checkDescriptionIfLengthIs250Return2(){
            Assertions.assertEquals(2,DesCheck.checkDescription(250));
        }

        @Test
        public void checkDescriptionIfLengthIs251Return3(){
            Assertions.assertEquals(3,DesCheck.checkDescription(251));
        }

    }

    @Nested
    class NewTimelinePurchaseCheckTest {

        IProduct testProduct = new Product("TestTimelineProduct","Empty",1,new Category("TestProduct",1));
        ICategory testCategory = new Category("TestTimelineCategory",1);
        ICategory faultyTestCategory = new Category("Test",1);
        IProduct faultyTestProduct = new Product("Testing","TestDescription",2,faultyTestCategory);

        //----------<Pair 1>----------------

        @Test
        public void inputCheckIfPriceIsPostitiveAndAllValid() throws ClassNotFoundException, SQLException {
            NewTimelinePurchaseCheck check = new NewTimelinePurchaseCheck();
            int actual = check.inputCheck("80.50",testCategory,testProduct,"10-05-2023");
            Assertions.assertEquals(0,actual);
        }

        @Test
        public void inputCheckIfPriceIsPositiveAndNoneAreValid() throws ClassNotFoundException, SQLException {
            NewTimelinePurchaseCheck check = new NewTimelinePurchaseCheck();
            int actual = check.inputCheck("80.50",faultyTestCategory,testProduct,"12-30-2023");
            Assertions.assertEquals(4,actual);
        }

        //----------<Pair 2>----------------
        @Test
        public void inputCheckIfPriceIsZeroAndAllAreValid() throws ClassNotFoundException, SQLException {
            NewTimelinePurchaseCheck check = new NewTimelinePurchaseCheck();
            int actual = check.inputCheck("0.0",faultyTestCategory,testProduct,"10-05-2023");
            Assertions.assertEquals(3,actual);
        }

        @Test
        public void inputCheckIfPriceIsZeroAndNoneAreValid() throws ClassNotFoundException, SQLException {
            NewTimelinePurchaseCheck check = new NewTimelinePurchaseCheck();
            int actual = check.inputCheck("0.0",testCategory,faultyTestProduct,"12-30-2023");
            Assertions.assertEquals(4,actual);
        }

        //----------<Pair 2>----------------

        @Test
        public void inputCheckIfPriceIsNegativeAndAllAreValid() throws ClassNotFoundException, SQLException {
            NewTimelinePurchaseCheck check = new NewTimelinePurchaseCheck();
            int actual = check.inputCheck("-80.50",faultyTestCategory,testProduct,"12-30-2023");
            Assertions.assertEquals(4,actual);
        }

        @Test
        public void inputCheckIfPriceIsNegativeAndNoneAreValidExceptCategory() throws ClassNotFoundException, SQLException {
            NewTimelinePurchaseCheck check = new NewTimelinePurchaseCheck();
            int actual = check.inputCheck("-80.50",testCategory,faultyTestProduct,"18-05-2023");
            Assertions.assertEquals(3,actual);
        }



    }

}
