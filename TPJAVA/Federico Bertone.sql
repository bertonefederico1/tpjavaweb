#DDL
#EN EL ENUNCIADO NO DECIA QUE LA BD ESTABA INCOMPLETA, SIN EMBARGO LA TABLA CHOFERES_TURNOS ESTABA INCOMPLETA, TUVE QUE COMPLETARLA
ALTER TABLE `manolo_carpa_tigre`.`choferes_turnos` 
ADD PRIMARY KEY (`cuil`, `cod_turno`, `fecha_turno`),
ADD INDEX `fk_choferesTurnos_turnos_idx` (`cod_turno` ASC) VISIBLE;
;
ALTER TABLE `manolo_carpa_tigre`.`choferes_turnos` 
ADD CONSTRAINT `fk_choferesTurnos_choferes`
  FOREIGN KEY (`cuil`)
  REFERENCES `manolo_carpa_tigre`.`choferes` (`cuil`)
  ON DELETE RESTRICT
  ON UPDATE CASCADE,
ADD CONSTRAINT `fk_choferesTurnos_turnos`
  FOREIGN KEY (`cod_turno`)
  REFERENCES `manolo_carpa_tigre`.`turnos` (`cod_turno`)
  ON DELETE RESTRICT
  ON UPDATE CASCADE;


#EJERCICIO a (1)
CREATE TABLE `manolo_carpa_tigre`.`estados` (
  `cod_estado` INT(11) NOT NULL AUTO_INCREMENT,
  `descripcion` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`cod_estado`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_bin;


#EJERCICIO a (2)
begin;
insert into estados (descripcion)
select distinct estado from viajes;
commit;

#EJERCICIO a (3)
ALTER TABLE `manolo_carpa_tigre`.`viajes` 
ADD COLUMN `cod_estado` INT(11) NOT NULL AFTER `fecha_cancelacion`;

#EJERCICIO a (4)
begin;
	update viajes v set cod_estado = (select cod_estado from estados e where v.estado = e.descripcion);
commit;

#EJERCICIO a (5)
ALTER TABLE `manolo_carpa_tigre`.`viajes` 
ADD INDEX `fk_viajes_estados_idx` (`cod_estado` ASC) VISIBLE;
;
ALTER TABLE `manolo_carpa_tigre`.`viajes` 
ADD CONSTRAINT `fk_viajes_estados`
  FOREIGN KEY (`cod_estado`)
  REFERENCES `manolo_carpa_tigre`.`estados` (`cod_estado`)
  ON DELETE RESTRICT
  ON UPDATE CASCADE;


#DML

#EJERCICIO 1
select vm.patente, m.marca
from viajes_moviles vm
inner join moviles m
	on vm.patente = m.patente
inner join viajes v 
	on v.nro_viaje = vm.nro_viaje
where estado = "Terminado" 
and year(v.fecha_ini) = "2013" 
and year(v.fecha_fin) = "2013"
group by vm.patente, m.marca
having count(*) > 2
order by m.patente asc;

#EJERCICIO 3

drop function if exists importe_adeudado;
select importe_adeudado("cuit", "11-11111111-1");

#EJERCICIO 2
drop temporary table if exists ultimo_viaje;

create temporary table ultimo_viaje
select vc.cuil, vc.nro_viaje, max(v.fecha_fin) ult_fecha
from viajes_choferes vc
inner join choferes c
	on vc.cuil = c.cuil
inner join viajes v
	on vc.nro_viaje = v.nro_viaje
    and vc.cuil = v.cuil
where year(v.fecha_fin) = 2018 and v.nro_contrato is null and month(v.fecha_fin) = 5 and v.estado = "Terminado"
group by 1,2;

select c.cuil, c.nom_ape, ifnull(v.nro_viaje, "SIN VIAJE"), ifnull(v.fecha_ini, "SIN VIAJE"),
ifnull(t.desc_turno, "SIN VIAJE"), ifnull(tv.desc_tipo_viaje, "SIN VIAJE")
from ultimo_viaje uv
left join choferes c
	on uv.cuil = c.cuil
left join viajes v
	on v.nro_viaje = uv.nro_viaje
    and v.fecha_fin = uv.ult_fecha
left join choferes_turnos ct
	on ct.cuil = c.cuil
left join turnos t
	on ct.cod_turno = t.cod_turno
left join tipos_viajes tv
	on v.cod_tipo_viaje = tv.cod_tipo_viaje;


