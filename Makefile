LOCAL=~/eclipse-workspace/Elevator/src/
GITHUB=~/Documents/S1/GL/Ascenseur/src/

push: $(LOCAL)
	cp -r $(LOCAL)* $(GITHUB)

pull: $(GITHUB)
	cp -r $(GITHUB)* $(LOCAL) 
