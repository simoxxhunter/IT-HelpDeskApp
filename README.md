# IT-HelpDeskApp

Project context
En tant que développeur full stack Java/Angular dans la société ITSolutions, vous êtes chargé de concevoir et de développer un système de gestion des équipements informatiques.

​

​

User Stories

​

Gestion des Équipements Informatiques

En tant qu'administrateur IT, je veux pouvoir ajouter de nouveaux équipements informatiques au système afin de suivre leur état et leur utilisation.

En tant qu'administrateur IT, je veux pouvoir modifier les informations des équipements existants pour maintenir des données à jour.

En tant qu'administrateur IT, je veux pouvoir supprimer des équipements obsolètes ou hors service pour garder le système organisé.

En tant qu'administrateur IT, je veux pouvoir voir une liste de tous les équipements avec leur état actuel pour une gestion efficace.

​

Gestion et Suivi des Pannes

En tant qu'administrateur IT, je veux pouvoir faire la gestion (ajouter,modifier,supprimer) des pannes.

En tant qu'administrateur IT, je veux pouvoir consulter l'historique des pannes pour chaque équipement afin d'identifier les équipements problématiques.

​

Gestion des Tickets de Support

En tant qu'utilisateur, je veux pouvoir créer un ticket de support pour signaler une panne afin de recevoir de l'aide.

En tant qu'administrateur IT, je veux pouvoir attribuer les tickets de support aux techniciens disponibles pour une résolution rapide.

En tant qu'technicien IT, je veux pouvoir voir les tickets qui me sont attribués pour les traiter efficacement.

En tant qu'utilisateur, je veux pouvoir suivre l'état de mon ticket de support pour savoir quand mon problème sera résolu.

​

Bonus

​

Rapports et Statistiques

En tant qu'administrateur IT, je veux recevoir des notifications pour les tickets en attente afin de ne pas manquer de demandes importantes.

En tant qu'administrateur IT, je veux pouvoir voir des statistiques sur les pannes pour identifier les tendances et les problèmes récurrents. En tant qu'administrateur IT, je veux pouvoir générer des rapports sur l'état des équipements pour une meilleure gestion.

En tant qu'administrateur IT, je veux pouvoir générer des rapports sur les performances du service de support pour améliorer l'efficacité.

​

Fonctionnement:

L'Historique des Pannes conserve un enregistrement détaillé de toutes les pannes passées pour chaque équipement. Chaque entrée dans l'historique est liée à un Équipement, permettant ainsi de garder une trace des problèmes rencontrés et des réparations effectuées.
Les Tickets de Support sont créés par les Utilisateurs lorsqu'ils rencontrent des problèmes avec les équipements. Chaque ticket est donc lié à un utilisateur spécifique, ce qui permet de suivre qui a signalé le problème et de maintenir une communication efficace.
Une fois un Ticket de Support créé, il est attribué à un Technicien pour résolution. Cette relation permet de suivre quel technicien est responsable de la résolution du problème et d'évaluer les performances des techniciens en fonction des tickets résolus.
​

Technologies Utilisées

Backend : Spring Boot, Spring Data JPA, Spring Security

Frontend : Angular 16

Base de données : PostgreSQL /MySQL

Test unitaire: JUnit

Conteneurisation: Docker

<img width="539" alt="usecase" src="https://github.com/user-attachments/assets/b8ec2812-26a5-4f04-830c-5afa79a2ee94">

<img width="562" alt="diag" src="https://github.com/user-attachments/assets/5bbd881b-5f3a-48b5-9f4a-72a06508c886">

