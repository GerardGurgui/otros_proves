package clases;

public class Ordinador {
    
    private String marca;
    private String model;
    private double preu;
    private int stock;

    
    public Ordinador(String marca, String model, double preu, int stock) {
        this.marca = marca;
        this.model = model;
        this.preu = preu;
        this.stock = stock;
    }

    
    
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getPreu() {
        return preu;
    }

    public void setPreu(double preu) {
        this.preu = preu;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
    
    
    
    

    @Override
    public String toString() {
        return "Ordinador{" + "marca=" + marca + ", model=" + model + ", preu=" + preu + ", stock=" + stock + '}';
    }
    
    
    
    
}
