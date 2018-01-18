package id.xyzsystem.budiono.recyclerretrofit;

/**
 * Created by budiono on 18/01/18.
 */

import android.support.v7.widget.RecyclerView;
import java.util.ArrayList;
import android.widget.TextView;
import android.view.View;
import android.view.ViewGroup;
import android.view.LayoutInflater;

/**
 *  a_viewHolder
 *  b_viewHolder
 *  c_viewGroup
 *  d_view
 *  e_number
 *  f_number
 *  g_arrayList
 *  h_getitemcount
 *  */

/**
 * Override RecyclerView:
 * 1. onCreateViewHolder(ViewGroup, int)
 * 2. onBindViewHolder(ViewHolder, int)
 * 3. getItemCount()
 */

/* todo (): declare RecyclerView, AdapterData */
/* todo (): tambahkan extends recyclerview.adapter  */
public class AdapterData  extends RecyclerView.Adapter<AdapterData.a_viewHolder> {

    /* todo (1) declare private ArrayList */
    private ArrayList<ObjectData> g_arrayList;

    /* todo(2) isi adapter dengan arraylist, Declare: ArrayList */
    public AdapterData(ArrayList<ObjectData> g_arrayList) {
        this.g_arrayList = g_arrayList;
    }

    /* todo(4): isi data viewholder, berdasarkan layout yg telah dibuat  */
    @Override
    public void onBindViewHolder(AdapterData.a_viewHolder b_viewHolder, int f_number) {

        b_viewHolder.tv_name.setText(g_arrayList.get(f_number).getName());
        b_viewHolder.tv_version.setText(g_arrayList.get(f_number).getVer());
        b_viewHolder.tv_api_level.setText(g_arrayList.get(f_number).getApi());
    }

    /* todo (3) : bikin ViewHolder, declare: TextView, View */
    public class a_viewHolder extends RecyclerView.ViewHolder {
        private TextView tv_name, tv_version, tv_api_level;

        public a_viewHolder(View view) {
            super(view);

            /* todo () : view card_row.xml */
            tv_name = (TextView) view.findViewById(R.id.tv_name);
            tv_version = (TextView) view.findViewById(R.id.tv_version);
            tv_api_level = (TextView) view.findViewById(R.id.tv_api_level);
        }
    }

    /* todo(5) : Panggil layout vievHolder,  Declare layoutInflater, ViewGroup, Card_row */
    @Override
    public AdapterData.a_viewHolder onCreateViewHolder(ViewGroup c_viewGroup, int e_number) {
        View d_view = LayoutInflater.from(c_viewGroup.getContext()).inflate(R.layout.card_row, c_viewGroup, false);
        return new a_viewHolder(d_view);
    }

    /* todo (6) : getItemCount */
    @Override
    public int getItemCount() {
        return g_arrayList.size();
    }
}