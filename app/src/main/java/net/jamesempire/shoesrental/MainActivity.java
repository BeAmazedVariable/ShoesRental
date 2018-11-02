package net.jamesempire.shoesrental;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final Integer[] shoesPic =  {R.drawable.adidas, R.drawable.jordan
                , R.drawable.klay, R.drawable.lebron,
                R.drawable.kobe,R.drawable.curry};
        final String[] shoeName = {"Adidas Crazy Explosive" , "Air Jordan XX9", "Anta KT3" ,"Lebron 15" , "Nike Zoom Kobe 1 protro","Under Armour Curry 2"};
        final Integer[] shoeRentalPrice = {160, 185, 120, 185, 175, 135} ;


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridView grid = findViewById(R.id.gridView);
        final ImageView rentedShoeImage = findViewById(R.id.imgRented);

        //Declare an output format for the output
        final DecimalFormat currency = new DecimalFormat("###$");

        grid.setAdapter(new ImageAdapter(this));
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getBaseContext(), "You have selected " + shoeName[position] + " which price is: " + currency.format(shoeRentalPrice[position]), Toast.LENGTH_SHORT).show();
                rentedShoeImage.setImageResource(shoesPic[position]);
            }

        });

    }
    public class ImageAdapter extends BaseAdapter
    {
        final Integer[] shoesPic =  {R.drawable.adidas, R.drawable.jordan
                , R.drawable.klay, R.drawable.lebron,
                R.drawable.kobe,R.drawable.curry};

        private Context context;
        public ImageAdapter(Context c) {
            context = c;
        }

        @Override
        public int getCount() {
            return shoesPic.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView gridViewShoeImage = new ImageView(context);
            gridViewShoeImage.setImageResource(shoesPic[position]);
            gridViewShoeImage.setScaleType(ImageView.ScaleType.FIT_XY);
            gridViewShoeImage.setLayoutParams(new GridView.LayoutParams(330,300));
            return gridViewShoeImage;
        }
    }
}
