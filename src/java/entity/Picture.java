package entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Picture implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Long NewsID; // проверить???!!!
    private String picTitle;
    @OneToOne
    private  Users author;

    public Picture() {
    }

    public Picture(Long NewsID, String picTitle, Users author) {
        this.NewsID = NewsID;
        this.picTitle = picTitle;
        this.author = author;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNewsID() {
        return NewsID;
    }

    public void setNewsID(Long NewsID) {
        this.NewsID = NewsID;
    }

    public String getPicTitle() {
        return picTitle;
    }

    public void setPicTitle(String picTitle) {
        this.picTitle = picTitle;
    }

    public Users getAuthor() {
        return author;
    }

    public void setAuthor(Users author) {
        this.author = author;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.id);
        hash = 59 * hash + Objects.hashCode(this.NewsID);
        hash = 59 * hash + Objects.hashCode(this.picTitle);
        hash = 59 * hash + Objects.hashCode(this.author);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Picture other = (Picture) obj;
        if (!Objects.equals(this.picTitle, other.picTitle)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.NewsID, other.NewsID)) {
            return false;
        }
        if (!Objects.equals(this.author, other.author)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Picture{" 
                + "id=" + id 
                + ", NewsID=" + NewsID 
                + ", picTitle=" + picTitle 
                + ", author=" + author.getNickName()
                + '}';
    }
    

    
    
}
