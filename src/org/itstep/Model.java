package org.itstep;

import java.util.ArrayList;
import java.util.Arrays;

public class Model {
    private int value;
    private int random;
    private int minBarrier=0;
    private int maxBarrier=100;
      ArrayList<Integer> statistic = new ArrayList<Integer>();

    public void randomNumberInDiapazon(int minBarrier,int maxBarrier) {
        random = (int) (Math.random() * (maxBarrier-minBarrier+1)+minBarrier);
    }
    
    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
    public int getRandom() {
        return random;
    }

    public int getMinBarrier() {
        return minBarrier;
    }

    public int getMaxBarrier() {
        return maxBarrier;
    }

    public boolean setMinBarrier(int minBarrier) {
        this.minBarrier = minBarrier;
        return true;
    }

    public boolean setMaxBarrier(int maxBarrier) {
        this.maxBarrier = maxBarrier;
        return true;
    }
    
    public boolean isGuessed() {
        if (random == value) {
            return true;
        }
        return false;
    }

    public boolean newMinBarrier() {
        if (value < random) {
            setMinBarrier(value);
            return true;
        }
        return false;
    }

    public boolean newMaxBarrier() {
        if (value > random) {
            setMaxBarrier(value);
            return true;
        }
        return false;
    }

    public void setStatistic() {
        statistic.add(minBarrier);
        statistic.add(maxBarrier);
        statistic.add(value);
    }

    public void printStatistic() {
       // System.out.println(Arrays.toString(statistic.toArray()));
        statisticToString();
    }

    public void statisticToString() {
        for (int i = 0; i <= statistic.size() - 3; i += 3) {
            System.out.print("Min=" + statistic.get(i)+" " + "Max=" + statistic.get(i + 1)+" " + " Your number=" + statistic.get(i + 2) + "\n");
        }
    }

}
