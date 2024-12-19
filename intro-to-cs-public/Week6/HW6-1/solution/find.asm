// Reads a number and a series of numbers that ends with a zero.
// If the number exists in the series, prints itx index; otherwise prints -1.
// The index of the first number in the series is assumed to be 1.
  read
  store x
  load one
  store i
  read
LOOP:
  gotoz END    // if zero, stop
  sub x
  gotoz FOUND  // the number was found
  load i       // i++
  add one
  store i 
  read         // read the next number
  goto LOOP
END:
  load zero    // write -1
  sub one
  write
  stop
FOUND:         // write i
  load i
  write
  stop