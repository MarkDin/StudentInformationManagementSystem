package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

public class MyPanel extends JPanel implements Runnable
{
    int times=0;

    //���忪ʼ
    @Override
	public void paint(Graphics g)
    {
        super.paint(g);
        //g.fillRect(0, 0, 500, 100);//����ɫ����
        if(times%2==0)
        {
            g.setColor(Color.black);
            //������Ϣ������					
            Font myFont=new Font("������κ",Font.BOLD,20);
            g.setFont(myFont);
            g.drawString("����", this.getWidth()-85, 20);
            g.setColor(Color.BLUE);
            g.drawString("������", this.getWidth()-85, 40);
            g.setColor(Color.yellow);
            g.drawString("������", this.getWidth()-85, 60);
        }
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        while(true)
        {
            //����
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

                times++;
                //�ػ�
                this.repaint();
        }
    }
}