/** 
    Calcule le prix TTC à partir d'un prix hors taxe.
    Le pourcentage de taxe est de 20%.
    @param  prixHT  Prix hors taxe
    @return prixHT augmenté de 20%
**/
function calculerPrixTTC_20pourcent(prixHT){
    let prixTTC = prixHT * 1.2;
    return prixTTC;
}

function calculerPrixTTC(prixHT, taux){
	return prixHT * (100 + taux) / 100;
}
