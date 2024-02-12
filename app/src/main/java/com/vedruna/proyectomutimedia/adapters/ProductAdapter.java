package com.vedruna.proyectomutimedia.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.vedruna.proyectomutimedia.R;
import com.vedruna.proyectomutimedia.model.Product;

import java.util.List;

public class ProductAdapter extends BaseAdapter {

    private List<Product> products;
    private Context context;

    public ProductAdapter(Context context, List<Product> products) {
        this.context = context;
        this.products = products;
    }

    @Override
    public int getCount() {
        return products.size();
    }

    @Override
    public Object getItem(int position) {
        return products.get(position);
    }

    @Override
    public long getItemId(int position) {
        return products.get(position).getProductID();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.product_list, parent, false);

            viewHolder = new ViewHolder();
            viewHolder.nameLabel = convertView.findViewById(R.id.nameLabel);
            viewHolder.nameText = convertView.findViewById(R.id.nameText);
            viewHolder.priceLabel = convertView.findViewById(R.id.priceLabel);
            viewHolder.priceText = convertView.findViewById(R.id.priceText);
            viewHolder.imageView = convertView.findViewById(R.id.imageView);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        // Obtén el producto actual
        Product product = (Product) getItem(position);

        // Asignar los valores del producto a las vistas
        viewHolder.nameLabel.setText("Nombre: ");
        viewHolder.nameText.setText(product.getName());
        viewHolder.priceLabel.setText("Precio: ");
        viewHolder.priceText.setText(String.valueOf(product.getPrice()));
        // Verificar si la URL de la imagen no está vacía antes de cargarla con Picasso
        if (!product.getImageUrl().isEmpty()) {
            Picasso.get().load(product.getImageUrl()).into(viewHolder.imageView);
        } else {
            // Si la URL de la imagen está vacía, puedes cargar una imagen de placeholder o dejar el ImageView vacío
            viewHolder.imageView.setImageDrawable(null);
        }

        return convertView;
    }

    static class ViewHolder {
        TextView nameLabel;
        TextView nameText;
        TextView priceLabel;
        TextView priceText;
        ImageView imageView;
    }
}


