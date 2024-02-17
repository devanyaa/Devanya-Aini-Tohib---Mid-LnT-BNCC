package midlnt;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class Main {

	Scanner scan = new Scanner(System.in); 
	ArrayList<String> kodeKaryawanList = new ArrayList<>(); 
	ArrayList<String> nameKaryawanList = new ArrayList<>(); 
	ArrayList<String> jenisKelaminList = new ArrayList<>(); 
	ArrayList<String> jabatanList = new ArrayList<>(); 
	ArrayList<Integer> gajiKaryawanList = new ArrayList<>(); 
	
	void insertDataKaryawan() {
		String kodeKaryawan, nameKaryawan, jenisKelamin, jabatan;
		int gajiKaryawan; 
		
		do {
			System.out.print("Input nama karyawan [>=3] : ");
			nameKaryawan = scan.nextLine(); 
		} while (!(nameKaryawan.length()>=3));
		
		do {
			System.out.print("Input jenis kelamin [Laki-Laki | Perempuan] : ");
			jenisKelamin = scan.nextLine();
		} while (!(jenisKelamin.equals("Laki-Laki") || jenisKelamin.equals("Perempuan")));
		
		do {
			System.out.print("Input jabatan [Manager | Supervisor | Admin] : ");
			jabatan = scan.nextLine();
		} while (!(jabatan.equals("Manager") || jabatan.equals("Supervisor") || jabatan.equals("Admin")));
		
		if (jabatan.equals("Manager")) {
			gajiKaryawan = 8000000; 
		}
		else if (jabatan.equals("Supervisor")) {
			gajiKaryawan = 6000000; 
		}
		else {
			gajiKaryawan = 4000000;
		} 
		
		double bonusPercentage = 0.0; 
		
		int countSameJabatan = Collections.frequency(jabatanList, jabatan); 
		if (countSameJabatan >= 3) {		
			if (jabatan.equals("Manager")) {
				bonusPercentage = 0.10;
			} else if (jabatan.equals("Supervisor")) {
				bonusPercentage = 0.075; 
			} else {
				bonusPercentage = 0.05;
			}	
			gajiKaryawan += (int) (gajiKaryawan * bonusPercentage);	
		}
		
		
		Random rand = new Random();
		kodeKaryawan =  " " + (char)(rand.nextInt(26) + 'A')
				         + (char)(rand.nextInt(26) + 'A') 
				         + rand.nextInt(10) + rand.nextInt(10) + rand.nextInt(10) + rand.nextInt(10);
		
		
		
		kodeKaryawanList.add(kodeKaryawan);
		nameKaryawanList.add(nameKaryawan);
		jenisKelaminList.add(jenisKelamin); 
		jabatanList.add(jabatan);
		gajiKaryawanList.add(gajiKaryawan); 
	
	}
	
	void ascen () {
		for (int i = 0; i < nameKaryawanList.size(); i++) {
			for (int j = 0; j < nameKaryawanList.size()-1; j++) {
				if (nameKaryawanList.get(i).compareToIgnoreCase(nameKaryawanList.get(j)) < 0) {
					String kodeKaryawan = kodeKaryawanList.get(i);
					kodeKaryawanList.set(i, kodeKaryawanList.get(j));
					kodeKaryawanList.set(j, kodeKaryawan);
					
					String nameKaryawan = nameKaryawanList.get(i); 
					nameKaryawanList.set(i, nameKaryawanList.get(j)); 
					nameKaryawanList.set(j, nameKaryawan); 
					
					String jenisKelamin = jenisKelaminList.get(i); 
					jenisKelaminList.set(i, jenisKelaminList.get(j)); 
					jenisKelaminList.set(j, jenisKelamin); 
					
					String jabatan = jabatanList.get(i); 
					jabatanList.set(i, jabatanList.get(j));
					jabatanList.set(j, jabatan); 
					
					int gajiKaryawan = gajiKaryawanList.get(i); 
					gajiKaryawanList.set(i, gajiKaryawanList.get(j)); 
					gajiKaryawanList.set(j, gajiKaryawan); 
				}
				
			}
			
		}
	}
	void viewDataKaryawan () {
		if (nameKaryawanList.isEmpty()) {
			System.out.println("No data");
		}
		else {
			ascen();
			System.out.println("|----|--------------|--------------|---------------|---------|---------------|");
			System.out.println("|No  |Kode Karyawan |Nama Karyawan |Jenis Kelamin  |Jabatan  |Gaji Karyawan  |");
			System.out.println("|----|--------------|--------------|---------------|---------|---------------|");
			for (int i = 0; i < nameKaryawanList.size(); i++) {
				System.out.println("|" +       (i+1)+     "|" + kodeKaryawanList.get(i) +    "|" + nameKaryawanList.get(i) + "|" + jenisKelaminList.get(i) + "|" + jabatanList.get(i) + "|" + gajiKaryawanList.get(i) + "|"); 
			}
			System.out.println("|---|---------------|--------------|---------------|---------|---------------|");
		}
		System.out.println("Berhasil menambahkan karyawan dengan id " + kodeKaryawanList);
		System.out.println("Enter to return");
		scan.nextLine(); 
	}
	
	void updateDataKaryawan() {
		viewDataKaryawan();
		int nomor, gajiKaryawan;
		do {
            System.out.printf("Input nomor urutan karyawan yang ingin diupdate [1 - %d] : ", (nameKaryawanList.size()));
            nomor = scan.nextInt(); scan.nextLine();
        } while (nomor < 1 || nomor > nameKaryawanList.size());
		
		int toUpdate = nomor - 1;
		String newnamaKaryawan, newjenisKelamin, newjabatan;
		do {
			System.out.println("Input nama karyawan baru : ");
			newnamaKaryawan = scan.nextLine(); 
		} while (newnamaKaryawan.length()<= 3);
		do {
			System.out.print("Input jenis kelamin [Laki-Laki | Perempuan] : ");
			newjenisKelamin = scan.nextLine();
		} while (!(newjenisKelamin.equals("Laki-Laki") || newjenisKelamin.equals("Perempuan")));
		
		do {
			System.out.print("Input jabatan [Manager | Supervisor | Admin] : ");
			newjabatan = scan.nextLine();
		} while (!(newjabatan.equals("Manager") || newjabatan.equals("Supervisor") || newjabatan.equals("Admin")));
		
		int newgajiKaryawan = gajiKaryawanList.get(toUpdate);
		if (newjabatan.equals("Manager")) {
			newgajiKaryawan = 8000000; 
		}
		else if (newjabatan.equals("Supervisor")) {
			newgajiKaryawan = 6000000; 
		}
		else {
			newgajiKaryawan = 4000000;
		} 
		
		double bonusPercentage = 0.0; 
		
		 
			if (newjabatan.equals("Manager")) {
				bonusPercentage = 0.10;
			} else if (newjabatan.equals("Supervisor")) {
				bonusPercentage = 0.075; 
			} else {
				bonusPercentage = 0.05;
			}	
//			newgajiKaryawan += (int) (newgajiKaryawan * bonusPercentage);	
		
			nameKaryawanList.set(toUpdate, newnamaKaryawan);
			jenisKelaminList.set(toUpdate, newjenisKelamin);
			jabatanList.set(toUpdate, newjabatan);
			gajiKaryawanList.set(toUpdate, newgajiKaryawan);
	}
	
	void deleteDataKaryawan() {
		viewDataKaryawan();
		int nomor;
        do {
            System.out.printf("Input nomor urutan karyawan yang ingin dihapus [1 - %d] : ", (nameKaryawanList.size()));
            nomor = scan.nextInt(); scan.nextLine();
        } while (nomor < 1 || nomor > nameKaryawanList.size());

        int hapus = nomor - 1;
        String newKode = kodeKaryawanList.get(hapus);
        System.out.println("Karyawan dengan kode " + newKode + " berhasil di hapus");
        
        nameKaryawanList.remove(hapus);
        jabatanList.remove(hapus);
        jenisKelaminList.remove(hapus); 
	}
	
	void menu() {
		int choice; 
		do {
			System.out.println("PT ChipiChapa");
			System.out.println("1. Insert data karyawan");
			System.out.println("2. View data karyawan");
			System.out.println("3. Update data karyawan");
			System.out.println("4. Delete data karyawan");
			System.out.println("5. Exit");
			System.out.println(">> ");
			
			choice = scan.nextInt(); scan.nextLine(); 
			if (choice == 1) {
					insertDataKaryawan(); 
			}
			else if (choice == 2) {
				viewDataKaryawan(); 
			}
			else if (choice == 3) {
				updateDataKaryawan(); 
			}
			else if (choice == 4 ) {
				deleteDataKaryawan(); 
			}
			else if (choice == 5) {
				System.out.println("Thank you!");
			}
		} while (choice != 5);
	}
	public Main() {
		// TODO Auto-generated constructor stub
		menu(); 
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main(); 
	}

}
