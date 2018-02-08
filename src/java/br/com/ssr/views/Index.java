/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ssr.views;

import eu.webtoolkit.jwt.Signal1;
import eu.webtoolkit.jwt.WApplication;
import eu.webtoolkit.jwt.WBootstrapTheme;
import eu.webtoolkit.jwt.WBreak;
import eu.webtoolkit.jwt.WColor;
import eu.webtoolkit.jwt.WContainerWidget;
import eu.webtoolkit.jwt.WEnvironment;
import eu.webtoolkit.jwt.WFont;
import eu.webtoolkit.jwt.WLength;
import eu.webtoolkit.jwt.WLink;
import eu.webtoolkit.jwt.WMouseEvent;
import eu.webtoolkit.jwt.WPushButton;
import eu.webtoolkit.jwt.WText;
import eu.webtoolkit.jwt.WVBoxLayout;
import eu.webtoolkit.jwt.WtServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Windows
 */
public class Index extends WtServlet {

    private Web web;
    public static String texto = "";

    public interface Path_Response {

        public static String INDEX = "/index";
        public static String SISTEMA = "/sistema";
        public static String CONTATOS = "/constatos";
        public static String SOBRE = "/sobre";
        public static String LOGIN = "/login";
        public static String ADMIN = "/admin";
        public static String OPERADOR = "/operador";
    }

    public Index() {
        super();

        //define icone para web
      //  getConfiguration().setFavicon("images/icone.png");
        
    }

    public WApplication createApplication(WEnvironment env) {

        WApplication app = new WApplication(env);
        configCss();
       
        if (!checkPageFound(app)) {
            return app;
        }

        app.getRoot().setId("root");

        app.setTitle("SSR");

        WVBoxLayout box = new WVBoxLayout(app.getRoot());
        box.setContentsMargins(0, 0, 0, 0);
        this.web = new Web(WApplication.getInstance().getSessionId());
        box.addWidget(web);
        return app;
    }

    public Index getIndex() {

        return this;
    }

    void configCss() {

        WBootstrapTheme p_wtTheme = new WBootstrapTheme();
        p_wtTheme.setVersion(WBootstrapTheme.Version.Version3);

        WApplication.getInstance().setTheme(p_wtTheme);

        WApplication.getInstance().useStyleSheet(new WLink("style/main.css"));
        WApplication.getInstance().useStyleSheet(new WLink("style/tabwidget.css"));
        WApplication.getInstance().useStyleSheet(new WLink("style/tableview.css"));
        WApplication.getInstance().useStyleSheet(new WLink("style/menu.css"));
        WApplication.getInstance().useStyleSheet(new WLink("style/tree.css"));
        
    }

    public WContainerWidget getRoot() {

        return WApplication.getInstance().getRoot();
    }

    public static double convertePixelPorcentoWidth(double pixel) {

        double width = WApplication.getInstance().getEnvironment().getScreenWidth();
        double x = (100 - (pixel * 100 / width));

        return x;
    }

    public static double convertePixelPorcentoHeight(double pixel) {

        double height = WApplication.getInstance().getEnvironment().getScreenHeight();
        double x = (100 - (pixel * 100 / height));

        return x;
    }

    private boolean checkPageFound(WApplication app) {

        boolean status = true;

        switch (app.getInternalPath()) {

            case Path_Response.INDEX:
            case Path_Response.SISTEMA:
                app.redirect("/SSR");
                status = false;
                break;
            case "/":
            case "":

                break;

            default:

                app.getRoot().addWidget(new WBreak());
                WContainerWidget container = new WContainerWidget(app.getRoot());
                container.resize(new WLength(100, WLength.Unit.Percentage), new WLength(100, WLength.Unit.Percentage));
                container.setStyleClass("panel default-panel");

                WText textoError = new WText("<h2>SSR</h2>"
                        + "<h3>Erro pagina não encontrada!</h3>", container);
                textoError.setMargin(15);
                textoError.getDecorationStyle().setForegroundColor(new WColor("#4CAF50"));

                WPushButton btBack = new WPushButton("Voltar", container);
                btBack.getDecorationStyle().setBackgroundColor(WColor.white);
                btBack.getDecorationStyle().setForegroundColor(new WColor("#4CAF50"));
                btBack.getDecorationStyle().setFont(new WFont(WFont.GenericFamily.SansSerif));
                btBack.getDecorationStyle().getFont().setSize(new WLength(13));
                btBack.setToolTip("Volta para pagina do sistema");
                btBack.setMargin(15);

                btBack.clicked().addListener(btBack, new Signal1.Listener<WMouseEvent>() {
                    @Override
                    public void trigger(WMouseEvent arg) {

                        if (arg.getButton() == WMouseEvent.Button.LeftButton) {
                            app.redirect("/SSR");
                        }
                    }
                });

                status = false;
                break;

        }

        return status;
    }
}
