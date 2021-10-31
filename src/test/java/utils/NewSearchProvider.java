package utils;

import org.testng.annotations.DataProvider;

public class NewSearchProvider {
    @DataProvider(name = "TestData")
    public static Object[][] getNewSearch() {
        return new Object[][]{
                { "Cartagena","1 de oct. - 5 de oct."},
        };
    }
}
