/**
 * @author Vinay Hiremath
 * vhiremath4@gmail.com
 * Main menu Activity for the AndroidTrix Android showcase app.
 * Acts as a multiple-Activity launcher via a ListView menu.
 */

package com.androidtrix.androidtrix;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class Main extends Activity {
	
	//variables that make up the main menu
	ListView mainMenu;
	ArrayAdapter<String> menuAdapter;//adapter that will bind the data to the ListView
	ArrayList<String> menuItems = new ArrayList<String>();
	
	private void makeToast(String toast) {
		Toast.makeText(getApplicationContext(), toast, Toast.LENGTH_SHORT).show();
	}
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        //initialize some variables that will be of importance to the main menu
        mainMenu = (ListView) findViewById(R.id.mainmenu);
        //bind the menuItems ArrayList to the adapter
        mainMenu.setAdapter(menuAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, menuItems));//bind the adapter to the ListView
        String[] menuEntries = new String[]{
        	"TextView Index onClick",
        	"Natural TextView Wrapping of Other Views",
        	"Painless JSON Parsing"
        };//items that will populate the menu
        
        //populate the ListView
        for (String entry : menuEntries)
        	menuItems.add(entry);
        	
        menuAdapter.notifyDataSetChanged();//notify the adapter of data change - not necessary but precautionary
        
        //fire up separate Activites that show and demo code on menu item click
        mainMenu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view, int index,
					long id) {
				//get the selected menu item
				final String selectedMenuItem = menuItems.get(index);
				
				//check to see which item has been selected and then fire up the necessary Activity
				if (selectedMenuItem.equals("TextView Index onClick")){
					Intent intent = new Intent(Main.this, TextViewIndexOnClick.class);
					startActivity(intent);
				} else if (selectedMenuItem.equals("Natural TextView Wrapping of Other Views")){
					makeToast("got item 2");
				} else if (selectedMenuItem.equals("Painless JSON Parsing")){
					makeToast("got item 3");
				}
			}
		});
    }
}