#include <stdio.h>
#include <stdlib.h> 
#include <string.h>
#include "MobileRanges.h"
#include "SimRanges.h"

typedef struct Mobile_SIM_PAIRING{
 char mobile_number[100];
 char sim_number[100];
 char status[20];
}Mobile_SIM_PAIRING;

void viewRange(MobileNumber* mobno,SIMNumber* simno){
   char ot;
   int i;
   getchar();
   printf("Select Do you want to see a-Mobile Number Range or b-Sim Number Range\n");
   scanf("%c",&ot);
   switch(ot){
    case 'a':for (i = 0; i < 100; ++i) {
        displayMob(mobno[i]);
    }
    break;
    case 'b':for (i = 0; i < 100; ++i) {
       display(simno[i]);
    }
    break;
}
}

//Activate and Pairing
void activateMobileNumber(MobileNumber** mobno,SIMNumber** simno,int* countOfNumber,
     int* countOfSimNumber,Mobile_SIM_PAIRING** msp,int* countOfMsp){
  long mb;
  long sim;
  int i,j=*countOfNumber,k=*countOfSimNumber;
  int count1=0,count2=0;
  char tempMobno[100];
  char tempSimno[100];
  int mbflag=0,simflag=0;
  printf("Enter Mobile Number you want\n");
  scanf("%ld",&mb);
  printf("Enter Sim number you want\n");
  scanf("%ld",&sim);
  sprintf(tempMobno, "%ld",mb);
  sprintf(tempSimno, "%ld",sim);
  *countOfMsp += 1; 
  *msp = (Mobile_SIM_PAIRING*)realloc(*msp, (*countOfMsp) * sizeof(Mobile_SIM_PAIRING));
  for(i=0;i<j;++i){
    if((strcmp((*mobno)[i].mobile_number,tempMobno)==0) && (strcmp((*mobno)[i].status,"Available")==0))
    {
       count1=i;
       mbflag=1;
       break; 
    }
    
  }
  for(i=0;i<k;++i){
    if((strcmp((*simno)[i].sim_number,tempSimno)==0) && (strcmp((*simno)[i].status,"Available")==0))
    {
       count2=i;
       simflag=1;
       break;
    }
    
  }
  if((mbflag==0) || (simflag==0)){
     printf("Mobile No or Sim No not available for your use.It is already in use\n");
  }else{
      strcpy((*msp)[*countOfMsp-1].mobile_number,tempMobno);
      strcpy((*msp)[*countOfMsp-1].sim_number,tempSimno);
      strcpy((*msp)[*countOfMsp-1].status,"Active");
      strcpy((*mobno)[count1].status,"Allocated");
      strcpy((*simno)[count2].status,"Allocated");
      printf("\nSim and Mobilno Paired\n");
    }

}


//View Mobile Sim Pairing
void viewMobileSimPairing(Mobile_SIM_PAIRING* msp,int* count) {
int i;
for(i=0;i<(*count);i++){
    printf("Paired Mobile and Sim:\n");
    printf("Mobile Number: %s\n", msp[i].mobile_number);
    printf("SIMNumber: %s\n", msp[i].sim_number);
    printf("PairingStatus: %s\n", msp[i].status);
}
}

//Deactivate
void deactivateMobileNumber(Mobile_SIM_PAIRING** msp,int* countOfMsp){
int i;
long mb;
  long sim;
  int count1=0;
  char tempMobno[100];
  char tempSimno[100];
  int mbflag=0,simflag=0;
  printf("Enter Mobile Number you want\n");
  scanf("%ld",&mb);
  printf("Enter Sim number you want\n");
  scanf("%ld",&sim);
  sprintf(tempMobno, "%ld",mb);
  sprintf(tempSimno, "%ld",sim);
    for(i=0;i<(*countOfMsp);++i){
    if((strcmp((*msp)[i].mobile_number,tempMobno)==0) && (strcmp((*msp)[i].status,"Active")==0))
    {
       count1=i;
       mbflag=1;
       break; 
    }
    
  }
    for(i=0;i<(*countOfMsp);++i){
    if((strcmp((*msp)[i].sim_number,tempSimno)==0) && (strcmp((*msp)[i].status,"Active")==0))
    {
       simflag=1;
       break;
    }
    
  }
  if((mbflag==0) || (simflag==0)){
     printf("Mobile No or Sim No not Allocated\n");
  }else{
      strcpy((*msp)[count1].status,"Inactivated");
      printf("\nSim and Mobilno Deactivated\n");
    }
}

//Release
void releaseNumber(Mobile_SIM_PAIRING** msp,int* countOfMsp,MobileNumber** mobno,SIMNumber** simno,int* countOfNumber,
     int* countOfSimNumber){
    int j,k,m,i;
    char tempMobno[100];
    char tempSimno[100];
    for(i=0;i<(*countOfMsp);++i){
    if(strcmp((*msp)[i].status,"Inactivated")==0)
    {
       strcpy(tempMobno,(*msp)[i].mobile_number);
       strcpy(tempSimno,(*msp)[i].sim_number);
            //Removing From Sim_Mobile Pairing       
            //found = 1;
            for (m =i; m <(*countOfMsp)-1; m++) {
                (*msp)[m] = (*msp)[m + 1];
            }
            *countOfMsp-=1;
            *msp = realloc(*msp, (*countOfMsp) * sizeof(Mobile_SIM_PAIRING));
            if (*msp == NULL && *countOfMsp > 0) {
                printf("Memory allocation failed after shifting.\n");
                return;
            }
            printf("Mobile and Sim Number Deallocated and made available successfully!\n");
       //Changing Status of MobileNumber Structure  
       for(j=0;j< (*countOfNumber);++j){
             if(strcmp((*mobno)[j].mobile_number,tempMobno)==0)
               {
                  strcpy((*mobno)[j].status,"Available");
               }
       }
       //Changing Status of SimNumber Structure
       for(k=0;k< (*countOfNumber);++k){
            if(strcmp((*simno)[k].sim_number,tempSimno)==0)
             {
                 strcpy((*simno)[k].status,"Available");
             }
       }
       --i;
    }
}
}

//Exit
void shutdown(MobileNumber** mobno,SIMNumber** simno,Mobile_SIM_PAIRING** msp){
  free(*mobno);
  free(*simno);
  free(*msp);
  exit(0);
}