package com.example.fsi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Rvapi extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private ArrayList<Eleve> etudians;
    private ArrayList<Bilan_1> bilan1;
    private ArrayList<Bilan_2> bilan2;

    public Rvapi(Context context, ArrayList<Eleve> etudians) {
        this.context = context;
        this.etudians = etudians;
    }

    public Rvapi() {

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.eleve, parent, false);
        return new RVItemsEtudiant(v);

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        RVItemsEtudiant vh = (RVItemsEtudiant) holder;
        Eleve etudiant = etudians.get(position);

        vh.id.setText(String.valueOf(etudiant.getID_ETU()));
        vh.nom.setText(etudiant.getNOM_ETU());
        vh.prenom.setText(etudiant.getPRE_ETU());
        vh.classe.setText(etudiant.getCLA_ETU());
        vh.spe.setText(etudiant.getSPE_ETU());
        vh.log.setText(etudiant.getLOG_ETU());

        System.out.println(etudiant.getNOM_ETU());

    }

    @Override
    public int getItemCount() {
        return this.etudians.size();
    }
    public static class RVItemsEtudiant extends RecyclerView.ViewHolder{

        public TextView id, nom, prenom, classe,spe,log;

        public RVItemsEtudiant(@NonNull View itemView) {
            super(itemView);

            this.id = itemView.findViewById(R.id.etudiant_id);
            this.prenom = itemView.findViewById(R.id.etudiant_nom);
            this.nom = itemView.findViewById(R.id.etudian_prenom);
            this.classe = itemView.findViewById(R.id.etudian_cla);
            this.spe = itemView.findViewById(R.id.etudiant_spe);
            this.log = itemView.findViewById(R.id.etudiant_log);


        }
    }

}
