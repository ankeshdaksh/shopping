package nop;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import utils.BrowserFactory;

/**
 * Created by Acer on 11/12/2016.
 */
public class Hooks {

    @Before
    public static void setUp(){
        BrowserFactory.openBrowser();
    }

    @After
    public static void teaDown(){
        BrowserFactory.closeBrowser();
    }
}
