package apium.config;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class AppiumDriverConfig {

    public static RemoteWebDriver initAndroidChrome() {
        RemoteWebDriver driver = null;
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
        caps.setCapability("chromedriverExecutable", "C:\\Users\\ameli\\Desktop\\chromedriver.exe");
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "7.0");//указываем версию Android
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");//Имя OS
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");//Сообщаем, что будет использоваться эмулятор
        caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 1800);
        try {
            driver = new RemoteWebDriver(new URL("http://192.168.56.1:4723/wd/hub"), caps);
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return driver;
    }

    public static AndroidDriver initAndroidDriver(){
        AndroidDriver driver=null;
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "7.0");//указываем версию Android
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");//Имя OS
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");//Сообщаем, что будет использоваться эмулятор
        caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 1800);
        caps.setCapability("appPackage", "com.weather.Weather");//"");
        caps.setCapability("appActivity", "com.weather.Weather.app.SplashScreenActivity");
        //       caps.setCapability(MobileCapabilityType.NO_RESET,true);


        try {
            driver = new AndroidDriver(new URL("http://127.0.0.1:4724/wd/hub"), caps);

//            while (!driver.currentActivity().contains("MainActivity")){
//            System.out.println(driver.get);
//                Thread.sleep(1000);
//            }
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);



        } catch (Exception e) {
            e.printStackTrace();
        }
        return driver;
    }
}
