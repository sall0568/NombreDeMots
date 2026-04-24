# NombreDeMots 📝

Programme Java de **comptage de mots** dans un fichier texte.

## 📋 Description

Ce programme lit le contenu d'un fichier texte à l'aide d'un **Scanner** (File Scanner), analyse chaque ligne en séparant les mots par les espaces, et affiche le **nombre total de mots** contenus dans le fichier.

### Fonctionnement

1. L'utilisateur saisit le chemin du fichier à analyser.
2. Le programme ouvre le fichier avec un `Scanner` (lecteur de fichiers).
3. Une boucle lit chaque ligne dans une `String` (chaîne de caractères).
4. Chaque ligne est séparée en utilisant l'**espace comme délimiteur** (`split("\\s+")`).
5. Le nombre de mots de chaque ligne est compté grâce à la **longueur du tableau** créé après la séparation.
6. Les mots de toutes les lignes sont additionnés.
7. Le **nombre total de mots** est affiché à l'écran.

## 🛠️ Prérequis

- **Java JDK** 17 ou supérieur (testé avec Amazon Corretto 24)

## 🚀 Compilation et Exécution

### Compiler le programme

```bash
javac -d out src/NombreDeMots.java
```

### Exécuter le programme

```bash
java -cp out NombreDeMots
```

Le programme vous demandera de saisir le chemin du fichier à analyser.

### Exemple d'exécution

```
===========================================
   PROGRAMME DE COMPTAGE DE MOTS
===========================================

Entrez le chemin du fichier a analyser : test/fichier_test1.txt

Lecture du fichier : C:\...\test\fichier_test1.txt
Analyse en cours...

  Ligne 1 : 3 mot(s)
  Ligne 2 : 5 mot(s)
  Ligne 3 : 6 mot(s)

Total de lignes lues : 3

-------------------------------------------
Nombre total de mots dans le fichier : 14
-------------------------------------------
```

## 🧪 Tests

Le dossier `test/` contient plusieurs fichiers de test :

| Fichier | Description | Mots attendus |
|---------|-------------|:-------------:|
| `fichier_test1.txt` | Fichier simple (3 lignes) | 14 |
| `fichier_test2.txt` | Fichier avec lignes vides | 64 |
| `fichier_test3_vide.txt` | Fichier vide | 0 |
| `fichier_test4_long.txt` | Fichier volumineux (30 lignes) | ~270 |

### Cas testés

- ✅ Fichier avec plusieurs lignes de texte
- ✅ Fichier contenant des lignes vides (ignorées)
- ✅ Fichier complètement vide (0 mots)
- ✅ Fichier volumineux avec beaucoup de contenu
- ✅ Fichier inexistant (message d'erreur affiché)

## 📁 Structure du projet

```
NombreDeMots/
├── src/
│   └── NombreDeMots.java    # Code source principal
├── test/
│   ├── fichier_test1.txt     # Test simple
│   ├── fichier_test2.txt     # Test avec lignes vides
│   ├── fichier_test3_vide.txt # Test fichier vide
│   └── fichier_test4_long.txt # Test fichier volumineux
├── .gitignore
└── README.md
```

## 👤 Auteur

Aissatou SALL

## 📄 Licence

Projet réalisé dans le cadre d'un exercice de programmation Java.
