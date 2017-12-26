package bgu.testing.identifyCuses2;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.util.List;

public class TestGlobalCuses {
    @Test
    public void GolbalCuesesTest() {
        GlobalCuses globalCuss = new GlobalCuses();
        List<String> allCusesForVar = globalCuss.findCUsesInMethod("src" + File.separatorChar + "test" + File.separatorChar + "resources" + File.separatorChar + "CUsesInputNoConditions.java", "c");
        Assert.assertEquals(allCusesForVar.size(), 1);
    }

}
