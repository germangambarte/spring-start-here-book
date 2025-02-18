package services;

import model.Comment;
import aspects.ToLog;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class CommentService {
    private Logger logger = Logger.getLogger(CommentService.class.getName());

    public String publishComment(Comment comment) {
        logger.info("Publishing comment: " + comment.getText());
        return "SUCCESS";
    }

    @ToLog
    public String deleteComment(Comment comment) {
        logger.info("Deleting comment" + comment.getText());
        return "SUCCESS";
    }

    public String editComment(Comment comment) {
        logger.info("Editing comment" + comment.getText());
        return "SUCCESS";
    }
}
