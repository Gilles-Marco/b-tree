## Etude

Dans le cadre de notre projet nous avons été amené à étudier et comparer les temps de recherche d'une clef dans un arbre avec deux méthodes : la méthode de recherche séquentielle (rechercheSéquentielle) dans le fichier de données et la recherche depuis grâce à l'index (rechercheArbre).

Nous avons dans un premier temps créer un nouvel éxécutable nous permettant d'éxécuter des recherches selon les différentes méthodes dans l'arbre :

Puis nous avons pour la recherche depuis l'index, utilisé la fonction contient(Type valeur) qui nous était déjà fournis dans Noeud.java par nos professeurs que nous avons appelé "rechercheArbre". 
Pour la rechercheSéquentielle nous avons crée un algorythme qui s'éxécute en plusieurs étapes :
1. L'algorythme regarde si les clefs contenus dans la racine sont égales à la valeur recherchée. Si oui on return la clef et on arrête là
2. Sinon on push dans un stack les noeuds fils de la racine
3. On pop le stack pour avoir un noeud fils de la racine, et on recommence au 1. en remplaçant la racine par le noeud obtenu depuis le stack
4. Quand on descend suffisament pour que le noeud n'est plus de fils, plus de noeuds ne sont rajoutés dans la stack et de ce fait nous remontons petit à petit dans l'arbre en le balayant.
5. Si plus aucun noeuds n'est présent dans le stack et que nous n'avons toujours pas trouvé la clef, on retourne null

En éxécutant rechercheArbre et rechercheSequentielle, nous obtenions des résultats assez surprenant, dans quelques cas rechercheSequentielle était plus rapide que rechercheArbre alors que théoriquement cela aurait du être l'inverse dû à la différence de compléxité théorique O(log(n)) et O(n) entre les 2 méthodes indépendament de leur implémentation.

Nous avons donc décidé de recréer la méthode rechercheArbre que nous avons nommée rechercheArbreHomemade(), qui est une méthode de recherche via l'index de manière **itérative**, là où Noeud.contient est **récursif**.
rechercheArbreHomemade implémente l'algorythme suivant:
1. On définit un noeud, le premier étant la racine
2. On créer une boucle while tant que result == null (result est la variable qui va contenir la clef qui a été trouvé)
3. On itère sur les clefs du noeud, pour voir si la clef est égale à la clef que l'on recherche, si oui on remplace result par la clef et on sort de l'itération sur les clefs du noeud 
4. sinon on applique testInteger.compare(clefATrouver, clef), afin de savoir si clefATrouver est plus petit que clef, si oui on remplace noeud par le noeud fils au même index que clef et on sort de l'itération sur les clefs du noeud.
5. Si aucun noeud n'est plus petit que clefATrouver alors on remplace noeud par le dernier noeud fils dans l'arraylist puis on recommence à partir de 3.
6. Si le noeud n'a plus de fils et que l'on a toujours pas trouvé la clef, alors on retourne null

Avec cette nouvelle version de la méthode de recherche, on obtient des résultats qui concordent avec la théorie.

### Graphiques

Voici ci-dessous les graphiques des résultats que nous avons obtenus sur un total de 100 recherche de clef. Sur ces graphiques, nous avons comparé les moyennes, les minimums et les temps maximums de recherche avec les trois méthodes et avec des échantillons de taille de clefs différentes (1000,10000 et 100000).

Graphique des moyennes de temps de recherche :
![Graphique des moyennes](https://github.com/Gilles-Marco/b-tree/blob/master/etude/graphics/GraphMoyennes.png)

Graphique des temps de recherche minimum :
![Graphique des minimums](https://github.com/Gilles-Marco/b-tree/blob/master/etude/graphics/GraphMinimums.png)

Graphique des temps de recherche maximum :
![Graphique des maximums](https://github.com/Gilles-Marco/b-tree/blob/master/etude/graphics/GraphMaximums.png)

Au vu des résultats la méthode de recherche depuis l'index est bien plus efficace que la recherche séquentielle du à la complexité des méthodes.