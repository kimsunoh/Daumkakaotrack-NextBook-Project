package com.scratchback.spring.test;

import java.util.Date;

public class Blog {
	private long id;
	private String subject;
	private String article;
	private Date datetime;

	public void setId(long id) {
		this.id = id;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public long getId() {
		return id;
	}

	public void setArticle(String article) {
		this.article = article;
	}

	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}

	public String getSubject() {
		return subject;
	}

	public String getArticle() {
		return article;
	}

	public Date getDatetime() {
		return datetime;
	}

	@Override
	public String toString() {
		return "Blog [id=" + id + ", subject=" + subject + ", article="
				+ article + ", datetime=" + datetime + "]";
	}
}
