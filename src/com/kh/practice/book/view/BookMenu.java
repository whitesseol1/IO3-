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
			 
		System.out.print("1.도서 추가 저장\n2.저장 도서 출력\n9.프로그램 끝내기\n메뉴번호 :");
		int cho=sc.nextInt();
		
		
		  switch (cho) {
		  case 1 : fileSave(); 
		  		break;
		  case 2 : fileRead();
		  		break;
		  case 9 : System.out.println("프로그램 종료"); 
		  		return;
		  default : System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
		  }
		}
	}
	
	
	
	public void fileSave() {
		sc.nextLine();
			System.out.print("도서명 :");
		String title=sc.nextLine();
		
			System.out.print("저자명 :");
		String author=sc.nextLine();
		
			System.out.print("도서가격 :");
		int price=sc.nextInt();

		
			System.out.print("출판날짜(yyyy-mm-dd):");
		String date=sc.next();
		String[] str=date.split("-");
		Calendar c=Calendar.getInstance();
		c.set(Integer.parseInt(str[0]),Integer.parseInt(str[1])-1,Integer.parseInt(str[2]));
		
			System.out.print("할인율:");
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
