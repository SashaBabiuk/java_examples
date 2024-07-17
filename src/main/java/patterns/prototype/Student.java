package patterns.prototype;

public class Student implements Cloneable{
    @Override
    protected Student clone() throws CloneNotSupportedException {
        return (Student)super.clone();
    }

}

class Cache{
    private Student student;
    public Student getStudent() throws CloneNotSupportedException {
        return student.clone();
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
