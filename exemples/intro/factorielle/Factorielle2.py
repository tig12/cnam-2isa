# -*- encoding: utf-8 -*-
'''
    Factorielle, utilisation de la récursivité
'''
import sys

def factorielle2(n):
    if n == 0:
        return 1
    return n * factorielle2(n - 1)

def main():
    n = int(sys.argv[1])
    f = factorielle2(n)
    print f

main()
