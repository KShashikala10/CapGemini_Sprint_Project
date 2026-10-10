package ecom.SwagLabs.genericUtility;

import org.testng.annotations.DataProvider;

public class DataProviderUtility {

    @DataProvider(name = "loginData")
    public Object[][] loginData() {
        return new Object[][] {
            {"standard_user", "secret_sauce"}
        };
    }

    @DataProvider(name = "invalidLoginData")
    public Object[][] invalidLoginData() {
        return new Object[][] {
            {"ase", "secret_sauce"}
        };
    }

    @DataProvider(name = "productPageData")
    public Object[][] productPageData() {
        return new Object[][] {
            {"standard_user", "secret_sauce"}
        };
    }
    
    @DataProvider(name = "sortingOptionData", parallel = false)
    public Object[][] sortingOptionData() {
        return new Object[][] {
            {"Name (A to Z)"},
            {"Name (Z to A)"},
            {"Price (low to high)"},
            {"Price (high to low)"}
        };
    }
        
    @DataProvider(name = "productSortingData")
    public Object[][] productSortingData() {
        return new Object[][] {
             {"Name (A to Z)"},
             {"Name (Z to A)"},
             {"Price (low to high)"},
             {"Price (high to low)"}
            };
        }
    
    @DataProvider(name = "priceSortingData")
    public Object[][] priceSortingData() {
        return new Object[][] {
            {"Price (low to high)"}
        };
    }
    
    @DataProvider(name = "checkoutData")
    public Object[][] checkoutData() {
        return new Object[][] {
            {"Shashi", "K", "583101"}
        };
    }
    
    }
