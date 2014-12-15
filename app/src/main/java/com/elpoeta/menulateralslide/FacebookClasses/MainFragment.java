package com.elpoeta.menulateralslide.FacebookClasses;



import com.elpoeta.menulateralslide.MyActivity;
import com.elpoeta.menulateralslide.R;
import java.util.Arrays;

import com.facebook.Request;
import com.facebook.Response;
import com.facebook.SessionState;
import com.facebook.Session;
import com.facebook.UiLifecycleHelper;
import com.facebook.model.GraphUser;
import com.facebook.widget.LoginButton;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class MainFragment extends Fragment{


    private static final String TAG = "MainFragment";

    private UiLifecycleHelper uiHelper;
  //  private static final int REAUTH_ACTIVITY_CODE = 100;
    private String user_email;
    private String user_name;
    private String user_lastname;
    private String user_birthdate;
    private String user_id;
    private String user_gender;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        uiHelper = new UiLifecycleHelper(getActivity(), callback);
        uiHelper.onCreate(savedInstanceState);
    }


    private Session.StatusCallback callback = new Session.StatusCallback() {
        @Override
        public void call(Session session, SessionState state, Exception exception) {
            onSessionStateChange(session, state, exception);
        }
    };

    private void onSessionStateChange(Session session, SessionState state, Exception exception) {
        if (session != null && session.isOpened()) {
            Log.i(TAG, "Logged in...");
            makeMeRequest(session);
            Intent intent = new Intent(getActivity(), MyActivity.class);
            startActivity(intent);
        } else if (state.isClosed()) {
            Log.i(TAG, "Logged out...");
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_login, container, false);


        LoginButton authButton = (LoginButton) view.findViewById(R.id.authButton);

        authButton.setFragment(this);
        authButton.setReadPermissions(Arrays.asList("user_likes", "user_status","public_profile","user_birthday","email"));

        return view;
    }


    @Override
    public void onResume() {
        super.onResume();

        // For scenarios where the main activity is launched and user
        // session is not null, the session state change notification
        // may not be triggered. Trigger it if it's open/closed.
        Session session = Session.getActiveSession();
        if (session != null &&
                (session.isOpened() || session.isClosed()) ) {
            onSessionStateChange(session, session.getState(), null);
        }

        uiHelper.onResume();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
            uiHelper.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onPause() {
        super.onPause();
        uiHelper.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        uiHelper.onDestroy();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        uiHelper.onSaveInstanceState(outState);
    }
    //getters de los atributos del usuario
    public String getUser_email() {
        return user_email;
    }
    public String getUser_name() {
        return user_name;
    }
    public String getUser_lastname() {
        return user_lastname;
    }
    public String getUser_birthdate() {
        return user_birthdate;
    }
    public String getUser_id() {
        return user_id;
    }
    public String getUser_gender() {
        return user_gender;
    }

    private void makeMeRequest(final Session session) {
        // Make an API call to get user data and define a
        // new callback to handle the response.
        Request request = Request.newMeRequest(session,
                new Request.GraphUserCallback() {
                    @Override
                    public void onCompleted(GraphUser user, Response response) {
                        // If the response is successful
                        if (session == Session.getActiveSession()) {
                            if (user != null) {
                                user_id= user.getId();
                                user_name= user.getFirstName();
                                user_lastname= user.getLastName();
                                user_birthdate= user.getBirthday();
                                user_gender = user.asMap().get("gender").toString();
                                user_email = user.asMap().get("email").toString();
                                String infoUsuario = "ID: "+getUser_id()
                                        +"\nNombre: "+getUser_name()
                                        +"\nApellido: "+getUser_lastname()
                                        +"\nFecha de nacimiento: "+getUser_birthdate()
                                        +"\nGenero: "+getUser_gender()
                                        +"\nCorreo: "+getUser_email();
                                System.out.println(infoUsuario);
                            }
                        }
                        if (response.getError() != null) {
                            // Handle errors, will do so later.
                        }
                    }
                });
        request.executeAsync();
    }
}


