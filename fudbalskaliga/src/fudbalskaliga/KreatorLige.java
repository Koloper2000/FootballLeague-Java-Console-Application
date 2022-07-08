package fudbalskaliga;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Scanner;

public class KreatorLige implements MenadzerLige{
private final int brojKlubova;
    
    private final ArrayList<FudbalskiKlub> liga;
    private final Scanner scanner;
    private final ArrayList<Mec> mecevi;
    
    public KreatorLige(int brojKlubova) {
        
        this.brojKlubova = brojKlubova;
        liga = new ArrayList<>();
        mecevi = new ArrayList<>();
        scanner = new Scanner(System.in);
        prikaziMeni();
    }
    
    
    private void prikaziMeni() {
        
        while(true) {
            System.out.println("Meni lige: ");
            System.out.println("Napravite novi tim i dodajte ga u ligu (pritisnite 1)");
            System.out.println("Izbrisite postojeći tim iz lige (pritisnite 2)");
            System.out.println("Prikazi statistiku za tim (pritisnite 3)");
            System.out.println("Prikaz tabele lige (pritisnite 4)");
            System.out.println("Dodajte odigranu utakmicu (pritisnite 5)" );
            System.out.println("Prikazite kalendar i pronadjite mec (pritisnite 6)");
            String line = scanner.nextLine();
            int komanda = 0;
            try {
                komanda = Integer.parseInt(line);
            } catch (Exception e) {
        }
            
            switch(komanda) {
                case 1 :
                   dodajTim();
            break;
                case 2 :
                    obrisiTim();
                    break;
                case 3 :
                    prikaziStatistiku();
                  break;
                case 4 :
                    prikaziTabeluLige();
                  break;
                case 5:
                    dodajOdigraniMec();
                   break;
                case 6:
                    prikaziKalendar();
                   break;
            default:
            System.out.println("Pogresna komanda");
        }
        
    } 
   }
    
    public void dodajTim(){
        if(liga.size() == brojKlubova) {
            System.out.println("Ne moze dodati vise klubova u ligi");
            return;
        }
        
        FudbalskiKlub klub = new FudbalskiKlub();
        System.out.println("Dodaj ime kluba: ");
        String line = scanner.nextLine();
        klub.setIme(line);
        
        if(liga.contains(klub)){
            System.out.println("Ovaj klub vec postoji u ligi!");
            return;
        }
        System.out.println("Unesi lokaciju kluba: ");
        line = scanner.nextLine();
        klub.setLokacija(line);
        liga.add(klub);   
    }
    
    public void obrisiTim() {
        System.out.println("Unesi ime kluba: ");
        String line = scanner.nextLine();
         for(FudbalskiKlub klub : liga) {
             if(klub.getIme().equals(line)){
                 liga.remove(klub);
                 System.out.println("klub "+ klub.getIme()+" obrisan");
                 return;
             }
         }
         System.out.println("Nema takvog kluba u ligi");
    }
    
    public void prikaziStatistiku() {
        
        System.out.println("Unesi ime kluba: ");
        String line = scanner.nextLine();
         for (FudbalskiKlub klub : liga) {
             if(klub.getIme().equals(line)){
                 System.out.println("klub " + klub.getIme()+ " ima pobeda: " + klub.getPobedaCount());
                 System.out.println("klub " + klub.getIme()+ " ima izgubljenih: " + klub.getIzgubljenoCount());
                 System.out.println("klub " + klub.getIme()+ " ima neresenih: " + klub.getNeresenoCount());
                 System.out.println("klub " + klub.getIme()+ "ima postignutih golova: " + klub.getPostignutiGolCount());
                 System.out.println("klub " + klub.getIme()+ "ima primljenih golova: " + klub.getPrimljeniGolCount());
                 System.out.println("klub " + klub.getIme()+ "ima poena: " + klub.getPoeni());
                 System.out.println("klub " + klub.getIme()+ "ima odigranih meceva: " + klub.getOdigraniMecevi());
                 return;
             }
         }
         System.out.println("Nema takvog kluba u ligi!");
    } 
    
    public void prikaziTabeluLige() {
        
        Collections.sort(liga, new Uporedi());
        for(FudbalskiKlub klub : liga) {
            System.out.println("klub: " + klub.getIme()+" Poeni: "+ klub.getPoeni()+" gol razlika: "+ (klub.getPostignutiGolCount()-klub.getPrimljeniGolCount()));
    }    
  }
    
