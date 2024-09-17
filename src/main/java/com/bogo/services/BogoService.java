package com.bogo.services;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ArrayList;

@Service
public class BogoService {

	public Map<String, List<Integer>> maximizeDiscount(List<Integer> productPrices) {
		Map<String, List<Integer>> prodDiscount = new HashMap<>();
		productPrices.sort(Comparator.naturalOrder());
        int n = productPrices.size();
        
        List<Integer> payableItems = new ArrayList<>();
        List<Integer> freeItems = new ArrayList<>();

        for (int i = n - 1; i >= 0; i -= 2) {
            payableItems.add(productPrices.get(i));
            
            if (i - 1 >= 0) {
                freeItems.add(productPrices.get(i - 1));
            }
        }
        
        prodDiscount.put("PayableItems", payableItems);
        prodDiscount.put("DiscountedItems", freeItems);
        
        return prodDiscount;
    }
}
