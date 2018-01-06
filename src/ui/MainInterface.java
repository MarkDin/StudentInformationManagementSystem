package ui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

import student.Student;
import students.Students;


public class MainInterface extends JFrame {
	Student stu;
	Students list = new Students();
	Button bt1 = new Button("���");
	Button bt2 = new Button("��ѯ");
	Button bt3 = new Button("�޸�");
	Button bt4 = new Button("ɾ��");
	Button bt5 = new Button("�˳�����");
	//
	JPanel panle_south = new JPanel();// ������
	PicPanel panle_north = new PicPanel("src/pic/01.jpg");// ͼƬ��
	JPanel students = new JPanel();// ��ʾ���ѧ����Ϣ���
	//
	JDialog query = new JDialog();// ��ѯ����Ի���

	public MainInterface() {
		//
		// panle_north.add(new JLabel("�˴���ͼƬ"));
		panle_south.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 30));
		panle_south.add(bt1);
		panle_south.add(bt2);
		panle_south.add(bt3);
		panle_south.add(bt4);
		panle_south.add(bt5);
		//
		MyListener l = new MyListener();
		bt1.addActionListener(l);
		bt2.addActionListener(l);
		bt3.addActionListener(l);
		bt4.addActionListener(l);
		bt5.addActionListener(l);
		//
		this.setLayout(new BorderLayout());
		this.add(panle_north, BorderLayout.CENTER);
		this.add(panle_south, BorderLayout.SOUTH);
		this.setTitle("ѧ����Ϣ����ϵͳ");
		this.setSize(500, 400);
		this.setLocation(200, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);

	}

	class MyListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String cmd = e.getActionCommand();
			switch (cmd) {
			case "���":
				new Add();
				System.out.println(cmd);
				break;
			case "��ѯ":
				new Query();
				System.out.println(cmd);
				break;
			case "�޸�":
				new Alter();
				System.out.println(cmd);
				break;
			case "ɾ��":
				Delete delete = new Delete();
				System.out.println(cmd);
				break;
			case "�˳�����":
			
				System.exit(0);
				System.out.println(cmd);
				break;
			}
			
		}
	}
}
