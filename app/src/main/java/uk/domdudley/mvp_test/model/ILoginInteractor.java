package uk.domdudley.mvp_test.model;

/**
 * Created by Dom on 23/11/2016.
 */
public interface ILoginInteractor {
    void validateCredentials(OnLoginFinishedListener listener, final String username, final String password);
}
