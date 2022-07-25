package com.Team_Management_System.DAO;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.Team_Management_System.DTO.CoachDTO;
import com.Team_Management_System.DTO.PlayerDTO;
import com.Team_Management_System.DTO.StaffDTO;



public class Player_Coach_DAO {

	private static EntityManagerFactory factory;
	private static EntityManager manager;
	private static EntityTransaction transaction;
	static Scanner sc = new Scanner(System.in);
	static int choice;
	static int remove;
	static int update;

	private static void openConnection() {
		factory = Persistence.createEntityManagerFactory("hibernate");
		manager = factory.createEntityManager();
		transaction = manager.getTransaction();
	}

	private static void closeConnection() {
		factory.close();
		manager.close();
		try {
			transaction.rollback();
		} catch (Exception e) {
			System.out.println("Transaction is Commited");
		}
	}

	public static void menu() {

		System.out.println("Choose Type : \n 1) Add New Player : " + "\n 2) Remove Player : "
				+ "\n 3) Show All Player : " + "\n 4) Update Player Information : " + "\n 5) Add New Coach :"
				+ "\n 6) Remove Coach : " + "\n 7) Show All Coach " + "\n 8) Update Coach Information :"
				+ "\n 9) Add New Staff Member :" + "\n 10) Remove Staff :" + "\n 11) Show All Staff Member"
				+ "\n 12) Update Staff Member" + "\n 13) Exit");
		choice = sc.nextInt();

		switch (choice) {
		case 1:
			addPlayer();
			System.out.println();
			System.out.println("Player Added Succesfully");
			break;

		case 2:
			removePlayer();
			System.out.println();
			System.out.println("Player Removed Succesfully");
			break;

		case 3:
			showPlayer();
			System.out.println();
			System.out.println("Player Showing Succesfully");
			break;

		case 4:
			updatePlayer();
			System.out.println();
			System.out.println("Player Updated Succesfully");
			break;
		case 5:
			addCoach();
			System.out.println();
			System.out.println("Coach Added Succesfully");
			break;

		case 6:
			removeCoach();
			System.out.println();
			System.out.println("Coach Removed Succesfully");
			break;

		case 7:
			showCoach();
			System.out.println();
			System.out.println("Coach Showing Succesfully");
			break;

		case 8:
			updateCoach();
			System.out.println();
			System.out.println("Coach Updated Succesfully");
			break;

		case 9:
			addStaff();
			System.out.println();
			System.out.println("Staff Added Succesfully");
			break;

		case 10:
			removeStaff();
			System.out.println();
			System.out.println("Staff Removed Succesfully");
			break;

		case 11:
			showStaff();
			System.out.println();
			System.out.println("Staff Showing Succesfully");
			break;

		case 12:
			updateStaff();
			System.out.println();
			System.out.println("Staff Updated Succesfully");
			break;

		case 13:
			System.out.println();
			System.out.println("Music Player Stopped Succesfully");
			break;

		default:
			System.out.println("Invalid Choice");
			break;
		}
	}

	
	public static void updatePlayer() {

		factory = Persistence.createEntityManagerFactory("hibernate");
		manager = factory.createEntityManager();
		transaction = manager.getTransaction();
		
		transaction.begin();

		System.out.println("Which Player Update (ID) : ");
		update = sc.nextInt();

		String name, grade, specilization;

		double age, player_package;

		System.out.println("Update Player Name :");
		name = sc.next();

		System.out.println("Update Player Grade :");
		grade = sc.next();

		System.out.println("Update Player Specialization :");
		specilization = sc.next();

		System.out.println("Update Player Age :");
		age = sc.nextDouble();

		System.out.println("Update Player Package :");
		player_package = sc.nextDouble();

		PlayerDTO find = manager.find(PlayerDTO.class, update);

		find.setAge(age);
		find.setPlayer_name(name);;
		find.setPlayer_package(player_package);
		find.setGrade(grade);
		find.setSpecilization(specilization);

		manager.persist(find);

		transaction.commit();

	}

