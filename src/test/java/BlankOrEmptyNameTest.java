import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.assertEquals;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;

@RunWith(Parameterized.class)
public class BlankOrEmptyNameTest {

    private Account account;
    private final String checkingValue;
    private final boolean expectedValue;

    public BlankOrEmptyNameTest(String checkingValue, boolean expectedValue){
        this.checkingValue = checkingValue;
        this.expectedValue = expectedValue;
    }

    @Parameterized.Parameters
    public static Object[][] getTestData(){
        return new Object[][]{
                {"ivan petrov",true },
                {"", false},
                {" ", false},
        };
    }

    @Test
    @DisplayName("BlankOrEmptyNameTest")
    @Description("Тест проверяет пустое ли имя или состоит ли имя только из пробелов")
    public void checkEmptyOrBlankIsNameTest()  {
        account = new Account(checkingValue);
        boolean actual = account.checkNameToEmboss();
        assertEquals(expectedValue,actual);
    }
}
