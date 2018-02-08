/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ssr.views;

import br.com.ssr.views.estoque.PageEstoque;
import eu.webtoolkit.jwt.WContainerWidget;
import eu.webtoolkit.jwt.WLength;
import eu.webtoolkit.jwt.WVBoxLayout;

/**
 *
 * @author Windows
 */
public class PageSistema extends WContainerWidget{

    public PageSistema() {
 
        resize(new WLength(100, WLength.Unit.Percentage),new WLength(100, WLength.Unit.Percentage));
        this.init();
    }
   
    private void init(){
        
        WVBoxLayout boxV = new WVBoxLayout(this);
        boxV.setContentsMargins(0, 0, 0, 0);
        boxV.setSpacing(0);
        
        PageEstoque pageEstque = new PageEstoque();
        
        boxV.addWidget(pageEstque);
        
    }
}
