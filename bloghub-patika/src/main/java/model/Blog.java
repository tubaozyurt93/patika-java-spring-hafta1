package model;

import model.enums.BlogStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Blog {

    private String title;
    private String text;
    private LocalDate createdDate;
    private User user;
    private BlogStatus blogStatus;
    private Long likeCount;
    private long viewCount;
    private List<BlogComment> blogCommentList = new ArrayList<>();

    public Blog(String title, String text, User user) {
        this.title = title;
        this.text = text;
        this.user = user;
        this.viewCount = 0;
        this.createdDate = LocalDate.now(); // Blog oluşturulduğunda tarih atanır
        this.blogStatus = BlogStatus.DRAFT;
        this.likeCount = 0L;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public BlogStatus getBlogStatus() {
        return blogStatus;
    }

    public void setBlogStatus(BlogStatus blogStatus) {
        this.blogStatus = blogStatus;
    }

    public Long getLikeCount() {
        return likeCount;
    }

    public long getViewCount() {
        return viewCount;
    }

    public void setViewCount(long viewCount) {
        this.viewCount = viewCount;
    }

    public List<BlogComment> getBlogCommentList() {
        return blogCommentList;
    }

    public void setBlogCommentList(List<BlogComment> blogCommentList) {
        this.blogCommentList = blogCommentList;
    }

    @Override
    public String toString() {
        return "Blog{" +
                "title='" + title + '\'' +
                ", text='" + text + '\'' +
                ", createdDate=" + createdDate +
                ", user=" + user +
                ", blogStatus=" + blogStatus +
                ", viewCount=" + viewCount +
                '}';
    }
}
