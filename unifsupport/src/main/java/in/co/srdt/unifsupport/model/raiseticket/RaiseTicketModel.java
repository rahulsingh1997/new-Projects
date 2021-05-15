package in.co.srdt.unifsupport.model.raiseticket;

public class RaiseTicketModel {

    private long id;
    private String ticketnumber;
    private String title;
    private String summary;
    private String status;
    private String description;
    private String attachment;
    private String createdby;
    private String updatedby;
    private String lastupdateddate;
    private String attribute;
    private String attributeone;

    public RaiseTicketModel() {
    }

    public RaiseTicketModel(long id, String ticketnumber, String title, String summary, String status, String description, String attachment, String createdby, String updatedby, String lastupdateddate, String attribute, String attributeone) {
        this.id = id;
        this.ticketnumber = ticketnumber;
        this.title = title;
        this.summary = summary;
        this.status = status;
        this.description = description;
        this.attachment = attachment;
        this.createdby = createdby;
        this.updatedby = updatedby;
        this.lastupdateddate = lastupdateddate;
        this.attribute = attribute;
        this.attributeone = attributeone;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTicketnumber() {
        return ticketnumber;
    }

    public void setTicketnumber(String ticketnumber) {
        this.ticketnumber = ticketnumber;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAttachment() {
        return attachment;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment;
    }

    public String getCreatedby() {
        return createdby;
    }

    public void setCreatedby(String createdby) {
        this.createdby = createdby;
    }

    public String getUpdatedby() {
        return updatedby;
    }

    public void setUpdatedby(String updatedby) {
        this.updatedby = updatedby;
    }

    public String getLastupdateddate() {
        return lastupdateddate;
    }

    public void setLastupdateddate(String lastupdateddate) {
        this.lastupdateddate = lastupdateddate;
    }

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    public String getAttributeone() {
        return attributeone;
    }

    public void setAttributeone(String attributeone) {
        this.attributeone = attributeone;
    }

    @Override
    public String toString() {
        return "RaiseTicketModel{" +
                "id=" + id +
                ", ticketnumber='" + ticketnumber + '\'' +
                ", title='" + title + '\'' +
                ", summary='" + summary + '\'' +
                ", status='" + status + '\'' +
                ", description='" + description + '\'' +
                ", attachment='" + attachment + '\'' +
                ", createdby='" + createdby + '\'' +
                ", updatedby='" + updatedby + '\'' +
                ", lastupdateddate='" + lastupdateddate + '\'' +
                ", attribute='" + attribute + '\'' +
                ", attributeone='" + attributeone + '\'' +
                '}';
    }
}