	public static void showPlayer() {

		factory = Persistence.createEntityManagerFactory("hibernate");
		manager = factory.createEntityManager();
		transaction = manager.getTransaction();
		
		transaction.begin();

		Query query = manager.createQuery("from PlayerDTO");
		List<PlayerDTO> list = query.getResultList();
		for (int i = 0; i < list.size(); i++) {
			System.out.println();
			System.out.println("Player " + (i) + " Details " + list.get(i));
			System.out.println();
		}

		transaction.commit();

	}

	public static void removePlayer() {

		factory = Persistence.createEntityManagerFactory("hibernate");
		manager = factory.createEntityManager();
		transaction = manager.getTransaction();

		transaction.begin();

		System.out.println("Which Player Remove (ID) : ");
		remove = sc.nextInt();
		PlayerDTO find = manager.find(PlayerDTO.class, remove);
		manager.remove(find);

		transaction.commit();

	}

	public static void addPlayer() {
		
		factory = Persistence.createEntityManagerFactory("hibernate");
		manager = factory.createEntityManager();
		transaction = manager.getTransaction();
		
		transaction.begin();
		
		String name, grade, specialization;

		double age, player_package;

		System.out.println("Add Player Name :");
		name = sc.next();
		
		System.out.println("Add Player Grade :");
		grade = sc.next();

		System.out.println("Add Player Specialization :");
		specialization = sc.next();

		System.out.println("Add Player Age :");
		age = sc.nextDouble();

		System.out.println("Add Player Package :");
		player_package = sc.nextDouble();

		PlayerDTO player = new PlayerDTO();
		player.setAge(age);
		player.setPlayer_name(name);
		player.setPlayer_package(player_package);
		player.setSpecilization(specialization);
		player.setGrade(grade);

		manager.persist(player);

		transaction.commit();
	}
	
	

	public static void updateCoach() {

		factory = Persistence.createEntityManagerFactory("hibernate");
		manager = factory.createEntityManager();
		transaction = manager.getTransaction();
		
		transaction.begin();

		System.out.println("Which Coach Update (ID) : ");
		update = sc.nextInt();

		String name, grade, specilization;

		double age, coach_package;

		System.out.println("Update Coach Name :");
		name = sc.next();

		System.out.println("Update Coach Grade :");
		grade = sc.next();

		System.out.println("Update Coach Specialization :");
		specilization = sc.next();

		System.out.println("Update Coach Age :");
		age = sc.nextDouble();

		System.out.println("Update Coach Package :");
		coach_package = sc.nextDouble();

		CoachDTO find = manager.find(CoachDTO.class, update);

		find.setAge(age);
		find.setCoach_name(name);
		find.setCoach_package(coach_package);
		find.setGrade(grade);
		find.setSpecilization(specilization);

		manager.persist(find);

		transaction.commit();

	}

	public static void showCoach() {

		factory = Persistence.createEntityManagerFactory("hibernate");
		manager = factory.createEntityManager();
		transaction = manager.getTransaction();
		
		transaction.begin();

		Query query = manager.createQuery("from CoachDTO");
		List<CoachDTO> list = query.getResultList();
		for (int i = 0; i < list.size(); i++) {
			System.out.println();
			System.out.println("Coach " + (i) + " Details " + list.get(i));
			System.out.println();
		}

		transaction.commit();

	}

	public static void removeCoach() {

		factory = Persistence.createEntityManagerFactory("hibernate");
		manager = factory.createEntityManager();
		transaction = manager.getTransaction();
		
		transaction.begin();

		System.out.println("Which Coach Remove (ID) : ");
		remove = sc.nextInt();
		CoachDTO find = manager.find(CoachDTO.class, remove);
		manager.remove(find);

		transaction.commit();

	}

