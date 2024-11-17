package com.example.assignment_4;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.List;
import java.util.Map;

public class ExpandableListAdapter extends BaseExpandableListAdapter {

    private Context context;
    private List<String> genreList;
    private Map<String, List<String>> movieList;

    public ExpandableListAdapter(Context context, List<String> genreList, Map<String, List<String>> movieList) {
        this.context = context;
        this.genreList = genreList;
        this.movieList = movieList;
    }

    @Override
    public int getGroupCount() {
        return genreList.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return movieList.get(genreList.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return genreList.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return movieList.get(genreList.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.group_item, null);
        }
        TextView groupTextView = convertView.findViewById(R.id.groupTextView);
        groupTextView.setText((String) getGroup(groupPosition));
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.child_item, null);
        }
        TextView childTextView = convertView.findViewById(R.id.childTextView);
        childTextView.setText((String) getChild(groupPosition, childPosition));
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
