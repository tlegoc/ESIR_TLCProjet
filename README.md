# ESIR_TLCProjet
 
Dépot git du projet de TLC de Robin Gaignoux, Rémi Cazoulat, Kilian Marcelin et Théo Le Goc.

# Fichiers

- `compiler/` : code source du compilateur, écrit en java.
- `grammaire/` : fichier de grammaire décrivant la syntaxe du while.
- `lib/` : code source de la librairie runtime, utilisée lors de la transformation du `.while` en `.exe`.
- `tests/` : fichiers source `.while` utilisés lors des tests

# Prérequis

- GCC installé et trouvable dans le PATH

# Comment utiliser 

Nous recommandons d'utiliser Intellij IDEA pour ouvrir le projet.
 - Dans le dossier `compiler` se trouve le code source du compilateur. Ouvrez le avec Intellij ou votre IDE.
 - Vérifiez la présence de `lib_while.h` et `libwhile.a`. Si ils ne sont pas présents, compilez le projet cmake présent dans `lib/`, puis copiez la librairie ainsi construite et le fichier `.h` dans le répertoire racine du projet java.
 - Vous pouvez maintenant lancer le projet. En arguments doit se trouver le chemin vers votre fichier `.while` et optionnellement le nom de la fonction main. Par défaut, le compilateur prendra la fonction nommée `main` si existante.
 - Un fichier éxécutable sera généré à côté du fichier source.

# Erreurs connues, TODO

- Programmer le main comme expliqué dans la spécification (à savoir entrée en paramètres, appel de la fonction nommée main dans le programme while).
- Pretty printer.
- Fonctions à plusieurs sorties. Actuellement le programme va correctement parser le code mais ne prendra en compte que la première valeur de retour.
- ~~assignation multiple (ACTUELLEMENT UNE ASSIGNATION MULTIPLE VA ASSIGNER LA PREMIERE VARIABLE A LA DEUXIEME VARIABLE ***D'ENTREE***, il serait judicieux de produire une erreur de compilation le temps que ce soit fix).~~
- La validation ne vérifie pas que les variables existent bien quand on les utilises (à l'exception de la première variable de sortie d'une fonction).
