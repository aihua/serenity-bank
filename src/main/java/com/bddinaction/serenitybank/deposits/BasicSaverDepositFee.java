package com.bddinaction.serenitybank.deposits;

import java.math.BigDecimal;
import java.util.function.Function;

public class BasicSaverDepositFee implements Function<BigDecimal, BigDecimal> {

    private static BigDecimal SMALL_SAVER_RATE = new BigDecimal("0.50");
    private static BigDecimal MEDIUM_SAVER_RATE = new BigDecimal("1.00");
    private static BigDecimal LARGE_SAVER_RATE = new BigDecimal("1.25");

    @Override
    public BigDecimal apply(BigDecimal amount) {
        if (isSmallDeposit(amount)) {
            return SMALL_SAVER_RATE;
        }
        if (isMediumDeposit(amount)) {
            return MEDIUM_SAVER_RATE;
        }
        return LARGE_SAVER_RATE;
    }

    private boolean isSmallDeposit(BigDecimal amount) {
        return amount.compareTo(new BigDecimal("100.00")) <= 0;
    }

    private boolean isMediumDeposit(BigDecimal amount) {
        return amount.compareTo(new BigDecimal("100.00")) > 0 && amount.compareTo(new BigDecimal("1000.00")) <= 0;
    }

}
