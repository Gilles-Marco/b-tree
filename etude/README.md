## Etude

Dans le cadre de notre projet nous avons été amené à étudier et comparer les temps de recherche d'une clef dans un arbre avec deux méthodes : la méthode de recherche séquentielle dans le fichier et la recherche depuis l'index (arbre).

Nous avons dans un premier temps modifié l'application afin d'avoir un nouveau main nous permettant de tester sans avoir à lancer l'interface graphique :

Dans un premier temps nous avons pour la recherche depuis l'index, utilisé la fonction déjà fournie (rechercheArbre) par nos professeurs. Cependant, nous avions des résultats assez surprenant, nous avons donc pris la décision de recréer la méthode avec une nouvelle version que nous avons nommée rechercheArbreHomemade().
En effet la méthode de recherche depuis l'index est sensée être plus rapide, or nous n'avons pas constaté cela, nous avons eu le contraire.

### Graphiques

Voici ci-dessous les graphiques des résultats que nous avons obtenus. Sur ces graphiques, nous avons comparé les moyennes, les minimums et les temps maximums de recherche avec les deux méthodes. (Nous avons laissé la méthode initiale afin que vous puissiez voir les raisons qui nous on fait refaire la méthode)

Graphique des moyennes de temps de recherche :
![Graphique des moyennes](https://github.com/Gilles-Marco/b-tree/blob/master/etude/graphics/GraphMoyennes.png)

Graphique des temps de recherche minimum :
![Graphique des minimums](https://github.com/Gilles-Marco/b-tree/blob/master/etude/graphics/GraphMinimums.png)

Graphique des temps de recherche maximum :
![Graphique des maximums](https://github.com/Gilles-Marco/b-tree/blob/master/etude/graphics/GraphMaximums.png)

Les résultats sont sans appels : la méthode de recherche depuis l'index est bien plus efficace que la recherche séquencielle. Effectivement, la différence est d'un facteur proche de 100 pour les moyennes entre les deux méthodes.
