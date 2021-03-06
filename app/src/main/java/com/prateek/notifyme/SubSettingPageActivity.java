package com.prateek.notifyme;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.prateek.notifyme.service.NotificationService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SubSettingPageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_setting_page);
        ListView listViewWithCheckbox = (ListView) findViewById(R.id.list_view_with_checkbox);

        // Create a custom list view adapter with checkbox control.
        final ListViewItemCheckboxBaseAdapter listViewDataAdapter = new ListViewItemCheckboxBaseAdapter(getApplicationContext(), getInitViewItemDtoList());
        listViewDataAdapter.notifyDataSetChanged();
        listViewWithCheckbox.setAdapter(listViewDataAdapter);
    }

    private List<ListViewItemDTO> getInitViewItemDtoList() {
        NotificationService notifyService = new NotificationService(getApplicationContext());
        return notifyService.getEnableStatusOfApps();

//        List<ListViewItemDTO> ret = new ArrayList<>();


        /*if(enableStatusOfApps!= null){
            //String itemTextArr[] = {"Facebook", "Tinder", "WhatsApp", "Instagram", "Chase Bank"};
            int length = data.size();

            for (int i = 0; i < length; i++) {
                String itemText = data.get(i);
                ListViewItemDTO dto = new ListViewItemDTO();
                dto.setChecked(dto.isChecked());
                dto.setItemText(itemText);
                ret.add(dto);
            }
        }*/

//        return ret;
    }

    /*// Return an initialize list of ListViewItemDTO.
    private List<ListViewItemDTO> getInitViewItemDtoList() {
        String itemTextArr[] = {"Facebook", "Tinder", "WhatsApp", "Instagram", "Chase Bank"};
        List<ListViewItemDTO> ret = new ArrayList<>();

        int length = itemTextArr.length;

        for (int i = 0; i < length; i++) {
            String itemText = itemTextArr[i];

            ListViewItemDTO dto = new ListViewItemDTO();
            dto.setChecked(true);
            dto.setItemText(itemText);
            ret.add(dto);
        }
        return ret;
    }*/

    @Override
    public void onBackPressed() {
        finish();
        overridePendingTransition(R.anim.slide_to_right, R.anim.slide_from_left);
    }
}
