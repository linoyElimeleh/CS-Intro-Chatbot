// Reads two numbers and prints their maximum
  read
  store x
  read
  store y
  sub x
  gotop YISMAX
  load x
  write
  goto END
YISMAX:
  load y
  write
END:
  stop
