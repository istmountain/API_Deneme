package pojos;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Jsonplaceholder_pojo {

/*
    1. tum keyler icin private veriable olusturulur
    2. tum parametrelerle ve parametresiz constructorlar olusturulur
    3. Getters ve setter lerimizi olusturuoyruz
    4. create tostring methodunu olusturmak
     */

    private Integer userId;
    private String title;
    private Boolean completed; // buranin gettelerini iscompleted yapabiliriz

    public Jsonplaceholder_pojo() {
    }

    public Jsonplaceholder_pojo(Integer userId, String title, Boolean completed) {
        this.userId = userId;
        this.title = title;
        this.completed = completed;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("pojos.Jsonplaceholder_pojo{");
        sb.append("userId=").append(userId);
        sb.append(", title='").append(title).append('\'');
        sb.append(", completed=").append(completed);
        sb.append('}');
        return sb.toString();
    }
}

