DECLARE    
   n3 number;
   adat meroeszkoz%ROWTYPE;
BEGIN
   n3 := egyEszkozAtlagHomerseklet(1);
   adat := eszkozAdatok( 1 );
   dbms_output.put_line('Egy eszkoz átlag hömérséklete: ' || n3); 
   DBMS_OUTPUT.PUT_LINE('Egy sor adatai: ' || adat.eszkozkulcs || ' ' || adat.gyartas_ido || ' ' || 
   adat.magassag || ' ' || adat.irszam || ' ' || adat.varos || ' ' || adat.utca || ' ' || adat.hazszam
   || ' ' || adat.tipus || ' ' || adat.gyarto);
END;

Set SERVEROUTPUT ON