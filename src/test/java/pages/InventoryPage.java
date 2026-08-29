package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class InventoryPage {

    WebDriver driverInventory;

    By inventoryPageTitle = By.xpath("//span[contains(@class, 'title') and text()='Producti']");

    By burgerMenu = By.id("react-burger-menu-btn");
    By menuAllItems = By.id("inventory_sidebar_link");
    By menuAbout = By.id("about_sidebar_link");
    By menuLogout = By.id("logout_sidebar_link");
    By menuResetState = By.id(("reset_sidebar_link"));


    By cartIcon = By.xpath("//div[contains(@id, 'shopping_cart_container')]/a[contains(@class, 'shopping_cart_link')]");

    By filterSelect = By.xpath("//select[@class= 'product_sort_container']");

    By productCards = By.className("inventory_item");

    By productNames = By.className("inventory_item_name");

    By productPrices = By.className("inventory_item_price");

    By addToCartButtons = By.className("btn_inventory");


    public InventoryPage(WebDriver driver) {
        this.driverInventory = driver;
    }


    public void verifyInventoryPage() {

        driverInventory.findElement(inventoryPageTitle).isDisplayed();
        driverInventory.findElement(burgerMenu).isDisplayed();
        driverInventory.findElement(cartIcon).isDisplayed();
    }


    public void clickProduct(String productName) {

        By product = By.xpath("//div[@class='inventory_item_name' and text()='" + productName + "']");

        driverInventory.findElement(product).click();
    }

    public void addProductToCart(String productName) {

        By product = By.xpath(
                "//div[contains(@class, 'inventory_item')]" +
                        "[.//div[contains(@class, 'inventory_item_name') and " +
                        "contains(translate(., 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), '" +
                        productName.toLowerCase() + "')]]" +
                        "//button[contains(@class, 'btn_inventory')]"
        );

        driverInventory.findElement(product).click();
    }

    public void sortItems(int sortOption) {

        Select filterDropdown = new Select(driverInventory.findElement(filterSelect));
        filterDropdown.selectByIndex(sortOption);
    }

    public void openBurgerMenu() {

        driverInventory.findElement(burgerMenu).click();

    }

    public void selectAllItems() {

        openBurgerMenu();
        driverInventory.findElement(menuAllItems).click();

    }

    public void selectAbout() {

        openBurgerMenu();
        driverInventory.findElement(menuAbout);

    }

    public void selectLogOut() {

        openBurgerMenu();
        driverInventory.findElement(menuLogout);

    }

    public void resetAppState() {

        openBurgerMenu();
        driverInventory.findElement(menuResetState);

    }

    public void clickCartIcon() {

        driverInventory.findElement(cartIcon).click();
    }

}