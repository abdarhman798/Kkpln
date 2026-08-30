package com.abboud.executor;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.content.ClipboardManager;
import android.content.Context;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText scriptEditor;
    private Button btnExecute, btnClear, btnPaste;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scriptEditor = findViewById(R.id.scriptEditor);
        btnExecute = findViewById(R.id.btnExecute);
        btnClear = findViewById(R.id.btnClear);
        btnPaste = findViewById(R.id.btnPaste);

        btnClear.setOnClickListener(v -> scriptEditor.setText(""));

        btnPaste.setOnClickListener(v -> {
            ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
            if (clipboard.hasPrimaryClip() && clipboard.getPrimaryClip().getItemCount() > 0) {
                CharSequence pasteData = clipboard.getPrimaryClip().getItemAt(0).getText();
                if (pasteData != null) {
                    scriptEditor.getText().insert(scriptEditor.getSelectionStart(), pasteData);
                }
            }
        });

        btnExecute.setOnClickListener(v -> {
            String script = scriptEditor.getText().toString();
            if (!script.isEmpty()) {
                executeScript(script);
            } else {
                Toast.makeText(MainActivity.this, "السكربت فاضي!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void executeScript(String script) {
        Toast.makeText(this, "جاري إرسال السكربت للعبة...", Toast.LENGTH_SHORT).show();
    }
}
