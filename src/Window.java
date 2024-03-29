import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class Window extends JFrame {
    //TO DO ファイルの場所指定
    //TO DO PDFの名前の指定
    //TO DO PDFをPNGに変換するボタン
    //TO DO JSONについかするボタン
    //TODO 変換のプレビュー
    //TODO JSONから消す場所の指定
    //TODO JSONから消すボタン
    //TODO josnのnumを指定するtextfield
    //TODO デザインやりなおし


    private JPanel p0;
    private JPanel p1;
    private JPanel p2;
    private JPanel p3;
    private JPanel p4;
    private JPanel p5;
    private JPanel p6;
    private JLabel l0;
    private JLabel jl;
    private JTextField area0;
    private JTextField area1;
    private JTextField area2;
    private JButton conB;
    private JButton addB;
    private JButton loadB;
    private JButton removeB;
    private JComboBox<String> combo;
    DefaultComboBoxModel model;

    private Conversion con;
    private Json json;
    private Previwe pre;

    Window(String title){
        setTitle(title);
        setBounds(100, 100, 500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        json =  new Json();

        addCon();
        setVisible(true);

        con = new Conversion();
        pre = new Previwe();
    }

    private void addCon(){
        p0 = new JPanel();
        p1 = new JPanel();
        p2 = new JPanel();
        p3 = new JPanel();
        p4 = new JPanel();
        p5 = new JPanel();
        p6 = new JPanel();
        l0 = new JLabel();
        p0.setLayout(new BoxLayout(p0, BoxLayout.Y_AXIS));
        p1.setLayout(new BoxLayout(p1, BoxLayout.LINE_AXIS));
        p2.setLayout(new BoxLayout(p2, BoxLayout.LINE_AXIS));
        p3.setLayout(new BoxLayout(p3, BoxLayout.LINE_AXIS));
        p6.setLayout(new BoxLayout(p6, BoxLayout.LINE_AXIS));

        area0 = new JTextField("",30);
        area1 = new JTextField("");
        area2 = new JTextField("");
        model = new DefaultComboBoxModel();
        combo = new JComboBox<>(model);
        conB = new JButton("get");
        loadB = new JButton("load");
        addB = new JButton("Add");
        removeB = new JButton("remove");
        jl = new JLabel();

        //ボタンのイベント処理
        conB.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                conBEve();
            }
        });
        addB.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                addBEve();
            }
        });
        removeB.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                removeBEve();
            }
        });
        loadB.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                loadBEve();
            }
        });

        p1.add(area0);
        p1.add(loadB);
        p2.add(area1);
        p2.add(conB);
        p3.add(combo);
        p3.add(removeB);
//        p4.add(jl);
//        p5.add(l0);
        p6.add(area2);
        p6.add(addB);

        getRootPane().setDefaultButton(conB);

        p0.add(p1);
        p0.add(p2);
        p0.add(p3);
//        p0.add(p4);
//        p0.add(p5);
        p0.add(p6);
        getContentPane().add(p0, BorderLayout.NORTH);
        repaint();
    }

    private void conBEve(){
        PdfToPng p2p = new PdfToPng(area0.getText());
        p2p.conversion(area1.getText());
        PreWindow previwe = new PreWindow(area0.getText()+"\\pic\\"+area1.getText(),area0.getText(),area1.getText());
        repaint();
        area1.setText(""+(Integer.valueOf(area1.getText())+1));
    }

    private void addBEve(){
        Random rand = new Random();
        json.reload();
        json.addAnode("pic/"+area2.getText()+".png",rand.nextInt(2)+1,rand.nextInt(2));
        json.outputJsonFile();
        reloadCombo();
    }
    private void loadBEve(){
        System.out.println(area0.getText());
        json.setPath(area0.getText());
        json.reload();
        reloadCombo();
    }
    private void removeBEve(){
        json.reload();
        json.removeAnode(Integer.valueOf(combo.getSelectedIndex()));
        json.outputJsonFile();
        reloadCombo();
    }

    private void reloadCombo(){
        for(int i =0;i<model.getSize();i++){
            model.removeAllElements();
        }
        addCombo();
    }

    private void addCombo(){
        String[] a = json.getAnode();
        for(String name : a){
            model.addElement(name);
        }
    }
}
