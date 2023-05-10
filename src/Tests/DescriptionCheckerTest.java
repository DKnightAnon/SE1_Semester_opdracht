import com.example.se_opdracht.DescriptionChecker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DescriptionCheckerTest {

    DescriptionChecker DesCheck = new DescriptionChecker(250);


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
