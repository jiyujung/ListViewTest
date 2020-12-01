package kr.hs.emirim.s2019w39.listviewtest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
//    String[] items = {"사이렌", "복수해라", "펜트하우스", "나 혼자 산다", "노는언니", "개는 훌륭하다"};
    ArrayList<String> itemList = new ArrayList<String>();
    ArrayAdapter<String> adapter;
    EditText edit1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView list1 = findViewById(R.id.list1);

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, itemList);
        list1.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        list1.setAdapter(adapter);

        edit1 = findViewById(R.id.edit1);
        Button btnAdd = findViewById(R.id.btn_add);

        btnAdd.setOnClickListener(btnListener);

        list1.setOnItemLongClickListener(listListener);

//        list1.setOnItemClickListener(listListener);
    }

    View.OnClickListener btnListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            itemList.add(edit1.getText().toString());
            adapter.notifyDataSetChanged();
        }
    };

    AdapterView.OnItemLongClickListener listListener = new AdapterView.OnItemLongClickListener() {
        @Override
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long l) {
            itemList.remove(position);
            adapter.notifyDataSetChanged();

            return false;   // 기본 행동 취소하려고 false
        }
    };

//    AdapterView.OnItemClickListener listListener = new AdapterView.OnItemClickListener() {
//        @Override
//        public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
//            Toast.makeText(getApplicationContext(), items[position], Toast.LENGTH_SHORT).show();
//        }
//    };
}