/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shoplog;

/**
 * Date 17/04/2018
 * @author Mohamad Harah
 */
public class FootWear extends Product {
    
    private int size;

    public FootWear() {
        super();
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public FootWear(int size, int productId, String productName, double price, int StockLevel) {
        super(productId, productName, price, StockLevel);
        this.size = size;
    }
    public FootWear(int size,String productName, double price, int StockLevel) {
        super(productName, price, StockLevel);
        this.size = size;
    }

    
}
