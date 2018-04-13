package io.swagger.sample.models;

import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Pet {

    @XmlElement(name = "id")
    private long id;
    @XmlElement(name = "category")
    private Category category;
    @XmlElement(name = "name")
    private String name;
    @XmlElementWrapper(name = "photoUrls")
    @XmlElement(name = "photoUrl")
    private List<String> photoUrls = new ArrayList<String>();
    @XmlElementWrapper(name = "tags")
    @XmlElement(name = "tag")
    private List<Tag> tags = new ArrayList<Tag>();
    @XmlElement(name = "status")
    @ApiModelProperty(value = "pet status in the store", allowableValues = "available,pending,sold")
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

    public List<String> getPhotoUrls() {
        return photoUrls;
    }

    public void setPhotoUrls(List<String> photoUrls) {
        this.photoUrls = photoUrls;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
