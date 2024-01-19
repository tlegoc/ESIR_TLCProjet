# ESIR_TLCProjet
 
Dépot git du projet de TLC de Robin Gaignoux, Rémi Cazoulat, Kilian Marcelin et Théo Le Goc.

# Fichiers

- `compiler/` : code source du compilateur, écrit en java.
- `grammaire/` : fichier de grammaire décrivant la syntaxe du while.
- `lib/` : code source de la librairie runtime, utilisée lors de la transformation du `.while` en `.exe`.
- `tests/` : fichiers source `.while` utilisés lors des tests

# Prérequis

Java version 17 et supérieure.

Vous pouvez récupérer une version précompilée sur [la page release du git](https://github.com/tlegoc/ESIR_TLCProjet/releases)

## Linux
- GCC installé et trouvable dans le PATH

## Windows
- Visual Studio avec les cibles C++

# Comment utiliser 

Nous recommandons d'utiliser Intellij IDEA pour ouvrir le projet.
1. Dans le dossier `compiler` se trouve le code source du compilateur. Ouvrez le avec Intellij ou votre IDE.
2. Vérifiez la présence de `lib_while.h` et `while.lib` pour windows, `libwhile.a` pour linux. Si ils ne sont pas présents, compilez la librairie runtime via `compile_windows.bat` ou `compile_linux.sh` présent dans `lib/`.
3. Vérifiez que votre répertoire de travail se trouve a la racine du compiler (dossier `compiler`).
4. Vous pouvez maintenant lancer le projet. En arguments doit se trouver le chemin vers votre fichier `.while`
5. Un fichier éxécutable sera généré à côté du fichier source.

# Compiler le .jar

Suivez les étapes d'utilisation jusqu'au point 2. Ensuite, compilez les artéfacts avec intellij. **Build > Build Artifacts**

# Utiliser le jar

`java -jar compiler.jar <CHEMIN_VERS_VOTRE_FICHIER_SOURCE>`

# While

Exemple :
```
function add :
read Op1, Op2
%
    Result := Op1 ;
    for Op2 do
        Result := ( cons nil Result )
    od
%
write Result

function main :
read Param1, Param2
%
    Result := (add Param1 Param2);
    Out := (cons int Result)
%
write Out
```
Ce programme va prendre en paramètres 2 entiers ou arbre, puis les sommer en considérant que ce sont des entiers. Affiche la somme en sortie, sous forme d'entier.

# Erreurs connues, TODO

- ~~Une fonction ne peut pas avoir une variable de retour et de sortie partageant le même nom, bug au niveau de la compilation en C++.~~
- L'utilisation d'une variable de retour avant qu'elle soit initialisée fait crash le programme (ajouter une validation).
- ~~Variables mal assignées en C++ (lorsqu'on fait var1 = var2, on a simplement une copie du pointeur. Au final ça ne copie pas réellement la valeur).~~
- ~~Programmer le main comme expliqué dans la spécification (à savoir entrée en paramètres, appel de la fonction nommée main dans le programme while).~~
- ~~Pretty printer.~~
- ~~Fonctions à plusieurs sorties. Actuellement le programme va correctement parser le code mais ne prendra en compte que la première valeur de retour.~~
- ~~assignation multiple (ACTUELLEMENT UNE ASSIGNATION MULTIPLE VA ASSIGNER LA PREMIERE VARIABLE A LA DEUXIEME VARIABLE ***D'ENTREE***, il serait judicieux de produire une erreur de compilation le temps que ce soit fix).~~
- ~~La validation ne vérifie pas que les variables existent bien quand on les utilises (à l'exception de la première variable de sortie d'une fonction).~~
- ~~Appels de fonction dans un while~~
- ~~Appels de fonction dans appel de fonction~~
- ~~Pouvoir mettre des symboles dans les arbres (`(cons a (cons b))` censé créer un string `ab`, actuellement fait ???)~~
- ~~Différentier une variable nommée `SYMBOL` du tag SYMBOL de l'ast~~
- Validation pas totalement au point, mais très proche
