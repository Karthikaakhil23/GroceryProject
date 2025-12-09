package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;


public class PageUtilities {
	//Select class
	public void selectByVisibleText(WebElement element,String visibleText) {
		Select select =new Select(element);
		select.selectByVisibleText(visibleText);	
	}
	
	public void selectByIndex(WebElement element,int index) {
		Select select =new Select(element);
		select.selectByIndex(index);	
	}
	
	public void selectByValue(WebElement element,String value) {
		Select select =new Select(element);
		select.selectByValue(value);	
	}
	//Action class
	public void dragAndDrop(WebDriver driver,WebElement element1, WebElement element2)
	{
		
		Actions action = new Actions(driver);
		action.dragAndDrop(element1, element2);	
	}
	
	public void rightClick(WebDriver driver,WebElement element)
	{

		Actions action = new Actions(driver);
		action.contextClick(element).perform();	
	}
	
	public void mouseHover(WebDriver driver,WebElement element)
	{
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();	
	}
	public void doubleClick(WebDriver driver,WebElement element)
	{
		Actions action = new Actions(driver);
		action.doubleClick(element).perform();
	}
	public void click(WebDriver driver,WebElement element)
	{
		Actions action = new Actions(driver);
		action.click(element).perform();
	}
	//JavaExecutor
	public void javaScriptUsingSendKeys( WebDriver driver,WebElement element )
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value='value';", element);
	}
	public void javaScriptUsingClick( WebDriver driver,WebElement element )
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	}
	public void scroll(WebDriver driver, int x, int y)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(x,y)", "");
	}
	public void scrollTillEnd(WebDriver driver, int scrollHeight)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)", "");
	}


}
