package seleniumBase;

import org.openqa.selenium.WebElement;

public interface SelenBase {
	
	//Setup Concept
	/**
	 * This method will launch the chrome browser with the giver URL
	 * @author Dhanakodi
	 * @param url
	 */
	void setUp(String url);
	
	/**
	 * This method will launch the chrome browser with the given URL 
	 * @param browser
	 * @param url
	 * @exception NullPointerException,Urlmalfunction
	 * \\
	 */
	void setUp(Browser browser, String url);
	
	//close concept
	void close();
	void quit();
	
	//Element Concept
	/**
	 * This method is used to find any webelement with this page
	 * @param type - element type eg. id,name or linkedText
	 * @param value - element value
	 * @return WebELement
	 */
	WebElement element(Locators type, String value);
	
	//Window Handling Concept
	void switchToWindow(int i);
	
	//Select Concept
	void selectValue(WebElement ele, String value);
	void selectText(WebElement ele, String text);
	void selectIndex(WebElement ele, int position);
	
	//Click Concept
	void click(WebElement ele);
	
	//Type Concept
	void type(WebElement ele);
	
	//AppendText Concept
	void appendText(WebElement ele);
	
	String getTitle();
	String getUrl();
	boolean isDisplayed();
	boolean isSelected();
	boolean isEnabled();
	
	

}
