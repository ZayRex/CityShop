/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shoplog;

import Form.EditProduct;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Date 17/04/2018
 * @author Mohamad Harah
 */
public class DBHandler {
    
    Connection myConnection;
    
    public DBHandler()
    {
                
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
           myConnection= DriverManager.getConnection("jdbc:ucanaccess://src/db/ShopDB.accdb");
           
          
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       
  
        
    }
    /**
     * closes the connection to database
     */
    public void closeConnection ()
    {
        try {
           
            myConnection.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    /**
     * registers the customer into the system
     * @param c
     * @return true if registerd
     */
    public boolean registerCustomer(Customer c)
    {
            try {
        
            String sql = " select * from Customers where username = '" + c.getUserName() +"'";
            Statement stmt;    
            stmt = myConnection.createStatement();
             ResultSet rs = stmt.executeQuery(sql);
             
             if (rs.next()){
             return false;
             }
             else{
                 
                 sql = "insert into customers (username, password, firstname, lastname, addressLine1, addressLine2, town, postCode ) values(?,?,?,?,?,?,?,?)";
                 
                PreparedStatement ps = myConnection.prepareStatement (sql);
                ps.setString(1, c.getUserName());
                ps.setString(2, c.getPassword());
                ps.setString(3, c.getFirstName());
                ps.setString(4, c.getLastName());
                ps.setString(5, c.getAddressLine1());
                ps.setString(6, c.getAddressLine2());
                ps.setString(7, c.getTown());
                ps.setString(8, c.getPostCode());

                int n = ps.executeUpdate();

                if ( n == 1)
                {
                    return true;
                }
                return false;
             }
             
             
             
             
        } catch (SQLException ex) {
            Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return false;      
    }
    /**
     *  the customer login function
     * @param user takes the username
     * @param pass and takes the password
     * @return the customer
     */
    public Customer customerLogin(String user, String pass) 
    {
        try {
            /* Customer c = new Customer();
            String sqlstr = "";
            try {
            
            if (myConnection != null){
            Statement st = myConnection.createStatement();
            ResultSet rs = null;            
            sqlstr= "select * from customers where username='" + user + "' and password = '" + pass + "'";
            rs = st.executeQuery(sqlstr);
            
            if(rs.next()) 
            {
            //valid login
            c.setUserName(rs.getString("Username"));
            c.setPassword(rs.getString("Password"));
            c.setFirstName(rs.getString("FirstName"));
            c.setLastName(rs.getString("LastName"));
            c.setAddressLine1(rs.getString("AddressLine1"));
            c.setAddressLine2(rs.getString("AddressLine2"));
            c.setTown(rs.getString("Town"));
            c.setPostCode(rs.getString("PostCode"));
            
            return c; 
            }
            }
            }
            catch (SQLException ex)
            {
            return c;
            }
            return null;
            */
            HashMap<String, Customer> customers;
            customers = loadCustomers();
            
            if (customers.containsKey(user)) {
                if (customers.get(user).getPassword().equals(pass)) {
                    return customers.get(user);
                }
            }
            return null;
        } catch (SQLException ex) {
            Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    return null;
      
    }
    /**
     * logs the staff in the system
     * @param user
     * @param pass
     * @return the staff
     */
     public Staff staffLogin(String user, String pass) 
    {
        Staff stf = new Staff();
        String sqlstr = "";
        try {
         
            if (myConnection != null){
            Statement st = myConnection.createStatement();
            ResultSet rs = null;            
            sqlstr= "select * from Staff where username='" + user + "' and password = '" + pass + "'";
            rs = st.executeQuery(sqlstr);
            
            if(rs.next()) 
            {
                //valid login
                stf.setSalary(rs.getDouble("Salary"));
                stf.setPosition(rs.getString("Position"));
                stf.setUserName(rs.getString("Username"));
                stf.setPassword(rs.getString("Password"));
                stf.setFirstName(rs.getString("FirstName"));
                stf.setLastName(rs.getString("LastName"));
                   
                
                return stf;                
            } 
            }
        }
        catch (SQLException ex) 
        {
            return stf;
        }
        return null;
      
    }
     /**
      * deletes customer form the database
      * @param c passes the customer in
      */
    public void deleteCustomer(Customer c)
    {
        try
        {
            Statement stmt = myConnection.createStatement();
            stmt.executeUpdate("DELETE FROM Customers WHERE Username = '" + c.getUserName() + "'");
        }
        catch(Exception ex)
        {
            String message = ex.getMessage();
        }
    }
    /**
     * load all the products
     * @return list of products
     */
    public HashMap<Integer, Product> loadProducts()
    {
       HashMap <Integer,Product> Products = new HashMap();
        
       String sql = "select * from products";
       
       try{
           Statement stmt = myConnection.createStatement();
           ResultSet rs = stmt.executeQuery(sql);
           
           
               while (rs.next()){
                   
                   if(rs.getString("Measurement").equals("")){
                       //make footwaer and add to products
                       FootWear fw = new FootWear (rs.getInt("Size"), rs.getInt("ProductID"), rs.getString("ProductName"), rs.getDouble("Price"), rs.getInt("StockLevel"));
                       Products.put(fw.getProductId(), fw);
                   }
                   else{
                       //make footwaer and add to products
                       Clothing cl = new Clothing (rs.getString("Measurement"), rs.getInt("ProductID"), rs.getString("ProductName"), rs.getDouble("Price"), rs.getInt("StockLevel"));
                       Products.put(cl.getProductId(), cl);
                   }
                   
               }
           } catch (SQLException ex) {               
               Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
           }
    
        return Products;
    }
    /**
     * deletes orderline form order
     * @param orderId
     * @param productId
     * @throws SQLException 
     */
    public void deleteOrderLine (int orderId, int productId) throws SQLException
    {
        Statement stmt = myConnection.createStatement();
        try {
            stmt.execute("DELETE from OrderLines WHERE ProductId = "+productId+" AND OrderId= "+orderId);
           
        } catch (SQLException ex) {
            Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * update orderline details
     * @param orderId
     * @param newOrderLineQ
     * @param newOrderLineTotal
     * @throws SQLException 
     */
    public void updateOrderLine (int orderId, int newOrderLineQ, double newOrderLineTotal) throws SQLException
    {
        Statement stmt = myConnection.createStatement();
        try {
            String sql = "UPDATE  OrderLines SET Quantity = "+newOrderLineQ+", LineTotal = "+newOrderLineTotal+" WHERE OrderId= "+orderId;
                    stmt.execute(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     *  adds order to the database
     * @param order the order will be added
     * @param username the username of the person who ordered
     * @return the order Id
     * @throws SQLException 
     */
    public int addOrder (Order order,String username) throws SQLException
    {
       // DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        DateFormat dateFormat =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	Date date = new Date();
        int orderId = 0;
        Statement stmt = myConnection.createStatement();
        stmt.executeUpdate("INSERT INTO Orders (OrderDate, Username, OrderTotal, Status) " +
                    "VALUES ('" + dateFormat.format(date) + "','" + 
                    username + "','" + order.getOrderTotal() + "','" + 
                    order.getStatus() + "')");
        
        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next())
        {
            orderId = rs.getInt(1);
        }
        return orderId;
    }
    /**
     *  the order details 
     * @param orderLine a single line in order
     * @param orderId the order ID that of the order line
     * @return the order ID
     * @throws SQLException 
     */
        public int addOrderLine (OrderLine orderLine,int orderId) throws SQLException
    {
        int orderLineId = 0;
        Statement stmt = myConnection.createStatement();
        String sql = "INSERT INTO OrderLines (OrderLineId,ProductId , Quantity ,LineTotal, OrderId) VALUES("
                +orderLine.getOrderLineId()+","
                +orderLine.getProduct().getProductId()+","
                +orderLine.getQuantity()+","
                +orderLine.getLineTotal()+","
                +orderId+")";
            
        stmt.executeUpdate(sql);
        updateOrderTotal(orderId, orderLine.getLineTotal());
        
        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next())
        {
            orderLineId = rs.getInt(1);
        }
        return orderId;
    }
        /**
         * update the order total on the database
         * @param orderId
         * @param lineTotal 
         */
        public void updateOrderTotal(int orderId, double lineTotal)
    {
        try
        {
            
            Statement stmt = myConnection.createStatement();
            stmt.executeUpdate("UPDATE Orders SET OrderTotal = OrderTotal + " + lineTotal +
                    " WHERE OrderId = '" + orderId + "'");
            
        }
        catch(Exception ex)
        {
            String message = ex.getMessage();
        }
    }
        /**
         * sets the order status to complete
         * @param orderId 
         */
     public void completeOrder(int orderId)
    {
        try
        {
           
            Statement stmt = myConnection.createStatement();
            stmt.executeUpdate("UPDATE Orders SET OrderDate = '" 
                    + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "',"
                    + " Status = 'Complete' WHERE OrderId = '" + orderId + "'");
            
        }
        catch(Exception ex)
        {
            String message = ex.getMessage();
        }
    }
     /**
      * adds a product to the database
      * @param newProduct the added product
      */
      public void addProduct(Product newProduct)
    {
        
        String measurement = "";
        int size =0;
        
        if(newProduct.getClass().getName().equals("shoplog.Clothing"))
        {
            Clothing newClothing = (Clothing)newProduct;
            measurement = newClothing.getMeasurement();
        }
        else
        {
            FootWear newFootWear = (FootWear)newProduct;
            size = newFootWear.getSize();
        }
        
        try
        {
            
            Statement stmt = myConnection.createStatement();
            stmt.executeUpdate("INSERT INTO Products (ProductId, ProductName, Price, StockLevel, Size, Measurement) " +
                    "VALUES ('" + newProduct.getProductId() + "','" + newProduct.getProductName() + "','" + newProduct.getPrice() + "','" + 
                    newProduct.getStockLevel() + "','" + size + "','" + measurement +"')");
            
        }
        catch(Exception ex)
        {
            String message = ex.getMessage();
        }
    }
      /**
       * deletes a product from the database
       * @param product 
       */
       public void deleteProduct(Product product)
    {
        try
        {
            Statement stmt = myConnection.createStatement();
            stmt.executeUpdate("DELETE FROM Products WHERE ProductId = '" + product.getProductId() + "'");
        }
        catch(Exception ex)
        {
            String message = ex.getMessage();
        }
    }
       /**
        * loads the customers order lines of a specific order
        * @param customers
        * @return 
        */
         public HashMap<String, Customer> loadCustomerOrderLines(HashMap<String, Customer> customers) {
        HashMap<Integer, Product> loadedProducts = loadProducts();
        try {

        
            Statement stmt = myConnection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM OrderLines");
            while (rs.next()) {
                int orderLineId = rs.getInt("OrderLineId");
                int productId = rs.getInt("ProductId");
                int quantity = rs.getInt("Quantity");
                double lineTotal = rs.getDouble("LineTotal");
                int orderId = rs.getInt("OrderId");

                Order orderForOrderLine = null;
                for (Map.Entry<String, Customer> customer : customers.entrySet()) {
                    if (customer.getValue().getOrders().containsKey(orderId)) {
                        orderForOrderLine = customer.getValue().getOrders().get(orderId);
                        Product productOrdered = loadedProducts.get(productId);
                        OrderLine loadedOrderLine = new OrderLine(orderForOrderLine, productOrdered, quantity);
                        loadedOrderLine.setOrderLineId(orderLineId);
                        loadedOrderLine.setLineTotal(lineTotal);

                        orderForOrderLine.getOrderLines().put(orderLineId, loadedOrderLine);
                    }
                }

            }
        } catch (Exception ex) {
            String message = ex.getMessage();
        } finally {
            //customers = loadCustomerOrders(customers);
            return customers;
        }
    }
       /**
        * load all the customers
        * @return customers
        * @throws SQLException 
        */
       public HashMap<String,Customer> loadCustomers() throws SQLException
    {
        HashMap<String,Customer> customers = new HashMap<>();
        String sqlstr = "SELECT * FROM customers";
        Statement st = myConnection.createStatement();
        ResultSet rs = null;
        
        rs = st.executeQuery(sqlstr);
        
        while(rs.next())
        {
            Customer c = new Customer();
            c.setUserName(rs.getString("Username"));
            c.setPassword(rs.getString("Password"));
            c.setFirstName(rs.getString("FirstName"));
            c.setLastName(rs.getString("LastName"));
            c.setAddressLine1(rs.getString("AddressLine1"));
            c.setAddressLine2(rs.getString("AddressLine2"));
            c.setTown(rs.getString("Town"));
            c.setPostCode(rs.getString("PostCode"));
            
            customers.put(rs.getString("Username"), c);
             customers = loadCustomerOrders(customers);
            customers = loadCustomerOrderLines(customers);
        }
        
        return customers;
    }
    /**
     * load orders
     * @param user
     * @return list of orders
     * @throws SQLException 
     */
    public HashMap<Integer, Order> loadOrders(String user) throws SQLException 
    {
        HashMap<Integer, Order> orders = new HashMap<>();
        String sqlstr = "";
        int count = 0;
        
        sqlstr = "select * from orders where username = '" + user + "'";
        
        if(user.equals(""))
        {
            sqlstr = "select * from orders";
        }
        
        Statement st = myConnection.createStatement();
        ResultSet rs = null;
        
        rs = st.executeQuery(sqlstr);
        
        while(rs.next()) 
        {
            Order order = new Order();
            order.setOrderDate(rs.getDate("OrderDate"));
            order.setOrderId(rs.getInt("OrderID"));
            order.setOrderTotal(rs.getDouble("OrderTotal"));
            order.setUsername(rs.getString("Username"));
            order.setStatus(rs.getString("Status"));
            
            //orders.put(count, order
            orders.put(rs.getInt("OrderID"), order);
            count++;
        }
        
        return orders;
    }
    /**
     * load customers orders
     * @param customers list of all the customers
     * @return all customers
     */
     public HashMap<String, Customer> loadCustomerOrders(HashMap<String, Customer> customers) {
        try {
           
            Statement stmt = myConnection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Orders");
            while (rs.next()) {
                int orderId = rs.getInt("OrderId");
                Date orderDate = new SimpleDateFormat("yyyy-MM-dd").parse(rs.getString("OrderDate"));
                String username = rs.getString("Username");
                double orderTotal = rs.getDouble("OrderTotal");
                String status = rs.getString("Status");

                Customer customerWithOrder = customers.get(username);

                //Order loadedOrder = new Order(orderId, orderDate, customerWithOrder, orderTotal, status);
                Order loadedOrder = new Order(orderId, orderDate, orderTotal, status);
                                
                customerWithOrder.getOrders().put(orderId, loadedOrder);

            }
        } catch (Exception ex) {
            String message = ex.getMessage();
        } finally {
            //customers = loadCustomerOrders(customers);
            return customers;
        }
    }
     /**
      * loads order lines of an order
      * @param customers
      * @return customers
      */
    public HashMap<String, Customer> loadOrderLines (HashMap<String, Customer> customers)
    {
        HashMap<Integer, Product> products = loadProducts();
        try
        {
          
            Statement stmt = myConnection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM OrderLines");
            while(rs.next())
            {
                int orderLineId = rs.getInt("OrderLineId");
                int productId = rs.getInt("ProductId");
                int quantity = rs.getInt("Quantity");
                double lineTotal = rs.getDouble("LineTotal");
                int orderId = rs.getInt("OrderId");
                
                Product loadedProduct = products.get(productId);

                for(Map.Entry<String, Customer> customerEntry : customers.entrySet())
                {
                    Customer customer = customerEntry.getValue();
                    if(customer.getOrders().containsKey(orderId))
                    {
                        OrderLine loadedOrderLine = 
                                new OrderLine(orderLineId,quantity, lineTotal, loadedProduct);
                        
                        customer.getOrders().get(orderId).getOrderLines().put(orderLineId, loadedOrderLine);
                    }                                    
                }
            }
            
        }
        catch(Exception ex)
        {
            String message = ex.getMessage();
        }
        finally
        {
            return customers;
        }
    }
    /**
     * update customers details on the database
     * @param c
     * @throws SQLException 
     */
    public void updateCustomer(Customer c) throws SQLException 
    {
       /*  try
        {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
           
            Statement stmt = myConnection.createStatement();
            stmt.executeUpdate("UPDATE customers SET password = '" + c.getPassword() + "', " +
                    "firstname = '" + c.getFirstName() + "', lastname = '" + c.getLastName() + "', " +
                    "addressline1 = '" + c.getAddressLine1() + "', addressline2 = '" + c.getAddressLine2() + "' " +        
                    "town = '" + c.getTown() + "', postcode = '" + c.getPostCode() + "' " +
                    "WHERE username = '" + c.getUserName() + "'");
        }
        catch(Exception ex)
        {
            String message = ex.getMessage();
       */ 
       String sqlstr = "Update customers Set username = ?, password = ?, firstname = ?, lastname = ?, addressline1 = ?, addressline2 = ?, town = ?, postcode = ? WHERE username = ?";
        Statement st = myConnection.createStatement();
        ResultSet rs = null;
        PreparedStatement ps = myConnection.prepareStatement(sqlstr);
    
        ps.setString(1, c.getUserName());
        ps.setString(2, c.getPassword());
        ps.setString(3, c.getFirstName());
        ps.setString(4, c.getLastName());
        
        ps.setString(5, c.getAddressLine1());
        ps.setString(6, c.getAddressLine2());
        ps.setString(7, c.getTown());
        ps.setString(8, c.getPostCode());
        ps.setString(9, c.getUserName());
        
        int i = ps.executeUpdate();
        
        if(i > 0) {
            System.out.println("Customer details updated.");
        }
        else
        {
            System.out.println("Could not find details.");
        }
        
    }
    /**
     * update product details on the database
     * @param p a product
     * @throws SQLException 
     */
     public void updateProduct(Product p) throws SQLException
    {
        String measurement = "";
        int size = 0;
        
        if(p.getClass().getName().equals("shoplog.Clothing"))
        {
            Clothing newCl = (Clothing)p;
            measurement = newCl.getMeasurement();
            System.out.println(measurement);
            System.out.println(p.getProductId());
            System.out.println(p.getPrice());
            System.out.println(p.getProductName());
            
                    
        }
        else
        {
            FootWear newFW = (FootWear)p;
            size = newFW.getSize();  
        }
        
        try
        {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Statement stmt = myConnection.createStatement();
            stmt.executeUpdate("UPDATE Products SET ProductId = '" + p.getProductId() +
                    "', ProductName = '" + p.getProductName() + "', Price = '" + p.getPrice() +
                    "', StockLevel = '" + p.getStockLevel() +       
                    "', Measurement = '" + measurement + "', Size = '" + size +
                    "' WHERE ProductId = '" + p.getProductId() + "'");
            
        }
        catch(Exception ex)
        {
            Logger.getLogger(EditProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
        /*
        String sqlstr;
        Statement st = myConnection.createStatement();
        ResultSet rs = null;
        
        if(p.getClass().getName().equals("shoplog.FootWear"))
        {
            
            sqlstr = "UPDATE Products set productID = ?, productname = ?, price = ?, stocklevel = ?, size = ? WHERE productID = ?";
            PreparedStatement ps = myConnection.prepareStatement(sqlstr);
            
            FootWear fW = (FootWear) p;
            
                ps.setInt(1, fW.getProductId());
                ps.setString(2, fW.getProductName());
                ps.setDouble(3, fW.getPrice());
                ps.setInt(4, fW.getStockLevel());
                ps.setInt(5, fW.getSize());
                ps.setInt(6, fW.getProductId());
               int i = ps.executeUpdate();
            if(i > 0) {
            System.out.println("Customer details updated.");
        }
        else
        {
            System.out.println("Could not find details.");
        }
            
            
        }
        else if(p.getClass().getName().equals("shoplog.Clothing"))
        {
            
            sqlstr = "UPDATE Products set productID = ?, productname = ?, price = ?, stocklevel = ?, measurement = ? WHERE productID = ?";
            PreparedStatement ps = myConnection.prepareStatement(sqlstr);
            
            Clothing cL = (Clothing) p;
            
                ps.setInt(1, cL.getProductId());
                ps.setString(2, cL.getProductName());
                ps.setDouble(3, cL.getPrice());
                ps.setInt(4, cL.getStockLevel());
                ps.setString(5, cL.getMeasurement());
                ps.setInt(6, cL.getProductId());
                int i = ps.executeUpdate();
        }*/
        
        
    }
    
       
    
}
    
    
    
    
    
    

