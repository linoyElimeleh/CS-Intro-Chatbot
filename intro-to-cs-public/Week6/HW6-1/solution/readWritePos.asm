// Reads a series of numbers that ends with a zero.
// Writes all the positive numbers in the series.
LOOP:
   read
   // if the input is zero, terminates
   gotoz END  
   // if the input is positive, writes it    
   gotop PRINT    
   goto LOOP
PRINT:
   write
   goto LOOP
END:
   stop