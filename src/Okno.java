import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Okno extends JFrame {

    public Okno() {
        init();
    }

    private JButton[][] tlac = new JButton[10][10];
    private boolean[][] miny = new boolean[10][10];

    private void init() {
        int x = 20;
        int y = 20;
        int[][] rndm = new int[2][10];
        for (int i = 0; i < rndm.length; i++) {
            for (int j = 0; j < rndm[i].length; j++) {
                rndm[i][j] = (int) (Math.random() * 10);
                System.out.println(rndm[0][j] + " " + rndm[1][j]);
            }
        }
        for (int i = 0; i < rndm.length; i++) {
            for (int j = 0; j < rndm[i].length; j++) {
                miny[rndm[0][j]][rndm[1][j]] = true;
            }
        }

        for (int i = 0; i < tlac.length; i++) {
            for (int j = 0; j < tlac[i].length; j++) {
                tlac[i][j] = new JButton();
                tlac[i][j].setBounds(x, y, 50, 50);
                x += 50;

                int finalI = i;
                int finalJ = j;
                tlac[i][j].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (miny[finalI][finalJ] == true) {
                            tlac[finalI][finalJ].setText("B");
                        } else {
                            tlac[finalI][finalJ].setText("C");
                        }

                    }
                });

                this.add(tlac[i][j]);
            }

            x = 20;
            y += 50;
        }


        this.setSize(800, 600);
        this.setDefaultCloseOperation(3);
        this.setLayout(null);
        this.setVisible(true);
    }
}

