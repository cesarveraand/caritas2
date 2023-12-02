-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2023-11-18 19:33:21.53

-- tables
-- Table: ABMs
CREATE TABLE ABMs (
    cva int  NOT NULL,
    accion varchar(30)  NOT NULL,
    Funcionario_cv int  NOT NULL,
    Funcionario_cv2 int  NOT NULL,
    CONSTRAINT ABMs_pk PRIMARY KEY (cva)
);

-- Table: Beneficiario
CREATE TABLE Beneficiario (
    cid int  NOT NULL,
    nombre varchar(50)  NOT NULL,
    edad int  NOT NULL,
    sexo varchar(30)  NOT NULL,
    ci varchar(50)  NOT NULL,
    fechaExpedido date  NOT NULL,
    ingreso boolean  NOT NULL,
    educacion varchar(50)  NOT NULL,
    estado boolean  NOT NULL,
    CONSTRAINT Beneficiario_pk PRIMARY KEY (cid)
);

-- Table: Familia_beneficiario_voluntario
CREATE TABLE Familia_beneficiario_voluntario (
    cbfv int  NOT NULL,
    Familias_cf int  NOT NULL,
    Beneficiario_cid int  NOT NULL,
    Funcionario_cv int  NOT NULL,
    CONSTRAINT Familia_beneficiario_voluntario_pk PRIMARY KEY (cbfv)
);

-- Table: Familias
CREATE TABLE Familias (
    cf int  NOT NULL,
    cantidad int  NOT NULL,
    ci_r varchar(30)  NOT NULL,
    estado boolean  NOT NULL,
    CONSTRAINT Familias_pk PRIMARY KEY (cf)
);

-- Table: FormRegPaisOr
CREATE TABLE FormRegPaisOr (
    cpo int  NOT NULL,
    FormularioRegistro_cfr int  NOT NULL,
    PaisOrigen_cpo int  NOT NULL,
    Beneficiario_cid int  NOT NULL,
    CONSTRAINT FormRegPaisOr_pk PRIMARY KEY (cpo)
);

-- Table: FormularioHPMH
CREATE TABLE FormularioHPMH (
    cfhp int  NOT NULL,
    FormularioHojaDeRuta_cfhd int  NOT NULL,
    PMH_cpmh int  NOT NULL,
    CONSTRAINT FormularioHPMH_pk PRIMARY KEY (cfhp)
);

-- Table: FormularioHojaDeRuta
CREATE TABLE FormularioHojaDeRuta (
    cfhd int  NOT NULL,
    numero int  NOT NULL,
    fecha date  NOT NULL,
    cantPer int  NOT NULL,
    observaciones varchar(300)  NOT NULL,
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
    fechaOtraAccion date  ,
    estado boolean  NOT NULL,
    CONSTRAINT FormularioHojaDeRuta_pk PRIMARY KEY (cfhd)
);

-- Table: FormularioRegBeneficiario
CREATE TABLE FormularioRegBeneficiario (
    cfb int  NOT NULL,
    FormularioRegistro_cfr int  NOT NULL,
    Beneficiario_cid int  NOT NULL,
    CONSTRAINT FormularioRegBeneficiario_pk PRIMARY KEY (cfb)
);

-- Table: FormularioRegistro
CREATE TABLE FormularioRegistro (
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
    observaciones varchar(300)  NOT NULL,
    transito boolean  NOT NULL,
    refugio boolean  NOT NULL,
    atencion boolean  NOT NULL,
    estado boolean  NOT NULL,
	horaRegistro time,
    CONSTRAINT FormularioRegistro_pk PRIMARY KEY (cfr)
);

-- Table: Funcionario
CREATE TABLE Funcionario (
    cv int  NOT NULL,
    nombrePerfil varchar(30)  NOT NULL,
    ci varchar(30)  NOT NULL,
    correo varchar(50)  NOT NULL,
    telefono varchar(30)  NOT NULL,
    fechaNacimiento date  NOT NULL,
    direccion varchar(30)  NOT NULL,
    ciudad varchar(30)  NOT NULL,
    contrasenia varchar(30)  NOT NULL,
    empleado boolean  NOT NULL,
    admin boolean  NOT NULL,
    fechaRegistrado date  NOT NULL,
    CONSTRAINT Funcionario_pk PRIMARY KEY (cv)
);

-- Table: NombresBeneficiario
CREATE TABLE NombresBeneficiario (
    cnb int  NOT NULL,
    FormularioHojaDeRuta_cfhd int  NOT NULL,
    FormularioRegistro_cfr int  NOT NULL,
    CONSTRAINT NombresBeneficiario_pk PRIMARY KEY (cnb)
);

-- Table: PMH
CREATE TABLE PMH (
    cpmh int  NOT NULL,
    accionRealizada Varchar(300)  NOT NULL,
    derivado varchar(50)  NOT NULL,
    instruccion varchar(300)  NOT NULL,
    observaciones varchar(300)  NOT NULL,
    fecha date  NOT NULL,
    estado boolean  NOT NULL,
    CONSTRAINT PMH_pk PRIMARY KEY (cpmh)
);

