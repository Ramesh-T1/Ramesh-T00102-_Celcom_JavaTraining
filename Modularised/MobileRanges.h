#ifndef MOB_NUMBER_H
#define MOB_NUMBER_H

typedef struct MobileNumber{
 char mobile_number[100];
 char type[50];
 char status[20];
}MobileNumber;

void displayMob(MobileNumber mobno);
char* generateMobNumber(long startingNumber);
char* type(char* number);
void saveMobileNumberRanges(MobileNumber** mobno, int* countOfNumber,long startingNumber);
#endif