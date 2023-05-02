# TeamRocketLutemonGame
Java programming cource practice work


Team RakettiUkot Dokumentaatio: 
A: Tekijät:  

Vili Jokela & Antti Kukkonen

 

B: Pelin dokumentaatio ja koodi itsessään löytyy githubista: 
https://github.com/RoNsKi88/TeamRocketLutemonGame 

Sieltä versio: Harjoitustyön palautus. 

 

C: Video ohjelman toiminnasta löytyy osoitteesta: 
https://lut-my.sharepoint.com/:v:/g/personal/vili-pekka_jokela_student_lut_fi/EdwLxlNxd7VKrEmiNDTjLWYBW2UsKsCwwHO4ZRdMo7KaiQ?e=7OIcDG 

 

Implementoidut ominaisuudet taulukossa erikseen: 

 
Yleinen kuvaus työstä: 

Lähes tehtävänannon mukainen tuote, jossa voit luoda Lutemoneja ja taistella niillä toisia (satunnaisesti luotuja) lutemoneja vastaan.  

Työssä on aloitusruutu ”hienolla” taustakuvalla, jossa voit valita, lataatko aiemman pelin tiedot ja jatkat siitä, vai aloitatko uuden pelin. Aloitettuasi pelin, päädyt valikkoruutuun. Voit valita neljästä fragmentista erilaisia toimintoja, mitä haluat tehdä. Fragmenteista löytyy seuraavat välilehdet: 

Battle välilehti, josta voit valita lähetätkö Lutemonisi taistelemaan randomBattleen vai treenaamaan. Treenatessa saat vastaasi rahapussin, joka toimii lyömäsäkkinä ja kokemuksen lähteenä lutemonillesi. RandomBattlessa sinua vastaan luodaan lutemon, joka saa boonuksena leveleitä riippuen voittojesi ja häviöidesi määrästä, sekä  vaikeusasteesta jonka valitset. Joka kymmenes taso on “boss battle” UberPixeliä vastaan. Vastustajan lutemonin nimi arvotaan ennaltamääritetystä nimilistasta. 

Battlessa Lutemonit lyövät toisiaan vuorotellen. Hyökkäävä lutemon arpoo luvun 0-Attack väliltä, lisäksi tarkastellaan onko hyökkäys kriittinen, joka tuplaa tehdyn vahingon. Normaalisti kriittinen mahdollisuus osua on 10%, mutta Oranssilla se on 20%. Saadusta luvusta vähennetään puolustavan lutemonin arpoma luku väliltä 0-Defence väliltä. 
Jos lutemon on elossa hyökkäyksen jälkeen, roolit vaihtuvat ja puolustaja hyökkää takaisin samalla periaatteella. 

Pelaajan lutemon kasvaa tasoja jo taistelun aikana. Lutemon saa kokoemuspisteitä tehdyn vahingon mukaan (vaikeus aste vaikuttaa kertoimella saatavaan kokemuspistemäärään.). Jokaista tason noususta kokemuspiste raja nousee ja vaatii 1.1 kertoimellisen määrän saadakseen seuraava tason nousu. Kun lutemonin kokemuspisteet ylittävät kokemuspisterajan ohjelma arpoo lutemonille attack, defence tai maxHp atribuutteja saadun tason nousun mukaisen määrän. Esim. Lutemon pääsee tasolle 10. Niin hän saa yhteensä 10 atribuuttia lisää. 1 atribuutti on arvoltaan joko 1 attack, 1 defence tai 2 maxHp:n arvoinen. 

Hyökkäykset ovat animoituja, jossa hyökkääjän kuva käy puolustajan päällä ja palaa alkuperäiseen kohtaansa. Puolessavälissä hyökkäystä alkaa lutemon jo pyörätämään, että animaatio näyttää lyönniltä. Samalle hetkellä, kun lutemon lähtee palaamaan omalle sijainnilleen ilmestyy hyökätyn lutemonin päälle tehty vahingon määrä. Samalla päyvittyy myös puolustavan lutemonin elämäpisteet ja “HP progress bar”. 

Kun toinen Lutemon kuolee, taistelu on päättynyt ja keskelle ruutua tulee ilmoitus, jossa kerrotaan voititko vai hävisitkö. Myös jos kyseessä oli HC-hahmo, kerrotaan että se on päätynyt hautausmaalle.  

  

Pick lutemon välilehti listaa varastossa olevat Lutemonit ja kertoo niiden statsit ja muut tiedot. Halutessasi voit vaihtaa pelaajalla käytössä olevaa lutemonia tällä ruudulla. Näkymä tulostaa listan lutemoneista recyclerview näkymään, josta klikkaamalla valittu lutemon siirtyy pelaajalle käyttöön ja aiempi palaa takaisin listalle: 

 

aikaisempi käyttäjän lutemon lisätään listaan 

Varastosta asetetaan pelaajalle käyttöön lutemon (aiempi ylikirjoitetaan) 

Indeksin mukainen (eli valittu) lutemon poistetaan listalta. 

 

Create Lutemon välilehdellä voit luoda uusia lutemoneja(Gray, Green, Orange, Pink, Rainbow). Luodut lutemonit laitetaan varastoon, jotka näkyvät aiemmalla pick lutemon sivulla. Sivulle tulostuu kuva käytettävästä lutemonista, sen olennaisimmat statsit (maxHP, Attack, Defence, special) nimikenttä, jolla voit nimetä lutemonin, tai jättää sen tyhjäksi jolloin sille generoituu nimi esivalituista nimistä. Lutemonia luodessa hyödynnetään periytymistä, jolloin luodaan tietyn värinen Lutemon, jonka saa siihen väriin liittyvät statsit ja muut ominaisuudet. Väriä voidaan näin hyödyntää myöhemmin mm. taistelussa, jos tarkastellaan instanceof metodilla onko jokin lutemon esimerkiksi ”harmaa”, jolloin se voi saa puolustaessaan kaksi yritystä puolustaa, joista suurempi arvo jää voimaan. Tai jos olisimme halunneet tehdä asian toisella tapaa, olisimme voineet luoda jokaiselle periytyvälle Lutemonille oman hyökkäys/puolustus metodin, jota olisimme voineet hyödyntää taistelussa. Tällä kertaa toteutimme metodin vain Pixeli-luokan lutemonille. 

 

Graveyard – välilehdelle menee kaikki kuolleet lutemonit(HC-valitut), jotka lisitataan myöskin recycler viewillä.  

 

Työn jakautuminen osallistujien kesken: 

Työssä on melko hankala arvioida, että kuka teki ja mitä kokonaisuuksia. Alusta asti lähdimme rakentamaan tuotetta yhdessä, mikä muovautui ajan kuluessa nykyiseen muotoonsa. Ehkä suuremmista kokonaisuuksista Vili teki BattleActivityn ja antti teki CreateLutemonFragmentin, Load ja Save game metodit.  

Ja näitäkin tehdessä on puolin ja toisin autettu toisiamme. 

 
