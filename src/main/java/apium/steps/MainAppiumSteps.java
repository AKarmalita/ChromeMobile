package apium.steps;

import apium.util.Util;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;

public class MainAppiumSteps extends BaseAppiumSteps {

    @When("^Open site \"([^\"]*)\"$")
    public void openSite(String url) throws Throwable{
        driver.get(url);
    }

    @Then("Print list")
    public void printList() {
        By itList = By.id("swiper-coaches");
        Util.scrollToElementVisibilityOf(driver, itList);//Скрол в классе ютилс.
        WebElement element = driver.findElement(By.xpath("//div[contains(@class,\"swiper-slider_pagination\") " +
                "and contains(@class, \"swiper-pagination-clickable\") and contains(@class,\"swiper-pagination-bullets\") " +
                "and contains(@class,\"swiper-pagination-bullets-dynamic\")]"));
        List<WebElement> list = element.findElements(By.tagName("span"));
        for (int i=1;i<list.size();i++) {
            try{
                list.get(i).click();
                List<WebElement> webElementList = driver.findElements(By.className("coach-card_group"));
                for (WebElement t: webElementList){
                    String str = t.findElement(By.tagName("span")).getText();
                    if(!str.equals("")){
                        System.out.println(str);
                    }
                }
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }


}
