create or replace trigger MeresiAdatokFigyelo before update on meresiadatok for each row
begin
    if (:new.homerseklet >= 50 OR :new.homerseklet <= -20) then
      :new.homerseklet := :old.homerseklet;
      dbms_output.put_line('A h?m�rs�klet modos�t�s nem l�pheti �t az 50 �s -20 hat�rt!');
    end if;
end;