package nop;

import org.openqa.selenium.support.PageFactory;
import utils.BrowserFactory;

/**
 * Created by Acer on 11/12/2016.
 */
public class BasePage extends BrowserFactory{
    public BasePage(){
        PageFactory.initElements(driver, this);

    }
}
