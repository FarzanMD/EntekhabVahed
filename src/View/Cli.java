package View;

import Controler.CollegeControler;
import Controler.CourseControler;
import Controler.StudentControler;
import Model.College;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cli {
    Scanner sc = new Scanner(System.in);
    CollegeControler collegeControler = new CollegeControler();
    StudentControler studentControler= new StudentControler();
    CourseControler courseControler = new CourseControler();
    public Cli() {

//        String a = firstPage();
//        signIn(a);
        start(true);
    }
    public boolean isValidUsername(String username){
        try(FileInputStream reader = new FileInputStream(new File("src/Model/StudentDataBase.txt"))){
            Scanner scanner = new Scanner(reader);
            while (scanner.hasNextLine()) {
                String[] a = scanner.nextLine().split(",");

                if (a[1].equals(username)){
                    return true;
                }
            }
        } catch (IOException e) {
        }catch (ArrayIndexOutOfBoundsException e){
        }
        return false;
    }
    public boolean isValidPassword(String password){
        try(FileInputStream reader = new FileInputStream(new File("src/Model/StudentDataBase.txt"))){
            Scanner sc = new Scanner(reader);
            while (sc.hasNextLine()) {
                String[] a = sc.nextLine().split(",");
                if (a[2].equals(password)){
                    return true;
                }
            }
        } catch (IOException e) {
        }catch (ArrayIndexOutOfBoundsException e){
        }
        return false;
    }
    public String firstPage() {
        System.out.println("hello , welcome to AP's first practice");
        System.out.println("please choose one of this optiones");
        System.out.println("1 - Sign in");
        System.out.println("2 - sign up");
        System.out.println("0 - Exit");
        String a = sc.next();
        return a;
    }
    public void signIn(String input){
        if(input.equals("1")){
            System.out.println("please enter your username");
            String b = sc.next();
            if (b.equals("admin")){
                System.out.println("hello admin , please enter the password");
                String c = sc.next();
                if (c.equals("admin")){
                    System.out.println("welcome admin");
                    System.out.println("1-Colleges");
                    start(true);

                }else {
                    System.out.println("invalid password , try again");
                    signIn(input);
                }
            }
            else if(isValidUsername(b)){
                System.out.println("hello " + b + ", please enter the password");
                String c = sc.next();
                if (isValidPassword(c)){
                    System.out.println("welcome "+b);
                    start(false);
                }else {
                    System.out.println("invalid password , try again");
                    signIn(input);
                }
            }else if (!isValidUsername(b) && !b.equals("admin")){
                System.out.println("invalid username try again");
                signIn(input);
            }
        } else if (input.equals("0")) {
            System.exit(0);
        }
    }
    public  void start(boolean isAdmin){
        if (isAdmin){
            while(sc.hasNextLine()){
                String command = sc.nextLine();
                proccesCommand(command);
            }
        }else while (sc.hasNextLine()){
            String command = sc.nextLine();
            proccesCommand(command);
        }
    }
    public void proccesCommand(String command){
        String[] a = command.split(" ") ;
        switch (a[0]){
            case "colleges":
                collegeControler.getColleges();
                break;
            case "getCourses":
                collegeControler.getCourses(a[1]);
                break;
            case "seeStudent":
                courseControler.getStudents(a[1]);
                break;
            case "addStudent":
                courseControler.addStudent(a[1]);
                break;
            case "removeStudent":
                courseControler.removeStudent(a[1]);
                break;
            case "addCourse":
                courseControler.addCourse(a[1]);
                break;
            case "editCapacity":
                courseControler.editCapacity(a[1]);
        }
    }

}
