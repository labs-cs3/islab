#include <stdio.h> 
#include<stdlib.h> 
#include<string.h>
void main()
{
char str[]="Hello World"; 
char str1[11];
char str2[11];
for(int i = 0; i<strlen(str);i++)
str2[i]= str[i];

char str3[11]; 
int i,len;
len = strlen(str);

for(i=0;i<len;i++)
{
str1[i] = str[i]&127;
 printf("%c",str1[i]);
}
printf("\n");
for(i=0;i<len;i++)
{
str3[i] = str2[i]^127; 
printf("%c",str3[i]);
}
printf("\n");

}
