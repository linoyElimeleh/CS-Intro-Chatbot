// Reads two non-negative numbers, and writes their product
   load zero     // result = 0
   store result
   read          // reads and stores the first number in x 
   store x
   read          // reads and stores the second number in count
   store count
LOOP:
   gotoz END     // if count = 0, terminates the loop
   load result   // result += x
   add x
   store result
   load count    // count--
   sub one
   store count
   goto LOOP
END:
   load result   // writes the result
   write
   stop