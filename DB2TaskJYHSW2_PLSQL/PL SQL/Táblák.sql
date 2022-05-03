Create table telephely (
telepkulcs number primary key NOT NULL,
telefonszam varchar(11),
irszam number,
varos varchar(30),
utca varchar(30),
hazszam number
);
Create table meroeszkoz (
eszkozkulcs number primary key NOT NULL,
gyartas_ido number,
magassag number,
irszam number,
varos varchar(30),
utca varchar(30),
hazszam number,
tipus varchar(30),
gyarto varchar(30)
);
Create table szerelo (
szerelokulcs number primary key NOT NULL,
nev varchar2(30),
javitas_határido date,
telepkulcs number,
CONSTRAINT fk_telephely
    FOREIGN KEY (telepkulcs)
    REFERENCES telephely(telepkulcs)
);
Create table meresiadatok(
meresiadatkulcs number primary key NOT NULL,
homerseklet number,
meres_ideje date,
paratartalom number,
szallopor number,
kendioxid number,
szenmonoxid number,
nitrogéndioxid number,
eszkozkulcs number,
CONSTRAINT fk_meroeszkoz
    FOREIGN KEY (eszkozkulcs)
    REFERENCES meroeszkoz(eszkozkulcs)
);
Create table karbantartas(
karbantartas_azonosito number primary key NOT NULL,
datum date,
eszkozkulcs number,
telepkulcs number,
szerelokulcs number,
CONSTRAINT fk_meroeszkoz_2
    FOREIGN KEY (eszkozkulcs)
    REFERENCES meroeszkoz(eszkozkulcs),
CONSTRAINT fk_telephely_2
    FOREIGN KEY (telepkulcs)
    REFERENCES telephely(telepkulcs),
CONSTRAINT fk_szerelo
    FOREIGN KEY (szerelokulcs)
    REFERENCES szerelo(szerelokulcs)
);

Drop Table TELEPHELY;
Drop Table meroeszkoz;
Drop Table szerelo;
Drop Table meresiadatok;
Drop Table karbantartas;