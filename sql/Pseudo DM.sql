-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2023-12-09 18:58:34.701

-- tables
-- Table: Analisis_Beneficiario
CREATE TABLE Analisis_Beneficiario (
    cid int  NOT NULL,
    edad int  NOT NULL,
    sexo varchar(30)  NOT NULL,
    fechaExpedido date  NOT NULL,
    ingreso boolean  NOT NULL,
    educacion varchar(50)  NOT NULL,
    CONSTRAINT Analisis_Beneficiario_pk PRIMARY KEY (cid)
);

-- Table: Analisis_Familias
CREATE TABLE Analisis_Familias (
    cf int  NOT NULL,
    cantidad int  NOT NULL,
    CONSTRAINT Analisis_Familias_pk PRIMARY KEY (cf)
);

-- Table: Analisis_FormularioHojaDeRuta
CREATE TABLE Analisis_FormularioHojaDeRuta (
    cfhd int  NOT NULL,
    numero int  NOT NULL,
    fecha date  NOT NULL,
    cantPer int  NOT NULL,
    legal boolean  NOT NULL,
    refugio boolean  NOT NULL,
    atencion boolean  NOT NULL,
    accionAlbergue boolean  NOT NULL,
    accionSerMedico boolean  NOT NULL,
    accionAlimentacion boolean  NOT NULL,
    accionAyudaHum boolean  NOT NULL,
    accionPasajes boolean  NOT NULL,
    accionCondonacion boolean  NOT NULL,
    accionOtro boolean  NOT NULL,
    otraAccion varchar(30)  NOT NULL,
    fechaOtraAccion date  NOT NULL,
    CONSTRAINT Analisis_FormularioHojaDeRuta_pk PRIMARY KEY (cfhd)
);

-- Table: Analisis_FormularioRegistro
CREATE TABLE Analisis_FormularioRegistro (
    cfr int  NOT NULL,
    lugar varchar(30)  NOT NULL,
    fechaRegistro date  NOT NULL,
    telefono varchar(30)  NOT NULL,
    paisOrigen varchar(30)  NOT NULL,
    fechaDeSalida date  NOT NULL,
    transporte boolean  NOT NULL,
    razon varchar(300)  NOT NULL,
    fechaDeIngreso date  NOT NULL,
    fronteroDeIngreso varchar(50)  NOT NULL,
    documentoDeIngreso varchar(50)  NOT NULL,
    diasDePermanencia int  NOT NULL,
    destinoFinal boolean  NOT NULL,
    paisSiguiente varchar(30)  NOT NULL,
    porquePais varchar(300)  NOT NULL,
    alojamiento varchar(30)  NOT NULL,
    envioDinero boolean  NOT NULL,
    sustento varchar(50)  NOT NULL,
    leEnvianDinero boolean  NOT NULL,
    medioEnvioDinero varchar(50)  NOT NULL,
    comoSeComunicaFamilia varchar(50)  NOT NULL,
    transito boolean  NOT NULL,
    refugio boolean  NOT NULL,
    atencion boolean  NOT NULL,
    CONSTRAINT Analisis_FormularioRegistro_pk PRIMARY KEY (cfr)
);

-- Table: Analisis_PMH
CREATE TABLE Analisis_PMH (
    cpmh int  NOT NULL,
    accionRealizada varchar(300)  NOT NULL,
    derivado varchar(50)  NOT NULL,
    instruccion varchar(300)  NOT NULL,
    fecha date  NOT NULL,
    CONSTRAINT Analisis_PMH_pk PRIMARY KEY (cpmh)
);

-- End of file.