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
/**
 * Adaptador personalizado para la lista de productos.
 */
public class ProductAdapter extends BaseAdapter {

    private List<Product> products;
    private Context context;

    /**
     * Constructor del adaptador.
     *
     * @param context  Contexto de la aplicación.
     * @param products Lista de productos a mostrar.
     */
    public ProductAdapter(Context context, List<Product> products) {
        this.context = context;
        this.products = products;
    }
    /**
     * Devuelve el número de elementos en la lista.
     *
     * @return El número de elementos en la lista.
     */
    @Override
    public int getCount() {
        return products.size();
    }

    /**
     * Devuelve el elemento en la posición especificada.
     *
     * @param position La posición del elemento.
     * @return El elemento en la posición especificada.
     */
    @Override
    public Object getItem(int position) {
        return products.get(position);
    }

    /**
     * Devuelve el ID del elemento en la posición especificada.
     *
     * @param position La posición del elemento.
     * @return El ID del elemento en la posición especificada.
     */
    @Override
    public long getItemId(int position) {
        return products.get(position).getProductID();
    }

    /**
     * Devuelve una vista que muestra el elemento en la posición especificada.
     *
     * @param position    La posición del elemento.
     * @param convertView La vista reciclada que se debe utilizar.
     * @param parent      El grupo al que pertenece la vista.
     * @return Una vista que muestra el elemento en la posición especificada.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.product_list, parent, false);

            viewHolder = new ViewHolder();
            viewHolder.idLabel = convertView.findViewById(R.id.idLabel);
            viewHolder.idText = convertView.findViewById(R.id.idText);
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
        viewHolder.idLabel.setText("ID: ");
        viewHolder.idText.setText(String.valueOf(product.getProductID()));
        viewHolder.nameLabel.setText("Producto: ");
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
    /**
     * Clase estática para contener las vistas de un elemento de la lista.
     */
    static class ViewHolder {
        TextView idLabel;
        TextView idText;
        TextView nameLabel;
        TextView nameText;
        TextView priceLabel;
        TextView priceText;
        ImageView imageView;
    }
}


