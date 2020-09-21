package br.com.javaChallenge.webStore.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.javaChallenge.webStore.business.UsuarioBusiness;
import br.com.javaChallenge.webStore.core.BusinessException;
import br.com.javaChallenge.webStore.core.IService;
import br.com.javaChallenge.webStore.core.model.WebServiceResponse;
import br.com.javaChallenge.webStore.model.Usuario;
import br.com.javaChallenge.webStore.repository.UsuariosRepository;

@Service
public class UsuarioService implements IService<Usuario> {
	
	@Autowired
	private UsuariosRepository usuarioRepository;
	@Autowired
	private UsuarioBusiness usuarioBusiness;

	private WebServiceResponse vWebServiceResponse;

	@Override
	public List<Usuario> listar() {
		return usuarioRepository.findAll();
	}
	
	public List<Usuario> listar(@PathVariable Long usuarioId) {
		return usuarioRepository.findAll();
	}

	@Override
	public Usuario editar(@PathVariable Long usuarioId) {
		return usuarioRepository.findById(usuarioId).get();
	}

	@Override
	public WebServiceResponse adicionar(@RequestBody @Valid Usuario T) {
		try {
			try {
				usuarioBusiness.validaUsuario(T);
			} catch (BusinessException e) {
				vWebServiceResponse = new WebServiceResponse(true, false, e.getMessage());
			}
			@Valid
			Usuario usuario = usuarioRepository.save(T);
			vWebServiceResponse = new WebServiceResponse(usuario);
		} catch (Exception e) {
			vWebServiceResponse = new WebServiceResponse(false, true, e.getMessage());
		}
		return vWebServiceResponse;
	}
	
	public String logon(@RequestBody @Valid Usuario T) {
		Usuario vObjUsuario = usuarioRepository.findAll().stream().filter(x -> x.getLogin().equals(T.getLogin())).findAny().get();
		
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
			e.printStackTrace();
			return null;
		}
	}

}
