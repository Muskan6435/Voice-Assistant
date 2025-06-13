import edu.cmu.sphinx.api.*;
import java.io.*;

public class VoiceApp extends javax.swing.JFrame {
    private LiveSpeechRecognizer recognizer;
    private boolean recognizing = false;
    private Thread recognitionThread;
    
    public VoiceApp() {
        initComponents();
        setLocationRelativeTo(null);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ta1 = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        label = new javax.swing.JLabel();
        b1 = new javax.swing.JButton();
        b2 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 0, 51));

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 3, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("                                        Voice Assistant");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 204, 255));

        ta1.setColumns(20);
        ta1.setRows(5);
        jScrollPane1.setViewportView(ta1);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Commands- ");

        label.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        label.setText("Status: Stopped");

        b1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        b1.setText("Start");
        b1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b1ActionPerformed(evt);
            }
        });

        b2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        b2.setText("Stop");
        b2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b2ActionPerformed(evt);
            }
        });

        jComboBox1.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "OPEN NOTEPAD ", "CLOSE NOTEPAD", "OPEN CHROME", "CLOSE CHROME", "OPEN NETBEANS", "CLOSE NETBEANS", "SYSTEM SHUTDOWN", "SYSTEM RESTART" }));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("List of Commands:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(b1)
                        .addGap(144, 144, 144)
                        .addComponent(label)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 151, Short.MAX_VALUE)
                        .addComponent(b2)
                        .addGap(28, 28, 28))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label)
                    .addComponent(b1)
                    .addComponent(b2))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void b1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b1ActionPerformed
        startRecognition();
    }//GEN-LAST:event_b1ActionPerformed

    private void b2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b2ActionPerformed
        stopRecognition();
    }//GEN-LAST:event_b2ActionPerformed
    
    private void initRecognizer() throws IOException{
        Configuration config = new Configuration();
        config.setAcousticModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us");  //pronunciation 
        
        // these paths are generated from http://www.speech.cs.cmu.edu/tools/lmtool-new.html and by choosing the
        // text file we can generate the paths according to our commands.
        config.setDictionaryPath("resource:/resources/9285.dic");  //phonemes are defined
        config.setLanguageModelPath("resource:/resources/9285.lm");  //sequence of the words
        
        recognizer = new LiveSpeechRecognizer(config);
        
    }
    
    private void startRecognition(){
        if(recognizing){
            System.out.println("Already recognizing.");
            return;
        }
        
        try{
            if(recognizer==null){
            initRecognizer();
        }
        recognizer.startRecognition(true);
        recognizing = true;
        
        b1.setEnabled(false);
        b2.setEnabled(true);
        label.setText("Status: Listening");
        
        recognitionThread = new Thread(()->{execRecognition();});
        recognitionThread.start();
        }catch(IOException ex){
            ex.printStackTrace();
        }
    }
    
    private void execRecognition(){
        try{
            SpeechResult speechResult;
            while(recognizing && (speechResult=recognizer.getResult())!=null){
                String voiceCommand = speechResult.getHypothesis();
                System.out.println("Voice Commands: " + voiceCommand);
                
                ta1.append("Voice Command: "+voiceCommand + "\n");
                
                try{
                    if(voiceCommand.equalsIgnoreCase("Open notepad")){
                        new ProcessBuilder("cmd.exe","/c","start","notepad.exe").start();
                    }else if(voiceCommand.equalsIgnoreCase("Close notepad")){
                        new ProcessBuilder("taskkill", "/F","/IM","notepad.exe").start();
                        
                    }else if(voiceCommand.equalsIgnoreCase("Open Chrome")){
                        new ProcessBuilder("cmd.exe", "/c","start","chrome.exe").start();
                    }else if(voiceCommand.equalsIgnoreCase("Close Chrome")){
                        new ProcessBuilder("taskkill", "/F","/IM","chrome.exe").start();
                        
                    }else if(voiceCommand.equalsIgnoreCase("Open Netbeans")){
                        new ProcessBuilder("C:\\Program Files\\NetBeans-24\\netbeans\\bin\\netbeans64.exe").start();
                       // \\is used cause when used \new folder, the IDE takes it as \n and returns code for next line.
                       // \\ makes it as single backslash.
                       // \\ is an escape sequence when converts it into single backslash 
                    }else if(voiceCommand.equalsIgnoreCase("Close Netbeans")){
                        new ProcessBuilder("taskkill", "/F","/IM","netbeans64.exe").start();
                        
                    }else if(voiceCommand.equalsIgnoreCase("System Shut down")){
                        new ProcessBuilder("shutdown", "-s","-t","0").start();
                        
                    }else if(voiceCommand.equalsIgnoreCase("System Restart")){
                        new ProcessBuilder("shutdown", "-r","-t","0").start();
                    }
                    else{
                        System.out.println("Unrecognized Command");
                    }
                }catch(Exception ex){
                    ex.printStackTrace();
                }
            }
        }catch(Exception ex){
            
        }
    }
    private void stopRecognition(){
        if(!recognizing){
            System.out.println("Recognition Already Stopped.");
            return;
        }
        recognizing = false;
        try{
            if(recognitionThread!=null && recognitionThread.isAlive()){
                recognitionThread.join();
            }
            if(recognizer!=null){
                recognizer.stopRecognition();
            }
        }catch(InterruptedException ex){
            Thread.currentThread().interrupt();
            ex.printStackTrace();
        }
        
        b1.setEnabled(true);
        b2.setEnabled(false);
        label.setText("Status: Stopped");
    }
    
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VoiceApp().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b1;
    private javax.swing.JButton b2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label;
    private javax.swing.JTextArea ta1;
    // End of variables declaration//GEN-END:variables
}
