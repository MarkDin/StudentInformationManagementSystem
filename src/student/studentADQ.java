package student;

import java.util.Scanner;

public class studentADQ {
	int id;
	String name;
	String sex;
	int age;
	int math;
	int computer;
	int Flanguage;
	// add
	Scanner in = new Scanner(System.in);

	public Boolean add() {
		Student stu = null;
		// id
		System.out.println("��������");
		id = in.nextInt();
		stu.setId(id);
		// name
		System.out.println("����������");
		name = in.next();
		stu.setName(name);
		// sex
		System.out.println("�������Ա�");
		sex = in.next();
		stu.setSex(sex);
		// age
		System.out.println("����������");
		age = in.nextInt();
		stu.setAge(age);
		// math
		System.out.println("��������ѧ�ɼ�");
		math = in.nextInt();
		stu.setMath(math);
		// computer
		System.out.println("�����������ɼ�");
		computer = in.nextInt();
		stu.setComputer(computer);
		// Flanguage
		System.out.println("����������ɼ�");
		Flanguage = in.nextInt();
		stu.setFlanguage(Flanguage);
		return true;
	}

	

	

}
