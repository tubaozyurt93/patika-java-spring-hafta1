import model.Blog;
import model.User;
import model.enums.BlogStatus;
import model.enums.StatusType;
import repository.BlogRepository;
import repository.UserRepository;
import service.BlogService;
import service.UserService;

import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws NoSuchAlgorithmException {

        UserService userService = new UserService(new UserRepository());

        BlogService blogService = new BlogService(new BlogRepository(), userService);

        userService.saveUser("cem@gmail.com", "password");
        userService.saveUser("mehmet@gmail.com", "123456");
        userService.saveUser("toygun@gmail.com", "123456");

        userService.changeStatus("cem@gmail.com", StatusType.APPROVED);
        userService.changeStatus("mehmet@gmail.com", StatusType.APPROVED);
        userService.changeStatus("toygun@gmail.com", StatusType.APPROVED);

        userService.changeStatus(List.of("cem@gmail.com", "toygun@gmail.com"), StatusType.APPROVED);

        userService.getAllUsers().forEach(System.out::println);

            List<String> emailList = userService.getAllUsers()
                    .stream()
                    .map(User::getEmail)
                    .toList();


            Map<String, User> emailUserMap = userService.getAllUsersMap();

            User cemUser = emailUserMap.get("cem@gmail.com");


            User foundUser = userService.getUserByEmail("cem@gmail.com");


            blogService.createBlog("başlık", "içerik", "cem@gmail.com");

            Blog foundBlog = blogService.getBlogByTitle("başlık");

            blogService.addComment("başlık", "çok kötü olmuş", foundUser);

            // Yorum,okunma sayısı ve oluşturulmna tarihini göre artan veya azalan sıralama
            blogService.changeBlogStatus(BlogStatus.DELETED, "başlık");
            List<Blog> blogsByDateAsc = blogService.getBlogsSortedByCreationDate(true);
            List<Blog> blogsByDateDesc = blogService.getBlogsSortedByCreationDate(false);

            List<Blog> blogsByCommentsAsc = blogService.getBlogsSortedByCommentCount(true);
            List<Blog> blogsByCommentsDesc = blogService.getBlogsSortedByCommentCount(false);

            List<Blog> blogsByViewsAsc = blogService.getBlogsSortedByViewCount(true);
            List<Blog> blogsByViewsDesc = blogService.getBlogsSortedByViewCount(false);

            // Blog istatistikleri
            System.out.println("Toplam blog sayısı: " + blogService.getTotalBlogs());
            System.out.println("Yayınlanmış blog sayısı: " + blogService.getPublishedBlogsCount());
            System.out.println("Tasarım aşamasındaki blog sayısı: " + blogService.getDraftBlogsCount());
            System.out.println("Silinmiş blog sayısı: " + blogService.getDeletedBlogsCount());
            System.out.println("Toplam beğenme sayısı: " + blogService.getLikeCount());



        System.out.println("Bloglar oluşturulma tarihine göre artan:");
        blogsByDateAsc.forEach(blog -> System.out.println(blog.getTitle() + " - Oluşturulma Tarihi: " + blog.getCreatedDate()));

        System.out.println("\nBloglar oluşturulma tarihine göre azalan:");
        blogsByDateDesc.forEach(blog -> System.out.println(blog.getTitle() + " - Oluşturulma Tarihi: " + blog.getCreatedDate()));

        System.out.println("\nBloglar yorum sayısına göre artan:");
        blogsByCommentsAsc.forEach(blog -> System.out.println(blog.getTitle() + " - Yorum Sayısı: " + blog.getBlogCommentList().size()));

        System.out.println("\nBloglar yorum sayısına göre azalan:");
        blogsByCommentsDesc.forEach(blog -> System.out.println(blog.getTitle() + " - Yorum Sayısı: " + blog.getBlogCommentList().size()));

        System.out.println("\nBloglar okunma sayısına göre artan:");
        blogsByViewsAsc.forEach(blog -> System.out.println(blog.getTitle() + " - Okunma Sayısı: " + blog.getViewCount()));

        System.out.println("\nBloglar okunma sayısına göre azalan:");
        blogsByViewsDesc.forEach(blog -> System.out.println(blog.getTitle() + " - Okunma Sayısı: " + blog.getViewCount()));

        }
    }
