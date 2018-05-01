import java.awt.Cursor;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import javax.imageio.ImageIO;
import javax.swing.JFrame;

/**
 * The search page of the GUI, which allows users to input a set of query to
 * use the Vector-Space model to finds top jobs.
 *
 * @author dzungnguyen
 */
public class Search extends javax.swing.JFrame {
    /**
     * Creates new form Search
     */
    private List<JobPost> results;
    //The number of matched results to display to the user
    private int numResultsDisplay;

    public Search() {
        try {
            initComponents();
            results = new ArrayList<JobPost>();
            numResultsDisplay = 0;
        } catch (IOException e) {
            System.out.println ("invalid image path");
        }
    }

    /**
     * Initialize the GUI.
     */
    @SuppressWarnings("unchecked")
    private void initComponents() throws IOException {

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
        sortByDropDown = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        numResultsDropDown = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jobEntered.setForeground(new java.awt.Color(102, 102, 102));
        jobEntered.setText("Computer Science Intern");
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
        locationEntered.setText("New York");
        locationEntered.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel4.setFont(new java.awt.Font("Lucida Grande", 2, 13)); // NOI18N
        jLabel4.setText("Separate your keywords with comas.");

        jLabel7.setText("Keywords:");

        keywordsEntered.setForeground(new java.awt.Color(102, 102, 102));
        keywordsEntered.setText("Machine learning, Java, Google");
        keywordsEntered.setToolTipText("");
        keywordsEntered.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel1.setBackground(new java.awt.Color(50, 132, 207));

        jLabel5.setFont(new java.awt.Font("Lucida Grande", 0, 40)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("careermatch");

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Because tinder won't get you a job.");
        jLabel6.setToolTipText("");

        BufferedImage buffImage2 = ImageIO.read(new File("Resources/icons8-matches.png"));
        jLabel8.setIcon(new javax.swing.ImageIcon(buffImage2));
        ; // NOI18N

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));

