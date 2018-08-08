import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import org.omg.CORBA.portable.InputStream;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Scanner;
import javax.swing.JTextArea;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JTextPane;
import javax.swing.JSpinner;


public class Frage {

		//Buttons und Textfelder der gesamten Oberfläche
	static  JFrame frame=new JFrame();
	static  JTextField txtFrage= new JTextField();
	static  JButton btnAntwort1= new JButton();
	static  JButton btnAntwort2= new JButton();
	static  JButton btnAntwort3= new JButton();
    static 	JTextField txtBeantwortet= new JTextField();
    static JTextField txtNummer= new JTextField();
    static JButton btnJung=new JButton();
    static JButton btnAlt= new JButton();
    static JTextArea txtBeginn=new JTextArea();
    static JTextField txtKategorie=new JTextField();
    static JButton btnBild=new JButton();
    static JButton btnLoeschen=new JButton();
	static JButton btnKatZurueck = new JButton("");
	static JButton btnKatVor = new JButton("");
    static JButton btnEinstellungen= new JButton(" Einstellungen");
    static JButton btnFragenkatalog= new JButton("Fragenkatalog");
    static JButton btnWettkampf= new JButton("Wettkampfsimulation");
    static JButton btnEinZurueck= new JButton ("Zurück zum Hauptmenü");
    static JButton btnStatistik= new JButton("Statistiken");
	static JButton btnZuMenue = new JButton("Hauptmen\u00FC");
	static JButton btnAlterAendern= new JButton("Alter ändern");
	static JTextField txtAlter= new JTextField();
	static JButton btnAlterZurueck = new JButton("Zurück zu den Einstellungen");
	static JButton btnAbgabe = new JButton("Abgabe");
	static JButton btnAbgabe1 = new JButton();
	static JButton btnAbgabe2 = new JButton();
	static JButton btnAbgabe3 = new JButton();
	static JButton btnAbgabe4 = new JButton();
	static JButton btnAbgabe5 = new JButton();
	static JButton btnAbgabe6 = new JButton();
	static JButton btnAbgabe7 = new JButton();
	static JButton btnAbgabe8 = new JButton();
	static JButton btnAbgabe9 = new JButton();
	static JButton btnAbgabe10 = new JButton();
	static JButton btnAbgabe11 = new JButton();
	static JButton btnAbgabe12 = new JButton();
	static JButton btnAbgabe13 = new JButton();
	static JButton btnAbgabe14 = new JButton();
	static JButton btnAbgabe15 = new JButton();
	static JTextField txtRichtig = new JTextField();
	static JTextField txtFalsch = new JTextField();
	static JTextField txtFehlerpunkte = new JTextField();
	static JTextField txtAntwortNr = new JTextField();
	static JButton btnWeiter = new JButton("N\u00E4chste Frage");
	static JButton btnZurueck = new JButton("Letzte Frage");
	static JButton btnLogo= new JButton("");
	static JTextField txtStaRichtig= new JTextField("");
	static JTextField txtStaFalsch= new JTextField("");
	static JTextField txtStaUnbeantwortet= new JTextField("");	
	static JTextField txtStaFragenkatalog = new JTextField();
	static JTextField txtStaKatRichtig= new JTextField("");
	static JTextField txtStaKatFalsch= new JTextField("");
	static JTextField txtStaKatUnbeantwortet= new JTextField("");	
	static JTextField txtStaKatFragenkatalog = new JTextField();
	static JButton btnStaKatZurueck= new JButton();
	static JButton btnStaKatVor= new JButton();
	

	
    	//Verschiedene Variablen und Arrays
    static int i=0;												//Gibt Nummer der Frage an
    static int n=1;												//Zeigt Nummer der Frage an
    static int p=0;												//Zeigt an wie viele Fragen es gibt
    static int r=0;
	static  String txt="";
	static boolean jung=false;									//Zur bestimmt ob über 15 oder unter 15
	static String alter="";
	static boolean AlterEingegeben=false;
	static  String[] a=new String[3];							//String zum zufälligen belegen der Buttons
	static boolean [] Richtig= new boolean[Fragenspeicher.Frage.length];//Array in dem die richtig beantworteten Fragen gespeichert werden
	static boolean [] Falsch=new boolean[Fragenspeicher.Frage.length];	//Array in dem die falsch beantworteten Fragen gespeichert werden
	static boolean Wettkampf= false;				//Wird bei Wettkampfsimulation auf true gesetzt um Aufruf und Abfrage anzupassen
	static int[] Fragen=new int[15];
	static boolean[] RichtigWettkampf= new boolean[15];
	static int[] Markiert= new int[15];
	static File richtigF= new File("");
	static File falschF= new File("");
	static File alterF= new File("");
	static int RichtigAntwort= 0;
	static 	int StaKat=0;
	static Image Frage20= null;
	static Image Frage50= null;
	static Image Frage51= null;
	static Image Frage52= null;
	static Image Frage53= null;
	static Image Frage54= null;
	



		public static void main(String[] args) throws IOException, URISyntaxException {
		
			java.io.InputStream is=Frage.class.getResourceAsStream("Einstellungen.png");
			Image BildEinstellung=ImageIO.read(is);
			btnEinstellungen.setIcon(new ImageIcon(BildEinstellung));
			java.io.InputStream is2=Frage.class.getResourceAsStream("Zurueck.jpg");
			Image BildZurueck=ImageIO.read(is2);
			btnKatZurueck.setIcon(new ImageIcon(BildZurueck));
			java.io.InputStream is3=Frage.class.getResourceAsStream("Vor.jpg");
			Image BildVor=ImageIO.read(is3);
			btnKatVor.setIcon(new ImageIcon(BildVor));
			java.io.InputStream is4=Frage.class.getResourceAsStream("Pfeil.png");
			Image BildPfeil=ImageIO.read(is4);
			btnZuMenue.setIcon(new ImageIcon(BildPfeil));
			java.io.InputStream is5=Frage.class.getResourceAsStream("Logo.jpg");
			Image BildLogo = ImageIO.read(is5);
			btnLogo.setIcon(new ImageIcon(BildLogo));
			java.io.InputStream is6=Frage.class.getResourceAsStream("StaKatVor.jpg");
			Image BildStaKatVor=ImageIO.read(is6);
			btnStaKatVor.setIcon(new ImageIcon(BildStaKatVor));
			java.io.InputStream is7=Frage.class.getResourceAsStream("StaKatZurueck.jpg");
			Image BildStaKatZurueck=ImageIO.read(is7);
			btnStaKatZurueck.setIcon(new ImageIcon(BildStaKatZurueck));
			
			java.io.InputStream is9=Frage.class.getResourceAsStream("Frage20.jpg");
			Frage20=ImageIO.read(is9);
			java.io.InputStream is10=Frage.class.getResourceAsStream("Frage50.jpg");
			Frage50=ImageIO.read(is10);
			java.io.InputStream is11=Frage.class.getResourceAsStream("Frage51.jpg");
		    Frage51=ImageIO.read(is11);
			java.io.InputStream is12=Frage.class.getResourceAsStream("Frage52.jpg");
		    Frage52 = ImageIO.read(is12);
			java.io.InputStream is13=Frage.class.getResourceAsStream("Frage53.jpg");
			Frage53=ImageIO.read(is13);
			java.io.InputStream is14=Frage.class.getResourceAsStream("Frage54.jpg");
			Frage54=ImageIO.read(is14);



			
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frage window = new Frage();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		
		Fragenspeicher.create();	//Läd alle Fragen aus Fragenspeicher
		Lesen();				//Liest	die gespeicherten Informationen 
		Menue();

		Abfrage();
		Loeschen();			//Funktion zum zurücksetzten des Fortschrittes   muss wegen eines Buggs deaktiviert werden
		Kategorien();			//Zeigt Kategorie an
		KategorienVorZurueck();
		Einstellungen();
		Alter();
		
	}
		
