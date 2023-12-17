--1
-- Trigger to update Analisis_Familias when Familias is inserted, updated, or deleted
CREATE OR REPLACE FUNCTION update_analisis_familias()
RETURNS TRIGGER AS
$$
BEGIN
    -- Delete from Analisis_Familias if a record is deleted in Familias
    IF TG_OP = 'DELETE' THEN
        DELETE FROM Analisis_Familias WHERE cf = OLD.cf;

    -- Update Analisis_Familias if a record is updated in Familias
    ELSIF TG_OP = 'UPDATE' THEN
        UPDATE Analisis_Familias SET cantidad = NEW.cantidad WHERE cf = NEW.cf;

    -- Insert into Analisis_Familias for new records in Familias
    ELSIF TG_OP = 'INSERT' THEN
        INSERT INTO Analisis_Familias (cf, cantidad) VALUES (NEW.cf, NEW.cantidad);
    END IF;

    RETURN NEW;
END;
$$
LANGUAGE plpgsql;

-- Trigger for Familias table (for insert, update, and delete)
CREATE TRIGGER trigger_update_analisis_familias
AFTER INSERT OR UPDATE OR DELETE
ON Familias
FOR EACH ROW
EXECUTE FUNCTION update_analisis_familias();

select * from Familias
select * from analisis_familias

--2
-- Trigger to update Analisis_Beneficiario when Beneficiario is inserted, updated, or deleted
CREATE OR REPLACE FUNCTION update_analisis_beneficiario()
RETURNS TRIGGER AS
$$
BEGIN
    -- Delete from Analisis_Beneficiario if a record is deleted in Beneficiario
    IF TG_OP = 'DELETE' THEN
        DELETE FROM Analisis_Beneficiario WHERE cid = OLD.cid;

    -- Update Analisis_Beneficiario if a record is updated in Beneficiario
    ELSIF TG_OP = 'UPDATE' THEN
        UPDATE Analisis_Beneficiario
        SET edad = NEW.edad,
            sexo = NEW.sexo,
            fechaExpedido = NEW.fechaExpedido,
            ingreso = NEW.ingreso,
            educacion = NEW.educacion
        WHERE cid = NEW.cid;

    -- Insert into Analisis_Beneficiario for new records in Beneficiario
    ELSIF TG_OP = 'INSERT' THEN
        INSERT INTO Analisis_Beneficiario (cid, edad, sexo, fechaExpedido, ingreso, educacion)
        VALUES (NEW.cid, NEW.edad, NEW.sexo, NEW.fechaExpedido, NEW.ingreso, NEW.educacion);
    END IF;

    RETURN NEW;
END;
$$
LANGUAGE plpgsql;

-- Trigger for Beneficiario table (for insert, update, and delete)
CREATE TRIGGER trigger_update_analisis_beneficiario
AFTER INSERT OR UPDATE OR DELETE
ON Beneficiario
FOR EACH ROW
EXECUTE FUNCTION update_analisis_beneficiario();


--3
-- Trigger to update Analisis_FormularioRegistro when FormularioRegistro is inserted, updated, or deleted
CREATE OR REPLACE FUNCTION update_analisis_formulario_registro()
RETURNS TRIGGER AS
$$
BEGIN
    -- Delete from Analisis_FormularioRegistro if a record is deleted in FormularioRegistro
    IF TG_OP = 'DELETE' THEN
        DELETE FROM Analisis_FormularioRegistro WHERE cfr = OLD.cfr;

    -- Update Analisis_FormularioRegistro if a record is updated in FormularioRegistro
    ELSIF TG_OP = 'UPDATE' THEN
        UPDATE Analisis_FormularioRegistro
        SET lugar = NEW.lugar,
            fechaRegistro = NEW.fechaRegistro,
            telefono = NEW.telefono,
            paisOrigen = NEW.paisOrigen,
            fechaDeSalida = NEW.fechaDeSalida,
            transporte = NEW.transporte,
            razon = NEW.razon,
            fechaDeIngreso = NEW.fechaDeIngreso,
            fronteroDeIngreso = NEW.fronteroDeIngreso,
            documentoDeIngreso = NEW.documentoDeIngreso,
            diasDePermanencia = NEW.diasDePermanencia,
            destinoFinal = NEW.destinoFinal,
            paisSiguiente = NEW.paisSiguiente,
            porquePais = NEW.porquePais,
            alojamiento = NEW.alojamiento,
            envioDinero = NEW.envioDinero,
            sustento = NEW.sustento,
            leEnvianDinero = NEW.leEnvianDinero,
            medioEnvioDinero = NEW.medioEnvioDinero,
            comoSeComunicaFamilia = NEW.comoSeComunicaFamilia,
            transito = NEW.transito,
            refugio = NEW.refugio,
            atencion = NEW.atencion
        WHERE cfr = NEW.cfr;

    -- Insert into Analisis_FormularioRegistro for new records in FormularioRegistro
    ELSIF TG_OP = 'INSERT' THEN
        INSERT INTO Analisis_FormularioRegistro (
            cfr, lugar, fechaRegistro, telefono, paisOrigen, fechaDeSalida,
            transporte, razon, fechaDeIngreso, fronteroDeIngreso, documentoDeIngreso,
            diasDePermanencia, destinoFinal, paisSiguiente, porquePais, alojamiento,
            envioDinero, sustento, leEnvianDinero, medioEnvioDinero, comoSeComunicaFamilia,
            transito, refugio, atencion
        )
        VALUES (
            NEW.cfr, NEW.lugar, NEW.fechaRegistro, NEW.telefono, NEW.paisOrigen, NEW.fechaDeSalida,
            NEW.transporte, NEW.razon, NEW.fechaDeIngreso, NEW.fronteroDeIngreso, NEW.documentoDeIngreso,
            NEW.diasDePermanencia, NEW.destinoFinal, NEW.paisSiguiente, NEW.porquePais, NEW.alojamiento,
            NEW.envioDinero, NEW.sustento, NEW.leEnvianDinero, NEW.medioEnvioDinero, NEW.comoSeComunicaFamilia,
            NEW.transito, NEW.refugio, NEW.atencion
        );
    END IF;

    RETURN NEW;
