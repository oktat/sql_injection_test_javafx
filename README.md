# SQL injekció

SQL injekció teszteléséhez, bemutatásához.

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
