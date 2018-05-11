# Testaus <h2>

Ohjelmaa on testattu yksikkötestein ja käytetty JUnittia. Myös järjestelmätason testejä on tehty.  

Sovelluksesta on testattu ennen kaikkea FileUserDaon ja FileAsiakasDaon luokat. Ne ovat keskeisessä osassa InvoiceService luokan kannalta, jossa tapahtuu ohjelman sovelluslogiikka. 

Testauksessa luodaan testitietokanta, joka määritellään config.properties tiedostossa. 

Yksikkötestit on tehty User, Customer ja Product luokille. 





# Testauskattavuus <h2>

Ohjelmassa on testattu pääosin dao-luokkaa. Sovelluslogiikan testauksessa ei ole testattu käyttöliittymää. 

Domain luokassa oli ongelmia tietokannan yhteyden kanssa, joten sen haarautuvuus on jäänyt toistaiseksi pieneksi. 

![testaus](https://github.com/jokineno/otm-harjoitustyo/blob/master/dokumentaatio/kuvat/testaus.png "testaus")

# Toiminallisuudet <h2>

Suurin osa keskeisistä toiminallisuuksista on testattu eli FileUserDaon ja FileAsiakasDaon kautta tapahtuvat toiminnot. 


# Ongelmat <h2> 

InvoiceServicen tietokantayhteydessä oli testausvaiheessa ongelmia, joten sovelluslogiikan testaaminen jäi pieneksi. Logiikka kuitenkin toimii ja se käyttää FileUserDaon ja FileAsiakasDaon luokkia, jotka toimivat testeissä. 


