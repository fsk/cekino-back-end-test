# cekino-back-end-test
Spring Project and Algorithm Question for Cekino

Swagger dokümantasyonu oluşturuldu.
Katmanlı Mimari kullanıldı.
Business Katmanı service katmanında oluşturuldu.
Http Method'ları için ayrı bir katman ve class kullanıldı. Bu class'tan (UserPath class'ı) nesne üretilmesine gerek olmadığından dolayı
(çünkü bütün field'ları static ve direkt olarak class adıyla ulaşılabilir.) constructor'u private tanımlandı ve nesne üretilmesi engellendi.
Exception class'ı için de aynısı yapıldı. 

# HATALAR

1) Service katmanında güncelleme ve kaydetme methodları için daha uygun bir business logic kullanılabilirdi.
2) Çözülemeyen bir hatadan dolayı (PostgreSQL hatası) kod deploy edilemedi.
3) Swagger documentasyonu daha uygun yazılabilirdi.
4) Branch mantığı ile github'a kodlar daha uygun bir biçimde atılabilirdi.
5) Unit Test yazılabilirdi. Ve test coverage ile başarı durumu gözetilebilirdi.
