import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
@RunWith(Parameterized.class)
public class StartsOrEndsWithSpaceTest {

    private Account account;
    private final String checkingValue;
    private final boolean expectedValue;

    public StartsOrEndsWithSpaceTest(String checkingValue, boolean expectedValue){
        this.checkingValue = checkingValue;
        this.expectedValue = expectedValue;
    }

    @Parameterized.Parameters
    public static Object[][] getTestData(){
        return new Object[][]{
                {"ivan petrov",true },
                {" ivanpetrov", false},
                {"ivanpetrov ", false},


        };
    }

    @Test
    @DisplayName("StartsOrEndsWithSpaceTest")
    @Description("Тест на проверку является ли начальным или последним символом пробел")
    public void checkStartsOrEndsWithSpaceTest()  {

        account = new Account(checkingValue);
        boolean actual = account.checkNameToEmboss();
        assertEquals(expectedValue,actual);

    }

}
