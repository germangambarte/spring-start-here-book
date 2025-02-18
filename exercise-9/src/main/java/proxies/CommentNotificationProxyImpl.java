package proxies;

import model.Comment;

public class CommentNotificationProxyImpl implements CommentNotificationProxy {
    @Override
    public void sendComment(Comment comment) {
        System.out.println("sendComment: " + comment.getText());
    }
}
