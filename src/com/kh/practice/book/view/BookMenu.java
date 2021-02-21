package com.kh.practice.book.view;

import java.util.Calendar;
import java.util.Scanner;

import com.kh.practice.book.controller.BookController;
import com.kh.practice.book.model.vo.Book;

public class BookMenu {
	
	Scanner sc=new Scanner(System.in);
	
	private BookController bc=new BookController();
	
	private Book[] bArr;
	
	public BookMenu() {
		// TODO Auto-generated constructor stub
		bc.makeFile();
		bArr=bc.fileRead();
	}

	public void mainMenu() {
		while(true) {
			 
		System.out.print("1.���� �߰� ����\n2.���� ���� ���\n9.���α׷� ������\n�޴���ȣ :");
		int cho=sc.nextInt();
		
		
		  switch (cho) {
		  case 1 : fileSave(); 
		  		break;
		  case 2 : fileRead();
		  		break;
		  case 9 : System.out.println("���α׷� ����"); 
		  		return;
		  default : System.out.println("�߸� �Է��ϼ̽��ϴ�. �ٽ� �Է����ּ���.");
		  }
		}
	}
	
	
	
	public void fileSave() {
		sc.nextLine();
			System.out.print("������ :");
		String title=sc.nextLine();
		
			System.out.print("���ڸ� :");
		String author=sc.nextLine();
		
			System.out.print("�������� :");
		int price=sc.nextInt();

		
			System.out.print("���ǳ�¥(yyyy-mm-dd):");
		String date=sc.next();
		String[] str=date.split("-");
		Calendar c=Calendar.getInstance();
		c.set(Integer.parseInt(str[0]),Integer.parseInt(str[1])-1,Integer.parseInt(str[2]));
		
			System.out.print("������:");
		double discount=sc.nextDouble();
		
		

		Book b=new Book(title, author, price, c ,discount);
		for(int i=0;i<bArr.length;i++) {
			if(bArr[i]==null) {
//				Book b=new Book(title, author, price, c ,discount);
				bArr[i]=b;
				break;
			}
		}
		 
		bc.fileSave(bArr);
	
		
		
	}
	
	public void fileRead() {
		bArr=bc.fileRead();
		for(int i=0;i<bArr.length;i++) {
			if(bArr[i]!=null) {
		System.out.println(bArr[i]);}
	}
	
	}
}