-- Table: PaisOrigen
CREATE TABLE PaisOrigen (
    cpo int  NOT NULL,
    pais varchar(30)  NOT NULL,
    tiempo int  NOT NULL,
    estadoMigratorio varchar(50)  NOT NULL,
    estado boolean  NOT NULL,
    CONSTRAINT PaisOrigen_pk PRIMARY KEY (cpo)
);

-- foreign keys
-- Reference: Administradores_Voluntario (table: ABMs)
ALTER TABLE ABMs ADD CONSTRAINT Administradores_Voluntario
    FOREIGN KEY (Funcionario_cv)
    REFERENCES Funcionario (cv)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: Administradores_Voluntario2 (table: ABMs)
ALTER TABLE ABMs ADD CONSTRAINT Administradores_Voluntario2
    FOREIGN KEY (Funcionario_cv)
    REFERENCES Funcionario (cv)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: Familia_beneficiario_Familias (table: Familia_beneficiario_voluntario)
ALTER TABLE Familia_beneficiario_voluntario ADD CONSTRAINT Familia_beneficiario_Familias
    FOREIGN KEY (Familias_cf)
    REFERENCES Familias (cf)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: Familia_beneficiario_voluntario_Funcionario (table: Familia_beneficiario_voluntario)
ALTER TABLE Familia_beneficiario_voluntario ADD CONSTRAINT Familia_beneficiario_voluntario_Funcionario
    FOREIGN KEY (Funcionario_cv)
    REFERENCES Funcionario (cv)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: Familia_beneficiario_voluntario_Identificacion (table: Familia_beneficiario_voluntario)
ALTER TABLE Familia_beneficiario_voluntario ADD CONSTRAINT Familia_beneficiario_voluntario_Identificacion
    FOREIGN KEY (Beneficiario_cid)
    REFERENCES Beneficiario (cid)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: FormRegPaisOr_Beneficiario (table: FormRegPaisOr)
ALTER TABLE FormRegPaisOr ADD CONSTRAINT FormRegPaisOr_Beneficiario
    FOREIGN KEY (Beneficiario_cid)
    REFERENCES Beneficiario (cid)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: FormRegPaisOr_FormularioRegistro (table: FormRegPaisOr)
ALTER TABLE FormRegPaisOr ADD CONSTRAINT FormRegPaisOr_FormularioRegistro
    FOREIGN KEY (FormularioRegistro_cfr)
    REFERENCES FormularioRegistro (cfr)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: FormRegPaisOr_PaisOrigen (table: FormRegPaisOr)
ALTER TABLE FormRegPaisOr ADD CONSTRAINT FormRegPaisOr_PaisOrigen
    FOREIGN KEY (PaisOrigen_cpo)
    REFERENCES PaisOrigen (cpo)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: FormularioHPMH_FormularioHojaDeRuta (table: FormularioHPMH)
ALTER TABLE FormularioHPMH ADD CONSTRAINT FormularioHPMH_FormularioHojaDeRuta
    FOREIGN KEY (FormularioHojaDeRuta_cfhd)
    REFERENCES FormularioHojaDeRuta (cfhd)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: FormularioHPMH_PMH (table: FormularioHPMH)
ALTER TABLE FormularioHPMH ADD CONSTRAINT FormularioHPMH_PMH
    FOREIGN KEY (PMH_cpmh)
    REFERENCES PMH (cpmh)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: FormularioRegBeneficiario_FormularioRegistro (table: FormularioRegBeneficiario)
ALTER TABLE FormularioRegBeneficiario ADD CONSTRAINT FormularioRegBeneficiario_FormularioRegistro
    FOREIGN KEY (FormularioRegistro_cfr)
    REFERENCES FormularioRegistro (cfr)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: FormularioRegBeneficiario_Identificacion (table: FormularioRegBeneficiario)
ALTER TABLE FormularioRegBeneficiario ADD CONSTRAINT FormularioRegBeneficiario_Identificacion
    FOREIGN KEY (Beneficiario_cid)
    REFERENCES Beneficiario (cid)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: NombresBeneficiario_FormularioRegistro (table: NombresBeneficiario)
ALTER TABLE NombresBeneficiario ADD CONSTRAINT NombresBeneficiario_FormularioRegistro
    FOREIGN KEY (FormularioRegistro_cfr)
    REFERENCES FormularioRegistro (cfr)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: entity_1_FormularioHojaDeRuta (table: NombresBeneficiario)
ALTER TABLE NombresBeneficiario ADD CONSTRAINT entity_1_FormularioHojaDeRuta
    FOREIGN KEY (FormularioHojaDeRuta_cfhd)
    REFERENCES FormularioHojaDeRuta (cfhd)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- End of file.
INSERT INTO Funcionario (cv, nombrePerfil, ci, correo, telefono, fechaNacimiento, direccion, ciudad, contrasenia, empleado, admin, fechaRegistrado)
VALUES
    (1, 'Admin1', '123', 'admin1@example.com', '1234567890', '1980-01-01', 'Admin City', 'Adminland', '123', true, true, '2023-11-18');
	
	

	
	
	
	
	
	
	
	
	
	
	