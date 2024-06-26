package enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Arrays;

import static engine.cookie.manager.CookieManager.getCookieManagerInstance;

@Getter
@ToString
@RequiredArgsConstructor
public enum Currency {
    EUR("€"),
    GBP("£"),
    USD("$");

    public final String currencySymbol;

    public static BigDecimal getPriceAsBigDecimal(String priceWithSymbol, Currency currency) {
        var currencySymbol = currency.getCurrencySymbol();
        return new BigDecimal(priceWithSymbol
                .replace(currencySymbol, ""));
    }

    public static BigDecimal getPriceAsBigDecimal(String priceWithSymbol) {
        return getPriceAsBigDecimal(priceWithSymbol, getCookieManagerInstance().globalCurrency);
    }

    public static Currency getCurrencyFromSymbol(String currencySymbol) {
        return Arrays.stream(Currency.values())
                .filter(currency -> currency.getCurrencySymbol().equals(currencySymbol))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No matching currency for symbol: " + currencySymbol));
    }
}