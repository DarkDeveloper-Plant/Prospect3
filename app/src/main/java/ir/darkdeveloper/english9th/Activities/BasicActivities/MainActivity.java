package ir.darkdeveloper.english9th.Activities.BasicActivities;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
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

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import co.ronash.pushe.Pushe;
import ir.darkdeveloper.english9th.Activities.AdBase;
import ir.darkdeveloper.english9th.Activities.BasicActivities.CrashHandler.CrashHandler;
import ir.darkdeveloper.english9th.Activities.BasicActivities.CrashHandler.CrashHandling;
import ir.darkdeveloper.english9th.Activities.Lessons.Tests.TestMain;
import ir.darkdeveloper.english9th.Adapters.RecyclerAdapters.AdapterRecyclerMain;
import ir.darkdeveloper.english9th.Contacts.ContactRecyclerMain;
import ir.darkdeveloper.english9th.Data.DataRecyclerMain;
import ir.plant.english9th.R;
import ir.tapsell.sdk.Tapsell;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private RecyclerView recyclerView;
    private final List<ContactRecyclerMain> contactRecyclerMainList = new ArrayList<>();
    private LinearLayoutManager linearLayoutManager;
    public static SQLiteDatabase database;
    private NavigationView navigationView;
    private SharedPreferences ps;
    private int cs;

    public final static String VERSION_NAME = "7.000208";

    private AdBase adBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            try {
                Tapsell.initialize(getApplicationContext()
                        , "abgaphnhtkbefdfgepcogsljmsiaoehhapnrcncelkeeksolshcbdjtfotrinecabopcfo");

                Pushe.initialize(this, true);
            } catch (Exception e) {
                e.printStackTrace();
            }
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

        // To grant and to handle dangerous permissions
        grantPermission();

        // if the first time that app run
        if (isFirstTime()) {
            //You can use to show the user what was the latest changes

        /*    new AlertDialog.Builder(MainActivity.this)
                    .setTitle("تغییرات نسخه جدید: " + VERSION_NAME)
                    .setMessage(getEmoji(0x2705) + " حل مشکل ظاهری بخش های conversation و find it.\n" +
                            getEmoji(0x2705) + " برداشته شدن تبلیغات")
                    .setPositiveButton("کانال سروش", (dialogInterface, i) -> {
                        Intent intent = new Intent(Intent.ACTION_VIEW);
                        intent.setData(Uri.parse("http://sapp.ir/plantdg"));
                        startActivity(intent);
                    })
                    .setNegativeButton("کانال تلگرام", ((dialog, which) -> {
                        Intent intent = new Intent(Intent.ACTION_VIEW);
                        intent.setData(Uri.parse("https://t.me/plantdg_ch"));
                        startActivity(intent);
                    })).show();*/
        }
    }

    @SuppressLint("InlinedApi")
    private void grantPermission() {

        SharedPreferences.Editor editor = ps.edit();
        PermissionListener permissionlistener = new PermissionListener() {
            @Override
            public void onPermissionGranted() {
                InitializeSQLCipher();
                //using this pref to be sure that permissions are granted later
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
                        Manifest.permission.READ_EXTERNAL_STORAGE)
                .check();


    }

    public static void deleteDirectory(File path) {
        // TODO Auto-generated method stub
        if (path != null && path.exists()) {
            /*final File to = new File(path.getAbsolutePath() + System.currentTimeMillis());
            path.renameTo(to);
            path.delete();*/

            File[] files = path.listFiles();
            if (files != null) {
                for (File file1 : files) {
                    if (file1.isDirectory()) {
                        deleteDirectory(file1);
                    } else {
                        file1.delete();
                    }
                }
            }
        }
    }

    private void InitializeSQLCipher() {
        try {
            String desPath = getExternalFilesDir(null)
                    + File.separator + "data" + File.separator;

            File file = new File(desPath);
            // this part is used to delete and replace the new db
            // to update the data and columns(some kind of DROP in SQL)
            if (file.exists()) {
                deleteDirectory(file);
            }

            //on Android 10+ you should add requestLegacyExternalStorage:true in application tag
            // in manifest because of android 10+ scope storage if you don't the mkdirs won't work
            file.mkdirs();
            file.createNewFile();
            // Copying database from assets folder to custom path.
            // Be sure that the path you defined here is
            // where you should use to access database
            copyDB(getBaseContext().getAssets().open("data"), new FileOutputStream(desPath + "data"));

        } catch (FileNotFoundException f) {
            f.printStackTrace();
        } catch (IOException io) {
            io.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

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
            adBase = new AdBase(MainActivity.this);
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("نظر به برنامه")
                    .setMessage("اگر از برنامه خوشتان آمد به آن امتیاز دهید یا ویدیو زیر را تا اخر ببینید و از ما حمایت کنید(کمتر از یک دقیقه)")
                    .setPositiveButton("دیدن ویدیو", (v, h) -> adBase.showAd())
                    .setNegativeButton("نظر دادن", (v, h) -> {
                        Intent intent = new Intent(Intent.ACTION_EDIT);
                        intent.setData(Uri.parse("bazaar://details?id=" + "ir.plant.english9th"));
                        intent.setPackage("com.farsitel.bazaar");
                        startActivity(intent);
                    })
                    .setNeutralButton("فعلا نه", (v, h) -> {
                        super.onBackPressed();
                        finish();
                    })
                    .show();

        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_test) {
            startActivity(new Intent(this, TestMain.class));
            finish();

        } else if (id == R.id.nav_settings) {
            startActivity(new Intent(this, Setting_Activity.class));
            finish();

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
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("https://t.me/plantdg"));
            startActivity(intent);
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    // You can add emoji to text using this, every emoji has a specific unicode
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


}
