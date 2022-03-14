/** 
    Affiche une triangle de chiffres,
    ou un message d'erreur si le paramètre n'est pas compris entre 1 et 9.
    @param  n   Nombre compris entre 1 et 9
    @return Chaîne de caractères contenant le dessin d'un triangle,
            ou un message d'erreur si n n'est pas compris entre 1 et 9.
**/
function dessinerTriangle(n){
    if(n < 1 || n > 9 || isNaN(n)){
        return "Le nombre doit être compris entre 1 et 9";
    }
    res = '';
    for(let i=1; i <= n; i++){
        res += '<br>';
        for(let j=0; j < i; j++){
            res += i;
        }
    }
    return res;
}
