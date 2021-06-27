package fr.miage.fsgbd;

import javax.swing.tree.DefaultMutableTreeNode;


/**
 * @param <Type>
 * @author Galli Gregory, Mopolo Moke Gabriel
 */
public class BTreePlus<Type, ValueType> implements java.io.Serializable {
    private Noeud<Type, ValueType> racine;

    public BTreePlus(int u, Executable e) {
        racine = new Noeud<Type, ValueType>(u, e, null);
    }

    public void afficheArbre() {
        racine.afficheNoeud(true, 0);
    }

    /**
     * Méthode récursive permettant de récupérer tous les noeuds
     *
     * @return DefaultMutableTreeNode
     */
    public DefaultMutableTreeNode bArbreToJTree() {
        return bArbreToJTree(racine);
    }

    private DefaultMutableTreeNode bArbreToJTree(Noeud<Type, ValueType> root) {
        StringBuilder txt = new StringBuilder();
        for (KeyValue key : root.keys)
            txt.append(key.toString()).append(" ");

        DefaultMutableTreeNode racine2 = new DefaultMutableTreeNode(txt.toString(), true);
        for (Noeud<Type, ValueType> fil : root.fils)
            racine2.add(bArbreToJTree(fil));

        return racine2;
    }


    public boolean addValeur(KeyValue<Type, ValueType> valeur) {
        System.out.println("Ajout de la valeur : " + valeur.toString());
        if (racine.contient(valeur.getKey()) == null) {
            Noeud<Type, ValueType> newRacine = racine.addValeur(valeur);
            if (racine != newRacine)
                racine = newRacine;
            return true;
        }
        return false;
    }


    public void removeValeur(Type valeur) {
        System.out.println("Retrait de la valeur : " + valeur.toString());
        if (racine.contient(valeur) != null) {
            Noeud<Type, ValueType> newRacine = racine.removeValeur(valeur, false);
            if (racine != newRacine)
                racine = newRacine;
        }
    }
}
