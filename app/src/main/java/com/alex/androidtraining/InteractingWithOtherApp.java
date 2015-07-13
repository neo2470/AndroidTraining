package com.alex.androidtraining;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Toast;

import org.apache.http.protocol.HTTP;

import java.util.List;

/**
 * Created by alex on 15-7-9.
 */
public class InteractingWithOtherApp extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interacting_with_other_app);

        Intent intent = getIntent();
        Uri data = intent.getData();

        String type = intent.getType();
        if(null != type) {

            if ("image/".contains(type)) {
                Toast.makeText(this, "image, " + data.toString(), Toast.LENGTH_SHORT).show();
            } else if ("text/plain".equals(type)) {
                Toast.makeText(this, "text/plain, " + data.toString(), Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(PICK_CONTACT_REQUEST == requestCode) {
            if(RESULT_OK == resultCode) {
                Uri contactUri = data.getData();
                String[] projection = {ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME, ContactsContract.CommonDataKinds.Phone.NUMBER};
                Cursor cursor = getContentResolver().query(contactUri, projection, null, null, null);
                cursor.moveToFirst();

                String name = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
                String number = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));

                Toast.makeText(this, name + ", " + number, Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.phoneCall :
                Uri number = Uri.parse("tel:13632915937");
                Intent call = new Intent(Intent.ACTION_DIAL, number);

                if(hasActivity2startByIntent(call)) {
                    startActivity(call);
                }
                break;
            case R.id.surfInternet :
                Uri url = Uri.parse("http://www.baidu.com/");
                Intent internet = new Intent(Intent.ACTION_VIEW, url);

                if(hasActivity2startByIntent(internet)) {
                    startActivity(internet);
                }
                break;
            case R.id.sendEmail :
                Intent email = new Intent(Intent.ACTION_SEND);
                email.setType(HTTP.PLAIN_TEXT_TYPE);
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{"zxfhacker@gmail.com"});
                email.putExtra(Intent.EXTRA_SUBJECT, "Email Subject");
                email.putExtra(Intent.EXTRA_TEXT, "Email message text");

                if(hasActivity2startByIntent(email)) {
                    startActivity(email);
                }
                break;
            case R.id.share :
                Intent share = new Intent(Intent.ACTION_SEND);

                Intent chooser = Intent.createChooser(share, "Share");
                chooser.setType("text/plain");
                Uri uri = Uri.parse("android.intent.action.SEND.TEST_DATA");
                chooser.setData(uri);

                if(hasActivity2startByIntent(share)) {
                    startActivity(chooser);
                } else {
                    Toast.makeText(this, "No activity to started by the intent", Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.pickContact :
                Intent contact = new Intent(Intent.ACTION_PICK, Uri.parse("content://contacts"));
                contact.setType(ContactsContract.CommonDataKinds.Phone.CONTENT_TYPE);

                if(hasActivity2startByIntent(contact)) {
                    startActivityForResult(contact, PICK_CONTACT_REQUEST);
                }
                break;
        }
    }



    private boolean hasActivity2startByIntent(Intent intent) {
        PackageManager packageManager = getPackageManager();
        List activities = packageManager.queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY);
        return 0 < activities.size();
    }

    private final static int PICK_CONTACT_REQUEST = 0x001;
}
