package pojos;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class HeroukappBooking_pojo {

    private String firstname;
    private String lastname;
    private Integer totalprice;
    private Boolean depositpaid; // buranin getterini isdepositpaid yapabiliriz
    private HerokuBookingdates_pojo bookingdates;
    private String additionalneeds;

    public HeroukappBooking_pojo() {
    }

    public HeroukappBooking_pojo(String firstname, String lastname, Integer totalprice,
    Boolean depositpaid, HerokuBookingdates_pojo bookingdates, String additionalneeds) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.totalprice = totalprice;
        this.depositpaid = depositpaid;
        this.bookingdates = bookingdates;
        this.additionalneeds = additionalneeds;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Integer getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(Integer totalprice) {
        this.totalprice = totalprice;
    }

    public Boolean isDepositpaid() {
        return depositpaid;
    }

    public void setDepositpaid(Boolean depositpaid) {
        this.depositpaid = depositpaid;
    }

    public HerokuBookingdates_pojo getBookingdates() {
        return bookingdates;
    }

    public void setBookingdates(HerokuBookingdates_pojo bookingdates) {
        this.bookingdates = bookingdates;
    }

    public String getAdditionalneeds() {
        return additionalneeds;
    }

    public void setAdditionalneeds(String additionalneeds) {
        this.additionalneeds = additionalneeds;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("pojos.HeroukappBooking_pojo{");
        sb.append("firstname='").append(firstname).append('\'');
        sb.append(", lastname='").append(lastname).append('\'');
        sb.append(", totalprice=").append(totalprice);
        sb.append(", depositpaid=").append(depositpaid);
        sb.append(", bookingdates=").append(bookingdates);
        sb.append(", additionalneeds='").append(additionalneeds).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
