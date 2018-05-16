package com.raj.Utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.raj.Base.TestBase;

public class JSUtils extends TestBase{

	
	///////////////// click
	public static void jsclick(WebElement ele) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", ele);
	}
	
	///////////////// highlight element
	public static void jshighlight(WebElement ele) {
		String bgcolor = ele.getCssValue("backgroundColor");
		
		for (int i=0; i<10; i++) {
			changeColor("rgb(200,0,0)", ele);
			changeColor(bgcolor, ele);
		}
	}

	///////////////// change color
	public static void changeColor(String color, WebElement ele) {
		JavascriptExecutor js = (JavascriptExecutor) driver;		
		js.executeScript("arguments[0].style.backgroundColor = '"+color+"'", ele);
		
		try {
			Thread.sleep(20);
		} catch(Exception e) {
			e.printStackTrace();
		}
			
	}

	///////////////// draw border
	public static void jsdrawborder(WebElement ele) {
		JavascriptExecutor js = (JavascriptExecutor) driver;		
		js.executeScript("arguments[0].style.border='3px solid red'", ele);
	}

	///////////////// alert
	public static void jsalert(String msg) {
		JavascriptExecutor js = (JavascriptExecutor) driver;		
		js.executeScript("alert('"+msg+"')");
	}

	///////////////// refresh
	public static void jsrefresh() {
		JavascriptExecutor js = (JavascriptExecutor) driver;		
		js.executeScript("history.go(0)");
	}

	///////////////// gettitle
	public static String jstitle() {
		JavascriptExecutor js = (JavascriptExecutor) driver;		
		return js.executeScript("return document.title").toString();
	}

	///////////////// get inner text
	public static String jsinnertext() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		return js.executeScript("return document.documentElement.innerText;").toString();
	}

	///////////////// scroll page down
	public static void jsscroll() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}


	///////////////// scroll page until element view
	public static void jsscrollintoview(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;		
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	
	///////////////// select an date attribute with js
	public static void jsselectdate(WebElement ele, String date) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('value','"+date+"')';", ele);
	}

	
}
