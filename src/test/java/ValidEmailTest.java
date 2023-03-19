import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ValidEmailTest {
    private ValidEmail vEmail;

    @BeforeClass
    public void initData() {
        vEmail = new ValidEmail();
    }


    @DataProvider
    public Object[][] ValidEmailProvider() {
        return new Object[][] {
                {
                        new String[] {
                                "svitlana@yandex.ua",
                                "svitlana27@gmail.com",
                                "svitlana.27@gmail.com",
                                "svitlana111@dev.com",
                                "svitlana.100@dev.com.ua",
                                "svitlana@1.com",
                                "svitlana@gmail.com.com",
                                "svitlana27@gmail.com",
                                "svitlana27@gmail-test.com"
                        }
                }
        };
    }

    @DataProvider
    public Object[][] InvalidEmailProvider() {
        return new Object[][] {
                {
                        new String[] {
                                "svitlana",
                                "svitlana@.com.ua",
                                "svitlana123@gmail.a",
                                "svitlana123@.com",
                                "svitlana@.com.com",
                                ".svitlana@dev.com",
                                "svitlana()*@gmail.com",
                                "svitlana@%*.com",
                                "svitlana..2013@gmail.com",
                                "svitlana.@gmail.com",
                                "svitlana@dev@gmail.com",
                                "svitlana@gmail.com.1ua"
                        }
                }
        };
    }


    @Test(dataProvider = "ValidEmailProvider")
    public void ValidEmailTest(String[] Email) {

        for (String temp : Email) {
            boolean valid = vEmail.checkEmail(temp);
            System.out.println("Email: " + temp + " -> " + valid);
            Assert.assertEquals(valid, true);
        }

    }

    @Test(dataProvider = "InvalidEmailProvider", dependsOnMethods = "ValidEmailTest")
    public void InValidEmailTest(String[] Email) {

        for (String temp : Email) {
            boolean valid = vEmail.checkEmail(temp);
            System.out.println("Email: " + temp + " -> " + valid);
            Assert.assertEquals(valid, false);
        }
    }



}
