create or replace trigger MeresiAdatokFigyelo before update on meresiadatok for each row
begin
    if (:new.homerseklet >= 50 OR :new.homerseklet <= -20) then
      :new.homerseklet := :old.homerseklet;
      dbms_output.put_line('A h?mérséklet modosítás nem lépheti át az 50 és -20 határt!');
    end if;
end;