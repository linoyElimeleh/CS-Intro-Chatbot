// Sums up a sequence of numbers that ends with a zero.
  load zero 
  store sum
LOOP:
  read
  store x
  gotoz END
  load sum 
  add x   
  store sum
  goto LOOP
END:
  load sum
  write
  stop
