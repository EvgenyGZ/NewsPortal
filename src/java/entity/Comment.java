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
    private Users author;
    private String CommentText;

    public Comment() {
    }

    public Comment(Articles articles, Date createDatel, Date lastEditDate, Users author, String CommentText) {
        this.articles = articles;
        this.createDatel = createDatel;
        this.lastEditDate = lastEditDate;
        this.author = author;
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

    public Users getAuthor() {
        return author;
    }

    public void setAuthor(Users author) {
        this.author = author;
    }

    public String getCommentText() {
        return CommentText;
    }

    public void setCommentText(String CommentText) {
        this.CommentText = CommentText;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + Objects.hashCode(this.id);
        hash = 23 * hash + Objects.hashCode(this.articles);
        hash = 23 * hash + Objects.hashCode(this.createDatel);
        hash = 23 * hash + Objects.hashCode(this.lastEditDate);
        hash = 23 * hash + Objects.hashCode(this.author);
        hash = 23 * hash + Objects.hashCode(this.CommentText);
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
        if (!Objects.equals(this.author, other.author)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Comment{" 
                + "id=" + id 
                + ", articles=" + articles 
                + ", createDatel=" + createDatel 
                + ", lastEditDate=" + lastEditDate 
                + ", author=" + author.getNickName()
                + ", CommentText=" + CommentText 
                + '}';
    }

    
}
