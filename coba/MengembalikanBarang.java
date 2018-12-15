/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pemrograman.lanjut.ProjectAkhir;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Calendar;
/**
 *
 * @author user
 */
public class MengembalikanBarang extends JPanel implements ActionListener{
private Label LJudul2,LBarangKembali,LJumlah,LTanggal;
private TextField pegawai,barangKembali,jumlah,tanggal;
private Button kembalikan,refresh;
private JComboBox pil;
private String pilKembalikan;
//private String[][]BStockD = new String[100][3];
//private String[][]BStockL = new String[100][3];
//private String[][]BStockT = new String[100][3];
//private String[][]BStockA = new String[100][3];
   
private Calendar hireday;
    private Calendar now;
    
    public void setBStockD(String BStockD,int i) {
        this.BStockD[i][2] = BStockD;
    }

    public void setBStockL(String BStockL,int i) {
        this.BStockL[i][2] = BStockL;
    }

    public void setBStockT(String BStockT,int i) {
        this.BStockT[i][2] = BStockT;
    }

    public void setBStockA(String BStockA,int i) {
        this.BStockA[i][2] = BStockA;
    }
    
    public void setBStockD1(String BStockD,String BStockD1,String BStockD2,int i) {
        this.BStockD[i][0] = BStockD;
         this.BStockD[i][1] = BStockD1;
          this.BStockD[i][2] = BStockD2;
    }

    public void setBStockL1(String BStockL,String BStockL1,String BStockL2,int i) {
        this.BStockL[i][0] = BStockL;
        this.BStockL[i][1] = BStockL1;
        this.BStockL[i][2] = BStockL2;
    }

    public void setBStockT1(String BStockT,String BStockT1,String BStockT2,int i) {
        this.BStockT[i][0] = BStockT;
        this.BStockT[i][1] = BStockT1;
        this.BStockT[i][2] = BStockT2;
    }

    public void setBStockA1(String BStockA,String BStockA1,String BStockA2,int i) {
        this.BStockA[i][0] = BStockA;
        this.BStockA[i][1] = BStockA1;
        this.BStockA[i][2] = BStockA2;
    }
    public MengembalikanBarang(){
    setLayout(null);
    this.now=Calendar.getInstance();
         Database database = new Database();
         BStockD=database.getDesktop();
     BStockL=database.getLaptop();
     BStockT=database.getTablet();
     BStockA=database.getAccessories();
     pegawai = new TextField("");
add(pegawai);
pegawai.setText(database.getPegawai());
         
    LJudul2 = new Label("Mengembalikan barang");
LJudul2.setFont(new Font("Arial",1,14));
add(LJudul2).setBounds(10,10,170, 20);
LBarangKembali = new Label("Nama Barang");
add(LBarangKembali).setBounds(10, 40, 80, 20);
barangKembali = new TextField("");
add(barangKembali).setBounds(130, 40, 200, 20);
LJumlah = new Label("Jumlahnya");
add(LJumlah).setBounds(10,100, 70, 20);
jumlah = new TextField("");
add(jumlah).setBounds(80, 100, 30, 20);
LTanggal = new Label("Tanggal Pembelian");
add(LTanggal).setBounds(10, 130, 120, 20);
tanggal = new TextField("");
add(tanggal).setBounds(140, 130, 140, 20);
kembalikan = new Button("Kembalikan");
add(kembalikan).setBounds(10, 160, 100, 20);
kembalikan.addActionListener(new Kembalikan());
refresh = new Button ("Refresh");
add(refresh).setBounds(140, 160, 70, 20);  
refresh.addActionListener(new Refresh());
    
    String x [] = {"Desktop", "Laptop", "Tablet", "Accessories"};
    pil = new JComboBox(x);
    add(pil).setBounds(130, 65, 130, 20);
    }
    
    
    class Kembalikan implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent event) {
            Database database = new Database();
           BStockD=database.getDesktop();
     BStockL=database.getLaptop();
     BStockT=database.getTablet();
     BStockA=database.getAccessories();
     pegawai.setText(database.getPegawai());
       String[] cek=tanggal.getText().split("-");
     String tgl=cek[0];int tgl1=Integer.parseInt(tgl);
     String bln=cek[1];int bln1=Integer.parseInt(bln);
     String thn=cek[2];int thn1=Integer.parseInt(thn);
     int tglN=now.get(Calendar.DATE);
     int blnN=(now.get(Calendar.MONTH)+1);
     int thnN=now.get(Calendar.YEAR);
     
     int test=(((thnN*360)+(blnN*30)+tglN)-((thn1*360)+(bln1*30)+tgl1));
     
            if(pegawai.getText().equals("")){}
         
          else {if(test<=7&&test>=0){
                
                if(pil.getSelectedItem().equals("Desktop")){
         for(int i=0;i<BStockD.length;i++)
         {if(barangKembali.getText().equals(BStockD[i][0])){
         int a=Integer.parseInt(jumlah.getText());
         int b=Integer.parseInt(BStockD[i][2]);b+=a;
         String c=String.valueOf(b);
         setBStockD(c,i);break;   
        }   
         }
         }
        else if(pil.getSelectedItem().equals("Laptop")){
        for(int i=0;i<BStockL.length;i++)
         {if(barangKembali.getText().equals(BStockL[i][0])){
         int a=Integer.parseInt(jumlah.getText());
         int b=Integer.parseInt(BStockL[i][2]);b+=a;
         String c=String.valueOf(b);
         setBStockL(c,i);break;
         
        } 
         }
         }
        else if(pil.getSelectedItem().equals("Tablet")){
        for(int i=0;i<BStockT.length;i++)
         {if(barangKembali.getText().equals(BStockT[i][0])){
         int a=Integer.parseInt(jumlah.getText());
         int b=Integer.parseInt(BStockT[i][2]);b+=a;
         String c=String.valueOf(b);
         setBStockT(c,i);break;
         
        }   
         }
         }
        else if(pil.getSelectedItem().equals("Accessories")){
         for(int i=0;i<BStockA.length;i++)
         {if(barangKembali.getText().equals(BStockA[i][0])){
         int a=Integer.parseInt(jumlah.getText());
         int b=Integer.parseInt(BStockA[i][2]);b+=a;
         String c=String.valueOf(b);
         setBStockA(c,i);break;
        
         }
         }
         }      
            }}
             database.setSemua(BStockD, BStockL, BStockT, BStockA, pegawai.getText());
        database.databaseWriter(BStockD,BStockL,BStockT,BStockA );
        }
}
class Refresh implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent event) {

       barangKembali.setText("");jumlah.setText("");tanggal.setText("");
        }}
    
    @Override
    public void actionPerformed(ActionEvent e) {
       }
    
}
