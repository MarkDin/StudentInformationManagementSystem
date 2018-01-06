package ui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import student.Student;
import students.Students;

public class Alter {
	Students list;
	Student stu;
	JPanel panel;
	JComboBox box;
	//GradeTable table;
	JTextField alter_text;
	JLabel lable;
	Query query;
	JFrame j;
	JPanel p;
	JPanel bt_panel;
	JButton alter;
	JButton close;
	JButton finish;
	JButton enter;
	public Alter() {
		alter = new JButton("�����޸�");
		close = new JButton("�޸Ľ���");
		p = new JPanel();
		p.add(alter);
		p.add(close);
		query = new Query();
		query.table.add(p, BorderLayout.SOUTH);
		alter.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Alter();
				stu = new Student();
				stu = query.stu;
			}
		});
		close.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				query.table.dispose();
			}
		});//ok
	}

	public void Alter() {
		j = new JFrame("�޸�");
		bt_panel = new JPanel();
		panel = new JPanel();
		box = new JComboBox();
		alter_text = new JTextField(20);
		enter = new JButton("ȷ���޸�");
		finish = new JButton("����޸�");
		lable = new JLabel("�����ı��������µ���Ϣ");
		box.addItem("��ѡ���޸ĵ���Ϣ");
		box.addItem("����");
		box.addItem("����");
		box.addItem("�Ա�");
		box.addItem("��ѧ����");
		box.addItem("���������");
		box.addItem("�������");
		panel.add(box);
		panel.add(alter_text);
		bt_panel.add(enter);
		bt_panel.add(finish);
		lable.setHorizontalAlignment(SwingConstants.CENTER);
		// text.setText("�����µ���Ϣ");
		//
		j.setLayout(new BorderLayout());
		j.add(lable, BorderLayout.NORTH);
		j.add(panel, BorderLayout.CENTER);
		j.add(bt_panel, BorderLayout.SOUTH);
		j.setSize(300, 160);
		j.setLocation(200, 400);
		j.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//
		j.setVisible(true);
		//
		box.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String item = (String)box.getSelectedItem();
				if(item.equals("��ѡ���޸ĵ���Ϣ")) {
					alter_text.setEditable(false);
				} else {
					alter_text.setEditable(true);
				}
			}
		});//box
		
		enter.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				boolean flag = true;
				String item = (String)box.getSelectedItem();
				String content = alter_text.getText();
				if(!content.equals("")) {
					switch(item) {
					case"��ѡ���޸ĵ���Ϣ":
						flag = false;
						new TipDialog("��ѡ��Ҫ�޸ĵ�ѧ����Ϣ");
						break;
					case"����":
						stu.setName(content);
						break;
					case"����":
						stu.setAge(Integer.parseInt(content));
						break;
					case"�Ա�":
						stu.setSex(content);
						break;
					case"��ѧ����":
						stu.setMath(Integer.parseInt(content));
						break;
					case"���������":
						stu.setComputer(Integer.parseInt(content));
						break;
					case"�������":
						stu.setFlanguage(Integer.parseInt(content));
						break;
					}
					if(flag)
						query.table.set_table(stu);
				} else {
					new TipDialog("����Ϊ��");
				}
				
			}//actionPerformed
		});//enter.addActionListener
		finish.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				j.dispose();
			}
		});
	}//Alter
}
