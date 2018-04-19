/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shoplog;

import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Date 17/04/2018
 * @author Mohamad Harah
 */
public class Order {
    /**
     * Order object class with attributes setters, getters, empty and loaded constructors
     */
    private int orderId;
    private Date orderDate;
    private double orderTotal;
    private String username;
    private String status;
    private HashMap <Integer, OrderLine> orderLines;
    
    
    public Order() {
        orderDate = new Date();
        username = "";
        orderTotal = 0;
        status = "InComplete";
        orderLines = new HashMap<>();
    }
    
    public Order(int orderIdIn, Date orderDateIn, double orderTotalIn, String statusIn)
    {
        orderId = orderIdIn;
        orderDate = orderDateIn;
        orderTotal = orderTotalIn;
        status = statusIn;
        orderLines = new HashMap<>();
    }  

    public Order(int orderId, Date orderDate, double orderTotal, String username, String status, HashMap<Integer, OrderLine> orderLines) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.orderTotal = orderTotal;
        this.username = username;
        this.status = status;
        this.orderLines = orderLines;
    }
    
    public int generateUniqueOrderLineId()
    {
        int orderLineId = 0;
        for(Map.Entry<Integer, OrderLine> orderLineEntry : orderLines.entrySet())
        {
            if(orderLines.containsKey(orderLineId))
            {
                orderLineId++;
            }
        }
        return orderLineId;
    }
    /**
     * gets the quantity of products in one order line
     * @param productId
     * @return the quantity of products
     */
    public int getQuantityofProduct(int productId)
    {
        //loop through hashmap
        for(Map.Entry<Integer, OrderLine> entry : orderLines.entrySet())
        {
            if (entry.getValue().getProduct().getProductId()== productId)
            {
                return entry.getValue().getQuantity();
            }
        }
        return -1;
    }
    /**
     * adds new line to the order (in the basket)
     * @param oL
     * @throws SQLException 
     */
    public void addOrderLine(OrderLine oL) throws SQLException 
    {
        orderLines.put(oL.getOrderLineId(), oL);
        DBHandler db = new DBHandler();
        db.addOrderLine(oL,orderId);
        orderTotal = orderTotal + oL.getLineTotal();
    }
    /**
     * removes a line from the order (in basket)
     * @param productId
     * @throws SQLException 
     */
     public void removeOrderLine(int productId) throws SQLException
    {
        Iterator<Map.Entry<Integer, OrderLine>> iter = orderLines.entrySet().iterator();
        while(iter.hasNext())
        {
            Map.Entry<Integer, OrderLine> olEntry = iter.next();
            OrderLine actualOrderLine = olEntry.getValue();
            
            if(actualOrderLine.getProduct().getProductId() == productId)
            {
                iter.remove();
                orderTotal = orderTotal - actualOrderLine.getLineTotal();
                
                DBHandler db = new DBHandler();
                db.deleteOrderLine(orderId, productId);
                db.updateOrderTotal(orderId, -actualOrderLine.getLineTotal());
            }
        }
    }
    

    public int getOrderId() {
        return orderId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public double getOrderTotal() {
        return orderTotal;
    }

    public String getStatus() {
        return status;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public void setOrderTotal(double orderTotal) {
        this.orderTotal = orderTotal;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public HashMap<Integer, OrderLine> getOrderLines() {
        return orderLines;
    }

    public void setOrderLines(HashMap<Integer, OrderLine> orderLines) {
        this.orderLines = orderLines;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

}
