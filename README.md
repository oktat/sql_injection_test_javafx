# SQL injekció

SQL injekció teszteléséhez, bemutatásához.

A program a sikeres vagy sikertelen bejelentkezést a konzolon közli.

## Telepítés

* Hozzunk létre a projekt gyökérkönyvtárában egy database.sqlite fájlt.
* Használjuk a datatabase/database.sqlite fájlban található SQL utasításokat.

## Tennivalók

* Az adatbázisban a jelszót kódolni kell.
* A UI felületen a jelszót PasswordField-ben kell bekérni.

## Felhasználók

* admin:titok
* janos:titok

## Injekció

SQL injekció példa:

* admin' --
* ' or 1=1 --

Az első változatnál ismerni kell a felhasználót, a másodiknál azt sem.

## Állítási lehetőség

A src/main/java/lan/zold/models/UserSource.java fájlban beállítható, hogy Statement vagy PreperedStatement osztállyal legyen megvalósítva az adatbázis elérés.

A Statemen használata, ami nem véd az SQL injekció ellen:

```java
final boolean PREPARED = false;
```

Ha szeretnék védelmet bemutatni, akkor állítsuk **true** értékre.
