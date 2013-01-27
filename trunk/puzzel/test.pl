/* Les terminaisons du présent de l'indicatif */

groupe1("je","e").
groupe1("tu","es").
groupe1("il/elle","e").
groupe1("nous","ons").
groupe1("vous","ez").
groupe1("ils/elles","ent").

/*Tester la terminaison du verbe si elle est egale à "er" */
testdegroupe1(Verbe,DebutVerbe):-append(DebutVerbe, [101,114], Verbe).


/* afficher la congugaison du verbes*/
conjugue(DebutVerbe):-groupe1(Auxiliaire,Terminaison), name(A,Auxiliaire),write(A),write(' '),
		      append(DebutVerbe,Terminaison,Resultat),name(R,Resultat),write(R),nl,fail.

/*Afficher la conjugaison si le verbe est du 1er groupe*/
conjugue_present(Verbe):-testdegroupe1(Verbe,DebutVerbe),conjugue(DebutVerbe).

