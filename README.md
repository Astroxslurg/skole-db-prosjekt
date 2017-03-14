# Treningsdagbok

- [Usecases implementert](#usecases-implementert)
- [Brukergrensesnitt](#brukergrensesnitt)
  * [Legge til øvelse](#legge-til-øvelse)
  * [Sette et mål](#sette-et-mål)
  * [Lagre et resultat](#lagre-et-resultat)
- [Limitasjoner](#limitasjoner)
## Usecases implementert

Vi har implementert følgende usecases:
 - Legge til en ny øvelse
 - Sette seg et mål knyttet til en øvelse
 - Lagre et resultat knyttet til en øvelse

## Brukergrensesnitt

Brukergrensesnittet består av tre faner: Øvelse, Mål og Resultat. Disse fanene inneholder grensesnitt for å legge til de respektive objektene i databasen.

### Legge til øvelse

Man legger til en ny øvelse ved å fylle ut skjemaet i øvelse-fanen og trykke på knappen kalt "Legg til øvelse"

### Sette et mål

Velg først hvilken øvelse du skal sette et mål for.
Fyll så ut skjemaet og trykk "Legg til Mål" for å legge til målet.

### Lagre et resultat

Velg hvilken øvelse som har blitt utfylt og fyll så ut det korresponderende skjemaet. Resultatet blir lagt til når man trykker på "Legg til resultat"

## Limitasjoner

- Man kan ikke velge gruppe for øvelsen, siden gruppetabellen ikke har blitt implementert.
- Man antar at brukeren ikke har koblet til noen pulsklokke, og har valgt å se helt bort i fra pulsverdier for nå.
- Man kan ikke legge til en belastning høyere enn 99.9, da vi kke har implementert kompatibilitet for veldig sterke folk enda.
