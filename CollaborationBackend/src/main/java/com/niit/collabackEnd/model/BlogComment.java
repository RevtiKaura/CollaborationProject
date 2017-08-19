package com.niit.collabackEnd.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import org.springframework.stereotype.Component;

@Entity
@Table(name="collaboration_blogcomment")
@Component
public class BlogComment implements Serializable {
	

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int blogcommentid;

	@ManyToOne
	@JoinColumn(name = "blogId")
	private Blog blog;

	@Column(name = "blogcomment")
	private String comment;

	@Temporal(TemporalType.DATE)
	private Date commentDate;
	private int userId;
	private String username;



	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	

	public int getBlogcommentid() {
		return blogcommentid;
	}

	public void setBlogcommentid(int blogcommentid) {
		this.blogcommentid = blogcommentid;
	}

	public Blog getBlog() {
		return blog;
	}

	public void setBlog(Blog blog) {
		this.blog = blog;
	}


	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Date getCommentDate() {
		return commentDate;
	}

	public void setCommentDate(Date commentDate) {
		this.commentDate = commentDate;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}


}