END;
$$
LANGUAGE plpgsql;

-- Trigger for FormularioRegistro table (for insert, update, and delete)
CREATE TRIGGER trigger_update_analisis_formulario_registro
AFTER INSERT OR UPDATE OR DELETE
ON FormularioRegistro
FOR EACH ROW
EXECUTE FUNCTION update_analisis_formulario_registro();


--4
-- Trigger to update Analisis_PMH when PMH is inserted, updated, or deleted
CREATE OR REPLACE FUNCTION update_analisis_pmh()
RETURNS TRIGGER AS
$$
BEGIN
    -- Delete from Analisis_PMH if a record is deleted in PMH
    IF TG_OP = 'DELETE' THEN
        DELETE FROM Analisis_PMH WHERE cpmh = OLD.cpmh;

    -- Update Analisis_PMH if a record is updated in PMH
    ELSIF TG_OP = 'UPDATE' THEN
        UPDATE Analisis_PMH
        SET accionRealizada = NEW.accionRealizada,
            derivado = NEW.derivado,
            instruccion = NEW.instruccion,
            fecha = NEW.fecha
        WHERE cpmh = NEW.cpmh;

    -- Insert into Analisis_PMH for new records in PMH
    ELSIF TG_OP = 'INSERT' THEN
        INSERT INTO Analisis_PMH (cpmh, accionRealizada, derivado, instruccion, fecha)
        VALUES (NEW.cpmh, NEW.accionRealizada, NEW.derivado, NEW.instruccion, NEW.fecha);
    END IF;

    RETURN NEW;
END;
$$
LANGUAGE plpgsql;

-- Trigger for PMH table (for insert, update, and delete)
CREATE TRIGGER trigger_update_analisis_pmh
AFTER INSERT OR UPDATE OR DELETE
ON PMH
FOR EACH ROW
EXECUTE FUNCTION update_analisis_pmh();

select * from pmh 

select * from analisis_pmh 
--5
-- Trigger to update Analisis_FormularioHojaDeRuta when FormularioHojaDeRuta is inserted, updated, or deleted
CREATE OR REPLACE FUNCTION update_analisis_formulario_hoja_de_ruta()
RETURNS TRIGGER AS
$$
BEGIN
    -- Delete from Analisis_FormularioHojaDeRuta if a record is deleted in FormularioHojaDeRuta
    IF TG_OP = 'DELETE' THEN
        DELETE FROM Analisis_FormularioHojaDeRuta WHERE cfhd = OLD.cfhd;

    -- Update Analisis_FormularioHojaDeRuta if a record is updated in FormularioHojaDeRuta
    ELSIF TG_OP = 'UPDATE' THEN
        UPDATE Analisis_FormularioHojaDeRuta
        SET numero = NEW.numero,
            fecha = NEW.fecha,
            cantPer = NEW.cantPer,
            legal = NEW.legal,
            refugio = NEW.refugio,
            atencion = NEW.atencion,
            accionAlbergue = NEW.accionAlbergue,
            accionSerMedico = NEW.accionSerMedico,
            accionAlimentacion = NEW.accionAlimentacion,
            accionAyudaHum = NEW.accionAyudaHum,
            accionPasajes = NEW.accionPasajes,
            accionCondonacion = NEW.accionCondonacion,
            accionOtro = NEW.accionOtro,
            otraAccion = NEW.otraAccion,
            fechaOtraAccion = NEW.fechaOtraAccion
        WHERE cfhd = NEW.cfhd;

    -- Insert into Analisis_FormularioHojaDeRuta for new records in FormularioHojaDeRuta
    ELSIF TG_OP = 'INSERT' THEN
        INSERT INTO Analisis_FormularioHojaDeRuta (
            cfhd, numero, fecha, cantPer, legal, refugio, atencion,
            accionAlbergue, accionSerMedico, accionAlimentacion, accionAyudaHum,
            accionPasajes, accionCondonacion, accionOtro, otraAccion, fechaOtraAccion
        )
        VALUES (
            NEW.cfhd, NEW.numero, NEW.fecha, NEW.cantPer, NEW.legal, NEW.refugio, NEW.atencion,
            NEW.accionAlbergue, NEW.accionSerMedico, NEW.accionAlimentacion, NEW.accionAyudaHum,
            NEW.accionPasajes, NEW.accionCondonacion, NEW.accionOtro, NEW.otraAccion, NEW.fechaOtraAccion
        );
    END IF;

    RETURN NEW;
END;
$$
LANGUAGE plpgsql;

-- Trigger for FormularioHojaDeRuta table (for insert, update, and delete)
CREATE TRIGGER trigger_update_analisis_formulario_hoja_de_ruta
AFTER INSERT OR UPDATE OR DELETE
ON FormularioHojaDeRuta
FOR EACH ROW
EXECUTE FUNCTION update_analisis_formulario_hoja_de_ruta();


select * from formularioregistro

select * from analisis_formulariohojaderuta


