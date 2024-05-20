## **MS URL SHORTENER(MELI CHALLENGE)**

**Author:**  Johan Fernando Sanchez Cano
****
### **Contentido**

- [Before starting](#before-starting)
- [Installing](#installing)
- [How to use](#how-to-use)
****
### **Antes de empezar**

Asegúrate de tener esto instalado. (Gradle es opcional porque está incluido en el repositorio).

| **Requerimientos:**   | **Como obtener**                                                              |
|-----------------------|-------------------------------------------------------------------------------|
| **Java**              | Consíguelo aquí:  https://www.java.com/en/download/help/download_options.html |
| **Git**               | Guía: https://git-scm.com/book/en/v2/Getting-Started-Installing-Git           |
| **Gradle (optional)** | Guía aqui: https://gradle.org/install/                                        |

****
### **Instalación**

#### **Clonando el repositorio**
Clonar el repositorio.
```
$ git clone https://github.com/johanshz/url-converter-ms.git
```

#### **Construyendo el .jar**
Finalmente, ejecute esto para construir el .jar .
```
$ cd url-converter-ms
$ ./gradlew build
```
****
### **Cómo utilizar**

#### **Ejecutando**
Una vez que se haya creado el archivo jar, navegue hasta el directorio donde creó el archivo JAR.:

```
$ cd url-converter-ms\applications\app-service\build\libs
```

Luego ejecute el archivo JAR usando el siguiente comando:

```
$ java -jar ms-url-shortener.jar
```

Esto iniciará la aplicación y la pondrá a disposición en http://localhost:8080.



#### **local**

Una vez que la aplicación se esté ejecutando, puede probarla enviando la siguiente solicitud POST:

```
POST http://localhost:8080/generarUrl
```

Recibe una URL para realizar un acortamiento.
Reemplace el valor con la URL que desea acortar.
Como resultado obtienes el uniqueId.
Acepta JSON en el siguiente formato:
```
{
    "original_url": "https://www.mercadolibre.com.co/televisor-caixun-40-c40vbfg-led-fhd-smart-google-tv/p/MCO24395719?pdp_filters=deal%3AMCO779366-1#polycard_client=homes-korribanSearchPromotions&searchVariation=MCO24395719&position=3&search_layout=grid&type=product&tracking_id=8f6fbc83-57b0-40bd-8a8c-d5d56e6ab252&c_id=/home/promotions-recommendations/element&c_uid=8704bd72-de49-46f8-9034-7a2f049f03a9"
}
```


Para ir a la pagina de la url acortada, debe enviar el uniqueId como parametro.
Debe ser peticion get y para validar que se realice el redireccionamiento se debe 
realizar la peticion desde un navegador
```
GET http://localhost:8080/55def7
```

También puedes ver la información de trazabilidad, con el método GET

```
http://localhost:8080/traceability
```

Para consultar la bitacora de uso de las URL Cortas, con el método GET

```
http://localhost:8080/accumulatedIp
```

#### **Acceso SQL**
También puedes ingresar a Sql Server y buscar las tablas creadas allí.
Puede encontrar las tablas url_shortener y de traceability creadas.

En la tabla url_shortener puede ver la original_uri, el unique_id y en la tabla de traceability puede ver la ip,registration_date y el unique_id.


```
url=jdbc:postgresql://aws-0-sa-east-1.pooler.supabase.com:5432/postgres
username=postgres.uzichqmewciqqegoghsq
password=+-CF@2DdbGXPPS*
name=org.postgresql.Driver
```



