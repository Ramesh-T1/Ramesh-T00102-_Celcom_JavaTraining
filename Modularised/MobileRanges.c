#include <stdio.h>
#include <stdlib.h> 
#include <string.h>

typedef struct MobileNumber{
 char mobile_number[100];
 char type[50];
 char status[20];
}MobileNumber;

//Generating MobileNumberRange
char* generateMobNumber(long startingNumber) {
    static char number[100];
    int numberExists = 0;
    do {
       sprintf(number, "%ld",startingNumber);
        FILE* fptr = fopen("numbersgenerated.txt", "r");
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

    FILE* fptr1 = fopen("numbersgenerated.txt", "a");
    if (fptr1 == NULL) {
        printf("Error opening file for appending!\n");
        return NULL;
    }
    fprintf(fptr1, "%s\n", number);
    fclose(fptr1);
    return number;
}
char* type(char* number){
      if((strncmp(number + 6, "1234",4)==0)||((number[6]==number[7]) && (number[7]==number[8]) && (number[8]==number[9])))
      {
         return "Platinum";
      }else if((strncmp(number + 7, "123",3)==0) || ((number[7]==number[8]) && (number[8]==number[9]))){
         return "Gold";
      }else if(((number[6]==number[7]) && (number[8]==number[9]))){
         return "Silver";
      }
      else{
         return "Regular";
      }
}

void saveMobileNumberRanges(MobileNumber** mobno, int* countOfNumber,long startingNumber) {
    *countOfNumber += 1;  
    *mobno = (MobileNumber*)realloc(*mobno, (*countOfNumber) * sizeof(MobileNumber));

    if (*mobno == NULL) {
        printf("Memory cannot be allocated\n");
        return;
    }
    char* num=generateMobNumber(startingNumber);
    strcpy((*mobno)[*countOfNumber - 1].mobile_number,num);
    strcpy((*mobno)[*countOfNumber - 1].type,type(num));
    strcpy((*mobno)[*countOfNumber - 1].status,"Available");
}

void displayMob(MobileNumber mobno) {
    printf("Mobile Number Ranges:\n");
    printf("MobileNumbers: %s\n", mobno.mobile_number);
    printf("Membership Value: %s\n", mobno.type);
    printf("MobileNumberStatus: %s\n", mobno.status);
}