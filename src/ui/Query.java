package ui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import student.Student;
import students.Students;

public class Query extends JFrame {
	Student stu;
	Students list;
	GradeTable table;
	JButton enter;
	JRadioButton c1;
	JRadioButton c2;
	ButtonGroup group;
	JPanel panel1;
	JPanel panel2;
	JPanel panel3;
	JTextField text;
	JLabel title;
	
	public Query() {
		table = new GradeTable();
		title = new JLabel("������ѧ�����");// ��ʾ��Ϣ
		text = new JTextField(20);// ��ѯ�����
		panel1 = new JPanel();
		panel2 = new JPanel();
		panel3 = new JPanel();
		enter = new JButton("��ѯ");
		c1 = new JRadioButton("����Ų�ѯ");
		c2 = new JRadioButton("��������ѯ");
		group = new ButtonGroup();
		c1.setSelected(true);
		group.add(c1);
		group.add(c2);
		panel1.add(title);
		panel2.add(text);
		panel2.add(c1);
		panel2.add(c2);
		panel3.add(enter);
		this.add(panel1, BorderLayout.NORTH);// BorderLayout
		this.add(panel2, BorderLayout.CENTER);
		this.add(panel3, BorderLayout.SOUTH);
		this.setSize(300, 200);
		this.setLocation(200, 100);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(true);
		MyListener l = new MyListener();
		c1.addActionListener(l);
		c2.addActionListener(l);
		enter.addActionListener(l);
	}

	public boolean is_digit(String content) {
		String pattern = "^\\d+";
		boolean isMatch = Pattern.matches(pattern, content);
		return isMatch;
	}

	class MyListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			boolean flag = true;
			if (c1.isSelected()) {// ��ʾ����Ų�ѯ
				flag = true;
				title.setText("������ѧ�����");
			} else {
				flag = false;
				title.setText("������ѧ������");
			}
			if (e.getSource() == enter) {
				String content = text.getText();// �ı�������
				if (content.equals("")) {// ����Ϊ��
					new TipDialog("����Ϊ�գ�����������");
				} else {// ���벻Ϊ��
					if (flag) {// ���ݱ�Ų���
						if (is_digit(content)) {
							dispose();
							stu = list.query_by_id(Integer.parseInt(content));
							if (stu == null) {// ���ѧ���Ҳ���
								new TipDialog("����ʧ�ܣ��ñ��ѧ��������");
							} else {
								table.setVisible(true);
								table.add_row(stu);
							}
						} else {
							new TipDialog("����������");
						}
					} else {// ������������
						if(!is_digit(content)) {
							dispose();
							stu = list.query_by_name(content);
							if (stu == null) {// ���ѧ���Ҳ���
								new TipDialog("����ʧ�ܣ�������ѧ��������");
							} else {
								table.setVisible(true);
								table.add_row(stu);
							}
						} else {
							new TipDialog("����������");
						}//else
					} // else
				} // else
			} // if
		}// actionPerformed
	}// class
}
