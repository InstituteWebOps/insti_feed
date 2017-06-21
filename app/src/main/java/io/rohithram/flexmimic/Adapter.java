package io.rohithram.flexmimic;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.List;


/**
 * Created by rohithram on 14/6/17.
 */

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder>  {
    Context context;
    List<String> cardcontent;
    List<String> carddate;
    List<String> cardtime;
    List<String> cardloc;
    @Override
    public Adapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.content_main, parent, false);
        return new ViewHolder(itemView);
    }
    public Adapter(Context context, List<String> cardcontent,List<String> carddate,List<String> cardtime,List<String> cardloc){
        this.context = context;
        this.cardcontent = cardcontent;
        this.carddate = carddate;
        this.cardtime = cardtime;
        this.cardloc = cardloc;

    }

    @Override
    public void onBindViewHolder(final Adapter.ViewHolder holder, int position) {
        holder.tv_maindate.setText(carddate.get(holder.getAdapterPosition()));
        holder.tv_briefdes.setText(cardcontent.get(holder.getAdapterPosition()));
        holder.tv_date.setText(carddate.get(holder.getAdapterPosition()));
        holder.tv_time.setText(cardtime.get(holder.getAdapterPosition()));
        holder.tv_loc.setText(cardloc.get(holder.getAdapterPosition()));



        holder.cv_content.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (holder.tv_des.getVisibility() == View.GONE) {
                    // it's collapsed - expand it
                    holder.tv_des.setVisibility(View.VISIBLE);
                    holder.bt_show.setImageResource(R.drawable.ic_expand_less_black_24dp);
                } else {
                    // it's expanded - collapse it
                    holder.tv_des.setVisibility(View.GONE);
                    holder.bt_show.setImageResource(R.drawable.ic_expand_more_black_24dp);
                }

                ObjectAnimator animation = ObjectAnimator.ofInt(holder.tv_des, "maxLines",holder.tv_des.getMaxLines());
                animation.setDuration(200).start();
            }
        });
        holder.bt_show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (holder.tv_des.getVisibility() == View.GONE) {
                    // it's collapsed - expand it
                    holder.tv_des.setVisibility(View.VISIBLE);
                    holder.bt_show.setImageResource(R.drawable.ic_expand_less_black_24dp);
                } else {
                    // it's expanded - collapse it
                    holder.tv_des.setVisibility(View.GONE);
                    holder.bt_show.setImageResource(R.drawable.ic_expand_more_black_24dp);
                }

                ObjectAnimator animation = ObjectAnimator.ofInt(holder.tv_des, "maxLines",holder.tv_des.getMaxLines());
                animation.setDuration(200).start();
            }
        });

    }


            @Override
    public int getItemCount() {
        return cardcontent.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        public CardView cv_content;
        public TextView tv_maindate;
        public TextView tv_briefdes;
        public TextView tv_des;
        public TextView tv_time;
        public TextView tv_loc;
        public TextView tv_date;
        ImageButton bt_share,bt_save,bt_show,bt_sched,bt_contact;
        public ViewHolder(View itemView) {
            super(itemView);
            cv_content = (CardView)itemView.findViewById(R.id.cv_content);
            tv_maindate = (TextView)itemView.findViewById(R.id.tv_maindate);
            tv_briefdes =(TextView)itemView.findViewById(R.id.tv_briefdes);
            tv_des = (TextView)itemView.findViewById(R.id.tv_des);
            tv_date = (TextView)itemView.findViewById(R.id.tv_date);
            tv_time = (TextView)itemView.findViewById(R.id.tv_time);
            tv_loc = (TextView)itemView.findViewById(R.id.tv_loc);

            bt_share = (ImageButton)itemView.findViewById(R.id.bt_share);
            bt_save = (ImageButton)itemView.findViewById(R.id.bt_save);
            bt_sched = (ImageButton)itemView.findViewById(R.id.bt_sched);
            bt_contact = (ImageButton)itemView.findViewById(R.id.bt_contact);
            bt_show = (ImageButton)itemView.findViewById(R.id.bt_show);


        }
    }
}
