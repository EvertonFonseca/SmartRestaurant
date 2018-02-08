/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ssr.views.estoque;

import br.com.ssr.views.estoque.div.DivHead;
import eu.webtoolkit.jwt.WContainerWidget;

/**
 *
 * @author Windows
 */
public class PageEstoque extends WContainerWidget {

    private DivHead divHead;
    
    public PageEstoque() {
        
        this.init();
        
    }
    
    /**Esse metedo inicializa todas as instancia desta classe*/
    private void init(){
        
        this.divHead = new DivHead(this);
    }
}
