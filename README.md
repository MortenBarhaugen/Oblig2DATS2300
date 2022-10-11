# Obligatorisk oppgave 2 i Algoritmer og Datastrukturer

Denne oppgaven er en innlevering i Algoritmer og Datastrukturer. 
Oppgaven er levert av følgende studenter:
* Morten Barhaugen, S364518, s364518@oslomet.no
* Lars Eknes, S362090, s362090@oslomet.no

# Arbeidsfordeling

I oppgaven har vi hatt følgende arbeidsfordeling:
* Morten har hatt hovedansvar for oppgave 1, 2, 3, 4 og 5. 
* Lars har hatt hovedansvar for oppgave 6, 7, og 8. 

# Oppgavebeskrivelse

I oppgave 1 så gikk vi frem ved å fylle inn metodene antall() og tom(). For antall er det bare å returne antallet siden verdien til antall oppdateres i andre metoder.
For å lage tom() er det bare å sjekke om antall er 0. Hvis antall er 0 så er tabellen tom og vi returnerer true, hvis antall ikke er 0 returneres false.
I konstruktøren sjekker vi om tabellen er tom, så finner vi første og siste element som ikke er en null-verdi. Så oppdaterer vi resten av nodene og pekerne.

I oppgave 2 så brukte vi StringBuilder til å bygge tegnstrenger med verdiene i tabellen. Her brukte vi toString-metoden fra kompendiet, løsningsforslag for oppgave 2 i  kap. 3.3.2: https://www.cs.hioa.no/~ulfu/appolonius/kap3/3/fasit332.html. Her legges alle verdier til så lenge det ikke er en null-verdi.
I omvendtString-metoden gjøres mye av det samme som i toString-metoden. Forskjellen her er at den starter i halen (den bakerste noden) og jobber seg bakover til hodet (den første noden).

I oppgave 3 a) fyller vi inn finnNode(). Her sjekker vi først om vi skal lete fra hode og gå mot høyre eller om vi skal lete fra halen og gå mot venstre. Dette gjøres ved if(indeks < antall() / 2).
Så looper vi gjennom et intervall som er bestemt av om vi begynner fra hode eller hale, og hvilken indeks vi ønsker. Til slutt returneres noden i den gitte indeksen.
I oppgave 3 b) sjekkes først om parameterne fra og til er gyldige. Her kastes tre ulike feilmeldinger avhengig av verdiene til fra og til. Hvis parameterne har lovlige verdier lages en ny DobbeltLenketListe og så legges alle verdiene fra det gitte intervallet inn i den nye listen.

I oppgave 4 brukte vi metodene fra kompendiet som utgangspunkt, løsningsforslag for oppgave 2 i kap. 3.3.3: https://www.cs.hioa.no/~ulfu/appolonius/kap3/3/fasit333.html.
Her sjekkes først om parameterverdien er en null-verdi. Hvis den er det returneres -1. Hvis den ikke er en null-verdi looper vi gjennom hele listen til vi finner verdien og returnerer så indeksen.
Hvis verdien ikke finnes i listen returneres -1. I inneholder() kan vi derfor bare sjekke om indeksTil() har returnert -1 eller ikke. Hvis den ikke har returnert -1 er inneholder() true.

I oppgave 5 sjekker vi først om parameterverdien verdi er en null-verdi, og hvis den er det kastes en feilmelding som gir tilbakemelding om det. Hvis verdien som skal legges inn er gyldig, sjekkes først om antall er 0. Hvis det stemmer, blir hode og hale satt til den nye verdien siden det da er den eneste verdien i listen.
Hvis antall ikke er 0 looper vi gjennom til slutten av listen og legger til den nye verdien på slutten av listen.

I oppgave 6 sjekker vi først med boolean som først finner hvor verdien vi søker etter ligger i den lenkede listen med compare siden det kan være ord, navn, tall etc. Og så fjerner vi hvis det finner, det er forskjellige if-statements for forksjellige situasjoner av en fjerning. Kommer ann på om verdien er i starten, slutten eller mellom to verdier. Returverdi blir da true. For fjerning på indeks så gjør vi nesten det samme bare at vi har indeksen fra før så nå er det lettere å velge hvilken side vi skal starte fra og itererer fra hale/hode og til ønsket verdi og fjerner på samme måte som i forrige bare med retur verdi av det vi fjerna.

I oppgave 7 i Metode 1 er det egentlig bare fjerning etterhvert som man flytter seg framover. Den er ganske effektiv fordi man flytter seg stadig fremover og bare fjerner den neste verdien uten så mye ekstra omregninger eller if-setninger. Mens Metode 2 er mindre effektiv fordi den gjør metodekall og er generelt mindre effektiv i kjøringen sin som vist i sekundene det tok å utføre testene som er skrevet i kommentarer i DobbeltLenketListe programmet.

I oppgave 8a så programmerte vi til å sjekke at endringene var like og at den stoppet når den ikke hadde en neste verdi.
8b så implementerte vi at den skulle returnere DobbeltLenketListeIterator uten indeks.
8c først implementerte vi at den skulle finne posisjonen til indeksen vår og så satte vi denne lik den posisjonen som ble funnet og kopierte resten fra den andre konstrøktoren som sagt i oppgaven.
8d så implementerte vi først indeksKontrollen så den ikke returener feil, og så implementerte vi at den skulle returnere DobbeltLenketListeIterator uten indeks.
