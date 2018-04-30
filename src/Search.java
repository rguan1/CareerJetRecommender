import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import javax.swing.*;

/**
 * This class represents the search screen of the search engine. Let's user input the title,
 * location, and keywords in order to find the top 5 jobs based on the search inputs.
 *
 * @author dzungnguyen
 */
public class Search extends javax.swing.JFrame {
//    private Map<String, Set<String>> searchCriteria; 
    /**
     * Creates new form Search
     */
    public Search() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jobEntered = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        locationEntered = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        keywordsEntered = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jobEntered.setForeground(new java.awt.Color(102, 102, 102));
        jobEntered.setText("computer science intern");
        jobEntered.setToolTipText("");
        jobEntered.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        searchButton.setText("Search");
        searchButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchButtonMouseClicked(evt);
            }
        });

        jLabel1.setText("Job title:");

        jLabel2.setText("Location:");

        locationEntered.setForeground(new java.awt.Color(102, 102, 102));
        locationEntered.setText("new york city");
        locationEntered.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel4.setFont(new java.awt.Font("Lucida Grande", 2, 13)); // NOI18N
        jLabel4.setText("Separate your keywords with comas.");

        jLabel7.setText("Keywords:");

        keywordsEntered.setForeground(new java.awt.Color(102, 102, 102));
        keywordsEntered.setText("java, IoT, full-stack, python");
        keywordsEntered.setToolTipText("");
        keywordsEntered.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel1.setBackground(new java.awt.Color(50, 132, 207));

        jLabel5.setFont(new java.awt.Font("Lucida Grande", 0, 40)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("careermatch");

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Because tinder won't get you a job.");
        jLabel6.setToolTipText("");

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-matches.png"))); // NOI18N

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-home_filled.png"))); // NOI18N
        jLabel3.setText("HOME");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(17, 17, 17))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel8)))
                .addContainerGap(34, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(14, 14, 14))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(140, 140, 140)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(locationEntered, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jobEntered, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(keywordsEntered, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(297, 297, 297)
                        .addComponent(searchButton)))
                .addContainerGap(186, Short.MAX_VALUE))
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jobEntered, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(keywordsEntered, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(locationEntered, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(27, 27, 27)
                .addComponent(searchButton)
                .addGap(19, 19, 19))
        );

        getContentPane().add(jPanel2, java.awt.BorderLayout.PAGE_START);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * When the search button is clicked, user's query entered in the keywords and 
     * location fields are recorded, processed (converted to lowercase, get rid of trailing 
     * white spaces) and placed inside the category map. 
     * 
     * @param evt the mouse clicked event
     */
    private void searchButtonMouseClicked(java.awt.event.MouseEvent evt) {
        
        //Turns off apache warnings
        java.util.logging.Logger.getLogger("com.gargoylesoftware").
                setLevel(Level.OFF); 
        System.setProperty("org.apache.commons.logging.Log", 
                "org.apache.commons.logging.impl.NoOpLog");
       

        String title = jobEntered.getText().toLowerCase(); 
        String location = locationEntered.getText().toLowerCase();
        String keywords = keywordsEntered.getText().toLowerCase(); 
         
        setTitle("Loading...");
        setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        setFocusable(false);

        JobPost query = new JobPost(keywords, location, title); 
              
        APICall singleScrape = new APICall();
        Set<JobPost> setOfJobs = singleScrape.callAPI(title,
                location, "date", "10");
        
        List<JobPost> listOfJobs = new ArrayList<>(setOfJobs);
        listOfJobs.add(query);        
        JobCorpus corpus = new JobCorpus(listOfJobs); 
        VectorSpaceModel model = new VectorSpaceModel(corpus); 
        ArrayList<JobPost> searchResults = new ArrayList<>();
        for (int i = 0; i < Math.min(5, listOfJobs.size()); i++) {
            JobPost job = listOfJobs.get(i); 
            if (job.getJobLink() != null) {
                double cosineSimValue = model.cosineSimilarity(job, query); 
                job.setCosineSimilarity(cosineSimValue);
                searchResults.add(job);  
            }   
        }
        if (searchResults.isEmpty()) {
            SplashScreen warning = new SplashScreen();
            warning.jLabel1.setText("No Job Found. Please try again.");
            warning.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            warning.setLocationRelativeTo(this);
            warning.setVisible(true);
            Search newSearch = new Search();
            newSearch.setLocationRelativeTo(warning);
            newSearch.setVisible(true);
            warning.toFront();
            setCursor(Cursor.getDefaultCursor());
            return; 
        }
        Collections.sort(searchResults);
        this.dispose();
        makeTopMatchesScreen(searchResults);  
    }

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {
        this.dispose();
        new HomePage().setVisible(true); 
    }
    
    /**
     * Display the top 5 search results.
     * 
     * @param searchResults list of results found by the search engine
     */
    private void makeTopMatchesScreen(ArrayList<JobPost> searchResults) {
        TopMatches topResults = new TopMatches();
    
        int i = 1; 
        for (JobPost job : searchResults) {
            String result = i + ". " + job.getTitle() + ": " + "\n" +
                "Date Posted: " + searchResults.get(0).getDate() + "\n" +
                "Location: " + searchResults.get(0).getLocations() + "\n" +
                "Company: " + searchResults.get(0).getCompany() + "\n" +
                "URL: " + searchResults.get(0).getJobLink() + "\n" + "\n";
            i++;
            topResults.jTextArea1.append(result);
        }
     
        topResults.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);       
        topResults.pack();
        topResults.setVisible(true);
       
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jobEntered;
    private javax.swing.JTextField keywordsEntered;
    private javax.swing.JTextField locationEntered;
    private javax.swing.JButton searchButton;
    // End of variables declaration//GEN-END:variables
}
