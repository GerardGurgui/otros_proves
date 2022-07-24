package app;

import clases.Botiga;
import clases.LlistaBuidaException;
import clases.Ordinador;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    
    
    
    public static void main(String[] args) throws LlistaBuidaException {
        
    
        ArrayList<Botiga> llistaBotigues = new ArrayList<>();
        
        //BOTIGUES
        Botiga botiga1 = new Botiga("tenda1","Barcelona", 0);
        Botiga botiga2 = new Botiga("tenda2","Madrid", 1);    
        Botiga botiga3 = new Botiga("tenda3","Londres", 2);
        
        //PCS
        Ordinador pc1 = new Ordinador("nvidia", "gtx", 1200, 4);
        Ordinador pc2 = new Ordinador("asus", "34X", 1000, 0);
        Ordinador pc3 = new Ordinador("apple", "macbook", 1500, 2);
        Ordinador pc4 = new Ordinador("corsair", "T5600", 900, 1);
        Ordinador pc5 = new Ordinador("PcTotal", "totality", 1800, 0);
        Ordinador pc6 = new Ordinador("nvidia", "rtx", 1450, 5);
        Ordinador pc7 = new Ordinador("nvidia", "rtx2", 1700, 3);
        
        //ArrayList de botigues
        
        llistaBotigues.add(botiga1);
        llistaBotigues.add(botiga2);
        llistaBotigues.add(botiga3);
        
        //ArrayList de ordinadors dins de botigues
            //BOTIGA 1 - 3 pcs
        botiga1.getLlistaPcs().add(pc1);
        botiga1.getLlistaPcs().add(pc2);
        botiga1.getLlistaPcs().add(pc3);
        
            //BOTIGA 2 - 3 PCS
        botiga2.getLlistaPcs().add(pc4);
        botiga2.getLlistaPcs().add(pc5);
        botiga2.getLlistaPcs().add(pc6);        
        
        //PENDENT, PC AMB MARCA REPETIDA COM BUSCAR, FILTRAR, MOSTRAR???
        botiga2.getLlistaPcs().add(pc7);
        
        
        menu(llistaBotigues);
        
    }
    
    
    static void menu(ArrayList<Botiga> llistaBotigues)throws LlistaBuidaException {
        
        
        int opcioUsuari;  
        
       
       
        do{
            
            System.out.println("1- Mostrar el 1r ordinador de una marca concreta en stock");
            System.out.println("2- Mostrar quantes unitats hi ha en una tenda de una marca en concret");
            System.out.println("3- Mostrar el pc de una marca en una tenda i modificar el preu");
            System.out.println("4- Mostrar llista de ordinadors de una tenda en concret");
            System.out.println("5- Guardar en un fitxer CSV");
            System.out.println("6- Metode deprecated");
            System.out.println("7- Sortir de la app");
            
            opcioUsuari = demanarNumUsuari("introdueixi una opció");
            
            
            switch(opcioUsuari){
                
                case 1:
                    
                    System.out.println("opcio 1");
                   
                    mostrarPc(llistaBotigues);  
                    
                    break;
                
                    
                case 2:
                    
                    System.out.println("opcio 2");
                    
                    mostrarStockPc(llistaBotigues);
                    
                    
                    break;
                    
                    
                    
                case 3:
                    
                    System.out.println("opcio 3");
                    
                    mostrarPcCambiarPreu(llistaBotigues);
                    
                    
                    break;
                
                
                    
                case 4:
                    
                    System.out.println("opcio 4");
                    
                    mostrarLlistaPcs(llistaBotigues);
                    
                    break;
                
                
                    
                case 5:
                    
                    System.out.println("opcio 5- guardar informació en un fitxer CSV");
                    
                    guardarFitxer(llistaBotigues);
                    
                    break;
                    
                case 6:

                    System.out.println("opcio 6- ");

                    

                    break;
                          
                
                
                
            }
            
            
            
            
            
            
        }while (opcioUsuari != 7);
        
    }
    
    
    
    
    
    static int buscarBotiga(ArrayList<Botiga>llistaBotigues, int id){
        
        int posicio = -1;
        boolean encontrado = false;
        int i = 0;
        
        while (i < llistaBotigues.size() && encontrado == false) {            
            
            if (id == llistaBotigues.get(i).getId()) {
                
                posicio = i;
                encontrado = true;
            }
            
            i++;
        }
        
        return posicio;
        
    }
    
    
  
    
    //////1- Mostrar el 1r ordinador de una marca concreta en stock
    static void mostrarPc(ArrayList<Botiga> llistaBotigues) {

        int posicioArray;
        int posicioBotiga;
        int botigaExiste;
        String marca;
        Ordinador ordinador;
        
        
        posicioBotiga = demanarNumUsuari("Introdueixi el id de la tenda");

        botigaExiste = buscarBotiga(llistaBotigues, posicioBotiga);

        if (botigaExiste >= 0 && posicioBotiga <= 3) {

            marca = demanarDadesText("introdueixi la marca a buscar");
            posicioArray = llistaBotigues.get(posicioBotiga).buscarPc(marca);

            if (posicioArray != -1) {

                ordinador = llistaBotigues.get(posicioBotiga).getLlistaPcs().get(posicioArray);

                if (ordinador.getStock() != 0) {

                    System.out.println("INFO:" + ordinador.toString());

                } else {

                    System.out.println("No hi ha stock");
                }

            } else {

                System.out.println("No existeix aquet pc");
            }

        } else {

            System.out.println("No existeix la botiga");
        }
               

    }
    
    
    
    /////2- Mostrar quantes unitats hi ha en una tenda de una marca en concret
    static void mostrarStockPc(ArrayList<Botiga> llistaBotigues){
        
        
        int posicioArray;
        int posicioBotiga;
        int botigaExiste;
        String marca;
        Ordinador ordinador;
        
        
        posicioBotiga = demanarNumUsuari("Introdueixi el id de la tenda");

        botigaExiste = buscarBotiga(llistaBotigues, posicioBotiga);

        if (botigaExiste >= 0 && posicioBotiga <= 3) {

            marca = demanarDadesText("introdueixi la marca a buscar");
            posicioArray = llistaBotigues.get(posicioBotiga).buscarPc(marca);

            if (posicioArray != -1) {

                ordinador = llistaBotigues.get(posicioBotiga).getLlistaPcs().get(posicioArray);

                if (ordinador.getStock() != 0) {

                    System.out.println("INFO:" + ordinador.getStock());

                } else {

                    System.out.println("No hi ha stock");
                }

            } else {

                System.out.println("No existeix aquet pc");
            }

        } else {

            System.out.println("No existeix la botiga");
        }
    }
    
    
    
    ////3-
    
    static void mostrarPcCambiarPreu(ArrayList<Botiga> llistaBotigues){
        
        
        int posicioArray;
        int posicioBotiga;
        int botigaExiste;
        String marca;
        Ordinador ordinador;
        
        
        posicioBotiga = demanarNumUsuari("Introdueixi el id de la tenda");

        botigaExiste = buscarBotiga(llistaBotigues, posicioBotiga);

        if (botigaExiste >= 0 && posicioBotiga <= 3) {

            marca = demanarDadesText("introdueixi la marca a buscar");
            posicioArray = llistaBotigues.get(posicioBotiga).buscarPc(marca);

            if (posicioArray != -1) {

                ordinador = llistaBotigues.get(posicioBotiga).getLlistaPcs().get(posicioArray);

                if (ordinador.getStock() != 0) {

                    System.out.println("Preu actual: " +ordinador.getPreu());
                    
                    ordinador.setPreu(500);
                    
                    System.out.println("Preu modificat: " + ordinador.getPreu());

                } else {

                    System.out.println("No hi ha stock");
                }

            } else {

                System.out.println("No existeix aquet pc");
            }

        } else {

            System.out.println("No existeix la botiga");
        }
        
    }
    
    
    
    
    ////4- Mostrar llista de ordinadors de una tenda en concret"
    
    static void mostrarLlistaPcs(ArrayList<Botiga> llistaBotigues) throws LlistaBuidaException{
        
        Botiga botiga;
        
//        
//        for (int i = 0; i < llistaBotigues.size(); i++) {
//            
//            
//            for (int j = 0; j < llistaBotigues.get(i).getLlistaPcs().size(); j++) {
//                
//                System.out.println(llistaBotigues.get(i).getLlistaPcs().get(j).toString());
//                
//                if (llistaBotigues.get(i).getLlistaPcs().isEmpty()) {
//                    
//                    throw new LlistaBuidaException("La llista està buida");
//                }
//                
//            }
//        }
        

        
        for (Botiga llistaBotigue : llistaBotigues) {
            
            if (llistaBotigue.getLlistaPcs().isEmpty()) {
                
                throw new LlistaBuidaException("La llista està buida");
                
            }
            
            
        }

   
    }
    
    
    
    
    
    
    
    ////5- Guardar a un fitxer csv
    
    static void guardarFitxer(ArrayList<Botiga> llistaBotigues){
        
        
        PrintWriter pw = null;
        
        
        try {
            
            pw = new PrintWriter("llistaPCs.csv", "UTF-8");
            pw.println(llistaBotigues);
            pw.close();
            System.out.println("Arxiu creat correctament");
            
            
        } catch(FileNotFoundException e) {
            
            e.printStackTrace();
            
        }catch(IOException e2){
            
            e2.printStackTrace();
            
        }catch(Exception e3){
            
            e3.printStackTrace();
            
        }finally{
            
            if (pw != null) {
                
                pw.close();
                
            }
        }
        
        
    }


    
    
    ////DADES USUARI
    
     static int demanarNumUsuari(String missatge){
        
         Scanner input = new Scanner(System.in);
         
        int valor = 0;
        boolean capturaError = false;
        
        do {            
            
            try {
                
                System.out.println(missatge);
                valor = input.nextInt();
                capturaError = true;
                
            } catch (InputMismatchException e) {
                
                System.out.println("Error de format, has d'introduir un número enter");
                
            }
            
            input.nextLine();
              
        } while (capturaError == false);
        
        return valor;
    }
    
    
    
    
      static String demanarDadesText(String texto){
        
        Scanner input = new Scanner(System.in);
        
        String textUsuari;
        
        System.out.println(texto);
        textUsuari = input.nextLine();
        
          
        return textUsuari;
    }
    
    
    
}
