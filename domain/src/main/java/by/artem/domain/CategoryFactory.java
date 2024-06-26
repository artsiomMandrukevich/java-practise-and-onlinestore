package by.artem.domain;

import by.artem.domain.categories.Bike;
import by.artem.domain.categories.Milk;
import by.artem.domain.categories.Phone;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class CategoryFactory {

    final static Map<CategoryType, Supplier<Category>> CATEGORY_TYPE_MAP = new HashMap<CategoryType, Supplier<Category>>(){{
        put(CategoryType.BIKE, Bike::new);
        put(CategoryType.MILK, Milk::new);
        put(CategoryType.PHONE, Phone::new);
    }};

    public Category getCategory(CategoryType type){
        return type != null ? CATEGORY_TYPE_MAP.get(type).get() : null;
    }

}
