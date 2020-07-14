/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CommentObserver;

import java.util.concurrent.Flow;

/**
 *
 * @author coqls
 */
public class CommentDisplay implements Flow.Subscriber<CommentData.Values> {
    
    private int commentNumber;
    private int postNumber;
    private Flow.Subscription subscription = null;
    
    public void display(){
        System.out.println("commentNumber : " + commentNumber + " postNumber : " + postNumber);
    }
    
    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        this.subscription = subscription;
        subscription.request(1);
    }

    @Override
    public void onNext(CommentData.Values item) {
        this.commentNumber = item.getCommentNumber();
        this.postNumber = item.getPostNumber();
        display();
        this.subscription.request(1);
    }

    @Override
    public void onError(Throwable throwable) {
        throwable.printStackTrace();
    }

    @Override
    public void onComplete() {
        System.out.println("Complete!");
    }
    
}
