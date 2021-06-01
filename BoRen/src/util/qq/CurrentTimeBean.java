package util.qq;

public class CurrentTimeBean {
    private String uuid;
    private String timestamp;

    
    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public CurrentTimeBean() {
    }

    @Override
    public String toString() {
        return "CurrentTimeBean [uuid=" + uuid + ", timestamp=" + timestamp
                + "]";
    }

}