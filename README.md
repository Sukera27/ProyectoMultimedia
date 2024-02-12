# Proyecto Mutimedia

Este proyecto es una aplicación de Android que incluye varias actividades y fragmentos para administrar productos multimedia.

## Activities

### LoginActivity

Esta actividad permite a los usuarios iniciar sesión en la aplicación. Ofrece dos opciones de inicio de sesión: mediante credenciales locales (nombre de usuario y contraseña) o mediante Google Sign-In.

### NavigationActivity

La `NavigationActivity` es la actividad principal de la aplicación que utiliza un `BottomNavigationView` para navegar entre diferentes fragmentos. Los fragmentos disponibles son:

## Fragments

### HomeFragment

El `HomeFragment` muestra una lista de productos multimedia recuperados del servidor. Utiliza un `ListView` y un adaptador personalizado (`ProductAdapter`) para mostrar los productos.

### CreateFragment

El `CreateFragment` permite al usuario agregar un nuevo producto multimedia proporcionando un nombre, un precio y una URL de imagen. Al hacer clic en el botón "Crear Producto", se envía la información al servidor a través de una solicitud POST.

### UpdateFragment

El `UpdateFragment` permite al usuario actualizar un producto multimedia existente. Se muestra un formulario prellenado con los detalles del producto seleccionado. El usuario puede modificar estos detalles y hacer clic en el botón "Actualizar Producto" para enviar la solicitud PUT al servidor.

### DeleteFragment

El `DeleteFragment` permite al usuario eliminar un producto multimedia existente. Presenta un campo para ingresar el ID del producto a eliminar. Al hacer clic en el botón "Borrar Producto", se envía una solicitud DELETE al servidor.

### ExitFragment

El `ExitFragment` proporciona al usuario la opción de cerrar sesión en la aplicación. Al hacer clic en el botón "Salir", se cierra la sesión actual y se redirige al usuario a la pantalla de inicio de sesión.
