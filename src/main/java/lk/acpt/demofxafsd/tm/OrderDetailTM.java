package lk.acpt.demofxafsd.tm;

public class OrderDetailTM {
    private String id;
    private String model;
    private double unitPrice;
    private int qty;
    private double total;

    public OrderDetailTM(String id, String model, double unitPrice, int qty, double total) {
        this.id = id;
        this.model = model;
        this.unitPrice = unitPrice;
        this.qty = qty;
        this.total = total;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
