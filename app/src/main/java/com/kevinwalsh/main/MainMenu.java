package com.kevinwalsh.main;
      //            import androidx.appcompat.app.AppCompatActivity;
        import android.app.ListActivity;
        import android.content.Intent;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.ArrayAdapter;
        import android.widget.ListView;

public class MainMenu extends ListActivity{

    String classes[]= {"SampleActivity"};
                // classes/ activities available for selection in menu

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setListAdapter(new ArrayAdapter<String>(MainMenu.this, android.R.layout.simple_list_item_1, classes));
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        String selecteditem = classes[position];
        try{
            Class selectedClass= Class.forName("com.kevinwalsh.main."+ selecteditem);
            Intent selectedIntent = new Intent(MainMenu.this, selectedClass);
            startActivity(selectedIntent);
        }
        catch(ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }
}
