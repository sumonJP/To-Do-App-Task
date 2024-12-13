package com.example.todoapp;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private EditText titleInput, descriptionInput, dateInput;
    private Spinner typeSpinner;
    private RadioGroup priorityGroup;
    private Button saveButton;
    private ListView todoListView;

    private ArrayAdapter<String> listAdapter;
    private ArrayList<String> todoList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize Views
        titleInput = findViewById(R.id.todoTitle);
        descriptionInput = findViewById(R.id.todoDescription);
        dateInput = findViewById(R.id.todoDate);
        typeSpinner = findViewById(R.id.todoType);
        priorityGroup = findViewById(R.id.priorityGroup);
        saveButton = findViewById(R.id.saveButton);
        todoListView = findViewById(R.id.todoListView);

        // Set Spinner Data
        ArrayAdapter<CharSequence> spinnerAdapter = ArrayAdapter.createFromResource(this,
                R.array.todo_type, android.R.layout.simple_spinner_item);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        typeSpinner.setAdapter(spinnerAdapter);

        // Initialize ListView
        todoList = new ArrayList<>();
        listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, todoList);
        todoListView.setAdapter(listAdapter);

        // Date Picker
        dateInput.setOnClickListener(v -> showDatePicker());

        // Save Button Action
        saveButton.setOnClickListener(v -> saveTodo());
    }

    private void showDatePicker() {
        // Show Date Picker Dialog
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                (view, year1, month1, dayOfMonth) -> {
                    String date = dayOfMonth + "/" + (month1 + 1) + "/" + year1;
                    dateInput.setText(date);
                }, year, month, day);
        datePickerDialog.show();
    }

    private void saveTodo() {
        // Get Inputs
        String title = titleInput.getText().toString().trim();
        String description = descriptionInput.getText().toString().trim();
        String date = dateInput.getText().toString().trim();
        String type = typeSpinner.getSelectedItem().toString();
        int selectedPriorityId = priorityGroup.getCheckedRadioButtonId();

        // Validate Inputs
        if (title.isEmpty()) {
            Toast.makeText(this, "Please enter a title", Toast.LENGTH_SHORT).show();
            return;
        }

        if (description.isEmpty()) {
            Toast.makeText(this, "Please enter a description", Toast.LENGTH_SHORT).show();
            return;
        }

        if (date.isEmpty()) {
            Toast.makeText(this, "Please select a date", Toast.LENGTH_SHORT).show();
            return;
        }

        if (selectedPriorityId == -1) {
            Toast.makeText(this, "Please select a priority", Toast.LENGTH_SHORT).show();
            return;
        }

        RadioButton selectedPriority = findViewById(selectedPriorityId);
        String priority = selectedPriority.getText().toString();

        // Add to Todo List
        String todoItem = "Title: " + title +
                "\nDescription: " + description +
                "\nType: " + type +
                "\nPriority: " + priority +
                "\nDate: " + date;
        todoList.add(todoItem);
        listAdapter.notifyDataSetChanged();

        // Clear Inputs
        titleInput.setText("");
        descriptionInput.setText("");
        dateInput.setText("");
        priorityGroup.clearCheck();

        Toast.makeText(this, "Todo added successfully!", Toast.LENGTH_SHORT).show();
    }
}
