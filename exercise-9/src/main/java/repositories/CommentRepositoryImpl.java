package repositories;

import model.Comment;

public class CommentRepositoryImpl implements CommentRepository {
    @Override
    public void storeComment(Comment comment) {
        System.out.println("Storing comment: " + comment.getText());
    }
}
