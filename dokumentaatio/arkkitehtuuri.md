Pakkausrakenne 

![pakkausrakenne](https://github.com/jokineno/otm-harjoitustyo/blob/master/dokumentaatio/kuvat/pakkausrakenne.png "Pakkausrakenne")


Luokkakaavio

![luokkakaavio](https://github.com/jokineno/otm-harjoitustyo/blob/master/dokumentaatio/kuvat/luokkakaavio.png "Luokkakaavio")


Sekvenssikaavio 

![sekvenssikaavio](https://github.com/jokineno/otm-harjoitustyo/blob/master/dokumentaatio/kuvat/laskutusohjelma%20sekvenssikaavio.png "Sekvenssikaavio")


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


