package uk.domdudley.mvp_test.model;

import android.os.Handler;

/**
 * Created by Dom on 23/11/2016.
 */
public class LoginInteractor implements ILoginInteractor {
    @Override
    public void validateCredentials(final OnLoginFinishedListener listener, final String username, final String password) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if((username.length() > 3) && (password.length() > 3)){
                    listener.onSuccess();
                }
                else{
                    listener.onError();
                }
            }
        }, 2000);
    }
}
