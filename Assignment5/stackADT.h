#ifndef STACKADT_H
#define STACKADT_H

#include <stdbool.h>   /* C99 only */

typedef int Item;

typedef struct stack_type *Stack;

/* create a new stack */
Stack create(void);
/* destroy the current stack */
void destroy(Stack s);
/* make an empty stack */
void make_empty(Stack s);
/* check if the stack is empty */
bool is_empty(Stack s);
/* check if the stack is full */
bool is_full(Stack s);
/* push an item inside the stack*/
void push(Stack s, Item i);
/* pop an item inside the stack*/
Item pop(Stack s);

#endif

