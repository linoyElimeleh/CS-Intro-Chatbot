// Reads a positive number from the input. 
// If the number is odd, writes 1; otherwise writes 0.
  read         // reads a number and stores it in x
  store x   
  load one     // two = 2
  add one
  store two
LOOP:
  load x       // x = x - 2
  sub two
  store x
  gotoz EVEN   // if x == 0, the input is even   
  gotop LOOP   // if x > 0, keep substracting 2
  goto ODD     // ix x < 0, the input is odd
EVEN:
  load zero    // the input is even
  write
  stop
ODD:
  load one     // the input is odd
  write
  stop