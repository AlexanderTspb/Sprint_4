import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
@RunWith(Parameterized.class)
public class LengthNameTest {

    private Account account;
    private final String checkingValue;
    private final boolean expectedValue;

    public LengthNameTest(String checkingValue, boolean expectedValue){
        this.checkingValue = checkingValue;
        this.expectedValue = expectedValue;
    }

    @Parameterized.Parameters
    public static Object[][] getTestData(){
        return new Object[][]{
                {"ivan petrov",true },
                {"iv", false},
                {"iv a", true},
                {"iv an", true},
                {"ivanivan ivaniva18", true},
                {"ivanivan ivanivan19", true},
                {"ivanivanivanivan0020", false},
        };
    }

    @Test
    @DisplayName("LengthNameTest")
    @Description("Тест на проверку количества символов имени")
    public void checkLengthNameTest()  {

        account = new Account(checkingValue);
        boolean actual = account.checkNameToEmboss();
        assertEquals(expectedValue,actual);

    }

}
