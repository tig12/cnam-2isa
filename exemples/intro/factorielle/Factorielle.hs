factorielle :: (Integral a) => a -> a
factorielle 0 = 1
factorielle n = n * factorielle (n - 1)
