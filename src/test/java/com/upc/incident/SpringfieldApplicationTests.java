package com.upc.incident;

import com.upc.incident.entidades.*;
import com.upc.incident.negocio.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

//@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringfieldApplicationTests {
	@Autowired
	private ServicioTipoIncidenciaCore servicioTipoIncidenciaCore;
	@Autowired
	private ServicioUsuarioCore servicioUsuarioCore;
	@Autowired
	private ServicioRolCore servicioRolCore;
	@Autowired
    private ServicioImagenCore servicioImagenCore;
	@Autowired
	private ServicioTipoDocumentoIdentidadCore servicioTipoDocumentoIdentidadCore;
	@Autowired
	private ServicioCategoriaCore servicioCategoriaCore;

	@Test
	public void contextLoads() {
	}
//
//	@Test
//	public void registrarTiposIncidencia(){
//		TipoIncidencia tipoIncidencia;
//		//1
//		tipoIncidencia= new TipoIncidencia();
//		tipoIncidencia.setCodigo("FP");
//		tipoIncidencia.setDescripcion("FALTA PEATONAL");
//		servicioTipoIncidenciaCore.registrarTipoIncidencia(tipoIncidencia);
//		//2
//		tipoIncidencia= new TipoIncidencia();
//		tipoIncidencia.setCodigo("RB");
//		tipoIncidencia.setDescripcion("ROBO");
//		servicioTipoIncidenciaCore.registrarTipoIncidencia(tipoIncidencia);
//	}
//
//	@Test
//	public void registrarTiposDocumentoIdentidad(){
//		TipoDocumentoIdentidad tipoDocumentoIdentidad;
//		//1
//		tipoDocumentoIdentidad= new TipoDocumentoIdentidad();
//		tipoDocumentoIdentidad.setCodigo("DNI");
//		tipoDocumentoIdentidad.setDescripcion("DOCUMENTO NACIONAL DE IDENTIDAD");
//		servicioTipoDocumentoIdentidadCore.registrarTipoDocumentoIdentidad(tipoDocumentoIdentidad);
//		//2
//		tipoDocumentoIdentidad= new TipoDocumentoIdentidad();
//		tipoDocumentoIdentidad.setCodigo("CE");
//		tipoDocumentoIdentidad.setDescripcion("CARNET DE EXTRANJERÍA");
//		servicioTipoDocumentoIdentidadCore.registrarTipoDocumentoIdentidad(tipoDocumentoIdentidad);
//	}
//
//	@Test
//	public void registrarRoles(){
//		Rol rol;
//		rol= new Rol();
//		rol.setCodigo("ADM");
//		rol.setDescripcion("ADMINISTRADOR");
//		servicioRolCore.registrarRol(rol);
//
//		rol= new Rol();
//		rol.setCodigo("USR");
//		rol.setDescripcion("USUARIO");
//		servicioRolCore.registrarRol(rol);
//	}
//
//	@Test
//	public void registrarCategorias(){
//		Categoria categoria;
//		categoria = new Categoria();
//		categoria.setCodigo("01");
//		categoria.setDescripcion("Freemium");
//		servicioCategoriaCore.registrarCategoria(categoria);
//
//		categoria = new Categoria();
//		categoria.setCodigo("02");
//		categoria.setDescripcion("Premium");
//		servicioCategoriaCore.registrarCategoria(categoria);
//	}
//
/*	@Test
	public void registrarUsuario(){
		Usuario usuario;
		TipoDocumentoIdentidad tipoDocumentoIdentidad;
		Categoria categoria= new Categoria();
		Rol rol= new Rol();
		usuario= new Usuario();
		usuario.setNroDocIdentidad("73272624");
		usuario.setNombre("Aldo Miguel");
		usuario.setApellidoPaterno("Chumpitaz");
		usuario.setApellidoMaterno("Pucllas");
		tipoDocumentoIdentidad= new TipoDocumentoIdentidad();
		tipoDocumentoIdentidad.setCodigo("DNI");
		tipoDocumentoIdentidad.setDescripcion("DOCUMENTO NACIONAL DE IDENTIDAD");
		usuario.setTipoDocIdentidad(tipoDocumentoIdentidad);
		//usuario.setSexo("M");
		//usuario.setFechaNacimiento();
		//usuario.setDireccion("Av. Petit thouars 3340");
		//usuario.setDistrito("San isidro");
		//usuario.setProvincia("Lima");
		//usuario.setDepartamento("Lima");
		usuario.setEmail("aldichumpi@gmail.com");
		usuario.setPassword("123456789");
		rol.setCodigo("USR");
		usuario.setRol(rol);

		categoria.setCodigo("01");
		usuario.setCategoria(categoria);

		Usuario u;
		u=servicioUsuarioCore.registrarUsuario(usuario);

		Assert.assertNotNull(u);
	}*/
//
//    @Test
//    public void registrarImagen(){
//        List<Imagen> listaImagen= new ArrayList<>();
//        MultipartFile[] listaFile=null;
//        String path="";
//        path="C:\\Users\\aldic\\Pictures\\descarga.jpg";
//        //MultipartFile file= new MultipartFile()
//
//        //listaFile.add(file);
//        Long codIncidencia=null;
//        codIncidencia=Long.parseLong("1");
//
//        listaImagen = servicioImagenCore.RegistrarImagen(codIncidencia,listaFile);
//
//    }

//    @Test
//    public void obtenerUsuario(){
//	    Usuario usuario=null;
//	    Credenciales credenciales= new Credenciales();
//	    credenciales.setEmail("aldichumpi@gmail.com");
//	    credenciales.setPassword("123456789");
//	    usuario= servicioUsuarioCore.validarUsuario(credenciales);
//	    Assert.assertNotNull(usuario);
//    }
}
