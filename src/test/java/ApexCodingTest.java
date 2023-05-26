import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import java.util.List;
import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.url;

public class ApexCodingTest {
    public static void main(String[] args) {

        open("https://test.salesforce.com/");
        $(By.xpath("//*[@id=\"username\"]")).setValue("login");
        $(By.xpath("//*[@id=\"password\"]")).setValue("password");
        $(By.xpath("//*[@id=\"Login\"]")).click();
        timeout = 15000;

        String currentUrl = url();
        String newUrl = currentUrl.replace("/lightning/page/home", "/_ui/common/apex/debug/ApexCSIPage");
        open(newUrl);

//Number of Apex classes
        $(By.xpath("//*[@id=\"queryEditorText-inputEl\"]")).setValue("select count() from ApexClass");
        $(By.xpath("//*[@id=\"queryExecuteButton-btnInnerEl\"]")).click();
        SelenideElement stringWithCountElem = $(By.xpath("//div[@id='selectcount()fromApexClass']//span[contains(text(), 'Query Results - Total Rows:')]"));
        stringWithCountElem.shouldBe(Condition.visible);
        List<SelenideElement> stringWithCount =
                $$(By.xpath("//div[@id='selectcount()fromApexClass']//span[contains(text(), 'Query Results - Total Rows:')]"));
        String countOfElements = stringWithCount.get(0).getText().replaceAll("[^\\d.]+", "");
        int NumberOfApexClasses = Integer.parseInt(countOfElements);

//Number of Apex classes without namespace
        refresh();
        $(By.xpath("//*[@id=\"queryEditorText-inputEl\"]")).setValue("select count() from ApexClass where NamespacePrefix = null");
        $(By.xpath("//*[@id=\"queryExecuteButton-btnInnerEl\"]")).click();
        SelenideElement stringWithCountElem2 = $(By.xpath("//div[@id='selectcount()fromApexClasswhereNamespacePrefix=null']//span[contains(text(), 'Query Results - Total Rows:')]"));
        stringWithCountElem2.shouldBe(Condition.visible);
        List<SelenideElement> stringWithCount2 =
                $$(By.xpath("//div[@id='selectcount()fromApexClasswhereNamespacePrefix=null']//span[contains(text(), 'Query Results - Total Rows:')]"));
        String countOfElements2 = stringWithCount2.get(0).getText().replaceAll("[^\\d.]+", "");
        int NumberOfApexClassesWithoutNamespace = Integer.parseInt(countOfElements2);

//Number of Apex classes with namespaces
        refresh();
        $(By.xpath("//*[@id=\"queryEditorText-inputEl\"]")).setValue("select count() from ApexClass where NamespacePrefix != null");
        $(By.xpath("//*[@id=\"queryExecuteButton-btnInnerEl\"]")).click();
        SelenideElement stringWithCountElem3 = $(By.xpath("//div[@id='selectcount()fromApexClasswhereNamespacePrefix!=null']//span[contains(text(), 'Query Results - Total Rows:')]"));
        stringWithCountElem3.shouldBe(Condition.visible);
        List<SelenideElement> stringWithCount3 =
                $$(By.xpath("//div[@id='selectcount()fromApexClasswhereNamespacePrefix!=null']//span[contains(text(), 'Query Results - Total Rows:')]"));
        String countOfElements3 = stringWithCount3.get(0).getText().replaceAll("[^\\d.]+", "");
        int NumberOfApexClassesWithNamespace = Integer.parseInt(countOfElements3);

//Number of Apex Triggers
        refresh();
        $(By.xpath("//*[@id=\"queryEditorText-inputEl\"]")).setValue("select count() from ApexTrigger");
        $(By.xpath("//*[@id=\"queryExecuteButton-btnInnerEl\"]")).click();
        SelenideElement stringWithCountElem4 = $(By.xpath("//div[@id='selectcount()fromApexTrigger']//span[contains(text(), 'Query Results - Total Rows:')]"));
        stringWithCountElem4.shouldBe(Condition.visible);
        List<SelenideElement> stringWithCount4 =
                $$(By.xpath("//div[@id='selectcount()fromApexTrigger']//span[contains(text(), 'Query Results - Total Rows:')]"));
        String countOfElements4 = stringWithCount4.get(0).getText().replaceAll("[^\\d.]+", "");
        int NumberOfApexTriggers = Integer.parseInt(countOfElements4);

//Visualforce pages
        refresh();
        $(By.xpath("//*[@id=\"queryEditorText-inputEl\"]")).setValue("select count() from ApexPage");
        $(By.xpath("//*[@id=\"queryExecuteButton-btnInnerEl\"]")).click();
        SelenideElement stringWithCountElem5 = $(By.xpath("//div[@id='selectcount()fromApexPage']//span[contains(text(), 'Query Results - Total Rows:')]"));
        stringWithCountElem5.shouldBe(Condition.visible);
        List<SelenideElement> stringWithCount5 =
                $$(By.xpath("//div[@id='selectcount()fromApexPage']//span[contains(text(), 'Query Results - Total Rows:')]"));
        String countOfElements5 = stringWithCount5.get(0).getText().replaceAll("[^\\d.]+", "");
        int NumberOfVisualForcePages = Integer.parseInt(countOfElements5);

//Aura components
        refresh();
        $(By.xpath("//*[@id=\"queryEditorText-inputEl\"]")).setValue("select count() from AuraDefinition where DefType = 'COMPONENT'");
        $(By.xpath("//*[@id=\"queryExecuteButton-btnInnerEl\"]")).click();
        SelenideElement stringWithCountElem6 = $(By.xpath("//div[@id=\"selectcount()fromAuraDefinitionwhereDefType='COMPONENT'\"]//span[contains(text(), 'Query Results - Total Rows:')]"));
        stringWithCountElem6.shouldBe(Condition.visible);
        List<SelenideElement> stringWithCount6 =
                $$(By.xpath("//div[@id=\"selectcount()fromAuraDefinitionwhereDefType='COMPONENT'\"]//span[contains(text(), 'Query Results - Total Rows:')]"));
        String countOfElements6 = stringWithCount6.get(0).getText().replaceAll("[^\\d.]+", "");
        int NumberOfAuraComponents = Integer.parseInt(countOfElements6);

//LWC components
        refresh();
        $(By.xpath("//*[@id=\"queryEditorText-inputEl\"]")).setValue("select count() from LightningComponentBundle");
        $(By.xpath("//*[@id=\"useToolingAPI-inputEl\"]")).click();
        $(By.xpath("//*[@id=\"queryExecuteButton-btnInnerEl\"]")).click();
        SelenideElement stringWithCountElem7 = $(By.xpath("//div[@id='selectcount()fromLightningComponentBundle']//span[contains(text(), 'Query Results - Total Rows:')]"));
        stringWithCountElem7.shouldBe(Condition.visible);
        List<SelenideElement> stringWithCount7 =
                $$(By.xpath("//div[@id='selectcount()fromLightningComponentBundle']//span[contains(text(), 'Query Results - Total Rows:')]"));
        String countOfElements7 = stringWithCount7.get(0).getText().replaceAll("[^\\d.]+", "");
        int NumberOfLWCComponents = Integer.parseInt(countOfElements7);

//Percent of Apex Used
        String currentUrl2 = url();
        String newUrl2 = currentUrl2.replace("/_ui/common/apex/debug/ApexCSIPage", "/lightning/setup/ApexClasses/home");
        open(newUrl2);
        switchTo().frame(0);
        List<SelenideElement> stringWithPercent =
                $$(By.xpath("//h4[contains(text(), 'Percent of Apex Used:')]"));
        String percent = stringWithPercent.get(0).getText().replaceAll("[^\\d.]+", "");
        double PercentOfApexUsed = Double.parseDouble(percent);

//Percent of code coverage
        $(By.xpath("//*[@id=\"all_classes_page:theTemplate:messagesForm:calcLink\"]")).click();
        List<SelenideElement> codeCoverage =
                $$(By.xpath("//h4[contains(text(), 'Code Coverage:')]"));
        String percent2 = codeCoverage.get(0).getText().replaceAll("[^\\d.]+", "");
        double codeCoveragePercent = Double.parseDouble(percent2);

        System.out.println("Number of Apex classes = " + NumberOfApexClasses);
        System.out.println("Number of Apex classes without namespace = " + NumberOfApexClassesWithoutNamespace);
        System.out.println("Number of Apex classes with namespace = " + NumberOfApexClassesWithNamespace);
        System.out.println("Number of Apex triggers = " + NumberOfApexTriggers);
        System.out.println("Number of Visualforce pages = " + NumberOfVisualForcePages);
        System.out.println("Number of Aura Components  = " + NumberOfAuraComponents);
        System.out.println("Number of LWC Components  = " + NumberOfLWCComponents);
        System.out.println("Percent of Apex Used  = " + PercentOfApexUsed);
        System.out.println("Percent of Code Coverage  = " + codeCoveragePercent);

    }
}