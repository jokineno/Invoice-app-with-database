# OTM-HARJOITUSTYO - Laskutusohjelma<h1> 

Laskutusohjelman avulla voiluoda pdf-muotoisia laskuja. Laskut tallentuvat tietokantaan. Lisäksi ohjelmassa voi luoda asiakasrekisterin.  Tietokannat tallentuu käyttäjän koneelle. 




# Dokumentaatio <h2>

[Kayttöohje](https://github.com/jokineno/otm-harjoitustyo/blob/master/dokumentaatio/kaytto-ohje.md)

[Vaatimusmäärittely.md](https://github.com/jokineno/otm-harjoitustyo/blob/master/dokumentaatio/vaatimusmaarittely.md)

[Arkkitehtuuri.md](https://github.com/jokineno/otm-harjoitustyo/blob/master/dokumentaatio/arkkitehtuuri.md)

Testausdokumentti

[Työaikakirjanpito.md](https://github.com/jokineno/otm-harjoitustyo/blob/master/dokumentaatio/tuntikirjanpito.md) 

# Release/viikko6 <h3>
[Release](https://github.com/jokineno/otm-harjoitustyo/releases/tag/viikko6)

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

# Suoritettavan jarin generointi <h3>

Pakkauksen luominen onnistuu terminaalissa komennolla:

> mvn package

generoi hakemistoon target suoritettavan jar-tiedoston laskutusohjelma-1.0-SNAPSHOT.jar


# JavaDoc <h3> 
JavaDocin suoritus onnistuu komennolla: 

>mvn javadoc:javadoc

JavaDocia voi tarkastella avaamalla selaimella tiedosto target/site/apidocs/index.html
