import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<>();
        List<Student> slit = studentList;
        int n;
        Scanner scanner = new Scanner(System.in);
        boolean flag = false;


        while (true) {
            System.out.println("-----------------------");
            System.out.println("1. add them sinh vien");
            System.out.println("2. xem danh sach sinh vien");
            System.out.println("3. sap xep sinh vien lai theo diem");
            System.out.println("4. thoat truong trinh");
            System.out.print("5. ban chon: ");
            n = scanner.nextInt();

            if (n == 5) {
                return;
            } else if (n == 1) {
                String name;
                int m, a;
                System.out.print("Nhap ten: ");
                name = scanner.next();
                System.out.print("Nhap tuoi: ");
                a = scanner.nextInt();
                System.out.print("Nhap diem: ");
                m = scanner.nextInt();
                addSinhVien(studentList, new Student(name, a, m));
            } else if (n == 2) {
                slit.forEach(e -> System.out.println("name: " + e.getName() + ", age: " + e.getAge() + ", mark: " + e.getMark()));
            } else if (n == 3) {
                if (flag) {
                    slit = studentList.stream().sorted(Comparator.comparing(Student::getMark)).collect(Collectors.toList());

                    flag = false;
                } else {
                    slit = studentList.stream().sorted(Comparator.comparing(Student::getMark).reversed()).collect(Collectors.toList());

                    flag = true;
                }
            } else {
                System.out.println("Nhap sai");
            }
        }
    }

    static void addSinhVien(List<Student> studentList, Student student) {
        studentList.add(student);
    }
}
