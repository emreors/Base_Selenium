#Created by Emre ÖRS
#Date 11.01.2022

Feature: login functionality test with invalid username

  Scenario: Check hepsiburada login screen
    Given kullanici hepsiburada anasayfasina erisir
    And ana sayfada giris yap butonu goruntulenir
    When kullanici giris yap butonuna tiklar
    Then kullanici login sayfasina yonlendirilir

  Scenario: Check login username
    Given kullanici login sayfasina erisir
    When kullanici gecerli bir kullanici adi girer "wrong@wrong.com"
    And kullanici username icin giris yap butonuna tiklar
    Then sistem hatali eposta mesaji doner



