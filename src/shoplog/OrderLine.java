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
public class OrderLine {
    private int OrderLineId;
    private int Quantity;
    private double LineTotal;

    public OrderLine() {
    }

    public OrderLine(int OrderLineId, int Quantity, double LineTotal) {
        this.OrderLineId = OrderLineId;
        this.Quantity = Quantity;
        this.LineTotal = LineTotal;
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
