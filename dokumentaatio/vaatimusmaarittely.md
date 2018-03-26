# Vaatimusmäärittely <h1>

# Sovelluksen tarkoitus <h3>

Harjoitustyönä teen laskutusohjelman pienyritykselle. Ohjelmalla voi kirjoittaa laskun. Laskutusohjelmalla voi olla useita käyttäjiä, joilla on omat asiakasrekisterinsä, joita ylläpidetään tietokannassa. 

# Käyttäjät <h3> 
* Ainakin aluksi sovelluksella on vain yksi käyttäjärooli eli _normaali käyttäjä_. Käyttäjiä voi olla monia, joilla on omat asiakasrekisterinsä ja laskutushistoriansa. Myöhemmin lisättävällä _pääkäyttäjällä_ on oikeus tehdä muokkauksia ohjelmaan. Pääkäyttäjä voi myös tarkastella ohjelman käyttödataa. Lue ylläpitäjä. 

# Ylläpitäjä <h3> 
* Ylläpitäjä voi tarkastella erilaisia tilastoja, kuten laskutusmääriä, käyttäjämäärää jne. 
* Ylläpitäjä voi myös poistaa käyttäjiä. 

# Toiminnallisuudet <h3> 

* Käyttäjä voi luoda tunnuksen ja kirjautua. 

* Käyttäjä voi lisätä itselleen omat tietonsa, jotka tallentuvat suoraan laskupohjaan. Täten oman yrityksen tietoja ei tarvitse aina erikseen lisätä laskupohjaan. Esimerkiksi yrityksen nimi, y-tunnus, tilinumero, pankkiyhteys jne. 

* Sovelluksessa voi luoda laskun. Laskua luodessa voi valita "pudotusvalikosta" asiakkaan tai luoda uuden asiakkaan. 

* Asiakkaat tallentuvat tietokantaan, jossa on asiakkaasta pidetään tallessa: nimi, y-tunnus, osoitetiedot tai pelkkä sähköpostiosoite. 

* Sovelluksessa on myös viitenumerogeneraattori, joka generoi jokaiseen laskuun aina uuden viitenumeron. 

* Ajatuksena on myös, että ohjelma erittelee arvonlisäveron määrän. Esimerkiksi, jos valitsen, että arvonlisävero on 24% ja merkitsen loppusumman, niin ohjelma osaa laskea verottoman summan itsestään. Sama päinvastoin eli jos ohjelmaan laitetaan veroton summa ja sen jälkeen valitaan arvonlisävero, niin ohjelma antaa loppusummaksi arvonlisäverollisen summan. 

* Ohjelmassa voi myös selata lähetettyjä laskuja sekä asiakkaita. 



# Jatkokehitysideat <h3>

* Ohjelma voi tarjota dataa esimerkiksi, että kuinka paljon ovat kuukausittaiset tulot. Ohjelma voi myös listata asiakkaat järjestykseen esimerkiksi laskutusmäärien perusteella. 
* Ohjelman voisi laajentaa kirjanpito-ohjelmaksi, joka tulostaisi eri raportteja tilinpäätöstä varten. Kirjanpito-ohjelma olisi kätevä, jos siihen voisi ladata kuvat kuiteista ja määritellä menot niiden perusteella. 
* Ohjelmassa voisi muokata menneitä laskuja, joiden tiedot tallentuisi myös kirjanpitoon. 
* Samalle tilille voisi olla useampi käyttöoikeus. 

# Käyttöympäristö <h3> 
* Teen ohjelman ensisijaisesti OSX:lle. Mikäli laajentaminen myös Linuxille ja  Windowsille on helppoa, niin sitä voi harkita aikataulun sallimissa rajoissa. 




