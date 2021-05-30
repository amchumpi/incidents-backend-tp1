package com.upc.springfield;

import com.upc.springfield.entidades.Imagen;
import com.upc.springfield.entidades.Rol;
import com.upc.springfield.entidades.TipoIncidencia;
import com.upc.springfield.entidades.Usuario;
import com.upc.springfield.negocio.ServicioImagenCore;
import com.upc.springfield.negocio.ServicioRolCore;
import com.upc.springfield.negocio.ServicioTipoIncidenciaCore;
import com.upc.springfield.negocio.ServicioUsuarioCore;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
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

	@Test
	public void contextLoads() {
	}

	@Test
	public void registrarTiposIncidencia(){
		TipoIncidencia tipoIncidencia;
		//1
		tipoIncidencia= new TipoIncidencia();
		tipoIncidencia.setCodigo("FP");
		tipoIncidencia.setDescripcion("FALTA PEATONAL");
		servicioTipoIncidenciaCore.registrarTipoIncidencia(tipoIncidencia);
		//2
		tipoIncidencia= new TipoIncidencia();
		tipoIncidencia.setCodigo("RB");
		tipoIncidencia.setDescripcion("ROBO");
		servicioTipoIncidenciaCore.registrarTipoIncidencia(tipoIncidencia);
	}

	@Test
	public void registrarRoles(){
		Rol rol;
		rol= new Rol();
		rol.setCodigo("ADM");
		rol.setDescripcion("ADMINISTRADOR");
		servicioRolCore.registrarRol(rol);

		rol= new Rol();
		rol.setCodigo("USR");
		rol.setDescripcion("USUARIO");
		servicioRolCore.registrarRol(rol);
	}

	@Test
	public void registrarUsuario(){
		Usuario usuario;
		Rol rol= new Rol();
		usuario= new Usuario();
		usuario.setDni("73272624");
		usuario.setNombre("aldo");
		usuario.setApellidoPaterno("chumpitaz");
		usuario.setApellidoMaterno("pucllas");
		usuario.setSexo("M");
		//usuario.setFechaNacimiento();
		usuario.setDireccion("Av. Petit thouars 3340");
		usuario.setDistrito("San isidro");
		usuario.setProvincia("Lima");
		usuario.setDepartamento("Lima");
		usuario.setEmail("aldichumpi@gmail.com");
		usuario.setPassword("123456789");
		rol.setCodigo("USR");
		usuario.setRol(rol);

		Usuario u;
		u=servicioUsuarioCore.registrarUsuario(usuario);

		Assert.assertNotNull(u);
	}

    @Test
    public void registrarImagen(){
        List<Imagen> listaImagen= new ArrayList<>();
        MultipartFile[] listaFile=null;
        String path="";
        path="C:\\Users\\aldic\\Pictures\\descarga.jpg";
        //MultipartFile file= new MultipartFile()

        //listaFile.add(file);
        Long codIncidencia=null;
        codIncidencia=Long.parseLong("1");

        listaImagen = servicioImagenCore.RegistrarImagen(codIncidencia,listaFile);

    }

    @Test
    public void obtenerUsuario(){
	    Usuario usuario=null;
	    usuario= servicioUsuarioCore.obtenerUsuarioPorEmail("");
	    Assert.assertNotNull(usuario);
    }
}
