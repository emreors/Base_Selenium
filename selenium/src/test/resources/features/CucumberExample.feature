#Created by Emre ÖRS
#Date 05.05.2022

Feature:Cucumber Example

  Scenario: Kullanıcı sisteme giriş yapar.
    Given Tanimli URL acilir.
    Given Kullanici adi ve sifre ile sisteme giris yapilir.
    When Anasayfada ust kisimda bulunan arama yap alanina tiklanir.
    Then Cikis yapilir




