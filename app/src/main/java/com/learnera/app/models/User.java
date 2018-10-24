package com.learnera.app.models;

import android.app.Activity;
import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AlertDialog;
import android.view.ContextThemeWrapper;
import android.widget.Toast;

import com.learnera.app.R;
import com.learnera.app.activities.WelcomeActivity;
import com.learnera.app.database.DatabaseConstants;

/**
 * Created by praji on 7/2/2017.
 */
@Entity(tableName = DatabaseConstants.UsersTable.TABLE_NAME)
public class User {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = DatabaseConstants.UsersTable.USER_ID)
    private String userName; //UID
    @ColumnInfo(name = DatabaseConstants.UsersTable.PASSWORD)
    private int password;
    @ColumnInfo(name = DatabaseConstants.UsersTable.USER_NAME)
    private String user; //Name of the user
    @ColumnInfo(name = DatabaseConstants.UsersTable.SEMESTER)
    private int sem;
    @ColumnInfo(name = DatabaseConstants.UsersTable.DEPARTMENT)
    private String dept;

    public User() {
    }

    public static void eraseUserInfo(Context context) {
        //removes all contents of sharedpreference file
        SharedPreferences sharedPreferences = context.getSharedPreferences(Constants.PREFERENCE_FILE, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
    }

    public static void logout(final Activity activity) {
        if (isLoggedIn(activity)) {
            //shows confirmation dialog for logout operation
            AlertDialog.Builder alert = new AlertDialog.Builder(new ContextThemeWrapper(activity, R.style.AlertDialogCustom));
            alert.setTitle(activity.getString(R.string.action_logout))
                    .setMessage(activity.getString(R.string.dialog_logout_description))
                    .setPositiveButton(activity.getString(R.string.btn_yes), new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            //if user confirms logout erases user data and shows logout success message
                            eraseUserInfo(activity.getBaseContext());
                            Toast.makeText(activity, activity.getString(R.string.toast_logout_success), Toast.LENGTH_SHORT).show();
                            activity.startActivity(new Intent(activity, WelcomeActivity.class));
                        }
                    })
                    .setNegativeButton(activity.getString(R.string.btn_no), null)
                    .show();
        } else {
            //if not logged in alerts user about it
            Toast.makeText(activity, activity.getString(R.string.toast_not_logged_in), Toast.LENGTH_SHORT).show();
        }
    }

    public static boolean isLoggedIn(Activity activity) {
        User user = new User();
        //checks whether username and password in sharedpreferences file is null. If null user is not logged in else he is logged in
        SharedPreferences sharedPreferences = activity.getSharedPreferences(Constants.PREFERENCE_FILE, Context.MODE_PRIVATE);
        user.setUserName(sharedPreferences.getString(activity.getString(R.string.pref_username), null));
        user.setPassword(sharedPreferences.getInt(activity.getString(R.string.pref_password), 0));
        return user.getPassword() != 0 && user.getUserName() != null;
    }

    public static User getLoginInfo(FragmentActivity fragmentActivity) {

        User result = new User();
        //loads ALL contents of sharedpreferences file to a new User object and returns it.
        SharedPreferences sharedPreferences = fragmentActivity.getSharedPreferences(Constants.PREFERENCE_FILE, Context.MODE_PRIVATE);
        result.setUser(sharedPreferences.getString(fragmentActivity.getString(R.string.pref_user), null));
        result.setUserName(sharedPreferences.getString(fragmentActivity.getString(R.string.pref_username), null));
        result.setPassword(sharedPreferences.getInt(fragmentActivity.getString(R.string.pref_password), 0));
        result.setSem(sharedPreferences.getInt(fragmentActivity.getString(R.string.pref_sem), 0));
        result.setDept(sharedPreferences.getString(fragmentActivity.getString(R.string.pref_department), null));
        return result;
    }

    public static User getLoginInfo(Activity activity) {

        User result = new User();
        //loads ALL contents of sharedpreferences file to a new User object and returns it.
        SharedPreferences sharedPreferences = activity.getSharedPreferences(Constants.PREFERENCE_FILE, Context.MODE_PRIVATE);
        result.setUser(sharedPreferences.getString(activity.getString(R.string.pref_user), null));
        result.setUserName(sharedPreferences.getString(activity.getString(R.string.pref_username), null));
        result.setPassword(sharedPreferences.getInt(activity.getString(R.string.pref_password), 0));
        result.setSem(sharedPreferences.getInt(activity.getString(R.string.pref_sem), 0));
        result.setDept(sharedPreferences.getString(activity.getString(R.string.pref_department), null));
        return result;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public int getSem() {
        return sem;
    }

    public void setSem(int sem) {
        this.sem = sem;
    }

    public int getattendanceCutoff(FragmentActivity fragmentActivity) {
        SharedPreferences sharedPreferences = fragmentActivity.getSharedPreferences(Constants.PREFERENCE_FILE, Context.MODE_PRIVATE);
        return sharedPreferences.getInt(fragmentActivity.getString(R.string.pref_attendance_cutoff), 0);
    }

    public void setAttendenceCutoff(FragmentActivity fragmentActivity, int attendanceCutoff) {
        SharedPreferences sharedPreferences = fragmentActivity.getSharedPreferences(Constants.PREFERENCE_FILE, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(fragmentActivity.getString(R.string.pref_attendance_cutoff),
                attendanceCutoff);
        editor.apply();

    }
}
