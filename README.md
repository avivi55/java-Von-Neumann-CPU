# CPU in Java

This project was made as part of a presentation for a `computer architecture` class.

It replicates a **Von Neumann** type microprocessor.

You can control it with a crude assembly language. Its intent is only for testing purposes.
This assembly language is described as follows:

- **Registers**
    - Registers are 32bits
    - We only have 10 general purpose registers.
    - General purpose registers are noted Rn, where n is an integer.
    - The arithmetic register ot accumulator is the `R0` register
      ( e.g. `DIV R2 R1` <=> `R0 = R2/R1`).
    - The counter register is the `R9` register (in the use of `JZ`).


- **Syntax**
    - Immediates are denoted as $n, where n is an integer or a character.
        - a space character is `$'\s'`.
        - a new line character is `$'\n'`.
        - an immediate is internally a new temporary register containing the value.
    - The syntax resembles AT&T assembly syntax : `Instruction` `sender` `receiver`
      ( e.g. `mov $5 R0` or `SUB R2 R1` <=> `R2-R1`)
    - If a register is required and non are given,
      `R0` will be used as first operand and `R1` as second.
    - The language is case-insensitive.
    - Comments exist as a standalone **line** that starts with `#` ( e.g. `# this is a comment`)
    - Empty lines can exist.

`R` : register

`C` : constant

`<empty field>` : operand unused, can be specified but will be ignored.

| Instruction name | operand 1 | operand 2 | description                                                                    |
|:----------------:|:---------:|:---------:|--------------------------------------------------------------------------------|
|       JMP        |    C/R    |           | Jumps to the specified line number in the assembly code.                       |
|       JNZ        |    C/R    |           | equivalent to JMP, but only if `R9` ≠ 0.                                       |
|        LS        |     R     |           | Makes a left shift of the bits (effectively a `× 2`).                          |
|        RS        |     R     |           | Makes a right shift of the bits (effectively a `÷ 2`).                         |
|       INC        |     R     |           | Increments the value stored in the register.                                   |
|       DEC        |     R     |           | Decrements the value stored in the register.                                   |
|       NOT        |     R     |           | Inverts the bits in the register                                               |
|       OUT        |     R     |           | Prints out the content of the register.                                        |
|       OUTC       |     R     |           | Prints out the content of the register as its ascii character.                 |
|        IN        |     R     |           | Scans the stdin and puts (only integer) in the register.                       |
|                  |           |           |                                                                                |
|       MOV        |    C/R    |     R     | Basically an `=`, you can copy data from a register or constant to a register. |
|       ADD        |     R     |     R     | Calculates the sum of the two registers.                                       |
|       SUB        |     R     |     R     | Calculates the difference of the two registers.                                |
|       MUL        |     R     |     R     | Calculates the product.                                                        |
|       DIV        |     R     |     R     | Calculates the integer quotient.                                               |
|       AND        |     R     |     R     | Calculates bitwise `and`.                                                      |
|        OR        |     R     |     R     | Calculates bitwise `or`.                                                       |       

The assembly language is interpreted.

This is an example of a hello world:
```
MOV $'H' R0
OUTC
MOV $'E' R0
OUTC
MOV $'L' R0
OUTC
OUTC
MOV $'O' R0
OUTC

MOV $'\s' R0
OUTC

MOV $'W' R0
OUTC
MOV $'O' R0
OUTC
MOV $'R' R0
OUTC
MOV $'L' R0
OUTC
MOV $'D' R0
OUTC
MOV $'!' R0
OUTC
```
example of a fibonacci sequence calculator
https://github.com/avivi55/java-Von-Neumann-CPU/blob/29fee03ffb50131b4f807eade87a99dcf40109ef/assembly/fibonacci.s#L1-L26


even tho the language does not support floating points, you can manipulate a poor version of it
https://github.com/avivi55/java-Von-Neumann-CPU/blob/452f477d31cd8ea3fd1cba3c64e38141cadf4100/assembly/circle_area.s#L1-L25