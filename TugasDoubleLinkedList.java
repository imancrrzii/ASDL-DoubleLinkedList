package ASDL;

import java.util.Scanner;
import java.util.LinkedList;

public class TugasDoubleLinkedList {
	private Node head;
	private Node tail;
	private int size = 0;

	static class Node {
		int data;
		Node next;
		Node prev;

		Node(int data) {
			this.data = data;
			prev = null;
			next = null;
		}

		public void printListData() {
			System.out.print(data + " ");
		}
	}

	public TugasDoubleLinkedList() {
		this.head = null;
		this.tail = null;
	}

	public boolean isEmpty() {
		return head == null;
	}

	public int getsize() {
		return size;
	}

	public void insertFirst(int data) {
		Node newNode = new Node(data);

		if (isEmpty()) {
			tail = newNode;
		} else {
			head.prev = newNode;
		}
		newNode.next = head;
		head = newNode;
		size++;
	}

	public void insertLast(int data) {
		Node newNode = new Node(data);

		if (isEmpty()) {
			head = newNode;
		} else {
			tail.next = newNode;
			newNode.prev = tail;
		}
		tail = newNode;
		size++;
	}

	public void insertAtIndex(int data, int index) {
		if (!isValidIndex(index)) {
			throw new IndexOutOfBoundsException("INDEX " + index + " NOT VALID FOR LINKED LIST OF SIZE " + size);
		}
		Node newNode = new Node(data);
		Node current = head;

		if (index == 0) {
			insertFirst(data);
		}

		else if (index == size) {
			insertLast(data);
		} else {
			for (int j = 0; j < index && current.next != null; j++) {
				current = current.next;
			}
			newNode.next = current;
			current.prev.next = newNode;
			newNode.prev = current.prev;
			current.prev = newNode;
			size++;
		}
	}

	public Node removeFirst() {
		if (head == null) {
			throw new RuntimeException("LIST IS EMPTY");
		}
		Node first = head;
		if (head.next == null) {
			tail = null;
		} else {
			head.next.prev = null;
		}
		head = head.next;
		size--;
		return first;
	}

	public Node removeLast() {
		if (tail == null) {
			throw new RuntimeException("LIST IS EMPTY");
		}
		Node last = tail;
		if (head.next == null) {
			head = null;
		} else {
			tail.prev.next = null;
		}
		tail = tail.prev;
		size--;
		return last;
	}

	public Node removeAtIndex(int index) {
		if (!isValidIndex(index + 1)) {
			throw new IndexOutOfBoundsException("INDEX " + index + " NOT VALID FOR LINKED LIST OF SIZE " + size);
		}
		Node current = head;

		if (index == 0) {
			return removeFirst();
		}

		else if (index == size - 1) {
			return removeLast();
		} else {
			for (int j = 0; j < index && current.next != null; j++) {
				current = current.next;
			}
			current.prev.next = current.next;
			current.next.prev = current.prev;
			size--;
		}

		return current;
	}

	private boolean isValidIndex(int index) {
		return index >= 0 && index <= size;
	}

	public boolean find(int data) {
		boolean flag = false;
		Node current = head;
		while (current != null) {
			if (current.data == data) {
				flag = true;
				break;
			}
			current = current.next;
		}
		return flag;
	}

	public boolean replace(int data, int index) {
		Node current = head;
		Node prev = null;

		while (current != null && index >= 0) {
			index--;
			prev = current;
			current = current.next;
		}
		if (index > 0)
			return false;

		if (prev != null)
			prev.data = data;
		System.out.println("DATA TELAH BERHASIL DIUBAH");
		return true;

	}

	public void printList(boolean asc) {
		Node current = null;
		if (asc)
			current = head;
		else
			current = tail;

		System.out.print("= [ ");
		while (current != null) {
			current.printListData();
			if (asc)
				current = current.next;
			else
				current = current.prev;
		}
		System.out.print("]\n\n");
	}

