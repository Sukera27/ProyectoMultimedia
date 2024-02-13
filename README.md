# Proyecto Mutimedia

Este proyecto es una aplicación de Android que incluye varias actividades y fragmentos para administrar productos vegetales de una empresa ficticia llamada Eco-Logist.

## Activities

### LoginActivity

Esta actividad permite a los usuarios iniciar sesión en la aplicación. Ofrece dos opciones de inicio de sesión: mediante credenciales locales (nombre de usuario y contraseña) o mediante Google Sign-In.

![login](https://github.com/Sukera27/ProyectoMultimedia/assets/122563964/c5f7c15c-264f-451c-b716-5ff2e23ef256)

### NavigationActivity

La `NavigationActivity` es la actividad principal de la aplicación que utiliza un `BottomNavigationView` para navegar entre diferentes fragmentos. Los fragmentos disponibles son:

![Captura de pantalla 2024-02-13 132630](https://github.com/Sukera27/ProyectoMultimedia/assets/122563964/f1da89d1-49d8-4ef3-89b6-9b4ff23ca8c1)

## Fragments

### HomeFragment

El `HomeFragment` muestra una lista de productos multimedia recuperados del servidor. Utiliza un `ListView` y un adaptador personalizado (`ProductAdapter`) para mostrar los productos.

![Productos](https://github.com/Sukera27/ProyectoMultimedia/assets/122563964/e15a31ec-872f-4d7b-8631-ae8f05b34432)

### CreateFragment

El `CreateFragment` permite al usuario agregar un nuevo producto multimedia proporcionando un nombre, un precio y una URL de imagen. Al hacer clic en el botón "Crear Producto", se envía la información a la API a través de una solicitud POST.

![crear](https://github.com/Sukera27/ProyectoMultimedia/assets/122563964/5ecd6470-020e-43fd-8a85-6a8c10ba908f)

### UpdateFragment

El `UpdateFragment` permite al usuario actualizar un producto multimedia existente. Se muestra un formulario prellenado con los detalles del producto seleccionado. El usuario puede modificar estos detalles y hacer clic en el botón "Actualizar Producto" para enviar la solicitud PUT a la API.

![actualizar](https://github.com/Sukera27/ProyectoMultimedia/assets/122563964/f7fd0715-1b47-46ba-80a0-c8f302d03b9f)

### DeleteFragment

El `DeleteFragment` permite al usuario eliminar un producto multimedia existente. Presenta un campo para ingresar el ID del producto a eliminar. Al hacer clic en el botón "Borrar Producto", se envía una solicitud DELETE a la API.

![borrar](https://github.com/Sukera27/ProyectoMultimedia/assets/122563964/259df94c-454a-487c-94ae-5db1251832a5)

### ExitFragment

El `ExitFragment` proporciona al usuario la opción de cerrar sesión en la aplicación. Al hacer clic en el botón "Salir", se cierra la sesión actual y se redirige al usuario a la pantalla de inicio de sesión.

![salir](https://github.com/Sukera27/ProyectoMultimedia/assets/122563964/663eb1f0-9d8e-47aa-b901-278bac5d5bbb)

## Uso de Dependencias

El proyecto utiliza varias dependencias para diferentes propósitos, incluyendo soporte de diseño, navegación, autenticación, comunicación con API, entre otros. A continuación se detallan las principales dependencias utilizadas:

- **AppCompat:** Biblioteca de compatibilidad para proporcionar características de la última versión del framework en versiones anteriores de Android.
- **Material Design:** Implementa los principios de Material Design en la interfaz de usuario de la aplicación.
- **ConstraintLayout:** Permite crear diseños grandes y complejos con una jerarquía de vistas plana.
- **CardView:** Proporciona un contenedor de diseño redondeado que se puede utilizar para representar información y acciones en tarjetas.
- **Picasso:** Librería para cargar y mostrar imágenes en la aplicación de forma sencilla.
- **Navigation Component:** Herramientas para facilitar la navegación dentro de la aplicación.
- **Firebase Auth:** Para la autenticación de usuarios mediante Firebase Authentication.
- **Play Services Auth:** Implementa la funcionalidad de inicio de sesión con Google en la aplicación.
- **Retrofit:** Biblioteca de cliente HTTP para la comunicación con servicios web RESTful.
- **Gson Converter:** Convierte JSON a objetos Java utilizando Gson para Retrofit.
- **JUnit y Espresso:** Utilizadas para realizar pruebas unitarias y de interfaz respectivamente.

Estas dependencias proporcionan una base sólida para el desarrollo de la aplicación y su integración con servicios externos.

