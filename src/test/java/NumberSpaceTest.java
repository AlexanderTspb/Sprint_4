import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
@RunWith(Parameterized.class)
public class NumberSpaceTest {

    private Account account;
    private final String checkingValue;
    private final boolean expectedValue;

    public NumberSpaceTest(String checkingValue, boolean expectedValue){
        this.checkingValue = checkingValue;
        this.expectedValue = expectedValue;
    }

    @Parameterized.Parameters
    public static Object[][] getTestData(){
        return new Object[][]{
                {"ivan petrov",true },
                {"ivanpetrov", false},
                {"ivan  petrov", false },

        };
    }

    @Test
    @DisplayName("NumberSpacesTest")
    @Description("Тесто на проверку количества пробелов в имени")
    public void checkNumberSpacesTest()  {

        account = new Account(checkingValue);
        boolean actual = account.checkNameToEmboss();
        assertEquals(expectedValue,actual);

    }

}
