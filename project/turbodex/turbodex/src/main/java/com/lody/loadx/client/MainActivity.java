package com.lody.loadx.client;

import java.io.File;

import com.lody.turbodex.TurboDex;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		TurboDex.enableTurboDex();
		TurboDex.disableTurboDex();
		String file = "/data/data/com.wadahana.testhook/b.txt";
		Toast.makeText(this, "b.txt?=" + new File(file).exists(), Toast.LENGTH_SHORT).show();
		// File dbDir = getDatabasePath("test.db").getParentFile();
		// NativeIO.open();
		// try {
		// NativeIO.redirectFolder(dbDir.getAbsolutePath(),
		// new File(getFilesDir().getParentFile(), "test").getAbsolutePath(),
		// true);
		// if (!dbDir.exists()) {
		// dbDir.mkdirs();
		// }
		// String toFile = new
		// File(dbDir.getParentFile(),"test2.db").getAbsolutePath();
		// NativeIO.redirectFile(getDatabasePath("test.db").getAbsolutePath(),
		// toFile);
		// SQLiteDatabase db = SQLiteDatabase.openDatabase(toFile, null,
		// SQLiteDatabase.CREATE_IF_NECESSARY | SQLiteDatabase.OPEN_READWRITE);
		// } catch (Exception e) {
		//
		// }
		// try {
		// Class.forName("com.kk.testlib.MyService");
		// Log.i("kk", "Class.forName");
		// } catch (Exception e) {
		// Log.e("kk", "", e);
		// }
		// try {
		// startService(new Intent().setClassName(this,
		// "com.kk.testlib.MyService"));
		// Log.i("kk", "startService");
		// } catch (Exception e) {
		// Log.e("kk", "", e);
		// }
	}
}
