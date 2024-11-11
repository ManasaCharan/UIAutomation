package com.utils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CommonUtils {
    public static List<String> sortPrices(List<String> prices, String sortOrder) {
        if (sortOrder.equalsIgnoreCase("low to high")) {
            Collections.sort(prices);
        } else if (sortOrder.equalsIgnoreCase("high to low")) {
            Collections.sort(prices, Collections.reverseOrder());
        }
        return prices;
    }
}
