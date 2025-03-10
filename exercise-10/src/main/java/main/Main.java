package main;


import config.ProjectConfig;
import model.Comment;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import services.CommentService;

public class Main {

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        var service = context.getBean(CommentService.class);

        Comment comment = new Comment();
        comment.setText("Holiss");
        comment.setAuthor("Germán");

        service.publishComment(comment);
    }
}
