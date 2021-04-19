package ir.darkdeveloper.english9th.Activities.BasicActivities.CrashHandler;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Environment;

import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;

// This class logs crashes into a file.
public class CrashHandler {


	//private static String CRASH_TAG = CRASH_DIR + ".crashed";

	private static String ANDROID = Build.VERSION.RELEASE;
	private static String MODEL = Build.MODEL;
	private static String MANUFACTURER = Build.MANUFACTURER;

	private static String VERSION = "Unknown";

	public void catchException(Throwable throwable, Context context){

		String CRASH_DIR = context.getExternalFilesDir(null)
				+ File.separator  + "logs" + File.separator;
		String CRASH_LOG = CRASH_DIR + "last_crash.log";

		File f = new File(CRASH_LOG);

		if (f.exists()) {
			f.delete();
		} else {
			try {
				new File(CRASH_DIR).mkdirs();
				f.createNewFile();
			} catch (Exception e) {
				return;
			}
		}

		PrintWriter p;
		try {
			p = new PrintWriter(f);
		} catch (Exception e) {
			return;
		}

		try {
			PackageInfo pInfo = context.getPackageManager().getPackageInfo(
					context.getPackageName(), 0);
			 VERSION = pInfo.versionName;
		} catch (PackageManager.NameNotFoundException e) {
			e.printStackTrace();
		}

		p.write("Android Version: " + ANDROID + "\n");
		p.write("Device Model: " + MODEL + "\n");
		p.write("Device Manufacturer: " + MANUFACTURER + "\n");
		p.write("App Version: " + VERSION + "\n");
		p.write("*********************\n");
		p.write(getStackTrace(throwable));
		p.close();

	}

	private static String getStackTrace(final Throwable throwable) {
		final StringWriter sw = new StringWriter();
		final PrintWriter pw = new PrintWriter(sw, true);
		throwable.printStackTrace(pw);
		return sw.getBuffer().toString();
	}
}

