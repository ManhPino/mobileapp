package com.example.myapplication.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.IClick;
import com.example.myapplication.R;
import com.example.myapplication.model.Infor;

import java.util.ArrayList;

public class InforAdapter extends RecyclerView.Adapter<InforAdapter.ViewHolderInfor> {
    private IClick iClick;
    private ArrayList<Infor> arrInfor;

    public InforAdapter(IClick iClick, ArrayList<Infor> arrInfor) {
        this.iClick = iClick;
        this.arrInfor = arrInfor;
    }

    @NonNull
    @Override
    public ViewHolderInfor onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_infor,parent,false);
        return new ViewHolderInfor(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderInfor holder, int position) {
          Infor f = arrInfor.get(position);
          holder.txtName.setText("Name:" +   f.getName());
          holder.txtEmail.setText("Mail:" + f.getEmail());
          holder.txtContact.setText("Contact:" +f.getContact());
          holder.txtAddress.setText("Address:" +f.getAddress());
          holder.btnUpdate.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                  iClick.mEdit(f);
              }
          });
          holder.btnDelete.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                  iClick.mDelete(f);
              }
          });
    }

    @Override
    public int getItemCount() {
        return arrInfor.size();
    }

    class ViewHolderInfor extends RecyclerView.ViewHolder{
        private TextView txtName, txtEmail,txtAddress,txtContact;
        private ImageButton btnUpdate, btnDelete;
        public ViewHolderInfor(@NonNull View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.name_update);
            txtEmail = itemView.findViewById(R.id.email_update);
            txtAddress = itemView.findViewById(R.id.address_update);
            txtContact = itemView.findViewById(R.id.contact_update);
            btnUpdate = itemView.findViewById(R.id.btn_a);
            btnDelete = itemView.findViewById(R.id.btn_b);
        }
    }
}
