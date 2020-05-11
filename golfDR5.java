// Name  : Dhruv 
// ID    : 597327
// Program : Golf - Card Game 
// Type: GUI
// Description : Golf is a 2 player card game played with 6 cards each. 
//          RULES GO HERE 
//                   
// 

import java.awt.*;
import javax.swing.border.Border;
import javax.swing.JButton;           
import javax.swing.*;
import java.awt.Color;

import java.awt.event.*;  // Needed for ActionListener

//////////////////////////////////////////////////////// class golfDR
class golfDR5 extends JFrame {
  //======================================================== constants +
  //=============================================== instance variables (Global)
  
  
  static int[] deck = new int[52]; //the 52 cards in the deck
  static int[] deckCardArray = new int[2]; //the top card placed up 
  static int[] usedCards = new int[53]; //cards that have been played already 
  static int[] playerHand1 = new int[6]; //player 2 cards
  static int[] playerHand2 = new int[6]; //player 1 cards 
  static int[] discard = new int[2]; //discard pile card 
  //use the convert array to help when calculating points 
  //switch the convert array into a a nested loop to fill array 
  static int[] convert = {0,1,1,1,1,2,2,2,2,3,3,3,3,4,4,4,4,5,5,5,5,6,6,6,6,7,7,7,7,8,8,8,8,9,9,9,9,10,10,10,10,11,11,11,11,12,12,12,12,13,13,13,13}; //use this array to convert the numbers from 1 to 52 to a number from 1 to 13 
  static JButton a1,a2,a3,a4,a5,a6,b1,b2,b3,b4,b5,b6; //the 12 played cards 
  static JLabel deckCard,message,hideA,hideB,player1Name,p1I,player2Name,scoreLabel,dis,dis2,lblNewLabel,placeHolder,win1,animate;
  static JButton start, newDeckCard,flipLast,discardPileSwitch,flipLast2,goToScore,button,goHome; 
  static JPanel content,home,rulesPage,morePages,score,options; //the different screens 
  static int turn;  //turn counter 
  Border border = BorderFactory.createLineBorder(Color.BLUE, 5); //thin blue border
  Border border2 = BorderFactory.createLineBorder(Color.BLACK, 5); //thick black border 
  static String allow,discardAllow;
  static String allowB = "yes"; 
  static JTextField textField1, textField2;                             
  static golfDR5 window; //main window
  
  
  //====================================================== constructor
  public golfDR5() {
    
    //set the window to a fixed size 
    setResizable(false);
     
    //create the different panels for each screen in the game 
    //set the layout to null allowing each element to be used with the absolute layout 
    
    
//    main home screen 
    home = new JPanel ();
    home.setLayout (null);
    
    //game screen
    content = new JPanel();
    content.setLayout(null);
    content.setBackground(new Color (46, 204, 113));
    content.setBorder(border2);
    
    //options screen
    options = new JPanel();
    options.setLayout(null);
    
    //more info screen 
    morePages = new JPanel ();
    morePages.setLayout (null);
    
    //rules page 
    rulesPage = new JPanel ();
    rulesPage.setLayout (null);
    
    //score page 
    score = new JPanel ();
    score.setLayout (null);
    
    
    
    //score page elements  
    
    JLabel scoreTitle = new JLabel("Top 5 Lowest Scores");
    //new feature - center align the text in JLabels 
    scoreTitle.setHorizontalAlignment(SwingConstants.CENTER);
    //change font (font name, type, font size) 
    scoreTitle.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 37));
    //.setBounds(x cordinate from left, y cordinate from the top, width, length)
    scoreTitle.setBounds(250, 40, 500, 71);
    score.add(scoreTitle);
    
    
    
    
    
    //rules page
    
    //new feature - implement a scroll pane - a textfeild with scroll bar 
    
    JTextArea display = new JTextArea ( 50, 0 ); //hieght and width of scroll pane 
    display.setEditable ( false ); // set textArea non-editable by user 
    //the rules are below - \n for a new line 
    display.setText("RULES: \n  Switch cards from the deck and discard pile to get pairs. Each vertical pair will cancell out in points and at the end all of the cards will be added up \n  and then the player with the lowest score will win. All vertical pairs will be removed from the score. \n\nNote: The King (K) will be counted at 0 points");
    JScrollPane scroll = new JScrollPane ( display ); //show the JTextArea display in the JScrollPane
    scroll.setVerticalScrollBarPolicy ( ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS); //only have the vertical scroll bars
    scroll.setBounds(40,100,900,400); 
    rulesPage.add(scroll);
    
    JLabel ruleTitle = new JLabel ("Rules",SwingConstants.CENTER); //center text 
    ruleTitle.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 70));
    ruleTitle.setBounds(0, 5, 1000, 118);
    rulesPage.add(ruleTitle);
    
    
    JButton goHome = new JButton ("Go Home");
    goHome.setBounds(0,0,100,40);
    rulesPage.add(goHome);
    //action listener class has what will happen with goHome button is clicked
    goHome.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        home.setVisible(true);
        //set the pain content pane with the home JFrame 
        setContentPane(home);
      }
    });
    
    //more page
    
    
    JButton goHome1 = new JButton ("Go Home");
    goHome1.setBounds(0,0,100,40);
    goHome1.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        home.setVisible(true);
        setContentPane(home);
      }
    });
    morePages.add(goHome1);
    
    //each of the following more'x' buttons will result in the placeholder changing 
    JButton more1 = new JButton("1");
    more1.setBounds(34, 47, 247, 70);
    more1.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        
      }});
    morePages.add(more1);
    
    JButton more2 = new JButton("2");
    more2.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        
      }                  
    });
    more2.setBounds(34, 154, 247, 70);
    morePages.add(more2);
    
    JButton more3 = new JButton("3");
    more3.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        
      }
    });
    more3.setBounds(34, 261, 247, 70);
    morePages.add(more3);
    
    JButton more4 = new JButton("4");
    more4.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        
      }
    });
    more4.setBounds(34, 368, 247, 70);
    morePages.add(more4);
    
    JButton more5 = new JButton("5");
    more5.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        
      }
    });
    more5.setBounds(34, 475, 247, 70);
    morePages.add(more5);
    
    //placeholder is the area that will be changed when each of the more"x" is clicked 
    placeHolder = new JLabel("placeholder");
    placeHolder.setBounds(337, 0, 647, 561);
    morePages.add(placeHolder);
    
    //seperation block 
    JPanel blackBorder = new JPanel();
    blackBorder.setBackground(Color.BLACK);
    blackBorder.setBounds(315, 0, 22, 561);
    morePages.add(blackBorder);
    
    
    //home page   
    
    JButton goHome7 = new JButton ("End Game");
    goHome7.setBounds(0,0,100,40);
    content.add(goHome7); 
    //action listener class has what will happen with goHome button is clicked
    goHome7.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        home.setVisible(true);
        //set the pain content pane with the home JFrame 
        setContentPane(home);
      }
    });
    
    JButton rules = new JButton("Rules");
    rules.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 20));
    rules.setBounds(20, 250, 238, 55);
    rules.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        //go to the rules page
        home.setVisible(false);
        rulesPage.setVisible(true);
        setContentPane(rulesPage);
      }
    });
    home.add(rules);
    
    JButton highScore = new JButton("Options");
    highScore.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 20));
    highScore.setBounds(20, 390, 238, 55);
    highScore.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        //go to options page
        home.setVisible(false);
        options.setVisible(true);
        setContentPane(options);
      }
    });
    home.add(highScore);
    
    JButton more = new JButton("More");
    more.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 20));
    more.setBounds(20, 320, 238, 55);
    more.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        //go to more info page
        home.setVisible(false);
        morePages.setVisible(true);
        setContentPane(morePages);
      }
    });
    home.add(more);
    
    JButton startGame = new JButton("Start");
    startGame.setFont(new Font("Yu Gothic Light", Font.PLAIN, 53));
    startGame.setBounds(20, 460, 319, 90);
    startGame.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        
        //go to game screen 
        
        score.setVisible(false);
        home.setVisible(false);
        content.setVisible(true);
        setContentPane(content); 
        
        //set allows to yes to have the player have only 1 option to take a card from the deck 
        allow="yes";
        discardAllow="no";
        allowB="yes";
        
