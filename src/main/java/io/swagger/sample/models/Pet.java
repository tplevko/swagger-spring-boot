package io.swagger.sample.models;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

//@XmlRootElement(name = "Pet")
//@ApiModel(value = "Pet", description = "Model description", reference = "reference")
@XmlRootElement
public class Pet {

    private long id;
    @XmlElement(name = "category")
    private Category category;
    private String name;
    private List<String> photoUrls = new ArrayList<String>();
    @XmlElement(name = "tag")
    private List<Tag> tags = new ArrayList<Tag>();
    private String status;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    @XmlElementWrapper(name = "photoUrls")
//    @XmlElement(name = "photoUrl")
    public List<String> getPhotoUrls() {
        return photoUrls;
    }

    public void setPhotoUrls(List<String> photoUrls) {
        this.photoUrls = photoUrls;
    }

//    @XmlElementWrapper(name = "tags")
//    @XmlElement(name = "tag")
    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

//    @XmlElement(name = "status")
//    @ApiModelProperty(value = "pet status in the store", allowableValues = "available,pending,sold")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
