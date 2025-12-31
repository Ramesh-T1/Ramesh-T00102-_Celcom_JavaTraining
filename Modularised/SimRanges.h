#ifndef SIM_NUMBER_H
#define SIM_NUMBER_H

typedef struct SIMNumber{
 char sim_number[100];
 char status[20];
}SIMNumber;

char* generateNumber(long startingNumber);
void saveSimNumberRanges(SIMNumber** simno, int* countOfNumber,long startingNumber);
void display(SIMNumber simno);

#endif