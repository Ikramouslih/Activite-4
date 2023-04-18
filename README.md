# JEE-LivrableContrôle

Cette application est un projet Spring boot basé sur Spring MVC, Spring Data, JPA, Hibernate, et qui englobe l'ensemble des concepts vues et pratiquées lors du cours JEE.

### Travail à faire ###
- Cette application représente le résultat des activités pratiques N°2, N°3 et N°4.
- L'application comprend les parties suivantes :
  
  1- Couche Dao:
    * Entité JPA Patient
    * Interface PatientRepository basée sur Spring Data
    * Test de la couche DAO
    
  2- Couche Web :
    * Contrôleur Spring MVC : PatientContrôller
    * Les vues basées sur Thymeleaf : 
     template.html : Page Template basée sur Thymeleaf layout,
     patients.html : Afficher, chercher, éditer, supprimer les patients avec pagination,
     formPatient.html : pour la saisie et l'ajout d'un patient avec la validation des données,
     editPatient.html : pour l'édition et la mise à jour d'un patient.
     
  3- Partie sécurité avec Spring Security.

### La configuration du projet ### 
- SDK : 1.8 Oracle OpenJDK version 18.0.2
- Java : 17
- Type : Maven 
- Packaging : Jar 

### Les dépendances utilisées ### 
- Spring Web : pour créer des applications Web, y compris RESTful, à l'aide de Spring MVC. Utilise Apache Tomcat comme conteneur intégré par défaut.
- Spring DATA JPA : Pour conserver les données dans ‘SQL stores‘ avec Java Persistance API à l’aide de Spring Data et Hibernate. C'est un module qui facilite le ORM basé sur JPA. Il est utilisé avec les bases de données relationnelles.
- H2 Database : Une base de données intégrée, open source et en mémoire. C'est un système de gestion de base de données relationnelle écrit en Java. C'est une application client/serveur et elle est généralement utilisée dans les tests unitaires.
- MySQL : MySQL est l'un des systèmes de bases de données relationnelles les plus populaires et il est souvent utilisé dans les applications Spring Boot.
- Lombok : Un outil de bibliothèque Java qui génère du code pour minimiser le code ‘boilerplate’. La bibliothèque remplace le code ‘boilerplate’ par des annotations faciles à utiliser (Exemples : @NoArgsConstructor, @Getter, @Setter…).
- Thymeleaf : Un moteur de modèle Java moderne coté serveur qui nous permet d’afficher correctement des pages HTML qui peuvent fonctionner comme des prototypes statiques.
- Thymeleaf-extras-springsecurity6 : Une bibliothèque qui fournit des extensions Thymeleaf pour faciliter l'intégration de Spring Security avec Thymeleaf.
- Spring-boot-starter-security : Une dépendance Spring Boot qui fournit un ensemble de fonctionnalités de sécurité pour votre application Spring Boot. Cette dépendance inclut Spring Security.
- Spring-boot-starter-validation : Une dépendance qui fournit une prise en charge de la validation des données dans les applications Spring Boot. Cette dépendance inclut Hibernate Validator, qui est une implémentation de référence de la spécification de validation de Bean Validation.
- Bootstrap/Bootstrap icons : Une bibliothèque open-source de développement front-end pour la conception de sites et d'applications web. Elle fournit des styles CSS prédéfinis, des composants JavaScript et des icônes pour faciliter la création d'interfaces utilisateur esthétiques et responsives.
- Spring-boot-devtools : une dépendance Spring Boot qui fournit des outils de développement pratiques pour le développement de vos applications Spring Boot. Cette dépendance a été utilisé dans cette activité pour :
    * Le mécanisme de rechargement automatique des classes en mode développement; 
    * Le serveur embarqué qui permet de redémarrer l'application automatiquement lorsqu'un changement est détecté.

### L'interface de l'Output et les fonctionnalités implémentées ### 

- La page d'acceuil et d'authentification :  

![1](https://user-images.githubusercontent.com/60039200/232346478-8d62c8e7-b6e4-4a42-ac23-6e84c1263439.PNG)

- L'interface si le compte est un compte USER : 

![2](https://user-images.githubusercontent.com/60039200/232346817-426ba489-2a6e-4c45-a65c-058f1f452c97.PNG)

- Un User peut chercher un patient et naviguer la pagination : 

![3](https://user-images.githubusercontent.com/60039200/232346946-3b67e52e-0791-4cd3-a730-e11577f71ede.PNG)

- La recherche avec un mot clé : 

![1](https://user-images.githubusercontent.com/60039200/232354963-7282a43a-5fe4-4db3-a6ee-28b06878fc6a.PNG)

- Les Urls de l'Admin sont également protégés :

![5](https://user-images.githubusercontent.com/60039200/232347050-5e1fc920-5b6d-4638-8d30-f5d0a9b13468.PNG)

- Un User peut se déconnecter : 

![4](https://user-images.githubusercontent.com/60039200/232347141-68c01269-96ba-4cdf-aec1-d158c628aecd.PNG)

- Authentification de l'Admin avec la fonctionnalité "Remember Me" qui permet de se souvenir du dernier compte qui a été connecté : 

![11](https://user-images.githubusercontent.com/60039200/232347341-23d467bd-4cb1-4b7b-9c8d-c940cbc3c3dc.PNG)

- Un Admin peut chercher, ajouter, modifier ou supprimer un patient : 

![22](https://user-images.githubusercontent.com/60039200/232347833-c8b65574-d538-43a2-a44f-da3075dbb772.PNG)

- Le formulaire d'ajout d'un patient :

![formulaire d'ajout](https://user-images.githubusercontent.com/60039200/232347675-3c7b99d4-1ae4-4cc5-a5fe-ca21c94a41b7.PNG)

![tststst](https://user-images.githubusercontent.com/60039200/232347714-6c358c00-5cbc-4dff-9e09-d25ccefc72aa.PNG)

- La modification d'un patient : 

![55 edit 1](https://user-images.githubusercontent.com/60039200/232349351-18bb4f59-3ed0-4331-81bd-815ff5206a7a.PNG)

![55 edit 3](https://user-images.githubusercontent.com/60039200/232348396-516d689d-9fbc-447a-be12-16e675d70cae.PNG)

- La suppression d'un patient : 

![44 sup 1](https://user-images.githubusercontent.com/60039200/232347919-52c3f1c8-828c-43b6-a6b7-65420295cd67.PNG)

![44 sup 2](https://user-images.githubusercontent.com/60039200/232348030-79dccd4c-a15b-49c8-b83e-b7bdabbbcd83.PNG)

- Les champs des formulaires sont controlés et validés :

![1111](https://user-images.githubusercontent.com/60039200/232349593-745715cf-262d-446b-9f97-8bc4ca86a29e.PNG)

