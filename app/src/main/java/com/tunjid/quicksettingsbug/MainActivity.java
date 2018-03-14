package com.tunjid.quicksettingsbug;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.view.accessibility.AccessibilityManager;
import android.widget.TextView;

import java.util.List;

import static android.view.accessibility.AccessibilityEvent.TYPES_ALL_MASK;

public class MainActivity extends AppCompatActivity {

    TextView prompt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        prompt = findViewById(R.id.text);
        prompt.setOnClickListener(view -> {
            if (!accessibilityServiceEnabled())
                startActivity(new Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS));
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        prompt.setText(accessibilityServiceEnabled()
                ? getString(R.string.quick_settings_prompt)
                : getString(R.string.accessibility_prompt));
    }

    public boolean accessibilityServiceEnabled() {
        String key = getPackageName();

        AccessibilityManager accessibilityManager = ((AccessibilityManager) getSystemService(ACCESSIBILITY_SERVICE));
        if (accessibilityManager == null) return false;

        List<AccessibilityServiceInfo> list = accessibilityManager.getEnabledAccessibilityServiceList(TYPES_ALL_MASK);

        for (AccessibilityServiceInfo info : list) if (info.getId().contains(key)) return true;
        return false;
    }
}
