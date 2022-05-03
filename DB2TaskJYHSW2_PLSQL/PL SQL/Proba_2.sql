DROP TRIGGER MeresiAdatMod;
SELECT * FROM meroeszkoz;
SELECT * FROM meresiadatok;
update meroeszkoz set gyartas_ido = p_ujgyartas_ido, magassag = p_ujmagassag,
        irszam = p_ujirszam, varos = p_ujvaros, utca = p_ujutca, hazszam = p_ujhazszam,
        tipus = p_ujtipus, gyarto = p_ujgyarto where eszkozkulcs = p_eszkozkulcs;
UPDATE meresiadatok SET homerseklet = 20 WHERE MERESIADATKULCS = 1;
SELECT * FROM Naplo;
BEGIN
   ujEszkoz(6,2017,2,3505,'Miskolc','Árpád utca',14,'y19','SPEC SENSORS');
END;
BEGIN
   eszkozModositas(1,2017,2,3505,'Miskolc','Árpád utca',14,'y19','SPEC SENSORS');
END;
BEGIN
   Eszkoztorles(6);
END;
BEGIN
   ujEszkoz2(2019,2,3502,'Miskolc','Árpád utca',11,'y19','SPEC SENSORS');
END;

DECLARE
  adat ACCOUNT1%ROWTYPE;
BEGIN
  adat := eszkozAdatok( 1 );
  DBMS_OUTPUT.PUT_LINE( adat.gyartas_ido );
END;
