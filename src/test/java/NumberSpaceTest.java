import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

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
    public void correctNameTest()  {

        Account account = new Account(checkingValue);
        boolean actual = account.checkNameToEmboss();
        assertEquals(expectedValue,actual);

    }

}
