
import java.awt.*;

import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;

public class ArcellanaStudentInf extends JFrame{
    Connection con = null;
    Statement st = null;
    String query = null;
    
    JFrame frame;
    JTable table;
    DefaultTableModel model;
    JScrollPane tablePanel;
    JButton btndelete = new JButton("Delete");
    
    public void constring(){
        try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost/java_db","root","");
        st = con.createStatement();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,ex.getMessage());
        }
    }
    
    public static void main(String[] args) {
        ArcellanaStudentInf ea = new ArcellanaStudentInf();
        ea.setVisible(true);
        ea.setSize(1000,500);
        ea.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    
    
    public void loadTable(){
        try{
           constring();
           query = "Select * from studinfo";
           ResultSet rs  = st.executeQuery(query);
           
           
           while(rs.next()){
               String id = rs.getString("id");
               String number = rs.getString("number");
               String lastname = rs.getString("lastname");
               String firstname = rs.getString("firstname");
               String middlename = rs.getString("middlename");
               String gender = rs.getString("gender");
               String contact = rs.getString("contact");
               String email = rs.getString("email");
               String course = rs.getString("course");
               String yearlvl = rs.getString("yearlvl");
               String tuition = rs.getString("tuition");
               String section = rs.getString("section");
               String status = rs.getString("status");
               String semester = rs.getString("Semester");
               
               
               model.insertRow(table.getRowCount(),new 
Object[]{id,number,lastname,firstname,middlename,gender,contact,email,course,
yearlvl,tuition,section,status,semester});
           }
            st.close();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,ex.getMessage());
        }
    }
        public ArcellanaStudentInf(){	
        	
        JPanel panel = new JPanel();
        this.add(panel);
        panel.setLayout(null);
        
        
        
        
        
        JLabel lbltext = new JLabel("STUDENT INFORMATION");
        lbltext.setFont(new Font("Consolas",Font.BOLD,30));
        
      
        
        JLabel lblnumber = new JLabel("Student Number:");
        lblnumber.setFont(new Font("Consolas",Font.BOLD,18));
        
        JLabel lbllname = new JLabel("Last name:");
        lbllname.setFont(new Font("Consolas",Font.BOLD,18));
        
        JLabel lblfname = new JLabel("First name:");
        lblfname.setFont(new Font("Consolas",Font.BOLD,18));
        
        JLabel lblmname = new JLabel("Middle name:");
        lblmname.setFont(new Font("Consolas",Font.BOLD,18));
        
        JLabel lblgen = new JLabel("Gender:");
        lblgen.setFont(new Font("Consolas",Font.BOLD,18));
        
        JLabel lblnum = new JLabel("Contact_num:");
        lblnum.setFont(new Font("Consolas",Font.BOLD,18));
        
        JLabel lblemail = new JLabel("Email:");
        lblemail.setFont(new Font("Consolas",Font.BOLD,18));
        
        JLabel lblcourse = new JLabel("Program:");
        lblcourse.setFont(new Font("Consolas",Font.BOLD,18));
        
        JLabel lblylevel = new JLabel("Year Level:");
        lblylevel.setFont(new Font("Consolas",Font.BOLD,18));
        
        JLabel lbltuition = new JLabel("Balance:");
        lbltuition.setFont(new Font("Consolas",Font.BOLD,18));
        
        JLabel lblsec = new JLabel("Section:");
        lblsec.setFont(new Font("Consolas",Font.BOLD,18));
        
        JLabel lblstat = new JLabel("Status:");
        lblstat.setFont(new Font("Consolas",Font.BOLD,18));
        
        JLabel lblsem = new JLabel("Semester:");
        lblsem.setFont(new Font("Consolas",Font.BOLD,18));
        
        
        
    
        JTextField txtnumber = new JTextField();
        
        JTextField txtlname = new JTextField();
        
        JTextField txtfname = new JTextField();
        
        JTextField txtmname = new JTextField();
        
        JTextField txtgen = new JTextField();
         
        JTextField txtnum = new JTextField();
          
        JTextField txtemail = new JTextField();
        
        JTextField txtcourse = new JTextField();
         
        JTextField txtylevel = new JTextField();
          
        JTextField txttuition = new JTextField();
           
        JTextField txtsec = new JTextField();
            
        JTextField txtstat = new JTextField();
             
        JTextField txtsem = new JTextField();
              
              btndelete.addActionListener(new ActionListener() {
                  @Override
                  public void actionPerformed(ActionEvent ae) {
                      int selectedRow = table.getSelectedRow();
                      if (selectedRow >= 0) {
                          String id = (String) table.getValueAt(selectedRow, 0);
                          deleteRecord(id);
                      } else {
                          JOptionPane.showMessageDialog(null, "Please select a row to delete.");
                      }
                  }
              });
         
        
              
              
        JLabel lblsearch = new JLabel("Search:");
        lblsearch.setFont(new Font("Consolas",Font.BOLD,12));
        
        JTextField txtsearch = new JTextField();
        
        txtsearch.addKeyListener(new KeyAdapter(){
            @Override
            public void keyReleased(KeyEvent ke) {
                try{
                    constring();
                    query = "SELECT * FROM studinfo WHERE id LIKE '%" + txtsearch.getText()
                    + "%' OR number LIKE '%" + txtsearch.getText()
                    + "%' OR firstname LIKE '%" + txtsearch.getText() 
                    + "%' OR lastname LIKE '%" + txtsearch.getText() + "%'";
                    ResultSet rs = st.executeQuery(query);
                    model.setNumRows(0);
                    
                    
                    while(rs.next()){
                    	String id = rs.getString("id");
                        String number = rs.getString("number");
                        String lastname = rs.getString("lastName");
                        String firstname = rs.getString("firstName");
                        String middlename = rs.getString("middlename");
                        String gender = rs.getString("Gender");
                        String contact = rs.getString("contact");
                        String email = rs.getString("email");
                        String course = rs.getString("course");
                        String yearlvl = rs.getString("YearLvl");
                        String tuition = rs.getString("Tuition");
                        String section = rs.getString("section");
                        String status = rs.getString("status");
                        String semester = rs.getString("semester");
                        
                        model.insertRow(table.getRowCount(),new 
Object[]{id,number,lastname,firstname,middlename,gender,contact,email,course,
	yearlvl,tuition,section,status,semester});
                    }
                    st.close();
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(null,ex.getMessage());
                }
            }
        
        });
        
        JButton btninsert = new JButton("Insert Record");
        
        btninsert.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
              try{
                constring();
                query = "INSERT INTO studinfo (number, lastname, firstname, middlename, gender, contact, email, course, yearlvl, tuition, section, status, semester) "
                        + "VALUES ('" + txtnumber.getText() + "','" + txtlname.getText() + "','" + txtfname.getText() + "','" +
                        txtmname.getText() + "','" + txtgen.getText() + "','" + txtnum.getText() +
                        "','" + txtemail.getText() + "','" + txtcourse.getText() + "','" + txtylevel.getText() + "','" +
                        txttuition.getText() + "','" + txtsec.getText() + "','" + txtstat.getText() +
                        "','" + txtsem.getText() + "')";

                st.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Succesfully added record");
                model.setNumRows(0);
                loadTable();
                st.close();
                txtnumber.setText("");
                txtlname.setText("");
                txtfname.setText("");
                
              }catch(Exception ex){
                JOptionPane.showMessageDialog(null,ex.getMessage());
              }
            }
        });
        String[][] data = {};
        String [] title = 
{"id","number","Last Name","First Name","Middle Name","Gender","Contact","Email","Course","Year Level","Tuition","Section","Status","Semester"};
        model = new DefaultTableModel(data,title);
        table = new JTable(model);
        table = new JTable(model) {
            @Override
            public boolean isOpaque() {
                return false;
            }
            
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2d = (Graphics2D) g.create();
                g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.8f));
                super.paintComponent(g2d);
                g2d.dispose();
            }
        };

        tablePanel = new JScrollPane(table);
        tablePanel.setOpaque(false);
        tablePanel.getViewport().setOpaque(false);
        

        
        table.getColumnModel().getColumn(0).setPreferredWidth(5);
        table.getColumnModel().getColumn(3).setPreferredWidth(3);
        
        
        

        
        

        lbltext.setBounds(950,25,400,30);
        lbltext.setForeground(Color.WHITE);
        lblnumber.setBounds(50,50,150,50);
        lblnumber.setForeground(Color.WHITE);
        lbllname.setBounds(50,80,150,50);
        lbllname.setForeground(Color.WHITE);
        lblfname.setBounds(50,110,150,50);
        lblfname.setForeground(Color.WHITE);
        lblmname.setBounds(50,140,150,50);
        lblmname.setForeground(Color.WHITE);
        lblgen.setBounds(50,170,150,50);
        lblgen.setForeground(Color.WHITE);
        lblnum.setBounds(50,205,150,50);
        lblnum.setForeground(Color.WHITE);
        lblemail.setBounds(50,235,150,50);
        lblemail.setForeground(Color.WHITE);
        lblcourse.setBounds(50,265,150,50);
        lblcourse.setForeground(Color.WHITE);
        lblylevel.setBounds(50,295,150,50);
        lblylevel.setForeground(Color.WHITE);
        lbltuition.setBounds(50,325,150,50);
        lbltuition.setForeground(Color.WHITE);
        lblsec.setBounds(50,355,150,50);
        lblsec.setForeground(Color.WHITE);
        lblstat.setBounds(50,385,150,50);
        lblstat.setForeground(Color.WHITE);
        lblsem.setBounds(50,415,150,50);
        lblsem.setForeground(Color.WHITE);
        txtnumber.setBounds(200,60,180,25);
        txtlname.setBounds(200,95,180,25);
        txtfname.setBounds(200,125,180,25);
        txtmname.setBounds(200,155,180,25);
        txtgen.setBounds(200,185,180,25);
        txtnum.setBounds(200,215,180,25);
        txtemail.setBounds(200,245,180,25);
        txtcourse.setBounds(200,275,180,25);
        txtylevel.setBounds(200,305,180,25);
        txttuition.setBounds(200,335,180,25);
        txtsec.setBounds(200,365,180,25);
        txtstat.setBounds(200,395,180,25);
        txtsem.setBounds(200,425,180,25);
        btninsert.setBounds(500,470,150,40);
        tablePanel.setBounds(400,100,1450,300);
        lblsearch.setBounds(900,50,150,50);
        lblsearch.setForeground(Color.WHITE);
        txtsearch.setBounds(1000,60,250,30);
        btninsert.setBounds(200, 470, 150, 40);
        btndelete.setBounds(1100, 470, 150, 40);
        panel.add(btndelete);
        
        
        
        panel.setBackground(Color.decode("#194d33"));
        panel.add(lbltext);
        panel.add(lblnumber);
        panel.add(lbllname);
        panel.add(lblfname);
        panel.add(lblmname);
        panel.add(lblgen);
        panel.add(lblnum);
        panel.add(lblemail);
        panel.add(lblcourse);
        panel.add(lblylevel);
        panel.add(lbltuition);
        panel.add(lblsec);
        panel.add(lblstat);
        panel.add(lblsem);
        panel.add(txtnumber);
        panel.add(txtlname);
        panel.add(txtfname);
        panel.add(txtmname);
        panel.add(txtgen);
        panel.add(txtnum);
        panel.add(txtemail);
        panel.add(txtcourse);
        panel.add(txtylevel);
        panel.add(txttuition);
        panel.add(txtsec);
        panel.add(txtstat);
        panel.add(txtsem);
        panel.add(btninsert);
        panel.add(tablePanel);
        panel.add(lblsearch);
        panel.add(txtsearch);
        
        
        
        
        
        
        
        loadTable();
    }
        private void deleteRecord(String id) {
            try {
                constring();
                query = "DELETE FROM studinfo WHERE id = '" + id + "'";
                st.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Record deleted successfully.");
                model.removeRow(table.getSelectedRow());
                st.close();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }
    
}