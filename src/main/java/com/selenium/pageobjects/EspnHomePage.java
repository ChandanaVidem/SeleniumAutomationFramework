package com.selenium.pageobjects;
import com.selenium.baseactions.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class EspnHomePage extends Base {
    WebDriver webDriver;
    @FindBy(xpath = "//img[@class='logo']")
    public WebElement logo;
    @FindBy(xpath = "//a[text()='Live Scores']")
    public WebElement liveScores;
    @FindBy(xpath = "//a[text()='Series']")
    public WebElement series;
    @FindBy(xpath = "//span[text()='Live']")
    public WebElement live;
    @FindBy(xpath = "//div[@class='ds-truncate']//following-sibling::span")
    public WebElement liveMatchDetails;
    @FindBy(xpath = "//strong[text()='Live']")
    public WebElement liveMatch;
    @FindBy(xpath = "//div[@class='ds-text-tight-m ds-font-regular ds-text-typo-mid3']")
    public WebElement liveMatchInfo;
    @FindBy(xpath = "(//div[@class='ci-team-score ds-flex ds-justify-between ds-items-center ds-text-typo ds-mb-2']//following-sibling::a)[1]")
    public WebElement teamOne;
    @FindBy(xpath = "(//div[@class='ci-team-score ds-flex ds-justify-between ds-items-center ds-text-typo ds-mb-2']//following-sibling::a)[2]")
    public WebElement teamTwo;
    @FindBy(xpath = "//div[@class='ds-text-compact-m ds-text-typo ds-text-right ds-whitespace-nowrap fadeIn-exit-done']//span")
    WebElement team2overDetails;
    @FindBy(xpath = "//div[@class='ds-text-compact-m ds-text-typo ds-text-right ds-whitespace-nowrap fadeIn-exit-done']//strong")
    WebElement team2Score;
    @FindBy(xpath = "//div[@class='ds-text-compact-m ds-text-typo ds-text-right ds-whitespace-nowrap']//span")
    WebElement team1overDetails;
    @FindBy(xpath = "//div[@class='ds-text-compact-m ds-text-typo ds-text-right ds-whitespace-nowrap']//strong")
    WebElement team1Score;
    @FindBy(xpath = "//i[@class='icon-dot_circular ds-text-icon-error hover:ds-text-icon-error-hover']")
    WebElement dot;
    @FindBy(xpath = "//div[@class='ci-team-score ds-flex ds-justify-between ds-items-center ds-text-typo ds-mb-2']//div//i//parent::div")
    WebElement currentPlayingTeam;
    public EspnHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(webDriver, this);
    }
    public void getTest(){
        webDriver.findElement(By.xpath("xpath")).isDisplayed();
        webDriver.switchTo().defaultContent();

    }
}
