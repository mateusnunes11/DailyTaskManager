package dailytaskmanager;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;



import java.util.ArrayList;

public class CategoryActivity extends AppCompatActivity {

    private ListView categoryListView;
    private Button btnAddCategory, btnFilterCategory;
    private ImageButton btnEditCategory, btnDeleteCategory;

    private ArrayList<String> categories;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.category_activity);

        categoryListView = findViewById(R.id.categoryListView);
        btnAddCategory = findViewById(R.id.btnAddCategory);
        btnFilterCategory = findViewById(R.id.btnFilterCategory);
        btnEditCategory = findViewById(R.id.btnEditCategory);
        btnDeleteCategory = findViewById(R.id.btnDeleteCategory);

        categories = new ArrayList<>();
        categories.add("Pessoal");
        categories.add("Trabalho");

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, categories);
        categoryListView.setAdapter(adapter);

        btnAddCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Adicionar nova categoria
                categories.add("Nova Categoria");
                adapter.notifyDataSetChanged();
            }
        });

        btnDeleteCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Excluir categoria selecionada
                if (!categories.isEmpty()) {
                    categories.remove(0); // Exemplo de exclusão do primeiro item
                    adapter.notifyDataSetChanged();
                }
            }
        });

        btnEditCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Editar categoria selecionada (Lógica a ser implementada)
            }
        });

        btnFilterCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lógica de filtragem (a ser implementada)
            }
        });
    }
}
