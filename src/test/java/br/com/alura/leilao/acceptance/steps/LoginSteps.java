package br.com.alura.leilao.acceptance.steps;

import br.com.alura.leilao.e2e.pages.Browser;
import br.com.alura.leilao.e2e.pages.LeiloesPage;
import br.com.alura.leilao.e2e.pages.LoginPage;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;

public class LoginSteps {

    private Browser browser;
    private LoginPage loginPage;
    private LeiloesPage leiloesPage;

    @Dado("o usuario valido")
    public void o_usuario_valido() {
        browser = new Browser();
        browser.seed();
        loginPage = browser.getLoginPage();
    }

    @Quando("realiza o login")
    public void realiza_o_login() {
        leiloesPage = this.loginPage.realizaLoginComo("fulano","pass");
    }

    @Entao("eh redirecionado para a pagina de leiloes")
    public void eh_redirecionado_para_a_pagina_de_leiloes() {
        Assert.assertTrue(this.leiloesPage.estaNaPaginaDeLeiloes());
        browser.clean();
    }

    @Dado("um usuario invalido")
    public void um_usuario_invalido() {
        browser = new Browser();
        browser.seed();
        loginPage = browser.getLoginPage();
    }

    @Quando("tenta se logar")
    public void tenta_se_logar() {
        leiloesPage = this.loginPage.realizaLoginComo("fulano123","pass123");
    }
    @Entao("continua na pagina de login")
    public void continua_na_pagina_de_login() {
        Assert.assertTrue(loginPage.estaNaPaginaDeLoginComErro());
        browser.clean();
    }

}
