package pt.com.viniciusfac.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Supplier {

    private static Map<Integer, List<String>> supplierMap;
    static {
    	supplierMap = new HashMap<Integer, List<String>>();

        List<String> supplierSet01 = new ArrayList<String>();
        supplierSet01.add("black_mug");//product_name
        supplierSet01.add("Shirts4U");//supplier
        supplierSet01.add("1");//delivery_times_eu
        supplierSet01.add("6");//delivery_times_us
        supplierSet01.add("2");//delivery_times_uk
        supplierSet01.add("3");//in_stock
        supplierMap.put(1, supplierSet01);

        List<String> supplierSet02 = new ArrayList<String>();
        supplierSet02.add("blue_t-shirt");//product_name
        supplierSet02.add("Best Tshirts");//supplier
        supplierSet02.add("1");//delivery_times_eu
        supplierSet02.add("5");//delivery_times_us
        supplierSet02.add("2");//delivery_times_uk
        supplierSet02.add("10");//in_stock
        supplierMap.put(2, supplierSet02);

        List<String> supplierSet03 = new ArrayList<String>();
        supplierSet03.add("white_mug");//product_name
        supplierSet03.add("Shirts Unlimited");//supplier
        supplierSet03.add("1");//delivery_times_eu
        supplierSet03.add("8");//delivery_times_us
        supplierSet03.add("2");//delivery_times_uk
        supplierSet03.add("3");//in_stock
        supplierMap.put(3, supplierSet03);

        List<String> supplierSet04 = new ArrayList<String>();
        supplierSet04.add("black_mug");//product_name
        supplierSet04.add("Shirts Unlimited");//supplier
        supplierSet04.add("1");//delivery_times_eu
        supplierSet04.add("7");//delivery_times_us
        supplierSet04.add("2");//delivery_times_uk
        supplierSet04.add("4");//in_stock
        supplierMap.put(4, supplierSet04);
        
        List<String> supplierSet05 = new ArrayList<String>();
        supplierSet05.add("pink_t-shirt");//product_name
        supplierSet05.add("Shirts4U");//supplier
        supplierSet05.add("1");//delivery_times_eu
        supplierSet05.add("6");//delivery_times_us
        supplierSet05.add("2");//delivery_times_uk
        supplierSet05.add("8");//in_stock
        supplierMap.put(5, supplierSet05);
        
        List<String> supplierSet06 = new ArrayList<String>();
        supplierSet06.add("pink_t-shirt");//product_name
        supplierSet06.add("Best Tshirts");//supplier
        supplierSet06.add("1");//delivery_times_eu
        supplierSet06.add("3");//delivery_times_us
        supplierSet06.add("2");//delivery_times_uk
        supplierSet06.add("2");//in_stock
        supplierMap.put(6, supplierSet06);
        
    }

	public static Map<Integer, List<String>> getSupplierMap() {
		return supplierMap;
	}

}
