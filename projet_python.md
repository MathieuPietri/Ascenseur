# Projet Python
## Fonctionnement
Pour utiliser ceci, ouvrir un interprète python3 dans le dossier.
et faire:
```py
from projet_python import *
```
Nous avons 3 états pour les appels de déplacements:
- **NONE** : qui correspond à un appel depuis la cabine
- **UP** : qui correspond à un appel depuis un étage voulant monter
- **DOWN** : qui correspond à un appel depuis un étage voulant descendre

L'ascenseur a comme états:
- **running** : l'ascenseur est actif (le moteur tourne) si **true**
- **cur_floor** : l'étage courant de l'ascenseur
- **cur_dir** : la direction courante de l'ascenseur (UP = 1 | DOWN = 2)

## Les files
Nous avons 2 files, la **up_queue** et la **down_queue** correspondants aux demandes montantes et descendantes.

## Simulation
```py
add_event(2, DOWN) # envoie une demande au système, qqn au 2e veut descendre
iter() # lance une itération de l'ascenseur, monte ou descend d'un étage selon les files
# peut être appelé plusieurs fois de suite
``` 
