/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectfinaljava;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.text.Text;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author atdig
 */
public class TentFrame extends JFrame implements ActionListener{
    //Tent frame for the information cost and activities
     ImageIcon image = new ImageIcon("camping2.jpg");
     ImageIcon image1 = new ImageIcon("image1.jpg");
     ImageIcon image2 = new ImageIcon("image2.jpg");
     ImageIcon image3 = new ImageIcon("image3.jpg");
     ImageIcon image4 = new ImageIcon("image4.jpg");
     JButton btnRes, btnTarif, btnEquit, btnCanot, btnEscal;
     JTextField nom_box, phone_box,cour_box;
     JTextArea infoTarif;
     JComboBox combo_nbrPer, combo_jourOpts;
     String[] joursopts = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
     String[] nbrperOpts = {"1", "2", "3", "4", "5", "6"};

     EquitationFrame equitation;
     CanotFrame canot;
     EscaladeFrame escalade;
     public static TentFrame tante;
     
     //Variables for calculation
     public static List<Campeur> campeurs = new ArrayList<Campeur>();
     public static List<Tarif> tarifs = new ArrayList<Tarif>();
     public static Campeur campeur;
     public static Tarif tarif;
    
     int jours, nombrePer;
     float tarif_Tante;
     public static String dispalyinfo;

