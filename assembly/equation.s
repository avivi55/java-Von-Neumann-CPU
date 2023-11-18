# (5x+4)/2 + 3y

# x
mov $1 R9

# y
mov $1 R8


mov $4 R2
mov $5 R1

# R0 = 5x
mul R9 R1

# R0 += 4
add R2

# R0 /= 2
mov $2 R1
div R0 R1

# save the result in R1
mov R0 R1

# R0 = 3
mov $3 R0

# R0 *= y
mul R8

add R1

out

