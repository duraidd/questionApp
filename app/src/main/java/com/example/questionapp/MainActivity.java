package com.example.questionapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    String JSON_DATA = "{\"setOne\":[{\"question\":\"1. What is Software?\",\"answer\":\"Software is nothing but a collection of computer programs that are related documents that are indented to provide desired features, functionalities and better performance.\"},{\"question\":\"2. What is OS?\",\"answer\":\"Software is nothing but a collection of computer programs that are related documents that are indented to provide desired features, functionalities and better performance.\"},{\"question\":\"3. What is JAVA?\",\"answer\":\"Software is nothing but a collection of computer programs that are related documents that are indented to provide desired features, functionalities and better performance.\"},{\"question\":\"4. What is Android?\",\"answer\":\"Software is nothing but a collection of computer programs that are related documents that are indented to provide desired features, functionalities and better performance.\"},{\"question\":\"1. What is Software?\",\"answer\":\"Software is nothing but a collection of computer programs that are related documents that are indented to provide desired features, functionalities and better performance.\"},{\"question\":\"2. What is OS?\",\"answer\":\"Software is nothing but a collection of computer programs that are related documents that are indented to provide desired features, functionalities and better performance.\"},{\"question\":\"3. What is JAVA?\",\"answer\":\"Software is nothing but a collection of computer programs that are related documents that are indented to provide desired features, functionalities and better performance.\"},{\"question\":\"4. What is Android?\",\"answer\":\"Software is nothing but a collection of computer programs that are related documents that are indented to provide desired features, functionalities and better performance.\"},{\"question\":\"1. What is Software?\",\"answer\":\"Software is nothing but a collection of computer programs that are related documents that are indented to provide desired features, functionalities and better performance.\"},{\"question\":\"2. What is OS?\",\"answer\":\"Software is nothing but a collection of computer programs that are related documents that are indented to provide desired features, functionalities and better performance.\"},{\"question\":\"3. What is JAVA?\",\"answer\":\"Software is nothing but a collection of computer programs that are related documents that are indented to provide desired features, functionalities and better performance.\"},{\"question\":\"4. What is Android?\",\"answer\":\"Software is nothing but a collection of computer programs that are related documents that are indented to provide desired features, functionalities and better performance.\"},{\"question\":\"1. What is Software?\",\"answer\":\"Software is nothing but a collection of computer programs that are related documents that are indented to provide desired features, functionalities and better performance.\"},{\"question\":\"2. What is OS?\",\"answer\":\"Software is nothing but a collection of computer programs that are related documents that are indented to provide desired features, functionalities and better performance.\"},{\"question\":\"3. What is JAVA?\",\"answer\":\"Software is nothing but a collection of computer programs that are related documents that are indented to provide desired features, functionalities and better performance.\"},{\"question\":\"4. What is Android?\",\"answer\":\"Software is nothing but a collection of computer programs that are related documents that are indented to provide desired features, functionalities and better performance.\"},{\"question\":\"1. What is Software?\",\"answer\":\"Software is nothing but a collection of computer programs that are related documents that are indented to provide desired features, functionalities and better performance.\"},{\"question\":\"2. What is OS?\",\"answer\":\"Software is nothing but a collection of computer programs that are related documents that are indented to provide desired features, functionalities and better performance.\"},{\"question\":\"3. What is JAVA?\",\"answer\":\"Software is nothing but a collection of computer programs that are related documents that are indented to provide desired features, functionalities and better performance.\"},{\"question\":\"4. What is Android?\",\"answer\":\"Software is nothing but a collection of computer programs that are related documents that are indented to provide desired features, functionalities and better performance.\"},{\"question\":\"1. What is Software?\",\"answer\":\"Software is nothing but a collection of computer programs that are related documents that are indented to provide desired features, functionalities and better performance.\"},{\"question\":\"2. What is OS?\",\"answer\":\"Software is nothing but a collection of computer programs that are related documents that are indented to provide desired features, functionalities and better performance.\"},{\"question\":\"3. What is JAVA?\",\"answer\":\"Software is nothing but a collection of computer programs that are related documents that are indented to provide desired features, functionalities and better performance.\"},{\"question\":\"4. What is Android?\",\"answer\":\"Software is nothing but a collection of computer programs that are related documents that are indented to provide desired features, functionalities and better performance.\"},{\"question\":\"1. What is Software?\",\"answer\":\"Software is nothing but a collection of computer programs that are related documents that are indented to provide desired features, functionalities and better performance.\"},{\"question\":\"2. What is OS?\",\"answer\":\"Software is nothing but a collection of computer programs that are related documents that are indented to provide desired features, functionalities and better performance.\"},{\"question\":\"3. What is JAVA?\",\"answer\":\"Software is nothing but a collection of computer programs that are related documents that are indented to provide desired features, functionalities and better performance.\"},{\"question\":\"4. What is Android?\",\"answer\":\"Software is nothing but a collection of computer programs that are related documents that are indented to provide desired features, functionalities and better performance.\"},{\"question\":\"1. What is Software?\",\"answer\":\"Software is nothing but a collection of computer programs that are related documents that are indented to provide desired features, functionalities and better performance.\"},{\"question\":\"2. What is OS?\",\"answer\":\"Software is nothing but a collection of computer programs that are related documents that are indented to provide desired features, functionalities and better performance.\"},{\"question\":\"3. What is JAVA?\",\"answer\":\"Software is nothing but a collection of computer programs that are related documents that are indented to provide desired features, functionalities and better performance.\"},{\"question\":\"4. What is Android?\",\"answer\":\"Software is nothing but a collection of computer programs that are related documents that are indented to provide desired features, functionalities and better performance.\"}]}";
    RecyclerView recyclerView;
    List<Model> listView;
    Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerViewId);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        listView = new ArrayList<>();

        try {
            JSONObject rootData = new JSONObject(JSON_DATA);

            JSONArray jsonArray = rootData.optJSONArray("setOne");
            JSONArray jsonArray2 = rootData.optJSONArray("setOne");

            for (int i = 0; i < jsonArray2.length(); i++) {
                JSONObject object = jsonArray2.getJSONObject(i);
                Model model = new Model(
                        object.optString("question"), object.optString("answer")
                );

                listView.add(model);
            }


            adapter = new Adapter(listView, getApplicationContext());
            recyclerView.setAdapter(adapter);


        } catch (JSONException e) {
            e.printStackTrace();
        }

    }


}