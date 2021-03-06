package br.com.javaChallenge.webStore.resource;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.javaChallenge.webStore.core.IResource;
import br.com.javaChallenge.webStore.core.model.WebServiceResponse;
import br.com.javaChallenge.webStore.model.Usuario;
import br.com.javaChallenge.webStore.service.UsuarioService;

@RestController
@CrossOrigin("${origem-permitida}")
public class UsuarioResource implements IResource<Usuario> {
	
	@Autowired
	private UsuarioService usuarioService;

	@Override
	@GetMapping("/usuario")
	public List<Usuario> listar() {
		return usuarioService.listar();
	}
	
	@Override
	@GetMapping("/usuario/{usuarioId}")
	public Usuario editar(@PathVariable Long usuarioId) {
		return usuarioService.editar(usuarioId);
	}
	
	@Override
	@PostMapping("/usuario")
	public WebServiceResponse adicionar(@RequestBody @Valid Usuario T) {
		return usuarioService.adicionar(T);
	}
	
	@PostMapping("/usuarioLogin")
	public String logon(@RequestBody @Valid Usuario T) {
		Usuario vObjUsuario = usuarioService.listar().stream().filter(x -> x.getLogin().equals(T.getLogin())).findAny().get();
		
		String vHashCode = geraHashCode(vObjUsuario.getChave(), "MD5");
		String vCHAVE = geraHashCode(T.getChave(), "MD5");
		if (vHashCode.equals(vCHAVE)) {
			String vSESSION = geraHashCode(vObjUsuario.getLogin()+vObjUsuario.getChave(), "SHA-256");
			return vSESSION; 
		}
		return null;
	}
	
	public String geraHashCode(String value, String algorithm) {
        MessageDigest md = null;
		try {
			md = MessageDigest.getInstance(algorithm);
	        md.update(value.getBytes());
	        byte[] bytes = md.digest();
	        return new String(bytes);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

}
