package service;

import model.Blog;
import model.BlogComment;
import model.User;
import model.enums.BlogStatus;
import repository.BlogRepository;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class BlogService {

    private BlogRepository blogRepository;
    private UserService userService;

    public BlogService(BlogRepository blogRepository, UserService userService) {
        this.blogRepository = blogRepository;
        this.userService = userService;
    }

    public Blog createBlog(String title, String text, String email) {

        User foundUser = userService.getUserByEmail(email);

        Blog blog = new Blog(title, text, foundUser);

        blogRepository.save(blog);

        return blog;
    }

    public Blog getBlogByTitle(String title) {

        return blogRepository.findByTitle(title).orElseThrow(() -> new RuntimeException("blog bulunamadı"));
    }

    public void addComment(String title, String comment, User user) {

        Blog foundBlog = getBlogByTitle(title);
        //TODO log ekle
        foundBlog.getBlogCommentList().add(new BlogComment(user, comment));

    }

    public List<Blog> getBlogsFilterByStatus(BlogStatus blogStatus, String email) {

        User foundUser = userService.getUserByEmail(email);

        return foundUser.getBlogList().stream()
                .filter(blog -> blogStatus.equals(blog.getBlogStatus()))
                .toList();
    }

    public void changeBlogStatus(BlogStatus blogStatus, String title) {

        Blog foundBlog = getBlogByTitle(title);

        if (foundBlog.getBlogStatus().equals(BlogStatus.PUBLISHED)) {
            throw new RuntimeException("statüsü PUBLISHED olan bir blog silinemez.");
        }

        //TODO log eklenecek
        foundBlog.setBlogStatus(blogStatus);

    }

    //
    public long getTotalBlogs() {
        return blogRepository.getAllBlogs().size();
    }

    // Toplam beğeni sayısını dönen metod
    public long getLikeCount() {
        return blogRepository.getAllBlogs().stream()
                .mapToLong(Blog::getLikeCount) // Blogların beğeni sayısını alır
                .sum(); // Toplam beğeni sayısını toplar
    }

    // Yayınlanan blog sayısını dönen metod
    public long getPublishedBlogsCount() {
        return blogRepository.getAllBlogs().stream()
                .filter(blog -> BlogStatus.PUBLISHED.equals(blog.getBlogStatus()))
                .count();
    }

    // Yayına hazır olan blogları dönen metod
    public long getDraftBlogsCount() {
        return blogRepository.getAllBlogs().stream()
                .filter(blog -> BlogStatus.DRAFT.equals(blog.getBlogStatus()))
                .count();
    }

    // Silinmiş blogları dönen metod
    public long getDeletedBlogsCount() {
        return blogRepository.getAllBlogs().stream()
                .filter(blog -> BlogStatus.DELETED.equals(blog.getBlogStatus()))
                .count();
    }

    // Blogları oluşturulma tarihine göre sıralar
    public List<Blog> getBlogsSortedByCreationDate(boolean ascending) {
        return blogRepository.getAllBlogs().stream()
                .sorted(ascending ? Comparator.comparing(Blog::getCreatedDate)
                        : Comparator.comparing(Blog::getCreatedDate).reversed())
                .collect(Collectors.toList());
    }

    // Blogları yorum sayısına göre sıralar
    public List<Blog> getBlogsSortedByCommentCount(boolean ascending) {
        return blogRepository.getAllBlogs().stream()
                .sorted(ascending ? Comparator.comparingInt(blog -> blog.getBlogCommentList().size())
                        : Comparator.comparingInt(blog -> blog.getBlogCommentList().reversed().size())
                )
                .collect(Collectors.toList());
    }

    // Blogları okunma sayısına göre sıralar
    public List<Blog> getBlogsSortedByViewCount(boolean ascending) {
        return blogRepository.getAllBlogs().stream()
                .sorted(ascending ? Comparator.comparingLong(Blog::getViewCount)
                        : Comparator.comparingLong(Blog::getViewCount).reversed())
                .collect(Collectors.toList());
    }
}
