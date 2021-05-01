/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.Prodi;

/**
 *
 * @author putri ramadani rais
 */
@Stateless
public class ProdiFacade extends AbstractFacade<Prodi> {

    @PersistenceContext(unitName = "RPS_AKADEMIK_KEL4PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProdiFacade() {
        super(Prodi.class);
    }
    
    public Prodi getLastProdi() {
        return em
                .createNamedQuery("Prodi.getLast", Prodi.class)
                .getResultList()
                .stream()
                .findFirst()
                .orElse(null);
    }
    
}
