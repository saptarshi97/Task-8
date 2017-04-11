package saptarshi.com.task8;


import android.support.v7.widget.RecyclerView;
    import android.view.LayoutInflater;
    import android.view.View;
    import android.view.ViewGroup;
    import android.widget.TextView;

    import java.util.ArrayList;

 import saptarshi.com.task8.R;

 public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {
        private ArrayList<saptarshi.com.task8.version> android;

        public DataAdapter(ArrayList<saptarshi.com.task8.version> android) {
            this.android = android;
        }

        @Override
        public DataAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_row, viewGroup, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(DataAdapter.ViewHolder viewHolder, int i) {

            viewHolder.tv_name.setText(android.get(i).getName());
            viewHolder.tv_version.setText(android.get(i).getVer());
            viewHolder.tv_api_level.setText(android.get(i).getApi());
        }

        @Override
        public int getItemCount() {
            return android.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder{
            private TextView tv_name,tv_version,tv_api_level;
            public ViewHolder(View view) {
                super(view);

                tv_name = (TextView)view.findViewById(R.id.tv_name);
                tv_version = (TextView)view.findViewById(R.id.tv_version);
                tv_api_level = (TextView)view.findViewById(R.id.tv_api_level);

            }
        }

    }

