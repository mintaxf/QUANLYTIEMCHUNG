
package vn.viettuts.qlsv.entity;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "student")
@XmlAccessorType(XmlAccessType.FIELD)
public class Student implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String name;
    private byte age;
    private String address;
    private String tsb;
    private String gt;
    private String cost;
    private String nt;
    private byte [] hinhAnh;
    private boolean gioitinh;

    public boolean isGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(boolean gioitinh) {
        this.gioitinh = gioitinh;
    }
    

    public byte [] getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(byte [] hinhAnh) {
        this.hinhAnh = hinhAnh;
    }
    

    public String getNt() {
        return nt;
    }

    public void setNt(String nt) {
        this.nt = nt;
    }

    
    public String getTsb() {
        return tsb;
    }

    public void setTsb(String tsb) {
        this.tsb = tsb;
    }

    public String getGt() {
        return gt;
    }

    public void setGt(String gt) {
        this.gt = gt;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public Student() {
    }

    public Student(int id, String name, byte age, String address, String tsb, String gt, String cost, String nt, byte [] hinhAnh, boolean gioitinh) {
        super();
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
        this.tsb = tsb;
        this.gt=gt;
        this.cost=cost;
        this.nt=nt;
        this.hinhAnh=hinhAnh;
        this.gioitinh=gioitinh;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte getAge() {
        return age;
    }

    public void setAge(byte age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setNt(Date selectedDate) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void sethinhAnh(byte[] encodedSrc) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
}

