package Ashot;

import java.io.IOException;
import java.sql.Date;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;
import screenShot.File;

public class Ashot
{
	private static WebDriver driver;
	public static void takeScreenShotEntireWebPage(AShot a, Screenshot sc)
	{
		Date d = new Date(0);
		sc = a.shootingStrategy(ShootingStrategies.viewportPasting(2000)).takeScreenshot(driver);
		try {
			ImageIO.write(sc.getImage(), "JPG", new File("./ScreenShotImages/" + d.toString() + ".jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) 
	{
		
		driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.timesofindia.com");
		AShot a = new AShot();
		Screenshot sc = a.takeScreenshot(driver);
		takeScreenShotEntireWebPage(a, sc);
	}

}