	 static void Aufruf() {
			btnEinZurueck.setVisible(false);
			int x=0;
			x=(int) (Math.random()*3);				//generiert Zufallszahl zwischen 0 und 2
			a[x]=Fragenspeicher.Frage[i][1];
			if(x==0) {								//wenn x==0 ist Antwort 1 belegt und Antwort 2 und 3 werden mit falschen Antowrten belget
			a[1]=Fragenspeicher.Frage[i][2];	
			a[2]=Fragenspeicher.Frage[i][3];	

			}else {									//falls nicht
				if(x==1) {							//wird getestet ob x==1 , wenn ja dann wird Antwort 1 und 3 mit falschen Antworten Belegt
					a[0]=Fragenspeicher.Frage[i][2];	
					a[2]=Fragenspeicher.Frage[i][3];
				}else {								//falls nicht muss x 2 sein und Antwort 1 und 2 werden mit falschen Antworten Belegt
					a[0]=Fragenspeicher.Frage[i][2];	
					a[1]=Fragenspeicher.Frage[i][3];
				}
				
			}
			txtBeantwortet.setVisible(true);
			if(Richtig[i]==true) {	//Prüft ob Frage schonmal richtig beantwortet wurde
				txtBeantwortet.setText("Richtig beantwortet");	
				txtBeantwortet.setBackground(Color.GREEN);
			}
			else {
				if(Falsch[i]==true) {//Prüft ob Frage schonmal falsch beantwortet wurde#
				txtBeantwortet.setText("Falsch beantwortet");
				txtBeantwortet.setBackground(Color.RED);
				}else {
					txtBeantwortet.setVisible(false);
				}
			}
			
			txtFrage.setText(Fragenspeicher.Frage[i][0]);							//Frage mit Antworten werden angezeigt
			btnAntwort1.setText(a[0]);			
			btnAntwort2.setText(a[1]);
			btnAntwort3.setText(a[2]);
		
			txtNummer.setText("Frage "+n+"/"+p);			//Zeigt an bei welcher Frage man ist
			//Setzt alle Eigenschaften der Buttons wieder in die richtige Form
			btnAntwort1.setBounds(10, 179, 1164, 130);
			btnAntwort2.setBounds(10, 325, 1164, 130);
			btnAntwort3.setBounds(10, 467, 1164, 130);
			txtFrage.setFont(new Font("Tahoma", Font.PLAIN, 16));
			btnAntwort1.setFont(new Font("Tahoma", Font.PLAIN, 16));
			btnAntwort2.setFont(new Font("Tahoma", Font.PLAIN, 16));
			btnAntwort3.setFont(new Font("Tahoma", Font.PLAIN, 16));
			if(Wettkampf==true) {
				btnZuMenue.setBounds(644, 608, 137, 23);
				txtBeantwortet.setVisible(false);
				
				if(Markiert[n-1]==1) {
					if(btnAntwort1.getText()==Fragenspeicher.Frage[i][1]) {
						btnAntwort1.setBackground(Color.GRAY);
					}else {
						btnAntwort1.setBackground(null);
					}
					if(btnAntwort2.getText()==Fragenspeicher.Frage[i][1]) {
						btnAntwort2.setBackground(Color.GRAY);
					}else {
						btnAntwort2.setBackground(null);
					}
					if(btnAntwort3.getText()==Fragenspeicher.Frage[i][1]) {
						btnAntwort3.setBackground(Color.GRAY);
					}else {
						btnAntwort3.setBackground(null);
					}
				}
				
				
				if(Markiert[n-1]==2) {
					if(btnAntwort1.getText()==Fragenspeicher.Frage[i][2]) {
						btnAntwort1.setBackground(Color.GRAY);
					}else {
						btnAntwort1.setBackground(null);
					}
					if(btnAntwort2.getText()==Fragenspeicher.Frage[i][2]) {
						btnAntwort2.setBackground(Color.GRAY);
					}else {
						btnAntwort2.setBackground(null);
					}
					if(btnAntwort3.getText()==Fragenspeicher.Frage[i][2]) {
						btnAntwort3.setBackground(Color.GRAY);
					}else {
						btnAntwort3.setBackground(null);
					}
				}
				if(Markiert[n-1]==3) {
					if(btnAntwort1.getText()==Fragenspeicher.Frage[i][3]) {
						btnAntwort1.setBackground(Color.GRAY);
					}else {
						btnAntwort1.setBackground(null);
					}
					if(btnAntwort2.getText()==Fragenspeicher.Frage[i][3]) {
						btnAntwort2.setBackground(Color.GRAY);
					}else {
						btnAntwort2.setBackground(null);
					}
					if(btnAntwort3.getText()==Fragenspeicher.Frage[i][3]) {
						btnAntwort3.setBackground(Color.GRAY);
					}else {
						btnAntwort3.setBackground(null);
					}
				}
				
				
			}else {
			btnZuMenue.setBounds(743, 608, 137, 23);
			btnAntwort1.setBackground(null);			
			btnAntwort2.setBackground(null);	
			btnAntwort3.setBackground(null);
			btnAntwort1.setForeground(null);
			btnAntwort2.setForeground(null);
			btnAntwort3.setForeground(null);
			}
			btnBild.setVisible(false);
			btnZuMenue.setVisible(true);
			btnZuMenue.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(Wettkampf==true) {

						Object[] arg0 = null;
						int	u= JOptionPane.showOptionDialog(null, "Bist du dir sicher, dass du die Simulation abbrechen willst und ins Hauptmenü zurück willst?",
				                null, JOptionPane.YES_NO_CANCEL_OPTION,
				                JOptionPane.WARNING_MESSAGE, null, 
				                new String[]{"Ja", "Nein"}, arg0);
						if(u==0) {
							Wettkampf=false;
							for(int r=0;r<RichtigWettkampf.length;r++) {
								RichtigWettkampf[r]=false;
								Markiert[r]=0;
								btnAntwort1.setBackground(null);
								btnAntwort2.setBackground(null);
								btnAntwort3.setBackground(null);
							}
							Menue();
							
						}else {
							Wettkampf=true;
						}
						
						
					}else {
					Menue();
					}
				}
			});
			
			
	 }
	
	 static void Abfrage() {
			btnAntwort1.addActionListener(new ActionListener() {					//ActionListener für Button 1
				public void actionPerformed(ActionEvent e) {
					
					

					if(Wettkampf==true) {
						btnAntwort1.setBackground(Color.GRAY);							//Zeigt dem Spieler welchen Button er geklickt hat
						btnAntwort2.setBackground(null);
						btnAntwort3.setBackground(null);
						if(btnAntwort1.getText()==Fragenspeicher.Frage[i][1]) {
							Markiert[n-1]=1;
							RichtigWettkampf[n-1]=true;
							
						}
						if(btnAntwort1.getText()==Fragenspeicher.Frage[i][2]) {
							Markiert[n-1]=2;
							RichtigWettkampf[n-1]=false;
						}
						if(btnAntwort1.getText()==Fragenspeicher.Frage[i][3]) {
							Markiert[n-1]=3;
							RichtigWettkampf[n-1]=false;
						}
						
						///////////////////////////////////////////////
					}else {	

					btnAntwort1.setForeground(Color.BLUE);							//Zeigt dem Spieler welchen Button er geklickt hat
					if (btnAntwort1.getText().equals(Fragenspeicher.Frage[i][1])){  //Wenn Text = Richtig
						btnAntwort1.setBackground(Color.GREEN);						//Dann wird Hintergrund grün
						btnAntwort2.setBackground(Color.RED);
						btnAntwort3.setBackground(Color.RED);
						Richtig[i]=true;											//Frage wird als richtig beantwortet markiert
						Falsch[i]=false;
		
						
					}
					else{															//wenn nicht
						btnAntwort1.setBackground(Color.RED);						//Dann wird Hintergrund rot
						Richtig[i]=false;
						Falsch[i]=true;
						if (btnAntwort2.getText().equals(Fragenspeicher.Frage[i][1])){  //Wenn btn2 ist Richtig
							btnAntwort2.setBackground(Color.GREEN);						//Dann wird Hintergrund  des 2. Buttonsgrün
							btnAntwort3.setBackground(Color.RED);

						}
						else{														//Wenn nicht
							btnAntwort3.setBackground(Color.GREEN);					//Dann btn3 Grün weil das die letzte Möglichkeit ist
							btnAntwort2.setBackground(Color.RED);
						}
					}
					btnAntwort1.setEnabled(false);
					btnAntwort2.setEnabled(false);
					btnAntwort3.setEnabled(false);
				}
				}
			});
			btnAntwort2.addActionListener(new ActionListener() {					//ActionListener für Button 2
				public void actionPerformed(ActionEvent e) {
					
					if(Wettkampf==true) {
						btnAntwort1.setBackground(null);
						btnAntwort3.setBackground(null);
						btnAntwort2.setBackground(Color.GRAY);							//Zeigt dem Spieler welchen Button er geklickt hat
						if(btnAntwort2.getText()==Fragenspeicher.Frage[i][1]) {
							Markiert[n-1]=1;
							RichtigWettkampf[n-1]=true;
						}
						if(btnAntwort2.getText()==Fragenspeicher.Frage[i][2]) {
							Markiert[n-1]=2;
							RichtigWettkampf[n-1]=false;
						}
						if(btnAntwort2.getText()==Fragenspeicher.Frage[i][3]) {
							Markiert[n-1]=3;
							RichtigWettkampf[n-1]=false;
						}
						/////////////////////////////////////////////////
						
					}else {
						
					btnAntwort2.setForeground(Color.BLUE);							//Zeigt dem Spieler welchen Button er geklickt hat
					if (btnAntwort2.getText().equals(Fragenspeicher.Frage[i][1])){  //Wenn Text = Richtig
						btnAntwort2.setBackground(Color.GREEN);						//Dann wird Hintergrund grün
						btnAntwort1.setBackground(Color.RED);
						btnAntwort3.setBackground(Color.RED);
						Richtig[i]=true;											//Frage wird als richtig beantwortet markiert
						Falsch[i]=false;
		
					}
					else{															//wenn nicht
						btnAntwort2.setBackground(Color.RED);
						Falsch[i]=true;
						Richtig[i]=false;
						if (btnAntwort1.getText().equals(Fragenspeicher.Frage[i][1])){  //Wenn btn2 ist Richtig
							btnAntwort1.setBackground(Color.GREEN);						//Dann wird Hintergrund  des 2. Buttonsgrün
							btnAntwort3.setBackground(Color.RED);

						}
						else{														//Wenn nicht
							btnAntwort3.setBackground(Color.GREEN);					//Dann btn3 Grün weil das die letzte Möglichkeit ist
							btnAntwort1.setBackground(Color.RED);
						}
					}
					btnAntwort1.setEnabled(false);
					btnAntwort2.setEnabled(false);
					btnAntwort3.setEnabled(false);
				}
				}
			});
			btnAntwort3.addActionListener(new ActionListener() {					//ActionListener für Button 3
				public void actionPerformed(ActionEvent e) {
					
					if(Wettkampf==true) {
						btnAntwort1.setBackground(null);
						btnAntwort2.setBackground(null);
						btnAntwort3.setBackground(Color.GRAY);							//Zeigt dem Spieler welchen Button er geklickt hat
						if(btnAntwort3.getText()==Fragenspeicher.Frage[i][1]) {
							Markiert[n-1]=1;
							RichtigWettkampf[n-1]=true;
						}
						if(btnAntwort3.getText()==Fragenspeicher.Frage[i][2]) {
							Markiert[n-1]=2;
							RichtigWettkampf[n-1]=false;
						}
						if(btnAntwort3.getText()==Fragenspeicher.Frage[i][3]) {
							Markiert[n-1]=3;
							RichtigWettkampf[n-1]=false;
						}
						//////////////////////////////////////////////////////
						
					}else {
						
					btnAntwort3.setForeground(Color.BLUE);							//Zeigt dem Spieler welchen Button er geklickt hat
					if (btnAntwort3.getText().equals(Fragenspeicher.Frage[i][1])){  //Wenn Text = Richtig
						btnAntwort3.setBackground(Color.GREEN);						//Dann wird Hintergrund grün
						btnAntwort2.setBackground(Color.RED);
						btnAntwort1.setBackground(Color.RED);
						Richtig[i]=true;											//Frage wird als richtig beantwortet markiert
						Falsch[i]=false;
					}
					else{															//wenn nicht
						btnAntwort3.setBackground(Color.RED);						//Dann wird Hintergrund rot
		
						Falsch[i]=true;
						Richtig[i]=false;
						if (btnAntwort1.getText().equals(Fragenspeicher.Frage[i][1])){  //Wenn btn1 ist Richtig
							btnAntwort1.setBackground(Color.GREEN);						//Dann wird Hintergrund  des 1. Buttonsgrün
							btnAntwort2.setBackground(Color.RED);
						}
						else{														//Wenn nicht
							btnAntwort2.setBackground(Color.GREEN);					//Dann btn2 Grün weil das die letzte Möglichkeit ist
							btnAntwort1.setBackground(Color.RED);
						}
					}
					btnAntwort1.setEnabled(false);
					btnAntwort2.setEnabled(false);
					btnAntwort3.setEnabled(false);	
				}
					
				Richtig()	;
				}
			});
		
		 }
	 
	 static void ButtonTester(){	
		 if(Wettkampf==true) {
		 if(n==1){								//Wenn die erste Frage ausgewählt ist dann
			 btnZurueck.setVisible(false);		//Wird der ZurückButton unsichtbar
		 }else{
			 btnZurueck.setVisible(true);		//wenn nicht ist er sichtbar
		 }
		 if(n==15){	//Wenn die letzte Frage ausgewählt ist dann
			 btnWeiter.setVisible(false);		//Wird der WeiterButton unsichtbar
		 }else{
			 btnWeiter.setVisible(true);		//wenn nicht ist er sichtbar
		 }
		 if(r==-1) {
			 r=0;
		 }
		 if(r==9) {
			 r=8;
		 }
			txtNummer.setText("Frage "+n+"/15");
	 }else {
		 
		 if(i==0){								//Wenn die erste Frage ausgewählt ist dann
			 btnZurueck.setVisible(false);		//Wird der ZurückButton unsichtbar
		 }else{
			 btnZurueck.setVisible(true);		//wenn nicht ist er sichtbar
		 }
		 if(n==p){	//Wenn die letzte Frage ausgewählt ist dann
			 btnWeiter.setVisible(false);		//Wird der WeiterButton unsichtbar
		 }else{
			 btnWeiter.setVisible(true);		//wenn nicht ist er sichtbar
		 }
		 if(r==-1) {
			 r=0;
		 }
		 if(r==9) {
			 r=8;
		 }
		 if(jung==true) {
			 p=96;
		 }else {
			 p=197;
		 }
			txtNummer.setText("Frage "+n+"/"+p);
	 	}
	 }
	 	 
	 static void Schreiben() {
		
			//Richtig
			 BufferedWriter writer = null;
				 try {
					 
					  
					writer = new BufferedWriter(new FileWriter("saves/Richtig.txt"));			//Variable zum bearbeiten der .txt Datei
					 for(int b=0;b<Richtig.length;b++){								
						 
							if(Richtig[b]){				//Wenn eine Frage richtig ist
								try {
									String s = String.valueOf(b);	//Wird die Stelle b in einen String umgwandelt
									writer.write(s+"");				//in die Zeile wird die Stelle b geschrieben
									System.out.println(s);
									writer.newLine();				//es wird in die nächste Zeile gesprungen
							
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
						 }

					 writer.close();				//writer wird wieder geschlossen
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 //Falsch
				 BufferedWriter writer2 = null;
					
				 try {
					writer2 = new BufferedWriter(new FileWriter("saves/Falsch.txt"));
					 for(int q=0;q<Falsch.length;q++){
						 
							if(Falsch[q]){
								try {
									String t = String.valueOf(q);
									writer2.write(t+"");
									writer2.newLine();
							
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
						 }

					 writer2.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 
				 //Alter 
				 
				 try {
					writer = new BufferedWriter(new FileWriter("saves/Alter.txt"));			//Variable zum bearbeiten der .txt Datei							
						 
							if(jung==true){				//Wenn alter == jung
								try {
									writer.write("0");				//in die Zeile wird die Stelle b geschrieben						
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}else {
								try {
									writer.write("1");				//in die Zeile wird die Stelle b geschrieben
							
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}

					 writer.close();				//writer wird wieder geschlossen
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 
			} 
		
	 static void Lesen()  {	
		 	//Richtig
		 
		 
		 	BufferedReader rd= null;
		 	try {
		 		rd= new BufferedReader(new FileReader("saves/Richtig.txt"));
		 		
		 		String inputLine = null;
		 		while((inputLine= rd.readLine())!=null) {
		 			int d= Integer.parseInt(inputLine);
		 			if(d==200) {
		 			
		 			}else {
		 				Richtig[d]=true;
		 			}
		 		}
		 		
		 		
		 	}
		 	catch(IOException ex) {
		 				System.err.println("An IOException was caught!");
	                        ex.printStackTrace();
	                    }
	           
	                    finally {
	                        // Close the file.
	                        try {
	                            rd.close();
	                        }
	                        catch (IOException ex) {
	                            System.err.println("An IOException was caught!");
	                            ex.printStackTrace();
	                        }
	                    }
		 	
		 	//Falsch
		 	BufferedReader rd2= null;
		 	try {
		 		rd2= new BufferedReader(new FileReader(new File("saves/Falsch.txt")));
		 		
		 		String inputLine = null;
		 		while((inputLine= rd2.readLine())!=null) {
		 			int e= Integer.parseInt(inputLine);
		 			if(e==200) {
		 			
		 			}else {
		 				Falsch[e]=true;
		 			}
		 		}
		 		
		 		
		 	}
		 	catch(IOException ex) {
		 				System.err.println("An IOException was caught!");
	                        ex.printStackTrace();
	                    }
	           
	                    finally {
	                        // Close the file.
	                        try {
	                            rd2.close();
	                        }
	                        catch (IOException ex) {
	                            System.err.println("An IOException was caught!");
	                            ex.printStackTrace();
	                        }
	                    }
		 	
		 	
		 	//Alter
		 	BufferedReader rd3= null;
		 	try {
		 		rd3= new BufferedReader(new FileReader(new File("saves/Alter.txt")));
		 		
		 		String inputLine = null;
		 		while((inputLine= rd3.readLine())!=null) {

		 				
		 			
		 			int d= Integer.parseInt(inputLine);
		 			if(d==0) {
	                	jung=true;			                	
	                }else {
	                    jung=false;	
	                }
		 			if(d==0||d==1) {
		 				AlterEingegeben=true;
		 			}else {
		 				AlterEingegeben=false;
		 			
		 			}
		 		}
		 		
		 		
		 	}
		 	catch(IOException ex) {
		 				System.err.println("An IOException was caught!");
	                        ex.printStackTrace();
	                    }
	           
	                    finally {
	                        // Close the file.
	                        try {
	                            rd3.close();
	                        }
	                        catch (IOException ex) {
	                            System.err.println("An IOException was caught!");
	                            ex.printStackTrace();
	                        }
	                    }

		 		
		 		
		 	}
		
	 static void Alter() {
		  if(AlterEingegeben==false) {		//Fragt ab ob etwas in Alter.txt steht wenn nein dann wird altersabfrage durchgeführt
			//Macht das normale Spielinterface unsichtbar
			btnAntwort1.setVisible(false);
			btnAntwort2.setVisible(false);
			btnAntwort3.setVisible(false);
			btnWeiter.setVisible(false);
			txtKategorie.setVisible(false);
			txtNummer.setVisible(false);
			txtBeantwortet.setVisible(false); 
			txtFrage.setVisible(false);
			btnKatVor.setVisible(false);
			btnKatZurueck.setVisible(false);
			btnEinstellungen.setVisible(false);
			btnAlterZurueck.setVisible(false);
			btnFragenkatalog.setVisible(false);
			btnWettkampf.setVisible(false);
			btnStatistik.setVisible(false);
			btnLogo.setVisible(false);
			
			btnJung.setVisible(true);
			btnAlt.setVisible(true);
			txtBeginn.setVisible(true);
			
			//Zeigt Interface zum auswählen des Alters an
			txtBeginn.setText("Herzlich Willkommen zum Fragebogentrainer f\u00FCr die Jugendfeuerwehr Waldeck-Frankenberg.\r\nBitte w\u00E4hle dein Alter aus um zu beginnen.\r\nWenn du dieses Jahr noch 15 Jahre alt wirst gilts du als 15-J\u00E4hrige/-r.\r\nBei den Fragen gibt es immer nur eine richtige Antwort!");
			btnAlt.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					txtNummer.setText("Frage "+n+"/"+p);
					txtBeantwortet.setVisible(false);
					btnAlt.setVisible(false);
					btnJung.setVisible(false);
					Menue();
					Schreiben();
				}
			});
			
			btnJung.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					//Nachdem der Button gedrückt wurde wird das normale Spielinterface sichtbar
					
					Menue();
					Schreiben();
					btnAlt.setVisible(false);
					btnJung.setVisible(false);
					txtBeantwortet.setVisible(false);
					//bei btnJung wird jung true gesetzt
					jung=true;
				}
				
			});
		
		  }else {
			  btnWettkampf.setVisible(true);
			  Menue();
		  }
		}
		
	 static void AlterVor() {

	if(jung==true) {// Springt nur an wenn BTN 10-14 gedrückt wurde
		if(i>=20&&i<=41) {			//Gerätekunde  			Testet Stelle der Frage und wenn eine Stelle für Ältere erreicht wird wird diese übersprungen
		i=42;
		}
		if(i>=62&&i<=78) {			//Brennen
		i=79;
		}
		if(i>=95&&i<=120) {			//Löscheinsatz
		i=121;
		}
		if(i>=127&&i<=134) {			//Lebensrettende Sofortmaßnahmen
		i=135;
		}
		if(i>=142&&i<=153) {			//Löschen
		i=154;
		}
		if(i>=157&&i<=159) {			//Teschnische Hilfe
		i=160;
		}
		if(i>=169&&i<=171) {			//Unfallversicherung
		i=172;
		}
		if(i>=175&&i<=177) {			//Rechtsgrundlagen
		i=178;
		}
		if(i>=190&&i<=196) {			//Organisation
		i=189;
		}
		
		}
	}

	 static void AlterZurueck() {
	if(jung==true) {// Springt nur an wenn BTN 10-14 gedrückt wurde
		if(i>=20&&i<=41) {			//Gerätekunde   Testet Stelle der Frage und wenn eine Stelle für Ältere erreicht wird wird diese übersprungen
		i=19;
		}
		if(i>=62&&i<=78) {			//Brennen
		i=61;
		}
		if(i>=95&&i<=120) {			//Löscheinsatz
		i=94;
		}
		if(i>=127&&i<=134) {			//Lebensrettende Sofortmaßnahmen
		i=126;
		}
		if(i>=142&&i<=153) {			//Löschen
		i=141;
		}
		if(i>=157&&i<=159) {			//Technische Hilfe
		i=156;
		}
		if(i>=169&&i<=171) {			//Unfallversicherung
		i=168;
		}
		if(i>=175&&i<=177) {			//Rechtsgrundlagen
		i=175;
		}
		if(i>=190&&i<=196) {			//Organisation
		i=189;
		}
		}
	}
	
	 static void Kategorien() {
		if(i>=0&&i<=41) {
			txtKategorie.setText("Kategorie: Gerätekunde");
			txtKategorie.setBounds(125, 608, 170, 23);
			btnKatVor.setBounds(295, 608, 23, 23);
			r=0;
		}
		if(i>=42&&i<=78) {
			txtKategorie.setText("Kategorie: Brennen");
			txtKategorie.setBounds(125, 608, 140, 23);
			btnKatVor.setBounds(266, 608, 23, 23);
			r=1;
		}
		if(i>=79&&i<=120) {
			txtKategorie.setText("Kategorie: Löscheinsatz");
			txtKategorie.setBounds(125, 608, 170, 23);
			btnKatVor.setBounds(295, 608, 23, 23);
			r=2;
		}
		if(i>=121&&i<=134) {
			txtKategorie.setText("Kategorie: Lebensrettende Sofortmaßnahmen(Erste Hilfe)");
			txtKategorie.setBounds(125, 608, 387, 23);
			btnKatVor.setBounds(512, 608, 23, 23);
			r=3;
		}
		if(i>=135&&i<=153) {
			txtKategorie.setText("Kategorie: Löschen");
			txtKategorie.setBounds(125, 608, 140, 23);
			btnKatVor.setBounds(265, 608, 23, 23);
			r=4;
		}
		if(i>=154&&i<=159) {
			txtKategorie.setText("Kategorie: Technische Hilfsleistung");
			txtKategorie.setBounds(125, 608, 240, 23);
			btnKatVor.setBounds(365, 608, 23, 23);
			r=5;
		}
		if(i>=160&&i<=171) {
			txtKategorie.setText("Kategorie: Unfallverhütungsvorschriften/ Unfallversicherung");
			txtKategorie.setBounds(125, 608, 414, 23);
			btnKatVor.setBounds(539, 608, 23, 23);
			r=6;
		}
		if(i>=172&&i<=177) {
			txtKategorie.setText("Kategorie: Rechtsgrundlage");
			txtKategorie.setBounds(125, 608, 198, 23);
			btnKatVor.setBounds(323, 608, 23, 23);
			r=7;
		}
		if(i>=178&&i<=196) {
			txtKategorie.setText("Kategorie: Organisation");
			txtKategorie.setBounds(125, 608, 172, 23);
			btnKatVor.setBounds(297, 608, 23, 23);
			r=8;
		}

	}

	 static void Bild() {
		if(i==19){
			btnBild.setVisible(true);
			btnBild.setIcon(new ImageIcon(Frage20));
			btnAntwort1.setBounds(10, 185, 900, 130);		//Muss hier hin wegen Größenveränderung bei Bildfragen
			btnAntwort2.setBounds(10, 326, 900, 130);
			btnAntwort3.setBounds(10, 467, 900, 130);
			
		}
		if(i==49){
			btnBild.setVisible(true);
			btnBild.setIcon(new ImageIcon(Frage50));
			btnAntwort1.setBounds(10, 185, 900, 130);		//Muss hier hin wegen Größenveränderung bei Bildfragen
			btnAntwort2.setBounds(10, 326, 900, 130);
			btnAntwort3.setBounds(10, 467, 900, 130);
			
		}
		if(i==50){
			btnBild.setVisible(true);
			btnBild.setIcon(new ImageIcon(Frage51));
			btnAntwort1.setBounds(10, 185, 900, 130);		//Muss hier hin wegen Größenveränderung bei Bildfragen
			btnAntwort2.setBounds(10, 326, 900, 130);
			btnAntwort3.setBounds(10, 467, 900, 130);
			
		}
		if(i==51){
			btnBild.setVisible(true);
			btnBild.setIcon(new ImageIcon(Frage52));
			btnAntwort1.setBounds(10, 185, 900, 130);		//Muss hier hin wegen Größenveränderung bei Bildfragen
			btnAntwort2.setBounds(10, 326, 900, 130);
			btnAntwort3.setBounds(10, 467, 900, 130);
			
		}
		if(i==52){
			btnBild.setVisible(true);
			btnBild.setIcon(new ImageIcon(Frage53));
			btnAntwort1.setBounds(10, 185, 900, 130);		//Muss hier hin wegen Größenveränderung bei Bildfragen
			btnAntwort2.setBounds(10, 326, 900, 130);
			btnAntwort3.setBounds(10, 467, 900, 130);
			
		}
		if(i==53){
			btnBild.setVisible(true);
			btnBild.setIcon(new ImageIcon(Frage54));
			btnAntwort1.setBounds(10, 185, 900, 130);		//Muss hier hin wegen Größenveränderung bei Bildfragen
			btnAntwort2.setBounds(10, 326, 900, 130);
			btnAntwort3.setBounds(10, 467, 900, 130);
			
		}
		
	}

	 static void Loeschen() {
		btnLoeschen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				int	u= JOptionPane.showOptionDialog(null, "Bist du dir sicher, dass du den Fragenkatalog zurücksetzten willst?","Fragenkatalog zurücksetzten",
		                JOptionPane.YES_NO_CANCEL_OPTION,
		                JOptionPane.WARNING_MESSAGE, null, 
		                new String[]{"Ja", "Nein"}, arg0);
				if(u==0) {
					
					 BufferedWriter writer3 = null;
					 BufferedWriter writer4= null;
					 txtBeantwortet.setVisible(false);
					 try {
			
						writer3 = new BufferedWriter(new FileWriter("saves/Richtig.txt"));
						writer4 = new BufferedWriter(new FileWriter("saves/Falsch.txt"));
						 for(int b=0;b<Fragenspeicher.Frage.length;b++){
							 //setzr Richtg und Falsch an jeder Stelle auf false
							 	Richtig[b]=false;
							 	Falsch[b]=false;
									try {	
										
										writer3.write("200");		//überschreibt die Zahlen in der .txt Datei mit einer leeren Stelle
										writer3.newLine();		//sprignt in nächste Zeile
										writer4.write("200");
										writer4.newLine();
								
									} catch (IOException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
								}
							 

						 writer3.close();		//schließt writer
						 writer4.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
						  
				}
				}


		});
	}
	
	 static void Lang() {
		if(i==7) {
			txtFrage.setFont(new Font("Tahoma", Font.PLAIN, 16));
			btnAntwort1.setFont(new Font("Tahoma", Font.PLAIN, 11));
			btnAntwort2.setFont(new Font("Tahoma", Font.PLAIN, 11));
			btnAntwort3.setFont(new Font("Tahoma", Font.PLAIN, 11));
		}
		if(i==22) {
			txtFrage.setFont(new Font("Tahoma", Font.PLAIN, 15));
		}
		if(i==24) {
			txtFrage.setFont(new Font("Tahoma", Font.PLAIN, 12));
		}
		if(i==33) {
			txtFrage.setFont(new Font("Tahoma", Font.PLAIN, 15));
		}
		if(i==40) {
			txtFrage.setFont(new Font("Tahoma", Font.PLAIN, 13));
		}
		if(i==71) {
			btnAntwort1.setFont(new Font("Tahoma", Font.PLAIN, 14));
			btnAntwort2.setFont(new Font("Tahoma", Font.PLAIN, 14));
			btnAntwort3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		if(i==110) {
			txtFrage.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		if(i==119) {
			btnAntwort1.setFont(new Font("Tahoma", Font.PLAIN, 14));
			btnAntwort2.setFont(new Font("Tahoma", Font.PLAIN, 14));
			btnAntwort3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		if(i==122) {
			txtFrage.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		if(i==160) {
			txtFrage.setFont(new Font("Tahoma", Font.PLAIN, 13));
		}
		if(i==163) {
			btnAntwort1.setFont(new Font("Tahoma", Font.PLAIN, 14));
			btnAntwort2.setFont(new Font("Tahoma", Font.PLAIN, 14));
			btnAntwort3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		if(i==168) {
			txtFrage.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		if(i==170) {
			btnAntwort1.setFont(new Font("Tahoma", Font.PLAIN, 14));
			btnAntwort2.setFont(new Font("Tahoma", Font.PLAIN, 14));
			btnAntwort3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		if(i==189) {
			btnAntwort1.setFont(new Font("Tahoma", Font.PLAIN, 14));
			btnAntwort2.setFont(new Font("Tahoma", Font.PLAIN, 14));
			btnAntwort3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		if(i==196) {
			btnAntwort1.setFont(new Font("Tahoma", Font.PLAIN, 13));
			btnAntwort2.setFont(new Font("Tahoma", Font.PLAIN, 13));
			btnAntwort3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		}
	}
	
	 static void KategorienVorZurueck() {
		 	
			btnKatVor.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					btnAntwort1.setEnabled(true);
					btnAntwort2.setEnabled(true);
					btnAntwort3.setEnabled(true);
					r++;
					if(r==0) {			//Gerätekunde	
						i=0;				//setzt i auf die erste Frage der Kategorie
						if(jung==true) {		//testet ob Spieler jung oder alt ist
							n=1;				//und passt dem entsprechend Nummer der Frage an
						}else {
							n=1;
						}
					}
					if(r==1) {			//Brennen	
						i=42;			//setzt i auf die erste Frage der Kategorie
						if(jung==true) {		//testet ob Spieler jung oder alt ist
							n=21;				//und passt dem entsprechend Nummer der Frage an
						}else {
							n=43;
						}
					}
					if(r==2) {			//Löscheinsatz
						i=79;			//setzt i auf die erste Frage der Kategorie
						if(jung==true) {		//testet ob Spieler jung oder alt ist
							n=41;				//und passt dem entsprechend Nummer der Frage an
						}else {
							n=80;
						}
					}
					if(r==3) {			//Erste Hilfe	
						i=121;			//setzt i auf die erste Frage der Kategorie
						if(jung==true) {		//testet ob Spieler jung oder alt ist
							n=58;				//und passt dem entsprechend Nummer der Frage an
						}else {
							n=122;
						}
						}
					if(r==4) {			//Löschen	
						i=135;			//setzt i auf die erste Frage der Kategorie
						if(jung==true) {		//testet ob Spieler jung oder alt ist
							n=63;				//und passt dem entsprechend Nummer der Frage an
						}else {
							n=136;
						}
					}
					if(r==5) {			//Technische Hilfe	
						i=154;			//setzt i auf die erste Frage der Kategorie
						if(jung==true) {		//testet ob Spieler jung oder alt ist
							n=70;				//und passt dem entsprechend Nummer der Frage an
						}else {
							n=155;
						}
					}
					if(r==6) {			//Unfallversicherung
						i=160;			//setzt i auf die erste Frage der Kategorie
						if(jung==true) {		//testet ob Spieler jung oder alt ist
							n=73;				//und passt dem entsprechend Nummer der Frage an
						}else {
							n=161;
						}
					}
					if(r==7) {			//Rechtsgrundlagen		
						i=172;			//setzt i auf die erste Frage der Kategorie
						if(jung==true) {		//testet ob Spieler jung oder alt ist
							n=82;				//und passt dem entsprechend Nummer der Frage an
						}else {
							n=173;
						}
					}
					if(r==8) {			//Organisation
						i=178;			//setzt i auf die erste Frage der Kategorie
						if(jung==true) {		//testet ob Spieler jung oder alt ist
							n=85;				//und passt dem entsprechend Nummer der Frage an
						}else {
							n=179;
						}
					}
					txtBeantwortet.setVisible(false);
					Kategorien();
					Aufruf();			
					Abfrage();		
					ButtonTester();
					Bild();					
					Lang();					
					Schreiben();
				}
			});
		 
		 
			btnKatZurueck.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					btnAntwort1.setEnabled(true);
					btnAntwort2.setEnabled(true);
					btnAntwort3.setEnabled(true);
					r--;
					if(r==0) {			//Gerätekunde	
						i=0;				//setzt i auf die erste Frage der Kategorie
						if(jung==true) {		//testet ob Spieler jung oder alt ist
							n=1;				//und passt dem entsprechend Nummer der Frage an
						}else {
							n=1;
						}
					}
					if(r==1) {			//Brennen	
						i=42;			//setzt i auf die erste Frage der Kategorie
						if(jung==true) {		//testet ob Spieler jung oder alt ist
							n=21;				//und passt dem entsprechend Nummer der Frage an
						}else {
							n=43;
						}
					}
					if(r==2) {			//Löscheinsatz
						i=79;			//setzt i auf die erste Frage der Kategorie
						if(jung==true) {		//testet ob Spieler jung oder alt ist
							n=41;				//und passt dem entsprechend Nummer der Frage an
						}else {
							n=80;
						}
					}
					if(r==3) {			//Erste Hilfe	
						i=121;			//setzt i auf die erste Frage der Kategorie
						if(jung==true) {		//testet ob Spieler jung oder alt ist
							n=58;				//und passt dem entsprechend Nummer der Frage an
						}else {
							n=122;
						}
						}
					if(r==4) {			//Löschen	
						i=135;			//setzt i auf die erste Frage der Kategorie
						if(jung==true) {		//testet ob Spieler jung oder alt ist
							n=63;				//und passt dem entsprechend Nummer der Frage an
						}else {
							n=136;
						}
					}
					if(r==5) {			//Technische Hilfe	
						i=154;			//setzt i auf die erste Frage der Kategorie
						if(jung==true) {		//testet ob Spieler jung oder alt ist
							n=70;				//und passt dem entsprechend Nummer der Frage an
						}else {
							n=155;
						}
					}
					if(r==6) {			//Unfallversicherung
						i=160;			//setzt i auf die erste Frage der Kategorie
						if(jung==true) {		//testet ob Spieler jung oder alt ist
							n=73;				//und passt dem entsprechend Nummer der Frage an
						}else {
							n=161;
						}
					}
					if(r==7) {			//Rechtsgrundlagen		
						i=172;			//setzt i auf die erste Frage der Kategorie
						if(jung==true) {		//testet ob Spieler jung oder alt ist
							n=82;				//und passt dem entsprechend Nummer der Frage an
						}else {
							n=173;
						}
					}
					if(r==8) {			//Organisation
						i=178;			//setzt i auf die erste Frage der Kategorie
						if(jung==true) {		//testet ob Spieler jung oder alt ist
							n=85;				//und passt dem entsprechend Nummer der Frage an
						}else {
							n=179;
						}
					}
					txtBeantwortet.setVisible(false);
					Kategorien();
					Aufruf();			
					Abfrage();		
					ButtonTester();
					Bild();					
					Lang();					
					Schreiben();

				}
			});
	 }
	 
	 static void Einstellungen() {
			btnEinstellungen.setFont(new Font("Tahoma", Font.PLAIN, 20));
			btnEinstellungen.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					btnLoeschen.setVisible(true);
					btnEinZurueck.setVisible(true);
					btnAlterAendern.setVisible(true);
					
					btnAntwort1.setVisible(false);
					btnAntwort2.setVisible(false);
					btnAntwort3.setVisible(false);
					btnWeiter.setVisible(false);
					txtKategorie.setVisible(false);
					txtNummer.setVisible(false);
					txtBeantwortet.setVisible(false); 
					txtFrage.setVisible(false);
					btnKatVor.setVisible(false);
					btnKatZurueck.setVisible(false);
					btnJung.setVisible(true);
					btnAlt.setVisible(true);
					btnAlt.setVisible(false);
					btnJung.setVisible(false);
					txtBeginn.setVisible(false);
					btnEinstellungen.setVisible(false);
					btnFragenkatalog.setVisible(false);
					btnWettkampf.setVisible(false);
					btnStatistik.setVisible(false);
				}
			});
			
			
			btnEinZurueck.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Menue();
				}
			});
			
			btnAlterAendern.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
						Lesen();

					btnAlt.setVisible(true);
					btnJung.setVisible(true);
					txtAlter.setVisible(true);
					btnAlterZurueck.setVisible(true);
					btnEinZurueck.setVisible(false);
					btnAlterAendern.setVisible(false);
					btnLoeschen.setVisible(false);
					String jungS="10-14 Jahre";
					String altS="15-18 Jahre";
					if(jung==true) {
						alter=jungS;
					}else {
						alter=altS;
					}
					
					txtAlter.setText(("Dein momentanes Alter beträgt "+ alter));
					btnAlt.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							txtNummer.setText("Frage "+n+"/"+p);
							alter=altS;
							jung=false;
							txtAlter.setText(("Dein momentanes Alter beträgt "+ alter));
							Schreiben();
						}
					});
					btnJung.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							txtNummer.setText("Frage "+n+"/"+p);
							jung=true;
							alter=jungS;
							txtAlter.setText(("Dein momentanes Alter beträgt "+ alter));
							Schreiben();
						}
					});
					
					btnAlterZurueck.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							btnLoeschen.setVisible(true);
							btnEinZurueck.setVisible(true);
							btnAlterAendern.setVisible(true);
							
							btnAntwort1.setVisible(false);
							btnAntwort2.setVisible(false);
							btnAntwort3.setVisible(false);
							btnWeiter.setVisible(false);
							txtKategorie.setVisible(false);
							txtNummer.setVisible(false);
							txtBeantwortet.setVisible(false); 
							txtFrage.setVisible(false);
							btnKatVor.setVisible(false);
							btnKatZurueck.setVisible(false);
							btnJung.setVisible(true);
							btnAlt.setVisible(true);
							btnAlt.setVisible(false);
							btnJung.setVisible(false);
							txtBeginn.setVisible(false);
							btnEinstellungen.setVisible(false);
							btnFragenkatalog.setVisible(false);
							btnWettkampf.setVisible(false);
							btnStatistik.setVisible(false);
							btnAlterZurueck.setVisible(false);
							txtAlter.setVisible(false);
						}
					});
					
					
				}
			});
	 }
	
	 static void Menue() {

		 	txtAntwortNr.setVisible(false);
		 	txtBeginn.setVisible(false);
			btnAntwort1.setVisible(false);
			btnAntwort2.setVisible(false);
			btnAntwort3.setVisible(false);
			txtKategorie.setVisible(false);
			txtNummer.setVisible(false);
			txtBeantwortet.setVisible(false); 
			txtFrage.setVisible(false);
			btnKatVor.setVisible(false);
			btnKatZurueck.setVisible(false);
			btnEinZurueck.setVisible(false);
			btnLoeschen.setVisible(false);
			btnEinstellungen.setVisible(true);
			btnFragenkatalog.setVisible(true);
			btnWettkampf.setVisible(true);
			btnStatistik.setVisible(true);
			btnZuMenue.setVisible(false);
			btnAlterAendern.setVisible(false);
			btnAbgabe.setVisible(false);
			btnBild.setVisible(false);
			txtRichtig.setVisible(false);
			txtFalsch.setVisible(false);
			txtFehlerpunkte.setVisible(false);
			btnAbgabe1.setVisible(false);
			btnAbgabe2.setVisible(false);
			btnAbgabe3.setVisible(false);
			btnAbgabe4.setVisible(false);
			btnAbgabe5.setVisible(false);
			btnAbgabe6.setVisible(false);
			btnAbgabe7.setVisible(false);
			btnAbgabe8.setVisible(false);
			btnAbgabe9.setVisible(false);
			btnAbgabe10.setVisible(false);
			btnAbgabe11.setVisible(false);
			btnAbgabe12.setVisible(false);
			btnAbgabe13.setVisible(false);
			btnAbgabe14.setVisible(false);
			btnAbgabe15.setVisible(false);
			btnAntwort1.setEnabled(true);
			btnAntwort2.setEnabled(true);
			btnAntwort3.setEnabled(true);
			btnFragenkatalog.setVisible(true);
			btnLogo.setVisible(true);
			btnWettkampf.setVisible(true);
			btnStatistik.setVisible(true);
			btnWeiter.setVisible(false);
			btnZurueck.setVisible(false);
			txtStaFragenkatalog.setVisible(false);
			txtStaRichtig.setVisible(false);
			txtStaFalsch.setVisible(false);
			txtStaUnbeantwortet.setVisible(false);
			txtStaKatFragenkatalog.setVisible(false);
			txtStaKatRichtig.setVisible(false);
			txtStaKatFalsch.setVisible(false);
			txtStaKatUnbeantwortet.setVisible(false);
			btnStaKatZurueck.setVisible(false);
			btnStaKatVor.setVisible(false);
			StaKat=0;
			for(int g=0;g<Markiert.length;g++) {
				Markiert[g]=0;
				RichtigWettkampf[g]=false;
			}
			btnAntwort1.setBackground(null);
			btnAntwort2.setBackground(null);
			btnAntwort3.setBackground(null);
			
			btnFragenkatalog.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					btnAntwort1.setVisible(true);
					btnAntwort2.setVisible(true);
					btnAntwort3.setVisible(true);
					btnWeiter.setVisible(true);
					txtKategorie.setVisible(true);
					txtNummer.setVisible(true);
					txtBeantwortet.setVisible(true); 
					txtFrage.setVisible(true);
					btnKatVor.setVisible(true);
					btnKatZurueck.setVisible(true);
					btnEinZurueck.setVisible(true);
					btnEinstellungen.setVisible(false);
					btnFragenkatalog.setVisible(false);
					btnWettkampf.setVisible(false);
					btnStatistik.setVisible(false);
					txtAlter.setVisible(false);
					btnLogo.setVisible(false);
					n=1;
					i=0;
					Aufruf();				//Belegt alle Buttons und Textfelder auf der Oberfläche
					ButtonTester();
				}
			});
			
			btnWettkampf.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					Wettkampf();
				
				//	Weiter();
				}
			});
			
			btnStatistik.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					Statistik();
				}
			});
			

	 }
	 
	 static void Wettkampf() {
		 	Wettkampf=true;
		 	btnWettkampf.setVisible(false);
			btnFragenkatalog.setVisible(false);
			btnStatistik.setVisible(false);
			btnEinstellungen.setVisible(false);
			txtFrage.setVisible(true);
			btnAntwort1.setVisible(true);
			btnAntwort2.setVisible(true);
			btnAntwort3.setVisible(true);
			txtNummer.setVisible(true);
			btnAbgabe.setVisible(true);
			btnLogo.setVisible(false);
			n=1;
			int d=197;
			if(jung==true) {
				d=96;
			}
			for(int u=0;u<15;u++) {
			Fragen[u]=(int) (Math.random()*d);
			for(int q=0;q<u;q++)
			if(Fragen[u]==Fragen[q]) {
				u--;
			}
			System.out.println(Fragen[u]);
			}
			
			i=Fragen[n-1];
			Aufruf();
			Bild();
			ButtonTester();
			Auswertung();
			
			
	 }
	 
	 static void Auswertung() {
		 btnAbgabe.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					btnAbgabe.setBounds(791, 608, 89, 23);
					btnAbgabe.setText("Abgabe");
					
					if(Wettkampf==true) {
					
					Object[] arg0 = null;
					int	u= JOptionPane.showOptionDialog(null, "Bist du dir sicher, dass du deinen Fragebogen zur Auswertung abgeben möchtest?",
			                null, JOptionPane.YES_NO_CANCEL_OPTION,
			                JOptionPane.WARNING_MESSAGE, null, 
			                new String[]{"Ja", "Nein"}, arg0);
					if(u==0) {
					btnAbgabe.setText("Abgabe");	
					btnAntwort1.setEnabled(true);
					btnAntwort2.setEnabled(true);
					btnAntwort3.setEnabled(true);
						
					txtAntwortNr.setVisible(false);
					Wettkampf=false;
					txtFrage.setVisible(false);
					btnAntwort1.setVisible(false);
					btnAntwort2.setVisible(false);
					btnAntwort3.setVisible(false);
					txtNummer.setVisible(false);
					btnAbgabe.setVisible(false);
					btnZurueck.setVisible(false);
					btnZuMenue.setVisible(false);
					btnBild.setVisible(false);
					btnWeiter.setVisible(false);
					btnAbgabe1.setVisible(true);
					btnAbgabe2.setVisible(true);
					btnAbgabe3.setVisible(true);
					btnAbgabe4.setVisible(true);
					btnAbgabe5.setVisible(true);
					btnAbgabe6.setVisible(true);
					btnAbgabe7.setVisible(true);
					btnAbgabe8.setVisible(true);
					btnAbgabe9.setVisible(true);
					btnAbgabe10.setVisible(true);
					btnAbgabe11.setVisible(true);
					btnAbgabe12.setVisible(true);
					btnAbgabe13.setVisible(true);
					btnAbgabe14.setVisible(true);
					btnAbgabe15.setVisible(true);
					txtRichtig.setVisible(true);
					txtFalsch.setVisible(true);
					txtFehlerpunkte.setVisible(true);
					btnZuMenue.setVisible(true);
					
					int ja=0;
					int nein=0;
					for(int z=0;z<RichtigWettkampf.length;z++) {
						if(RichtigWettkampf[z]==true) {
							ja++;
						}else {
							nein++;
						}
					}
					
					txtRichtig.setText("Richtig beantwortet: "+ja+"/15");
					txtFalsch.setText("Falsch beantwortet: "+nein+"/15");
					txtFehlerpunkte.setText("Fehlerpunkte im Wettkampf: "+nein*5);
					
					btnAbgabe1.setText("Frage 1:"+ Fragenspeicher.Frage[Fragen[0]][0]);
					if(RichtigWettkampf[0]==true) {
						btnAbgabe1.setBackground(Color.GREEN);
					}else {
						btnAbgabe1.setBackground(Color.RED);
					}
					btnAbgabe2.setText("Frage 2:"+ Fragenspeicher.Frage[Fragen[1]][0]);
					if(RichtigWettkampf[1]==true) {
						btnAbgabe2.setBackground(Color.GREEN);
					}else {
						btnAbgabe2.setBackground(Color.RED);
					}
					btnAbgabe3.setText("Frage 3:"+ Fragenspeicher.Frage[Fragen[2]][0]);
					if(RichtigWettkampf[2]==true) {
						btnAbgabe3.setBackground(Color.GREEN);
					}else {
						btnAbgabe3.setBackground(Color.RED);
					}
					btnAbgabe4.setText("Frage 4:"+ Fragenspeicher.Frage[Fragen[3]][0]);
					if(RichtigWettkampf[3]==true) {
						btnAbgabe4.setBackground(Color.GREEN);
					}else {
						btnAbgabe4.setBackground(Color.RED);
					}
					btnAbgabe5.setText("Frage 5:"+ Fragenspeicher.Frage[Fragen[4]][0]);
					if(RichtigWettkampf[4]==true) {
						btnAbgabe5.setBackground(Color.GREEN);
					}else {
						btnAbgabe5.setBackground(Color.RED);
					}
					btnAbgabe6.setText("Frage 6:"+ Fragenspeicher.Frage[Fragen[5]][0]);
					if(RichtigWettkampf[5]==true) {
						btnAbgabe6.setBackground(Color.GREEN);
					}else {
						btnAbgabe6.setBackground(Color.RED);
					}
					btnAbgabe7.setText("Frage 7:"+ Fragenspeicher.Frage[Fragen[6]][0]);
					if(RichtigWettkampf[6]==true) {
						btnAbgabe7.setBackground(Color.GREEN);
					}else {
						btnAbgabe7.setBackground(Color.RED);
					}
					btnAbgabe8.setText("Frage 8:"+ Fragenspeicher.Frage[Fragen[7]][0]);
					if(RichtigWettkampf[7]==true) {
						btnAbgabe8.setBackground(Color.GREEN);
					}else {
						btnAbgabe8.setBackground(Color.RED);
					}
					btnAbgabe9.setText("Frage 9:"+ Fragenspeicher.Frage[Fragen[8]][0]);
					if(RichtigWettkampf[8]==true) {
						btnAbgabe9.setBackground(Color.GREEN);
					}else {
						btnAbgabe9.setBackground(Color.RED);
					}
					btnAbgabe10.setText("Frage 10:"+ Fragenspeicher.Frage[Fragen[9]][0]);
					if(RichtigWettkampf[9]==true) {
						btnAbgabe10.setBackground(Color.GREEN);
					}else {
						btnAbgabe10.setBackground(Color.RED);
					}
					btnAbgabe11.setText("Frage 11:"+ Fragenspeicher.Frage[Fragen[10]][0]);
					if(RichtigWettkampf[10]==true) {
						btnAbgabe11.setBackground(Color.GREEN);
					}else {
						btnAbgabe11.setBackground(Color.RED);
					}
					btnAbgabe12.setText("Frage 12:"+ Fragenspeicher.Frage[Fragen[11]][0]);
					if(RichtigWettkampf[11]==true) {
						btnAbgabe12.setBackground(Color.GREEN);
					}else {
						btnAbgabe12.setBackground(Color.RED);
					}
					btnAbgabe13.setText("Frage 13:"+ Fragenspeicher.Frage[Fragen[12]][0]);
					if(RichtigWettkampf[12]==true) {
						btnAbgabe13.setBackground(Color.GREEN);
					}else {
						btnAbgabe13.setBackground(Color.RED);
					}
					btnAbgabe14.setText("Frage 14:"+ Fragenspeicher.Frage[Fragen[13]][0]);
					if(RichtigWettkampf[13]==true) {
						btnAbgabe14.setBackground(Color.GREEN);
					}else {
						btnAbgabe14.setBackground(Color.RED);
					}
					btnAbgabe15.setText("Frage 15:"+ Fragenspeicher.Frage[Fragen[14]][0]);
					if(RichtigWettkampf[14]==true) {
						btnAbgabe15.setBackground(Color.GREEN);
					}else {
						btnAbgabe15.setBackground(Color.RED);
					}
					
					Anschauen();
					Schreiben();
					
					
					
					
					}else {
						Wettkampf=true;
					}
				}else {
					btnAbgabe.setText("Abgabe");	
					btnAntwort1.setEnabled(true);
					btnAntwort2.setEnabled(true);
					btnAntwort3.setEnabled(true);
						
					txtAntwortNr.setVisible(false);
					Wettkampf=false;
					txtFrage.setVisible(false);
					btnAntwort1.setVisible(false);
					btnAntwort2.setVisible(false);
					btnAntwort3.setVisible(false);
					txtNummer.setVisible(false);
					btnAbgabe.setVisible(false);
					btnZurueck.setVisible(false);
					btnZuMenue.setVisible(false);
					btnBild.setVisible(false);
					btnWeiter.setVisible(false);
					btnAbgabe1.setVisible(true);
					btnAbgabe2.setVisible(true);
					btnAbgabe3.setVisible(true);
					btnAbgabe4.setVisible(true);
					btnAbgabe5.setVisible(true);
					btnAbgabe6.setVisible(true);
					btnAbgabe7.setVisible(true);
					btnAbgabe8.setVisible(true);
					btnAbgabe9.setVisible(true);
					btnAbgabe10.setVisible(true);
					btnAbgabe11.setVisible(true);
					btnAbgabe12.setVisible(true);
					btnAbgabe13.setVisible(true);
					btnAbgabe14.setVisible(true);
					btnAbgabe15.setVisible(true);
					txtRichtig.setVisible(true);
					txtFalsch.setVisible(true);
					txtFehlerpunkte.setVisible(true);
					btnZuMenue.setVisible(true);
					
					int ja=0;
					int nein=0;
					for(int z=0;z<RichtigWettkampf.length;z++) {
						if(RichtigWettkampf[z]==true) {
							ja++;
						}else {
							nein++;
						}
					}
					
					txtRichtig.setText("Richtig beantwortet: "+ja+"/15");
					txtFalsch.setText("Falsch beantwortet: "+nein+"/15");
					txtFehlerpunkte.setText("Fehlerpunkte im Wettkampf: "+nein*5);
					
					btnAbgabe1.setText("Frage 1:"+ Fragenspeicher.Frage[Fragen[0]][0]);
					if(RichtigWettkampf[0]==true) {
						btnAbgabe1.setBackground(Color.GREEN);
					}else {
						btnAbgabe1.setBackground(Color.RED);
					}
					btnAbgabe2.setText("Frage 2:"+ Fragenspeicher.Frage[Fragen[1]][0]);
					if(RichtigWettkampf[1]==true) {
						btnAbgabe2.setBackground(Color.GREEN);
					}else {
						btnAbgabe2.setBackground(Color.RED);
					}
					btnAbgabe3.setText("Frage 3:"+ Fragenspeicher.Frage[Fragen[2]][0]);
					if(RichtigWettkampf[2]==true) {
						btnAbgabe3.setBackground(Color.GREEN);
					}else {
						btnAbgabe3.setBackground(Color.RED);
					}
					btnAbgabe4.setText("Frage 4:"+ Fragenspeicher.Frage[Fragen[3]][0]);
					if(RichtigWettkampf[3]==true) {
						btnAbgabe4.setBackground(Color.GREEN);
					}else {
						btnAbgabe4.setBackground(Color.RED);
					}
					btnAbgabe5.setText("Frage 5:"+ Fragenspeicher.Frage[Fragen[4]][0]);
					if(RichtigWettkampf[4]==true) {
						btnAbgabe5.setBackground(Color.GREEN);
					}else {
						btnAbgabe5.setBackground(Color.RED);
					}
					btnAbgabe6.setText("Frage 6:"+ Fragenspeicher.Frage[Fragen[5]][0]);
					if(RichtigWettkampf[5]==true) {
						btnAbgabe6.setBackground(Color.GREEN);
					}else {
						btnAbgabe6.setBackground(Color.RED);
					}
					btnAbgabe7.setText("Frage 7:"+ Fragenspeicher.Frage[Fragen[6]][0]);
					if(RichtigWettkampf[6]==true) {
						btnAbgabe7.setBackground(Color.GREEN);
					}else {
						btnAbgabe7.setBackground(Color.RED);
					}
					btnAbgabe8.setText("Frage 8:"+ Fragenspeicher.Frage[Fragen[7]][0]);
					if(RichtigWettkampf[7]==true) {
						btnAbgabe8.setBackground(Color.GREEN);
					}else {
						btnAbgabe8.setBackground(Color.RED);
					}
					btnAbgabe9.setText("Frage 9:"+ Fragenspeicher.Frage[Fragen[8]][0]);
					if(RichtigWettkampf[8]==true) {
						btnAbgabe9.setBackground(Color.GREEN);
					}else {
						btnAbgabe9.setBackground(Color.RED);
					}
					btnAbgabe10.setText("Frage 10:"+ Fragenspeicher.Frage[Fragen[9]][0]);
					if(RichtigWettkampf[9]==true) {
						btnAbgabe10.setBackground(Color.GREEN);
					}else {
						btnAbgabe10.setBackground(Color.RED);
					}
					btnAbgabe11.setText("Frage 11:"+ Fragenspeicher.Frage[Fragen[10]][0]);
					if(RichtigWettkampf[10]==true) {
						btnAbgabe11.setBackground(Color.GREEN);
					}else {
						btnAbgabe11.setBackground(Color.RED);
					}
					btnAbgabe12.setText("Frage 12:"+ Fragenspeicher.Frage[Fragen[11]][0]);
					if(RichtigWettkampf[11]==true) {
						btnAbgabe12.setBackground(Color.GREEN);
					}else {
						btnAbgabe12.setBackground(Color.RED);
					}
					btnAbgabe13.setText("Frage 13:"+ Fragenspeicher.Frage[Fragen[12]][0]);
					if(RichtigWettkampf[12]==true) {
						btnAbgabe13.setBackground(Color.GREEN);
					}else {
						btnAbgabe13.setBackground(Color.RED);
					}
					btnAbgabe14.setText("Frage 14:"+ Fragenspeicher.Frage[Fragen[13]][0]);
					if(RichtigWettkampf[13]==true) {
						btnAbgabe14.setBackground(Color.GREEN);
					}else {
						btnAbgabe14.setBackground(Color.RED);
					}
					btnAbgabe15.setText("Frage 15:"+ Fragenspeicher.Frage[Fragen[14]][0]);
					if(RichtigWettkampf[14]==true) {
						btnAbgabe15.setBackground(Color.GREEN);
					}else {
						btnAbgabe15.setBackground(Color.RED);
					}
					
					Anschauen();
					
				}
				}
			});
		 
		 
	 }
	
	 static void Anschauen() {
		 
			btnAbgabe1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					btnAbgabe.setBounds(791, 608, 170, 23);
					btnAbgabe.setText("Zurück zur Auswertung");
					txtRichtig.setVisible(false);
					txtFalsch.setVisible(false);
					txtFehlerpunkte.setVisible(false);
					btnAbgabe1.setVisible(false);
					btnAbgabe2.setVisible(false);
					btnAbgabe3.setVisible(false);
					btnAbgabe4.setVisible(false);
					btnAbgabe5.setVisible(false);
					btnAbgabe6.setVisible(false);
					btnAbgabe7.setVisible(false);
					btnAbgabe8.setVisible(false);
					btnAbgabe9.setVisible(false);
					btnAbgabe10.setVisible(false);
					btnAbgabe11.setVisible(false);
					btnAbgabe12.setVisible(false);
					btnAbgabe13.setVisible(false);
					btnAbgabe14.setVisible(false);
					btnAbgabe15.setVisible(false);
					
					txtFrage.setVisible(true);
					btnAntwort1.setVisible(true);
					btnAntwort2.setVisible(true);
					btnAntwort3.setVisible(true);
					btnAbgabe.setVisible(true);
					txtAntwortNr.setVisible(true);
					txtAntwortNr.setText("Deine Antwort:"+Markiert[0]);
					btnAntwort1.setEnabled(false);	
					btnAntwort2.setEnabled(false);
					btnAntwort3.setEnabled(false);
					btnAntwort1.setBackground(Color.GREEN);
					btnAntwort2.setBackground(Color.RED);
					btnAntwort3.setBackground(Color.RED);
					txtFrage.setText(Fragenspeicher.Frage[Fragen[0]][0]);
					btnAntwort1.setText(Fragenspeicher.Frage[Fragen[0]][1]);
					btnAntwort2.setText(Fragenspeicher.Frage[Fragen[0]][2]);
					btnAntwort3.setText(Fragenspeicher.Frage[Fragen[0]][3]);
					Bild();
					Lang();
				}
			});
			 
				btnAbgabe2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						btnAbgabe.setBounds(791, 608, 170, 23);
						btnAbgabe.setText("Zurück zur Auswertung");
						txtRichtig.setVisible(false);
						txtFalsch.setVisible(false);
						txtFehlerpunkte.setVisible(false);
						btnAbgabe1.setVisible(false);
						btnAbgabe2.setVisible(false);
						btnAbgabe3.setVisible(false);
						btnAbgabe4.setVisible(false);
						btnAbgabe5.setVisible(false);
						btnAbgabe6.setVisible(false);
						btnAbgabe7.setVisible(false);
						btnAbgabe8.setVisible(false);
						btnAbgabe9.setVisible(false);
						btnAbgabe10.setVisible(false);
						btnAbgabe11.setVisible(false);
						btnAbgabe12.setVisible(false);
						btnAbgabe13.setVisible(false);
						btnAbgabe14.setVisible(false);
						btnAbgabe15.setVisible(false);
						
						txtFrage.setVisible(true);
						btnAntwort1.setVisible(true);
						btnAntwort2.setVisible(true);
						btnAntwort3.setVisible(true);
						btnAbgabe.setVisible(true);
						txtAntwortNr.setVisible(true);
						txtAntwortNr.setText("Deine Antwort:"+Markiert[1]);
						btnAntwort1.setEnabled(false);	
						btnAntwort2.setEnabled(false);
						btnAntwort3.setEnabled(false);
						btnAntwort1.setBackground(Color.GREEN);
						btnAntwort2.setBackground(Color.RED);
						btnAntwort3.setBackground(Color.RED);
						txtFrage.setText(Fragenspeicher.Frage[Fragen[1]][0]);
						btnAntwort1.setText(Fragenspeicher.Frage[Fragen[1]][1]);
						btnAntwort2.setText(Fragenspeicher.Frage[Fragen[1]][2]);
						btnAntwort3.setText(Fragenspeicher.Frage[Fragen[1]][3]);
						Bild();
						Lang();
					}
				});	
				 
				btnAbgabe3.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						btnAbgabe.setBounds(791, 608, 170, 23);
						btnAbgabe.setText("Zurück zur Auswertung");
						txtRichtig.setVisible(false);
						txtFalsch.setVisible(false);
						txtFehlerpunkte.setVisible(false);
						btnAbgabe1.setVisible(false);
						btnAbgabe2.setVisible(false);
						btnAbgabe3.setVisible(false);
						btnAbgabe4.setVisible(false);
						btnAbgabe5.setVisible(false);
						btnAbgabe6.setVisible(false);
						btnAbgabe7.setVisible(false);
						btnAbgabe8.setVisible(false);
						btnAbgabe9.setVisible(false);
						btnAbgabe10.setVisible(false);
						btnAbgabe11.setVisible(false);
						btnAbgabe12.setVisible(false);
						btnAbgabe13.setVisible(false);
						btnAbgabe14.setVisible(false);
						btnAbgabe15.setVisible(false);
						
						txtFrage.setVisible(true);
						btnAntwort1.setVisible(true);
						btnAntwort2.setVisible(true);
						btnAntwort3.setVisible(true);
						btnAbgabe.setVisible(true);
						txtAntwortNr.setVisible(true);
						txtAntwortNr.setText("Deine Antwort:"+Markiert[2]);
						btnAntwort1.setEnabled(false);	
						btnAntwort2.setEnabled(false);
						btnAntwort3.setEnabled(false);
						btnAntwort1.setBackground(Color.GREEN);
						btnAntwort2.setBackground(Color.RED);
						btnAntwort3.setBackground(Color.RED);
						txtFrage.setText(Fragenspeicher.Frage[Fragen[2]][0]);
						btnAntwort1.setText(Fragenspeicher.Frage[Fragen[2]][1]);
						btnAntwort2.setText(Fragenspeicher.Frage[Fragen[2]][2]);
						btnAntwort3.setText(Fragenspeicher.Frage[Fragen[2]][3]);
						Bild();
						Lang();
					}
				});
				 
				btnAbgabe4.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						btnAbgabe.setBounds(791, 608, 170, 23);
						btnAbgabe.setText("Zurück zur Auswertung");
						txtRichtig.setVisible(false);
						txtFalsch.setVisible(false);
						txtFehlerpunkte.setVisible(false);
						btnAbgabe1.setVisible(false);
						btnAbgabe2.setVisible(false);
						btnAbgabe3.setVisible(false);
						btnAbgabe4.setVisible(false);
						btnAbgabe5.setVisible(false);
						btnAbgabe6.setVisible(false);
						btnAbgabe7.setVisible(false);
						btnAbgabe8.setVisible(false);
						btnAbgabe9.setVisible(false);
						btnAbgabe10.setVisible(false);
						btnAbgabe11.setVisible(false);
						btnAbgabe12.setVisible(false);
						btnAbgabe13.setVisible(false);
						btnAbgabe14.setVisible(false);
						btnAbgabe15.setVisible(false);
						
						txtFrage.setVisible(true);
						btnAntwort1.setVisible(true);
						btnAntwort2.setVisible(true);
						btnAntwort3.setVisible(true);
						btnAbgabe.setVisible(true);
						txtAntwortNr.setVisible(true);
						txtAntwortNr.setText("Deine Antwort:"+Markiert[3]);
						btnAntwort1.setEnabled(false);	
						btnAntwort2.setEnabled(false);
						btnAntwort3.setEnabled(false);
						btnAntwort1.setBackground(Color.GREEN);
						btnAntwort2.setBackground(Color.RED);
						btnAntwort3.setBackground(Color.RED);
						txtFrage.setText(Fragenspeicher.Frage[Fragen[3]][0]);
						btnAntwort1.setText(Fragenspeicher.Frage[Fragen[3]][1]);
						btnAntwort2.setText(Fragenspeicher.Frage[Fragen[3]][2]);
						btnAntwort3.setText(Fragenspeicher.Frage[Fragen[3]][3]);
						Bild();
						Lang();
					}
				});
				 
				btnAbgabe5.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						btnAbgabe.setBounds(791, 608, 170, 23);
						btnAbgabe.setText("Zurück zur Auswertung");
						txtRichtig.setVisible(false);
						txtFalsch.setVisible(false);
						txtFehlerpunkte.setVisible(false);
						btnAbgabe1.setVisible(false);
						btnAbgabe2.setVisible(false);
						btnAbgabe3.setVisible(false);
						btnAbgabe4.setVisible(false);
						btnAbgabe5.setVisible(false);
						btnAbgabe6.setVisible(false);
						btnAbgabe7.setVisible(false);
						btnAbgabe8.setVisible(false);
						btnAbgabe9.setVisible(false);
						btnAbgabe10.setVisible(false);
						btnAbgabe11.setVisible(false);
						btnAbgabe12.setVisible(false);
						btnAbgabe13.setVisible(false);
						btnAbgabe14.setVisible(false);
						btnAbgabe15.setVisible(false);
						
						txtFrage.setVisible(true);
						btnAntwort1.setVisible(true);
						btnAntwort2.setVisible(true);
						btnAntwort3.setVisible(true);
						btnAbgabe.setVisible(true);
						txtAntwortNr.setVisible(true);
						txtAntwortNr.setText("Deine Antwort:"+Markiert[4]);
						btnAntwort1.setEnabled(false);	
						btnAntwort2.setEnabled(false);
						btnAntwort3.setEnabled(false);
						btnAntwort1.setBackground(Color.GREEN);
						btnAntwort2.setBackground(Color.RED);
						btnAntwort3.setBackground(Color.RED);
						txtFrage.setText(Fragenspeicher.Frage[Fragen[4]][0]);
						btnAntwort1.setText(Fragenspeicher.Frage[Fragen[4]][1]);
						btnAntwort2.setText(Fragenspeicher.Frage[Fragen[4]][2]);
						btnAntwort3.setText(Fragenspeicher.Frage[Fragen[4]][3]);
						Bild();
						Lang();
					}
				});
				 
				btnAbgabe6.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						btnAbgabe.setBounds(791, 608, 170, 23);
						btnAbgabe.setText("Zurück zur Auswertung");
						txtRichtig.setVisible(false);
						txtFalsch.setVisible(false);
						txtFehlerpunkte.setVisible(false);
						btnAbgabe1.setVisible(false);
						btnAbgabe2.setVisible(false);
						btnAbgabe3.setVisible(false);
						btnAbgabe4.setVisible(false);
						btnAbgabe5.setVisible(false);
						btnAbgabe6.setVisible(false);
						btnAbgabe7.setVisible(false);
						btnAbgabe8.setVisible(false);
						btnAbgabe9.setVisible(false);
						btnAbgabe10.setVisible(false);
						btnAbgabe11.setVisible(false);
						btnAbgabe12.setVisible(false);
						btnAbgabe13.setVisible(false);
						btnAbgabe14.setVisible(false);
						btnAbgabe15.setVisible(false);
						
						txtFrage.setVisible(true);
						btnAntwort1.setVisible(true);
						btnAntwort2.setVisible(true);
						btnAntwort3.setVisible(true);
						btnAbgabe.setVisible(true);
						txtAntwortNr.setVisible(true);
						txtAntwortNr.setText("Deine Antwort:"+Markiert[5]);
						btnAntwort1.setEnabled(false);	
						btnAntwort2.setEnabled(false);
						btnAntwort3.setEnabled(false);
						btnAntwort1.setBackground(Color.GREEN);
						btnAntwort2.setBackground(Color.RED);
						btnAntwort3.setBackground(Color.RED);
						txtFrage.setText(Fragenspeicher.Frage[Fragen[5]][0]);
						btnAntwort1.setText(Fragenspeicher.Frage[Fragen[5]][1]);
						btnAntwort2.setText(Fragenspeicher.Frage[Fragen[5]][2]);
						btnAntwort3.setText(Fragenspeicher.Frage[Fragen[5]][3]);
						Bild();
						Lang();
					}
				});
				 
				btnAbgabe7.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						btnAbgabe.setBounds(791, 608, 170, 23);
						btnAbgabe.setText("Zurück zur Auswertung");
						txtRichtig.setVisible(false);
						txtFalsch.setVisible(false);
						txtFehlerpunkte.setVisible(false);
						btnAbgabe1.setVisible(false);
						btnAbgabe2.setVisible(false);
						btnAbgabe3.setVisible(false);
						btnAbgabe4.setVisible(false);
						btnAbgabe5.setVisible(false);
						btnAbgabe6.setVisible(false);
						btnAbgabe7.setVisible(false);
						btnAbgabe8.setVisible(false);
						btnAbgabe9.setVisible(false);
						btnAbgabe10.setVisible(false);
						btnAbgabe11.setVisible(false);
						btnAbgabe12.setVisible(false);
						btnAbgabe13.setVisible(false);
						btnAbgabe14.setVisible(false);
						btnAbgabe15.setVisible(false);
						
						txtFrage.setVisible(true);
						btnAntwort1.setVisible(true);
						btnAntwort2.setVisible(true);
						btnAntwort3.setVisible(true);
						btnAbgabe.setVisible(true);
						txtAntwortNr.setVisible(true);
						txtAntwortNr.setText("Deine Antwort:"+Markiert[6]);
						btnAntwort1.setEnabled(false);	
						btnAntwort2.setEnabled(false);
						btnAntwort3.setEnabled(false);
						btnAntwort1.setBackground(Color.GREEN);
						btnAntwort2.setBackground(Color.RED);
						btnAntwort3.setBackground(Color.RED);
						txtFrage.setText(Fragenspeicher.Frage[Fragen[6]][0]);
						btnAntwort1.setText(Fragenspeicher.Frage[Fragen[6]][1]);
						btnAntwort2.setText(Fragenspeicher.Frage[Fragen[6]][2]);
						btnAntwort3.setText(Fragenspeicher.Frage[Fragen[6]][3]);
						Bild();
						Lang();
					}
				});
				 
				btnAbgabe8.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						btnAbgabe.setBounds(791, 608, 170, 23);
						btnAbgabe.setText("Zurück zur Auswertung");
						txtRichtig.setVisible(false);
						txtFalsch.setVisible(false);
						txtFehlerpunkte.setVisible(false);
						btnAbgabe1.setVisible(false);
						btnAbgabe2.setVisible(false);
						btnAbgabe3.setVisible(false);
						btnAbgabe4.setVisible(false);
						btnAbgabe5.setVisible(false);
						btnAbgabe6.setVisible(false);
						btnAbgabe7.setVisible(false);
						btnAbgabe8.setVisible(false);
						btnAbgabe9.setVisible(false);
						btnAbgabe10.setVisible(false);
						btnAbgabe11.setVisible(false);
						btnAbgabe12.setVisible(false);
						btnAbgabe13.setVisible(false);
						btnAbgabe14.setVisible(false);
						btnAbgabe15.setVisible(false);
						
						txtFrage.setVisible(true);
						btnAntwort1.setVisible(true);
						btnAntwort2.setVisible(true);
						btnAntwort3.setVisible(true);
						btnAbgabe.setVisible(true);
						txtAntwortNr.setVisible(true);
						txtAntwortNr.setText("Deine Antwort:"+Markiert[7]);
						btnAntwort1.setEnabled(false);	
						btnAntwort2.setEnabled(false);
						btnAntwort3.setEnabled(false);
						btnAntwort1.setBackground(Color.GREEN);
						btnAntwort2.setBackground(Color.RED);
						btnAntwort3.setBackground(Color.RED);
						txtFrage.setText(Fragenspeicher.Frage[Fragen[7]][0]);
						btnAntwort1.setText(Fragenspeicher.Frage[Fragen[7]][1]);
						btnAntwort2.setText(Fragenspeicher.Frage[Fragen[7]][2]);
						btnAntwort3.setText(Fragenspeicher.Frage[Fragen[7]][3]);
						Bild();
						Lang();
					}
				});
				 
				btnAbgabe9.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						btnAbgabe.setBounds(791, 608, 170, 23);
						btnAbgabe.setText("Zurück zur Auswertung");
						txtRichtig.setVisible(false);
						txtFalsch.setVisible(false);
						txtFehlerpunkte.setVisible(false);
						btnAbgabe1.setVisible(false);
						btnAbgabe2.setVisible(false);
						btnAbgabe3.setVisible(false);
						btnAbgabe4.setVisible(false);
						btnAbgabe5.setVisible(false);
						btnAbgabe6.setVisible(false);
						btnAbgabe7.setVisible(false);
						btnAbgabe8.setVisible(false);
						btnAbgabe9.setVisible(false);
						btnAbgabe10.setVisible(false);
						btnAbgabe11.setVisible(false);
						btnAbgabe12.setVisible(false);
						btnAbgabe13.setVisible(false);
						btnAbgabe14.setVisible(false);
						btnAbgabe15.setVisible(false);
						
						txtFrage.setVisible(true);
						btnAntwort1.setVisible(true);
						btnAntwort2.setVisible(true);
						btnAntwort3.setVisible(true);
						btnAbgabe.setVisible(true);
						txtAntwortNr.setVisible(true);
						txtAntwortNr.setText("Deine Antwort:"+Markiert[8]);
						btnAntwort1.setEnabled(false);	
						btnAntwort2.setEnabled(false);
						btnAntwort3.setEnabled(false);
						btnAntwort1.setBackground(Color.GREEN);
						btnAntwort2.setBackground(Color.RED);
						btnAntwort3.setBackground(Color.RED);
						txtFrage.setText(Fragenspeicher.Frage[Fragen[8]][0]);
						btnAntwort1.setText(Fragenspeicher.Frage[Fragen[8]][1]);
						btnAntwort2.setText(Fragenspeicher.Frage[Fragen[8]][2]);
						btnAntwort3.setText(Fragenspeicher.Frage[Fragen[8]][3]);
						Bild();
						Lang();
					}
				});
				 
				btnAbgabe10.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						btnAbgabe.setBounds(791, 608, 170, 23);
						btnAbgabe.setText("Zurück zur Auswertung");
						txtRichtig.setVisible(false);
						txtFalsch.setVisible(false);
						txtFehlerpunkte.setVisible(false);
						btnAbgabe1.setVisible(false);
						btnAbgabe2.setVisible(false);
						btnAbgabe3.setVisible(false);
						btnAbgabe4.setVisible(false);
						btnAbgabe5.setVisible(false);
						btnAbgabe6.setVisible(false);
						btnAbgabe7.setVisible(false);
						btnAbgabe8.setVisible(false);
						btnAbgabe9.setVisible(false);
						btnAbgabe10.setVisible(false);
						btnAbgabe11.setVisible(false);
						btnAbgabe12.setVisible(false);
						btnAbgabe13.setVisible(false);
						btnAbgabe14.setVisible(false);
						btnAbgabe15.setVisible(false);
						
						txtFrage.setVisible(true);
						btnAntwort1.setVisible(true);
						btnAntwort2.setVisible(true);
						btnAntwort3.setVisible(true);
						btnAbgabe.setVisible(true);
						txtAntwortNr.setVisible(true);
						txtAntwortNr.setText("Deine Antwort:"+Markiert[9]);
						btnAntwort1.setEnabled(false);	
						btnAntwort2.setEnabled(false);
						btnAntwort3.setEnabled(false);
						btnAntwort1.setBackground(Color.GREEN);
						btnAntwort2.setBackground(Color.RED);
						btnAntwort3.setBackground(Color.RED);
						txtFrage.setText(Fragenspeicher.Frage[Fragen[9]][0]);
						btnAntwort1.setText(Fragenspeicher.Frage[Fragen[9]][1]);
						btnAntwort2.setText(Fragenspeicher.Frage[Fragen[9]][2]);
						btnAntwort3.setText(Fragenspeicher.Frage[Fragen[9]][3]);
						Bild();
						Lang();
					}
				});
				 
				btnAbgabe11.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						btnAbgabe.setBounds(791, 608, 170, 23);
						btnAbgabe.setText("Zurück zur Auswertung");
						txtRichtig.setVisible(false);
						txtFalsch.setVisible(false);
						txtFehlerpunkte.setVisible(false);
						btnAbgabe1.setVisible(false);
						btnAbgabe2.setVisible(false);
						btnAbgabe3.setVisible(false);
						btnAbgabe4.setVisible(false);
						btnAbgabe5.setVisible(false);
						btnAbgabe6.setVisible(false);
						btnAbgabe7.setVisible(false);
						btnAbgabe8.setVisible(false);
						btnAbgabe9.setVisible(false);
						btnAbgabe10.setVisible(false);
						btnAbgabe11.setVisible(false);
						btnAbgabe12.setVisible(false);
						btnAbgabe13.setVisible(false);
						btnAbgabe14.setVisible(false);
						btnAbgabe15.setVisible(false);
						
						txtFrage.setVisible(true);
						btnAntwort1.setVisible(true);
						btnAntwort2.setVisible(true);
						btnAntwort3.setVisible(true);
						btnAbgabe.setVisible(true);
						txtAntwortNr.setVisible(true);
						txtAntwortNr.setText("Deine Antwort:"+Markiert[10]);
						btnAntwort1.setEnabled(false);	
						btnAntwort2.setEnabled(false);
						btnAntwort3.setEnabled(false);
						btnAntwort1.setBackground(Color.GREEN);
						btnAntwort2.setBackground(Color.RED);
						btnAntwort3.setBackground(Color.RED);
						txtFrage.setText(Fragenspeicher.Frage[Fragen[10]][0]);
						btnAntwort1.setText(Fragenspeicher.Frage[Fragen[10]][1]);
						btnAntwort2.setText(Fragenspeicher.Frage[Fragen[10]][2]);
						btnAntwort3.setText(Fragenspeicher.Frage[Fragen[10]][3]);
						Bild();
						Lang();
					}
				});
				 
				btnAbgabe12.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						btnAbgabe.setBounds(791, 608, 170, 23);
						btnAbgabe.setText("Zurück zur Auswertung");
						txtRichtig.setVisible(false);
						txtFalsch.setVisible(false);
						txtFehlerpunkte.setVisible(false);
						btnAbgabe1.setVisible(false);
						btnAbgabe2.setVisible(false);
						btnAbgabe3.setVisible(false);
						btnAbgabe4.setVisible(false);
						btnAbgabe5.setVisible(false);
						btnAbgabe6.setVisible(false);
						btnAbgabe7.setVisible(false);
						btnAbgabe8.setVisible(false);
						btnAbgabe9.setVisible(false);
						btnAbgabe10.setVisible(false);
						btnAbgabe11.setVisible(false);
						btnAbgabe12.setVisible(false);
						btnAbgabe13.setVisible(false);
						btnAbgabe14.setVisible(false);
						btnAbgabe15.setVisible(false);
						
						txtFrage.setVisible(true);
						btnAntwort1.setVisible(true);
						btnAntwort2.setVisible(true);
						btnAntwort3.setVisible(true);
						btnAbgabe.setVisible(true);
						txtAntwortNr.setVisible(true);
						txtAntwortNr.setText("Deine Antwort:"+Markiert[11]);
						btnAntwort1.setEnabled(false);	
						btnAntwort2.setEnabled(false);
						btnAntwort3.setEnabled(false);
						btnAntwort1.setBackground(Color.GREEN);
						btnAntwort2.setBackground(Color.RED);
						btnAntwort3.setBackground(Color.RED);
						txtFrage.setText(Fragenspeicher.Frage[Fragen[11]][0]);
						btnAntwort1.setText(Fragenspeicher.Frage[Fragen[11]][1]);
						btnAntwort2.setText(Fragenspeicher.Frage[Fragen[11]][2]);
						btnAntwort3.setText(Fragenspeicher.Frage[Fragen[11]][3]);
						Bild();
						Lang();
					}
				});
				 
				btnAbgabe13.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						btnAbgabe.setBounds(791, 608, 170, 23);
						btnAbgabe.setText("Zurück zur Auswertung");
						txtRichtig.setVisible(false);
						txtFalsch.setVisible(false);
						txtFehlerpunkte.setVisible(false);
						btnAbgabe1.setVisible(false);
						btnAbgabe2.setVisible(false);
						btnAbgabe3.setVisible(false);
						btnAbgabe4.setVisible(false);
						btnAbgabe5.setVisible(false);
						btnAbgabe6.setVisible(false);
						btnAbgabe7.setVisible(false);
						btnAbgabe8.setVisible(false);
						btnAbgabe9.setVisible(false);
						btnAbgabe10.setVisible(false);
						btnAbgabe11.setVisible(false);
						btnAbgabe12.setVisible(false);
						btnAbgabe13.setVisible(false);
						btnAbgabe14.setVisible(false);
						btnAbgabe15.setVisible(false);
						
						txtFrage.setVisible(true);
						btnAntwort1.setVisible(true);
						btnAntwort2.setVisible(true);
						btnAntwort3.setVisible(true);
						btnAbgabe.setVisible(true);
						txtAntwortNr.setVisible(true);
						txtAntwortNr.setText("Deine Antwort:"+Markiert[12]);
						btnAntwort1.setEnabled(false);	
						btnAntwort2.setEnabled(false);
						btnAntwort3.setEnabled(false);
						btnAntwort1.setBackground(Color.GREEN);
						btnAntwort2.setBackground(Color.RED);
						btnAntwort3.setBackground(Color.RED);
						txtFrage.setText(Fragenspeicher.Frage[Fragen[12]][0]);
						btnAntwort1.setText(Fragenspeicher.Frage[Fragen[12]][1]);
						btnAntwort2.setText(Fragenspeicher.Frage[Fragen[12]][2]);
						btnAntwort3.setText(Fragenspeicher.Frage[Fragen[12]][3]);
						Bild();
						Lang();
					}
				});
				 
				btnAbgabe14.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						btnAbgabe.setBounds(791, 608, 170, 23);
						btnAbgabe.setText("Zurück zur Auswertung");
						txtRichtig.setVisible(false);
						txtFalsch.setVisible(false);
						txtFehlerpunkte.setVisible(false);
						btnAbgabe1.setVisible(false);
						btnAbgabe2.setVisible(false);
						btnAbgabe3.setVisible(false);
						btnAbgabe4.setVisible(false);
						btnAbgabe5.setVisible(false);
						btnAbgabe6.setVisible(false);
						btnAbgabe7.setVisible(false);
						btnAbgabe8.setVisible(false);
						btnAbgabe9.setVisible(false);
						btnAbgabe10.setVisible(false);
						btnAbgabe11.setVisible(false);
						btnAbgabe12.setVisible(false);
						btnAbgabe13.setVisible(false);
						btnAbgabe14.setVisible(false);
						btnAbgabe15.setVisible(false);
						
						txtFrage.setVisible(true);
						btnAntwort1.setVisible(true);
						btnAntwort2.setVisible(true);
						btnAntwort3.setVisible(true);
						btnAbgabe.setVisible(true);
						txtAntwortNr.setVisible(true);
						txtAntwortNr.setText("Deine Antwort:"+Markiert[13]);
						btnAntwort1.setEnabled(false);	
						btnAntwort2.setEnabled(false);
						btnAntwort3.setEnabled(false);
						btnAntwort1.setBackground(Color.GREEN);
						btnAntwort2.setBackground(Color.RED);
						btnAntwort3.setBackground(Color.RED);
						txtFrage.setText(Fragenspeicher.Frage[Fragen[13]][0]);
						btnAntwort1.setText(Fragenspeicher.Frage[Fragen[13]][1]);
						btnAntwort2.setText(Fragenspeicher.Frage[Fragen[13]][2]);
						btnAntwort3.setText(Fragenspeicher.Frage[Fragen[13]][3]);
						Bild();
						Lang();
					}
				});
				 
				btnAbgabe15.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						btnAbgabe.setBounds(791, 608, 170, 23);
						btnAbgabe.setText("Zurück zur Auswertung");
						txtRichtig.setVisible(false);
						txtFalsch.setVisible(false);
						txtFehlerpunkte.setVisible(false);
						btnAbgabe1.setVisible(false);
						btnAbgabe2.setVisible(false);
						btnAbgabe3.setVisible(false);
						btnAbgabe4.setVisible(false);
						btnAbgabe5.setVisible(false);
						btnAbgabe6.setVisible(false);
						btnAbgabe7.setVisible(false);
						btnAbgabe8.setVisible(false);
						btnAbgabe9.setVisible(false);
						btnAbgabe10.setVisible(false);
						btnAbgabe11.setVisible(false);
						btnAbgabe12.setVisible(false);
						btnAbgabe13.setVisible(false);
						btnAbgabe14.setVisible(false);
						btnAbgabe15.setVisible(false);
						
						txtFrage.setVisible(true);
						btnAntwort1.setVisible(true);
						btnAntwort2.setVisible(true);
						btnAntwort3.setVisible(true);
						btnAbgabe.setVisible(true);
						txtAntwortNr.setVisible(true);
						txtAntwortNr.setText("Deine Antwort:"+Markiert[14]);
						btnAntwort1.setEnabled(false);	
						btnAntwort2.setEnabled(false);
						btnAntwort3.setEnabled(false);
						btnAntwort1.setBackground(Color.GREEN);
						btnAntwort2.setBackground(Color.RED);
						btnAntwort3.setBackground(Color.RED);
						txtFrage.setText(Fragenspeicher.Frage[Fragen[14]][0]);
						btnAntwort1.setText(Fragenspeicher.Frage[Fragen[14]][1]);
						btnAntwort2.setText(Fragenspeicher.Frage[Fragen[14]][2]);
						btnAntwort3.setText(Fragenspeicher.Frage[Fragen[14]][3]);
						Bild();
						Lang();
					}
				});
				
			
	 }
	 
	 static void Richtig() {
		 RichtigAntwort=0;
		 for(int t=0;t<Fragenspeicher.Frage.length;t++) {
			 if(Richtig[t]==true) {
				 RichtigAntwort++;
			 }
		 }
		 if(RichtigAntwort==Fragenspeicher.Frage.length) {
			 Object[] arg0 = null;
				 JOptionPane.showOptionDialog(null, "Du hast alle Fragen im Fragenkatalog richtig beantwortet!\nWenn du den Fragenkatalog erneut durcharbeiten willst kannst du ihn in den Einstellungen zurücksetzten. ",
		                null, JOptionPane.YES_NO_CANCEL_OPTION,
		                JOptionPane.WARNING_MESSAGE, null, 
		                new String[]{"Okay"}, arg0);

			 
			 
		 }
	 }
	 
	 static void Statistik() {
		btnLogo.setVisible(false);
		btnStatistik.setVisible(false);
		btnEinstellungen.setVisible(false);
		btnWettkampf.setVisible(false);
		btnFragenkatalog.setVisible(false);
		btnStaKatVor.setVisible(true);
		btnStaKatZurueck.setVisible(true);
		Aufruf();
		txtBeantwortet.setVisible(false);
		btnZuMenue.setVisible(true);
		txtStaFragenkatalog.setVisible(true);
		txtStaRichtig.setVisible(true);
		txtStaFalsch.setVisible(true);
		txtStaUnbeantwortet.setVisible(true);
		double StaR=0;
		double StaF=0;
		double StaU=0;
		double h=197;
		if(jung==true) {
			h=96;
		}else {
			h=197;
		}
		for(int g=0;g<h;g++) {
			if(Richtig[g]==true) {
				StaR++;
				}
			if(Falsch[g]==true) {
				StaF++;
			}
			}
		StaU=h-StaR-StaF;
		int StaRint= (int) StaR; 
		int StaFint= (int) StaF;
		int StaUint= (int) StaU;
		int hint= (int) h;
		txtStaRichtig.setText("Richtig "+StaRint+"/"+hint);
		txtStaFalsch.setText("Falsch "+StaFint+"/"+hint);
		txtStaUnbeantwortet.setText("Unbeantwortet "+StaUint+"/"+hint); 
		int BoundsR=(int) (StaR/h*1000);
		int BoundsF=(int) (StaF/h*1000);
		int BoundsU=(int) (StaU/h*1000);
		txtStaRichtig.setBounds(100, 120, BoundsR, 20);
		txtStaFalsch.setBounds(100+BoundsR, 120, BoundsF, 20);
		txtStaUnbeantwortet.setBounds(100+BoundsR+BoundsF, 120, BoundsU, 20);
		
		txtStaKatFragenkatalog.setVisible(true);
		txtStaKatRichtig.setVisible(true);
		txtStaKatFalsch.setVisible(true);
		txtStaKatUnbeantwortet.setVisible(true);
		
	
		txtStaKatFragenkatalog.setText("Kategorie: Gerätekunde");
		txtStaKatFragenkatalog.setBounds(473, 185, 254, 31);
		double StaKatR=0;
		double StaKatF=0;
		double StaKatU=0;
		double u=0;
		if(jung==true) {
			u=20;
		}else {
			u=42;
		}
		for(int g=0;g<u;g++) {
			if(Richtig[g]==true) {
				StaKatR++;
				}
			if(Falsch[g]==true) {
				StaKatF++;
			}
		}
		StaKatU=u-StaKatR-StaKatF;
		int StaKatRint= (int) StaKatR; 
		int StaKatFint= (int) StaKatF;
		int StaKatUint= (int) StaKatU;
		int uint= (int) u;
		txtStaKatRichtig.setText("Richtig "+StaKatRint+"/"+uint);
		txtStaKatFalsch.setText("Falsch "+StaKatFint+"/"+uint);
		txtStaKatUnbeantwortet.setText("Unbeantwortet "+StaKatUint+"/"+uint); 
		int BoundsKatR=(int) (StaKatR/u*1000);
		int BoundsKatF=(int) (StaKatF/u*1000);
		int BoundsKatU=(int) (StaKatU/u*1000);
		txtStaKatRichtig.setBounds(100, 220, BoundsKatR, 20);
		txtStaKatFalsch.setBounds(100+BoundsKatR, 220, BoundsKatF, 20);
		txtStaKatUnbeantwortet.setBounds(100+BoundsKatR+BoundsKatF, 220, BoundsKatU, 20);
		
	 }
	
	static void StaKatVor() {
		

		StaKat++;
		if(StaKat==9) {
			StaKat=8;
		}
		if(StaKat==1) {
			txtStaKatFragenkatalog.setText("Kategorie: Brennen");
			txtStaKatFragenkatalog.setBounds(500, 185, 200, 31);
			double StaKatR=0;
			double StaKatF=0;
			double StaKatU=0;
			double u=0;
			double u2=0;
			if(jung==true) {
				u=62;
				u2=19;
			}else {
				u=79;
				u2=36;
			}
			for(int g=42;g<u;g++) {
				if(Richtig[g]==true) {
					StaKatR++;
					}
				if(Falsch[g]==true) {
					StaKatF++;
				}
			}
			StaKatU=u2-StaKatR-StaKatF;
			int StaKatRint= (int) StaKatR; 
			int StaKatFint= (int) StaKatF;
			int StaKatUint= (int) StaKatU;
			int uint= (int) u2;
			txtStaKatRichtig.setText("Richtig "+StaKatRint+"/"+uint);
			txtStaKatFalsch.setText("Falsch "+StaKatFint+"/"+uint);
			txtStaKatUnbeantwortet.setText("Unbeantwortet "+StaKatUint+"/"+uint); 
			int BoundsKatR=(int) (StaKatR/u2*1000);
			int BoundsKatF=(int) (StaKatF/u2*1000);
			int BoundsKatU=(int) (StaKatU/u2*1000);
			txtStaKatRichtig.setBounds(100, 220, BoundsKatR, 20);
			txtStaKatFalsch.setBounds(100+BoundsKatR, 220, BoundsKatF, 20);
			txtStaKatUnbeantwortet.setBounds(100+BoundsKatR+BoundsKatF, 220, BoundsKatU, 20);
			
		}
		if(StaKat==2) {
			txtStaKatFragenkatalog.setText("Kategorie: Löscheinsatz");
			txtStaKatFragenkatalog.setBounds(476, 185, 248, 31);
			double StaKatR=0;
			double StaKatF=0;
			double StaKatU=0;
			double u=0;
			double u2=0;
			if(jung==true) {
				u=127;
				u2=6;
			}else {
				u=135;
				u2=14;
			}
			for(int g=121;g<u;g++) {
				if(Richtig[g]==true) {
					StaKatR++;
					}
				if(Falsch[g]==true) {
					StaKatF++;
				}
			}
			StaKatU=u2-StaKatR-StaKatF;
			int StaKatRint= (int) StaKatR; 
			int StaKatFint= (int) StaKatF;
			int StaKatUint= (int) StaKatU;
			int uint= (int) u2;
			txtStaKatRichtig.setText("Richtig "+StaKatRint+"/"+uint);
			txtStaKatFalsch.setText("Falsch "+StaKatFint+"/"+uint);
			txtStaKatUnbeantwortet.setText("Unbeantwortet "+StaKatUint+"/"+uint); 
			int BoundsKatR=(int) (StaKatR/u2*1000);
			int BoundsKatF=(int) (StaKatF/u2*1000);
			int BoundsKatU=(int) (StaKatU/u2*1000);
			txtStaKatRichtig.setBounds(100, 220, BoundsKatR, 20);
			txtStaKatFalsch.setBounds(100+BoundsKatR, 220, BoundsKatF, 20);
			txtStaKatUnbeantwortet.setBounds(100+BoundsKatR+BoundsKatF, 220, BoundsKatU, 20);
			
		}
		if(StaKat==3) {
			txtStaKatFragenkatalog.setText("Kategorie: Lebensrettende Sofortmaßnahmen (Erste Hilfe)");
			txtStaKatFragenkatalog.setBounds(302, 185, 596, 31);
			double StaKatR=0;
			double StaKatF=0;
			double StaKatU=0;
			double u=0;
			double u2=0;
			if(jung==true) {
				u=95;
				u2=16;
			}else {
				u=121;
				u2=42;
			}
			for(int g=79;g<u;g++) {
				if(Richtig[g]==true) {
					StaKatR++;
					}
				if(Falsch[g]==true) {
					StaKatF++;
				}
			}
			StaKatU=u2-StaKatR-StaKatF;
			int StaKatRint= (int) StaKatR; 
			int StaKatFint= (int) StaKatF;
			int StaKatUint= (int) StaKatU;
			int uint= (int) u2;
			txtStaKatRichtig.setText("Richtig "+StaKatRint+"/"+uint);
			txtStaKatFalsch.setText("Falsch "+StaKatFint+"/"+uint);
			txtStaKatUnbeantwortet.setText("Unbeantwortet "+StaKatUint+"/"+uint); 
			int BoundsKatR=(int) (StaKatR/u2*1000);
			int BoundsKatF=(int) (StaKatF/u2*1000);
			int BoundsKatU=(int) (StaKatU/u2*1000);
			txtStaKatRichtig.setBounds(100, 220, BoundsKatR, 20);
			txtStaKatFalsch.setBounds(100+BoundsKatR, 220, BoundsKatF, 20);
			txtStaKatUnbeantwortet.setBounds(100+BoundsKatR+BoundsKatF, 220, BoundsKatU, 20);
			
		}
		if(StaKat==4) {
			txtStaKatFragenkatalog.setText("Kategorie: Löschen");
			txtStaKatFragenkatalog.setBounds(500, 185, 200, 31);
			double StaKatR=0;
			double StaKatF=0;
			double StaKatU=0;
			double u=0;
			double u2=0;
			if(jung==true) {
				u=142;
				u2=7;
			}else {
				u=154;
				u2=19;
			}
			for(int g=135;g<u;g++) {
				if(Richtig[g]==true) {
					StaKatR++;
					}
				if(Falsch[g]==true) {
					StaKatF++;
				}
			}
			StaKatU=u2-StaKatR-StaKatF;
			int StaKatRint= (int) StaKatR; 
			int StaKatFint= (int) StaKatF;
			int StaKatUint= (int) StaKatU;
			int uint= (int) u2;
			txtStaKatRichtig.setText("Richtig "+StaKatRint+"/"+uint);
			txtStaKatFalsch.setText("Falsch "+StaKatFint+"/"+uint);
			txtStaKatUnbeantwortet.setText("Unbeantwortet "+StaKatUint+"/"+uint); 
			int BoundsKatR=(int) (StaKatR/u2*1000);
			int BoundsKatF=(int) (StaKatF/u2*1000);
			int BoundsKatU=(int) (StaKatU/u2*1000);
			txtStaKatRichtig.setBounds(100, 220, BoundsKatR, 20);
			txtStaKatFalsch.setBounds(100+BoundsKatR, 220, BoundsKatF, 20);
			txtStaKatUnbeantwortet.setBounds(100+BoundsKatR+BoundsKatF, 220, BoundsKatU, 20);	
		}
		if(StaKat==5) {
			txtStaKatFragenkatalog.setText("Kategorie: Technische Hilfeleistung");
			txtStaKatFragenkatalog.setBounds(417, 185, 366, 31);
			double StaKatR=0;
			double StaKatF=0;
			double StaKatU=0;
			double u=0;
			double u2=0;
			if(jung==true) {
				u=157;
				u2=3;
			}else {
				u=160;
				u2=6;
			}
			for(int g=145;g<u;g++) {
				if(Richtig[g]==true) {
					StaKatR++;
					}
				if(Falsch[g]==true) {
					StaKatF++;
				}
			}
			StaKatU=u2-StaKatR-StaKatF;
			int StaKatRint= (int) StaKatR; 
			int StaKatFint= (int) StaKatF;
			int StaKatUint= (int) StaKatU;
			int uint= (int) u2;
			txtStaKatRichtig.setText("Richtig "+StaKatRint+"/"+uint);
			txtStaKatFalsch.setText("Falsch "+StaKatFint+"/"+uint);
			txtStaKatUnbeantwortet.setText("Unbeantwortet "+StaKatUint+"/"+uint); 
			int BoundsKatR=(int) (StaKatR/u2*1000);
			int BoundsKatF=(int) (StaKatF/u2*1000);
			int BoundsKatU=(int) (StaKatU/u2*1000);
			txtStaKatRichtig.setBounds(100, 220, BoundsKatR, 20);
			txtStaKatFalsch.setBounds(100+BoundsKatR, 220, BoundsKatF, 20);
			txtStaKatUnbeantwortet.setBounds(100+BoundsKatR+BoundsKatF, 220, BoundsKatU, 20);
		}
		if(StaKat==6) {
			txtStaKatFragenkatalog.setText("Kategorie: Unfallverhütungsvorschriften / Unfallversicherung");
			txtStaKatFragenkatalog.setBounds(285, 185, 630, 31);
			double StaKatR=0;
			double StaKatF=0;
			double StaKatU=0;
			double u=0;
			double u2=0;
			if(jung==true) {
				u=167;
				u2=9;
			}else {
				u=172;
				u2=12;
			}
			for(int g=160;g<u;g++) {
				if(Richtig[g]==true) {
					StaKatR++;
					}
				if(Falsch[g]==true) {
					StaKatF++;
				}
			}
			StaKatU=u2-StaKatR-StaKatF;
			int StaKatRint= (int) StaKatR; 
			int StaKatFint= (int) StaKatF;
			int StaKatUint= (int) StaKatU;
			int uint= (int) u2;
			txtStaKatRichtig.setText("Richtig "+StaKatRint+"/"+uint);
			txtStaKatFalsch.setText("Falsch "+StaKatFint+"/"+uint);
			txtStaKatUnbeantwortet.setText("Unbeantwortet "+StaKatUint+"/"+uint); 
			int BoundsKatR=(int) (StaKatR/u2*1000);
			int BoundsKatF=(int) (StaKatF/u2*1000);
			int BoundsKatU=(int) (StaKatU/u2*1000);
			txtStaKatRichtig.setBounds(100, 220, BoundsKatR, 20);
			txtStaKatFalsch.setBounds(100+BoundsKatR, 220, BoundsKatF, 20);
			txtStaKatUnbeantwortet.setBounds(100+BoundsKatR+BoundsKatF, 220, BoundsKatU, 20);
		}
		if(StaKat==7) {
			txtStaKatFragenkatalog.setText("Kategorie: Rechtsgrundlagen");
			txtStaKatFragenkatalog.setBounds(447, 185, 306, 31);
			double StaKatR=0;
			double StaKatF=0;
			double StaKatU=0;
			double u=0;
			double u2=0;
			if(jung==true) {
				u=175;
				u2=3;
			}else {
				u=178;
				u2=6;
			}
			for(int g=172;g<u;g++) {
				if(Richtig[g]==true) {
					StaKatR++;
					}
				if(Falsch[g]==true) {
					StaKatF++;
				}
			}
			StaKatU=u2-StaKatR-StaKatF;
			int StaKatRint= (int) StaKatR; 
			int StaKatFint= (int) StaKatF;
			int StaKatUint= (int) StaKatU;
			int uint= (int) u2;
			txtStaKatRichtig.setText("Richtig "+StaKatRint+"/"+uint);
			txtStaKatFalsch.setText("Falsch "+StaKatFint+"/"+uint);
			txtStaKatUnbeantwortet.setText("Unbeantwortet "+StaKatUint+"/"+uint); 
			int BoundsKatR=(int) (StaKatR/u2*1000);
			int BoundsKatF=(int) (StaKatF/u2*1000);
			int BoundsKatU=(int) (StaKatU/u2*1000);
			txtStaKatRichtig.setBounds(100, 220, BoundsKatR, 20);
			txtStaKatFalsch.setBounds(100+BoundsKatR, 220, BoundsKatF, 20);
			txtStaKatUnbeantwortet.setBounds(100+BoundsKatR+BoundsKatF, 220, BoundsKatU, 20);
		}
		if(StaKat==8) {
			txtStaKatFragenkatalog.setText("Kategorie: Organisation");
			txtStaKatFragenkatalog.setBounds(476, 185, 248, 31);
			double StaKatR=0;
			double StaKatF=0;
			double StaKatU=0;
			double u=0;
			double u2=0;
			if(jung==true) {
				u=190;
				u2=12;
			}else {
				u=197;
				u2=19;
			}
			for(int g=178;g<u;g++) {
				if(Richtig[g]==true) {
					StaKatR++;
					}
				if(Falsch[g]==true) {
					StaKatF++;
				}
			}
			StaKatU=u2-StaKatR-StaKatF;
			int StaKatRint= (int) StaKatR; 
			int StaKatFint= (int) StaKatF;
			int StaKatUint= (int) StaKatU;
			int uint= (int) u2;
			txtStaKatRichtig.setText("Richtig "+StaKatRint+"/"+uint);
			txtStaKatFalsch.setText("Falsch "+StaKatFint+"/"+uint);
			txtStaKatUnbeantwortet.setText("Unbeantwortet "+StaKatUint+"/"+uint); 
			int BoundsKatR=(int) (StaKatR/u2*1000);
			int BoundsKatF=(int) (StaKatF/u2*1000);
			int BoundsKatU=(int) (StaKatU/u2*1000);
			txtStaKatRichtig.setBounds(100, 220, BoundsKatR, 20);
			txtStaKatFalsch.setBounds(100+BoundsKatR, 220, BoundsKatF, 20);
			txtStaKatUnbeantwortet.setBounds(100+BoundsKatR+BoundsKatF, 220, BoundsKatU, 20);
		}
		
	
		
	 	
	}
	
	static void StaKatZurueck() {

		StaKat--;
		if(StaKat<0) {
			StaKat=0;
		}
		if(StaKat==0) {
			txtStaKatFragenkatalog.setText("Kategorie: Gerätekunde");
			txtStaKatFragenkatalog.setBounds(473, 185, 254, 31);
			double StaKatR=0;
			double StaKatF=0;
			double StaKatU=0;
			double u=0;
			double u2=0;
			if(jung==true) {
				u=20;
			}else {
				u=42;
			}
			for(int g=0;g<u;g++) {
				if(Richtig[g]==true) {
					StaKatR++;
					}
				if(Falsch[g]==true) {
					StaKatF++;
				}
			}
			StaKatU=u-StaKatR-StaKatF;
			int StaKatRint= (int) StaKatR; 
			int StaKatFint= (int) StaKatF;
			int StaKatUint= (int) StaKatU;
			int uint= (int) u;
			txtStaKatRichtig.setText("Richtig "+StaKatRint+"/"+uint);
			txtStaKatFalsch.setText("Falsch "+StaKatFint+"/"+uint);
			txtStaKatUnbeantwortet.setText("Unbeantwortet "+StaKatUint+"/"+uint); 
			int BoundsKatR=(int) (StaKatR/u*1000);
			int BoundsKatF=(int) (StaKatF/u*1000);
			int BoundsKatU=(int) (StaKatU/u*1000);
			txtStaKatRichtig.setBounds(100, 220, BoundsKatR, 20);
			txtStaKatFalsch.setBounds(100+BoundsKatR, 220, BoundsKatF, 20);
			txtStaKatUnbeantwortet.setBounds(100+BoundsKatR+BoundsKatF, 220, BoundsKatU, 20);
		}
		if(StaKat==1) {
			txtStaKatFragenkatalog.setText("Kategorie: Brennen");
			txtStaKatFragenkatalog.setBounds(500, 185, 200, 31);
			double StaKatR=0;
			double StaKatF=0;
			double StaKatU=0;
			double u=0;
			double u2=0;
			if(jung==true) {
				u=62;
				u2=19;
			}else {
				u=79;
				u2=36;
			}
			for(int g=42;g<u;g++) {
				if(Richtig[g]==true) {
					StaKatR++;
					}
				if(Falsch[g]==true) {
					StaKatF++;
				}
			}
			StaKatU=u2-StaKatR-StaKatF;
			int StaKatRint= (int) StaKatR; 
			int StaKatFint= (int) StaKatF;
			int StaKatUint= (int) StaKatU;
			int uint= (int) u2;
			txtStaKatRichtig.setText("Richtig "+StaKatRint+"/"+uint);
			txtStaKatFalsch.setText("Falsch "+StaKatFint+"/"+uint);
			txtStaKatUnbeantwortet.setText("Unbeantwortet "+StaKatUint+"/"+uint); 
			int BoundsKatR=(int) (StaKatR/u2*1000);
			int BoundsKatF=(int) (StaKatF/u2*1000);
			int BoundsKatU=(int) (StaKatU/u2*1000);
			txtStaKatRichtig.setBounds(100, 220, BoundsKatR, 20);
			txtStaKatFalsch.setBounds(100+BoundsKatR, 220, BoundsKatF, 20);
			txtStaKatUnbeantwortet.setBounds(100+BoundsKatR+BoundsKatF, 220, BoundsKatU, 20);
		
		}
		if(StaKat==2) {
			txtStaKatFragenkatalog.setText("Kategorie: Löscheinsatz");
			txtStaKatFragenkatalog.setBounds(476, 185, 248, 31);
			double StaKatR=0;
			double StaKatF=0;
			double StaKatU=0;
			double u=0;
			double u2=0;
			if(jung==true) {
				u=127;
				u2=6;
			}else {
				u=135;
				u2=14;
			}
			for(int g=121;g<u;g++) {
				if(Richtig[g]==true) {
					StaKatR++;
					}
				if(Falsch[g]==true) {
					StaKatF++;
				}
			}
			StaKatU=u2-StaKatR-StaKatF;
			int StaKatRint= (int) StaKatR; 
			int StaKatFint= (int) StaKatF;
			int StaKatUint= (int) StaKatU;
			int uint= (int) u2;
			txtStaKatRichtig.setText("Richtig "+StaKatRint+"/"+uint);
			txtStaKatFalsch.setText("Falsch "+StaKatFint+"/"+uint);
			txtStaKatUnbeantwortet.setText("Unbeantwortet "+StaKatUint+"/"+uint); 
			int BoundsKatR=(int) (StaKatR/u2*1000);
			int BoundsKatF=(int) (StaKatF/u2*1000);
			int BoundsKatU=(int) (StaKatU/u2*1000);
			txtStaKatRichtig.setBounds(100, 220, BoundsKatR, 20);
			txtStaKatFalsch.setBounds(100+BoundsKatR, 220, BoundsKatF, 20);
			txtStaKatUnbeantwortet.setBounds(100+BoundsKatR+BoundsKatF, 220, BoundsKatU, 20);
			
		}
		if(StaKat==3) {
			txtStaKatFragenkatalog.setText("Kategorie: Lebensrettende Sofortmaßnahmen (Erste Hilfe)");
			txtStaKatFragenkatalog.setBounds(302, 185, 596, 31);
			double StaKatR=0;
			double StaKatF=0;
			double StaKatU=0;
			double u=0;
			double u2=0;
			if(jung==true) {
				u=95;
				u2=16;
			}else {
				u=121;
				u2=42;
			}
			for(int g=79;g<u;g++) {
				if(Richtig[g]==true) {
					StaKatR++;
					}
				if(Falsch[g]==true) {
					StaKatF++;
				}
			}
			StaKatU=u2-StaKatR-StaKatF;
			int StaKatRint= (int) StaKatR; 
			int StaKatFint= (int) StaKatF;
			int StaKatUint= (int) StaKatU;
			int uint= (int) u2;
			txtStaKatRichtig.setText("Richtig "+StaKatRint+"/"+uint);
			txtStaKatFalsch.setText("Falsch "+StaKatFint+"/"+uint);
			txtStaKatUnbeantwortet.setText("Unbeantwortet "+StaKatUint+"/"+uint); 
			int BoundsKatR=(int) (StaKatR/u2*1000);
			int BoundsKatF=(int) (StaKatF/u2*1000);
			int BoundsKatU=(int) (StaKatU/u2*1000);
			txtStaKatRichtig.setBounds(100, 220, BoundsKatR, 20);
			txtStaKatFalsch.setBounds(100+BoundsKatR, 220, BoundsKatF, 20);
			txtStaKatUnbeantwortet.setBounds(100+BoundsKatR+BoundsKatF, 220, BoundsKatU, 20);
			
		}
		if(StaKat==4) {
			txtStaKatFragenkatalog.setText("Kategorie: Löschen");
			txtStaKatFragenkatalog.setBounds(500, 185, 200, 31);
			double StaKatR=0;
			double StaKatF=0;
			double StaKatU=0;
			double u=0;
			double u2=0;
			if(jung==true) {
				u=142;
				u2=7;
			}else {
				u=154;
				u2=19;
			}
			for(int g=135;g<u;g++) {
				if(Richtig[g]==true) {
					StaKatR++;
					}
				if(Falsch[g]==true) {
					StaKatF++;
				}
			}
			StaKatU=u2-StaKatR-StaKatF;
			int StaKatRint= (int) StaKatR; 
			int StaKatFint= (int) StaKatF;
			int StaKatUint= (int) StaKatU;
			int uint= (int) u2;
			txtStaKatRichtig.setText("Richtig "+StaKatRint+"/"+uint);
			txtStaKatFalsch.setText("Falsch "+StaKatFint+"/"+uint);
			txtStaKatUnbeantwortet.setText("Unbeantwortet "+StaKatUint+"/"+uint); 
			int BoundsKatR=(int) (StaKatR/u2*1000);
			int BoundsKatF=(int) (StaKatF/u2*1000);
			int BoundsKatU=(int) (StaKatU/u2*1000);
			txtStaKatRichtig.setBounds(100, 220, BoundsKatR, 20);
			txtStaKatFalsch.setBounds(100+BoundsKatR, 220, BoundsKatF, 20);
			txtStaKatUnbeantwortet.setBounds(100+BoundsKatR+BoundsKatF, 220, BoundsKatU, 20);	
		}
		if(StaKat==5) {
			txtStaKatFragenkatalog.setText("Kategorie: Technische Hilfeleistung");
			txtStaKatFragenkatalog.setBounds(417, 185, 366, 31);
			double StaKatR=0;
			double StaKatF=0;
			double StaKatU=0;
			double u=0;
			double u2=0;
			if(jung==true) {
				u=157;
				u2=3;
			}else {
				u=160;
				u2=6;
			}
			for(int g=145;g<u;g++) {
				if(Richtig[g]==true) {
					StaKatR++;
					}
				if(Falsch[g]==true) {
					StaKatF++;
				}
			}
			StaKatU=u2-StaKatR-StaKatF;
			int StaKatRint= (int) StaKatR; 
			int StaKatFint= (int) StaKatF;
			int StaKatUint= (int) StaKatU;
			int uint= (int) u2;
			txtStaKatRichtig.setText("Richtig "+StaKatRint+"/"+uint);
			txtStaKatFalsch.setText("Falsch "+StaKatFint+"/"+uint);
			txtStaKatUnbeantwortet.setText("Unbeantwortet "+StaKatUint+"/"+uint); 
			int BoundsKatR=(int) (StaKatR/u2*1000);
			int BoundsKatF=(int) (StaKatF/u2*1000);
			int BoundsKatU=(int) (StaKatU/u2*1000);
			txtStaKatRichtig.setBounds(100, 220, BoundsKatR, 20);
			txtStaKatFalsch.setBounds(100+BoundsKatR, 220, BoundsKatF, 20);
			txtStaKatUnbeantwortet.setBounds(100+BoundsKatR+BoundsKatF, 220, BoundsKatU, 20);
		}
		if(StaKat==6) {
			txtStaKatFragenkatalog.setText("Kategorie: Unfallverhütungsvorschriften / Unfallversicherung");
			txtStaKatFragenkatalog.setBounds(285, 185, 630, 31);
			double StaKatR=0;
			double StaKatF=0;
			double StaKatU=0;
			double u=0;
			double u2=0;
			if(jung==true) {
				u=167;
				u2=9;
			}else {
				u=172;
				u2=12;
			}
			for(int g=160;g<u;g++) {
				if(Richtig[g]==true) {
					StaKatR++;
					}
				if(Falsch[g]==true) {
					StaKatF++;
				}
			}
			StaKatU=u2-StaKatR-StaKatF;
			int StaKatRint= (int) StaKatR; 
			int StaKatFint= (int) StaKatF;
			int StaKatUint= (int) StaKatU;
			int uint= (int) u2;
			txtStaKatRichtig.setText("Richtig "+StaKatRint+"/"+uint);
			txtStaKatFalsch.setText("Falsch "+StaKatFint+"/"+uint);
			txtStaKatUnbeantwortet.setText("Unbeantwortet "+StaKatUint+"/"+uint); 
			int BoundsKatR=(int) (StaKatR/u2*1000);
			int BoundsKatF=(int) (StaKatF/u2*1000);
			int BoundsKatU=(int) (StaKatU/u2*1000);
			txtStaKatRichtig.setBounds(100, 220, BoundsKatR, 20);
			txtStaKatFalsch.setBounds(100+BoundsKatR, 220, BoundsKatF, 20);
			txtStaKatUnbeantwortet.setBounds(100+BoundsKatR+BoundsKatF, 220, BoundsKatU, 20);
		}
		if(StaKat==7) {
			txtStaKatFragenkatalog.setText("Kategorie: Rechtsgrundlagen");
			txtStaKatFragenkatalog.setBounds(447, 185, 306, 31);
			double StaKatR=0;
			double StaKatF=0;
			double StaKatU=0;
			double u=0;
			double u2=0;
			if(jung==true) {
				u=175;
				u2=3;
			}else {
				u=178;
				u2=6;
			}
			for(int g=172;g<u;g++) {
				if(Richtig[g]==true) {
					StaKatR++;
					}
				if(Falsch[g]==true) {
					StaKatF++;
				}
			}
			StaKatU=u2-StaKatR-StaKatF;
			int StaKatRint= (int) StaKatR; 
			int StaKatFint= (int) StaKatF;
			int StaKatUint= (int) StaKatU;
			int uint= (int) u2;
			txtStaKatRichtig.setText("Richtig "+StaKatRint+"/"+uint);
			txtStaKatFalsch.setText("Falsch "+StaKatFint+"/"+uint);
			txtStaKatUnbeantwortet.setText("Unbeantwortet "+StaKatUint+"/"+uint); 
			int BoundsKatR=(int) (StaKatR/u2*1000);
			int BoundsKatF=(int) (StaKatF/u2*1000);
			int BoundsKatU=(int) (StaKatU/u2*1000);
			txtStaKatRichtig.setBounds(100, 220, BoundsKatR, 20);
			txtStaKatFalsch.setBounds(100+BoundsKatR, 220, BoundsKatF, 20);
			txtStaKatUnbeantwortet.setBounds(100+BoundsKatR+BoundsKatF, 220, BoundsKatU, 20);
		}
		if(StaKat==8) {
			txtStaKatFragenkatalog.setText("Kategorie: Organisation");
			txtStaKatFragenkatalog.setBounds(476, 185, 248, 31);
			double StaKatR=0;
			double StaKatF=0;
			double StaKatU=0;
			double u=0;
			double u2=0;
			if(jung==true) {
				u=190;
				u2=12;
			}else {
				u=197;
				u2=19;
			}
			for(int g=178;g<u;g++) {
				if(Richtig[g]==true) {
					StaKatR++;
					}
				if(Falsch[g]==true) {
					StaKatF++;
				}
			}
			StaKatU=u2-StaKatR-StaKatF;
			int StaKatRint= (int) StaKatR; 
			int StaKatFint= (int) StaKatF;
			int StaKatUint= (int) StaKatU;
			int uint= (int) u2;
			txtStaKatRichtig.setText("Richtig "+StaKatRint+"/"+uint);
			txtStaKatFalsch.setText("Falsch "+StaKatFint+"/"+uint);
			txtStaKatUnbeantwortet.setText("Unbeantwortet "+StaKatUint+"/"+uint); 
			int BoundsKatR=(int) (StaKatR/u2*1000);
			int BoundsKatF=(int) (StaKatF/u2*1000);
			int BoundsKatU=(int) (StaKatU/u2*1000);
			txtStaKatRichtig.setBounds(100, 220, BoundsKatR, 20);
			txtStaKatFalsch.setBounds(100+BoundsKatR, 220, BoundsKatF, 20);
			txtStaKatUnbeantwortet.setBounds(100+BoundsKatR+BoundsKatF, 220, BoundsKatU, 20);
		}
		
	
		
	 	
	}
	
			

	 /**
 * Create the application.
 */
