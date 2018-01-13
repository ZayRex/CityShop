/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shoplog;

/**
 *
 * @author 30213076
 */
public class Clothing extends Product {
    
    private String Measurment;

    public Clothing() {
        super();
    }

    public Clothing(String Measurment, int productId, String productName, double price, int StockLevel) {
        super(productId, productName, price, StockLevel);
        this.Measurment = Measurment;
    }

    public String getMeasurment() {
        return Measurment;
    }

    public void setMeasurment(String Measurment) {
        this.Measurment = Measurment;
    }

    @Override
    public String toString() {
        return "Clothing{" + "Measurment=" + Measurment + '}';
    }
    
    
    
}
