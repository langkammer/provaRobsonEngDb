package br.com.robsonlangkammer.bean;

public class PesquisaClienteBean {

    public String getCampoPesquisado() {
        return campoPesquisado;
    }

    public void setCampoPesquisado(String campoPesquisado) {
        this.campoPesquisado = campoPesquisado;
    }

    public String getPesquisa() {
        return pesquisa;
    }

    public void setPesquisa(String pesquisa) {
        this.pesquisa = pesquisa;
    }

    private String campoPesquisado;

    private String pesquisa;

}
