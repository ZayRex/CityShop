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
public class OrderLine {
    /**
     * Order line object class with attributes setters, getters, empty and loaded constructors
     */
    private int OrderLineId;
    private int Quantity;
    private double LineTotal;
    private Product product;

    public void setProduct(Product product) {
        this.product = product;
    }

    public Product getProduct() {
        return product;
    }

    public OrderLine() {
        
    }

    public OrderLine(int OrderLineId, int Quantity, double LineTotal, Product product) {
        this.OrderLineId = OrderLineId;
        this.Quantity = Quantity;
        this.LineTotal = LineTotal;
        this.product = product;
    }
    public OrderLine(Order orderIn, Product productIn, int Quantity)
    {
        OrderLineId = orderIn.generateUniqueOrderLineId();
        product = productIn;
        this.Quantity = Quantity;
        LineTotal = productIn.getPrice() * Quantity;
    }

    public int getOrderLineId() {
        return OrderLineId;
    }

    public int getQuantity() {
        return Quantity;
    }

    public double getLineTotal() {
        return LineTotal;
    }

    public void setOrderLineId(int OrderLineId) {
        this.OrderLineId = OrderLineId;
    }

    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }

    public void setLineTotal(double LineTotal) {
        this.LineTotal = LineTotal;
    }
    
    
    
    
}
