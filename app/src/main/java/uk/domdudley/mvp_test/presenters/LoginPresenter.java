package uk.domdudley.mvp_test.presenters;

import uk.domdudley.mvp_test.iLoginView;
import uk.domdudley.mvp_test.model.LoginInteractor;
import uk.domdudley.mvp_test.model.OnLoginFinishedListener;

/**
 * Created by Dom on 23/11/2016.
 */
public class LoginPresenter implements iLoginPresenter, OnLoginFinishedListener {

    private iLoginView view;
    private LoginInteractor interactor;

    public LoginPresenter(iLoginView view){
        this.view = view;
        this.interactor = new LoginInteractor();
    }

    @Override
    public void attemptLogin(String username, String password) {
        interactor.validateCredentials(this, username, password);
    }

    @Override
    public void onSuccess() {
        view.loginSuccess();
    }

    @Override
    public void onError() {
        view.loginFailed();
    }
}
