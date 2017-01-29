package vlc.ss.datastore;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

@Entity
public class Receipt {

    @Id
    private Long id;

    private String text;

    public Receipt() {
    }

    public Receipt(Long id, String text) {
        this.id = id;
        this.text = text;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Receipt{" +
                "id=" + id +
                ", text='" + text + '\'' +
                '}';
    }
}
