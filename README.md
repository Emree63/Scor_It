<div align = center>

<img src="doc/Images/Banner-Scor_It.png" width="1050">

</div>

<div align = center>

---

&nbsp; ![Android](https://img.shields.io/badge/Android-3DDC84?style=for-the-badge&logo=android&logoColor=white)
&nbsp; ![Kotlin](https://img.shields.io/badge/Kotlin-0095D5?&style=for-the-badge&logo=kotlin&logoColor=white)
&nbsp; ![Google Play](https://img.shields.io/badge/Google_Play-414141?style=for-the-badge&logo=google-play&color=white&logoColor=green)
&nbsp; ![Android Studio](https://img.shields.io/badge/Android%20Studio-3DDC84.svg?style=for-the-badge&logo=android-studio&logoColor=white)

[![Code Smells](https://codefirst.iut.uca.fr/sonar/api/project_badges/measure?project=Scor_It&metric=code_smells&token=f19f43142bada43a272cd7bce342e340e1298f15)](https://codefirst.iut.uca.fr/sonar/dashboard?id=Scor_It)
[![Maintainability Rating](https://codefirst.iut.uca.fr/sonar/api/project_badges/measure?project=Scor_It&metric=sqale_rating&token=f19f43142bada43a272cd7bce342e340e1298f15)](https://codefirst.iut.uca.fr/sonar/dashboard?id=Scor_It)
[![Quality Gate Status](https://codefirst.iut.uca.fr/sonar/api/project_badges/measure?project=Scor_It&metric=alert_status&token=f19f43142bada43a272cd7bce342e340e1298f15)](https://codefirst.iut.uca.fr/sonar/dashboard?id=Scor_It)
[![Security Rating](https://codefirst.iut.uca.fr/sonar/api/project_badges/measure?project=Scor_It&metric=security_rating&token=f19f43142bada43a272cd7bce342e340e1298f15)](https://codefirst.iut.uca.fr/sonar/dashboard?id=Scor_It)
[![Vulnerabilities](https://codefirst.iut.uca.fr/sonar/api/project_badges/measure?project=Scor_It&metric=vulnerabilities&token=f19f43142bada43a272cd7bce342e340e1298f15)](https://codefirst.iut.uca.fr/sonar/dashboard?id=Scor_It)

---

</div>

**Contexte** : Scor'It est une application mobile pour *Android* sur le thème du football :soccer:. Son objectif est de répertorier tous les championnats, équipes, joueurs, etc. afin de permettre à l'utilisateur de les ajouter en favoris et de visualiser les matchs récents correspondants.


API : https://www.football-data.org/documentation/quickstart (Football Data)

IDE : https://developer.android.com/studio (Android Studio)

## :bookmark_tabs: Fonctionnement

### Diagramme de classes du modèle :

```plantuml
@startuml
skinparam defaultFontName Tahoma
skinparam classAttributeIconSize 0
skinparam monochrome true
skinparam shadowing true
skinparam linetype ortho
skinparam class {
    BackgroundColor transparent
}
skinparam package {
    BackgroundColor transparent
}
hide circle

class Contract {
    -start: Calendar
    -until: Calendar

    +duration() : Int
}

abstract class Personne {
    -id: Int
    -firstName: String
    -lastName: String
    -name: String
    -dateOfBirth: Calendar
    -nationality: String

}

class Staff {
}

class Coach {
}

class Player {
    -position: String
    shirtNumber: Int
}

class Team {
    -id: Int
    -name: String
    -shortName: String
    -crest: String
    -adress: String
    -website: String
    -founded: Int
    -clubColors: String
    -venue: String
}

class Area {
    -id: Int
    -name: String
    -code: String
    -flag: String
    -parentArea: String
}

class Competition {
    -id: Int
    -name: String
    -code: String
    -type: String
    -emblem: String
}

class Season {
    -id: Int
    -startDate: Calendar
    -endDate: Calendar
    -currentMatchday: Int
    -winner: Int
}

class Match {
    -id: Int
    -idHomeTeam: Int
    -score: Score
    -idAwayTeam: Int
    -status: String
}

class Score {
    -home: Int
    -away: Int
    -winner: String
}

Personne --> "-contract" Contract

Staff ..|> Personne
Coach ..|> Personne
Player ..|> Personne

Team --> "-staff*" Staff
Team --> "-coach" Coach
Team --> "-squad*" Player
Team --> "-area" Area

Competition --> "-area" Area
Competition --> "-currentSeason" Season

Match --> "-score" Score 

@enduml
```

### Diagramme de classes des interfaces et classes de gestion de l'accées aux données :

```plantuml
@startuml
skinparam defaultFontName Tahoma
skinparam classAttributeIconSize 0
skinparam monochrome true
skinparam shadowing true
skinparam linetype ortho
skinparam class {
    BackgroundColor transparent
}
skinparam package {
    BackgroundColor transparent
}
hide circle

interface GenericDataManager {
    +getItemsByName(substring: String) : List<T>
    +getItems() : List<T>
    +getItemById(id: Int) : T
}

class TeamsManager {
}

class CompetitionsManager {
}

class MatchesManager {
}

class PeopleManager {
}

class AreaManager {
}

abstract class DataManager {
}

class ApiManager {
}

class StubManager {
}

AreaManager ..|> GenericDataManager
PeopleManager ..|> GenericDataManager
MatchesManager ..|> GenericDataManager
CompetitionsManager ..|> GenericDataManager
TeamsManager ..|> GenericDataManager

DataManager --> "-areaMgr" AreaManager
DataManager --> "-peopleMgr" PeopleManager
DataManager --> "-matchesMgr*" MatchesManager
DataManager --> "-competitionsMgr" CompetitionsManager
DataManager --> "-teamsMgr" TeamsManager

ApiManager --|> DataManager
StubManager --|> DataManager

@enduml
```

## :construction_worker: Technicien en charge de l'application

- Emre KARTAL : Emre.KARTAL@etu.uca.fr
- Baptiste MARCEL : Baptiste.MARCEL@etu.uca.fr
<div align="center">
<a href = "https://codefirst.iut.uca.fr/git/emre.kartal">
<img src="https://codefirst.iut.uca.fr/git/avatars/402cf312e853192f42c0135a888725c2?size=870" width="50" >
</a>
<a href = "https://codefirst.iut.uca.fr/git/david.d_almeida">
<img src="https://codefirst.iut.uca.fr/git/avatars/6b1f2a8b8f636d8f4d315b060075578f?size=870" width="50" >
</a>

© IUT - Auvergne
</div>