package pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class GorestDataPojo {
     @JsonIgnoreProperties(ignoreUnknown = false)

     private Integer id;
     private String name;
     private String email;
     private String gender;
     private String status;

     public GorestDataPojo() {
     }

     public GorestDataPojo(Integer id, String name, String email, String gender, String status) {
          this.id = id;
          this.name = name;
          this.email = email;
          this.gender = gender;
          this.status = status;
     }

     public Integer getId() {
          return id;
     }

     public void setId(Integer id) {
          this.id = id;
     }

     public String getName() {
          return name;
     }

     public void setName(String name) {
          this.name = name;
     }

     public String getEmail() {
          return email;
     }

     public void setEmail(String email) {
          this.email = email;
     }

     public String getGender() {
          return gender;
     }

     public void setGender(String gender) {
          this.gender = gender;
     }

     public String getStatus() {
          return status;
     }

     public void setStatus(String status) {
          this.status = status;
     }

     @Override
     public String toString() {
          final StringBuilder sb = new StringBuilder("pojos.GorestDataPojo{");
          sb.append("id=").append(id);
          sb.append(", name='").append(name).append('\'');
          sb.append(", email='").append(email).append('\'');
          sb.append(", gender='").append(gender).append('\'');
          sb.append(", status='").append(status).append('\'');
          sb.append('}');
          return sb.toString();
     }
}
