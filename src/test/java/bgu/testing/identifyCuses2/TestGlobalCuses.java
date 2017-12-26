package bgu.testing.identifyCuses2;

import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.List;

public class TestGlobalCuses {
    @Test
    public void GolbalCuesesTest() {
        GlobalCuses globalCuss = new GlobalCuses();
        List<String> allCusesForVar = globalCuss.findCUsesInMethod("src\\test\\resources\\CUsesInputNoConditions.java","c");
        Assert.assertEquals(allCusesForVar.size(), 1);
    }

}
