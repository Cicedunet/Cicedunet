# Spring Boot Microservices - Gestion de Commandes

Ce projet est une architecture de microservices utilisant Spring Boot et Spring Cloud, migrée vers PostgreSQL et enrichie d'un système de tracing et de métriques.

## Services
* **microservice-produits** : Gestion du catalogue produits.
* **microservice-commandes** : Gestion des commandes.
* **microservice-paiement** : Gestion des paiements.
* **microservice-clientui** : Interface utilisateur.

## Infrastructure Cloud
* **config-server** : Serveur de configuration centralisé (port 9200).
* **eureka-server** : Serveur de découverte (port 9201).
* **gateway-server** : API Gateway (port 8081).

## Observabilité
* **Tracing** : Intégration de Spring Cloud Sleuth / Micrometer Tracing avec Zipkin.
* **Métriques** : Intégration de Spring Boot Actuator avec Micrometer et Prometheus.

---

## Configuration de PostgreSQL

Chaque microservice métier (`produits`, `commandes`, `paiement`) utilise une base de données PostgreSQL dédiée.

### 1. Prérequis
- Docker et Docker Compose installés.

### 2. Lancement de l'infrastructure
Le fichier `docker-compose.yml` permet de lancer PostgreSQL, Zipkin et Prometheus.

```bash
docker-compose up -d
```

### 3. Lancement des services
Lancer les services dans l'ordre suivant :
1. `config-server`
2. `eureka-server`
3. `gateway-server`
4. Microservices métiers (`produits`, `commandes`, `paiement`, `clientui`).

## Monitoring
- **Zipkin UI** : `http://localhost:9411`
- **Prometheus UI** : `http://localhost:9090`
- **Endpoints Métriques** : Chaque service expose `/actuator/prometheus`.
