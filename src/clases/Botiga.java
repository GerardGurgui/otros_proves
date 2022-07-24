package clases;

import java.util.ArrayList;

public class Botiga {
    
    private String nom;
    private String sucursal;
    private int id;
    private ArrayList<Ordinador> llistaPcs;
    
    
    
    public Botiga(String nom, String sucursal, int id){
        
        this.nom = nom;
        this.sucursal = sucursal;
        this.id = id;
        llistaPcs = new ArrayList<>();
        
    }

    
    
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getSucursal() {
        return sucursal;
    }

    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Ordinador> getLlistaPcs() {
        return llistaPcs;
    }

    public void setLlistaPcs(ArrayList<Ordinador> llistaPcs) {
        this.llistaPcs = llistaPcs;
    }
    
    
    public int buscarPc(String marca){
        
        int posicio = -1;
        boolean encontrado = false;
        int i = 0;
        
        while (i < llistaPcs.size() && encontrado == false) {            
            
            if (marca.equals(llistaPcs.get(i).getMarca())) {
                
                posicio = i;
                encontrado = true;
            }
            i++;
        }
        
        return posicio;
        
    }
    

    
    @Override
    public String toString() {
        return "Botiga{" + "nom=" + nom + ", sucursal=" + sucursal + ", id=" + id + ", llistaPcs=" + llistaPcs + '}';
    }
    
    
    
    
}
