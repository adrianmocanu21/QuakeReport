package com.example.android.quakereport;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class EarhquakeAdapter extends ArrayAdapter<Earthquake> {


    public EarhquakeAdapter(Context context, ArrayList<Earthquake> earthquakes) {
        super(context, 0, earthquakes);
    }

    private String formatDate(Date dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        return dateFormat.format(dateObject);
    }

    private String formatTime(Date dateObject) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        return timeFormat.format(dateObject);
    }

    private String getFirstName(String earthquakeName) {
        Pattern p = Pattern.compile("(.*of)");
        Matcher m = p.matcher(earthquakeName);
        if( m.find() ) {
            return m.group(1);
        }
        return "Near the";
    }

    private String getSecondName(String earthquakeName) {
        Pattern p = Pattern.compile(".*of(.*)");
        Matcher m = p.matcher(earthquakeName);
        if( m.find() ) {
            return m.group(1);
        } else return earthquakeName;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;

        if( listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false);
        }

        Earthquake currentQuake = getItem(position);

        DecimalFormat formatter = new DecimalFormat("0.0");
        String output = formatter.format(currentQuake.getMagnitude());
        TextView magnitudeTV = (TextView) listItemView.findViewById(R.id.magnitude);
        magnitudeTV.setText(output);
        // Set the proper background color on the magnitude circle.
        // Fetch the background from the TextView, which is a GradientDrawable.
        GradientDrawable magnitudeCircle = (GradientDrawable) magnitudeTV.getBackground();
        // Get the appropriate background color based on the current earthquake magnitude
        int magnitudeColor = getMagnitudeColor(currentQuake.getMagnitude());
        // Set the color on the magnitude circle
        magnitudeCircle.setColor(magnitudeColor);



        String earthquakeName = currentQuake.getEarthquakeName();

        TextView earthquakeNameTv1 = (TextView) listItemView.findViewById(R.id.quake_name1);
        String name1 = getFirstName(earthquakeName);
        earthquakeNameTv1.setText(name1);

        TextView earthquakeNameTv2 = (TextView) listItemView.findViewById(R.id.quake_name2);
        String name2 = getSecondName(earthquakeName);
        earthquakeNameTv2.setText(name2);



        Date dateObject = new Date(currentQuake.getEarthquakeDate());

        TextView earthquakeDate = (TextView) listItemView.findViewById(R.id.quake_date);
        String formattedDate = formatDate(dateObject);
        earthquakeDate.setText(formattedDate);

        TextView earthquakeTime = (TextView) listItemView.findViewById(R.id.quake_time);
        String formattedTime = formatTime(dateObject);
        earthquakeTime.setText(formattedTime);

        return listItemView;
    }

    private int getMagnitudeColor(double magnitude) {
        int magnitudeColorResourceId;
        int magnitudeFloor = (int) Math.floor(magnitude);
        switch (magnitudeFloor) {
            case 0:
            case 1:
                magnitudeColorResourceId = R.color.magnitude1;
                break;
            case 2:
                magnitudeColorResourceId = R.color.magnitude2;
                break;
            case 3:
                magnitudeColorResourceId = R.color.magnitude3;
                break;
            case 4:
                magnitudeColorResourceId = R.color.magnitude4;
                break;
            case 5:
                magnitudeColorResourceId = R.color.magnitude5;
                break;
            case 6:
                magnitudeColorResourceId = R.color.magnitude6;
                break;
            case 7:
                magnitudeColorResourceId = R.color.magnitude7;
                break;
            case 8:
                magnitudeColorResourceId = R.color.magnitude8;
                break;
            case 9:
                magnitudeColorResourceId = R.color.magnitude9;
                break;
            default:
                magnitudeColorResourceId = R.color.magnitude10plus;
                break;
        }
        return ContextCompat.getColor(getContext(), magnitudeColorResourceId);
    }
}
