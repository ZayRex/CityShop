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
public class Clothing extends Product {
    
    private String Measurement;

    public Clothing() {
        super();
    }

    public Clothing(String Measurement, int productId, String productName, double price, int StockLevel) {
        super(productId, productName, price, StockLevel);
        this.Measurement = Measurement;
    }
     public Clothing(String Measurement, String productName, double price, int StockLevel) {
        super(productName, price, StockLevel);
        this.Measurement = Measurement;
    }

    public String getMeasurement() {
        return Measurement;
    }

    public void setMeasurment(String Measurment) {
        this.Measurement = Measurment;
    }

    
}
