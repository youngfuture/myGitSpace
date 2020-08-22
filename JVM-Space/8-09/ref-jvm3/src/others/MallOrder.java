package others;

/**
 * @author King老师
 */
public class MallOrder {
    class Order{
        long orderId;
        String orderName;
        double price;
        public long getOrderId() { return orderId; }
        public void setOrderId(long orderId) { this.orderId = orderId; }
        public String getOrderName() { return orderName; }
        public void setOrderName(String orderName) { this.orderName = orderName; }
        public double getPrice() { return price; }
        public void setPrice(double price) { this.price = price; }
    }
    public  int order()throws Exception{//这个方法执行大概1s（高并发下）
        Order order = new Order();//业务线程暂停了，能走1，不能走2
        //
        int x =1;
        int y =2;
        int z =(x+y)*10;
        return  z;
    }
    public static void main(String[] args) throws Exception{
        MallOrder mallOrder = new MallOrder();
        mallOrder.order();
    }
}
