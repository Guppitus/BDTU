package BDTU;

import java.awt.EventQueue;
import java.io.File;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;



/**
 * GUI Implementation
 *
 * Created by Jack Lavallee, Joe Russel, and Seth K. Lunn on 12/5/16.
 *
 */
public class BDTUGUI {


        private JFrame frmBdtu;
        private JTextField txtNameOfFile;
        private JTextField txtSourceFolderfile;
        private JTextField txtDestinationFolder;
        private JTable table;
        private JTextField txtLengthOfTime;
        private JList list;


        /**
         * Launch the application.
         */
        public static void main(String[] args) {
            BDTUSerialization.deserialize();
            EventQueue.invokeLater(new Runnable() {
                public void run() {
                    try {
                        BDTUGUI window = new BDTUGUI();
                        window.frmBdtu.setVisible(true);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            BDTUSerialization.serialize(BDTUArchival.archivalTable);
        }


        /**
         * Create the application.
         */
        public BDTUGUI() {
            initialize();
        }


        public void FolderChooser1(){
            String source;
            JFileChooser jFileChooser = new JFileChooser();
            jFileChooser.setCurrentDirectory(new File("/User/alvinreyes"));
            jFileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                int result = jFileChooser.showOpenDialog(new JFrame());
                if (result == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = jFileChooser.getSelectedFile();
                    source = selectedFile.getAbsolutePath();
                    txtSourceFolderfile.setText(source);
                    System.out.println("Selected file: " + selectedFile.getAbsolutePath());
                }
            }
    public void FolderChooser2(){
        String destination;
        JFileChooser jFileChooser = new JFileChooser();
        jFileChooser.setCurrentDirectory(new File("/User/alvinreyes"));
        jFileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int result = jFileChooser.showOpenDialog(new JFrame());
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = jFileChooser.getSelectedFile();
            destination = selectedFile.getAbsolutePath();
            txtDestinationFolder.setText(destination);
            System.out.println("Selected file: " + selectedFile.getAbsolutePath());
        }
    }


    /**
         *
         * @param path
         * @return
         */
        protected static ImageIcon createImageIcon(String path) {
            java.net.URL imgURL = BDTUGUI.class.getResource(path);
            if (imgURL != null) {
                return new ImageIcon(imgURL);
            } else {
                System.err.println("Couldn't find file: " + path);
                return null;
            }
        }


        /**
         * Initialize the contents of the frame.
         */
        private void initialize() {
            frmBdtu = new JFrame();
            frmBdtu.setTitle("Backup Data To Unit");
            frmBdtu.setBounds(100, 100, 799, 471);
            frmBdtu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frmBdtu.getContentPane().setLayout(null);

            JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
            tabbedPane.setBounds(6, 24, 787, 419);
            frmBdtu.getContentPane().add(tabbedPane);

            JPanel Restore = new JPanel();
            tabbedPane.addTab("Restore", null, Restore, null);
            Restore.setLayout(null);
            JPanel tablePanel = new JPanel();

            tablePanel.setBackground(Color.WHITE);

            tablePanel.setBounds(6, 107, 754, 170);

            Restore.add(tablePanel);

            tablePanel.setLayout(null);

            JPanel panel_2 = new JPanel();
            panel_2.setBackground(Color.WHITE);
            panel_2.setBounds(221, 39, 311, 56);
            Restore.add(panel_2);
            panel_2.setLayout(null);

            JLabel lblLogo_1 = new JLabel("Logo", SwingConstants.CENTER);
            lblLogo_1.setBounds(120, 6, 61, 44);
            panel_2.add(lblLogo_1);



            JPanel Backup = new JPanel();
            tabbedPane.addTab("Backup", null, Backup, null);
            Backup.setLayout(null);


            txtNameOfFile = new JTextField(10);
            txtNameOfFile.setText("Name of Backup");
            txtNameOfFile.setBounds(30, 50, 200, 26);
            Backup.add(txtNameOfFile);
            txtNameOfFile.setColumns(10);

            txtSourceFolderfile = new JTextField();
            txtSourceFolderfile.setText("Source Folder/File");
            txtSourceFolderfile.setBounds(30, 100, 200, 26);

            Backup.add(txtSourceFolderfile);
            txtSourceFolderfile.setColumns(10);

            JButton btnNewButton_2 = new JButton("...");
            btnNewButton_2.setBounds(242, 100, 40, 29);
            Backup.add(btnNewButton_2);

            btnNewButton_2.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    FolderChooser1();
                }
            });

            txtDestinationFolder = new JTextField();
            txtDestinationFolder.setText("Destination Folder");
            txtDestinationFolder.setBounds(30, 150, 200, 26);
            Backup.add(txtDestinationFolder);
           // txtDestinationFolder.setColumns(10);




            JButton btnNewButton_3 = new JButton("...");
            btnNewButton_3.setBounds(242, 150, 40, 29);
            Backup.add(btnNewButton_3);

            btnNewButton_3.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    FolderChooser2();
                }
            });

            JPanel panel = new JPanel();
            panel.setBackground(Color.WHITE);
            panel.setBounds(30, 220, 350, 133);
            Backup.add(panel);
            panel.setLayout(null);

            JRadioButton rdbtnEncrypt = new JRadioButton("Encrypt");
            rdbtnEncrypt.setBounds(6, 10, 100, 23);
            panel.add(rdbtnEncrypt);

            JRadioButton rdbtnNetwork = new JRadioButton("Network");
            rdbtnNetwork.setBounds(6, 50, 100, 23);
            panel.add(rdbtnNetwork);

            JRadioButton rdbtnSession = new JRadioButton("Session   |");
            rdbtnSession.setBounds(6, 90, 100, 23);
            panel.add(rdbtnSession);

            txtLengthOfTime = new JTextField();
            txtLengthOfTime.setBounds(230, 89, 53, 26);
            panel.add(txtLengthOfTime);
            txtLengthOfTime.setColumns(10);

            JLabel lblLengthOfTime = new JLabel("Length of Time");
            lblLengthOfTime.setBounds(118, 94, 100, 16);
            panel.add(lblLengthOfTime);

            JLabel lblOptions = new JLabel("Options");
            lblOptions.setBounds(50, 200, 61, 16);
            Backup.add(lblOptions);

            JButton btnNewButton = new JButton("Backup");
            btnNewButton.setBounds(524, 220, 173, 65);
            Backup.add(btnNewButton);

            JButton btnNewButton_1 = new JButton("Clear/Cancel");
            btnNewButton_1.setBounds(555, 297, 117, 37);
            Backup.add(btnNewButton_1);

            btnNewButton_1.addActionListener(new ClearText());

            btnNewButton.addActionListener(new RunBackupListener());


            JPanel panel_1 = new JPanel();
            panel_1.setBackground(Color.WHITE);
            panel_1.setBounds(480, 50, 259, 148);
            Backup.add(panel_1);
            panel_1.setLayout(null);

            JLabel lblLogo = new JLabel("Logo", SwingConstants.CENTER);
            lblLogo.setBounds(100, 60, 61, 16);
            panel_1.add(lblLogo);

            JPanel Settings = new JPanel();
            tabbedPane.addTab("Settings", null, Settings, null);

            String[] data = {};

            list = new JList(data);
            list.setFont(new Font("Lucida Grande", Font.PLAIN, 18));

            list.setVisibleRowCount(5);
            list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

            list.setBounds(154, 16, 444, 148);

            DefaultListCellRenderer renderer = (DefaultListCellRenderer) list.getCellRenderer();
            renderer.setHorizontalAlignment(SwingConstants.CENTER);

            list.setListData(BDTUArchival.archivalTable.keySet().toArray());
            System.out.println(list.toString());

            tablePanel.add(list);

            JButton restoreSubmit = new JButton("Restore");

            restoreSubmit.setBounds(322, 289, 117, 45);

            Restore.add(restoreSubmit);

            restoreSubmit.addActionListener(new RestoreListener());


            JButton clearRestore = new JButton("Clear/Cancel");

            clearRestore.setBounds(322, 338, 117, 29);

            Restore.add(clearRestore);


        }

        private class RestoreListener implements ActionListener{

            public void actionPerformed(ActionEvent e) {

               // int list2 = list.getSelectedIndex();
                String restoreName = (String) list.getSelectedValue();
                BDTURun.restore(restoreName);

                list.setListData(BDTUArchival.archivalTable.keySet().toArray());

            }
        }

        private class RunBackupListener implements ActionListener{

            public void actionPerformed(ActionEvent e) {

                if(txtNameOfFile.getText().equals("") | txtSourceFolderfile.getText().equals("")
                        | txtDestinationFolder.getText().equals("") ){
                    return;
                }

                String name = txtNameOfFile.getText();
                String source = txtSourceFolderfile.getText();
                String destination = txtDestinationFolder.getText();
                BDTURun.archiveBackup(name, source, destination);

                list.setListData(BDTUArchival.archivalTable.keySet().toArray());

            }
        }
        private class ClearText implements ActionListener{

            public void actionPerformed(ActionEvent e) {
                    txtNameOfFile.setText("");
                    txtSourceFolderfile.setText("");
                    txtDestinationFolder.setText("");
            }
        }

    }





