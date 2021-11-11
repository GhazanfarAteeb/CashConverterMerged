package com.app.cashconvertermerged;


import java.math.BigDecimal;
import java.math.RoundingMode;

public class CashConverter {
    public static String[] cashTypes = {
            "€",
            "US$",
            "RMB"
    };


    private double convertToSiUnit(double value, int key) {
        double val = 0;
        switch(key) {
            case 0:
                val = value;
                break;
            case 1:
                val = value * 0.87;
                break;
            case 2:
                val = value / 7.36;
                break;
        }

        return val;
    }

    private double convertSIUnitToResult(double SIUnit, int key) {
        double val = 0;
        switch(key) {
            case 0:
                val = SIUnit;
                break;
            case 1:
                val = SIUnit / 0.87;
                break;
            case 2:
                val = SIUnit * 7.36;
                break;
        }

        return val;
    }
    public String getResult(double value, int convertFrom, int convertTo) {
        double SIUnit = convertToSiUnit(value, convertFrom);
        double result = convertSIUnitToResult(SIUnit, convertTo);

        BigDecimal res = new BigDecimal(Double.toString(result));
        res = res.setScale(12, RoundingMode.HALF_UP);

        return "" + res.doubleValue();
    }
}

