package piguLt.tests.piguLt;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import piguLt.pages.piguLt.GiftCardPage;
import piguLt.tests.TestBase;

public class GiftCardTest extends TestBase {
    @BeforeMethod
    @Override
    public void setUp() {
        super.setUp();
        GiftCardPage.open("https://pigu.lt/lt/dovanu-kuponai");
        GiftCardPage.acceptPrivacyConfirmation();
    }
    @Test
    private void testSearchGiftCardAtPrice50Eu(){
        String expectedFind ="El. Dovanų kuponas, €50";
        String actualfind = null;
        String maxPrice = "50";

        GiftCardPage.clickOnPiguLtKuponai();
        GiftCardPage.waitForPiguLtKuponaiPage();
        GiftCardPage.clickOnFiltraiButton();
        GiftCardPage.waitForFiltraiPage();
        GiftCardPage.doubleClickOnPrice();
        GiftCardPage.enetrMaxPrice(maxPrice);
        GiftCardPage.clickToCloseFiltrai();
        GiftCardPage.waitForGiftCardPage();
        GiftCardPage.clickOnNeededGiftCsrd();
        GiftCardPage.waitFor50EUGifCardPageLoad();

        actualfind = GiftCardPage.readGiftCardName();
        Assert.assertTrue(actualfind.contains(expectedFind),
                String.format("Actual [%s]; Expected [%s]",
                        actualfind,
                        expectedFind)
        );



    }
}
