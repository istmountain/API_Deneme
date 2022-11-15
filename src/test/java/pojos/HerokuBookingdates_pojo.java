package pojos;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class HerokuBookingdates_pojo {

    private String checkin;
    private String checkout;

    public HerokuBookingdates_pojo() {
    }

    public HerokuBookingdates_pojo(String checkin, String checkout) {
        this.checkin = checkin;
        this.checkout = checkout;
    }

    public String getCheckin() {
        return checkin;
    }

    public void setCheckin(String checkin) {
        this.checkin = checkin;
    }

    public String getCheckout() {
        return checkout;
    }

    public void setCheckout(String checkout) {
        this.checkout = checkout;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("pojos.HerokuBookingdates_pojo{");
        sb.append("checkin='").append(checkin).append('\'');
        sb.append(", checkout='").append(checkout).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
