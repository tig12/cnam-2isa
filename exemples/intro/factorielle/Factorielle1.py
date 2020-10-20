# -*- encoding: utf-8 -*-
'''
    Factorielle, utilisation d'une boucle
'''
import sys

def factorielle1(n):
    if n == 0:
        return 1
    res = 1
    for i in range(1, n+1):
        res = res * i
    return res

def main():
    n = int(sys.argv[1])
    f = factorielle1(n)
    print f

main()
