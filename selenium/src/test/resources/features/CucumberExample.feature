#Created by Emre ÖRS
#Date 05.05.2022

Feature:Cucumber Example

  Scenario: Kullanıcı sisteme giriş yapar.
    Given Tanımlı URL açılır.
    Given Kullanıcı giriş butonuna tıklanır.
    Given Kullanıcı adı ve şifre ile sisteme giriş yapılır.
    When Anasayfada üst kısımda bulunan arama yap alanına tıklanır.
    Then Çıkış yap.