	public static void addCoach() {

		factory = Persistence.createEntityManagerFactory("hibernate");
		manager = factory.createEntityManager();
		transaction = manager.getTransaction();
		
		transaction.begin();
		
		String name, grade, specialization;

		double age, coach_package;

		System.out.println("Add Coach First Name :");
		name = sc.next();

		System.out.println("Add Coach Grade :");
		grade = sc.next();

		System.out.println("Add Coach Specialization :");
		specialization = sc.next();

		System.out.println("Add Coach Age :");
		age = sc.nextDouble();

		System.out.println("Add Coach Package :");
		coach_package = sc.nextDouble();

		CoachDTO coach = new CoachDTO();
		coach.setAge(age);
		coach.setCoach_name(name);
		coach.setCoach_package(coach_package);
		coach.setSpecilization(specialization);
		coach.setGrade(grade);

		manager.persist(coach);

		transaction.commit();

	}

	
	public static void updateStaff() {

		factory = Persistence.createEntityManagerFactory("hibernate");
		manager = factory.createEntityManager();
		transaction = manager.getTransaction();
		
		transaction.begin();

		System.out.println("Which Satff Update (ID) : ");
		remove = sc.nextInt();
		StaffDTO find = manager.find(StaffDTO.class, remove);

		String name, grade;

		double age, staff_package;

		System.out.println("Update Staff Name :");
		name = sc.next();

		System.out.println("Update Staff Grade :");
		grade = sc.next();

		System.out.println("Update Staff Age :");
		age = sc.nextDouble();

		System.out.println("Update Staff Package :");
		staff_package = sc.nextDouble();

		find.setAge(age);
		find.setStaff_name(name);
		find.setStaff_package(staff_package);
		find.setGrade(grade);

		manager.persist(find);

		transaction.commit();

	}

	public static void showStaff() {

		factory = Persistence.createEntityManagerFactory("hibernate");
		manager = factory.createEntityManager();
		transaction = manager.getTransaction();
		
		transaction.begin();

		Query query = manager.createQuery("from StaffDTO");
		List<StaffDTO> list = query.getResultList();
		for (int i = 0; i < list.size(); i++) {
			System.out.println();
			System.out.println("Staff " + (i) + " Details " + list.get(i));
			System.out.println();
		}

		transaction.commit();

	}

	public static void removeStaff() {

		factory = Persistence.createEntityManagerFactory("hibernate");
		manager = factory.createEntityManager();
		transaction = manager.getTransaction();
		
		transaction.begin();

		System.out.println("Which Staff Remove (ID) : ");
		remove = sc.nextInt();
		StaffDTO find = manager.find(StaffDTO.class, remove);
		manager.remove(find);

		transaction.commit();

	}

	public static void addStaff() {

		factory = Persistence.createEntityManagerFactory("hibernate");
		manager = factory.createEntityManager();
		transaction = manager.getTransaction();
		
		transaction.begin();
		
		String name, grade, specialization;

		double age, staff_package;

		System.out.println("Add Coach Name :");
		name = sc.next();

		System.out.println("Add Coach Grade :");
		grade = sc.next();

		System.out.println("Add Coach Age :");
		age = sc.nextDouble();

		System.out.println("Add Coach Package :");
		staff_package = sc.nextDouble();

		StaffDTO staff = new StaffDTO();
		staff.setStaff_name(name);;
		staff.setAge(age);;
		staff.setStaff_package(staff_package);
		staff.setGrade(grade);

		manager.persist(staff);

		transaction.commit();

	}
	

	

	public static void main(String[] args) {

		openConnection();
		transaction.begin();

//		PlayerDTO p1 = new PlayerDTO();
//		p1.setAge(21);
//		p1.setPlayer_name("Hardik");
//		p1.setGrade("A1");
//		p1.setPlayer_package(2500000.00);
//		p1.setSpecilization("All Rounder");
//		
//		manager.persist(p1);
//		
//		CoachDTO c1 = new CoachDTO();
//		c1.setAge(45);
//		c1.setCoach_name
//		c1.setGrade("A1");
//		c1.setCoach_package(3500000.00);
//		c1.setSpecilization("Batting");
//		
//		manager.persist(c1);
//		
//		StaffDTO s1 = new StaffDTO();
//		s1.setAge(33);
//		s1.setStaff_name("ABC");
//		s1.setGrade("B1");
//		s1.setStaff_package(250000.00);
//		
//		
//		manager.persist(s1);
		
		transaction.commit();

		menu();

		closeConnection();
	}
}
