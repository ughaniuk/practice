package com.mavenit.selenium.training;


import com.mavenit.selenium.training.page_elements.LocatorHelper;
import org.junit.Test;
import org.openqa.selenium.By;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class RegressionSuite extends Hooks {

    private LocatorHelper helper = new LocatorHelper();

    @Test
    public void searchTest() {

        String searchTerm = "laptop";

        helper.search(searchTerm);
        String actualTitle = helper.getPageTitle();
        String actualThumNail = helper.getThumbNail();
        String actualCurrentUrl = helper.getCurrentUrl();

        assertThat(actualTitle, is(equalToIgnoringCase(searchTerm)));
        assertThat(actualThumNail, is(equalToIgnoringCase(searchTerm)));
        assertThat(actualCurrentUrl, containsString(searchTerm));

    }

    @Test
    public void addProductToBasketTest() {
        helper.search("cable");
        String expected = helper.selectAnyProduct();
        helper.addProductToBasket();
        String actual = helper.getProuctsInBasket();
        assertThat(actual, is(equalToIgnoringCase(expected)));
    }

    public void addProductToBasketUsingFilters(){
        helper.search("cable");
        helper.selectPrice();
        helper.selectAnyProduct();
        helper.addProductToBasket();
        String actual = helper.getProuctsInBasket();
        assertThat(actual, is(equalToIgnoringCase("")));

    }
}