	public static void main(String[] args) {
		Scanner inputUser = new Scanner(System.in);

		TugasDoubleLinkedList list = new TugasDoubleLinkedList();
		int pilih;
		int pilih2;
		int index = 0;
		int x = 00000;
		char input;
		boolean lanjut;
		int userData;
		boolean asc = true;

		do {
			System.out.println("DOUBLE LINKED LIST");
			System.out.println("1. MANUAL");
			System.out.println("2. PUSTAKA");
			System.out.println("3. KELUAR");
			System.out.print("SILAHKAN PILIH [1/2/3]: ");
			pilih = inputUser.nextInt();
			System.out.println("\n[-------------------------]");
			System.out.println();

			switch (pilih) {
			case 1:
				do {
					System.out.println("OPERASI MANUAL DOUBLE LINKED LIST");
					System.out.println("1. TAMBAH DATA");
					System.out.println("2. HAPUS DATA ");
					System.out.println("3. PENCARIAN/PENGUBAHAN DATA");
					System.out.println("4. KEMBALI KE MENU SEBELUMNYA");
					System.out.print("SILAHKAN PILIH [1/2/3/4]: ");
					pilih = inputUser.nextInt();
					System.out.println("\n[-------------------------]");
					System.out.println();

					switch (pilih) {
					case 1:
						do {
							System.out.println("OPERASI MANUAL TAMBAH DATA DOUBLE LINKED LIST");
							System.out.println("1. TAMBAH DATA AWAL");
							System.out.println("2. TAMBAH DATA TENGAH");
							System.out.println("3. TAMBAH DATA AKHIR");
							System.out.println("4. CETAK DATA");
							System.out.println("5. KEMBALI KE MENU SEBELUMNYA");
							System.out.print("SILAHKAN PILIH [1/2/3/4/5]: ");
							pilih = inputUser.nextInt();
							System.out.println();

							switch (pilih) {

							case 1:
								lanjut = true;
								System.out.println("INFO: - MASUKKAN DATA ANGKA (INTEGER)\n"
										+ "      - TEKAN 00000 UNTUK KEMBALI KE MENU SEBELUMNYA\n");
								while (lanjut) {
									for (int i = 0; i < i + 1; i++) {
										System.out.print("DATA KE-" + (i + 1) + ": ");
										userData = inputUser.nextInt();
										if (userData == x) {
											lanjut = false;
											break;
										}
										list.insertFirst(userData);
									}
									System.out.println();
								}
								break;

							case 2:
								lanjut = true;
								System.out.println("INFO: - MASUKKAN DATA ANGKA (INTEGER)\n"
										+ "      - TEKAN 00000 UNTUK KEMBALI KE MENU SEBELUMNYA\n");

								while (lanjut) {
									for (int i = 0; i < i + 1; i++) {
										System.out.print("APAKAH ANDA INGIN MELANJUTKAN?[Y/T]: ");
										input = inputUser.next().charAt(0);
										if (input == 't' || input == 'T') {
											lanjut = false;
											break;
										}
										System.out.print("MASUKKAN NODE: ");
										index = inputUser.nextInt();
										if (index < 1 || index > list.getsize())
											System.out.println("NODE KE-" + index + " TIDAK DITEMUKAN");
										System.out.print("MASUKKAN DATA: ");
										userData = inputUser.nextInt();
										list.insertAtIndex(userData, index);
									}
									System.out.println();
								}
								break;
							case 3:
								lanjut = true;
								System.out.println("INFO: - MASUKKAN DATA ANGKA (INTEGER)\n"
										+ "      - TEKAN 00000 UNTUK KEMBALI KE MENU SEBELUMNYA\n");
								while (lanjut) {
									for (int i = 0; i < i + 1; i++) {
										System.out.print("DATA KE-" + (i + 1) + ": ");
										userData = inputUser.nextInt();
										if (userData == x) {
											lanjut = false;
											break;
										}
										list.insertLast(userData);
									}
									System.out.println();
								}
								break;

							case 4:
								list.printList(asc);
								break;
							}

						} while (pilih != 5);
						break;

					case 2:
						do {
							System.out.println("OPERASI MANUAL HAPUS DATA DOUBLE LINKED LIST");
							System.out.println("1. HAPUS DATA AWAL");
							System.out.println("2. HAPUS DATA TENGAH");
							System.out.println("3. HAPUS DATA AKHIR");
							System.out.println("4. CETAK DATA");
							System.out.println("5. KEMBALI KE MENU SEBELUMNYA");
							System.out.print("SILAHKAN PILIH [1/2/3/4/5]: ");
							pilih = inputUser.nextInt();
							System.out.println();

							switch (pilih) {
							case 1:
								lanjut = true;
								while (lanjut) {
									for (int i = 0; i < i + 1; i++) {
										System.out.print("YAKIN INGIN MENGHAPUS DATA DI AWAL?[Y/T]: ");
										input = inputUser.next().charAt(0);
										if (input == 't' || input == 'T') {
											lanjut = false;
											break;
										}
										list.removeFirst();
									}
									System.out.println("\nDATA YANG DITENTUKAN TELAH TERHAPUS");
								}
								break;

							case 2:
								Node node = null;
								lanjut = true;
								while (lanjut) {
									for (int i = 0; i < i + 1; i++) {
										System.out.print("YAKIN INGIN MENGHAPUS DATA DI TENGAH?[Y/T]: ");
										input = inputUser.next().charAt(0);

										if (input == 't' || input == 'T') {
											lanjut = false;
											break;
										}
										System.out.print("MASUKKAN NODE: ");
										index = inputUser.nextInt();
										if (index < 1 || index > list.getsize())
											System.out.println("NODE KE-" + index + " TIDAK DITEMUKAN");
										node = list.removeAtIndex(index);
									}
									System.out.println("\nDATA YANG DITENTUKAN TELAH TERHAPUS");
								}
								break;

							case 3:
								lanjut = true;
								while (lanjut) {
									for (int i = 0; i < i + 1; i++) {
										System.out.print("YAKIN INGIN MENGHAPUS DATA DI AKHIR?[Y/T]: ");
										input = inputUser.next().charAt(0);
										if (input == 't' || input == 'T') {
											lanjut = false;
											break;
										}
										list.removeLast();
									}
									System.out.println("\nDATA YANG DITENTUKAN TELAH TERHAPUS");
								}
								break;

							case 4:
								list.printList(asc);
								break;
							}
						} while (pilih != 5);
						break;

					case 3:
						do {
							System.out.println("OPERASI MANUAL PENCARIAN/PENGUBAHAN DATA DOUBLE LINKED LIST");
							System.out.println("1. CARI DATA");
							System.out.println("2. UBAH DATA");
							System.out.println("3. CETAK DATA");
							System.out.println("4. KEMBALI KE MENU SEBELUMNYA");
							System.out.print("SILAHKAN PILIH [1/2/3/4]: ");
							pilih2 = inputUser.nextInt();
							System.out.println();

							switch (pilih2) {
							case 1:
								lanjut = true;
								while (lanjut) {
									for (int i = 0; i < i + 1; i++) {
										System.out.print("OPERASI PENCARIAN DATA\n" + "LANJUT[Y/T]: ");
										input = inputUser.next().charAt(0);
										if (input == 't' || input == 'T') {
											lanjut = false;
											break;
										}
										System.out.print("MASUKKAN DATA: ");
										userData = inputUser.nextInt();

										if (list.find(userData))
											System.out.println("[DATA DITEMUKAN]");
										else
											System.out.println("[DATA TIDAK DITEMUKAN]");
									}
									System.out.println();
								}
								break;
							case 2:
								lanjut = true;
								while (lanjut) {
									for (int i = 0; i < i + 1; i++) {
										System.out.print("OPERASI PENGUBAHAN DATA\n" + "LANJUT[Y/T]: ");
										input = inputUser.next().charAt(0);
										if (input == 't' || input == 'T') {
											lanjut = false;
											break;
										}
										System.out.print("MASUKKAN NODE: ");
										index = inputUser.nextInt();
										if (index < 1 || index > list.getsize())
											System.out.println("NODE KE-" + index + " TIDAK DITEMUKAN");
										System.out.print("MASUKKAN DATA: ");
										userData = inputUser.nextInt();
										list.replace(userData, index);
									}
									System.out.println();
								}
								break;
							case 3:
								list.printList(asc);
								break;
							}
						} while (pilih2 != 4);
						break;
					}

				} while (pilih != 4);
				break;
			case 2:
				LinkedList<Integer> llist = new LinkedList<>();
				do {
					System.out.println("OPERASI PUSTAKA DOUBLE LINKED LIST");
					System.out.println("1. TAMBAH DATA");
					System.out.println("2. HAPUS DATA ");
					System.out.println("3. PENCARIAN/PENGUBAHAN DATA");
					System.out.println("4. KEMBALI KE MENU SEBELUMNYA");
					System.out.print("SILAHKAN PILIH [1/2/3/4]: ");
					pilih = inputUser.nextInt();
					System.out.println("\n[-------------------------]");
					System.out.println();

					switch (pilih) {
					case 1:
						do {
							System.out.println("OPERASI PUSTAKA TAMBAH DATA DOUBLE LINKED LIST");
							System.out.println("1. TAMBAH DATA AWAL");
							System.out.println("2. TAMBAH DATA TENGAH");
							System.out.println("3. TAMBAH DATA AKHIR");
							System.out.println("4. CETAK DATA");
							System.out.println("5. KEMBALI KE MENU SEBELUMNYA");
							System.out.print("SILAHKAN PILIH [1/2/3/4/5]: ");
							pilih = inputUser.nextInt();
							System.out.println("\n[-------------------------]");
							System.out.println();

							switch (pilih) {

							case 1:
								lanjut = true;
								System.out.println("INFO: - MASUKKAN DATA ANGKA (INTEGER)\n"
										+ "      - TEKAN 00000 UNTUK KEMBALI KE MENU SEBELUMNYA\n");
								while (lanjut) {
									for (int i = 0; i < i + 1; i++) {
										System.out.print("DATA KE-" + (i + 1) + ": ");
										userData = inputUser.nextInt();
										if (userData == x) {
											lanjut = false;
											break;
										}
										llist.addFirst(userData);
									}
									System.out.println();
								}
								break;

							case 2:
								lanjut = true;
								System.out.println("INFO: - MASUKKAN DATA ANGKA (INTEGER)\n"
										+ "      - TEKAN 00000 UNTUK KEMBALI KE MENU SEBELUMNYA\n");
								while (lanjut) {
									for (int i = 0; i < i + 1; i++) {
										System.out.print("APAKAH ANDA INGIN MELANJUTKAN?[Y/T]: ");
										input = inputUser.next().charAt(0);
										if (input == 't' || input == 'T') {
											lanjut = false;
											break;
										}
										System.out.print("MASUKKAN NODE: ");
										index = inputUser.nextInt();
										if (index < 1 || index > list.getsize())
											System.out.println("NODE KE-" + index + " TIDAK DITEMUKAN");
										System.out.print("MASUKKAN DATA: ");
										userData = inputUser.nextInt();

										llist.add(index, userData);
									}
									System.out.println();
								}
								break;

							case 3:
								lanjut = true;
								System.out.println("INFO: - MASUKKAN DATA ANGKA (INTEGER)\n"
										+ "      - TEKAN 00000 UNTUK KEMBALI KE MENU SEBELUMNYA\n");
								while (lanjut) {
									for (int i = 0; i < i + 1; i++) {
										System.out.print("DATA KE-" + (i + 1) + ": ");
										userData = inputUser.nextInt();
										if (userData == x) {
											lanjut = false;
											break;
										}
										llist.addLast(userData);
									}
									System.out.println();
								}
								break;

							case 4:
								System.out.println("    " + llist + "\n");
								break;
							}

						} while (pilih != 5);
						break;

					case 2:
						do {
							System.out.println("OPERASI PUSTAKA HAPUS DATA DOUBLE LINKED LIST");
							System.out.println("1. HAPUS DATA AWAL");
							System.out.println("2. HAPUS DATA TENGAH");
							System.out.println("3. HAPUS DATA AKHIR");
							System.out.println("4. CETAK DATA");
							System.out.println("5. KEMBALI KE MENU SEBELUMNYA");
							System.out.print("SILAHKAN PILIH [1/2/3/4/5]: ");
							pilih = inputUser.nextInt();
							System.out.println();

							switch (pilih) {
							case 1:
								lanjut = true;
								while (lanjut) {
									for (int i = 0; i < i + 1; i++) {
										System.out.print("YAKIN INGIN MENGHAPUS DATA DI AWAL?[Y/T]: ");
										input = inputUser.next().charAt(0);
										if (input == 't' || input == 'T') {
											lanjut = false;
											break;
										}
										llist.removeFirst();
									}
									System.out.println("\nDATA YANG DITENTUKAN TELAH TERHAPUS");
								}
								break;

							case 2:
								lanjut = true;
								while (lanjut) {
									for (int i = 0; i < i + 1; i++) {
										System.out.print("YAKIN INGIN MENGHAPUS DATA DI TENGAH?[Y/T]: ");
										input = inputUser.next().charAt(0);

										if (input == 't' || input == 'T') {
											lanjut = false;
											break;
										}
										System.out.print("MASUKKAN NODE");
										index = inputUser.nextInt();
										if (index < 1 || index > list.getsize())
											System.out.println("NODE KE-" + index + " TIDAK DITEMUKAN");
										llist.remove(index);
									}
									System.out.println("\nDATA YANG DITENTUKAN TELAH TERHAPUS");
								}
								break;

							case 3:
								lanjut = true;
								while (lanjut) {
									for (int i = 0; i < i + 1; i++) {
										System.out.print("YAKIN INGIN MENGHAPUS DATA DI AKHIR?[Y/T]: ");
										input = inputUser.next().charAt(0);
										if (input == 't' || input == 'T') {
											lanjut = false;
											break;
										}
										llist.removeLast();
									}
									System.out.println("\nDATA YANG DITENTUKAN TELAH TERHAPUS");
								}
								break;

							case 4:
								System.out.println("    " + llist + "\n");
								break;
							}
						} while (pilih != 5);
						break;

					case 3:
						do {
							System.out.println("OPERASI PUSTAKA PENCARIAN/PENGUBAHAN DATA DOUBLE LINKED LIST");
							System.out.println("1. CARI DATA");
							System.out.println("2. UBAH DATA");
							System.out.println("3. CETAK DATA");
							System.out.println("4. KEMBALI KE MENU SEBELUMNYA");
							System.out.print("SILAHKAN PILIH [1/2/3/4]: ");
							pilih2 = inputUser.nextInt();
							System.out.println();

							switch (pilih2) {
							case 1:
								lanjut = true;
								while (lanjut) {
									boolean flag = false;
									for (int i = 0; i < i + 1; i++) {
										System.out.print("\nOPERASI PENCARIAN DATA\n" + "LANJUT[Y/T]: ");
										input = inputUser.next().charAt(0);
										if (input == 't' || input == 'T') {
											lanjut = false;
											break;
										}
										System.out.print("MASUKKAN DATA: ");
										userData = inputUser.nextInt();

										for (int j = 0; j < llist.size(); j++) {
											if (llist.get(j) == userData) {
												System.out.println("\nDATA " + userData + " DITEMUKAN");
												flag = true;
												break;
											}
										}
										if (!flag) {
											System.out.println("\nDATA TIDAK DITEMUKAN");
										}

									}
									System.out.println();
								}
								break;
							case 2:
								lanjut = true;
								while (lanjut) {
									boolean flag = false;
									for (int i = 0; i < i + 1; i++) {
										System.out.print("OPERASI PENGUBAHAN DATA\n" + "LANJUT[Y/T]: ");
										input = inputUser.next().charAt(0);
										if (input == 't' || input == 'T') {
											lanjut = false;
											break;
										}
										System.out.print("MASUKKAN NODE: ");
										index = inputUser.nextInt();
										System.out.print("MASUKKAN DATA: ");
										userData = inputUser.nextInt();
										for (int j = 0; j < llist.size(); j++) {
											if (j == index) {
												llist.set(j, userData);
												flag = true;
											}
										}
										if (!flag) {
											System.out.println("DATA TIDAK DITEMUKAN");
										}

									}
									System.out.println();
								}
								break;
							case 3:
								System.out.println("    " + llist + "\n");
								break;
							}
						} while (pilih2 != 4);
						break;
					}

				} while (pilih != 4);

				break;
			}
		} while (pilih != 3);
		System.out.println("END PROGRAM \nTHANK YOU");
	}
}