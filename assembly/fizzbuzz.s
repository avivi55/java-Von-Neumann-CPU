in r1

mov $5 r5
mov $3 r3

mod r1 r3
mov r0 r9

# if not divisible by 3 -> skip print fizz
jz $21
# else -> fizz print
jmp $13

mov $'F'
outc
mov $'i'
outc
mov $'z'
outc
outc

mod r1 r5
mov r0 r9
jz $34
jmp $26

mov $'B'
outc
mov $'u'
outc
mov $'z'
outc
outc

