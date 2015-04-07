/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package questions;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

/**
 *
 * @author gaitanesnikos
 */
public class Pan extends JPanel {

    private static final long serialVersionUID = 1L;
    private String type;
    private Fr frame;
    private JButton fifty = new JButton("50/50");
    private JButton nxtQuest = new JButton("next Question");
    private JButton choosenToShowfalseButton;
    private Timer time;
    private int coutFalseAnswers = 0;
    private JButton[] questionButton = new JButton[4];
    private ArrayList<Object> toChooseButtonText = new ArrayList<Object>();
    private Hashtable questionsWithAnser = new Hashtable();
    private Hashtable StringLevelEasy = new Hashtable();
    private Hashtable StringLevelMedium = new Hashtable();
    private Hashtable StringLevelHard = new Hashtable();
    private JTextArea screen = new JTextArea();
    private String trueAnswere = "";
    private boolean canPressAnotherButton = true;
    private boolean answereTrue = false, answereFalse = false;
    private Pan panel;
    private int level;
    private String removingDataFtomHasTable;
    private int score = 0;
    private JButton trueButton;
    private String drawLevel = "easy";

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getDrawLevel() {
        return drawLevel;
    }

    public void setDrawLevel(String drawLevel) {
        this.drawLevel = drawLevel;
    }

    public boolean isCanPressAnotherButton() {
        return canPressAnotherButton;
    }

    public int getCoutFalseAnswers() {
        return coutFalseAnswers;
    }

    public void setCoutFalseAnswers(int coutFalseAnswers) {
        this.coutFalseAnswers = coutFalseAnswers;
    }

    public Hashtable getStringLevelEasy() {
        return StringLevelEasy;
    }

    public void setStringLevelEasy(Hashtable StringLevelEasy) {
        this.StringLevelEasy = StringLevelEasy;
    }

    public Hashtable getStringLevelHard() {
        return StringLevelHard;
    }

    public void setStringLevelHard(Hashtable StringLevelHard) {
        this.StringLevelHard = StringLevelHard;
    }

    public Hashtable getStringLevelMedium() {
        return StringLevelMedium;
    }

    public void setStringLevelMedium(Hashtable StringLevelMedium) {
        this.StringLevelMedium = StringLevelMedium;
    }

    public void setCanPressAnotherButton(boolean canPressAnotherButton) {
        this.canPressAnotherButton = canPressAnotherButton;
    }

    public String getRemovingDataFtomHasTable() {
        return removingDataFtomHasTable;
    }

    public void setRemovingDataFtomHasTable(String removingDataFtomHasTable) {
        this.removingDataFtomHasTable = removingDataFtomHasTable;
    }

    public boolean isAnswereFalse() {
        return answereFalse;
    }

    public void setAnswereFalse(boolean answereFalse) {
        this.answereFalse = answereFalse;
    }

    public boolean isAnswereTrue() {
        return answereTrue;
    }

