package pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class GoRestPojo {
    @JsonIgnoreProperties(ignoreUnknown =false)
    private Object meta;
    private GorestDataPojo data;

    public GoRestPojo() {
    }

    public GoRestPojo(Object meta, GorestDataPojo data) {
        this.meta = meta;
        this.data = data;
    }

    public Object getMeta() {
        return meta;
    }

    public void setMeta(Object meta) {
        this.meta = meta;
    }

    public GorestDataPojo getData() {
        return data;
    }

    public void setData(GorestDataPojo data) {
        this.data = data;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("pojos.GoRestPojo{");
        sb.append("meta=").append(meta);
        sb.append(", data=").append(data);
        sb.append('}');
        return sb.toString();
    }
}
