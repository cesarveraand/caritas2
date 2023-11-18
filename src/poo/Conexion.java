package poo;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Conexion {
	static final String DB_URl="jdbc:postgresql://localhost/Caritas";
	static final String USER ="postgres";
	static final String PASS= "D4l3mb3rt";
	public Connection getConexionPostgres() throws SQLException {
		Connection conn=null;
		try {
			conn=DriverManager.getConnection(DB_URl,USER,PASS);
			
		}catch (SQLException e) {
			//JOptionPane.showMessageDialog(null,"No se puede conectar");
			return null;
		}
		//JOptionPane.showMessageDialog(null,"Conexion exitosa");
		return conn;
	}
	public static Funcionario traerFuncionario(int cod)throws SQLException{
		Conexion con=new Conexion();
		Connection conexion = con.getConexionPostgres();
		Funcionario ad=null;
		java.sql.Statement s= conexion.createStatement();
		ResultSet rs=  s.executeQuery("select distinct cv,nombreperfil,ci,correo,telefono,fechanacimiento,direccion,ciudad,contrasenia,fecharegistrado,empleado,admin from funcionario where  empleado=true and cv='"+cod+"'");
		while (rs.next()) {
			ad=new Funcionario(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(8), rs.getString(7), rs.getString(9),rs.getDate(6).toLocalDate(),rs.getDate(10).toLocalDate(),rs.getBoolean(11),rs.getBoolean(12));
		}
		conexion.close();
		System.out.println("admin: "+ad );
		return ad;
	}
	public static FormlarioRegistro traerFormulario(int cod)throws SQLException{
		Conexion con=new Conexion();
		Connection conexion = con.getConexionPostgres();
		FormlarioRegistro ad=null;
		java.sql.Statement s= conexion.createStatement();
		ResultSet rs=  s.executeQuery("select distinct cfr, lugar, fecharegistro ,telefono,paisorigen,fechadesalida,transporte,razon,fechadeingreso,fronterodeingreso,documentodeingreso,diasdepermanencia,destinofinal,paissiguiente,porquepais,alojamiento,enviodinero,sustento,leenviandinero,medioenviodinero,comosecomunicafamilia,observaciones,transito,refugio,atencion,estado from formularioregistro where cfr='"+cod+"'");
		while (rs.next()) { 
			ad=new FormlarioRegistro(rs.getInt(1),rs.getString(2),rs.getDate(3).toLocalDate(),rs.getString(4),rs.getString(5),rs.getDate(6).toLocalDate(),rs.getBoolean(7),rs.getString(8),rs.getDate(9).toLocalDate(),rs.getString(10),rs.getString(11),rs.getInt(12),rs.getBoolean(13),rs.getString(14),rs.getString(15),rs.getString(16),rs.getBoolean(17),rs.getBoolean(18),rs.getBoolean(19),rs.getString(20),rs.getString(21),rs.getString(22),rs.getBoolean(23),rs.getBoolean(24),rs.getBoolean(25),familiasForm(rs.getInt(1)),rs.getBoolean(26));
			
		}
		conexion.close();
		return ad;
	}
	public static Funcionario ingresarFun(String ci, String contra)throws SQLException {
		Conexion con=new Conexion();
		Connection conexion = con.getConexionPostgres();
		Funcionario ad=null;
		java.sql.Statement s= conexion.createStatement();
		ResultSet rs=  s.executeQuery("select distinct cv,nombreperfil,ci,correo,telefono,fechanacimiento,direccion,ciudad,contrasenia,fecharegistrado,empleado,admin from funcionario where ci='"+ci+"' and contrasenia ='"+contra+"'");
		while (rs.next()) {
			ad=new Funcionario(rs.getInt(1), rs.getString(2), ci, rs.getString(4), rs.getString(5), rs.getString(8), rs.getString(7), contra,rs.getDate(6).toLocalDate(),rs.getDate(10).toLocalDate(),rs.getBoolean(11),rs.getBoolean(12));
		}
		conexion.close();
		System.out.println("admin: "+ad );
		return ad;
	}
	public static ArrayList<Funcionario> adminsRegistrados()throws SQLException {
		Conexion con=new Conexion();
		Connection conexion = con.getConexionPostgres();
		Funcionario ad=null;
		ArrayList<Funcionario> admins=new ArrayList<Funcionario>();
		java.sql.Statement s= conexion.createStatement();
		ResultSet rs=  s.executeQuery("select distinct cv,nombreperfil,ci,correo,telefono,fechanacimiento,direccion,ciudad,contrasenia,fecharegistrado,empleado,admin from funcionario where admin=true and empleado=true");
		while (rs.next()) {
			ad=new Funcionario(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(8), rs.getString(7), rs.getString(9),rs.getDate(6).toLocalDate(),rs.getDate(10).toLocalDate(),rs.getBoolean(11),rs.getBoolean(12));
			admins.add(ad);
		}
		conexion.close();
		System.out.println("admin: "+ad );
		return admins;
	}
	public static ArrayList<Funcionario> voluntariosRegistrados()throws SQLException {
		Conexion con=new Conexion();
		Connection conexion = con.getConexionPostgres();
		Funcionario ad=null;
		ArrayList<Funcionario> voluns=new ArrayList<Funcionario>();
		java.sql.Statement s= conexion.createStatement();
		ResultSet rs=  s.executeQuery("select distinct cv,nombreperfil,ci,correo,telefono,fechanacimiento,direccion,ciudad,contrasenia,fecharegistrado,empleado,admin from funcionario where admin=false and empleado=true");
		while (rs.next()) {
			ad=new Funcionario(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(8), rs.getString(7), rs.getString(9),rs.getDate(6).toLocalDate(),rs.getDate(10).toLocalDate(),rs.getBoolean(11),rs.getBoolean(12));
			voluns.add(ad);
		}
		conexion.close();
		System.out.println("admin: "+ad );
		return voluns;
	}
	public static int ultimoFuncionario()throws SQLException {
		Conexion con=new Conexion();
		int ultimo=0,max=0;
		Connection conexion = con.getConexionPostgres();
		java.sql.Statement s= conexion.createStatement();
		ResultSet rs=  s.executeQuery("select cv from funcionario order by(cv)  ");
		
		while (rs.next()) {
			//System.out.println(rs.getLong(1)+", "+rs.getString(2)+", "+rs.getLong(3)+", "+rs.getDouble(4)+", "+rs.getDouble(5));
			
			ultimo=(int) rs.getLong(1);
			if(ultimo>max) {
				max=ultimo;
			}
		}
		max++;
		conexion.close();
		
		return max;
	}
	public static int ultimaFamilia()throws SQLException {
		Conexion con=new Conexion();
		int ultimo=0,max=0;
		Connection conexion = con.getConexionPostgres();
		java.sql.Statement s= conexion.createStatement();
		ResultSet rs=  s.executeQuery("select cf from familias order by(cf)  ");
		
		while (rs.next()) {
			//System.out.println(rs.getLong(1)+", "+rs.getString(2)+", "+rs.getLong(3)+", "+rs.getDouble(4)+", "+rs.getDouble(5));
			
			ultimo=(int) rs.getLong(1);
			if(ultimo>max) {
				max=ultimo;
			}
		}
		max++;
		conexion.close();
		
		return max;
	}
	public static int ultimaHojaRuta()throws SQLException {
		Conexion con=new Conexion();
		int ultimo=0,max=0;
		Connection conexion = con.getConexionPostgres();
		java.sql.Statement s= conexion.createStatement();
		ResultSet rs=  s.executeQuery("select cfhd from FormularioHojaDeRuta order by(cfhd)  ");
		
		while (rs.next()) {
			//System.out.println(rs.getLong(1)+", "+rs.getString(2)+", "+rs.getLong(3)+", "+rs.getDouble(4)+", "+rs.getDouble(5));
			
			ultimo=(int) rs.getLong(1);
			if(ultimo>max) {
				max=ultimo;
			}
		}
		max++;
		conexion.close();
		
		return max;
	}
	public static int ultimoNumero()throws SQLException {
		Conexion con=new Conexion();
		int ultimo=0,max=0;
		Connection conexion = con.getConexionPostgres();
		java.sql.Statement s= conexion.createStatement();
		ResultSet rs=  s.executeQuery("select numero from FormularioHojaDeRuta order by(numero)  ");
		
		while (rs.next()) {
			//System.out.println(rs.getLong(1)+", "+rs.getString(2)+", "+rs.getLong(3)+", "+rs.getDouble(4)+", "+rs.getDouble(5));
			
			ultimo=(int) rs.getLong(1);
			if(ultimo>max) {
				max=ultimo;
			}
		}
		max++;
		conexion.close();
		
		return max;
	}
	public static int ultimoBeneficiario()throws SQLException {
		Conexion con=new Conexion();
		int ultimo=0,max=0;
		Connection conexion = con.getConexionPostgres();
		java.sql.Statement s= conexion.createStatement();
		ResultSet rs=  s.executeQuery("select cid from beneficiario order by(cid)  ");
		
		while (rs.next()) {
			//System.out.println(rs.getLong(1)+", "+rs.getString(2)+", "+rs.getLong(3)+", "+rs.getDouble(4)+", "+rs.getDouble(5));
			
			ultimo=(int) rs.getLong(1);
			if(ultimo>max) {
				max=ultimo;
			}
		}
		max++;
		conexion.close();
		
		return max;
	}
	public static int ultimoFBF()throws SQLException {
		Conexion con=new Conexion();
		int ultimo=0,max=0;
		Connection conexion = con.getConexionPostgres();
		java.sql.Statement s= conexion.createStatement();
		ResultSet rs=  s.executeQuery("select cbfv from Familia_beneficiario_voluntario order by(cbfv)  ");
		
		while (rs.next()) {
			
			ultimo=(int) rs.getLong(1);
			if(ultimo>max) {
				max=ultimo;
			}
		}
		max++;
		conexion.close();
		
		return max;
	}
	public static int ultimoFormularioRegistro()throws SQLException {
		Conexion con=new Conexion();
		int ultimo=0,max=0;
		Connection conexion = con.getConexionPostgres();
		java.sql.Statement s= conexion.createStatement();
		ResultSet rs=  s.executeQuery("select cfr from formularioregistro order by(cfr)  ");
		
		while (rs.next()) {
			//System.out.println(rs.getLong(1)+", "+rs.getString(2)+", "+rs.getLong(3)+", "+rs.getDouble(4)+", "+rs.getDouble(5));
			
			ultimo=(int) rs.getLong(1);
			if(ultimo>max) {
				max=ultimo;
			}
		}
		max++;
		conexion.close();
		
		return max;
	}
	public static int ultimoCnb()throws SQLException {
		Conexion con=new Conexion();
		int ultimo=0,max=0;
		Connection conexion = con.getConexionPostgres();
		java.sql.Statement s= conexion.createStatement();
		ResultSet rs=  s.executeQuery("select cnb from nombresbeneficiario order by(cnb)  ");
		
		while (rs.next()) {
			//System.out.println(rs.getLong(1)+", "+rs.getString(2)+", "+rs.getLong(3)+", "+rs.getDouble(4)+", "+rs.getDouble(5));
			
			ultimo=(int) rs.getLong(1);
			if(ultimo>max) {
				max=ultimo;
			}
		}
		max++;
		conexion.close();
		
		return max;
	}
	public static int ultimoPaisVisita()throws SQLException {
		Conexion con=new Conexion();
		int ultimo=0,max=0;
		Connection conexion = con.getConexionPostgres();
		java.sql.Statement s= conexion.createStatement();
		ResultSet rs=  s.executeQuery("select cpo from paisorigen order by(cpo)  ");
		
		while (rs.next()) {
			//System.out.println(rs.getLong(1)+", "+rs.getString(2)+", "+rs.getLong(3)+", "+rs.getDouble(4)+", "+rs.getDouble(5));
			
			ultimo=(int) rs.getLong(1);
			if(ultimo>max) {
				max=ultimo;
			}
		}
		max++;
		conexion.close();
		
		return max;
	}
	public static int ultimoFB()throws SQLException {
		Conexion con=new Conexion();
		int ultimo=0,max=0;
		Connection conexion = con.getConexionPostgres();
		java.sql.Statement s= conexion.createStatement();
		ResultSet rs=  s.executeQuery("select cfb from FormularioRegBeneficiario order by(cfb)  ");
		
		while (rs.next()) {
			
			ultimo=(int) rs.getLong(1);
			if(ultimo>max) {
				max=ultimo;
			}
		}
		max++;
		conexion.close();
		
		return max;
	}
	public static int ultimoFBP()throws SQLException {
		Conexion con=new Conexion();
		int ultimo=0,max=0;
		Connection conexion = con.getConexionPostgres();
		java.sql.Statement s= conexion.createStatement();
		ResultSet rs=  s.executeQuery("select cpo from FormRegPaisOr order by(cpo)  ");
		
		while (rs.next()) {
			
			ultimo=(int) rs.getLong(1);
			if(ultimo>max) {
				max=ultimo;
			}
		}
		max++;
		conexion.close();
		
		return max;
	}
	public static Familias familiasForm (int f) throws SQLException{
		Conexion con=new Conexion();
		Connection conexion = con.getConexionPostgres();
		Familias fam=null;
		java.sql.Statement s= conexion.createStatement();
		ResultSet rs=  s.executeQuery("select a.cf,a.cantidad,a.ci_r,a.estado from familias a, formularioregbeneficiario c, beneficiario d, familia_beneficiario_voluntario e where a.cf=e.familias_cf and d.cid =e.beneficiario_cid and c.beneficiario_cid=d.cid and c.formularioregistro_cfr='"+f+"'");
		while (rs.next()) { 
			fam=new Familias(rs.getInt(1),rs.getInt(2),obtenerBeneficiarioCi(rs.getString(3)),obtenerBeneficiarios(rs.getInt(1)),rs.getBoolean(4));
			}
		conexion.close();
		return fam;
	}
	public static ArrayList<Beneficiarios> obtenerBeneficiarios(int fam) throws SQLException{
		Conexion con=new Conexion();
		Connection conexion = con.getConexionPostgres();
		Beneficiarios auxBen=null;
		java.sql.Statement s= conexion.createStatement();
		ArrayList<Beneficiarios> beneficiarios=new ArrayList<Beneficiarios>();

		ResultSet rs=  s.executeQuery("select a.cid, a.nombre, a.edad ,a.sexo,a.ci,a.fechaexpedido,a.ingreso,a.educacion,a.estado from beneficiario a, familia_beneficiario_voluntario b where a.cid=b.beneficiario_cid and b.familias_cf='"+fam+"'");
		while (rs.next()) {
			auxBen=new Beneficiarios(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4),rs.getString(5),rs.getDate(6).toLocalDate(),rs.getBoolean(7),rs.getString(8),obetenerPaisesBeneficiarios(rs.getInt(1)),rs.getBoolean(9));
			beneficiarios.add(auxBen);
		}
		conexion.close();
		return beneficiarios;
	}
	public static Beneficiarios obtenerBeneficiarioCi(String ci) throws SQLException{
		Conexion con=new Conexion();
		Connection conexion = con.getConexionPostgres();
		Beneficiarios aux=null;
		java.sql.Statement s= conexion.createStatement();
		ResultSet rs=  s.executeQuery("select cid, nombre, edad ,sexo,ci,fechaexpedido,ingreso,educacion,estado from beneficiario where ci='"+ci+"'");
		while (rs.next()) {
			aux=new Beneficiarios(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4),rs.getString(5),rs.getDate(6).toLocalDate(),rs.getBoolean(7),rs.getString(8),obetenerPaisesBeneficiarios(rs.getInt(1)),rs.getBoolean(9));
		}
		conexion.close();
		System.out.println(aux.toString());
		return aux;
	}
	public static ArrayList<PaisVisita> obetenerPaisesBeneficiarios(int d) throws SQLException{
		Conexion con=new Conexion();
		Connection conexion = con.getConexionPostgres();
		PaisVisita auxPais=null;
		ArrayList<PaisVisita> paises=new ArrayList<PaisVisita>();
		java.sql.Statement s= conexion.createStatement();
		ResultSet rs=  s.executeQuery("select a.cpo, a.pais, a.tiempo, a.estadomigratorio,a.estado from paisorigen a, formregpaisor b where a.cpo=paisorigen_cpo and beneficiario_cid='"+d+"'");
		while (rs.next()) { 
			auxPais=new PaisVisita(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4),rs.getBoolean(5));
			paises.add(auxPais);
		}
		conexion.close();
		return paises;
	}
	public static ArrayList<FormlarioRegistro> formulariosRegistrado()throws SQLException{
		Conexion con=new Conexion();
		Connection conexion = con.getConexionPostgres();
		FormlarioRegistro auxForm=null;
		ArrayList<FormlarioRegistro> forms=new ArrayList<FormlarioRegistro>();
		java.sql.Statement s= conexion.createStatement();
		ResultSet rs=  s.executeQuery("select distinct cfr, lugar, fecharegistro ,telefono,paisorigen,fechadesalida,transporte,razon,fechadeingreso,fronterodeingreso,documentodeingreso,diasdepermanencia,destinofinal,paissiguiente,porquepais,alojamiento,enviodinero,sustento,leenviandinero,medioenviodinero,comosecomunicafamilia,observaciones,transito,refugio,atencion,estado from formularioregistro");
		while (rs.next()) { 
			auxForm=new FormlarioRegistro(rs.getInt(1),rs.getString(2),rs.getDate(3).toLocalDate(),rs.getString(4),rs.getString(5),rs.getDate(6).toLocalDate(),rs.getBoolean(7),rs.getString(8),rs.getDate(9).toLocalDate(),rs.getString(10),rs.getString(11),rs.getInt(12),rs.getBoolean(13),rs.getString(14),rs.getString(15),rs.getString(16),rs.getBoolean(17),rs.getBoolean(18),rs.getBoolean(19),rs.getString(20),rs.getString(21),rs.getString(22),rs.getBoolean(23),rs.getBoolean(24),rs.getBoolean(25),familiasForm(rs.getInt(1)),rs.getBoolean(26));
			forms.add(auxForm);
		}
		conexion.close();
		return forms;
	}
	public static FormlarioRegistro formularioReg(int cod) throws SQLException{
		Conexion con=new Conexion();
		Connection conexion = con.getConexionPostgres();
		FormlarioRegistro auxForm=null;
		java.sql.Statement s= conexion.createStatement();
		ResultSet rs=  s.executeQuery("	select distinct a.cfr, a.lugar, a.fecharegistro ,a.telefono,a.paisorigen,a.fechadesalida,a.transporte,a.razon,a.fechadeingreso,a.fronterodeingreso,a.documentodeingreso,a.diasdepermanencia,a.destinofinal,a.paissiguiente,a.porquepais,a.alojamiento,a.enviodinero,a.sustento,a.leenviandinero,a.medioenviodinero,a.comosecomunicafamilia,a.observaciones,a.transito,a.refugio,a.atencion,a.estado from formularioregistro a,nombresbeneficiario b  where a.cfr=b.formularioregistro_cfr   and formulariohojaderuta_cfhd='"+cod+"'");
		while (rs.next()) { 
			auxForm=new FormlarioRegistro(rs.getInt(1),rs.getString(2),rs.getDate(3).toLocalDate(),rs.getString(4),rs.getString(5),rs.getDate(6).toLocalDate(),rs.getBoolean(7),rs.getString(8),rs.getDate(9).toLocalDate(),rs.getString(10),rs.getString(11),rs.getInt(12),rs.getBoolean(13),rs.getString(14),rs.getString(15),rs.getString(16),rs.getBoolean(17),rs.getBoolean(18),rs.getBoolean(19),rs.getString(20),rs.getString(21),rs.getString(22),rs.getBoolean(23),rs.getBoolean(24),rs.getBoolean(25),familiasForm(rs.getInt(1)),rs.getBoolean(26));
		}
		conexion.close();
		return auxForm;
	}
	public static Hoja_de_ruta traerFormularioHoja(int cod)throws SQLException{
		Conexion con=new Conexion();
		Connection conexion = con.getConexionPostgres();
		Hoja_de_ruta auxForm=null;
		java.sql.Statement s= conexion.createStatement();
		ResultSet rs=  s.executeQuery("select a.cfhd, a.numero,a.fecha,a.cantper,a.observaciones,a.legal,a.refugio,a.atencion,a.accionalbergue,a.accionsermedico,a.accionalimentacion,a.accionayudahum,a.accionpasajes,a.accioncondonacion,a.otraaccion,a.fechaotraaccion,a.estado from formulariohojaderuta a,formulariohpmh b where a.cfhd=b.formulariohojaderuta_cfhd and b.pmh_cpmh='"+cod+"'");
		while (rs.next()) { 
			if(rs.getDate(16)!=null) {
				auxForm=new Hoja_de_ruta(rs.getInt(1), rs.getInt(2)+"",rs.getDate(3).toLocalDate() , rs.getInt(4), rs.getString(5),rs.getBoolean(6), rs.getBoolean(7), rs.getBoolean(8), rs.getBoolean(9), rs.getBoolean(10), rs.getBoolean(11), rs.getBoolean(12), rs.getBoolean(13), rs.getBoolean(14), rs.getString(15),rs.getDate(16).toLocalDate(),formularioReg(rs.getInt(1)),rs.getBoolean(17)) ;

			}else {
				auxForm=new Hoja_de_ruta(rs.getInt(1), rs.getInt(2)+"",rs.getDate(3).toLocalDate() , rs.getInt(4), rs.getString(5),rs.getBoolean(6), rs.getBoolean(7), rs.getBoolean(8), rs.getBoolean(9), rs.getBoolean(10), rs.getBoolean(11), rs.getBoolean(12), rs.getBoolean(13), rs.getBoolean(14), rs.getString(15),null,formularioReg(rs.getInt(1)),rs.getBoolean(17)) ;

			}
		}
		conexion.close();
		return auxForm;
	}
	public static ArrayList<Hoja_de_ruta> HojasDeRutaExistentes()throws SQLException{
		Conexion con=new Conexion();
		Connection conexion = con.getConexionPostgres();
		Hoja_de_ruta auxForm=null;
		ArrayList<Hoja_de_ruta> ahj=new ArrayList<Hoja_de_ruta>();
		java.sql.Statement s= conexion.createStatement();
		ResultSet rs=  s.executeQuery("select a.cfhd, a.numero,a.fecha,a.cantper,a.observaciones,a.legal,a.refugio,a.atencion,a.accionalbergue,a.accionsermedico,a.accionalimentacion,a.accionayudahum,a.accionpasajes,a.accioncondonacion,a.otraaccion,a.fechaotraaccion,a.estado from formulariohojaderuta a ");
		while (rs.next()) { 
			if(rs.getDate(16)!=null) {
				auxForm=new Hoja_de_ruta(rs.getInt(1), rs.getInt(2)+"",rs.getDate(3).toLocalDate() , rs.getInt(4), rs.getString(5),rs.getBoolean(6), rs.getBoolean(7), rs.getBoolean(8), rs.getBoolean(9), rs.getBoolean(10), rs.getBoolean(11), rs.getBoolean(12), rs.getBoolean(13), rs.getBoolean(14), rs.getString(15),rs.getDate(16).toLocalDate(),formularioReg(rs.getInt(1)),rs.getBoolean(17)) ;
				ahj.add(auxForm);
				
			}else {
				auxForm=new Hoja_de_ruta(rs.getInt(1), rs.getInt(2)+"",rs.getDate(3).toLocalDate() , rs.getInt(4), rs.getString(5),rs.getBoolean(6), rs.getBoolean(7), rs.getBoolean(8), rs.getBoolean(9), rs.getBoolean(10), rs.getBoolean(11), rs.getBoolean(12), rs.getBoolean(13), rs.getBoolean(14), rs.getString(15),null,formularioReg(rs.getInt(1)),rs.getBoolean(17)) ;
				ahj.add(auxForm);
			}
		}
		conexion.close();
		return ahj;
	}
	public static ArrayList<Hoja_de_ruta> formHojaRutaAccions()throws SQLException{
		Conexion con=new Conexion();
		Connection conexion = con.getConexionPostgres();
		Hoja_de_ruta auxForm=null;
		ArrayList<Hoja_de_ruta> formsAc=new ArrayList<Hoja_de_ruta>();
		java.sql.Statement s= conexion.createStatement();
		ResultSet rs=  s.executeQuery("select a.cfhd, a.numero,a.fecha,a.cantper,a.observaciones,a.legal,a.refugio,a.atencion,a.accionalbergue,a.accionsermedico,a.accionalimentacion,a.accionayudahum,a.accionpasajes,a.accioncondonacion,a.otraaccion,a.fechaotraaccion,a.estado from formulariohojaderuta a where not exists(select b.formulariohojaderuta_cfhd from formulariohpmh b where b.formulariohojaderuta_cfhd=a.cfhd) ");
		while (rs.next()) { 
			if(rs.getDate(16)!=null) {
				auxForm=new Hoja_de_ruta(rs.getInt(1), rs.getInt(2)+"",rs.getDate(3).toLocalDate() , rs.getInt(4), rs.getString(5),rs.getBoolean(6), rs.getBoolean(7), rs.getBoolean(8), rs.getBoolean(9), rs.getBoolean(10), rs.getBoolean(11), rs.getBoolean(12), rs.getBoolean(13), rs.getBoolean(14), rs.getString(15),rs.getDate(16).toLocalDate(),formularioReg(rs.getInt(1)),rs.getBoolean(17)) ;
				if(auxForm.getForm()!=null) {
					formsAc.add(auxForm);

				}
			}else {
				auxForm=new Hoja_de_ruta(rs.getInt(1), rs.getInt(2)+"",rs.getDate(3).toLocalDate() , rs.getInt(4), rs.getString(5),rs.getBoolean(6), rs.getBoolean(7), rs.getBoolean(8), rs.getBoolean(9), rs.getBoolean(10), rs.getBoolean(11), rs.getBoolean(12), rs.getBoolean(13), rs.getBoolean(14), rs.getString(15),null,formularioReg(rs.getInt(1)),rs.getBoolean(17)) ;
				if(auxForm.getForm()!=null) {
					formsAc.add(auxForm);
				}
			}
			
		}
		conexion.close();
		return formsAc;
	}
	public static ArrayList<HojaRutaAcciones> formHojaRutaAccionesExistentes()throws SQLException{
		Conexion con=new Conexion();
		Connection conexion = con.getConexionPostgres();
		HojaRutaAcciones auxForm=null;
		ArrayList<HojaRutaAcciones> formsAc=new ArrayList<HojaRutaAcciones>();
		java.sql.Statement s= conexion.createStatement();
		ResultSet rs=  s.executeQuery("select a.cpmh, a.accionrealizada,a.derivado,a.instruccion,a.observaciones,a.fecha,a.estado from pmh a, formulariohpmh b where a.cpmh=b.pmh_cpmh");
		while (rs.next()) { 
				auxForm=new HojaRutaAcciones(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),rs.getDate(6).toLocalDate(), Conexion.traerFormularioHoja(rs.getInt(1)),rs.getBoolean(7));
				formsAc.add(auxForm);
			
		}
		conexion.close();
		return formsAc;
	}
	public static ArrayList<HojaRutaAcciones> traerHojaRutaAccion(int cod)throws SQLException{
		Conexion con=new Conexion();
		Connection conexion = con.getConexionPostgres();
		HojaRutaAcciones auxForm=null;
		ArrayList<HojaRutaAcciones> formsAc=new ArrayList<HojaRutaAcciones>();
		java.sql.Statement s= conexion.createStatement();
		ResultSet rs=  s.executeQuery("select a.cpmh, a.accionrealizada,a.derivado,a.instruccion,a.observaciones,a.fecha,a.estado from pmh a, formulariohpmh b where b.pmh_cpmh= a.cpmh and formulariohojaderuta_cfhd='"+cod+"'  ");
		while (rs.next()) { 
				auxForm=new HojaRutaAcciones(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),rs.getDate(6).toLocalDate(), Conexion.traerFormularioHoja(rs.getInt(1)),rs.getBoolean(7));
				formsAc.add(auxForm);
			
		}
		conexion.close();
		return formsAc;
	}
	public static ArrayList<FormlarioRegistro> traerFormulariosSinHojaDeRuta()throws SQLException{
		Conexion con=new Conexion();
		Connection conexion = con.getConexionPostgres();
		FormlarioRegistro auxForm=null;
		ArrayList<FormlarioRegistro> forms=new ArrayList<FormlarioRegistro>();
		java.sql.Statement s= conexion.createStatement();
		ResultSet rs=  s.executeQuery("select distinct a.cfr, a.lugar, a.fecharegistro ,a.telefono,a.paisorigen,a.fechadesalida,a.transporte,a.razon,a.fechadeingreso,a.fronterodeingreso,a.documentodeingreso,a.diasdepermanencia,a.destinofinal,a.paissiguiente,a.porquepais,a.alojamiento,a.enviodinero,a.sustento,a.leenviandinero,a.medioenviodinero,a.comosecomunicafamilia,a.observaciones,a.transito,a.refugio,a.atencion,a.estado from formularioregistro a  where not exists(select b.formularioregistro_cfr from nombresbeneficiario b where a.cfr=b.formularioregistro_cfr) ");
		while (rs.next()) { 
			auxForm=new FormlarioRegistro(rs.getInt(1),rs.getString(2),rs.getDate(3).toLocalDate(),rs.getString(4),rs.getString(5),rs.getDate(6).toLocalDate(),rs.getBoolean(7),rs.getString(8),rs.getDate(9).toLocalDate(),rs.getString(10),rs.getString(11),rs.getInt(12),rs.getBoolean(13),rs.getString(14),rs.getString(15),rs.getString(16),rs.getBoolean(17),rs.getBoolean(18),rs.getBoolean(19),rs.getString(20),rs.getString(21),rs.getString(22),rs.getBoolean(23),rs.getBoolean(24),rs.getBoolean(25),familiasForm(rs.getInt(1)),rs.getBoolean(26));
			forms.add(auxForm);
		}
		conexion.close();
		return forms;
	}
	public static void registrarFormBD(FormlarioRegistro form) {
		
		Familias famAux= form.getFam();
		int cod1=0,cod2=0,cod3=0;
		ArrayList<Beneficiarios> fam=famAux.getFamilia();
		ArrayList<PaisVisita> pf=fam.get(0).getPais();
		FormlarioRegistro f=form;
		
		try {
			registrarFamilia(famAux);
			for(PaisVisita i:pf) {
				registrarPaisVisita(i);
			}
			registrarFormularioRegistro(f);
			cod1=ultimoFBF();
			cod2=ultimoFB();
			cod3=ultimoFBP();
			for(Beneficiarios i:fam) {
				registrarBeneficiarios(i);
				registrarFamBenFun(cod1,famAux,i);
				registrarFormBen(cod2,f,i);
				for(PaisVisita j:pf) {
					registrarFormBenPais(cod3,f,i,j);
					cod3++;
				}
				
				cod2++;
				cod1++;
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void registrarFormBenPais(int cpo,FormlarioRegistro form,Beneficiarios ben,PaisVisita p) throws SQLException {
		Conexion con=new Conexion();
		Connection conexion = (Connection) con.getConexionPostgres();
		PreparedStatement s;
		
		String query="insert into FormRegPaisOr"
				+ "(cpo, formularioRegistro_cfr,paisorigen_cpo,beneficiario_cid) values "
				+ "(?,?,?,?)";
		try {
			s=(PreparedStatement) conexion.prepareStatement(query);
			s.setInt(1, cpo);
			s.setInt(2,form.getCfr());
			s.setInt(3,p.getCpo());
			s.setInt(4,ben.getCodBen());
			

			s.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		conexion.close();
		System.out.println("Datos ingresados correctamente");
	}
	public static void registrarFormBen(int cfb,FormlarioRegistro form,Beneficiarios ben) throws SQLException {
		Conexion con=new Conexion();
		Connection conexion = (Connection) con.getConexionPostgres();
		PreparedStatement s;
		
		String query="insert into FormularioRegBeneficiario"
				+ "(cfb, formularioRegistro_cfr,beneficiario_cid) values "
				+ "(?,?,?)";
		try {
			s=(PreparedStatement) conexion.prepareStatement(query);
			s.setInt(1, cfb);
			s.setInt(2,form.getCfr());
			s.setInt(3,ben.getCodBen());
			

			s.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		conexion.close();
		System.out.println("Datos ingresados correctamente");
	}
	public static void registrarFamBenFun(int cbfv,Familias famAux,Beneficiarios ben) throws SQLException {
		Conexion con=new Conexion();
		Connection conexion = (Connection) con.getConexionPostgres();
		PreparedStatement s;
		
		String query="insert into Familia_beneficiario_voluntario"
				+ "(cbfv, familias_cf,beneficiario_cid,funcionario_cv) values "
				+ "(?,?,?,?)";
		try {
			s=(PreparedStatement) conexion.prepareStatement(query);
			s.setInt(1, cbfv);
			s.setInt(2,famAux.getCodFamilia());
			s.setInt(3,ben.getCodBen());
			s.setInt(4,Main.getCod());
			

			s.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		conexion.close();
		System.out.println("Datos ingresados correctamente");
	}
	public static void registrarFormularioRegistro(FormlarioRegistro form)throws SQLException{
		Conexion con=new Conexion();
		Connection conexion = (Connection) con.getConexionPostgres();
		PreparedStatement s;
		
		String query="insert into formularioregistro"
				+ "(cfr, lugar, fecharegistro ,telefono,paisorigen,fechadesalida,transporte,razon,fechadeingreso,fronterodeingreso,documentodeingreso,diasdepermanencia,destinofinal,paissiguiente,porquepais,alojamiento,enviodinero,sustento,leenviandinero,medioenviodinero,comosecomunicafamilia,observaciones,transito,refugio,atencion) values "
				+ "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			s=(PreparedStatement) conexion.prepareStatement(query);
			s.setInt(1,form.getCfr() );
			s.setString(2, form.getLugar());
			s.setDate(3,java.sql.Date.valueOf(form.getFechaRegistro()));
			s.setString(4, form.getTelefono());
			s.setString(5,form.getPaisOrigen());
			s.setDate(6, java.sql.Date.valueOf(form.getFechaSalida()));
			s.setBoolean(7,form.isTransporte());
			s.setString(8,form.getRazon());
			s.setDate(9,java.sql.Date.valueOf(form.getFechaIngreso()));
			s.setString(10, form.getFronteraIngreso());
			s.setString(11, form.getDocumentoIngreso());
			s.setInt(12, Integer.parseInt(form.getDiasPermanencia()));
			s.setBoolean(13, form.isDestinoFinal());
			s.setString(14, form.getPaisSiguiente());
			s.setString(15, form.getPorquePais());
			s.setString(16,form.getAlojamiento());
			s.setBoolean(17,form.isEnviaDinero());
			s.setBoolean(18,form.getSustento());
			s.setBoolean(19,form.isLeEnviaDienro() );
			s.setString(20,form.getMedioEvniaDinero());
			s.setString(21,form.getComunicaFamilia());
			s.setString(22,form.getObs());
			s.setBoolean(23, form.isTransito());
			s.setBoolean(24, form.isRefugio());
			s.setBoolean(25, form.isAtencion());

			s.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		conexion.close();
		System.out.println("Datos ingresados correctamente");
	}
	public static void registrarPaisVisita(PaisVisita pf) throws SQLException {
		Conexion con=new Conexion();
		Connection conexion = (Connection) con.getConexionPostgres();
		PreparedStatement s;
		
		String query="insert into paisorigen"
				+ "(cpo, pais, tiempo,estadomigratorio) values "
				+ "(?,?,?,?)";
		try {
			s=(PreparedStatement) conexion.prepareStatement(query);
			s.setInt(1, pf.getCpo());
			s.setString(2,pf.getPais());
			s.setInt(3,pf.getTiempoDias());
			s.setString(4,pf.getEstadoMigratorioString());
			

			s.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		conexion.close();
		System.out.println("Datos ingresados correctamente");
	}
	public static void registrarBeneficiarios(Beneficiarios b) throws SQLException {
		Conexion con=new Conexion();
		Connection conexion = (Connection) con.getConexionPostgres();
		PreparedStatement s;
		
		String query="insert into beneficiario"
				+ "(cid, nombre, edad ,sexo,ci,fechaexpedido,ingreso,educacion) values "
				+ "(?,?,?,?,?,?,?,?)";
		try {
			s=(PreparedStatement) conexion.prepareStatement(query);
			s.setInt(1, b.getCodBen());
			s.setString(2, b.getNombre());
			s.setInt(3,b.getEdad());
			s.setString(4, b.getSexo());
			s.setString(5,b.getCi());
			s.setDate(6, java.sql.Date.valueOf(b.getFechaExpedido()));
			s.setBoolean(7,b.isIngreso());
			s.setString(8,b.getEducacion());
			

			s.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		conexion.close();
		System.out.println("Datos ingresados correctamente");
	}
	public static void registrarFamilia(Familias fam) throws SQLException {
		Conexion con=new Conexion();
		Connection conexion = (Connection) con.getConexionPostgres();
		PreparedStatement s;
		
		String query="insert into familias"
				+ "(cf, cantidad, ci_r) values "
				+ "(?,?,?)";
		try {
			s=(PreparedStatement) conexion.prepareStatement(query);
			s.setInt(1, fam.getCodFamilia());
			s.setInt(2,fam.getCantidad());
			s.setString(3,fam.getPrin().getCi());
		
			

			s.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		conexion.close();
		System.out.println("Datos ingresados correctamente");
	}
	public static boolean confirmar(String ci) throws SQLException{
		Conexion con=new Conexion();
		Connection conexion = con.getConexionPostgres();
		java.sql.Statement s= conexion.createStatement();
		ResultSet rs=  s.executeQuery("select count(cv) from funcionario where ci='"+ci+"'");
		
		
		if (rs.next()) {
	        int count = rs.getInt(1);
	        return count == 0;  
	    } else {
	        
	        return false; 
	    }
		
		
		
	}
	public static void actualizar(Funcionario fun) throws SQLException{
		
		Conexion con=new Conexion();
		Connection conexion = con.getConexionPostgres();
		java.sql.Statement s= conexion.createStatement();
		String query="update funcionario set nombreperfil='"+fun.getNombre()+"',ci='"+fun.getCi()+"',correo='"+fun.getCorreo()+"',telefono='"+fun.getTelefono()+"',fechanacimiento='"+java.sql.Date.valueOf(fun.getFechaNac())+"',direccion='"+fun.getDireccion()+"',ciudad='"+fun.getCiudad()+"',contrasenia='"+fun.getContra()+"',empleado='"+fun.isEmpleado()+"',admin='"+fun.isAdmin()+"',fecharegistrado='"+java.sql.Date.valueOf(fun.getLFechaCon())+"' where cv = "+fun.getCod();		
		System.out.println(fun);
		try {
			s.executeQuery(query);			
			
			
		} catch (SQLException e) {
//			System.err.println(e);
		}
		conexion.close();
regAbms(Main.getCod(),fun.getCod(),"Actualizar");
	}
	public static void agregarAdmin(Funcionario fun)throws SQLException  {
		Conexion con=new Conexion();
		Connection conexion = (Connection) con.getConexionPostgres();
		PreparedStatement s;
		
		String query="insert into funcionario"
				+ "(cv, nombreperfil, ci ,correo,telefono,fechanacimiento,direccion,ciudad,contrasenia,empleado,admin,fecharegistrado) values "
				+ "(?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			s=(PreparedStatement) conexion.prepareStatement(query);
			s.setInt(1, fun.getCod());
			s.setString(2, fun.getNombre());
			s.setString(3,fun.getCi());
			s.setString(4, fun.getCorreo());
			s.setString(5,fun.getTelefono());
			s.setDate(6, java.sql.Date.valueOf(fun.getFechaNac()));
			s.setString(7,fun.getDireccion());
			s.setString(8,fun.getCiudad());
			s.setString(9,fun.getContra());
			s.setBoolean(10, fun.isEmpleado());
			s.setBoolean(11, fun.isAdmin());
			s.setDate(12, java.sql.Date.valueOf(fun.getLFechaCon()));

			s.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		conexion.close();
		System.out.println("Datos ingresados correctamente");
		regAbms(Main.getCod(),fun.getCod(),"Agregar");
	}
	public static int ultimoRegAbms() throws SQLException{
		Conexion con=new Conexion();
		int ultimo=0,max=0;
		Connection conexion = con.getConexionPostgres();
		java.sql.Statement s= conexion.createStatement();
		ResultSet rs=  s.executeQuery("select cva from abms order by(cva)  ");
		
		while (rs.next()) {
			//System.out.println(rs.getLong(1)+", "+rs.getString(2)+", "+rs.getLong(3)+", "+rs.getDouble(4)+", "+rs.getDouble(5));
			
			ultimo=(int) rs.getLong(1);
			if(ultimo>max) {
				max=ultimo;
			}
		}
		max++;
		conexion.close();
		
		return max;
	}
	public static int ultimaHojaRutaAcciones() throws SQLException{
		Conexion con=new Conexion();
		int ultimo=0,max=0;
		Connection conexion = con.getConexionPostgres();
		java.sql.Statement s= conexion.createStatement();
		ResultSet rs=  s.executeQuery("select cpmh from pmh order by(cpmh)  ");
		
		while (rs.next()) {
			//System.out.println(rs.getLong(1)+", "+rs.getString(2)+", "+rs.getLong(3)+", "+rs.getDouble(4)+", "+rs.getDouble(5));
			
			ultimo=(int) rs.getLong(1);
			if(ultimo>max) {
				max=ultimo;
			}
		}
		max++;
		conexion.close();
		
		return max;
	}
	public static int ultimocfhp() throws SQLException{
		Conexion con=new Conexion();
		int ultimo=0,max=0;
		Connection conexion = con.getConexionPostgres();
		java.sql.Statement s= conexion.createStatement();
		ResultSet rs=  s.executeQuery("select cfhp from formulariohpmh order by(cfhp)  ");
		
		while (rs.next()) {
			//System.out.println(rs.getLong(1)+", "+rs.getString(2)+", "+rs.getLong(3)+", "+rs.getDouble(4)+", "+rs.getDouble(5));
			
			ultimo=(int) rs.getLong(1);
			if(ultimo>max) {
				max=ultimo;
			}
		}
		max++;
		conexion.close();
		
		return max;
	}
	public static void regAbms(int ca,int cb,String accion)throws SQLException  {
		int ultimo=ultimoRegAbms();
		Conexion con=new Conexion();
		Connection conexion = (Connection) con.getConexionPostgres();
		PreparedStatement s;
		
		String query="insert into abms"
				+ "(cva, funcionario_cv, funcionario_cv2 ,accion) values "
				+ "(?,?,?,?)";
		try {
			s=(PreparedStatement) conexion.prepareStatement(query);
			s.setInt(1, ultimo);
			s.setInt(2, ca);
			s.setInt(3,cb);
			s.setString(4, accion);
			s.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		conexion.close();
	}
	public static void registrarHojaDeRuta(Hoja_de_ruta hj) throws SQLException{
		// TODO Auto-generated method stub
		Conexion con=new Conexion();
		Connection conexion = (Connection) con.getConexionPostgres();
		PreparedStatement s;
		
		String query="insert into formulariohojaderuta"
				+ "(cfhd, numero, fecha ,cantPer,observaciones,legal,refugio,atencion,accionAlbergue,accionSerMedico,accionAlimentacion,accionAyudaHum,accionPasajes,accionCondonacion,accionOtro,otraAccion,fechaOtraAccion) values "
				+ "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			s=(PreparedStatement) conexion.prepareStatement(query);
			s.setInt(1, hj.getCfhd());
			s.setInt(2, Integer.parseInt(hj.getNumero()) );
			s.setDate(3, java.sql.Date.valueOf(hj.getFechaReg()));
			s.setInt(4,hj.getCantPer());
			s.setString(5,hj.getObs());
			s.setBoolean(6, hj.isLegal());
			s.setBoolean(7, hj.isRefugio());
			s.setBoolean(8, hj.isAtencion());
			s.setBoolean(9, hj.isAccionAlbergue());
			s.setBoolean(10, hj.isAccionSerMedico());
			s.setBoolean(11, hj.isAccionAlimentacion());
			s.setBoolean(12, hj.isAccionAyudaHum());
			s.setBoolean(13, hj.isAccionPasajes());
			s.setBoolean(14, hj.isAccionCondonacion());
			s.setBoolean(15, !hj.getAsignacion().equals(""));
			s.setString(16, hj.getAsignacion());
			if(!hj.getAsignacion().equals("")) {
				s.setDate(17, java.sql.Date.valueOf(hj.getFechaAsig()));

			}else {
				s.setDate(17, null);

			}
			
			s.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		conexion.close();
		System.out.println("Datos ingresados correctamente");
		regHojaRutaRegistro(hj);
	}
	private static void regHojaRutaRegistro(Hoja_de_ruta hj) throws SQLException{
		
		// TODO Auto-generated method stub
		Conexion con=new Conexion();
		Connection conexion = (Connection) con.getConexionPostgres();
		PreparedStatement s;
		
		String query="insert into NombresBeneficiario"
				+ "(cnb,formulariohojaderuta_cfhd,formularioregistro_cfr) values "
				+ "(?,?,?)";
		try {
			s=(PreparedStatement) conexion.prepareStatement(query);
			s.setInt(1, ultimoCnb());
			s.setInt(2,hj.getCfhd());
			s.setInt(3,hj.getForm().getCfr());
			

			s.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		conexion.close();
		System.out.println("Datos ingresados correctamente");
	}
	public static void registrarHojaDeRutaAcciones(HojaRutaAcciones hjr) throws SQLException{
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				Conexion con=new Conexion();
				Connection conexion = (Connection) con.getConexionPostgres();
				PreparedStatement s;
				
				String query="insert into pmh"
						+ "(cpmh, accionrealizada,derivado,instruccion,observaciones,fecha) values "
						+ "(?,?,?,?,?,?)";
				try {
					s=(PreparedStatement) conexion.prepareStatement(query);
					s.setInt(1, hjr.getCpmh());
					s.setString(2, hjr.getAccionRealizada());
					s.setString(3,hjr.getDerivado());
					s.setString(4,hjr.getInstruccion());
					s.setString(5,hjr.getObservaciones());
					s.setDate(6,  java.sql.Date.valueOf(hjr.getFechaAccion()));
					
					
					s.executeUpdate();
					
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
				conexion.close();
				System.out.println("Datos ingresados correctamente");
				regHojaRutaAcccionRegistro(hjr);
	}
	private static void regHojaRutaAcccionRegistro(HojaRutaAcciones hjr)throws SQLException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				Conexion con=new Conexion();
				Connection conexion = (Connection) con.getConexionPostgres();
				PreparedStatement s;
				
				String query="insert into formulariohpmh"
						+ "(cfhp,formulariohojaderuta_cfhd,pmh_cpmh) values "
						+ "(?,?,?)";
				try {
					s=(PreparedStatement) conexion.prepareStatement(query);
					s.setInt(1,ultimocfhp());
					s.setInt(2,hjr.getHjr().getCfhd());
					s.setInt(3,hjr.getCpmh());
					

					s.executeUpdate();
					
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
				conexion.close();
				System.out.println("Datos ingresados correctamente");
	}
	
	
}
