## **MS URL SHORTENER(MELI CHALLENGE)**

**Author:**  Johan Fernando Sanchez Cano
****
### **Content**

- [Before starting](#before-starting)
- [Installing](#installing)
- [How to use](#how-to-use)
****
### **Before starting**

Make sure you have this installed. (Gradle is optional because it's included in the repo.)

| **Requirements:**     | **How to obtain**                                                           |
| --------------------- | --------------------------------------------------------------------------- |
| **Java**              | Obtain it here:  https://www.java.com/en/download/help/download_options.html|
| **Git**               | Guide: https://git-scm.com/book/en/v2/Getting-Started-Installing-Git        |
| **Gradle (optional)** | Guide here: https://gradle.org/install/                                     |

****
### **Installing**

#### **Cloning the repository**
First you need to clone the repository.
```
$ git clone https://github.com/johanshz/url-converter-ms.git
```

#### **Building the .jar**
Finally, execute this to build the .jar .
```
$ cd url-converter-ms
$ ./gradlew build
```
****
### **How to use**

#### **Executing**
Once the jar has been created navigate to the directory where you built the JAR file:

```
$ cd bank-challenge/applications/app-service/build/libs
```

Then run the JAR file using the following command:

```
$ java -jar EverBank.jar
```

This will start the application and make it available at http://localhost:8080.



#### **Local Endpoint**

Once the application is running, you can test it by sending a POST request to the following endpoint:

```
POST http://localhost:8080/generarUrl
```

This endpoint accepts a JSON payload in the following format:

```
{
    "original_url": "https://www.mercadolibre.com.co/televisor-caixun-40-c40vbfg-led-fhd-smart-google-tv/p/MCO24395719?pdp_filters=deal%3AMCO779366-1#polycard_client=homes-korribanSearchPromotions&searchVariation=MCO24395719&position=3&search_layout=grid&type=product&tracking_id=8f6fbc83-57b0-40bd-8a8c-d5d56e6ab252&c_id=/home/promotions-recommendations/element&c_uid=8704bd72-de49-46f8-9034-7a2f049f03a9"
}
```

This payload represents a transaction that receives a URL to perform a shortening.
Replace the value with the URLs you want to shorten.
As a result you get the unique id.


You can also go to the page with the uniqueId generated above, with the GET method

```
GET http://localhost:8080/55def7
```

You can also see the traceability information, with the GET method

```
http://localhost:8080/traceability
```

Consult the log of use of the Short Urls, with the GET method

```
http://localhost:8080/accumulatedIp
```

#### **SQL ACCESS**
You can also enter Sql Server and search for the tables created there.
You can find the url_shortener and traceability tables created.

In url_shortener table you can see original_url,unique_id and in traceability table you can see ip, registration_date and unique_id.


```
url=jdbc:postgresql://aws-0-sa-east-1.pooler.supabase.com:5432/postgres
username=postgres.uzichqmewciqqegoghsq
password=+-CF@2DdbGXPPS*
name=org.postgresql.Driver
```



