# Vaatimusmäärittely <h1>

# Sovelluksen tarkoitus <h3>

Harjoitustyönä teen laskutusohjelman pienyritykselle. Ohjelmalla voi kirjoittaa pdf laskun. Laskutusohjelmalla voi olla useita käyttäjiä.
Toistaiseksi kaikilla käyttäjillä on yhteinen asiakasrekisteri. 

# Käyttäjät <h3> 
* Ainakin aluksi sovelluksella on vain yksi käyttäjärooli eli _normaali käyttäjä_. Käyttäjiä voi olla monia. Asiakasrekisteri on yhteinen kaikille. Myöhemmin lisättävällä _pääkäyttäjällä_ on oikeus tehdä muokkauksia ohjelmaan. Pääkäyttäjä voi myös tarkastella ohjelman käyttödataa. Lue ylläpitäjä. 

# Ylläpitäjä <h3> 
* Ylläpitäjä voi tarkastella erilaisia tilastoja, kuten laskutusmääriä, käyttäjämäärää jne. 
* Ylläpitäjä voi myös poistaa käyttäjiä.

# Toiminnallisuudet <h3> 

* Käyttäjä voi luoda tunnuksen ja kirjautua. 

* Käyttäjä voi lisätä itselleen omat tietonsa, jotka tallentuvat suoraan laskupohjaan. Täten oman yrityksen tietoja ei tarvitse aina erikseen lisätä laskupohjaan. Esimerkiksi yrityksen nimi, y-tunnus, tilinumero, pankkiyhteys jne. 

* Sovelluksessa voi luoda laskun. Laskua luodessa voi valita "pudotusvalikosta" asiakkaan tai luoda uuden asiakkaan. 

* Asiakkaat tallentuvat tietokantaan, jossa on asiakkaasta pidetään tallessa: id,  nimi ja y-tunnus. 

* Sovelluksessa on myös viitenumerogeneraattori, joka generoi jokaiseen laskuun aina uuden viitenumeron. 

* Käyttäjä voi muokata omia tietojaan

* Käyttäjä voi luoda myös uuden käyttäjän 

* Käyttäjä voi luoda uuden asiakkaan



# Jatkokehitysideat <h3>

* Ohjelma voi tarjota dataa esimerkiksi, että kuinka paljon ovat kuukausittaiset tulot. Ohjelma voi myös listata asiakkaat järjestykseen esimerkiksi laskutusmäärien perusteella. 
* Ohjelman voisi laajentaa kirjanpito-ohjelmaksi, joka tulostaisi eri raportteja tilinpäätöstä varten. Kirjanpito-ohjelma olisi kätevä, jos siihen voisi ladata kuvat kuiteista ja määritellä menot niiden perusteella. 
* Ohjelmassa voisi muokata menneitä laskuja, joiden tiedot tallentuisi myös kirjanpitoon. 
* Samalle tilille voisi olla useampi käyttöoikeus. 
* Ohjelmaan voisi kehittää laskimen, joka laskisi valmiiksi loppusumman alvin ja tuotteen hinnan pohjalta. 
* Laskin voisi toimia myös niin, että täyttämällä loppusumman ja valitsemalla alvin myös veroton summa täyttyisi. 

# Käyttöympäristö <h3> 
* Teen ohjelman ensisijaisesti OSX:lle. Mikäli laajentaminen myös Linuxille ja  Windowsille on helppoa, niin sitä voi harkita aikataulun sallimissa rajoissa. 




