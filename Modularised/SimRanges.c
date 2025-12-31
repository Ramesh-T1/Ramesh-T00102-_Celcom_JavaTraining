#include <stdio.h>
#include <stdlib.h> 
#include <string.h>

typedef struct SIMNumber{
 char sim_number[100];
 char status[20];
}SIMNumber;


//Generate Sim Number Range
char* generateNumber(long startingNumber) {
    static char number[100];
    int numberExists = 0;
    do {
        sprintf(number, "%ld",startingNumber);
        FILE* fptr = fopen("simNumbersGenerated.txt", "r");
        if (fptr == NULL) {
            printf("Error opening file for reading!\n");
            return NULL;
        }

        char mystring[100];
        while (fgets(mystring, sizeof(mystring), fptr)) {
            mystring[strcspn(mystring, "\n")] = '\0';
            if (strcmp(mystring, number) == 0) {
                numberExists = 1;
                break;
            }
        }
        fclose(fptr);
    } while (numberExists);

    FILE* fptr1 = fopen("simNumbersGenerated.txt", "a");
    if (fptr1 == NULL) {
        printf("Error opening file for appending!\n");
        return NULL;
    }
    fprintf(fptr1, "%s\n", number);
    fclose(fptr1);

    return number;
}

void saveSimNumberRanges(SIMNumber** simno, int* countOfNumber,long startingNumber) {
    *countOfNumber += 1;  
    *simno = (SIMNumber*)realloc(*simno, (*countOfNumber) * sizeof(SIMNumber));

    if (*simno == NULL) {
        printf("Memory cannot be allocated\n");
        return;
    }
    strcpy((*simno)[*countOfNumber - 1].sim_number, generateNumber(startingNumber));
    strcpy((*simno)[*countOfNumber - 1].status,"Available");
}

void display(SIMNumber simno) {
    printf("Sim Number Ranges:\n");
    printf("SIMNumber: %s\n", simno.sim_number);
    printf("SIMStatus: %s\n", simno.status);
}