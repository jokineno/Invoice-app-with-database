### This is a course work in University of Helsinki<h3>
- Documentation is written in Finnish. Programming Language used in the project is Java. This project is a sketch of Invoicing system in which customers can be added to a database. After selecting a customer an invoice template gets filled automatically with the selected customer information. 

# OTM-HARJOITUSTYO - Laskutusohjelma<h1> 
 
Laskutusohjelman avulla voiluoda pdf-muotoisia laskuja. Laskut tallentuvat tietokantaan. Lisäksi ohjelmassa voi luoda asiakasrekisterin.  Tietokannat tallentuu käyttäjän koneelle. 




# Dokumentaatio <h2>

[Kayttöohje](https://github.com/jokineno/otm-harjoitustyo/blob/master/dokumentaatio/kaytto-ohje.md)

[Vaatimusmäärittely.md](https://github.com/jokineno/otm-harjoitustyo/blob/master/dokumentaatio/vaatimusmaarittely.md)

[Arkkitehtuuri.md](https://github.com/jokineno/otm-harjoitustyo/blob/master/dokumentaatio/arkkitehtuuri.md)

[Testausdokumentti](https://github.com/jokineno/otm-harjoitustyo/blob/master/dokumentaatio/testausdokumentti.md)

[Työaikakirjanpito.md](https://github.com/jokineno/otm-harjoitustyo/blob/master/dokumentaatio/tuntikirjanpito.md) 

# Release <h3>
[Release viikko6](https://github.com/jokineno/otm-harjoitustyo/releases/tag/viikko6)


[Loppupalautus](https://github.com/jokineno/otm-harjoitustyo/releases/tag/loppupalautus)

# Ohjelman kääntyminen <h3> 
Ohjelma kääntyy NetBeansissa vihreällä "Run"- nappulalla 

>**Terminaalissa:**
1. Mene ensiksi otm-harjoitustyo/laskutusohjelma/Laskutusohjelma

Anna komento: **mvn compile exec:java -Dexec.mainClass=laskutusohjelma.ui.Paaohjelma**

# Testaus <h3> 
1. Mene ensiksi otm-harjoitustyo/laskutusohjelma/Laskutusohjelma

Anna komento: **mvn test**

# Testikattavuusraportti <h3>
1. Mene ensiksi otm-harjoitustyo/laskutusohjelma/Laskutusohjelma

Anna komento: **mvn jacoco:report**


# Checkstyle <h3> 

Tiedostoon [checkstyle.xlm](https://github.com/jokineno/otm-harjoitustyo/blob/master/laskutusohjelma/Laskutusohjelma/checkstyle.xml) määrittelemät tarkistukset suoritetaan komennolla

>mvn jxr:jxr checkstyle:checkstyle

Mahdolliset virheilmoitukset selviävät avaamalla selaimella tiedosto target/site/checkstyle.html

Lopullisessa työssä on kaksi virheilmoitusta, jotka ovat liian pitkien metodien syytä. Mielestäni kuitenkin näitä ei voi muuttaa, niin että se helpottaisi ohjelman käyttämistä.

# Suoritettavan jarin generointi <h3>

Pakkauksen luominen onnistuu terminaalissa komennolla:

> mvn package

generoi hakemistoon target suoritettavan jar-tiedoston laskutusohjelma-1.0-SNAPSHOT.jar


# JavaDoc <h3> 
JavaDocin suoritus onnistuu komennolla: 

>mvn javadoc:javadoc

JavaDocia voi tarkastella avaamalla selaimella tiedosto target/site/apidocs/index.html
