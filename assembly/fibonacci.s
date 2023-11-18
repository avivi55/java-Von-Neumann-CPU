# Programs that calculates the fibonacci sequence
MOV $0 R1
MOV $1 R2
OUT R1

# a space char
MOV $'\s' R3
OUTC R3

OUT R2

# space
OUTC R3

ADD R1 R2
OUT R0
OUTC R3
MOV R0 R1

# loop counter
MOV $20 R9

# Fibonacci formula
ADD R1 R2
OUT R0
OUTC R3
MOV R1 R2
MOV R0 R1

# loop
DEC R9
JZ $24
