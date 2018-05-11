Pakkausrakenne 

![pakkausrakenne](https://github.com/jokineno/otm-harjoitustyo/blob/master/dokumentaatio/kuvat/pakkausrakenne.png "Pakkausrakenne")


Luokkakaavio

![luokkakaavio](https://github.com/jokineno/otm-harjoitustyo/blob/master/dokumentaatio/kuvat/luokkakaavio.png "Luokkakaavio")


Sekvenssikaavio 

![sekvenssikaavio](https://github.com/jokineno/otm-harjoitustyo/blob/master/dokumentaatio/kuvat/laskutusohjelma%20sekvenssikaavio.png "Sekvenssikaavio")


# Päätoiminallisuudet <h2> 

Käyttäjän kirjautuminen: 

Kun loginScenessä kirjautumiskenttään on syötetty nimi, niin invoiceService etsii userDaon avulla tietokannasta nimen. 
Jos nimi löytyy käyttäjä kirjautuu sisään ja jos nimeä ei löydy, niin konsoliin tulostuu teksti "NOT GONNA HAPPEN". 


Käyttäjän luominen: 

Samalla periaatteella toimii käyttäjän luominen. Ainoa pakollinen täytettävä kenttä on käyttäjätunnus, joka pitää käyttäjää luodessa olla uniikki ja olemassa. 


Laskun luominen: 

Käyttäjä voi valita asiakaslistasta asiakkaan. Asiakkaan tiedot täyttyvät vastaanottaja ja yTunnus kohtaan. 

Laskua luodessa pakolliset täytettävät kentät ovat hinta ja määrä tekstikentät. Jos niiden formaatti on väärin, niin ohjelma tulostaa käyttäjälle virheilmoituksen konsoliin. 

Laskun luominen näkyy käyttäjälle uutena tiedostona PDFFiles -kansiossa. 


Profiilin muutokset: 

Profiilin muutokset voi tehdä profilescenessä. Kun käyttäjä muokkaa tekstikenttiä ja painaa save changes, niin muutokset näkyvät kentissä välittömästi. Näitä tietoja ei tarkisteta tietokannasta. 




# Käyttöliittymä <h2> 

Käyttöliittymä sisältää 4 näkymää
- kirjautumisnäkymä
- uuden käyttäjän luonti
- laskun tekeminen
- profiilin muokkaus 
 

jokainen näistä on toteutettu omana -scene oliona. Näkymistä on ainoastsaan yksi kerrallaan näkyvissä. Käyttöliittymä on rakennettu ohjelmallisesti luokassa laskutusohjelma.ui.Paaohjelma

# Sovelluslogiikka <h2>

Sovelluslogiikan muodostaa InvoiceService -luokka, joka käyttää muita luokkia toteutuksessaan. 

Käytettäviä luokkia ovat:
- product,
- customer,
- user
- FileUserDao,
- FileAsiakasDao,
- SQLiteDatabase,
- PdfCreator -luokat. 


# Tietojen talletus <h2>
Luodut pdf tiedostot tallentuvat paikallisesti.
 
Asiakas -ja käyttäjärekisteri tallentuu tietokantaan. 

Pakkauksen laskutusohjelma.dao luokat FileAsiakasDao ja FileUserDao huolehtivat tietojen tallettamisesta tietokantaan.

Luokat noudattavat Data Access Object -suunnittelumallia ja ne on tarvittaessa mahdollista korvata uusilla toteutuksilla, jos sovelluksen datan talletustapaa päätetään vaihtaa. FileUserDao ja FileAsiakasDao ovat rajapintojen AsiakasDao ja UserDao takana.

# Tiedostot <h2> 

Sovellus tallettaa tiedostot config.properties -tiedostossa määritellyllä tavalla. 
mainDatabaseFile=asiakasrekisteriDB.db
testDatabaseFile=test.db

# Heikkoudet <h2> 

Pääluokan "Paaluokka" metodit setinvoiceScene ja setInvoicescene2 sisältävät toisteista koodia. Samoin profileScene ja profileScene2. 
Ne ovat luotu siksi, että kun näkymästä loginScene siirrytään invoiceScenee, niin setInvoiceScene2 avulla voidaan ladata comboBoxin ja käyttäjän tiedot. 
setInvoiceScene metodilla en saanut tätä toimimaan. 

Sama ongelma oli profileScenen kanssa. 


Tällä toteutuksella ohjelma kuitenkin toimii. 
