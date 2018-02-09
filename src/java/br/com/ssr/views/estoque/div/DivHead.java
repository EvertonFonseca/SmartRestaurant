/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ssr.views.estoque.div;

import eu.webtoolkit.jwt.AlignmentFlag;
import eu.webtoolkit.jwt.Side;
import eu.webtoolkit.jwt.WApplication;
import eu.webtoolkit.jwt.WContainerWidget;
import eu.webtoolkit.jwt.WHBoxLayout;
import eu.webtoolkit.jwt.WLength;
import eu.webtoolkit.jwt.WTemplate;
import eu.webtoolkit.jwt.WText;
import eu.webtoolkit.jwt.WVBoxLayout;
import java.util.EnumSet;

/**
 *
 * @author Windows
 */
public class DivHead extends WContainerWidget{

    public DivHead() {

        this.init();
    }

    public DivHead(WContainerWidget parent) {
        super(parent);

        this.init();

    }
    
    /**Inicializa todo das as instancia*/
    private void init(){
           
        resize(new WLength(100, WLength.Unit.Percentage), new WLength(90, WLength.Unit.Pixel));
        setMinimumSize(new WLength(100, WLength.Unit.Percentage), new WLength(90, WLength.Unit.Pixel));
        setMaximumSize(new WLength(100, WLength.Unit.Percentage), new WLength(90, WLength.Unit.Pixel));
        setStyleClass("polaroide");
        
        WVBoxLayout vBox = new WVBoxLayout(this);
        
        WContainerWidget divMenus = new WContainerWidget();
        divMenus.resize(WLength.Auto,new WLength(100, WLength.Unit.Percentage));
        
        WHBoxLayout boxMenu = new WHBoxLayout(divMenus);
        boxMenu.setContentsMargins(0, 0, 0, 0);
        boxMenu.setSpacing(25);
        
        WTemplate tempConfig = new WTemplate();
        tempConfig.setTemplateText("<div class=\"dropdown\">\n"
                + "  <div class=\"dropbtn\">Fornecedor</div>\n"
                + "  <div class=\"dropdown-content\">\n"
                + "    <div>${menu-cadastro}</div>\n"
                + "    <div></div>\n"
                + "  </div>\n"
                + "</div>");
        
        WContainerWidget menuCadastroFornecedor = new WContainerWidget();
        menuCadastroFornecedor.setContentAlignment(AlignmentFlag.AlignLeft);
        menuCadastroFornecedor.clicked().addListener(menuCadastroFornecedor,(arg)->{
        
        });
        WText text = new WText("Cadastro",menuCadastroFornecedor);
     
        tempConfig.bindWidget("menu-cadastro",menuCadastroFornecedor);
        
        WTemplate tempCadastro = new WTemplate();
        tempCadastro.setTemplateText("<div class=\"dropdown\">\n"
                + "  <div class=\"dropbtn\">Cadastros</div>\n"
                + "  <div class=\"dropdown-content\">\n"
                + "    <div >Julietas</div>\n"
                + "    <div >Tipo de Conjunto</div>\n"
                + "    <div >Caminhões</div>\n"
                + "    <div >Pátios</div>\n"
                + "    <div >Rotas</div>\n"
                + "  </div>\n"
                + "</div>");
        
        WTemplate tempTool = new WTemplate();
        tempTool.setTemplateText("<div class=\"dropdown\">\n"
                + "  <div class=\"dropbtn\">Ferramentas</div>\n"
                + "  <div class=\"dropdown-content\">\n"
                + "  </div>\n"
                + "</div>");
        
        WTemplate tempModel = new WTemplate();
        tempModel.setTemplateText("<div class=\"dropdown\">\n"
                + "  <div class=\"dropbtn\">Módulos</div>\n"
                + "  <div class=\"dropdown-content\">\n"
                + "  </div>\n"
                + "</div>");
      
        //add menus
        boxMenu.addWidget(tempConfig,0,AlignmentFlag.AlignMiddle);
        boxMenu.addWidget(tempCadastro,0,AlignmentFlag.AlignMiddle);
        boxMenu.addWidget(tempTool,0,AlignmentFlag.AlignMiddle);
        boxMenu.addWidget(tempModel,0,AlignmentFlag.AlignMiddle);
        
        vBox.addWidget(divMenus, 0,EnumSet.of( AlignmentFlag.AlignCenter,AlignmentFlag.AlignMiddle));
    }
}
