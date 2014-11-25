package com.elpoeta.menulateralslide.loginFacebook;



import com.elpoeta.menulateralslide.MyActivity;
import com.elpoeta.menulateralslide.R;
import java.util.Arrays;

import com.facebook.HttpMethod;
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
import android.widget.TextView;

public class MainFragment extends Fragment{


    private static final String TAG = "MainFragment";

    private UiLifecycleHelper uiHelper;


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
        if (state.isOpened()) {
            Log.i(TAG, "Logged in...");
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
        authButton.setReadPermissions(Arrays.asList("public_profile"));

        authButton.setFragment(this);

        authButton.setReadPermissions(Arrays.asList("user_likes", "user_status"));

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

	/*public void InfoProfile(){

		new Request(
			    Session.getActiveSession(),
			    "/me",
			    null,
			    HttpMethod.GET,
			    new Request.Callback() {
			        public void onCompleted(Response response) {

			        	String name = response.getGraphObject().getProperty("first_name").toString();
			        	String last = response.getGraphObject().getProperty("last_name").toString();
			        	TextView test = (TextView)getActivity().findViewById(R.id.textView1);
			        	String display = new StringBuilder(name).append(last).toString();
			        }
			    }
			).executeAsync();


	}*/


}