    public void dodajOdigraniMec(){
        System.out.println("Unesi datum (format mm-dd-yyyy): ");
        String line = scanner.nextLine();
        Date date;
        try {
            date = new SimpleDateFormat("MM-dd-yyyy").parse(line);
        } catch (ParseException ex) {
            System.out.println("Niste uneli datum u formatu mm-dd-yyyy");
            return;
        }
        System.out.println("Unesi domaci tim: ");
        line = scanner.nextLine();
        FudbalskiKlub domacin = null;
          for(FudbalskiKlub klub : liga){
              if(klub.getIme().equals(line))
                  domacin = klub;
          }  
          if (domacin == null) {
              System.out.println("Nema takvog kluba u ligi");
              return;
          }
          System.out.println("Unesi gostujuci tim: ");
          line = scanner.nextLine();
          FudbalskiKlub gost = null;
           for(FudbalskiKlub klub : liga){
              if(klub.getIme().equals(line))
                  gost = klub;
          } 
           if (gost == null) {
              System.out.println("Nema takvog kluba u ligi");
              return;
          }
           
           System.out.println("Unesi golove domceg tima: ");
           line = scanner.nextLine();
           int domacinGolovi = -1;
             try {
                 domacinGolovi = Integer.parseInt(line);                
             } catch (Exception e) { 
    }
         if (domacinGolovi == -1) {
             System.out.println("Morate da unesete broj golova");
             return;
         }
         
         System.out.println("Unesi golove gostujuceg tima: ");
           line = scanner.nextLine();
           int gostGolovi = -1;
             try {
                 gostGolovi = Integer.parseInt(line);                
             } catch (Exception e) { 
    }
         if (gostGolovi == -1) {
             System.out.println("Morate da unesete broj golova");
             return;
         }
         
         
         Mec mec = new Mec();
         mec.setDate(date);
         mec.setTimA(domacin);
         mec.setTimB(gost);
         mec.setTimAPostigao(gostGolovi);
         mec.setTimBPostigao(domacinGolovi);
         mecevi.add(mec);
         domacin.setPostignutiGolCount(domacin.getPostignutiGolCount()+domacinGolovi);
         gost.setPostignutiGolCount(gost.getPostignutiGolCount()+gostGolovi);
         domacin.setPrimljeniGolCount(domacin.getPrimljeniGolCount()+gostGolovi);
         gost.setPrimljeniGolCount(gost.getPrimljeniGolCount()+domacinGolovi);
         domacin.setOdigraniMecevi(domacin.getOdigraniMecevi()+1);
         gost.setOdigraniMecevi(gost.getOdigraniMecevi()+1);
         
         if (domacinGolovi > gostGolovi) {            
             domacin.setPoeni(domacin.getPoeni()+3);
             domacin.setPobedaCount(domacin.getPobedaCount()+1);
             gost.setIzgubljenoCount(gost.getIzgubljenoCount()+1);
         }
         
         else if (domacinGolovi < gostGolovi) {            
             gost.setPoeni(gost.getPoeni()+3);
             gost.setPobedaCount(gost.getPobedaCount()+1);
             domacin.setIzgubljenoCount(domacin.getIzgubljenoCount()+1);
         }
         else {
             domacin.setPoeni(domacin.getPoeni()+1);
             gost.setPoeni(gost.getPoeni()+1);
             domacin.setNeresenoCount(domacin.getNeresenoCount()+1);
             gost.setNeresenoCount(gost.getNeresenoCount()+1);
         }      
    } 
    
    public void prikaziKalendar() {
        
        System.out.println("Unesi godinu: ");
        String line = scanner.nextLine();
         int Y = 1900;
           try {
               Y = Integer.parseInt(line);
           } catch (Exception e) { 
    }
         if (Y <= 1900) {
             System.out.println("Moras uneti godinu!");
             return;
         }
    
          System.out.println("Unesi mesec: ");
          line = scanner.nextLine();
          int M = 0;
           try {
               M = Integer.parseInt(line);
           } catch (Exception e) { 
    }
         if (M == 0) {
             System.out.println("Moras uneti mesec!");
             return;
         }
         
         String[] meseci = {
            "",
             "Januar", "Februar", "Mart",
             "April", "Maj", "Jun",
             "Jul", "Avgust", "Septembar",
             "Oktobar", "Novembar", "Decembar"  
         };
         
         int[] dani = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
         
         if (M == 2 && jePrestupnaGodina(Y)) dani[M] = 29;
         
         System.out.println("    " + meseci[M] + " " + Y);
         System.out.println("Ned  Pon  Uto  Sre  Cet  Pet  Sub");
         
         int d = day(M, 1, Y);
         String razmak = "";
         
         for (int i = 0; i < d; i++)
             System.out.print("   ");
         for (int i = 1; i <= dani[M]; i++) {
             if (i<10)
                 System.out.print(i +"  ");
             else 
                 System.out.print(i+" ");
             if (((i + d) % 7 == 0) || (i == dani[M])) System.out.println();
         }
         
         System.out.println("Unesi dan: ");
         line = scanner.nextLine();
         int D = 0;
           try {
               D= Integer.parseInt(line);
           }  catch (Exception e) {             
           }
       if (D == 0 || dani[M] < D) {
           System.out.println("Nemate dana u mesecu");
           return;
       }  
       
       Calendar cal = Calendar.getInstance();
       cal.set(Y, M-1, D);
       for (Mec m : mecevi) {
           Calendar cal2 = Calendar.getInstance();
           cal2.setTime(m.getDate());
            if (cal.get(Calendar.YEAR) == cal2.get(Calendar.YEAR) || cal.get(Calendar.DAY_OF_YEAR) == cal2.get(Calendar.DAY_OF_YEAR)) {
                System.out.println(m.getTimA().getIme()+ " "+m.getTimAPostigao() + " : "+ m.getTimBPostigao()+ " "+ m.getTimB().getIme());
            }
       }   
    } 
    
    public int day(int M, int D, int Y) {
        int y = Y - (14 - M) / 12;
        int x = y + y/4 - y/100 + y/400;
        int m = M + 12 * ((14-M) / 12) - 2;
        int d = (D + x + (31*m)/12) % 7;
        return d;
    }
    
    public boolean jePrestupnaGodina(int year) {
        
        if ((year % 4 ==0) && (year % 100 !=0 )) return true;
        if (year % 400 == 0) return true;
        return false;  
    }
}
