<?php
/******************************************************************************

    Génère la table des puissances de 16 pour la page base 2 10 16
    
    @license    GPL
    @history    2021-10-13 17:30:10+02:00, Thierry Graff : Creation
********************************************************************************/

echo generate(16, 4);

/** 
    Génère une table avec les multiples de $base, de la puissance 1 à $maxExponent.
**/
function generate($base, $maxExponent){
    $res = '';
    $res .= '<table class="wikitable alternate margin">' . "\n";
    // header
    $res .= '<tr>';
    // 1 colonne par exposant
    for($exp=0; $exp <= $maxExponent; $exp++){
        $current = pow($base, $exp);
        $res .=
              '<th>'
            . $base
            . "<sup>$exp</sup>"
            . '<br>'
            . number_format(num:$current, thousands_separator:' ')
            . '</th>'
            ;
    }
    $res .= '</tr>'. "\n";
    
    // 1 ligne par multiple, de 1 à $base
    for($line=1; $line <= $base; $line++){
        $res .= '<tr>';
        for($exp=0; $exp <= $maxExponent; $exp++){
            $current = pow($base, $exp);
            $multiple = $current * $line;
            $res .=
                  '<td>'
/* 
number_format(
    float $num,
    int $decimals = 0,
    ?string $decimal_separator = ".",
    ?string $thousands_separator = ","
): string
*/
                . number_format(num:$multiple, thousands_separator:' ')
                . '</td>';
        }
        $res .= '</tr>'. "\n";
    }
    $res .= "</table>\n";
    return $res;
}
