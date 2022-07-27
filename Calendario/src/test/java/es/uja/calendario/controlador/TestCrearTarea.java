package es.uja.calendario.controlador;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.test.context.ActiveProfiles;



import es.uja.calendario.entidades.Usuario;
import es.uja.calendario.interfaces.SistemaTareas;

@ActiveProfiles("test")
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class TestCrearTarea {
	
	@LocalServerPort
	private int serverPort;

	@Autowired
	private WebDriver driver;
	
	@Autowired
	SistemaTareas sistema;
	
	private String appUrl;
	
	private Usuario user;
	
	@PostConstruct
	public void initDAO() {
		appUrl = String.format("http://localhost:%d", serverPort);

		// Preload sample users
		user = new Usuario("admin", "123456", "123456");
		sistema.nuevoUsuario(user);
	}
	
	@Test
	  public void testCrearUsuario() {
	    driver.get(appUrl);
	    driver.manage().window().setSize(new Dimension(1064, 819));
	    driver.findElement(By.linkText("Registrarse")).click();
	    driver.findElement(By.id("username")).click();
	    driver.findElement(By.id("username")).click();
	    {
	      WebElement element = driver.findElement(By.id("username"));
	      Actions builder = new Actions(driver);
	      builder.doubleClick(element).perform();
	    }
	    driver.findElement(By.id("username")).sendKeys("test");
	    driver.findElement(By.id("usuario")).click();
	    driver.findElement(By.id("password")).click();
	    driver.findElement(By.id("password")).click();
	    {
	      WebElement element = driver.findElement(By.id("password"));
	      Actions builder = new Actions(driver);
	      builder.doubleClick(element).perform();
	    }
	    driver.findElement(By.id("password")).sendKeys("test");
	    driver.findElement(By.id("passwordConfirm")).click();
	    driver.findElement(By.id("passwordConfirm")).sendKeys("test");
	    driver.findElement(By.cssSelector(".btn-primary:nth-child(1)")).click();
	    driver.findElement(By.id("CuentaCreada")).click();
	    driver.findElement(By.id("CuentaCreada")).click();
	    {
	      WebElement element = driver.findElement(By.id("CuentaCreada"));
	      Actions builder = new Actions(driver);
	      builder.doubleClick(element).perform();
	    }
	    assertThat(driver.findElement(By.id("CuentaCreada")).getText()).isEqualTo("El cuenta esta creado");
	    driver.findElement(By.cssSelector(".bi-box-arrow-in-right")).click();
	    driver.close();
	  }

	
	@TestConfiguration
	static class TestConfig {
		@Bean(destroyMethod = "quit")
		public WebDriver getDriver() {
			if (System.getProperty("os.name").startsWith("Windows"))
				System.setProperty("webdriver.chrome.driver",
						new java.io.File("").getAbsolutePath() + "//chromedriver.exe");
			else
				System.setProperty("webdriver.chrome.driver",
						new java.io.File("").getAbsolutePath() + "//chromedriver");
			WebDriver driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			return driver;
		}
	}




}
