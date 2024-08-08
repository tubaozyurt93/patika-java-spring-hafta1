[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/bm7i247I)
1.SOA (Service-Oriented Architecture)
   
Açıklama: SOA, yazılım tasarımında hizmet tabanlı bir yaklaşımı ifade eder. Bu mimari, uygulamaların, birbirinden bağımsız ve belirli işlevleri yerine getiren hizmetler (services) şeklinde yapılandırılmasını öngörür. Her hizmet, belirli bir işlevi yerine getirir ve diğer hizmetlerle iletişim kurar.
  
 Örnek: Bir e-ticaret sitesinde, kullanıcı yönetimi, ürün kataloğu, sipariş yönetimi ve ödeme işlemleri gibi işlevler ayrı hizmetler olarak tasarlanabilir. Her bir hizmet, belirli bir işlevi yerine getirir ve diğer hizmetlerle veri alışverişi yapar.


2.Web Service

   Açıklama: Web servisleri, internet üzerinden iletişim kurabilen ve belirli işlevleri sunan yazılım bileşenleridir. Web servisleri, genellikle standart protokoller ve veri formatları kullanarak birbirleriyle etkileşimde bulunurlar.
   
   Örnek: Bir hava durumu web servisi, kullanıcıların hava durumu verilerini sorgulamasına izin verir. Kullanıcılar bu servise HTTP isteği gönderir ve servisten hava durumu verilerini alırlar.


   2.1 SOAP (Simple Object Access Protocol)
   Açıklama: SOAP, XML tabanlı bir mesajlaşma protokolüdür ve genellikle HTTP veya TCP/IP üzerinden çalışır. SOAP, güvenilir ve yapılandırılmış iletişim gerektiren kurumsal uygulamalarda yaygın olarak kullanılır. SOAP mesajları, WSDL (Web Services Description Language) dosyaları ile tanımlanır ve bu dosyalar, servislerin nasıl çağrılacağını, hangi protokollerin kullanılacağını ve hangi veri formatlarının desteklendiğini belirtir
   
 Örnek:

  ```
   xml
   <soap:Envelope xmlns:soap="http://www.w3.org/2003/05/soap-envelope">
   <soap:Header>
   <m:Trans xmlns:m="http://www.w3schools.com/transaction/" soap:mustUnderstand="1">
   234
   </m:Trans>
   </soap:Header>
   <soap:Body>
   <m:GetStockPrice xmlns:m="http://www.w3schools.com/prices">
   <m:StockName>IBM</m:StockName>
   </m:GetStockPrice>
   </soap:Body>
   </soap:Envelope>
   ```
   2.2. Restful Service
   
   Açıklama: RESTful hizmetler, REST (Representational State Transfer) mimarisini kullanarak yapılandırılmış web servisleridir. REST, HTTP protokolünü kullanarak kaynaklara erişim sağlar. RESTful hizmetler, genellikle JSON veya XML formatında veri sunar.
    
   Örnek: Bir RESTful API, kullanıcı bilgilerini yönetmek için HTTP istekleri kullanabilir. 
   
   Örneğin:
    
    GET /users - Tüm kullanıcıları getirir.
    POST /users - Yeni bir kullanıcı oluşturur.
    PUT /users/{id} - Belirli bir kullanıcının bilgilerini günceller.
    DELETE /users/{id} - Belirli bir kullanıcıyı siler.

   3. HTTP Methods

   Açıklama: HTTP yöntemleri, web servislerinde ve RESTful API'lerde kullanılan çeşitli işlemleri tanımlar. En yaygın HTTP yöntemleri şunlardır:
   
```
   GET: Sunucudan veri alır. Veri değişikliği yapmaz.
   Örnek: GET /products - Ürünlerin listesini getirir.
   POST: Sunucuya yeni veri gönderir. Genellikle veri oluşturmak için kullanılır.
   Örnek: POST /products - Yeni bir ürün ekler.
   PUT: Var olan bir veriyi günceller. Genellikle belirli bir kaynağı güncellemek için kullanılır.
   Örnek: PUT /products/123 - ID'si 123 olan ürünü günceller.
   DELETE: Sunucudan veri siler.
   Örnek: DELETE /products/123 - ID'si 123 olan ürünü siler.
   ```
