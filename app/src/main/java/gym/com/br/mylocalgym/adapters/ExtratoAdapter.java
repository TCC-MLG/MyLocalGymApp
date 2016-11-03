package gym.com.br.mylocalgym.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import gym.com.br.mylocalgym.R;
import gym.com.br.mylocalgym.models.ExtratoView;

/**
 * Created by Luciano on 02/11/2016.
 */

public class ExtratoAdapter extends ArrayAdapter<ExtratoView>{

    private final Context context;
    private final ArrayList<ExtratoView> elementos;

    public ExtratoAdapter(Context context, ArrayList<ExtratoView> elementos) {
        super(context, R.layout.linha_extrato, elementos);
        this.context = context;
        this.elementos = elementos;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.linha_extrato, parent, false);

        TextView nomeAcademia = (TextView) rowView.findViewById(R.id.nome);
        TextView valor = (TextView) rowView.findViewById(R.id.valor);
        TextView data = (TextView) rowView.findViewById(R.id.data);

        nomeAcademia.setText(elementos.get(position).getNomeAcademia());
        valor.setText(elementos.get(position).getValor());
        data.setText(elementos.get(position).getData());

        return rowView;

    }
}
