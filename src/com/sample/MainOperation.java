package com.sample;

import java.util.Scanner;

public class MainOperation {
	
		static void Display()
		{
			System.out.println("-----------NEW-----------");
			System.out.println("CRUD-Operations-JDBC");
			System.out.println("----------------------------");
			System.out.println("1) Insert DATA");
			System.out.println("2) View DATA");
			System.out.println("3) Update DATA");
			System.out.println("4) Delete DATA");
			System.out.println("----------------------------");
		}
		
		static Scanner sc = new Scanner(System.in);
		
		public static void main(String[] args) {	
			
				for(;;)
				{
					AddUser a = new AddUser();
					DisplayUser d1 = new DisplayUser();
					DeleteUser d2 = new DeleteUser();
					UpdateUser u = new UpdateUser();
				
					Display();
					int operationNum = sc.nextInt();
					switch (operationNum) 
					{
						case 1 :
							System.out.println("Add(int roll , String name , String collegeName , String education , int fees)");
							a.Add(sc.nextInt(), sc.next(), sc.next(), sc.next(), sc.nextInt());
							break;
						case 2 :
							System.out.println("Dipslay()");
							d1.Dipslay();
							break;
						case 3 :
							System.out.println("Delete(int roll)");
							d2.Delete(sc.nextInt());
							break;
						case 4 :
							System.out.println("Update(String name , String collegeName , String education , int fees , int roll)");
							u.Update(sc.next(), sc.next(), sc.next(), sc.nextInt(), sc.nextInt());
							break;
						default :
							System.out.println("Wrong Input");		
							break;
					}
					System.out.println("-----------------------------");
				}
				
		}

}
