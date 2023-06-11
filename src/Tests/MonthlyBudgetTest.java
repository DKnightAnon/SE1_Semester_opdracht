import com.example.se_opdracht.BudgetHandlers.MonthlyBudget;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

 class MonthlyBudgetTest {

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
