package vn.viettuts.qlsv.func;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

import vn.viettuts.qlsv.entity.Student;
import vn.viettuts.qlsv.entity.StudentXML;
import vn.viettuts.qlsv.utils.FileUtils;

/**
 * StudentFunc class
 * 
 * @author viettuts.vn
 */
public class StudentFunc {
    private static final String STUDENT_FILE_NAME = "student.xml";
    private List<Student> listStudents;

    public StudentFunc() {
        this.listStudents = readListStudents();
    }

    /**
     * Lưu các đối tượng student vào file student.xml
     * 
     * @param students
     */
    public void writeListStudents(List<Student> students) {
        StudentXML studentXML = new StudentXML();
        studentXML.setStudent(students);
        FileUtils.writeXMLtoFile(STUDENT_FILE_NAME, studentXML);
    }

    /**
     * Đọc các đối tượng student từ file student.xml
     * 
     * @return list student
     */
    public String SpinNum()
    {
        int size = listStudents.size();
        Random rand = new Random();
        int ranNum = rand.nextInt(size-1);
        String name = listStudents.get(ranNum).getName();
        return name;
    }
    public List<Student> readListStudents() {
        List<Student> list = new ArrayList<Student>();
        StudentXML studentXML = (StudentXML) FileUtils.readXMLFile(
                STUDENT_FILE_NAME, StudentXML.class);
        if (studentXML != null) {
            list = studentXML.getStudent();
        }
        return list;
    }
    

    /**
     * thêm student vào listStudents và lưu listStudents vào file
     * 
     * @param student
     */
    public void add(Student student) {
        
        listStudents.add(student);
        int size = listStudents.size();
        for (int i = 0; i < size; i++) {
            listStudents.get(i).setId(i+1);
        }
        writeListStudents(listStudents);
        
        
    }

    /**
     * cập nhật student vào listStudents và lưu listStudents vào file
     * 
     * @param student
     */
    public void edit(Student student) {
        int size = listStudents.size();
        for (int i = 0; i < size; i++) {
            if (listStudents.get(i).getId() == student.getId()) {
                listStudents.get(i).setName(student.getName());
                listStudents.get(i).setAge(student.getAge());
                listStudents.get(i).setAddress(student.getAddress());
                listStudents.get(i).setGioitinh(student.isGioitinh());
                listStudents.get(i).setNt(student.getNt());
                listStudents.get(i).setTsb(student.getTsb());
                listStudents.get(i).setGt(student.getGt());
                listStudents.get(i).setCost(student.getCost());
                if (student.getHinhAnh() != null) {
                    listStudents.get(i).setHinhAnh(student.getHinhAnh());
                }
                //listStudents.get(i).setImageFilePath(student.getImageFilePath());a
                writeListStudents(listStudents);
                break;
            }
        }
    }

    /**
     * xóa student từ listStudents và lưu listStudents vào file
     * 
     * @param student
     */
    public boolean delete(Student student) {
        boolean isFound = false;
        int size = listStudents.size();
        for (int i = 0; i < size; i++) {
            if (listStudents.get(i).getId() == student.getId()) {
                student = listStudents.get(i);
                isFound = true;
                break;
            }
        }
        if (isFound) {
            listStudents.remove(student);
         size = listStudents.size();  
        for (int i = 0; i < size; i++) {
            listStudents.get(i).setId(i+1);
        }
            writeListStudents(listStudents);
            return true;
        }
        return false;
    }

    /**
     * sắp xếp danh sách student theo name theo tứ tự tăng dần
     */
    public void sortStudentByName() {
        Collections.sort(listStudents, new Comparator<Student>() {
            public int compare(Student student1, Student student2) {
                return student1.getName().compareTo(student2.getName());
            }
        });
        
        int size = listStudents.size();
        for (int i = 0; i < size; i++) {
            listStudents.get(i).setId(i+1);
        }
    }

    /**
     * sắp xếp danh sách student theo GPA theo tứ tự tăng dần
     */
    public void sortStudentByNumber() {
        Collections.sort(listStudents, new Comparator<Student>() {
            public int compare(Student student1, Student student2) {
                return student1.getTsb().compareTo(student2.getTsb());
            }
        });
        int size = listStudents.size();
        for (int i = 0; i < size; i++) {
            listStudents.get(i).setId(i+1);
        }
    }

    public List<Student> getListStudents() {
        return listStudents;
    }

    public void setListStudents(List<Student> listStudents) {
        this.listStudents = listStudents;
    }
}