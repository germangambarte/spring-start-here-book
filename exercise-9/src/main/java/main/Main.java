package main;

import model.Comment;
import proxies.CommentNotificationProxyImpl;
import repositories.CommentRepositoryImpl;
import services.CommentService;

public class Main {
    public static void main(String[] args) {
        var commentRepository = new CommentRepositoryImpl();
        var commentNotificationProxy = new CommentNotificationProxyImpl();
        var commentService = new CommentService(commentRepository, commentNotificationProxy);

        var comment = new Comment();
        comment.setAuthor("Germán");
        comment.setText("This is a comment");

        commentService.publishComment(comment);
    }
}
