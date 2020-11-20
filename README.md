# cekino-back-end-test
Spring Project and Algorithm Question for Cekino


# Ana READ.ME DOSYASI. Lütfen Dikkatle Okuyunuz.

# Spring Projesi Hk.

Gerekli exception handlingler yazıldı.
Gerekli katmanlı mimari yapıya uygun kod geliştirilmeye çalışıldı.
Api Path'lerinin ya da Exception mesajlarının olduğu class'lar private yapıldı.
(Sınıf adı üzerinden doğrudan ulaşılabilen field'lar için nesne oluşturulması engellendi.)
Swagger Dokümantasyonu yazıldı. Kodu çalıştırınca "localhos:1905/swagger-ui.html" üzerinden doc'a ulaşabilirsiniz.

--

1) Exception Handling daha düzenli yazılabilirdi.
2) Update ve insert methodları daha sade yazılabilirdi.
3) If-Else blokları kodda fazla var, ki bu da SOLID kavramlarından Liskov's Substition kavramına aykırı bir durum.


# DİKKAT
1) Kod 1905 portu üzerinden ayağa kalkar.
2) Gerekli db adı userdb'dir. 
3) BASE_URL ("/cekino") üzerinden diğer Mapping'lere ulaşılır.
4) Projenin jar hali için master branch, war (External TomCat) hali için TomcatDeploying branchı kullanıldı.
5) External olarak TomCat yüklendi. Deploy edildi. Fakat bazı hatalarla karşılaşıldı. Tam ve doğru sonuç alınamadı.
6) Herhangi bir test case yapmamanız adına, tüm test case'leri içeren bir video çekildi.
https://drive.google.com/drive/folders/1M4GJwWLZhe_OokQWR-BWB6xIpW0Pthe3?usp=sharing
Bu linkten ilgili video'ya ulaşabilirsiniz. (5.43 dk)

