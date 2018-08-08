package inducesmile.com.androidstaggeredgridlayoutmanager;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.Menu;
import android.view.MenuItem;

import com.androidnetworking.AndroidNetworking;
import com.jacksonandroidnetworking.JacksonParserFactory;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class MainActivity extends FragmentActivity {

    private StaggeredGridLayoutManager gaggeredGridLayoutManager;
    public static List<ItemObjects> gaggeredList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_with_tabs);
        //==========================================================================================
        //android networking libraries initialization

        AndroidNetworking.initialize(getApplicationContext());

        //use jackson parser instead of gson (by default = gson)
        AndroidNetworking.setParserFactory(new JacksonParserFactory());

        //==========================================================================================

        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        //recyclerView.setItemAnimator(null);

        gaggeredList = getListItemData();

        int numberOfColumns = 3;
        recyclerView.setLayoutManager(new GridLayoutManager(this, numberOfColumns));

        SolventRecyclerViewAdapter rcAdapter = new SolventRecyclerViewAdapter(MainActivity.this, gaggeredList);
        recyclerView.setAdapter(rcAdapter);


        //==========================================================================================
        //test


        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentDateandTime = sdf.format(new Date());
        System.out.println("dateTime lol: "+currentDateandTime);

        String username = "tangkas01";
        String password = "qwe123";
        String reqDateTime = currentDateandTime;
        String appSignature = "123456";

        String securityToken = convertPassMd5(username + password + reqDateTime +appSignature);
        System.out.println("MD5 lol: "+securityToken);
    }

    private static String convertPassMd5(String pass) {
        String password = null;
        MessageDigest mdEnc;
        try {
            mdEnc = MessageDigest.getInstance("MD5");
            mdEnc.update(pass.getBytes(), 0, pass.length());
            pass = new BigInteger(1, mdEnc.digest()).toString(16);
            while (pass.length() < 32) {
                pass = "0" + pass;
            }
            password = pass;
        } catch (NoSuchAlgorithmException e1) {
            e1.printStackTrace();
        }
        return password;
    }

    private List<ItemObjects> getListItemData(){
        List<ItemObjects> listViewItems = new ArrayList<ItemObjects>();

        listViewItems.add(new ItemObjects("Gourmet Salted Egg Yolk Potato Crisp x 3 x 125g", "https://i.imgur.com/EofKWTAh.jpg", "RM 118.00"));
        listViewItems.add(new ItemObjects("Gourmet Salted Egg Yolk Fish Skin x 3 x 125g", "https://i.imgur.com/LLdgs2Yh.jpg", "RM 118.00"));

        listViewItems.add(new ItemObjects("Cornish Smoked Sea Salt Flake - 125g", "https://i.imgur.com/tPYBGUAh.jpg", "RM 118.00"));
        listViewItems.add(new ItemObjects("Cornish Original Sea Salt Crystals - 225g", "https://i.imgur.com/VmhJpKHh.jpg", "RM 118.00"));

        listViewItems.add(new ItemObjects("Cornish Garlic Sea Salt - 55g", "https://i.imgur.com/isCLG73h.jpg", "RM 118.00"));
        listViewItems.add(new ItemObjects("Cornish Sea Salt Flakes - 150g", "https://i.imgur.com/YdkLK0Qh.jpg", "RM 118.00"));

        listViewItems.add(new ItemObjects("Cornish Smoked Sea Salt Flake - 50g", "https://i.imgur.com/qRBu7OYh.jpg", "RM 118.00"));
        listViewItems.add(new ItemObjects("Cornish Fiery Sea Pepper - 40g", "https://i.imgur.com/iLmk4Aah.jpg", "RM 118.00"));

        listViewItems.add(new ItemObjects("Cornish Sea Salt & Luxury Pepper - 60g", "https://i.imgur.com/MGoMMxFh.jpg", "RM 118.00"));
        listViewItems.add(new ItemObjects("Cornish Chilli Sea Salt - 50g", "https://i.imgur.com/hNjEWZ2h.jpg", "RM 118.00"));

        listViewItems.add(new ItemObjects("Cornish Lemon & Thyme Sea Salt - 55g", "https://i.imgur.com/NSePjmoh.jpg", "RM 118.00"));
        listViewItems.add(new ItemObjects("Cornish Original Sea Pepper - 40g", "https://i.imgur.com/W191LcNh.jpg", "RM 118.00"));
        //===

        listViewItems.add(new ItemObjects("Salty Essentials Combi Set - 185g", "https://i.imgur.com/iUB3lmrh.jpg", "RM 118.00"));
        listViewItems.add(new ItemObjects("Punchy Seasoning Combi Set - 160g", "https://i.imgur.com/aSgfzImh.jpg", "RM 118.00"));

        listViewItems.add(new ItemObjects("Seaweed Seasoning Set - 118g", "https://i.imgur.com/JQmcbpbh.jpg", "RM 118.00"));
        listViewItems.add(new ItemObjects("Great British Co. Potato Crisps - Tikka Masala (150g x 10)", "https://i.imgur.com/cbQrGqlh.jpg", "RM 118.00"));

        listViewItems.add(new ItemObjects("Great British Co. Potato Crisps - Fish & Chips (150g x 10)", "https://i.imgur.com/6utW4sPh.jpg", "RM 118.00"));
        listViewItems.add(new ItemObjects("Great British Co. Potato Crisps - Cheddar Cheese & Chive (150g x 10)", "https://i.imgur.com/Bc3HlsQh.jpg", "RM 118.00"));

        listViewItems.add(new ItemObjects("Great British Co. Potato Crisps - English Breakfast (150g x 10)", "https://i.imgur.com/3mppKPvh.jpg", "RM 75.00"));
        listViewItems.add(new ItemObjects("Great British Co. Potato Crisps - Salt & Vinegar (150g x 10)", "https://i.imgur.com/maRawyeh.jpg", "RM 50.00"));



        return listViewItems;
    }
}
/*

        //orientation 0 = scroll horizontally, 1 = scroll vertically
        //if 0, objects added top-down, if 1, objects added left-right
        gaggeredGridLayoutManager = new StaggeredGridLayoutManager(2, 1);
        recyclerView.setLayoutManager(gaggeredGridLayoutManager);

        //==========================================================================================
        for(int i = 0; i < 10; i++){

            listViewItems.add(new ItemObjects("Gourmet Salted Egg Yolk Potato Crisp x 3 x 125g", R.drawable.item_001, "RM 118.00"));

        }
*/