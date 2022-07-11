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
import static projectfinaljava.EquitationFrame.tante;

/**
 *
 * @author atdig
 */
public class CanotFrame extends JFrame implements ActionListener {
     //Canot frame for the information of cost
     ImageIcon image = new ImageIcon("boating.jpg");
     JButton btnRes, btnTarif, btnEquit, btnEscal, btnBackHome;
     JTextArea infoTarif;
     JComboBox combo_foisdebloc;
     String[] bloc_opts = {"1", "2", "3", "4"};
     JRadioButton btnRweek,btnRweekend;
     
     public static TentFrame tante;
     EquitationFrame equitation;
     EscaladeFrame escalade;
     //Variables for calculation
     int foisDeuxHeures, weekend;
     float tarif_Canot;
     String weekinfo, message;
    CanotFrame(){
        this.setTitle("Canot Page");
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
        JLabel title = new JLabel("Canot a Camping de Tante Irma");
        title.setFont(new Font("Arial", Font.BOLD, 30));
        panL_Top.add(title);
        panL_Top.setBorder(new EmptyBorder(40, 20, 40, 20));
        
        //Image of tent
        JLabel imagelab = new JLabel();
        imagelab.setIcon(image);
        panL_Middle.add(imagelab);
        panL_Middle.setBorder(new EmptyBorder(0, 20, 0, 20));
        //Fees for stay

        JLabel txt_tarif1 = new JLabel("Tarifs pour Canot 2022");
        txt_tarif1.setFont(new Font("Arial", Font.BOLD, 22));
        txt_tarif1.setBorder(new EmptyBorder(20, 0, 20, 0));
        JLabel txt_tarif2 = new JLabel("Par embarcation  et pour des blocs de deux heures");
        txt_tarif2.setFont(new Font("Arial", Font.PLAIN, 16));
        txt_tarif2.setBorder(new EmptyBorder(0, 0, 10, 0));
        JLabel txt_tarif3 = new JLabel("Parcours No.    Semaine                 Fin de semaine");
        txt_tarif3.setFont(new Font("Arial", Font.PLAIN, 16));
        txt_tarif3.setBorder(new EmptyBorder(0, 0, 10, 0));
        JLabel txt_tarif4 = new JLabel("Parcours 1  :    $22,35                              $29,55");
        txt_tarif4.setFont(new Font("Arial", Font.PLAIN, 16));
        txt_tarif4.setBorder(new EmptyBorder(0, 0, 10, 0));

        JPanel txtArea = new JPanel();
        
        txtArea.add(txt_tarif1);
        txtArea.add(txt_tarif2);
        txtArea.add(txt_tarif3);
        txtArea.add(txt_tarif4);
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
        JLabel formTitle = new JLabel("Réserver pour activite de Canot");
        formTitle.setFont(new Font("Arial", Font.BOLD, 24));
        
        //Grid layout for the form
        JPanel panForm = new JPanel();
        panForm.setLayout(new GridLayout(2, 2, 20, 20));
        panForm.setBorder(new EmptyBorder(40, 0, 40, 220));
        
        JLabel foisbloc = new JLabel("Combien des blocs de deux heures");
        foisbloc.setFont(new Font("Arial", Font.PLAIN, 16));
      
        combo_foisdebloc = new JComboBox(bloc_opts);
        combo_foisdebloc.setSelectedIndex(0);
        combo_foisdebloc.setPreferredSize(new Dimension(200, 30));
        
        btnRweek = new JRadioButton("Jour de semaine");
        btnRweek.setFont(new Font("Arial", Font.PLAIN, 16));
        btnRweek.setPreferredSize(new Dimension(200, 30));
        btnRweekend = new JRadioButton("Fin de semaine ou jour de conge");
        btnRweekend.setPreferredSize(new Dimension(200, 30));
        btnRweekend.setFont(new Font("Arial", Font.PLAIN, 16));
        ButtonGroup gr = new ButtonGroup();
        gr.add(btnRweek);
        gr.add(btnRweekend);


        panForm.add(foisbloc);
        panForm.add(combo_foisdebloc);
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
        infoTarif = new JTextArea(6, 20);
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

        btnEquit = new JButton("Equitation");
        btnEscal = new JButton("Escalade");
        btnBackHome = new JButton("Retour Accueil");
        
        btnEquit.setFont(new Font("Arial", Font.BOLD, 16));
        btnEquit.setPreferredSize(new Dimension(150, 50));
        btnEquit.setBackground(new Color(147, 0, 236));
        btnEquit.setForeground(Color.white);
        
        btnEscal.setFont(new Font("Arial", Font.BOLD, 16));
        btnEscal.setPreferredSize(new Dimension(150, 50));
        btnEscal.setBackground(new Color(147, 0, 236));
        btnEscal.setForeground(Color.white);
        
        btnBackHome.setFont(new Font("Arial", Font.BOLD, 16));
        btnBackHome.setPreferredSize(new Dimension(150, 50));
        btnBackHome.setBackground(new Color(147, 0, 236));
        btnBackHome.setForeground(Color.white);
   
        JPanel btnPan = new JPanel();
        
        btnPan.add(btnEquit);
        btnPan.add(btnEscal);
        btnPan.add(btnBackHome);
        btnPan.setLayout(new FlowLayout(FlowLayout.CENTER, 85, 20));

        panR_Bottom.setLayout(new BorderLayout());
        panR_Bottom.add(ActivTitle, BorderLayout.NORTH);
        panR_Bottom.add(btnPan, BorderLayout.SOUTH);
        panR_Bottom.setBorder(new EmptyBorder(30, 20, 30, 20));
        
        //Add event listener to buttons
        btnRes.addActionListener(this);
        btnTarif.addActionListener(this);
        btnEquit.addActionListener(this);
        btnEscal.addActionListener(this);
        btnBackHome.addActionListener(this);
        
        this.pack();
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Return to main page from activity pages
        if (e.getSource() == btnBackHome)
             message = "Veuiilez quitter le system et retour a l'Accuiel? Yes/No";
             int ans = JOptionPane.showConfirmDialog(null, message, "Quitter? Yes/No", JOptionPane.YES_NO_CANCEL_OPTION);
             if(ans == 0){
                 this.setVisible(false);
             }         
        if (e.getSource() == btnEquit){
            equitation = new EquitationFrame();
        }

        if (e.getSource() == btnEscal){
            escalade = new EscaladeFrame();
        }

        if (e.getSource() ==btnTarif){          
            //Calculate cost of canot
            //Get data and convert the values from user input
            foisDeuxHeures = Integer.parseInt(combo_foisdebloc.getSelectedItem().toString());
            System.out.println("Nombre de bloc : " + foisDeuxHeures);            //Only for confirm in console
            
            //Convert user choise to week option int value
            if (btnRweek.isSelected()){
                weekend = 0;
                System.out.println("Week selected");
            }
                
            if (btnRweekend.isSelected()){
                weekend = 1;
                System.out.println("Weekend selected");
            }
                           
            // using Tarif instance for existing class tent
            tarif_Canot = tante.tarif.CalculTarifCanot(weekend, foisDeuxHeures);
            
            //Print results in textarea
            String results = "Tarif de l'Equitation est: " + Float.toString(tarif_Canot) + "\n"
                    + "Pour " + foisDeuxHeures + " fois deuxHeuresBloc " + ", et pour" + weekinfo + "\n"
                    + "Votre Nom: "  + tante.campeur.getNom() + "\n"
                    + "Votre Phone: " + tante.campeur.getPhone() + "\n"
                    + "Votre Courriel: " + tante.campeur.getCourriel() + "\n"
                    + "Confermer et reserver SVP!";
            //Dislay in textarea
            infoTarif.setText(results);
        }
        if (e.getSource() ==btnRes){
            //Reserver button will add data to list for colecting and using           
            if (tante.campeur != null && tante.tarif != null){
                tante.DispalyBookingInfo();
                infoTarif.setText("Reserver success!! Merci! \n" + tante.UserInfo());
            }
            else 
                infoTarif.setText("Entrez votre information et choisirs,\n Cliquez sur le button Tarif pour calculer, \nEt confirmer avant de Reserver SVP!!");
        }
    }
}
