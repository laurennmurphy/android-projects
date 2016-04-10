package com.laurennor.todo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> myItems;
    private ArrayAdapter<String> myItemsAdapter;
    private TextView mTextView;
    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        readItems(); // Call readItems method

        mListView = (ListView) findViewById(R.id.mListView);
        myItems = new ArrayList<>();
        myItemsAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,myItems);

        // Set Adapter for ListView
        mListView.setAdapter(myItemsAdapter);

        // Add a few example items to the list
        myItems.add("Feed the cat");
        myItems.add("Do the laundry");
        myItems.add("Read a book");

        // Add remove listener method
        setListViewListener();
    }

    // Create a remove method
    // Use a long click listener to remove item from list
    private void setListViewListener() {
        mListView.setOnItemLongClickListener(
                new AdapterView.OnItemLongClickListener() {
                    @Override
                    //Place the adapter, item, position and id as parameters
                    public boolean onItemLongClick(AdapterView<?> adapter, View item, int position, long id) {
                        // Remove the item from the array by position
                        myItems.remove(position);

                        // Refresh the adapter after item is removed
                        myItemsAdapter.notifyDataSetChanged();

                        //Call the writeItems method
                        writeItems();

                        // Return true once click event is done
                        return true;
                    }
                }
        );
    }


    private void readItems(){
        File filesDir = getFilesDir();
        File todoFile = new File(filesDir, "todo-list.txt");
        try{
            myItems = new ArrayList<>(FileUtils.readLines(todoFile));
        }catch (IOException e){
            myItems = new ArrayList<>();
        }
    }

    private void writeItems() {
        File filesDir = getFilesDir();
        File todoFile = new File(filesDir, "todo-list.txt");
        try {
            FileUtils.writeLines(todoFile, myItems);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void addItems(View view) {
        EditText addNewItem = (EditText) findViewById(R.id.newItem);
        String itemText = null;
        if (addNewItem != null) {
            itemText = addNewItem.getText().toString();
        }
        myItemsAdapter.add(itemText);
        assert addNewItem != null;
        addNewItem.setText("");
        writeItems(); // Call writeItems method
    }

    public void deleteAllItems(View view) {
        // Clears all the items in the array
        myItems.clear();
        // Notifies the adapter of the change
        myItemsAdapter.notifyDataSetChanged();
    }

}
