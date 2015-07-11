/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.baz.scc.alarmas.depficto.dao;

import com.baz.scc.alarmas.base.dao.CjCRSAlrBaseQueryDao;
import com.baz.scc.alarmas.depficto.model.CjCRSAlrDepoFictoOpcion;
import org.springframework.stereotype.Component;

/**
 * <br><br>Copyright 2014 Banco Azteca. Todos los derechos reservados.
 *
 *
 * @author B229463 Carlos Ever Isai V.E.
 */
@Component(CjCRSAlrDepoFictoQueryDao.BEAN_NAME)
public class CjCRSAlrDepoFictoQueryDao extends CjCRSAlrBaseQueryDao<CjCRSAlrDepoFictoOpcion> {

    public static final String BEAN_NAME = "cjCRSAlrDepoFictoSoloQueryDao";

    @Override
    public String getQuery(CjCRSAlrDepoFictoOpcion opc) {
        String result;

        switch (opc) {
            
            case INSERT_BLOQUEO:
                result = getQryInsertBloqueo();
                break;

            case INSERT_DETALLE:
                result = getQryInsertDetalle();
                break;

            default:
                result = "";
                break;
        }
        return result;
    }

    private String getQryInsertBloqueo() {
        return usuarioCaja.getSentence("{call %s.PQCJALR0001.PACJALRLI0001(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
    }

    private String getQryInsertDetalle() {
        return usuarioCaja.getSentence("{call %s.PQCJALR0001.PACJALRLI0002(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
    }
}