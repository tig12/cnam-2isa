<?php
function uncurried_add($x, $y){
    return $x + $y;
}

// Avant PHP 7.4
function curried_add($x){
    return function($y) use($x) { return $x + $y; };
}

// Depuis PHP 7.4 ("arrow functions")
function curried_add2($x){
    return fn($y) => $x + $y;
}

echo "uncurried_add(3, 5) = " . uncurried_add(3, 5) . "\n";
echo "curried_add(3)(5) = " . curried_add(3)(5) . "\n";
echo "curried_add2(3)(5) = " . curried_add2(3)(5) . "\n";