//        a1.setVisible(false);
//        a2.setVisible(false);
//        a3.setVisible(false);
//        a4.setVisible(false);
//        a5.setVisible(false);
//        a6.setVisible(false);
//        
//        b1.setVisible(false);
//        b2.setVisible(false);
//        b3.setVisible(false);
//        b4.setVisible(false);
//        b5.setVisible(false);
//        b6.setVisible(false);
//        deckCard.setVisible(false);
        
        
        
//set Discard pile to nothing so you cant switch with discard pile 
        discardPileSwitch.setIcon(null);
        
        //set all of the values in the arrays to 0 
        for(int i = 0; i< deck.length; i++) //go through loop while 'i' is less then the length of the array  
          deck[i] = 0; //set each value from index 0 to 1 less then the length of the array to '0'
        for(int i = 0; i< usedCards.length; i++)
          usedCards[i] = 0;
        for(int i = 0; i< deckCardArray.length; i++)
          deckCardArray[i] = 0;
        for(int i = 0; i< playerHand1.length; i++)
          playerHand1[i] = 0;
        for(int i = 0; i< playerHand2.length; i++)
          playerHand2[i] = 0;
        
        
        player2Name.setBounds(640, 5, 97, 148);
        player2Name.setFont(new Font("SansSerif", Font.BOLD,22));
        
        player1Name.setBounds(25, 5, 97, 148);
        player1Name.setFont(new Font("SansSerif", Font.BOLD,22));
        
        //show button to start game 
        start.setVisible(true);
        start();
        //reset the turn counter to 0
        turn = 0;
        message.setText("Player 1 must switch with a deck card");
        //reset the score 
        dis.setText("");
        dis2.setText("");
        goToScore.setVisible(false);
        
      }
    });
    home.add(startGame);
    
    //game title 
    
    JLabel title1 = new JLabel("Golf Card");
    title1.setForeground(Color.WHITE);
    title1.setFont(new Font("Yu Gothic", Font.PLAIN, 65));
    title1.setBounds(10, 52, 308, 126);
    home.add(title1);
    
    JLabel title2 = new JLabel("Game");
    title2.setForeground(Color.WHITE);
    title2.setFont(new Font("Yu Gothic", Font.PLAIN, 65));
    title2.setBounds(10, 138, 308, 126);
    home.add(title2);
    
    
    // b'x' are each of the cards on the left sidde
    
    b1 = new JButton("");
    b1.setBounds(32, 100, 97, 148);
    content.add(b1); 
    b1.setActionCommand("b1");
    b1.addActionListener( new b1()); //access the action class for each button 
    
    b2 = new JButton("");
    b2.setBounds(137, 100, 97, 148);
    content.add(b2); 
    b2.setActionCommand("b2");
    b2.addActionListener( new b2());
    
    b3 = new JButton("");
    b3.setBounds(242, 100, 97, 148);
    content.add(b3); 
    b3.setActionCommand("b3");
    b3.addActionListener( new b3());
    
    b4 = new JButton("");
    b4.setBounds(32, 260, 97, 148);
    content.add(b4); 
    b4.setActionCommand("b4");
    b4.addActionListener( new b4());
    
    b5 = new JButton("");
    b5.setBounds(137, 260, 97, 148);
    content.add(b5); 
    b5.setActionCommand("b5");
    b5.addActionListener( new b5());
    
    b6 = new JButton("");
    b6.setBounds(242, 260, 97, 148);
    content.add(b6); 
    b6.setActionCommand("b6");
    b6.addActionListener( new b6());
    
    
    // a'x' are each of the cards on the left sidde
    
    a1 = new JButton("");
    a1.setBounds(651, 100, 97, 148);
    content.add(a1);
    a1.setActionCommand("a1");
    a1.addActionListener( new a1());
    
    a2 = new JButton("");
    a2.setBounds(756, 100, 97, 148);
    content.add(a2);
    a2.setActionCommand("a2");
    a2.addActionListener( new a2());
    
    a3 = new JButton("");
    a3.setBounds(861, 100, 97, 148);
    content.add(a3);
    a3.setActionCommand("a3");
    a3.addActionListener( new a3());
    
    a4 = new JButton("");
    a4.setBounds(651, 260, 97, 148);
    content.add(a4);
    a4.setActionCommand("a4");
    a4.addActionListener( new a4());
    
    a5 = new JButton("");
    a5.setBounds(756, 260, 97, 148);
    content.add(a5);
    a5.setActionCommand("a5");
    a5.addActionListener( new a5());
    
    a6 = new JButton("");
    a6.setBounds(861, 260, 97, 148);
    content.add(a6);
    a6.setActionCommand("a6");
    //end cards
    
    //placeholder for the new deck card to go 
    deckCard = new JLabel("");
    deckCard.setBounds(506, 30, 97, 148);
    content.add(deckCard);
    
    //button to switch with discard pile card or place new deck card in the discard pile 
    discardPileSwitch = new JButton ("");
    discardPileSwitch.setBounds(451, 200, 97, 148);
    content.add(discardPileSwitch);
    discardPileSwitch.setVisible(false);
    discardPileSwitch.addActionListener( new discardSwitch());
    
    //message bar 
    message = new JLabel("Message Update",SwingConstants.CENTER);
    message.setBounds(345, 368, 300, 40);
    content.add(message);
    message.setBorder(border);
    
    //start button to start game
    start = new JButton ("Start");
    start.setBounds(385,450,230,60);
    content.add(start);
    start.addActionListener( new startBTNlistener()); //clicking the button will either start or restart the game 
    
    //deck card button for a new card fromt the deck 
    newDeckCard = new JButton ("");
    newDeckCard.setBounds(397, 30, 97, 148);
    newDeckCard.setIcon(new ImageIcon("back.png")); //set image to the back of a card located in the same directory 
    content.add(newDeckCard);
    newDeckCard.setVisible(false);
    newDeckCard.addActionListener( new deckCard()); //show a new card in deckCard
    
    //flip last buttons are to flip the last card over and end game 
    flipLast = new JButton ("");
    flipLast.setBounds(242, 260, 97, 148);
    flipLast.setIcon(new ImageIcon("back.png"));
    content.add(flipLast);
    flipLast.addActionListener( new flipLast());
    flipLast.setVisible(false);
    
    flipLast2 = new JButton ("");
    flipLast2.setBounds(861, 260, 97, 148);
    flipLast2.setIcon(new ImageIcon("back.png"));
    content.add(flipLast2);
    flipLast2.addActionListener( new flipLast2());
    flipLast2.setVisible(false);
    
    //default names for player 1 & 2
    player1Name = new JLabel("Player 1");
    player1Name.setBounds(25, 5, 97, 148);
    player1Name.setFont(new Font("SansSerif", Font.BOLD,22));
    content.add(player1Name);
    
    player2Name = new JLabel("Player 2",SwingConstants.CENTER);
    player2Name.setBounds(640, 5, 97, 148);
    player2Name.setFont(new Font("SansSerif", Font.BOLD,22));
    content.add(player2Name);
    
    //go to score screen button 
    goToScore = new JButton ("Go to Score Board");
    goToScore.setFont(new Font("SansSerif", Font.BOLD,30)); //bolded text 
    goToScore.setBounds(345, 185, 300, 148);
    goToScore.setIcon(new ImageIcon("back2.png")); // red background to the JLabel 
    goToScore.setForeground(Color.WHITE); //white text 
    content.add(goToScore); 
    goToScore.addActionListener( new goToScore()); //go to score frame class 
    goToScore.setVisible(false);
    
    
    
    //score frame 
    button = new JButton("Play Again");
    button.setBounds(200, 400, 200, 75);
    button.setEnabled(true); 
    score.add(button);
    button.setVisible(true);
    button.addActionListener(new restart());
    
    goHome = new JButton("Go Home");
    goHome.setBounds(600, 400, 200, 75);
    goHome.setEnabled(true); 
    score.add(goHome);
    goHome.setVisible(true);
    goHome.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        score.setVisible(false);
        home.setVisible(true);
        //set the window to the home frame 
        setContentPane(home);
      }
    });
    
    
    
    
    JLabel playerName1 = new JLabel("Player 1 Score:");
    playerName1.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 40));
    playerName1.setBounds(43, 86, 322, 60);
    score.add(playerName1);
    
    JLabel playerName2 = new JLabel("Player 2 Score:");
    playerName2.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 40));
    playerName2.setBounds(601, 86, 322, 60);
    score.add(playerName2);  
    
    //score labels 
    dis = new JLabel (" ");
    dis2 = new JLabel (" ");
    
    //label to set for who wins or tie 
    win1 = new JLabel(" ",SwingConstants.CENTER);
    win1.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 55));
    win1.setBounds(250, 275, 500, 60);
    win1.setVisible(true);
    score.add(win1);  
    
    //background of home page 
    JLabel blNewLabel = new JLabel("New label");
    blNewLabel.setIcon(new ImageIcon("pexels-photo-262333 (3).jpeg"));
    blNewLabel.setBounds(0, 0, 1000, 600); //set it starting in the corner(0,0) and have it the dimensions of the screen (1000 X 600)
    home.add(blNewLabel);
    blNewLabel.setVisible(true);
    
    //options page 
    //button to go back home 
    JButton goHome4 = new JButton ("Go Home");
    goHome4.setBounds(0,0,100,40);
    options.add(goHome4);
    //action listener class has what will happen with goHome button is clicked
    goHome4.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        home.setVisible(true);
        //set the pain content pane with the home JFrame 
        setContentPane(home);
      }
    });
    
    JLabel optTitle = new JLabel("Options");
    optTitle.setHorizontalAlignment(SwingConstants.CENTER);
    optTitle.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 54));
    optTitle.setBounds(338, 30, 224, 73);
    options.add(optTitle);
    
    //text field for player 1 name 
    textField1 = new JTextField();
    textField1.setBounds(454, 164, 299, 55);
    textField1.setColumns(10);
    options.add(textField1);
    
    //text field for player 2 name 
    textField2 = new JTextField();
    textField2.setColumns(10);
    textField2.setBounds(454, 244, 299, 55);
    options.add(textField2);
    
    JLabel p1NewName = new JLabel("Player 1 Name:  ");
    p1NewName.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 50));
    p1NewName.setBounds(60, 160, 384, 59);
    options.add(p1NewName);
    
    JLabel p2NewName = new JLabel("Player 2 Name:  ");
    p2NewName.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 50));
    p2NewName.setBounds(60, 240, 384, 59);
    options.add(p2NewName);
    
  
    //once the button is clicked the player 1 name will be set 
    JButton done1 = new JButton("Done");
    done1.setBounds(804, 170, 131, 42);
    done1.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        player1Name.setText(textField1.getText());//get the text of the text field and set it as the title of the player name 
      }
    });
    options.add(done1);
    
    JButton done2 = new JButton("Done");
    done2.setBounds(804, 250, 131, 42);
    done2.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        player2Name.setText(textField2.getText());
      }
    });
    options.add(done2);
    
    JLabel lblGameBackgroundColor = new JLabel("Game Background Color:");
    lblGameBackgroundColor.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 50));
    lblGameBackgroundColor.setBounds(60, 361, 554, 75);
    options.add(lblGameBackgroundColor);
    
    //new feature - only let one button to be clicked at a time using a button group  
    ButtonGroup buttonGroup = new ButtonGroup(); 
    
    JRadioButton greenNewC = new JRadioButton("Green");
    greenNewC.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 25));
    greenNewC.setBounds(446, 443, 168, 48);
    greenNewC.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        //set the background to green 
        content.setBackground(new Color(46, 204, 113));  //r,g,b format
      }
    });
    options.add(greenNewC);
    buttonGroup.add(greenNewC);
    
    JRadioButton blueNewC = new JRadioButton("Blue");
    blueNewC.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 25));
    blueNewC.setBounds(706, 443, 168, 48);
    blueNewC.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        content.setBackground(new Color(52, 152, 129));
      }
    });
    options.add(blueNewC);
    buttonGroup.add(blueNewC);
    
    JRadioButton blackNewC = new JRadioButton("Black");
    blackNewC.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 25));
    blackNewC.setBounds(190, 443, 168, 48);
    blackNewC.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        content.setBackground(new Color(33, 33, 33));
      }
    });
    options.add(blackNewC);
    buttonGroup.add(blackNewC);
    
    
