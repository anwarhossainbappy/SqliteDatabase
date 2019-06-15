package bd.ac.cbiu.sqlite.sqlite.model;

public class model {

    private String id;
    private String name;
    private String batch;
    private String student_id;

    public model(String id,String name, String batch, String student_id) {
        this.id = id;
        this.name = name;
        this.batch = batch;
        this.student_id = student_id;
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

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }
}
