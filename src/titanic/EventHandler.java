/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package titanic;

//Needed Imports
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JLabel;
import javax.swing.JPanel;
import titanic.gui.MainTitanicWindow;
import titanic.gui.SectionPanel;
import titanic.gui.StartPanel;
import titanic.gui.conceptdesign.ConceptDesign;
import titanic.gui.detaildesign.DetailDesign;
import titanic.gui.needsfinding.DrawPanel;
import titanic.gui.needsfinding.GeneratePanel;
import titanic.gui.needsfinding.NeedsFindingPanel;
import titanic.gui.needsfinding.WritePanel;
import titanic.gui.support.MeetingPanel;
import titanic.gui.support.SupportPanel;
import titanic.gui.support.WhiteboardPanel;

/**
 *
 * @author Menes
 */
public class EventHandler implements ActionListener{
    
    //Private class attributes
    private JPanel targetPanel;
    private JLabel currentState;
    
    //Panels
    private StartPanel startPanel;
    private SectionPanel sectionPanel;
    private SupportPanel supportPanel;
    private MeetingPanel meetingPanel;
    private WhiteboardPanel whiteboardPanel;   
    private NeedsFindingPanel needsFindingPanel;
    private GeneratePanel generatePanel;
    private WritePanel writePanel;
    private DrawPanel drawPanel;
    private ConceptDesign conceptDesign;
    private DetailDesign detailDesign;
           
    
    //Commands for StartPanel
    private static final String NEW_PROJECT = "NUEVO_PROYECTO";
    private static final String CREATE_USER = "CREAR_USUARIO";
    private static final String OPEN_PROJECT = "ABRIR_PROYECTO";
    
    //Commands for SectionPanel    
    private static final String SUPPORT = "HERRAMIENTAS_SOPORTE";
    private static final String NEEDS_FINDING = "BUSQUEDA_NECESIDADES";
    private static final String CONCEPT_DESIGN = "DISENO_CONCEPTUAL";
    private static final String DETAIL_DESIGN = "DISENO_DETALLE";
    
    //Commands for SupportPanel
    private static final String MEETING = "REUNION";
    private static final String WHITEBOARD = "WHITEBOARD";
    
    //Commands for MeetingPanel
    private static final String BEGIN_VOICE_CALL = "VOICE_CALL";
    private static final String BEGIN_VIDEO_CALL = "VIDEO_CALL";
    private static final String ONLY_BEGIN = "BEGIN";
    
    //Commands for NeedsFindingPanel
    private static final String NF_GENERATE = "BN_GENERAR";
    private static final String NF_WRITE = "BN_ESCRIBIR";
    private static final String NF_DRAW = "BN_DIBUJAR";
            
    public EventHandler( MainTitanicWindow mtw ){
        targetPanel = mtw.getMainPanel();
        currentState = mtw.getCurrentCompLabel();
        startPanel = new StartPanel();
        sectionPanel = new SectionPanel();
        supportPanel = new SupportPanel();
        meetingPanel = new MeetingPanel();
        whiteboardPanel = new WhiteboardPanel();
        needsFindingPanel = new NeedsFindingPanel();
        generatePanel = new GeneratePanel();
        writePanel = new WritePanel();
        drawPanel = new DrawPanel();
        conceptDesign = new ConceptDesign();
        detailDesign = new DetailDesign();
        
        setStartPanel();
        setStartPanelCommands();
        setSectionPanelCommands();
        setSupportPanelCommands();
        setMeetingPanelCommands();
        setNeedsFindingPanelCommands();
       
        setBackLabels();
    }
    
    //Starts the GUI with its initial panel
    private void setStartPanel(){
        targetPanel.add(startPanel, BorderLayout.CENTER);
    }
    
    //Sets the commands for the diferent buttons on the panels
    private void setStartPanelCommands(){
        startPanel.getNewProjectButton().addActionListener(this);
        startPanel.getNewUserButton().addActionListener(this);
        startPanel.getOpenProyectButton().addActionListener(this);
        
        startPanel.getNewProjectButton().setActionCommand( NEW_PROJECT );
        startPanel.getNewUserButton().setActionCommand( CREATE_USER );
        startPanel.getOpenProyectButton().setActionCommand( OPEN_PROJECT );
    }
    private void setSectionPanelCommands(){
        sectionPanel.getSupportButton().addActionListener(this);
        sectionPanel.getNeedsFindingButton().addActionListener(this);
        sectionPanel.getConceptDesignButton().addActionListener(this);
        sectionPanel.getDetailDesignButton().addActionListener(this);
        
        sectionPanel.getSupportButton().setActionCommand( SUPPORT );
        sectionPanel.getNeedsFindingButton().setActionCommand( NEEDS_FINDING );
        sectionPanel.getConceptDesignButton().setActionCommand( CONCEPT_DESIGN );
        sectionPanel.getDetailDesignButton().setActionCommand( DETAIL_DESIGN );
    }
    private void setSupportPanelCommands(){
        supportPanel.getMeetingButton().addActionListener(this);
        supportPanel.getWhiteboardButton().addActionListener(this);
        
        supportPanel.getMeetingButton().setActionCommand(MEETING);
        supportPanel.getWhiteboardButton().setActionCommand(WHITEBOARD);
    }
    private void setMeetingPanelCommands(){
        meetingPanel.getStartAudioMeetingButton().addActionListener(this);
        meetingPanel.getStartVideoCallMeetingButton().addActionListener(this);
        meetingPanel.getStartMeetingButton().addActionListener(this);
        
        meetingPanel.getStartAudioMeetingButton().setActionCommand( BEGIN_VOICE_CALL );
        meetingPanel.getStartVideoCallMeetingButton().setActionCommand(BEGIN_VIDEO_CALL);
        meetingPanel.getStartMeetingButton().setActionCommand(ONLY_BEGIN);
    }
    private void setNeedsFindingPanelCommands(){
        needsFindingPanel.getGenerateButton().addActionListener(this);
        needsFindingPanel.getWriteButton().addActionListener(this);
        needsFindingPanel.getDrawButton().addActionListener(this);
        
        needsFindingPanel.getGenerateButton().setActionCommand(NF_GENERATE);
        needsFindingPanel.getWriteButton().setActionCommand(NF_WRITE);
        needsFindingPanel.getDrawButton().setActionCommand(NF_DRAW);
    }
    
