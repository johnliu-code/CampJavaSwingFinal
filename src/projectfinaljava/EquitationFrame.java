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
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author atdig
 */
public class EquitationFrame extends JFrame implements ActionListener {
      //Equitation frame for the information of cost
     ImageIcon image = new ImageIcon("horse-2.jpg");
     ImageIcon image2 = new ImageIcon("riding0.jpg");
     JButton btnRes, btnTarif, btnCanot, btnEscal, btnBackHome;
     JTextArea infoTarif;
     JComboBox combo_nbrPer, combo_parcour;
     String[] parcoursopts = {"1", "2", "3"};
     String[] personnes = {"1", "2", "3", "4", "5", "6"};
     JRadioButton btnRweek,btnRweekend;

     public static TentFrame tante;
     CanotFrame canot;
     EscaladeFrame escalade;
     
     //Variables for calculation
     int nombrePer, nbrParcours, weekend;
     float tarif_Equit;
     String weekinfo, message;
    
    EquitationFrame(){
        this.setTitle("Equitation Page");
        this.setSize (1200, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
        JLabel title = new JLabel("Equitation a Camping de Tante Irma");
        title.setFont(new Font("Arial", Font.BOLD, 30));
        panL_Top.add(title);
        panL_Top.setBorder(new EmptyBorder(40, 20, 40, 20));
        
        //Image of tent
        JLabel imagelab = new JLabel();
        imagelab.setIcon(image);
        panL_Middle.add(imagelab);
        panL_Middle.setBorder(new EmptyBorder(0, 20, 0, 20));
        //Fees for stay

        JLabel txt_tarif1 = new JLabel("Tarifs pour l'Equitation 2022");
        txt_tarif1.setFont(new Font("Arial", Font.BOLD, 22));
        txt_tarif1.setBorder(new EmptyBorder(20, 0, 20, 0));
        JLabel txt_tarif2 = new JLabel("Parcours No.    Semaine                 Fin de semaine");
        txt_tarif2.setFont(new Font("Arial", Font.PLAIN, 16));
        txt_tarif2.setBorder(new EmptyBorder(0, 0, 10, 0));
        JLabel txt_tarif3 = new JLabel("Parcours 1  :    $15,25                              $18,25");
        txt_tarif3.setFont(new Font("Arial", Font.PLAIN, 16));
        txt_tarif3.setBorder(new EmptyBorder(0, 0, 10, 0));
        JLabel txt_tarif4 = new JLabel("Parcours 2  :    $22,75                              $25,00");
        txt_tarif4.setFont(new Font("Arial", Font.PLAIN, 16));
        txt_tarif4.setBorder(new EmptyBorder(0, 0, 10, 0));
        JLabel txt_tarif5 = new JLabel("Parcours 3  :    $25,25                              $27,75");
        txt_tarif5.setFont(new Font("Arial", Font.PLAIN, 16));
        txt_tarif5.setBorder(new EmptyBorder(0, 0, 10, 0));
        
        JPanel txtArea = new JPanel();
        
        txtArea.add(txt_tarif1);
        txtArea.add(txt_tarif2);
        txtArea.add(txt_tarif3);
        txtArea.add(txt_tarif4);
        txtArea.add(txt_tarif5);
        txtArea.setLayout(new BoxLayout(txtArea, BoxLayout.PAGE_AXIS));
        txtArea.setBorder(new EmptyBorder(30, 150, 50, 110));
        txtArea.setBackground(new Color(226, 225, 223));
        
        panL_Bottom.add(txtArea);
        panL_Bottom.setBorder(new EmptyBorder(20, 0, 80, 0));
        

        //Right part to show booking form and activities links and fees calculator
        
        JPanel panR_Top = new JPanel();
        JPanel panR_Middle = new JPanel();
        JPanel panR_Bottom = new JPanel();
        
        panRight.setLayout(new BorderLayout());
        panRight.setBorder(new EmptyBorder(120, 20, 50, 160));
        panRight.add(panR_Top, BorderLayout.NORTH);
        panRight.add(panR_Middle, BorderLayout.CENTER);
        panRight.add(panR_Bottom, BorderLayout.SOUTH);        
        
        //Booking form 
        panR_Top.setLayout(new BorderLayout());
        
        //Label title of form
        JLabel formTitle = new JLabel("Réserver pour activite de l'Equitation");
        formTitle.setFont(new Font("Arial", Font.BOLD, 24));
        
        //Grid layout for the form
        JPanel panForm = new JPanel();
        panForm.setLayout(new GridLayout(3, 2, 20, 20));
        panForm.setBorder(new EmptyBorder(40, 0, 40, 220));
        
        JLabel parcours = new JLabel("Numero du Parcours");
        parcours.setFont(new Font("Arial", Font.PLAIN, 16));
        JLabel nbrePersonne = new JLabel("Nombre de Personnes");
        nbrePersonne.setFont(new Font("Arial", Font.PLAIN, 16));
        JLabel nom = new JLabel("Votre Nom complet");
        nom.setFont(new Font("Arial", Font.PLAIN, 16));
        JLabel phone = new JLabel("Telephone");
        phone.setFont(new Font("Arial", Font.PLAIN, 16));
        JLabel courriel = new JLabel("Courriel");
        courriel.setFont(new Font("Arial", Font.PLAIN, 16));
      
        combo_parcour= new JComboBox(parcoursopts);
        combo_parcour.setSelectedIndex(0);
        combo_parcour.setPreferredSize(new Dimension(200, 30));
        
        combo_nbrPer = new JComboBox(personnes);
        combo_nbrPer.setSelectedIndex(0);
        combo_nbrPer.setPreferredSize(new Dimension(200, 30));
        
        btnRweek = new JRadioButton("Jour de semaine");
        btnRweek.setFont(new Font("Arial", Font.PLAIN, 16));
        btnRweek.setPreferredSize(new Dimension(200, 30));
        btnRweekend = new JRadioButton("Fin de semaine ou jour de conge");
        btnRweekend.setPreferredSize(new Dimension(200, 30));
        btnRweekend.setFont(new Font("Arial", Font.PLAIN, 16));
        ButtonGroup gr = new ButtonGroup();
        gr.add(btnRweek);
        gr.add(btnRweekend);
              
        panForm.add(parcours);
        panForm.add(combo_parcour);
        panForm.add(nbrePersonne);
        panForm.add(combo_nbrPer);
        panForm.add(btnRweek);
        panForm.add(btnRweekend);


        JPanel panBtn = new JPanel();
        btnRes = new JButton("Réserver");
        btnRes.setFont(new Font("Arial", Font.BOLD, 16));
        btnRes.setPreferredSize(new Dimension(510, 40));

        panBtn.add(btnRes);
        panBtn.setBorder(new EmptyBorder(0, 0, 40, 220));
        
        panR_Top.add(formTitle, BorderLayout.NORTH);
        panR_Top.add(panForm, BorderLayout.CENTER);                
        panR_Top.add(panBtn, BorderLayout.SOUTH);
        panR_Top.setBorder(new EmptyBorder(0, 20, 20, 0));
        
        //Fees calculator and booking info
        btnTarif = new JButton("Tarif: $");
        btnTarif.setFont(new Font("Arial", Font.BOLD, 16));
        btnTarif.setPreferredSize(new Dimension(150, 50));
        btnTarif.setBackground(new Color(147, 0, 236));
        btnTarif.setForeground(Color.white);
        infoTarif = new JTextArea(5, 20);
        infoTarif.setBorder(new EmptyBorder(20, 20, 20, 20));
        
        panR_Middle.add(btnTarif);
        panR_Middle.add(infoTarif);
        ((FlowLayout)panR_Middle.getLayout()).setHgap(40);
        panR_Middle.setBackground(new Color(226, 225, 223));
        panR_Middle.setBorder(new EmptyBorder(30, 0, 20, 0));
        
        //Label title of Acitivities
        JLabel ActivTitle = new JLabel("Activities pour choisir: ");
        ActivTitle.setFont(new Font("Arial", Font.BOLD, 24));
        ActivTitle.setBorder(new EmptyBorder(20, 20, 20, 0));
         
        //Buttons link to activities and back to home

        btnCanot = new JButton("Canot");
        btnEscal = new JButton("Escalade");
        btnBackHome = new JButton("Retour Accueil");
        
        btnCanot.setFont(new Font("Arial", Font.BOLD, 16));
        btnCanot.setPreferredSize(new Dimension(150, 50));
        btnCanot.setBackground(new Color(147, 0, 236));
        btnCanot.setForeground(Color.white);
        
        btnEscal.setFont(new Font("Arial", Font.BOLD, 16));
        btnEscal.setPreferredSize(new Dimension(150, 50));
        btnEscal.setBackground(new Color(147, 0, 236));
        btnEscal.setForeground(Color.white);
        
        btnBackHome.setFont(new Font("Arial", Font.BOLD, 16));
        btnBackHome.setPreferredSize(new Dimension(150, 50));
        btnBackHome.setBackground(new Color(147, 0, 236));
        btnBackHome.setForeground(Color.white);
   
        JPanel btnPan = new JPanel();
        
        btnPan.add(btnCanot);
        btnPan.add(btnEscal);
        btnPan.add(btnBackHome);
        btnPan.setLayout(new FlowLayout(FlowLayout.CENTER, 85, 20));
        //((FlowLayout)btnPan.getLayout()).setHgap(50);

        panR_Bottom.setLayout(new BorderLayout());
        panR_Bottom.add(ActivTitle, BorderLayout.NORTH);
        panR_Bottom.add(btnPan, BorderLayout.SOUTH);
        panR_Bottom.setBorder(new EmptyBorder(30, 20, 30, 20));
        
        //Add event listener to buttons
        btnRes.addActionListener(this);
        btnTarif.addActionListener(this);
        btnCanot.addActionListener(this);
        btnEscal.addActionListener(this);
        btnBackHome.addActionListener(this);
        
        this.pack();
        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Return to main page from activity pages       
  
        if (e.getSource() == btnBackHome){
             message = "Veuiilez quitter le system et retour a l'Accuiel? Yes/No";
            int ans = JOptionPane.showConfirmDialog(null, message, "Quitter? Yes/No", JOptionPane.YES_NO_CANCEL_OPTION);
            if(ans == 0)
            this.setVisible(false);
        }
        if (e.getSource() == btnCanot){
            canot = new CanotFrame();
            this.setVisible(false);
        }

        if (e.getSource() == btnEscal){
            escalade = new EscaladeFrame();
            this.setVisible(false);
        }
        if (e.getSource() ==btnTarif){          
            //To display booking info and cost details           
            if (tante.campeur != null && tante.tarif != null){
                tante.DispalyBookingInfo();
                infoTarif.setText("Reserver success!! Merci! \n" + tante.UserInfo());
            }
            else 
                infoTarif.setText("Entrez votre information et choisirs,\n Cliquez sur le button Tarif pour calculer, \nEt confirmer avant de Reserver SVP!!");
        }
        if (e.getSource() ==btnRes){    
            //Calculate cost of activity
            //Get data and convert the values from user input
            nombrePer = Integer.parseInt(combo_nbrPer.getSelectedItem().toString());
            nbrParcours = Integer.parseInt(combo_parcour.getSelectedItem().toString());
            
            //Convert user choise to week option int value
            if (btnRweek.isSelected()){
                weekend = 0;
                weekinfo = "Jour de semaine";
                System.out.println("Week selected");
            }
                
            if (btnRweekend.isSelected()){
                weekend = 1;
                weekinfo = "Fin de semaine ou jour de conge";
                System.out.println("Weekend selected");
            }
                           
            // using Tarif instance for existing class tent
            tarif_Equit = tante.tarif.CalculTarifEquitation(nombrePer, nbrParcours, weekend);
            
            //Print results in textarea
            String results = 
                    "Tarif de l'Equitation est: " + Float.toString(tarif_Equit) + "\n"
                    + "Pour " + nombrePer + " personnes et " + "Parcours No." + nbrParcours +  "a " + weekinfo + "\n"
                    + "Votre Nom: "  + tante.campeur.getNom() + "\n"
                    + "Votre Phone: " + tante.campeur.getPhone() + "\n"
                    + "Votre Courriel: " + tante.campeur.getCourriel() + "\n"
                    + "Confermer et reserver SVP!";
            //Dislay in textarea
            infoTarif.setText(results);
        }

    }
            
}
