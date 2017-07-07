package dao;

import java.util.List;

/**
 * Contrat que tous les DAO vont devoir respecter. Il contient les op�rations
 * CRUD de base
 * 
 * @author Eric Sultan
 * @param <BO>
 *            L'objet m�tier g�n�rique
 * @param <PK>
 *            Le type de cl� primaire g�n�rique
 */
public interface Dao<BO, PK>
{

    /**
     * Retourne un objet m�tier en fonction de sa cl� primaire
     * 
     * @param id
     *            Cl� primaire
     * @return L'objet m�tier trouv�
     */
    BO findById(PK id);

    /**
     * Retourne tous les objets m�tiers d'un type donn� de la source de donn�es
     * 
     * @return La liste des objets m�tiers
     */
    List<BO> findAll();

    /**
     * Cr�e un nouvel objet m�tier afin de le persister
     * 
     * @param obj
     *            L'objet � persister
     */
    void create(BO obj);

    /**
     * Retourne un objet m�tier mis � jour
     * 
     * @param obj
     *            L'objet � mettre � jour
     * @return L'objet m�tier mis � jour
     */
    BO update(BO obj);

    /**
     * Supprime un objet m�tier de la source de donn�es
     * 
     * @param obj
     *            L'objet � supprimer
     */
    void delete(BO obj);
}
