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
