package vn.fis.training.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

public class Customer {
    /** ID cua Customer la duy nhat trong toan bo he thong
       Su dung @java.util.UUID de tao id gan cho tung customer
    */
    private String id;

    /** Constraints:
        1. Khong duoc trong (NOT NULL OR BLANK)
        2. Do dai tu tu 5 den 50 ky tu, chi bao gom ky tu a->z, A->Z va khong trang (Blank).
        3. Truoc khi cap nhat vao he thong truong ten phai duoc chuan hoa.
            Qui tac chuan hoa:
                *. Bo cac ky tu trang o dau va cuoi
                *. Upper case chu cai dau tien truoc cac tu
                   VD: nGuyen van    BinH      -> Nguyen Van Binh
    **/


    private String name;
    /** Constraints:
        1. Khong duoc trong
        2. Tinh toan de khong cho phep nhap Customer nho hon 10 tuoi so voi thoi diem hien tai
     **/
    private LocalDate birthDay;
    /** Constraints:
    *   1. Do dai 10 ky tu bat dau bang ky tu 0, chi bao gom cac so tu 0->9
     *  2. So dien thoai la duy nhat trong toan bo he thong. Duoc su dung de kiem tra duplicate khach hang
     *  3. Chuan hoa lai truong so dien thoai truoc khi cap nhat vao he thong. Bo cac ky tu trang o dau, giua va cuoi
     *     Vidu: 0921 000 008 --> 0921000008
    * */
    private String mobile;

    /** Constraints:
     * NOT NULL
     * */

    private CustomerStatus status;
    private CustomerValidate customerValidate;

    /**
     * Thoi gian tao doi tuong. mac dinh la thoi diem hien tai
     */

    private LocalDateTime createDateTime;

    public Customer(String id, String name, LocalDate birthDay, String mobile, CustomerStatus status, LocalDateTime createDateTime) {
        String uuid = UUID.randomUUID().toString();
        this.id = uuid;
        this.name = customerValidate.name();
        this.birthDay = customerValidate.birthDay();
        this.mobile = mobile;
        this.status = status;
        this.createDateTime = createDateTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public CustomerStatus getStatus() {
        return status;
    }

    public void setStatus(CustomerStatus status) {
        this.status = status;
    }

    public LocalDateTime getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(LocalDateTime createDateTime) {
        this.createDateTime = createDateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Customer customer = (Customer) o;

        if (id != null ? !id.equals(customer.id) : customer.id != null) return false;
        if (name != null ? !name.equals(customer.name) : customer.name != null) return false;
        if (birthDay != null ? !birthDay.equals(customer.birthDay) : customer.birthDay != null) return false;
        if (mobile != null ? !mobile.equals(customer.mobile) : customer.mobile != null) return false;
        if (status != customer.status) return false;
        return createDateTime != null ? createDateTime.equals(customer.createDateTime) : customer.createDateTime == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (birthDay != null ? birthDay.hashCode() : 0);
        result = 31 * result + (mobile != null ? mobile.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (createDateTime != null ? createDateTime.hashCode() : 0);
        return result;
    }
}