    TentFrame() {
        this.setTitle("Tante Accueil Page");
        this.setSize (1200, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //this.setLayout(new FlowLayout());
        this.setLayout(new GridLayout(1, 2, 50, 20));
        
        //Left and Right two part of main container 
        JPanel panLeft = new JPanel();
        JPanel panRight = new JPanel();
        
        this.add(panLeft, BorderLayout.NORTH);
        this.add(panRight, BorderLayout.SOUTH);
        
        //Left part to show the main information of introductions
        JPanel panL_Top = new JPanel();
        JPanel panL_Middle = new JPanel();
        JPanel panL_Bottom = new JPanel();
        
        panLeft.setLayout(new BorderLayout());
        panLeft.add(panL_Top, BorderLayout.NORTH);
        panLeft.add(panL_Middle, BorderLayout.CENTER);
        panLeft.add(panL_Bottom, BorderLayout.SOUTH);
        
        //Title of the page
        JLabel title = new JLabel("Sejour a Camping de Tante Irma");
        title.setFont(new Font("Arial", Font.BOLD, 30));
        panL_Top.add(title);
        panL_Top.setBorder(new EmptyBorder(40, 20, 40, 20));
        
        //Image of tent
        JLabel imagelab = new JLabel();
        imagelab.setIcon(image);
        panL_Middle.add(imagelab);
        panL_Middle.setBorder(new EmptyBorder(0, 20, 0, 20));

        
        //Label title of Acitivities
        JLabel ActivTitle = new JLabel("Activities pour choisir: ");
        ActivTitle.setFont(new Font("Arial", Font.BOLD, 24));
        ActivTitle.setBorder(new EmptyBorder(20, 100, 20, 20));
        
        //Images for activitie and tent
        JPanel panActivity = new JPanel();
        panActivity.setLayout(new FlowLayout());

        JLabel imagelab2 = new JLabel();
        JLabel imagelab3 = new JLabel();
        JLabel imagelab4 = new JLabel();
        
        
        imagelab2.setIcon(image2);
        imagelab3.setIcon(image3);
        imagelab4.setIcon(image4);
        
        panActivity.add(imagelab2);
        panActivity.add(imagelab3);
        panActivity.add(imagelab4);
        ((FlowLayout)panActivity.getLayout()).setHgap(20);
         panActivity.setBorder(new EmptyBorder(20, 20, 20, 20));
                 
        //Buttons link to activities and back to home

        btnEquit = new JButton("Equitation");
        btnEscal = new JButton("Escalade");
        btnCanot= new JButton("Canot");

        btnEquit.setFont(new Font("Arial", Font.BOLD, 16));
        btnEquit.setPreferredSize(new Dimension(150, 50));
        btnEquit.setBackground(new Color(147, 0, 236));
        btnEquit.setForeground(Color.white);
        
        btnCanot.setFont(new Font("Arial", Font.BOLD, 16));
        btnCanot.setPreferredSize(new Dimension(150, 50));
        btnCanot.setBackground(new Color(147, 0, 236));
        btnCanot.setForeground(Color.white);
        
        btnEscal.setFont(new Font("Arial", Font.BOLD, 16));
        btnEscal.setPreferredSize(new Dimension(150, 50));
        btnEscal.setBackground(new Color(147, 0, 236));
        btnEscal.setForeground(Color.white);       
        
        JPanel btnPan = new JPanel();
        
        btnPan.add(btnEquit);
        btnPan.add(btnEscal);
        btnPan.add(btnCanot);

        btnPan.setLayout(new FlowLayout(FlowLayout.CENTER, 90, 20));
        
        panL_Bottom.setLayout(new BorderLayout());
        panL_Bottom.add(ActivTitle, BorderLayout.NORTH);
        panL_Bottom.add(panActivity, BorderLayout.CENTER);
        panL_Bottom.add(btnPan, BorderLayout.SOUTH);
        panL_Bottom.setBorder(new EmptyBorder(20, 20, 80, 20));
        

        //Right part to show booking form and activities links and fees calculator
        
        JPanel panR_Top = new JPanel();
        JPanel panR_Middle = new JPanel();
        JPanel panR_Bottom = new JPanel();
        
        panRight.setLayout(new BorderLayout());
        panRight.setBorder(new EmptyBorder(60, 20, 100, 160));
        panRight.add(panR_Top, BorderLayout.NORTH);
        panRight.add(panR_Middle, BorderLayout.CENTER);
        panRight.add(panR_Bottom, BorderLayout.SOUTH);        
        
        //Right top for tarifs info
        panR_Top.setLayout(new BorderLayout());

        //Fees for stay
        /*
        JTextArea tarif_tante = new JTextArea(10, 50);
        tarif_tante.setText(s_tarif);
        tarif_tante.setLineWrap(true);
        tarif_tante.setAlignmentX(CENTER_ALIGNMENT);
        */
        JLabel txt_tarif1 = new JLabel("Tarifs d'occupation");
        txt_tarif1.setFont(new Font("Arial", Font.BOLD, 22));
        txt_tarif1.setBorder(new EmptyBorder(20, 0, 20, 0));
        JLabel txt_tarif2 = new JLabel("Personne 1 : $ 23,25  par jour ");
        txt_tarif2.setFont(new Font("Arial", Font.PLAIN, 16));
        txt_tarif2.setBorder(new EmptyBorder(0, 0, 10, 0));
        JLabel txt_tarif3 = new JLabel("Personne 2 : $ 20,90  par jour");
        txt_tarif3.setFont(new Font("Arial", Font.PLAIN, 16));
        txt_tarif3.setBorder(new EmptyBorder(0, 0, 10, 0));
        JLabel txt_tarif4 = new JLabel("Personne 3 : $ 18,25 par jour");
        txt_tarif4.setFont(new Font("Arial", Font.PLAIN, 16));
        txt_tarif4.setBorder(new EmptyBorder(0, 0, 10, 0));
        JLabel txt_tarif5 = new JLabel("A partir de personne 4 : $ 16,25 par jour");
        txt_tarif5.setFont(new Font("Arial", Font.PLAIN, 16));
        txt_tarif5.setBorder(new EmptyBorder(0, 0, 10, 0));
        
        JPanel txtArea = new JPanel();
        
        txtArea.add(txt_tarif1);
        txtArea.add(txt_tarif2);
        txtArea.add(txt_tarif3);
        txtArea.add(txt_tarif4);
        txtArea.add(txt_tarif5);
        txtArea.setLayout(new BoxLayout(txtArea, BoxLayout.PAGE_AXIS));
        txtArea.setBorder(new EmptyBorder(30, 260, 50, 140));
        txtArea.setBackground(new Color(226, 225, 223));
                         
        panR_Top.add(txtArea);
        
        //Middle for the booking form
        //Label title of form
        JLabel formTitle = new JLabel("Réserver pour un séjour");
        formTitle.setFont(new Font("Arial", Font.BOLD, 24));
        formTitle.setBorder(new EmptyBorder(20, 20, 20, 20));
        
        //Grid layout for the form in the moddle container
        JPanel panForm = new JPanel();
        panForm.setLayout(new GridLayout(5, 2, 20, 20));
        panForm.setBorder(new EmptyBorder(20, 20, 20, 20));
        
        JLabel jour = new JLabel("Jours de séjour");
        jour.setFont(new Font("Arial", Font.PLAIN, 16));
        JLabel nbrePersonne = new JLabel("Nombre de Personnes");
        nbrePersonne.setFont(new Font("Arial", Font.PLAIN, 16));
        JLabel nom = new JLabel("Votre Nom complet");
        nom.setFont(new Font("Arial", Font.PLAIN, 16));
        JLabel courriel = new JLabel("Courriel");
        courriel.setFont(new Font("Arial", Font.PLAIN, 16));
        JLabel phone = new JLabel("Telephone");
        phone.setFont(new Font("Arial", Font.PLAIN, 16));
        
        combo_jourOpts = new JComboBox(joursopts);
        combo_jourOpts.setSelectedIndex(0);
        combo_jourOpts.setPreferredSize(new Dimension(200, 30));
        
        combo_nbrPer = new JComboBox(nbrperOpts);
        combo_nbrPer.setSelectedIndex(0);
        combo_nbrPer.setPreferredSize(new Dimension(200, 30));

        nom_box = new JTextField(20);
        nom_box.setPreferredSize(new Dimension(200, 30));
        cour_box = new JTextField(20);
        cour_box.setPreferredSize(new Dimension(200, 30));
        phone_box = new JTextField(20);
        phone_box.setPreferredSize(new Dimension(200, 30));
        
        panForm.add(jour);
        panForm.add(combo_jourOpts);
        panForm.add(nbrePersonne);
        panForm.add(combo_nbrPer);
        panForm.add(nom);
        panForm.add(nom_box);
        panForm.add(courriel);
        panForm.add(cour_box);
        panForm.add(phone);
        panForm.add(phone_box);

        JPanel panBtn = new JPanel();
        btnRes = new JButton("Réserver");
        btnRes.setFont(new Font("Arial", Font.BOLD, 16));
        btnRes.setPreferredSize(new Dimension(650, 40));
        panBtn.add(btnRes);
        panBtn.setBorder(new EmptyBorder(0, 20, 20, 20));
        
        
        panR_Middle.setLayout(new BorderLayout());
        panR_Middle.add(formTitle, BorderLayout.NORTH);
        panR_Middle.add(panForm, BorderLayout.CENTER);
        panR_Middle.add(panBtn, BorderLayout.SOUTH);
        panR_Middle.setBorder(new EmptyBorder(20, 0, 20, 0));
        
        
        //Fees calculator and booking info
                
        btnTarif = new JButton("Tarif: $");
        btnTarif.setFont(new Font("Arial", Font.BOLD, 16));
        btnTarif.setPreferredSize(new Dimension(150, 50));
        btnTarif.setBackground(new Color(147, 0, 236));
        btnTarif.setForeground(Color.white);
        infoTarif = new JTextArea(5, 20);
        infoTarif.setBorder(new EmptyBorder(20, 20, 20, 20));
        
        panR_Bottom.setLayout(new FlowLayout());

        panR_Bottom.add(infoTarif);
        panR_Bottom.add(btnTarif);
        ((FlowLayout)panR_Bottom.getLayout()).setHgap(20);
        panR_Bottom.setBackground(new Color(226, 225, 223));
        panR_Bottom.setBorder(new EmptyBorder(20, 20, 20, 20));
        
        //Add event listener to buttons
        btnRes.addActionListener(this);
        btnTarif.addActionListener(this);
        btnEquit.addActionListener(this);
        btnCanot.addActionListener(this);
        btnEscal.addActionListener(this);

        this.pack();
        this.setVisible(true);     
    }


    @Override
    public void actionPerformed(ActionEvent e) {
       //Open new window and close current
        if (e.getSource() == btnEquit){
            equitation = new EquitationFrame();
        }
            
        if (e.getSource() == btnCanot){
            canot = new CanotFrame();
        }
            
        if (e.getSource() == btnEscal){
            escalade = new EscaladeFrame();
        }
            
        if (e.getSource() ==btnTarif){
            //Create instance of campeur with form input values
            String intputNom = nom_box.getText();
            String intputPhone = phone_box.getText();
            String intputCourriel = cour_box.getText();    
            campeur = new Campeur(intputNom, intputPhone, intputCourriel);
            
            //Calculate cost of stay
            //Valid user number input value

            jours = getIntegerFromTextBox(combo_jourOpts.getSelectedItem().toString());
            
            nombrePer = Integer.parseInt(combo_nbrPer.getSelectedItem().toString());

            //Tarif instance
            tarif = new Tarif(campeur);
            tarif_Tante = tarif.calculTarifTante(jours, nombrePer);
            
            //Print results in textarea
            String results = "Tarif de sejour est: " + Float.toString(tarif_Tante) + "\n"
                    + "Pour " + nombrePer + " personnes et " + jours + " jours \n"
                    + "Votre Nom: "  + campeur.getNom() + "\n"
                    + "Votre Phone: " + campeur.getPhone() + "\n"
                    + "Votre Courriel: " + campeur.getCourriel() + "\n"
                    + "Confermer et reserver SVP!";
            //Dislay in textarea
            infoTarif.setText(results);
        }
        if (e.getSource() ==btnRes){
            //Reserver button will add data to list for colecting and using           
            if (campeur != null && tarif != null){
                campeurs.add(campeur);
                tarifs.add(tarif);

                DispalyBookingInfo();

                infoTarif.setText("Reserver success!! Merci! \n" + UserInfo());
            }
            else 
                infoTarif.setText("Entrez votre information et choisirs,\n Cliquez sur le button Tarif pour calculer, \nEt confirmer avant de Reserver SVP!!");
        }
 
    }
    
    //Method for reusing
    //01 String for dispaly
    public static String UserInfo(){
        dispalyinfo = "Nom: " + tante.campeur.getNom() + ", Phone: " + tante.campeur.getPhone() + ", Courriel: " + tante.campeur.getCourriel() + "\n";
        if (tante.tarif.GetTarifTante() != 0)
            dispalyinfo += "Tarif de Sejour est : $" + tante.tarif.GetTarifTante() + "\n";
        if (tante.tarif.GetTarifEquitation() != 0)
            dispalyinfo += "Tarif de l'Equitation est : $" + tante.tarif.GetTarifEquitation() + "\n";
        if (tante.tarif.GetTarifCanot() != 0)
            dispalyinfo += "Tarif de Canot est : $" + tante.tarif.GetTarifCanot() + "\n";
        if (tante.tarif.GetTarifEscalade() != 0)
            dispalyinfo += "Tarif de Escalade est : $" + tante.tarif.GetTarifEscalade() + "\n";
        
        dispalyinfo +=  "Totla Tarif: $" + tante.tarif.TotalTarifs();
        return dispalyinfo;
    }
    
    public static void DispalyBookingInfo(){
        tante.campeurs.forEach((c) -> {
            System.out.println("Nom: " + c.getNom() + ", Phone: " + c.getPhone() + ", Courriel: " + c.getCourriel());
        });
        for(Tarif t:tante.tarifs){
            System.out.println("Campeur: " + t.GetCampeur().getNom());
            if (t.GetTarifTante() != 0)
                System.out.println("Tarif de Sejour est : $" + t.GetTarifTante());
            if (t.GetTarifEquitation() != 0)
                System.out.println("Tarif de l'Equitation est : $" + t.GetTarifEquitation());
            if (t.GetTarifCanot() != 0)
                System.out.println("Tarif de Canot est : $" + t.GetTarifCanot());
            if (t.GetTarifEscalade() != 0)
                System.out.println("Tarif de Escalade est : $" + t.GetTarifEscalade());
        }
        System.out.println("Totla Tarif: $" + tante.tarif.TotalTarifs());
    }
    
        //Validation checker
        Integer getIntegerFromTextBox(String text) {
            Integer integer;

            if (text.trim().equals("")) { 
                integer = 0; 
            } else { 
                integer = Integer.parseInt(text); 
            }

            return integer;
        }
}
