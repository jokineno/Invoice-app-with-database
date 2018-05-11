# Käyttöohje <h2>

Lataa tiedosto laskutusohjelma.jar

# Ohjelman käynnistäminen <h2> 

Ohjelma käynnistetään komennolla 

java -jar laskutusohjelma.jar

# Ilmoitusten seuraaminen <h2> 

Ilmoitukset tulevat konsoliin. 

- Esimerkiksi jos yrität kirjautua ohjelmaan käyttäjätunnuksella, joka ei ole olemassa, niin konsoliin tulostuu "NOT GONNA HAPPEN". 
- Seuraa siis konsolia aina, jos on epäselvä tilanne. 


# Kirjautuminen <h2>

Sovellus käynnistyy kirjautumisnäkymään 

Kirjautuminen onnistuu kirjoittamalla vain käyttäjätunnus. Jos käyttäjää ei ole vielä luotu, niin voit mennä signup osioon, johon täyttämällä voit luoda tunnukset ja kirjautua sovellukseen.
Ainoa pakollinen täytettävä tekstikenttä on ylin tekstikenttä eli "username". Ilman sitä käyttäjän luominen ei onnistu.
Jos yrität luoda käyttäjätunnuksen, joka on jo olemassa, ohjelma tulostaa "empty username or username is already in use".  


# Laskun luominen <h2> 

Laskun luominen onnistuu, kun täytät kysytyt kentät. Painamalla create pdf invoice, ohjelma luo pdf laskun antamiesi tietojesi perusteella. 
PDF pohja on vielä hyvin yksinkertainen, mutta siinä on yksinkertaiseen sähköpostilla tai postitse lähetettävään laskuun tarvittavat kentät.

"price per unit", "amount", "vat", "finalPrice" -kentät tulee täyttää numeroilla. Jos tekstikentissä ei ole numeroita, niin ohjelma ei suostu luomaan pdf tiedostoa. 

* "price per unit" - double - esim 10.2

* "amount" - double - esim 10

* "vat" - integer - esim 0, 10, 14, 24

* "finalPrice" - double - esim 102.0 

Laskupohja on pdf-muotoinen tiedosto, jossa on valmiiksi täytettynä lähettäjän tiedot. 

# Asiakkaan valitseminen <h2> 

Jos haluat valita asiakkaan, niin paina "Select Customer". Valitsemalla asiakkaan, laskukentän "receiver" ja "yNumber" - osiot täyttyvät valinnan tiedoilla. 

Jos haluat luoda uuden asiakkaan, niin paina "add new customer". Täyttämällä tiedot asiakas tallennetaan tietokantaan. Tietokannassa oleva asiakkaat ilmestyvät "select customer" -pudostusvalikkoon. 


# Profiilin muokkaus <h2> 

Käyttäjä ei voi vaihtaa käyttäjänimeään. 
Kun käyttäjä on profile -scenessä, niin pankkiyhteys, y-tunnus ja yrityksen nimi tiedot ovat täytettyinä kirjautumistietojen perusteella. 
Vaihtamalla y-tunnusta, pankkiyhteyttä tai yrityksen nimeä voit täyttää tekstikentät ja painaa "save changes". Nämä tiedot tallentuvat tietokantaan ja tulevat valmiina laskupohjaan.

# Liikkuminen scenejen välillä <h2> 

Näkymän vaihtaminen on yksinkertaista. 
* Login -> SignUp - paina signUp
* SignUp-> Login - paina back to main 
* Login -> invoiceView -> paina login (oikea käyttäjätunnus ehtona) 
* invoiceView -> Profile -> paina Profile
* invoiceView -> Login -> paina logout
* SignUp->InvoiceView -> paina create account (tekstikentät oikein täytettynä on ehto siirtymiselle)
* Profile -> profile -> save changes 
* Profile -> invoiceView -> back 
