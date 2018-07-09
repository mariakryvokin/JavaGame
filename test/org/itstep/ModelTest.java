package org.itstep;


import org.junit.Assert;
import org.junit.Test;

public class ModelTest {
    private int[] randomTestDataAssertTrue = {5,15,66,66,32,44,1,99};

    @Test
    public void randomNumberInDiapazonTrue() {
        Model model = new Model();
        for(int i=0;i<randomTestDataAssertTrue.length;i+=2) {
            model.randomNumberInDiapazon(randomTestDataAssertTrue[i], randomTestDataAssertTrue[i+1]);
            Assert.assertTrue(model.getRandom() >= randomTestDataAssertTrue[i] & model.getRandom() <= randomTestDataAssertTrue[i+1]);
        }
    }
    @Test
    public void randomNumberInDiapazonFalse() {
        Model model = new Model();
        for (int i = 0; i < randomTestDataAssertTrue.length; i += 2) {
            model.randomNumberInDiapazon(randomTestDataAssertTrue[i], randomTestDataAssertTrue[i + 1]);
            Assert.assertFalse(model.getRandom() < randomTestDataAssertTrue[i] || model.getRandom() > randomTestDataAssertTrue[i + 1]);
        }
    }

    }
