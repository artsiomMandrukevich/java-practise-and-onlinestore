package by.artem.store;

import by.artem.domain.Category;
import by.artem.domain.Product;

import java.util.ArrayList;
import java.util.List;

public class Store {

    private List<Category> productCategoryList;

    private Store(){
        this.productCategoryList = new ArrayList<>();
    }

    public List<Product> getAllProducts(){
        List<Product> listProduct = new ArrayList<>();
        for(Category outputList : this.productCategoryList) {
            listProduct.addAll(outputList.getProductList());
        }
        return listProduct;
    }

    private static class SingletoneHelper{
        private static final Store storeInstance = new Store();
    }


    public static Store getInstance(){
        return SingletoneHelper.storeInstance;

    }

    public void setProductCategoryList(Category category) {
        this.productCategoryList.add(category);
    }

    public void printProduct(List<Product> products){
        for(Product productList : products){
            System.out.println(productList.getName() + " " + productList.getPrice() + " " + productList.getRate());
        }
    }

    public void printProductFromCategory(){
        for(Category outputList : this.productCategoryList) {
            System.out.println("Category = " + outputList.getName());
            printProduct(outputList.getProductList());
        }
    }

}