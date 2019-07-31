package ir.darkdeveloper.english9th.Activities.BasicActivities;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.navigation.NavigationView;
import com.gun0912.tedpermission.PermissionListener;
import com.gun0912.tedpermission.TedPermission;

import net.sqlcipher.database.SQLiteDatabase;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import co.ronash.pushe.Pushe;
import ir.adad.androidsdk.Adad;
import ir.darkdeveloper.english9th.Activities.BasicActivities.CrashHandler.CrashHandler;
import ir.darkdeveloper.english9th.Activities.BasicActivities.CrashHandler.CrashHandling;
import ir.darkdeveloper.english9th.Activities.Lessons.Tests.TestMain;
import ir.darkdeveloper.english9th.Adapters.RecyclerAdapters.AdapterRecyclerMain;
import ir.darkdeveloper.english9th.Contacts.ContactRecyclerMain;
import ir.darkdeveloper.english9th.Data.DataRecyclerMain;
import ir.databeen.sdk.Databeen;
import ir.myteam.adsdk.AdCommon;
import ir.plant.english9th.R;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private RecyclerView recyclerView;
    private List<ContactRecyclerMain> contactRecyclerMainList = new ArrayList<>();
    private LinearLayoutManager linearLayoutManager;
    public static SQLiteDatabase database;
    public static final String desPath = Environment.getExternalStorageDirectory()
            + "/Android/data/ir.plant.english9th/";
    private NavigationView navigationView;
    private SharedPreferences ps, rp;
    private int cs, ad;
    public static final String VERSION_NAME = "5.98324";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try {
            AdadInit();
            Pushe.initialize(this, true);
            setContentView(R.layout.activity_main);
            intro();
            ini();
            recyclerInit();

        } catch (NullPointerException ne) {

            Bundle bundle = new Bundle();
            bundle.putBoolean("sqlException", true);
            ne.printStackTrace();
            new CrashHandler().catchException(ne, this);
            Intent nextActivity = new Intent(this, CrashHandling.class);
            nextActivity.putExtras(bundle);
            startActivity(nextActivity);
            finish();

        } catch (Exception e) {
            e.printStackTrace();
            new CrashHandler().catchException(e, this);
            startActivity(new Intent(MainActivity.this, CrashHandling.class));
            finish();
        }
    }


    private void intro() {
        ps = getSharedPreferences("permission", Context.MODE_PRIVATE);
        SharedPreferences ads = getSharedPreferences("ads?", Context.MODE_PRIVATE);
        ad = ads.getInt("ads??", 0);

        grantPermission();

        if (isFirstTime()) {
            File file1 = new File(Environment.getExternalStorageDirectory() + "/.P/");
            if (file1.exists()) {
                deleteDirectory(file1);
            }
            InitializeSQLCipher();
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("تغییرات نسخه جدید: " + VERSION_NAME)
                    .setMessage("- اضافه شدن ترجمه برای  language melody\n" +
                            "\n" +
                            "- اضافه شدن ترجمه برای find it\n" +
                            "\n" +
                            "- اضافه شدن قابلیت ترجمه آنی برای find it  و language melody\n" +
                            "\n" +
                            "- ساخته شدن کانال تلگرام و پشتیبانی\n" +
                            "\n" +
                            "- حل مشکلات گزارش شده و مقاوم شدن در برابر بسته شدن ناگهانی")
                    .setPositiveButton("کانال سروش", (dialogInterface, i) -> {
                        Intent intent = new Intent(Intent.ACTION_VIEW);
                        intent.setData(Uri.parse("http://sapp.ir/plantdg"));
                        startActivity(intent);
                    })
                    .setNegativeButton("کانال تلگرام", ((dialog, which) -> {
                        Intent intent = new Intent(Intent.ACTION_VIEW);
                        intent.setData(Uri.parse("https://t.me/plantdg_ch"));
                        startActivity(intent);
                    })).show();
        }
    }

    @SuppressLint("InlinedApi")
    private void grantPermission() {

        SharedPreferences.Editor editor = ps.edit();
        PermissionListener permissionlistener = new PermissionListener() {
            @Override
            public void onPermissionGranted() {
                InitializeSQLCipher();
                Databeen.init(MainActivity.this,
                        "945185f355954f7fb6909b9742fd42cd", "Bazaar");
                editor.putBoolean("granted?", true);
                editor.apply();
            }

            @Override
            public void onPermissionDenied(ArrayList<String> deniedPermissions) {
                Toast.makeText(MainActivity.this,
                        "دسترسی های داده نشده به نرم افزار:\n" +
                                deniedPermissions.toString(), Toast.LENGTH_SHORT).show();
                finish();
            }


        };

        new TedPermission(this)
                .setPermissionListener(permissionlistener)
                .setDeniedMessage("اگر دسترسی به برنامه ندهید نرم افزار کار نخواهد کرد." +
                        getEmoji(0x1f628) + " چون نرم افزار اطلاعات کتاب را از یک فایل " +
                        "از پیش ساخته شده در حافظه شما می خواند. " +
                        "\n لطفا از قسمت تنظیمات" +
                        " در قسمت نرم افزار ها به نرم افزار دسترسی بدهید " +
                        "یا نرم افزار را دوباره اجرا کنید تا دسترسی ها را دوباره ببینید.")
                .setPermissions(Manifest.permission.WRITE_EXTERNAL_STORAGE,
                        Manifest.permission.READ_EXTERNAL_STORAGE,
                        Manifest.permission.READ_PHONE_STATE)
                .check();


        if (ps.getBoolean("granted?", false)) {
            if (ad == 0) {
                AdCommon.init(MainActivity.this, "WBCjnQuCGQ", false, true);
            } else if (ad == 1) {
                AdCommon.init(MainActivity.this, "WBCjnQuCGQ", false, false);
            }
        }

    }

    public static void deleteDirectory(File path) {
        // TODO Auto-generated method stub
        if (path != null && path.exists()) {
            /*final File to = new File(path.getAbsolutePath() + System.currentTimeMillis());
            path.renameTo(to);
            path.delete();*/

            File[] files = path.listFiles();
            for (File file1 : files) {
                if (file1.isDirectory()) {
                    deleteDirectory(file1);
                } else {
                    file1.delete();
                }
            }
        }
    }

    private void InitializeSQLCipher() {
        SQLiteDatabase.loadLibs(this);
        try {
            File file = new File(desPath);
            if (file.exists()) {
                deleteDirectory(file);
            }
            file.mkdirs();
            file.createNewFile();
            copyDB(getBaseContext().getAssets().open("data"), new FileOutputStream(desPath + "data"));

        } catch (FileNotFoundException f) {
            f.printStackTrace();
        } catch (IOException io) {
            io.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    private void AdadInit() {
        ConnectivityManager manager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = manager.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {
            Adad.initialize(getApplicationContext(), "a93e05398be349128a04409ceb282260");
            Adad.prepareFullscreenBannerAd(getApplicationContext()
                    , "60BA5D43-F0CD-41F8-925B-EFAE8CB01F00");
            if (Adad.isFullscreenBannerAdReady()) {
                Adad.showFullscreenBannerAd(MainActivity.this);
            }
        }

    }


    private boolean isFirstTime() {
        SharedPreferences preferences = getPreferences(MODE_PRIVATE);
        boolean ranBefore = preferences.getBoolean("RanBefore", false);
        if (!ranBefore) {
            // first time
            SharedPreferences.Editor editor = preferences.edit();
            editor.putBoolean("RanBefore", true);
            editor.apply();
        }
        return !ranBefore;
    }

    private void ini() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        androidx.appcompat.app.ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayShowTitleEnabled(false);
        }
        rp = getSharedPreferences("review", Context.MODE_PRIVATE);
        recyclerView = findViewById(R.id.recyclerView1);
        linearLayoutManager = new LinearLayoutManager(MainActivity.this);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        SharedPreferences color1 = getSharedPreferences("color?", Context.MODE_PRIVATE);
        cs = color1.getInt("color??", 4);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            if (rp.getBoolean("reviewed", true)) {

                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("نظر به برنامه")
                        .setMessage("اگر از برنامه خوشتان آمد به آن امتیاز دهید")
                        .setPositiveButton("5 ستاره میدم", (v, h) -> {
                            Intent intent = new Intent(Intent.ACTION_EDIT);
                            intent.setData(Uri.parse("bazaar://details?id=" + "ir.plant.english9th"));
                            intent.setPackage("com.farsitel.bazaar");
                            startActivity(intent);
                            SharedPreferences.Editor edt = rp.edit();
                            edt.putBoolean("reviewed", false);
                            edt.apply();
                        })
                        .setNegativeButton("فعلا نه", (v, h) -> {
                            super.onBackPressed();
                            finish();
                        }).show();
            } else {
                super.onBackPressed();
                finish();
            }


        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_test) {
            startActivity(new Intent(this, TestMain.class));
            finish();

        } else if (id == R.id.nav_settings) {
            startActivity(new Intent(this, Setting_Activity.class));
            finish();

        } else if (id == R.id.nav_download) {
            if (ps.getBoolean("granted?", false)) {
                startActivity(new Intent(this, DownloadCenter.class));
                finish();
            } else {
                Toast.makeText(this, "دسترسی را به نرم افزار بدهید",
                        Toast.LENGTH_SHORT).show();
            }
        } else if (id == R.id.nav_about) {
            startActivity(new Intent(this, Info.class));

        } else if (id == R.id.nav_share) {
            Intent i = new Intent(Intent.ACTION_SEND);
            i.setType("text/plain");
            i.putExtra(Intent.EXTRA_SUBJECT, "Prospect 3");
            String sAux = "\nنرم افزار اندرویدی انگلیسی نهم را نصب کن تا از امکانات رایگان آن مثل گرامر و ترجمه و تست بهره مند شی.\n\n";
            sAux = sAux + "https://cafebazaar.ir/app/ir.plant.english9th/?l=fa \n\n";
            i.putExtra(Intent.EXTRA_TEXT, sAux);
            startActivity(Intent.createChooser(i, "ارسال لینک از طریق ..."));

        } else if (id == R.id.nav_review) {
            Intent intent = new Intent(Intent.ACTION_EDIT);
            intent.setData(Uri.parse("bazaar://details?id=" + "ir.plant.english9th"));
            intent.setPackage("com.farsitel.bazaar");
            startActivity(intent);

        } else if (id == R.id.nav_apps) {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("bazaar://collection?slug=by_author&aid=" + "154816235404"));
            intent.setPackage("com.farsitel.bazaar");
            startActivity(intent);
        } else if (id == R.id.channel_nav) {
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("کانال")
                    .setMessage("عضو کانال سروش یا تلگرام ما بشید و از اخبار اطلاع بیابید")
                    .setPositiveButton("سروش", (v, h) -> {
                        Intent intent = new Intent(Intent.ACTION_VIEW);
                        intent.setData(Uri.parse("http://sapp.ir/plantdg"));
                        startActivity(intent);
                    })
                    .setNegativeButton("تلگرام", (v, h) -> {
                        Intent intent = new Intent(Intent.ACTION_VIEW);
                        intent.setData(Uri.parse("https://t.me/plantdg_ch"));
                        startActivity(intent);
                    }).show();
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    private void copyDB(InputStream inputStream, OutputStream outputStream) throws IOException {

        byte[] buffer = new byte[1024];
        int length;
        while ((length = inputStream.read(buffer)) > 0) {
            outputStream.write(buffer, 0, length);
        }
        inputStream.close();
        outputStream.close();
    }


    public String getEmoji(int unicode) {
        return new String((Character.toChars(unicode)));
    }


    private void recyclerInit() {
        for (int i = 0; i < 6; i++) {
            ContactRecyclerMain contactRecyclerMain = new ContactRecyclerMain();
            DataRecyclerMain dataRecyclerMain = new DataRecyclerMain();
            contactRecyclerMain.text_main = dataRecyclerMain.main_text[i];
            contactRecyclerMain.image_main = dataRecyclerMain.main_image[i];
            contactRecyclerMain.text_main2 = dataRecyclerMain.main_text2[i];
            contactRecyclerMainList.add(contactRecyclerMain);

        }
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(new AdapterRecyclerMain(getBaseContext(),
                contactRecyclerMainList));

        if (cs == 5) {
            navigationView.setBackgroundColor(getResources().getColor(R.color.nav_color));
        } else {
            navigationView.setBackgroundColor(getResources().getColor(R.color.light_card));
        }
    }


    @Override
    protected void onStart() {
        super.onStart();
        Databeen.setAppStart();
        /*ActivityManager am = (ActivityManager) getSystemService(ACTIVITY_SERVICE);
        List<ActivityManager.RunningTaskInfo> tasks = am.getRunningTasks(1);
        ActivityManager.RunningTaskInfo task = tasks.get(0); // current task
        ComponentName rootActivity = task.baseActivity;


        String currentPackageName = rootActivity.getPackageName();
        if (currentPackageName.equals("ir.plant.english9th")) {
            Toast.makeText(this, "onStart", Toast.LENGTH_SHORT).show();
            AdCommon.init(this, "WBCjnQuCGQ", false, true);
        }*/
    }

}