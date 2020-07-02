package br.com.javaChallenge.webStore.core.model;

public class WebServiceResponse {

	private Boolean erro;
	private Boolean businessException;
	
	private String mensagem;
	private Object model;
	
	public WebServiceResponse(Boolean businessException, Boolean Exception, String mensagem) {
		super();
		if (businessException)
			this.businessException = businessException;
		else
			this.erro = Exception;
		this.mensagem = mensagem;
	}
	
	public WebServiceResponse(Object model) {
		super();
		this.model = model;
	}

	public Boolean getErro() {
		return erro;
	}
	public void setErro(Boolean erro) {
		this.erro = erro;
	}
	public Boolean getBusinessException() {
		return businessException;
	}
	public void setBusinessException(Boolean businessException) {
		this.businessException = businessException;
	}
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	public Object getModel() {
		return model;
	}
	public void setModel(Object model) {
		this.model = model;
	}
}
