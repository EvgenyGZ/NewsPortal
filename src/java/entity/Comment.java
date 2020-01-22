/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author pupil
 */
@Entity
public class Comment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Articles articles;
        
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDatel;
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastEditDate;

    @OneToOne
    private Person person;
    private String CommentText;

    public Comment() {
    }

    public Comment(Articles articles, Date createDatel, Date lastEditDate, Person person, String CommentText) {
        this.articles = articles;
        this.createDatel = createDatel;
        this.lastEditDate = lastEditDate;
        this.person = person;
        this.CommentText = CommentText;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Articles getArticles() {
        return articles;
    }

    public void setArticles(Articles articles) {
        this.articles = articles;
    }

    public Date getCreateDatel() {
        return createDatel;
    }

    public void setCreateDatel(Date createDatel) {
        this.createDatel = createDatel;
    }

    public Date getLastEditDate() {
        return lastEditDate;
    }

    public void setLastEditDate(Date lastEditDate) {
        this.lastEditDate = lastEditDate;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getCommentText() {
        return CommentText;
    }

    public void setCommentText(String CommentText) {
        this.CommentText = CommentText;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.id);
        hash = 59 * hash + Objects.hashCode(this.articles);
        hash = 59 * hash + Objects.hashCode(this.createDatel);
        hash = 59 * hash + Objects.hashCode(this.lastEditDate);
        hash = 59 * hash + Objects.hashCode(this.person);
        hash = 59 * hash + Objects.hashCode(this.CommentText);
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
        final Comment other = (Comment) obj;
        if (!Objects.equals(this.CommentText, other.CommentText)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.articles, other.articles)) {
            return false;
        }
        if (!Objects.equals(this.createDatel, other.createDatel)) {
            return false;
        }
        if (!Objects.equals(this.lastEditDate, other.lastEditDate)) {
            return false;
        }
        if (!Objects.equals(this.person, other.person)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Comment{" + "id=" + id + ", articles=" + articles + ", createDatel=" + createDatel + ", lastEditDate=" + lastEditDate + ", person=" + person + ", CommentText=" + CommentText + '}';
    }

    
    
}