public Frage() {
	 	

	initialize();
}

/**
 * Initialize the contents of the frame.
 */
private void initialize() {
	frame.setBounds(100, 100, 1200, 700);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.getContentPane().setLayout(null);
	
	
	
	//Attribute für Fragenfeld werden festgeleget
	txtFrage.setEditable(false);
	txtFrage.setFont(new Font("Tahoma", Font.PLAIN, 17));
	txtFrage.setText(txt);
	txtFrage.setHorizontalAlignment(SwingConstants.CENTER);
	txtFrage.setBounds(10, 18, 1164, 150);
	frame.getContentPane().add(txtFrage);
	txtFrage.setColumns(10);
	
	txtBeginn.setEditable(false);
	txtBeginn.setFont(new Font("Tahoma", Font.PLAIN, 17));
	txtBeginn.setBounds(142, 50, 851, 100);
	txtBeginn.setVisible(false);
	
	frame.getContentPane().add(txtBeginn);
	btnAntwort1.setFont(new Font("Tahoma", Font.BOLD, 15));
	
	
	frame.getContentPane().add(btnAntwort1);						//Button bekommt Rahmen
	btnAntwort2.setFont(new Font("Tahoma", Font.BOLD, 15));			//Bestimmt Schriftgröße und Art
					
	frame.getContentPane().add(btnAntwort2);	
	btnAntwort3.setFont(new Font("Tahoma", Font.BOLD, 15));
	frame.getContentPane().add(btnAntwort3);
	
	txtBeantwortet.setEditable(false);
	txtBeantwortet.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
	txtBeantwortet.setBounds(586, 608, 147, 20);
	frame.getContentPane().add(txtBeantwortet);
	txtBeantwortet.setColumns(10);
	
	txtNummer = new JTextField();
	txtNummer.setEditable(false);
	txtNummer.setBounds(10, 608, 86, 20);
	frame.getContentPane().add(txtNummer);
	txtNummer.setColumns(10);
	
	btnJung.setText("10-14 Jahre");
	btnJung.setFont(new Font("Tahoma", Font.PLAIN, 20));
	btnJung.setBounds(300, 400, 600, 50);
	frame.getContentPane().add(btnJung);
	btnJung.setVisible(false);
	
	btnAlt.setText("15-18 Jahre");
	btnAlt.setFont(new Font("Tahoma", Font.PLAIN, 20));
	btnAlt.setBounds(300, 475, 600, 50);
	frame.getContentPane().add(btnAlt);
	btnAlt.setVisible(false);
	
	btnKatZurueck.setBounds(101, 608, 23, 23);
	btnKatZurueck.setRolloverEnabled(false);
	btnKatZurueck.setRequestFocusEnabled(false);
	btnKatZurueck.setOpaque(false);
	frame.getContentPane().add(btnKatZurueck);
	
	btnKatVor.setRolloverEnabled(false);
	btnKatVor.setRequestFocusEnabled(false);
	btnKatVor.setOpaque(false);
	frame.getContentPane().add(btnKatVor);
	
	txtKategorie.setFont(new Font("Tahoma", Font.BOLD, 13));
	txtKategorie.setEditable(false);
	txtKategorie.setBounds(125, 608, 169, 23);
	txtKategorie.setColumns(10);
	frame.getContentPane().add(txtKategorie);
	

	btnBild.setRolloverEnabled(false);
	btnBild.setRequestFocusEnabled(false);
	btnBild.setOpaque(false);
	btnBild.setBounds(960, 287, 200, 200);
	frame.getContentPane().add(btnBild);
	btnBild.setVisible(false);
	
	btnAlterZurueck.setFont(new Font("Tahoma", Font.PLAIN, 20));
	btnAlterZurueck.setBounds(300, 325, 600, 50);
	frame.getContentPane().add(btnAlterZurueck);
	btnAlterZurueck.setVisible(false);
	
	btnFragenkatalog.setFont(new Font("Tahoma", Font.PLAIN, 20));
	btnFragenkatalog.setBounds(300, 250, 600, 50);
	frame.getContentPane().add(btnFragenkatalog);
	
	btnEinstellungen.setBounds(300, 475, 600, 50);
	frame.getContentPane().add(btnEinstellungen);

	
	
	btnWettkampf.setFont(new Font("Tahoma", Font.PLAIN, 20));
	btnWettkampf.setBounds(300, 325, 600, 50);
	frame.getContentPane().add(btnWettkampf);
	
	btnEinZurueck.setFont(new Font("Tahoma", Font.PLAIN, 20));
	btnEinZurueck.setBounds(300, 250, 600, 50);
	frame.getContentPane().add(btnEinZurueck);
	btnEinZurueck.setVisible(false);
	
	btnLoeschen.setText("Fragenkatalog zurücksetzten");
	btnLoeschen.setFont(new Font("Tahoma", Font.PLAIN, 20));
	btnLoeschen.setBounds(300, 325, 600, 50);
	btnLoeschen.setVisible(false);	
	
	btnStatistik.setFont(new Font("Tahoma", Font.PLAIN, 20));
	btnStatistik.setBounds(300, 400, 600, 50);
	
	frame.getContentPane().add(btnStatistik);
	frame.getContentPane().add(btnLoeschen);
	btnZuMenue.setBounds(743, 608, 137, 23);
	btnZuMenue.setVisible(false);
	frame.getContentPane().add(btnZuMenue);
	
	btnAlterAendern.setFont(new Font("Tahoma", Font.PLAIN, 20));
	btnAlterAendern.setBounds(300, 400, 600, 50);
	frame.getContentPane().add(btnAlterAendern);
	btnAlterAendern.setVisible(false);
	txtAlter.setEditable(false);
	
	
	txtAlter.setFont(new Font("Tahoma", Font.PLAIN, 20));
	txtAlter.setBackground(Color.LIGHT_GRAY);
	txtAlter.setBounds(300, 150, 600, 80);
	frame.getContentPane().add(txtAlter);
	txtAlter.setColumns(10);
	
	btnAbgabe.setBounds(791, 608, 89, 23);
	frame.getContentPane().add(btnAbgabe);
	
 
	btnStaKatZurueck.setBounds(100, 190, 30, 30);
	frame.getContentPane().add(btnStaKatZurueck);
	btnStaKatZurueck.setVisible(false);
	
	
	btnAbgabe1.setFont(new Font("Tahoma", Font.PLAIN, 15));
	btnAbgabe1.setBounds(100, 50, 1000, 23);
	frame.getContentPane().add(btnAbgabe1);
	btnAbgabe1.setHorizontalAlignment(SwingConstants.LEFT);
	
	btnAbgabe2.setFont(new Font("Tahoma", Font.PLAIN, 15));
	btnAbgabe2.setBounds(100, 75, 1000, 23);
	frame.getContentPane().add(btnAbgabe2);
	btnAbgabe2.setHorizontalAlignment(SwingConstants.LEFT);
	
	btnAbgabe3.setFont(new Font("Tahoma", Font.PLAIN, 15));
	btnAbgabe3.setBounds(100, 100, 1000, 23);
	frame.getContentPane().add(btnAbgabe3);
	btnAbgabe3.setHorizontalAlignment(SwingConstants.LEFT);
	
	btnAbgabe4.setFont(new Font("Tahoma", Font.PLAIN, 15));
	btnAbgabe4.setBounds(100, 125, 1000, 23);
	frame.getContentPane().add(btnAbgabe4);
	btnAbgabe4.setHorizontalAlignment(SwingConstants.LEFT);
	
	btnAbgabe5.setFont(new Font("Tahoma", Font.PLAIN, 15));
	btnAbgabe5.setBounds(100, 150, 1000, 23);
	frame.getContentPane().add(btnAbgabe5);
	btnAbgabe5.setHorizontalAlignment(SwingConstants.LEFT);
	
	btnAbgabe6.setFont(new Font("Tahoma", Font.PLAIN, 15));
	btnAbgabe6.setBounds(100, 175, 1000, 23);
	frame.getContentPane().add(btnAbgabe6);
	btnAbgabe6.setHorizontalAlignment(SwingConstants.LEFT);
	
	btnAbgabe7.setFont(new Font("Tahoma", Font.PLAIN, 15));
	btnAbgabe7.setBounds(100, 200, 1000, 23);
	frame.getContentPane().add(btnAbgabe7);
	btnAbgabe7.setHorizontalAlignment(SwingConstants.LEFT);
	
	btnAbgabe8.setFont(new Font("Tahoma", Font.PLAIN, 15));
	btnAbgabe8.setBounds(100, 225, 1000, 23);
	frame.getContentPane().add(btnAbgabe8);
	btnAbgabe8.setHorizontalAlignment(SwingConstants.LEFT);
	
	btnAbgabe9.setFont(new Font("Tahoma", Font.PLAIN, 15));
	btnAbgabe9.setBounds(100, 250, 1000, 23);
	frame.getContentPane().add(btnAbgabe9);
	btnAbgabe9.setHorizontalAlignment(SwingConstants.LEFT);
	
	btnAbgabe10.setFont(new Font("Tahoma", Font.PLAIN, 15));
	btnAbgabe10.setBounds(100, 275, 1000, 23);
	frame.getContentPane().add(btnAbgabe10);
	btnAbgabe10.setHorizontalAlignment(SwingConstants.LEFT);
	
	btnAbgabe11.setFont(new Font("Tahoma", Font.PLAIN, 15));
	btnAbgabe11.setBounds(100, 300, 1000, 23);
	frame.getContentPane().add(btnAbgabe11);
	btnAbgabe11.setHorizontalAlignment(SwingConstants.LEFT);
	
	btnAbgabe12.setFont(new Font("Tahoma", Font.PLAIN, 15));
	btnAbgabe12.setBounds(100, 325, 1000, 23);
	frame.getContentPane().add(btnAbgabe12);
	btnAbgabe12.setHorizontalAlignment(SwingConstants.LEFT);
	
	btnAbgabe13.setFont(new Font("Tahoma", Font.PLAIN, 15));
	btnAbgabe13.setBounds(100, 350, 1000, 23);
	frame.getContentPane().add(btnAbgabe13);
	btnAbgabe13.setHorizontalAlignment(SwingConstants.LEFT);
	
	btnAbgabe14.setFont(new Font("Tahoma", Font.PLAIN, 15));
	btnAbgabe14.setBounds(100, 375, 1000, 23);
	frame.getContentPane().add(btnAbgabe14);
	btnAbgabe14.setHorizontalAlignment(SwingConstants.LEFT);
	
	btnAbgabe15.setFont(new Font("Tahoma", Font.PLAIN, 15));
	btnAbgabe15.setBounds(100, 400, 1000, 23);
	frame.getContentPane().add(btnAbgabe15);
	btnAbgabe15.setHorizontalAlignment(SwingConstants.LEFT);
	

	txtRichtig.setHorizontalAlignment(SwingConstants.LEFT);
	txtRichtig.setFont(new Font("Tahoma", Font.PLAIN, 15));
	txtRichtig.setEditable(false);
	txtRichtig.setBounds(101, 475, 179, 20);
	frame.getContentPane().add(txtRichtig);
	txtRichtig.setColumns(10);
	txtRichtig.setVisible(false);
	
	txtFalsch.setHorizontalAlignment(SwingConstants.LEFT);
	txtFalsch.setFont(new Font("Tahoma", Font.PLAIN, 15));
	txtFalsch.setEditable(false);
	txtFalsch.setBounds(101, 525, 179, 20);
	frame.getContentPane().add(txtFalsch);
	txtFalsch.setColumns(10);
	txtFehlerpunkte.setEditable(false);
	
	
	txtFehlerpunkte.setHorizontalAlignment(SwingConstants.LEFT);
	txtFehlerpunkte.setFont(new Font("Tahoma", Font.PLAIN, 15));
	txtFehlerpunkte.setBounds(101, 575, 220, 20);
	txtFehlerpunkte.setVisible(false);
	
	frame.getContentPane().add(txtFehlerpunkte);
	txtFehlerpunkte.setColumns(10);
	
	txtAntwortNr.setEditable(false);
	txtAntwortNr.setFont(new Font("Tahoma", Font.PLAIN, 13));
	txtAntwortNr.setBounds(346, 609, 100, 20);
	frame.getContentPane().add(txtAntwortNr);
	txtAntwortNr.setColumns(10);
	
	btnWeiter.setVisible(false);
	btnWeiter.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			btnEinZurueck.setVisible(false);
			if(Wettkampf==true) {
				n++;
				i=Fragen[n-1];
				btnAntwort1.setBackground(null);
				btnAntwort2.setBackground(null);
				btnAntwort3.setBackground(null);
				txtBeantwortet.setVisible(false);
			}else {
				btnAntwort1.setEnabled(true);
				btnAntwort2.setEnabled(true);
				btnAntwort3.setEnabled(true);	
			i++;					//Erhöht Fragencounter -> Nächste Frage aus Liste
			n++;
			}
			Aufruf();
			AlterVor();				//Skippt Frage falls 10-14 Jahre
			Kategorien();			
			Abfrage();
			ButtonTester();
			Bild();					//Wenn die Frage ein Bild hat wird dieses geldaden und die Antworten angepasst
			Lang();					//Wenn der Text zu lang ist wird die Schriftgröße angepasst
			Schreiben();			//Beschreibt die .txt Datein und speichert somit den Spielvortschritt
		}
	});
	btnWeiter.setBounds(1037, 608, 137, 23);
	frame.getContentPane().add(btnWeiter);
	
	btnZurueck.setVisible(false);
	btnZurueck.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			if(Wettkampf==true) {
				n--;
				i=Fragen[n-1];
				btnAntwort1.setBackground(null);
				btnAntwort2.setBackground(null);
				btnAntwort3.setBackground(null);
				txtBeantwortet.setVisible(false);
			}else {
				btnAntwort1.setEnabled(true);
				btnAntwort2.setEnabled(true);
				btnAntwort3.setEnabled(true);
			i--;					//Erhöht Fragencounter -> Nächste Frage aus Liste
			n--;
			}
			Aufruf();
			Kategorien();
			AlterZurueck();			//Skippt Frage falls 10-14 Jahre			
			Abfrage();				
			ButtonTester();
			Bild();
			Lang();
			Schreiben();
		}
	});
	btnZurueck.setBounds(890, 608, 137, 23);
	
	frame.getContentPane().add(btnZurueck);
	btnLogo.setBounds(80, 37, 200, 188);
	frame.getContentPane().add(btnLogo);
	txtStaRichtig.setHorizontalAlignment(SwingConstants.CENTER);
	txtStaRichtig.setFont(new Font("Tahoma", Font.BOLD, 11));
	

	txtStaRichtig.setEditable(false);
	txtStaRichtig.setBounds(80, 120, 10, 20);
	frame.getContentPane().add(txtStaRichtig);
	txtStaRichtig.setColumns(10);
	txtStaRichtig.setBackground(Color.GREEN);
	txtStaRichtig.setVisible(false);
	txtStaFalsch.setHorizontalAlignment(SwingConstants.CENTER);
	txtStaFalsch.setFont(new Font("Tahoma", Font.BOLD, 11));

	txtStaFalsch.setEnabled(false);
	txtStaFalsch.setBounds(390, 120, 86, 20);
	frame.getContentPane().add(txtStaFalsch);
	txtStaFalsch.setColumns(10);
	txtStaFalsch.setBackground(Color.RED);
	txtStaFalsch.setVisible(false);
	txtStaUnbeantwortet.setFont(new Font("Tahoma", Font.BOLD, 11));
	txtStaUnbeantwortet.setHorizontalAlignment(SwingConstants.CENTER);
	
	
	txtStaUnbeantwortet.setEnabled(false);
	txtStaUnbeantwortet.setBounds(736, 120, 86, 20);
	frame.getContentPane().add(txtStaUnbeantwortet);
	txtStaUnbeantwortet.setColumns(10);
	txtStaUnbeantwortet.setBackground(Color.GRAY);
	
	frame.getContentPane().add(txtStaFragenkatalog);
	txtStaUnbeantwortet.setVisible(false);
	
	txtStaFragenkatalog.setFont(new Font("Tahoma", Font.BOLD, 20));
 	txtStaFragenkatalog.setText("Fragenkatalog");
 	txtStaFragenkatalog.setEditable(false);
 	txtStaFragenkatalog.setBounds(523, 85, 154, 31);
 	txtStaFragenkatalog.setColumns(10);
 	txtStaFragenkatalog.setVisible(false);
 	
 	
	txtStaKatRichtig.setHorizontalAlignment(SwingConstants.CENTER);
	txtStaKatRichtig.setFont(new Font("Tahoma", Font.BOLD, 11));
	

	txtStaKatRichtig.setEditable(false);
	txtStaKatRichtig.setBounds(80, 220, 10, 20);
	frame.getContentPane().add(txtStaKatRichtig);
	txtStaKatRichtig.setColumns(10);
	txtStaKatRichtig.setBackground(Color.GREEN);
	txtStaKatRichtig.setVisible(false);
	txtStaKatFalsch.setHorizontalAlignment(SwingConstants.CENTER);
	txtStaKatFalsch.setFont(new Font("Tahoma", Font.BOLD, 11));

	txtStaKatFalsch.setEnabled(false);
	txtStaKatFalsch.setBounds(390, 220, 86, 20);
	frame.getContentPane().add(txtStaKatFalsch);
	txtStaKatFalsch.setColumns(10);
	txtStaKatFalsch.setBackground(Color.RED);
	txtStaKatFalsch.setVisible(false);
	txtStaKatUnbeantwortet.setFont(new Font("Tahoma", Font.BOLD, 11));
	txtStaKatUnbeantwortet.setHorizontalAlignment(SwingConstants.CENTER);
	
	
	txtStaKatUnbeantwortet.setEnabled(false);
	txtStaKatUnbeantwortet.setBounds(736, 220, 86, 20);
	frame.getContentPane().add(txtStaKatUnbeantwortet);
	txtStaKatUnbeantwortet.setColumns(10);
	txtStaKatUnbeantwortet.setBackground(Color.GRAY);
	
	frame.getContentPane().add(txtStaKatFragenkatalog);
	txtStaKatUnbeantwortet.setVisible(false);
	
	txtStaKatFragenkatalog.setFont(new Font("Tahoma", Font.BOLD, 20));
 	txtStaKatFragenkatalog.setText("Fragenkatalog");
 	txtStaKatFragenkatalog.setEditable(false);
 	txtStaKatFragenkatalog.setBounds(523, 185, 154, 31);
 	txtStaKatFragenkatalog.setColumns(10);
 	
 	
 	btnStaKatVor.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			StaKatVor();
		}
	});
 	btnStaKatVor.setBounds(1070, 190, 30, 30);
 	frame.getContentPane().add(btnStaKatVor);
 	btnStaKatVor.setVisible(false);
 	
 	txtStaKatFragenkatalog.setVisible(false);
	
	
	btnStaKatZurueck.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			StaKatZurueck();
		}
	});

 	
	txtAntwortNr.setVisible(false);
	
	
	txtFalsch.setVisible(false);
	
	btnAbgabe.setVisible(false);
	txtAlter.setVisible(false);
	
	btnAbgabe1.setVisible(false);
	btnAbgabe2.setVisible(false);
	btnAbgabe3.setVisible(false);
	btnAbgabe4.setVisible(false);
	btnAbgabe5.setVisible(false);
	btnAbgabe6.setVisible(false);
	btnAbgabe7.setVisible(false);
	btnAbgabe8.setVisible(false);
	btnAbgabe9.setVisible(false);
	btnAbgabe10.setVisible(false);
	btnAbgabe11.setVisible(false);
	btnAbgabe12.setVisible(false);
	btnAbgabe13.setVisible(false);
	btnAbgabe14.setVisible(false);
	btnAbgabe15.setVisible(false);
	

	
	

	
}
}