        BufferedImage buffImage3 = ImageIO.read(new File("Resources/icons8-home_filled.png"));
        jLabel3.setIcon(new javax.swing.ImageIcon(buffImage3)); // NOI18N
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
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing
                                        .GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel5)
                                        .addComponent(jLabel6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement
                                        .UNRELATED)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement
                                        .RELATED, 179, Short.MAX_VALUE)
                                .addComponent(jLabel3)
                                .addGap(17, 17, 17))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing
                                        .GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(45, 45, 45)
                                                .addComponent(jLabel5, javax.swing.GroupLayout
                                                        .PREFERRED_SIZE, 36, javax.swing
                                                        .GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle
                                                        .ComponentPlacement.RELATED)
                                                .addComponent(jLabel6))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(19, 19, 19)
                                                .addComponent(jLabel8)))
                                .addContainerGap(34, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout
                                .createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel3)
                                .addGap(14, 14, 14))
        );

        sortByDropDown.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Date",
                "Salary"}));

        jLabel9.setText("Sort by:");

        numResultsDropDown.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"5",
                "10", "15", "20"}));

        jLabel10.setText("Number to return:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax
                                .swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout
                                .DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(140, 140, 140)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing
                                        .GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel4)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGroup(jPanel2Layout.createParallelGroup(javax
                                                        .swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel2Layout
                                                                .createSequentialGroup()
                                                                .addGroup(jPanel2Layout
                                                                        .createParallelGroup
                                                                                (javax.swing
                                                                                        .GroupLayout.Alignment.LEADING)
                                                                        .addGroup(jPanel2Layout
                                                                                .createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                .addComponent
                                                                                        (jLabel2,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent
                                                                                        (jLabel1,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent
                                                                                        (jLabel7,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                        .addComponent(jLabel9))
                                                                .addGap(47, 47, 47))
                                                        .addGroup(javax.swing.GroupLayout
                                                                .Alignment.TRAILING,
                                                                jPanel2Layout
                                                                        .createSequentialGroup()
                                                                .addComponent(jLabel10)
                                                                .addPreferredGap(javax.swing
                                                                        .LayoutStyle
                                                                        .ComponentPlacement
                                                                        .RELATED)))
                                                .addGroup(jPanel2Layout.createParallelGroup(javax
                                                        .swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(locationEntered, javax
                                                                .swing.GroupLayout
                                                                .PREFERRED_SIZE, 272, javax.swing
                                                                .GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jobEntered, javax.swing
                                                                .GroupLayout.PREFERRED_SIZE, 272,
                                                                javax.swing.GroupLayout
                                                                        .PREFERRED_SIZE)
                                                        .addComponent(keywordsEntered, javax
                                                                .swing.GroupLayout
                                                                .PREFERRED_SIZE, 272, javax.swing
                                                                .GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(jPanel2Layout
                                                                .createParallelGroup(javax.swing
                                                                        .GroupLayout.Alignment
                                                                        .TRAILING, false)
                                                                .addComponent(numResultsDropDown,
                                                                        javax.swing.GroupLayout
                                                                                .Alignment
                                                                                .LEADING, 0,
                                                                        javax.swing.GroupLayout
                                                                                .DEFAULT_SIZE,
                                                                        Short.MAX_VALUE)
                                                                .addComponent(sortByDropDown,
                                                                        javax.swing.GroupLayout
                                                                                .Alignment
                                                                                .LEADING, 0,
                                                                        javax.swing.GroupLayout
                                                                                .DEFAULT_SIZE,
                                                                        Short.MAX_VALUE)))))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short
                                        .MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout
                                .createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short
                                        .MAX_VALUE)
                                .addComponent(searchButton)
                                .addGap(290, 290, 290))
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing
                                                .GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement
                                        .UNRELATED)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement
                                        .RELATED, 29, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing
                                        .GroupLayout.Alignment.BASELINE)
                                        .addComponent(jobEntered, javax.swing.GroupLayout
                                                .PREFERRED_SIZE, 34, javax.swing.GroupLayout
                                                .PREFERRED_SIZE)
                                        .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement
                                        .RELATED, 22, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing
                                        .GroupLayout.Alignment.BASELINE)
                                        .addComponent(keywordsEntered, javax.swing.GroupLayout
                                                .PREFERRED_SIZE, 34, javax.swing.GroupLayout
                                                .PREFERRED_SIZE)
                                        .addComponent(jLabel7))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing
                                        .GroupLayout.Alignment.BASELINE)
                                        .addComponent(locationEntered, javax.swing.GroupLayout
                                                .PREFERRED_SIZE, 34, javax.swing.GroupLayout
                                                .PREFERRED_SIZE)
                                        .addComponent(jLabel2))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing
                                        .GroupLayout.Alignment.BASELINE)
                                        .addComponent(sortByDropDown, javax.swing.GroupLayout
                                                .PREFERRED_SIZE, javax.swing.GroupLayout
                                                .DEFAULT_SIZE, javax.swing.GroupLayout
                                                .PREFERRED_SIZE)
                                        .addComponent(jLabel9))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing
                                        .GroupLayout.Alignment.BASELINE)
                                        .addComponent(numResultsDropDown, javax.swing.GroupLayout
                                                .PREFERRED_SIZE, javax.swing.GroupLayout
                                                .DEFAULT_SIZE, javax.swing.GroupLayout
                                                .PREFERRED_SIZE)
                                        .addComponent(jLabel10))
                                .addGap(18, 18, 18)
                                .addComponent(searchButton)
                                .addGap(45, 45, 45))
        );

        getContentPane().add(jPanel2, java.awt.BorderLayout.PAGE_START);

        pack();
    }// </editor-fold>

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
        String sortBy = sortByDropDown.getSelectedItem().toString();
        numResultsDisplay = Integer.valueOf
                (numResultsDropDown.getSelectedItem().toString());

        setTitle("Loading...");
        setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        setFocusable(false);

        JobPost query = new JobPost(keywords, location, title);

        //Scraping the API for 20 jobs
        APICall singleScrape = new APICall();
        Set<JobPost> setOfJobs = singleScrape.callAPI(title,
                location, sortBy, "20");

        //Use the vector-space model to find the top 5 (or less) search results
        List<JobPost> listOfJobs = new ArrayList<>(setOfJobs);
        listOfJobs.add(query);
        JobCorpus corpus = new JobCorpus(listOfJobs);
        VectorSpaceModel model = new VectorSpaceModel(corpus);
        ArrayList<JobPost> searchResults = new ArrayList<>();
        for (int i = 0; i < Math.min(numResultsDisplay, listOfJobs.size()); i++) {
            JobPost job = listOfJobs.get(i);
            if (job.getJobLink() != null) {
                double cosineSimValue = model.cosineSimilarity(job, query);
                job.setCosineSimilarity(cosineSimValue);
                searchResults.add(job);
            }
        }
        if (searchResults.isEmpty()) {
            if (searchResults.isEmpty()) {
                SplashScreen warning = new SplashScreen();
                warning.jLabel1.setText("No Job Found. Please try again.");
                warning.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                warning.setLocationRelativeTo(this);
                warning.pack();
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
        Collections.sort(searchResults);
        //Display the search results
        makeTopMatchesScreen(searchResults);
    }

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {
        this.dispose();
        new HomePage().setVisible(true);
    }

    /**
     * Display the top n search results (n = number of results users chose to display)
     *
     * @param searchResults
     */
    private void makeTopMatchesScreen(ArrayList<JobPost> searchResults) {
        TopMatches topResults = new TopMatches(searchResults);

        int i = 0;
        for (JobPost job : searchResults) {
            String result = Integer.toString(i) + ". " + job.getTitle() + ": " + "\n" +
                    "Date Posted: " + searchResults.get(i).getDate() + "\n" +
                    "Location: " + searchResults.get(i).getLocations() + "\n" +
                    "Company: " + searchResults.get(i).getCompany() + "\n" +
                    "URL: " + searchResults.get(i).getJobLink() + "\n" + "\n";
            i++;
            topResults.display.append(result);
        }

        topResults.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        topResults.pack();
        topResults.setVisible(true);
    }


    // Variables declaration - do not modify
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jobEntered;
    private javax.swing.JTextField keywordsEntered;
    private javax.swing.JTextField locationEntered;
    private javax.swing.JComboBox<String> numResultsDropDown;
    private javax.swing.JButton searchButton;
    private javax.swing.JComboBox<String> sortByDropDown;
    // End of variables declaration
}