//    set the first screen as the home screen 
    setContentPane(home);
    pack();  // Layout components.
    setTitle("Golf Card Game");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //close program when X'ed 
    setLocationRelativeTo(null);  // Center window.
    
  }
  
  
  //====================================================== method main
  public static void main(String[] args) {
    window = new golfDR5();
    window.setVisible(true);
    window.setBounds(150,50,1000,600); 
  }
  
  
  //action listeners 
  
  //starting the game 
  class startBTNlistener implements ActionListener {        
    public void actionPerformed(ActionEvent e) {
      //set of commands that start the game 
      start.setVisible(false);
      start();
      playerCards1();
      playerCards2();
      hide2Cards();
      addCards();
      newDeckCard.setVisible(true);
      flipLast.setVisible(true);
      flipLast2.setVisible(true);
      discardPileSwitch.setVisible(true);   
      turn = 0; //set the turn back to 0
      message.setText("Player 1 once switch with a deck card"); 
      allow = "yes";
    }
  }
  
  //reset the game 
  class restart implements ActionListener {        
    public void actionPerformed(ActionEvent e) {
      
      content.setVisible(false); 
      allowB = "yes";      
      goToScore.setVisible(false); 
      discardPileSwitch.setIcon(null);
      //go through each array using for loops and set each value to '0'
      for(int i = 0; i< deck.length; i++)
        deck[i] = 0;
      for(int i = 0; i< usedCards.length; i++)
        usedCards[i] = 0;
      for(int i = 0; i< deckCardArray.length; i++)
        deckCardArray[i] = 0;
      for(int i = 0; i< playerHand1.length; i++)
        playerHand1[i] = 0;
      for(int i = 0; i< playerHand2.length; i++)
        playerHand2[i] = 0;
      
      
      //trigger commands to start the game 
      start.setVisible(false);
      start();
      //set up both player hands 
      playerCards1();
      playerCards2();
      hide2Cards();
      addCards();
      //set options to visible true 
      newDeckCard.setVisible(true);
      flipLast.setVisible(true);
      flipLast2.setVisible(true);
      discardPileSwitch.setVisible(true);
      turn = 0; //reset the turn to 0
      message.setText("Player 1 must switch with a deck card");
      dis.setText(" ");
      dis2.setText(" ");
      score.setVisible(false);
      content.setVisible(true);
      setContentPane(content); 
      
    }
  }
  //calculate and show score 
  class goToScore implements ActionListener {        
    public void actionPerformed(ActionEvent e) {
      
      //go to score screen 
      content.setVisible(false);
      score.setVisible(true);
      setContentPane(score);
      
    //convert from the numbers from 1 to 52 to a number from 1 to 13 
      //take the ceiling of the number after dividing by 4
      for(int i =0; i<6; i++)
        playerHand1[i] = convert(playerHand1[i]);
      
      for(int i =0; i<6; i++)
        playerHand2[i] = convert(playerHand2[i]);
      
      //if the card is a K '13' then set its value to '0' as the point value for a K in the game is 0
      for(int i =0; i<6; i++)
      {
        if(playerHand1[i] == 13)
          playerHand1[i] = 0;
      }
      
      for(int i =0; i<6; i++)
      {
        if(playerHand2[i] == 13)
          playerHand2[i] = 0;
      }
      
      //point value for a A or 1 is -1 so if any card is a 1 set it to -1 
      for(int i =0; i<6; i++)
      {
        if(playerHand1[i] == 1)
          playerHand1[i] = -1;
      }
      
      for(int i =0; i<6; i++)
      {
        if(playerHand2[i] == 1)
          playerHand2[i] = -1;
      }
      //go through the cards and if any card is a Q or J || 11,12 then set the value to 10 and the point value is 10 
      for(int i =0; i<6; i++)
      {
        if(playerHand1[i] == 12 || playerHand1[i] == 11 )
          playerHand1[i] = 10;
      }
      
      for(int i =0; i<6; i++)
      {
        if(playerHand2[i] == 12 || playerHand2[i] == 11 )
          playerHand2[i] = 10;
      }
      
      
      //display score 
      
      //add the vertical rows to count points for each row 
      int p2a = playerHand2[0] + playerHand2[3]; 
      int p2b = playerHand2[1] + playerHand2[4];
      int p2c = playerHand2[2] + playerHand2[5];
      
      int p1a = playerHand1[0] + playerHand1[3]; 
      int p1b = playerHand1[1] + playerHand1[4];
      int p1c = playerHand1[2] + playerHand1[5];
      
      //check for any pairs and if so set the point value for that row to 0
      if(playerHand2[0] == playerHand2[3])
        p2a= 0;
      if(playerHand2[1] == playerHand2[4])
        p2b = 0;
      if(playerHand2[2] == playerHand2[5])
        p2c = 0;
      
      if(playerHand1[0] == playerHand1[3])
        p1a= 0;
      if(playerHand1[1] == playerHand1[4])
        p1b = 0;
      if(playerHand1[2] == playerHand1[5])
        p1c = 0;
      
      //display the score for each player -> the sum of the points in each row 
      dis.setText((p2a+p2b+p2c)+"");
      dis.setFont(new Font("Tahoma", Font.PLAIN, 66));
      dis.setBounds(160, 128, 170, 153);
      score.add(dis);
      
      dis2.setText((p1a+p1b+p1c)+"");
      dis2.setFont(new Font("Tahoma", Font.PLAIN, 66));
      dis2.setBounds(690, 128, 170, 153);
      score.add(dis2);
      
      //check who wins || or tie 
      if ((p2a+p2b+p2c) > (p1a+p1b+p1c))
        win1.setText("Player 2 Wins!");
      else if ((p2a+p2b+p2c) < (p1a+p1b+p1c))
        win1.setText("Player 1 Wins!");
      else if ((p2a+p2b+p2c) == (p1a+p1b+p1c))
        win1.setText("It is a tie");      
    }
  }
  
  //show new card from the deck 
  class deckCard implements ActionListener {        
    public void actionPerformed(ActionEvent e) {
      
      if(allowB.equals("yes"))
      {
        //deckCard.setBorder(border); 
        deckCardArray[0] = randCard(); //take a random card 
        deckCard.setIcon(new ImageIcon(deckCardArray[0]+".png")); //set the placeholder with that card 
        message.setText("Select the card  you want to switch with or click the discard pile");
        allow = "yes"; 
        allowB = "no";
      }
    }
  }
  
  //two hidden cards button 
  
  class flipLast implements ActionListener {        
    public void actionPerformed(ActionEvent e) {
      flipLast.setVisible(false); 
      //swap card with new deck card and put other card in the discard pile 
      if(allow.equals("yes") && (turn%2==0))
      {
        deckCard.setBorder(null);
        playerHand2[5] = deckCardArray[0]; 
        b6.setIcon(new ImageIcon(playerHand2[5] + ".png"));
        deckCard.setIcon(null);
        allow = "no";
        turn++;
        allowB = "yes";
        discardPileSwitch.setEnabled(true);
      }
      //swap clicked card with the discard pile card 
      else if(discardAllow.equals("yes") && (turn%2==0))
      {
        playerHand2[5] = discard[0];
        b6.setIcon(new ImageIcon(playerHand2[5] + ".png")); 
        turn++;
        discardAllow = "no";        
      }
      //ending game mechanic 
      //disable visiblilty of certain elements and show the button to go to score screen 
      hideA.setVisible(false);
      hideB.setVisible(false);
      b6.setVisible(true);
      a6.setVisible(true);
      goToScore.setVisible(true); //show the go to score button
      discardPileSwitch.setVisible(false);
      message.setText("ROUND OVER");
      //restrict the game from being played further 
      allow = "no";
      allowB = ("no");  
    }
  }
  
  class flipLast2 implements ActionListener {        
    public void actionPerformed(ActionEvent e) {
      flipLast2.setVisible(false); 
      
      if(allow.equals("yes") && (turn%2==1))
      {
        deckCard.setBorder(null);
        playerHand1[5] = deckCardArray[0]; 
        a6.setIcon(new ImageIcon(playerHand1[5] + ".png"));
        deckCard.setIcon(null);
        allow = "no";
        turn++;
        allowB = "yes";
        discardPileSwitch.setEnabled(true);
      }
      else if(discardAllow.equals("yes") && (turn%2==1))
      {
        playerHand1[5] = discard[0];
        a6.setIcon(new ImageIcon(playerHand1[5] + ".png")); 
        turn++;
        discardAllow = "no";        
      }
      
      hideA.setVisible(false);
      hideB.setVisible(false);
      b6.setVisible(true);
      a6.setVisible(true);
      goToScore.setVisible(true); //show the go to score button
      discardPileSwitch.setVisible(false);
      message.setText("ROUND OVER");
      //restrict the game from being played further 
      allow = "no";
      allowB = ("no");
    }
  }
  
  //switching card with the discard pile either from deck card or from player hand 
  class discardSwitch implements ActionListener {        
    public void actionPerformed(ActionEvent e) {
      if(allow.equals("yes")) 
      {
        deckCard.setBorder(null);
        discard[0] = deckCardArray[0]; //set the discard pile card to the new card that was drawn 
        discardPileSwitch.setIcon(new ImageIcon((deckCardArray[0]+".png")));
        deckCard.setIcon(null); 
        turn++;
        //restrict other moves 
        allow = "no";
        allowB = "yes";
        discardPileSwitch.setEnabled(true);
        
      }
      //or allow the card to be swapped
      else{
        message.setText("Select which card you want to switch with");
        discardAllow = "yes";
      }
    }
  }
  
  //12 classes for each card with two possible outcomes 
  //  1. Swap cards with the discard pile and the card clicked 
  //  2. Take the new deck card that was fliped over and put in on the clicked card and discard the previous card 
  
  class b1 implements ActionListener {        
    public void actionPerformed(ActionEvent e) {
      //switch card from deck with clicked card and put clicked card in the discard pile
      //allow will only be yes if the player clicks on the deck and a new card is shown to the player 
      if(allow.equals("yes") && (turn%2==0)) //check for turn & if the deck card is clicked 
      {
        deckCard.setBorder(null); //keep no border 
        discard[0] = playerHand2[0]; //set the discard pile top card numerical value to the clicked card 
        discardPileSwitch.setIcon(new ImageIcon(playerHand2[0] + ".png")); //set the image for the discard pile to the card clicked on 
        playerHand2[0] = deckCardArray[0]; //set the card clicked on with the new deck card
        b1.setIcon(new ImageIcon(playerHand2[0] + ".png")); //switch card with new deck card image
        deckCard.setIcon(null); //set the deck card placeholder to nothing (null)
        allow = "no"; //restrict other moves 
        turn++; //increment turn counter 
        allowB = "yes";
        discardPileSwitch.setEnabled(true);
        
        
      }
      //switch card with the discard pile card
      else if(discardAllow.equals("yes"))
      {
        int temp = playerHand2[0]; //use temp variable to hold card value 
        playerHand2[0] = discard[0]; //set the card clicked to the discard value 
        b1.setIcon(new ImageIcon(playerHand2[0] + ".png"));
        discard[0] = temp; //set the discard pile to the temp variable that was set previously as the card clicked on 
        discardPileSwitch.setIcon(new ImageIcon(temp + ".png"));
        turn++; //increment turn indiquator 
        discardAllow = "no"; //restrict other moves 
      }
    }
  }
  
  
  
  
  
  class b2 implements ActionListener {        
    public void actionPerformed(ActionEvent e) {
      if(allow.equals("yes") && (turn%2==0))
      {
        deckCard.setBorder(null);
        discard[0] = playerHand2[1];
        discardPileSwitch.setIcon(new ImageIcon(playerHand2[1] + ".png"));
        playerHand2[1] = deckCardArray[0];
        b2.setIcon(new ImageIcon(playerHand2[1] + ".png"));
        deckCard.setIcon(null);
        allow = "no";
        turn++;
        allowB = "yes";
        discardPileSwitch.setEnabled(true);
      }
      else if(discardAllow.equals("yes") && (turn%2==0))
      {
        int temp = playerHand2[1];
        playerHand2[1] = discard[0];
        b2.setIcon(new ImageIcon(playerHand2[1] + ".png"));
        discard[0] = temp;
        discardPileSwitch.setIcon(new ImageIcon(temp + ".png"));
        turn++;
        discardAllow = "no";
      }
    }
  }
  
  class b3 implements ActionListener {        
    public void actionPerformed(ActionEvent e) {
      if(allow.equals("yes") && (turn%2==0))
      {
        deckCard.setBorder(null);
        discard[0] = playerHand2[2];
        discardPileSwitch.setIcon(new ImageIcon(playerHand2[2] + ".png"));
        playerHand2[2] = deckCardArray[0];
        b3.setIcon(new ImageIcon(playerHand2[2] + ".png"));
        deckCard.setIcon(null);
        allow = "no";
        turn++;
        allowB = "yes";
        discardPileSwitch.setEnabled(true);
      }
      else if(discardAllow.equals("yes") && (turn%2==0))
      {
        int temp = playerHand2[2];
        playerHand2[2] = discard[0]; 
        b3.setIcon(new ImageIcon(playerHand2[2] + ".png"));
        discard[0] = temp;
        discardPileSwitch.setIcon(new ImageIcon(temp + ".png"));
        turn++;
        discardAllow = "no";
      }
    }
  }
  
  class b4 implements ActionListener {        
    public void actionPerformed(ActionEvent e) {
      if(allow.equals("yes") && (turn%2==0))
      {
        deckCard.setBorder(null);
        discard[0] = playerHand2[3];
        discardPileSwitch.setIcon(new ImageIcon(playerHand2[3] + ".png"));
        playerHand2[3] = deckCardArray[0]; 
        b4.setIcon(new ImageIcon(playerHand2[3] + ".png"));
        deckCard.setIcon(null);
        allow = "no";
        turn++;
        discardPileSwitch.setEnabled(true);
        allowB = "yes";
      }
      else if(discardAllow.equals("yes") && (turn%2==0))
      {
        int temp = playerHand2[3];
        playerHand2[3] = discard[0]; 
        b4.setIcon(new ImageIcon(playerHand2[3] + ".png"));
        discard[0] = temp;
        discardPileSwitch.setIcon(new ImageIcon(temp + ".png"));
        turn++;
        discardAllow = "no"; 
      }
    }
  }
  
  class b5 implements ActionListener {        
    public void actionPerformed(ActionEvent e) {
      if(allow.equals("yes") && (turn%2==0))
      {
        deckCard.setBorder(null);
        discard[0] = playerHand2[0];
        discardPileSwitch.setIcon(new ImageIcon(playerHand2[4] + ".png"));
        playerHand2[4] = deckCardArray[0]; 
        b5.setIcon(new ImageIcon(playerHand2[4] + ".png"));
        deckCard.setIcon(null);
        allow = "no";
        turn++;
        allowB = "yes";
        discardPileSwitch.setEnabled(true); 
      }
      else if(discardAllow.equals("yes") && (turn%2==0))
      {
        int temp = playerHand2[4];
        playerHand2[4] = discard[0]; 
        b5.setIcon(new ImageIcon(playerHand2[4] + ".png"));
        discard[0] = temp;
        discardPileSwitch.setIcon(new ImageIcon(temp + ".png"));
        turn++;
        discardAllow = "no"; 
      }
    }
  }
  
  class b6 implements ActionListener {        
    public void actionPerformed(ActionEvent e) {
      if(allow.equals("yes") && (turn%2==0))
      {
        deckCard.setBorder(null);
        discard[0] = playerHand2[5];
        discardPileSwitch.setIcon(new ImageIcon(playerHand2[5] + ".png"));
        playerHand2[5] = deckCardArray[0]; 
        b6.setIcon(new ImageIcon(playerHand2[5] + ".png"));
        deckCard.setIcon(null);
        allow = "no";
        turn++;
        allowB = "yes";
        discardPileSwitch.setEnabled(true); 
      }
      else if(discardAllow.equals("yes") && (turn%2==0))
      {
        int temp = playerHand2[5];
        playerHand2[5] = discard[0]; 
        b6.setIcon(new ImageIcon(playerHand2[5] + ".png"));
        discard[0] = temp;
        discardPileSwitch.setIcon(new ImageIcon(temp + ".png"));
        turn++;
        discardAllow = "no"; 
      }
    }
  } 
  
  
  class a1 implements ActionListener {        
    public void actionPerformed(ActionEvent e) {
      
      if(allow.equals("yes") && (turn%2==1))
      { 
        deckCard.setBorder(null);
        discard[0] = playerHand1[0];
        discardPileSwitch.setIcon(new ImageIcon(playerHand1[0] + ".png"));
        playerHand1[0] = deckCardArray[0]; 
        a1.setIcon(new ImageIcon(playerHand1[0] + ".png"));        
        deckCard.setIcon(null);
        allow = "no";
        turn++;
        allowB = "yes";
        discardPileSwitch.setEnabled(true);
      }
      else if(discardAllow.equals("yes") && (turn%2==1))
      {
        int temp = playerHand1[0];
        playerHand1[0] = discard[0]; 
        a1.setIcon(new ImageIcon(playerHand1[0] + ".png"));
        discard[0] = temp;
        discardPileSwitch.setIcon(new ImageIcon(temp + ".png"));
        turn++;
        discardAllow = "no";
        // discard.setEnabled(false);
      }
    }
  }
  
  class a2 implements ActionListener {        
    public void actionPerformed(ActionEvent e) {
      if(allow.equals("yes") && (turn%2==1))
      {
        deckCard.setBorder(null);
        discard[0] = playerHand1[1];
        discardPileSwitch.setIcon(new ImageIcon(playerHand1[1] + ".png"));
        playerHand1[1] = deckCardArray[0];
        a2.setIcon(new ImageIcon(playerHand1[1] + ".png"));
        deckCard.setIcon(null);
        allow = "no";
        turn++;
        allowB = "yes";
        discardPileSwitch.setEnabled(true);
      }
      else if(discardAllow.equals("yes") && (turn%2==1))
      {
        int temp = playerHand1[1];
        playerHand1[1] = discard[0];
        a2.setIcon(new ImageIcon(playerHand1[1] + ".png"));
        discard[0] = temp;
        discardPileSwitch.setIcon(new ImageIcon(temp + ".png"));
        turn++;
        discardAllow = "no";
        // discard.setEnabled(false);
      }
    }
  }
  
  class a3 implements ActionListener {        
    public void actionPerformed(ActionEvent e) {
      if(allow.equals("yes") && (turn%2==1))
      {
        deckCard.setBorder(null);
        discard[0] = playerHand1[2];
        discardPileSwitch.setIcon(new ImageIcon(playerHand1[2] + ".png"));
        playerHand1[2] = deckCardArray[0];
        deckCard.setIcon(null);
        a3.setIcon(new ImageIcon(playerHand1[2] + ".png"));                         
        allow = "no";
        turn++;
        allowB = "yes";
        discardPileSwitch.setEnabled(true);
      }
      else if(discardAllow.equals("yes") && (turn%2==1))
      {
        int temp = playerHand1[2];
        playerHand1[2] = discard[0];
        a3.setIcon(new ImageIcon(playerHand1[2] + ".png"));
        discard[0] = temp;
        discardPileSwitch.setIcon(new ImageIcon(temp + ".png"));
        turn++;
        discardAllow = "no";
        // discard.setEnabled(false);
      }
    }
  }
  
  
  
  class a4 implements ActionListener {        
    public void actionPerformed(ActionEvent e) {
      if(allow.equals("yes") && (turn%2==1))
      {
        deckCard.setBorder(null);
        discard[0] = playerHand1[3];
        discardPileSwitch.setIcon(new ImageIcon(playerHand1[3] + ".png"));
        playerHand1[3] = deckCardArray[0];
        deckCard.setIcon(null);
        a4.setIcon(new ImageIcon(playerHand1[3] + ".png"));                         
        allow = "no";
        turn++;
        allowB = "yes";
        discardPileSwitch.setEnabled(true);
      }
      else if(discardAllow.equals("yes") && (turn%2==1))
      {
        int temp = playerHand1[3];
        playerHand1[3] = discard[0];
        a4.setIcon(new ImageIcon(playerHand1[3] + ".png"));
        discard[0] = temp;
        discardPileSwitch.setIcon(new ImageIcon(temp + ".png"));
        discardAllow = "no";
        turn++;
        // discard.setEnabled(false);
      }
    }
  }
  
  class a5 implements ActionListener {        
    public void actionPerformed(ActionEvent e) {
      if(allow.equals("yes") && (turn%2==1))
      {
        deckCard.setBorder(null);
        discard[0] = playerHand1[3];
        discardPileSwitch.setIcon(new ImageIcon(playerHand1[4] + ".png"));
        playerHand1[4] = deckCardArray[0];
        a5.setIcon(new ImageIcon(playerHand1[4] + ".png"));
        deckCard.setIcon(null);
        allow = "no";
        turn++;
        allowB = "yes";
        discardPileSwitch.setEnabled(true);
      }
      else if(discardAllow.equals("yes") && (turn%2==1))
      {
        int temp = playerHand1[4];
        playerHand1[4] = discard[0]; 
        a5.setIcon(new ImageIcon(playerHand1[4] + ".png"));
        discard[0] = temp;
        discardPileSwitch.setIcon(new ImageIcon(temp + ".png"));
        turn++;
        discardAllow = "no"; 
      }
    }
  }
  
  
  
  
  
  
  
  
  
  
  
  
  //other methods here 
  
  public static void start (){
    // Initialize cards array 
    for (int i = 1; i < deck.length; i++) {
      deck[i] = i;
    }
  }
  
  //choose a random un used card 
  public static int randCard (){
    //choose a number between 1 - 52
    int random =  (int) (Math.random() * 52) + 1;
    int newCard = deck[random];
    
    //check if the the card is contained in the usedCards array if it is check again until a new card is found
    while(contains(usedCards, newCard) == true)
    {
      random =  (int) (Math.random() * 52) + 1;
      newCard = deck[random];
    }
    
    //add the new card to usedCard array to not allow it to be choosen again 
    addUsedCard(newCard);
    //return the choosen card
    return ((newCard));
  }
  
  //new feature 
  public static boolean contains(int[] arr, int item) {
    //check if the 'item' belongs in array 'arr'
    for (int n : arr) {
      if (item == n) {
        return true;  //return true if the card has been previously drawn befor
      }
    }
    return false; //return false if the card is new and not been drawn before 
  }
  
  //take a card and add it into the next avaliable spot in the usedCard array 
  //new feature 
  public static void addUsedCard (int a){
    int i = 0;
    while (usedCards[i] != 0)
      i++;
    usedCards[i] = a;   
  }
  
  //give playerCards1 6 new random cards 
  public static void playerCards1 (){
    for(int i = 0; i < playerHand1.length; i++) //for loop goes through each index in the array 
      playerHand1[i] = randCard(); //set each value in the array to a new card using the randCard method 
  }
  
  //give playerCards2 6 new random cards 
  public static void playerCards2 (){
    for(int i = 0; i < playerHand2.length; i++) //for loop goes through each index in the array 
      playerHand2[i] = randCard();
  }
  
  //new feature 
  //add the picture corresponding with the number card value from the directory 
  public static void addCards () {
    b1.setIcon(new ImageIcon(playerHand2[0] + ".png"));
    b2.setIcon(new ImageIcon(playerHand2[1] + ".png"));
    b3.setIcon(new ImageIcon(playerHand2[2] + ".png"));
    b4.setIcon(new ImageIcon(playerHand2[3] + ".png"));
    b5.setIcon(new ImageIcon(playerHand2[4] + ".png"));
    b6.setIcon(new ImageIcon(playerHand2[5] + ".png"));
    
    a1.setIcon(new ImageIcon(playerHand1[0] + ".png"));
    a2.setIcon(new ImageIcon(playerHand1[1] + ".png"));
    a3.setIcon(new ImageIcon(playerHand1[2] + ".png"));
    a4.setIcon(new ImageIcon(playerHand1[3] + ".png"));
    a5.setIcon(new ImageIcon(playerHand1[4] + ".png"));
    a6.setIcon(new ImageIcon(playerHand1[5] + ".png"));   
  }
  
  //dont show the last two cards 
  public static void hide2Cards() {
    //hide b6 and a1
    hideA = new JLabel("");
    hideA.setBounds(861, 260, 97, 148);
    content.add(hideA); //hide the card
    hideA.setOpaque(true);
    a6.setVisible(false);
    
    hideB = new JLabel("");
    hideB.setBounds(242, 260, 97, 148);
    content.add(hideB);
    hideB.setOpaque(true);
    b6.setVisible(false);
  }
  
  //convert from the 52 card array to number from 1 to 13 
  public static int convert (int a)
  {
    return convert[a]; 
  }
  
  
  
  
  
}
