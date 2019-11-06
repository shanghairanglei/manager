package com.rl.utils;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class BusinessToolUtil {

    /**
     * 加法
     *
     * @param num1  被加数
     * @param num2  加数
     * @param digit 保留位数
     * @return
     * @throws NumberFormatException
     */
    public double add(double num1, double num2, int digit) throws NumberFormatException {
        BigDecimal bd1 = new BigDecimal(Double.toString(num1));
        BigDecimal bd2 = new BigDecimal(Double.toString(num2));
        return bd1.add(bd2).setScale(digit, RoundingMode.HALF_UP).doubleValue();
    }


    /**
     * 减法
     *
     * @param num1  被减数
     * @param num2  减数
     * @param digit 保留位数
     * @return
     * @throws NumberFormatException
     */
    public double sub(double num1, double num2, int digit) throws NumberFormatException {
        BigDecimal bd1 = new BigDecimal(Double.toString(num1));
        BigDecimal bd2 = new BigDecimal(Double.toString(num2));
        return bd1.subtract(bd2).setScale(digit, RoundingMode.HALF_UP).doubleValue();
    }


    /**
     * 乘积
     *
     * @param num1  被乘数
     * @param num2  乘数
     * @param digit 保留位数
     * @return
     * @throws NumberFormatException
     */
    public double mul(double num1, double num2, int digit) throws NumberFormatException {
        BigDecimal bd1 = new BigDecimal(Double.toString(num1));
        BigDecimal bd2 = new BigDecimal(Double.toString(num2));
        return bd1.multiply(bd2).setScale(digit, RoundingMode.HALF_UP).doubleValue();
    }

    /**
     * 除法
     *
     * @param num1  被除数
     * @param num2  除数
     * @param digit
     * @return
     * @throws NumberFormatException
     */
    public double div(double num1, double num2, int digit) throws NumberFormatException {
        BigDecimal bd1 = new BigDecimal(Double.toString(num1));
        BigDecimal bd2 = new BigDecimal(Double.toString(num2 == 0 ? 1 : num2));
        return bd1.divide(bd2, digit, BigDecimal.ROUND_HALF_UP).doubleValue();

    }


}