    public void setAnswereTrue(boolean answereTrue) {
        this.answereTrue = answereTrue;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public JButton[] getQuestionButton() {
        return questionButton;
    }

    public void setQuestionButton(JButton[] questionButton) {
        this.questionButton = questionButton;
    }

    public Hashtable getQuestionsWithAnser() {
        return questionsWithAnser;
    }

    public void setQuestionsWithAnser(Hashtable questionsWithAnser) {
        this.questionsWithAnser = questionsWithAnser;
    }

    public JTextArea getScreen() {
        return screen;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setScreen(JTextArea screen) {
        this.screen = screen;
    }

    public String getTrueAnswere() {
        return trueAnswere;
    }

    public void setTrueAnswere(String trueAnswere) {
        this.trueAnswere = trueAnswere;
    }

    public Fr getFrame() {
        return frame;
    }

    public void setFrame(Fr frame) {
        this.frame = frame;
    }

    public Pan(Fr frame, String type) {
        super();
        this.type = type;
        this.frame = frame;
        panel = this;
        time = new Timer(this);
        time.start();
        for (int i = 0; i <= 3; i++) {
            questionButton[i] = new JButton();
            questionButton[i].setSize(230, 50);
            questionButton[i].setBackground(Color.white);
            this.add(questionButton[i]);
            questionButton[i].addActionListener(action);
        }
        fifty.setSize(90, 30);
        fifty.setLocation(400, 330);

        nxtQuest.setSize(150, 30);
        nxtQuest.setLocation(100, 330);

        this.add(nxtQuest);
        this.add(fifty);
        this.setLayout(null);
        screen.setSize(560, 300);
        this.add(screen);
        screen.setLocation(20, 10);
        screen.setBackground(Color.yellow);
        questionButton[0].setLocation(50, 400);
        questionButton[1].setLocation(350, 400);
        questionButton[2].setLocation(55, 500);
        questionButton[3].setLocation(350, 500);
        screen.setEditable(false);
        screen.setFont(new Font("", Font.BOLD, 20));
        if (type.equals("general")) {
            intializeHashtableWithQuestionsAndAnsweres();
        } else if (type.equals("sports")) {
            intializeHashtableWithQuestionsAndAnsweresSports();
        }

        makeLevel(0, StringLevelEasy);



    }

    @SuppressWarnings("unchecked")
    public void intializeHashtableWithQuestionsAndAnsweresSports() {
        StringLevelEasy.put("ποιος ποδοσφαιριστις εβαλε 1281 γκολ", "πελε-μαραντονα-ροναλντο-μεσι");
        StringLevelEasy.put("ο ζινταν ειναι γενημενος στην γαλια ", "λαθος-σωστο- - ");

    }

    ;
    @SuppressWarnings("unchecked")
    public void intializeHashtableWithQuestionsAndAnsweres() {
        StringLevelEasy.put(" Ποσά χρόνια κράτησε ο 100ετής πόλεμος; ", "116-100-99-105");
        StringLevelEasy.put(" Πόσες μέρες ζει μια κατσαρίδα χωρίς κεφάλι; ", "9-10-8-7");
        StringLevelEasy.put(" Μέγιστη ταχύτητα μετάδοσης δεδομένων usb3 (bps)?  ", "400-300-200-500");
        StringLevelEasy.put(" Το τρενάκι στα λούνα-παρκ ανακαλύφθηκε τον \n 17 αιώνα που ?", "Ρωσια-Τσεχια-Ουκρανια-Βοσνια");
        StringLevelEasy.put("Ποσα δεπτερολεπτα κραταει η μνήμη του \nχρυσόψαρου διαρκεί ", "3-4-2-5");
        StringLevelEasy.put(" Η χειραψία παλιά γινόταν για να δείχνει \n κανείς πως? ", "ειναι αοπλος-εχει τροπους-ειναι ευγενεις-πανε τα κεφια ");
        StringLevelEasy.put(" Μια μπάλλα ποδοσφαίρου αποτελείται από \n ποσες κυψελες ", "36-42-32-46");
        StringLevelEasy.put("O ισχυρότερος μυς στο ανθρώπινο σώμα είναι?", "γλωσσα-δικεφαλο-τετρακεφαλο-καρδια");
        StringLevelEasy.put("O Mel Blanc (η φωνή του Mπαγκς Mπάνι) ήταν \n αλεργικός στο", "καροτο-μαρουλι-σελινο-αγγουρι");
        StringLevelEasy.put("Οι πεταλούδες μυρίζουν με τα", "ποδια-χερια-φτερα-αυτια");
        StringLevelEasy.put("Ποιο είναι το νοτιότερο μεγάλο νησί της Ευρώπης;", "κρητη-κυπρος-ναξος-φαρμακονησι");
        StringLevelEasy.put("Ποια είναι η επίσημη γλώσσα της Βραζιλίας;", "Πορτογαλικα-Βραζιλιανικα-Αγγλικα-Ισπανικα");
        StringLevelEasy.put("Ποιο μέρος του πλοίου λέγεται πλώρα; ", " μπροστινο-πισο-δεξυ-αριστερο");
        StringLevelEasy.put(" Πού έγινε η ολυμπιάδα το 1988; ", "Σεουλ-Βαρκελωνη-Ατλαντα-Αθηνα");
        StringLevelEasy.put(" «Η γλώσσα κόκαλα δεν έχει και κόκαλα…»", "τσακιζει-βαραει-χτυπαει-σπαει");
        StringLevelEasy.put(" «Θέλει και τον σκύλο χορτάτο και την πίττα …»", " ολοκληρη-γεματη-πληρες-νωστιμη");
        StringLevelEasy.put("Πόσες ευθείες περνάνε από ένα σημείο;", "απειρες-αναλογα το σημειο-μια- καμια");
        StringLevelEasy.put("Από ποια χώρα προέρχεται το τυρί χαλούμι;", "Κυπρος-Ελλαδα-Ιταλια-Ισπανια");
        StringLevelEasy.put("Ποια δύο βασικά χρώματα μαζί κάνουν \nτο πράσινο;", "μπλε και κιτρινο-Μπλε και μοβ-ασπρο και μαυρο-μπεζ και ροζ");
        StringLevelEasy.put("Ποιος συγγραφεας εγραψε το ..\nΕνα παιδι μετραει τ' αστρα", "Ο  Λουντέμης-Ο Ελιτης-Ο Κενζος- Ο Μαρκοπουλος");
        StringLevelEasy.put("Ποιο είναι το μεγαλύτερο όργανο του\n ανθρώπινου σώματος;", "συκοτι-καρδια-πνευμονας-φαρυγκας");
        StringLevelEasy.put("Πόσοι είναι οι μονοί αριθμοί από το 0-20?", "10-20-19-9");
        StringLevelEasy.put("Τι ζώδιο είναι ο γεννημένος 9/9?", "παρθενος-υδροχοος-κρυος-αιγοκερος");
        StringLevelEasy.put("Πόσες νότες έχει μια οκτάβα?", "8-9-10-5");
        StringLevelEasy.put("ποιο ζωο τσιριζει", "ποντικι-νυχτεριδα-δελφινι-τυφλοποντικας");
        StringLevelEasy.put("ποσα δαχτυλα εχει ενα παντα ?", "6-5-4-7");
        StringLevelEasy.put("ποσες καρδιες εχει ενα χταποδι ?", "3-1-2-4");
        StringLevelEasy.put("τι χρωμα εχει η γλωσσα της\n καμηλοπαρδαλης ?", " μαυρο-ασπρο-κοκκινο-ροζ");
        StringLevelEasy.put("πως κυνηγαει το ψαρι τοξοτης ?", "φτυνει νερο-φτυνει πετραδακια-εκτοξευει τα αγαθια που εχει-τα κουτουλαει ");
        StringLevelEasy.put("γιατι η πασχαλιτσα ειναι φιλη \nτων κηπουρων ?", "τρωει την μελιγκρα-κανει καλο λιπασμα-κανει κοκκινες τις ντοματες-εξαφανιζει τον σταφιλοκοκο");
        StringLevelEasy.put("ποσο συχνα θρεφει τα μικρα του \nο καλογερος(πουλι) την μερα", "900-400-200-600");
        StringLevelEasy.put("ποσες μυροδιες αναγνωριζει η μυτη μας", "4000-300-2000-περιπου 3000");
        StringLevelEasy.put("ποσες περιπου τριχες εχει το κεφαλι σου ?", "εξαρτατε απο το χρωμα-90000- εξαρτατε την υλικια και φυλο-10000");
        StringLevelEasy.put("ποσοι ανθροποι εχουν περπατησει \nστο φεγγαρι", "12-10-14-16");
        StringLevelEasy.put("το νερο της θαλλασσας γινεται \n παγος στους (βαθμους κελσιου)?", "μειων 1.9-μειων 1.3-0-μειων 2.5");
        StringLevelEasy.put("ποιους απο τους ηχους δεν ακουει\n ο ανθροπος", "κανενα απο τους 2- και τους 2 ακουει-υπεριχο-υποηχο");
        StringLevelEasy.put("τι υπηκοτητα ειχε ο αινσταιν?", "και τις 3- γερμανικη-ελβετικη-αμερικανικη");
        StringLevelEasy.put("ποιος ανατραφηκε απο μια λυκαινα", " μογλης- πιτερ παν - ταρζν - γουλβεριν ");
        StringLevelEasy.put("ποιος ποδοσφαιριστις εβαλε 1281 γκολ", "πελε-μαραντονα-ροναλντο-μεσι");
        StringLevelEasy.put("τι δεν χρυσημοποιει ο μπατμαν", "σανιδα-μηχανη-αεροπλανο-αμαξι");
        StringLevelEasy.put("ο πανοραμιξ (αστεριξ και οβελιξ) ειναι ο", "δρυηδης-αρχηγος-σκυλος-βαρδος");
        StringLevelEasy.put("ποιο ποσοστο αναλογει στα οστα των \n ποδιων και των χεριων \nσε σχεση με το συνολο οστων \nτου σωματος μας ", "1/2-1/3-1/4-1/6");
        StringLevelEasy.put("ποιο το επιστιμονικο ονομα για τον αφαλο", "ομφαλος-γεωσκολιξ-αμανιτης-λορος");
        StringLevelEasy.put("ποιος λαος επινοησε την γραφη ", "σουμεριοι-ρωμαιοι-φοινηκες-αιγηπτιοι");
        StringLevelEasy.put("το ποσοστο του γλυκου νερου που \n περιεχετε στο συνολο της\n ποσοτητας νερου του πλανητη", "3%-13%-30%-50%");
        StringLevelEasy.put("πως πεθανε ο μαυρογενης πειρατης", "αποκεφαλιστικε-απο γερατια-δηλητιριαστικε-πνιγικε");
        StringLevelEasy.put("ποια η ιδιαιτεροτητα της ερημου ουγιουνι\n στην βοληβια", "ειναι απο αλατι-η πιο μεγαλη-ειναι ανεξερευνητη-προκαλει οφθαλμαπατες");
        StringLevelEasy.put("το ταζ μαχαλ ειναι", "ταφος-παλατι-τζαμι-μουσειο");
        StringLevelEasy.put("οι βοες γαινουν αυγα", "λαθος-σωστο- - ");
        StringLevelEasy.put("το δελφινι δεν εχει αυτια ", "λαθος-σωστο- - ");
        StringLevelEasy.put("τα ερπετα ειχαν καποτε ποδια", "σωστο-λαθος - - ");
        StringLevelEasy.put("ο ιστος της αραχνης ειναι πιο\n ανθεκτοκος απο μια κλωστη", "σωστο -λαθος- - ");
        StringLevelEasy.put("το κουκαρ λεγετε αλιως και πουμα", "σωστο-λαθος- - ");
        StringLevelEasy.put("η κατσικα εχει 3 στομαχια", "λαθος-σωστο- - ");
        StringLevelEasy.put("η κλιμακα ρικτερ εχειδιαβαθμηση \nαπο το 1 εως το 10", "λαθος-σωστο- - ");
        StringLevelEasy.put("ενα ναυτικο μιλι ισουτε με ενα\n αγγλικο μιλι", "λαθος -σωστο- - ");
        StringLevelEasy.put("ο αριθμος 0 στο ρωμαικο σηστημα\n αριθμισης συμβολιζετε με\n Ζ", "λαθος-σωστο- - ");
        StringLevelEasy.put("ο Ρολαντ γκαρος ο οποιος εδωσε το \nονομα του στο διασημο σταδιο\nτου γαλικου τενις ηπηρξε μεγαλος\nπαιχτης την 10ετια του 90", "λαθος-σωστο- - ");
        StringLevelEasy.put("ο μονος γαλαζιος πλανητης ειναι η γη", "λαθος-σωστο- - ");
        StringLevelEasy.put("το 80% της ατμοσφαιρας αποτελειτε\n απο οξυγωνο", "λαθος-σωστο- - ");
        StringLevelEasy.put("το λιχτενσταιν ειναι ευροπαικη χωρα", "σωστο-λαθος- - ");
        StringLevelEasy.put("ο αμερικανος προεδρος εκλεγετε \'nανα 4 χρονια", "σωστο-λαθος- - ");
        StringLevelEasy.put("ο μαγκελανος δεν ειναι ο πρωτος που\n εκανε τον γυρο του κοσμου", "σωστο-λαθος- - ");
        StringLevelEasy.put("η ελαυροπετρα μπορει να επιπλεει στο νερο", "σωστο-λαθος- - ");
        StringLevelEasy.put("βλεπουμε παντα την ιδια πλευρα της σεληνης", "σωστο-λαθος- - ");
        StringLevelEasy.put("ενα αντικειμενο 10 πικομετρων \nειναι πιο μικρο απο ενα \nαντικειμενο 10 νανομετρων", "σωστο-λαθος- - ");
        StringLevelEasy.put("το νερο βραζει στους 100 βαθμους\nκελσιου που αντιστιχει σε\n212 βαθμους φαρεναιτ", "σωστο-λαθος- - ");
        StringLevelEasy.put("οταν εχει 27 βαθμους φαρεναιτ \n βγαινεις με κοντομανικο", "λαθος-σωστο- - ");
        StringLevelEasy.put("το φως εχει παντου την ιδια ταχυτητα\n ειται διασχιζει το νερο ειτε τον αερα", "λαθος-σωστο- - ");
        StringLevelEasy.put("το νεον αεριο δινει ενα λευκο\n εντονο χρομα", "λαθος-σωστο- - ");

        // StringLevelEasy.put("", "");


        ///70
        StringLevelMedium.put("ποια πουλιά που μπορούν να δουν \nτο μπλε χρώμα!", "κουκουβαγια-αετος-κορακι-γερακι");
        StringLevelMedium.put("Πινόκιο σημαίνει το μάτι του", "πευκου-ελατου-δενδρου-κακτου");
        StringLevelMedium.put("Ποια είναι η 1η ταινία φτιαγμένη με Η/Υ?", "Toy story-αρχοντας - μουλαν-lin king");
        StringLevelMedium.put("Ποιοι δημιούργησαν τα πρώτα λιπάσματα? ", "γερμανοι-αγγλοι-ελληνες-ιταλοι");
        StringLevelMedium.put("Πότε ξεκίνησε το facebook?", "2004-2003-2005-2006");
        StringLevelMedium.put("Πότε ιδρύθηκε η Apple?", "1976-1986-1980-1979");
        StringLevelMedium.put("Πόσα οστά έχει ο άνθρωπος?", "208-210-206-205");
        StringLevelMedium.put(" Σε πια Χώρα ανακαλύφτηκε το \n καπέλο τύπου Παναμά;", "Εκουαδόρ-Παναμά-Αργεντινή-Μεξικό");
        StringLevelMedium.put("Από πιο Ζώο πήραν οι Κανάριοι Νήσοι \n την oνομασία τους ;", "Σκύλο-Καναρίνι-άλογο-Φώκια");
        StringLevelMedium.put(" Πως λεγόταν ο Βασιλιάς της Αγγλίας \n Γεώργιος VΙ;", "Αλβέρτος -Κάρολος-Εδουάρδος-Γεώργιος");
        StringLevelMedium.put("Ποιο μήνα γιορτάζουν οι Ρώσοι την \n επανάσταση του Οκτωβρίου;", "Νοέμβριο-Οκτωβρη-Αύγουστο-Ιανουάριο");
        StringLevelMedium.put("Ανάμεσα στο 187 και 196 υπάρχουν ποσοι ακεραιοι", "8-6-7-5");
        StringLevelMedium.put("Ποσοστό εδάφους της γης καλυπτόμενο από έρημο?", "0.3-0.5-0.8-0.214");
        StringLevelMedium.put("Πόσο γρήγορη είναι η σκέψη; ( σε χμ)", "248 -258 -250 -254 ");
        StringLevelMedium.put("Που βρίσκεται η Κυανή Ακτή;", "Γαλλια-Αγγλια-Ρωσια-Ιταλια");
        StringLevelMedium.put(" Πόσα βιβλία της Παλαιάς Διαθήκης\n έγραψε ο Μωυσής; ", "5-4-3-6");
        StringLevelMedium.put("Ποιος είναι ο μακρινότερος πλανήτης \nτου ηλιακού μας συστήματος;", "πλουτονας-διας-ερμης-αρης");
        StringLevelMedium.put("Η κουκέτα είναι", " κρεβατι-τραπεζι-κουζινα-μπανιο");
        StringLevelMedium.put("Σε χώρα επινοήθηκε το golf;", "Σκωτια-Ουαλια-Αγγλια-Τσεχια");
        StringLevelMedium.put("Τί χρώμα έχει το «μαύρο κουτί» των αεροπλάνων; ", "Πορτοκαλι-Μαυρο-Μπλε-Ασπρο");
        StringLevelMedium.put("Τί ποσοστό σε νερό έχει κάθε αγγούρι; ", "97%-95%-99%-94%");
        StringLevelMedium.put("Πόσα μετρα μήκος έχουν συνολικά\n τα νεύρα του ανθρώπου; ", "70-60-50-80");
        StringLevelMedium.put("Kάθε πόσα χρόνια γιορτάζουν οι\n κινέζοι τα γενέθλειά τους;", "10-5-2-1");
        StringLevelMedium.put("πως ονομαζεται η περιοχη που αποθηκευει\n το xamster τις προμηθειες", "γναθοφυλακας-οψοφυλακιο-τροφοφυλακιο-μαρσιπο");
        StringLevelMedium.put("στα 100 χρονια ενας ανθροπος ποσα\n χρονια κοιμαται", "30-40-25-35");
        StringLevelMedium.put("ποσους νευρονες διαθετουμε", "100000000-100000-10000000-10000000000");
        StringLevelMedium.put("πως λεγεται η επιστημη που μελετα την γη ", "πεδολογια-γεωγραφια-πετρολογια-γεωλογια");
        StringLevelMedium.put("ο γαλιλαιος ηταν ?", "ιταλος-γαλος-πολωνος-ιρλανδος");
        StringLevelMedium.put("πως ανακαληψε ο μοναχος Μεντελ \nτους νομους της κληρονομικοτητας", "διασταυρονοντας μοσχομπιζελα- μελετοντας ποντικια-μελετωντας τα δροσοφυλα-επιφωτηση");
        StringLevelMedium.put("ποιος εδοσε το ονομα στο οξυγονο ", "Λαβουαζιε-Μοντελιε-Σιλε-Πριστλει");
        StringLevelMedium.put("ποια τανια ΔΕΝ ειναι του Σπιλμπεργκ ", "ο μονομαχος-λιστα του σιντλερ-ο εξογηινος- τα σαγωνια του καρχαρια ");
        StringLevelMedium.put("ποσους πλανητες εχει το ηλιακο μας συστημα", "8-7-9-10");
        StringLevelMedium.put("ποιοι λατρευαν το καλαμποκοι ως θεο", "μαγια-ινγκας-μασσαι-αιγιπτυοι");
        StringLevelMedium.put("ποια η ποιο ανυδρη ερημος", "ατακαμα-της αριζονας -ατογιαμα-σαχαρα");
        StringLevelMedium.put("οι πιο ψηλοι καταρακτες ειναι ", "σαλτο ανχερ-τουγκελα-ουτιγκαρτ-νιαγαρα");
        StringLevelMedium.put("ποσα μυρμιγκια πιιανει με την \n γλωσσα του ο μεγαλος\n μυρμιγκοφαγος", "35000-5000-15000-25000");
        StringLevelMedium.put("απο ποσους σπονδυλους αποτελειτε ο\n λαιμος της καμηλοπρδαλης", "7-15-132-245");
        StringLevelMedium.put("το ονομα του διαστημικου σταθμου μιρ σημαινει\n στα ρωσικα ?", "ειρηνη-διαστημα-διαστημικος σταθμος-νεα γη");
        StringLevelMedium.put("για ποια επιστημη δεν υπαρχει βραβειο νομπελ", "μαθηματικα-φυσικη-ιατρικη-σε ολες υπαρχει");
        StringLevelMedium.put("ενας κομβιοσυλεκτης τι συλλεγει", "κουμπια-γραμματοσημα-σπιρτοκουτα-τηλεκαρτες");
        StringLevelMedium.put("ποσα αστερια υπαρχουν στην \nσημαια της ευροπαικης ενωσης", "12-18-25-34");
        StringLevelMedium.put("το γηρεοτερο δενδρο του κοσμου θα\n μπορουσε να σβησει ποσα κερακια", "4770-1512-12760-8423");
        StringLevelMedium.put("ποια η θερμοκρασια της λαβας \nπου βγαινει απο υφαιστιο", "1200-900-2200-3450");
        StringLevelMedium.put("οι πυγμαιοι κατηκουν στην", "αφρικη-νοτια αμερικη-ωκαιανια-βορεια αμερικη");
        StringLevelMedium.put("πρωτου ονομαστει Nεα Yορκη η \nπολη αυτη λεγοταν ", "Νεο Αμστερνταμ-ΝεαΒενετια-Νεο Χαρλεμ-Νεο Λονδινο");
        StringLevelMedium.put("ενα μιλι ποσα μετρα ειναι", "1600-1200-1800-900");
        StringLevelMedium.put("γιατι το μαμουθ δεν ηταν\n ευαισθητο στο κρυο", "και τα 3-εχει μακρυ τροχωμα-ηταν πολυ παχυ-ειχε βαλβιδα στον προκτο");
        //46
        StringLevelHard.put("Η Γη από την Σελήνη απέχει", "384.403-384.413-384.404-384.414");
        StringLevelHard.put("Σε ποιον πλανήτη βρίσκεται η \nερυθρή κηλίδα?", "διας-ερμης-αρης-ποσιδονας");
        StringLevelHard.put("Σε τι ρυθμό χορεύουμε βαλς?", "3/4-3/5-3/6-3/2");
        StringLevelHard.put("Πότε γράφτηκε το Ρωμαίος και Ιουλιέτα?", "1594-1584-1694-1674");
        StringLevelHard.put("ποιοος βαφτισε τους δινοσαυρους", "ριτσαρντ οουενς-νορμαν ντινο-τζεσσε ουενς-στανλει ουενς");
        StringLevelHard.put("ο ιατρικος ορος για τον πονοκεφαλο", "κεφαλολαγνια-πονοκεφαλος-κρανολογια-εγκεφαλοφαλγια");
        StringLevelHard.put("ποτε ανακαλυψε ο ανθροπος την φωτια  \n(πριν ποσα χρονια) ", " 400.000-1.000.000-790.000-960.000");
        StringLevelHard.put("ποιος εφτασε πρωτος στον βορειο πολο", "ρομπερτ πιρυ-φρεντερικ κουκ-τζειμς κουκ -φρανκ πιρυ");
        StringLevelHard.put("ποια χρονια γραφτικε ο ευροπαικος υμνος", "1823-1859-1879-1894");
        StringLevelHard.put("τι ειναι ο μπονμπο ?", "πιθικος-αντιλοπη-φιδι-ειδος σκυλου");
        StringLevelHard.put("το μεσο υψος ενος αντρα\n στην ευροπη", "1.76-1.75-1.73-1.78");
        StringLevelHard.put("ο εφευρετης της πρωτης υπολογιστικης\n μηχανης", "Σικαρτ-Λαβουαζιε-Πασχαλ-Ντα Βιντσι");
        StringLevelHard.put("ποιος ειναι ο πατερας της γεωμετριας", "Ευκλειδης-Θαλης-Πηθαγορας-Αριστοτελης");
        StringLevelHard.put("ποιος θεωρειτε ο πατερας της\n φιλοσοφιας παρολο που δεν\n εγραψε τιποτα", "Σωκρατης-Αριστοφανης-Πλατωνας-Ξενοφωντας");
        StringLevelHard.put("πως ονομαζεται μια υποβρυχια οροσειρα", "μεσοκεανια ραχη-μεσοκαιανιος υφαλος-μεσοκαιανια μεση-μεσοκαιανιος αυχενας");
        StringLevelHard.put("ποιο ειναι το μαυροσικαλο ", "φαγοπυρο-σικαλη-σιταρι-αλευροσιταρο");
        StringLevelHard.put("πριν απο 230 εκτομυρια χρονια η γη\n περιλαμβανε μοναχα μια ηπειρο , \nπως λεγωταν αυτη", "παγγαια-ταγγεραια-καμπραια-ιαλλαια");
        StringLevelHard.put("ποια η νοτιοτερη προτευουσα\n στον κοσμο", "ουελινγκτον(νεα ζηλαδια)-ουσουαια(αργεντινη)-σαντιαγκο(χιλη)-καμπερα(αυστραλια)");
        StringLevelHard.put("ποιο απο τα νησια βρισκετε στην ευροπη", "μπελ ιονον μερ-μαρι γκαλαντ-σευμουρ-σαιντ βινσετ ");
        StringLevelHard.put("σε ποιον ανηκουν οι νυσοι Γκαλαπαγκος", "Ισημερικο-και στους 3-Περου-Βενεζουελα");
        StringLevelHard.put("σε ποια απο τις χωρες δεν περνα ο ρινος(ποταμι)", "Βελγιο-Ελβετια-Ολανδια-Γαλια");
        StringLevelHard.put("ποιος ειναι ο αρχαιοτερος πολλιτισμος", "Μαγια-Ινγκας-Μασσαι-και οι 3 ");
//23
    }

    @SuppressWarnings("deprecation")
    public void makeLevel(int lvl, Hashtable StringLevel) {
        this.level = lvl;
        nxtQuest.setToolTipText(" skip this question ");
        fifty.setToolTipText(" leaves 2 boxes  ");
        nxtQuest.addActionListener(skipQuestion);
        fifty.addActionListener(fiftyFifty);
        for (int i = 0; i <= 3; i++) {
            this.add(questionButton[i]);
            this.add(frame.getMusicCombo());
        }
        questionButton[0].setSelected(false);
        questionButton[1].setSelected(false);
        questionButton[2].setSelected(false);
        questionButton[3].setSelected(false);



        int xx = (int) (Math.random() * StringLevel.size());
        Iterator iter = StringLevel.keySet().iterator();
        int count = 0;
        if (!StringLevel.isEmpty() && level <= 45) {
            while (iter.hasNext()) {
                try {
                    String quest = (String) iter.next();
                    String ansers = (String) StringLevel.get(quest);
                    String[] splitAnsers = ansers.split("-");

                    if (xx == count) {
                        addToQuestionsTable(quest, splitAnsers[0], splitAnsers[1], splitAnsers[2], splitAnsers[3]);

                        setOnScrnTheQuestions();

                        removingDataFtomHasTable = quest;
                    }
                    count++;
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println(e.getMessage());
                    e.printStackTrace();
                }
            }
        } else {
            screen.setText("no more Congratulations you are the \n master of the Game for More info \n check  mrtsoglanakos.game.gr :P ");
            time.stop();
            questionButton[0].setText("cong");
            questionButton[0].removeActionListener(action);
            questionButton[1].setText("rat");
            questionButton[2].setText("ulat");
            questionButton[3].setText("ions");
            questionButton[1].removeActionListener(action);
            questionButton[2].removeActionListener(action);
            questionButton[3].removeActionListener(action);
            new Thread() {

                int locX0 = 50, locY0 = 400, locX1 = 350, locY1 = 400, locX2 = 55, locY2 = 500, locX3 = 350, locY3 = 500;

                @Override
                public void run() {
                    try {
                        fifty.removeActionListener(fiftyFifty);
                        nxtQuest.removeActionListener(skipQuestion);
                        questionButton[0].setSelected(false);
                        questionButton[1].setSelected(false);
                        questionButton[2].setSelected(false);
                        questionButton[3].setSelected(false);
                        while (locY0 > 340) {
                            this.sleep(10);
                            questionButton[0].setLocation(locX0--, locY0--);
                            panel.repaint();
                        }
                        while (locY1 > 370) {
                            this.sleep(10);
                            questionButton[1].setLocation(locX1--, locY1--);
                            panel.repaint();
                        }
                        while (locX1 > 60) {
                            this.sleep(5);
                            questionButton[1].setLocation(locX1--, locY1);
                            panel.repaint();
                        }
                        while (locY2 > 400) {
                            this.sleep(10);
                            questionButton[2].setLocation(locX2--, locY2--);
                            panel.repaint();
                        }
                        while (locX2 < 100) {
                            this.sleep(10);
                            questionButton[2].setLocation(locX2++, locY2);
                            panel.repaint();
                        }
                        while (locY3 > 300) {
                            this.sleep(10);
                            questionButton[3].setLocation(locX3--, locY3--);
                            panel.repaint();
                        }
                        while (locY3 < 430) {
                            this.sleep(10);
                            questionButton[3].setLocation(locX3, locY3++);
                            panel.repaint();
                        }
                        this.sleep(2000);
                        new Base(panel);








                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
            }.start();

        }













    }

    @SuppressWarnings("deprecation")
    public void gameOver(boolean gameIsOverFromFalseAnsweres) {
        if (gameIsOverFromFalseAnsweres) {
            screen.setText("you make 3 mistakes  \n Game is Over ");

            time.stop();
        } else {
            screen.setText("Time Is Up");

        }
        questionButton[0].setText("");
        questionButton[0].removeActionListener(action);
        questionButton[1].setText("");
        questionButton[2].setText("");
        questionButton[3].setText("");
        questionButton[1].removeActionListener(action);
        questionButton[2].removeActionListener(action);
        questionButton[3].removeActionListener(action);
        nxtQuest.removeActionListener(skipQuestion);
        fifty.removeActionListener(fiftyFifty);


        new Thread() {

            @Override
            public void run() {
                try {
                    this.sleep(3000);
                    new Base(panel);
                } catch (Exception e) {
                }
            }
        }.start();
    }

    public void addToQuestionsTable(String question, String trueAnser, String f1, String f2, String f3) {
        Iterator iter = questionsWithAnser.keySet().iterator();
        while (iter.hasNext()) {

            String quest = (String) iter.next();
            questionsWithAnser.remove(quest);
        }

        String s = trueAnser + "-" + f1 + "-" + f2 + "-" + f3;
        questionsWithAnser.put(question, s);


    }

    public void setOnScrnTheQuestions() {
        int xx = (int) (Math.random() * questionsWithAnser.size());
        Iterator iter = questionsWithAnser.keySet().iterator();
        int count = 0;
        toChooseButtonText.add(questionButton[3]);
        toChooseButtonText.add(questionButton[2]);
        toChooseButtonText.add(questionButton[1]);
        toChooseButtonText.add(questionButton[0]);

        while (iter.hasNext()) {

            String quest = (String) iter.next();
            String ansers = (String) questionsWithAnser.get(quest);
            String[] splitAnsers = ansers.split("-");
            trueAnswere = splitAnsers[0];

            if (count == xx) {
                screen.setText(quest);
                int chooseFalse = (int) (Math.random() * 3) + 1;

                for (int i = 0; i < 4; i++) {
                    int sze = (int) (Math.random() * toChooseButtonText.size());

                    JButton bbb = (JButton) toChooseButtonText.get(sze);
                    bbb.setText(splitAnsers[i]);

                    toChooseButtonText.remove(bbb);
                    if (i == 0) {
                        trueButton = bbb;

                    }

                    if (chooseFalse == i) {



                        choosenToShowfalseButton = bbb;
                    }


                }

                /// gia na pernei true false xwris na deixnei exra parathira(jbuttons)
                for (int i = 0; i < 4; i++) {
                    int toGo;
                    if (questionButton[i].getText().equals(" ")) {
                        if (i == 0 && !questionButton[3].getText().equals(" ")) {
                            questionButton[i].setText(questionButton[3].getText());
                            questionButton[3].setText(" ");
                        } else if (i == 0 && !questionButton[2].getText().equals(" ")) {
                            questionButton[i].setText(questionButton[2].getText());
                            questionButton[2].setText(" ");
                        } else if (i == 1 && !questionButton[3].getText().equals(" ")) {
                            questionButton[i].setText(questionButton[3].getText());
                            questionButton[3].setText(" ");
                        } else if (i == 1 && !questionButton[2].getText().equals(" ")) {
                            questionButton[i].setText(questionButton[2].getText());
                            questionButton[2].setText(" ");
                        } else {
                            this.remove(questionButton[i]);
                        }
                        nxtQuest.removeActionListener(skipQuestion);
                        fifty.removeActionListener(fiftyFifty);
                        nxtQuest.setToolTipText(null);
                        fifty.setToolTipText(null);
                    }


                }








            }
            count++;
        }



    }
    ActionListener action = new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            JButton b = (JButton) e.getSource();
            if (canPressAnotherButton) {

                canPressAnotherButton = false;
                if (b.getText().equals(trueAnswere)) {
                    System.out.println("trueee");
                    // answereTrue = true;
                    new ThreadToCheckAnswere(panel, false, true, b, time).run();
                } else {
                    System.out.println("false the true is  " + trueAnswere);

                    coutFalseAnswers++;
                    if (coutFalseAnswers >= 3) {
                        new Music("wha-wha");
                        gameOver(true);

                        return;
                    }
                    new ThreadToCheckAnswere(panel, true, false, b, time).run();
                }

            }


        }
    };

    @Override
    public void paint(Graphics gg) {
        super.paint(gg);
        Graphics2D g = (Graphics2D) gg;
        Font f = new Font("", Font.BOLD, 20);
        gg.setFont(f);
        if (answereFalse) {
            gg.drawString("wrong", 300, 500);
            answereFalse = false;
            new Thread() {

                @Override
                public void run() {
                    try {
                        this.sleep(100);
                        for (int i = 0; i < 4; i++) {
                            questionButton[i].setBackground(Color.white);
                        }
                        this.sleep(600);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                    panel.repaint();
                }
            }.start();
        }
        if (answereTrue) {
            gg.drawString("correct", 300, 500);

            answereTrue = false;
            new Thread() {

                @Override
                public void run() {
                    try {
                        this.sleep(100);
                        for (int i = 0; i < 4; i++) {
                            questionButton[i].setBackground(Color.white);
                        }
                        this.sleep(600);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                    panel.repaint();
                }
            }.start();
        }
        Font ff = new Font("", Font.ITALIC, 10);
        g.setFont(ff);
        g.drawString(drawLevel + " Mode", 300, 300);

    }
    ActionListener fiftyFifty = new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            JButton b = (JButton) e.getSource();
            panel.remove(b);
            panel.repaint();
            for (int i = 0; i < 4; i++) {
                if (questionButton[i] != trueButton && questionButton[i] != choosenToShowfalseButton) {
                    questionButton[i].setText("");
                }
            }
        }
    };
    ActionListener skipQuestion = new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            JButton b = (JButton) e.getSource();
            panel.remove(b);
            panel.repaint();
            System.out.println("tru answere " + trueAnswere);
            new ThreadToCheckAnswere(panel, false, true, time, false).start();
        }
    };
}