    //Changes from the target outPanel for inPanel
    public void putPanel( JPanel inPanel, JPanel outPanel ){
        targetPanel.remove(outPanel);
        targetPanel.add(inPanel, BorderLayout.CENTER);
    }    
    
    //Sets de behavior for the labels "back"
    private void setBackLabels() {
        supportPanel.getReturnBackLabel().addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                putPanel(sectionPanel, supportPanel);
                currentState.setText( "Secciones" );
                targetPanel.updateUI();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
        whiteboardPanel.getReturnBackLabel().addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                putPanel(sectionPanel, whiteboardPanel);
                currentState.setText( "Secciones" );
                targetPanel.updateUI();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
        needsFindingPanel.getReturnBackLabel().addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                putPanel(sectionPanel, needsFindingPanel);
                currentState.setText("Secciones");
                targetPanel.updateUI();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
        generatePanel.getReturnBackButton().addMouseListener( new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                putPanel(needsFindingPanel, generatePanel);
                currentState.setText( "Busqueda de Necesidades" );
                targetPanel.updateUI();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
        writePanel.getReturnBackLabel().addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                putPanel(needsFindingPanel, writePanel);
                currentState.setText( "Busqueda de Necesidades" );
                targetPanel.updateUI();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
        drawPanel.getReturnBackLabel().addMouseListener( new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                putPanel(needsFindingPanel, drawPanel);
                currentState.setText( "Busqueda de Necesidades" );
                targetPanel.updateUI();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
        conceptDesign.getReturnBackLabel().addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                putPanel(sectionPanel, conceptDesign);
                currentState.setText( "Secciones" );
                targetPanel.updateUI();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
        detailDesign.getReturnBackLabel().addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                putPanel(sectionPanel, detailDesign);
                currentState.setText("Secciones");
                targetPanel.updateUI();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
    }
    
    //Method implemented cuz ActionListener interface
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        
        /* StartPanel Commands */{
            if (command.equals(NEW_PROJECT)) {
                putPanel( sectionPanel, startPanel );
                currentState.setText("Secciones");
                targetPanel.updateUI();
                System.out.println(command);
                return;
            }
            if (command.equals(OPEN_PROJECT)) {
                putPanel( sectionPanel, startPanel );
                currentState.setText("Secciones");
                targetPanel.updateUI();
                System.out.println(command);
                return;
            }
            if (command.equals(CREATE_USER)) {
                System.out.println(command);
                return;
            }
        }
        /* SectionPanel Commands */ {
            if (command.equals(SUPPORT)) {
                putPanel(supportPanel, sectionPanel);
                targetPanel.updateUI();
                currentState.setText( "Soporte" );
                System.out.println(command);
                return;
            }
            if (command.equals(NEEDS_FINDING)) {
                putPanel( needsFindingPanel, sectionPanel );
                targetPanel.updateUI();
                currentState.setText("Busqueda de Necesidades");
                System.out.println(command);
                return;
            }
            if (command.equals(CONCEPT_DESIGN)) {
                putPanel( conceptDesign, sectionPanel );
                targetPanel.updateUI();
                currentState.setText("Diseño Conceptual");
                System.out.println(command);
                return;
            }
            if (command.equals(DETAIL_DESIGN)) {
                putPanel( detailDesign, sectionPanel );
                targetPanel.updateUI();
                currentState.setText("Diseño Detallado");
                System.out.println(command);
                return;
            }
        }
        /* SupportPanel Commands */{
            if (command.equals(MEETING)) {
                putPanel(meetingPanel, supportPanel);
                targetPanel.updateUI();
                currentState.setText( "Reunion" );
                System.out.println(command);
                return;
            }
            if (command.equals(WHITEBOARD)) {
                putPanel(whiteboardPanel, supportPanel);
                targetPanel.updateUI();
                currentState.setText( "Whiteboard" );
                System.out.println(command);
                return;
            }
        }
        /* MeetingPanel Commands */{
            if (command.equals(BEGIN_VOICE_CALL)  || command.equals(BEGIN_VIDEO_CALL) 
                    || command.equals(ONLY_BEGIN)) {
                putPanel(whiteboardPanel, meetingPanel);
                targetPanel.updateUI();
                currentState.setText( "Whiteboard" );
                System.out.println(command);
                return;
            }
        }
        /* NeedsFindingPanel Commands */{
            if( command.equals(NF_GENERATE) ){
                putPanel( generatePanel, needsFindingPanel );
                currentState.setText("Generar");
                targetPanel.updateUI();
                System.out.println(command);
                return;
            }
            if( command.equals(NF_WRITE) ){
                putPanel(writePanel, needsFindingPanel);
                currentState.setText("Escribir");
                targetPanel.updateUI();
                System.out.println(command);
                return;
            }
            if( command.equals(NF_DRAW) ){
                putPanel(drawPanel, needsFindingPanel);
                currentState.setText("Dibujar");
                targetPanel.updateUI();
                System.out.println(command);
                return;
            }
        }
        System.out.println( "Comando no reconocido" );
    }
}
