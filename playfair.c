#include <stdio.h>
#include <string.h>
#include <ctype.h>

#define SIZE 5

void generateKeyTable(char key[], char keyTable[SIZE][SIZE]) {
    int map[26] = {0};
    int x = 0, y = 0;
    int len = strlen(key);

    for (int i = 0; i < len; i++) {
        if (key[i] != 'j' && map[key[i] - 'a'] == 0) {
            keyTable[x][y] = key[i];
            map[key[i] - 'a'] = 1;
            y++;
            if (y == SIZE) {
                y = 0;
                x++;
            }
        }
    }

    for (char c = 'a'; c <= 'z'; c++) {
        if (c != 'j' && map[c - 'a'] == 0) {
            keyTable[x][y] = c;
            map[c - 'a'] = 1;
            y++;
            if (y == SIZE) {
                y = 0;
                x++;
            }
        }
    }
}

void preprocessMessage(char message[], char preprocessed[]) {
    int len = strlen(message);
    int idx = 0;
    
    for (int i = 0; i < len; i++) {
        if (message[i] != ' ') {
            preprocessed[idx++] = tolower(message[i]);
        }
    }
    preprocessed[idx] = '\0';
}

void digraphs(char message[], char digraphs[][2], int *n) {
    int len = strlen(message);
    int idx = 0;

    for (int i = 0; i < len; i += 2) {
        digraphs[idx][0] = message[i];
        if (i + 1 < len) {
            if (message[i] == message[i + 1]) {
                digraphs[idx][1] = 'x';
                i--;
            } else {
                digraphs[idx][1] = message[i + 1];
            }
        } else {
            digraphs[idx][1] = 'x';
        }
        idx++;
    }
    *n = idx;
}

void findPosition(char keyTable[SIZE][SIZE], char c, int *row, int *col) {
    for (int i = 0; i < SIZE; i++) {
        for (int j = 0; j < SIZE; j++) {
            if (keyTable[i][j] == c) {
                *row = i;
                *col = j;
                return;
            }
        }
    }
}

void encryptPair(char keyTable[SIZE][SIZE], char a, char b, char *c1, char *c2) {
    int row1, col1, row2, col2;
    findPosition(keyTable, a, &row1, &col1);
    findPosition(keyTable, b, &row2, &col2);

    if (row1 == row2) {
        *c1 = keyTable[row1][(col1 + 1) % SIZE];
        *c2 = keyTable[row2][(col2 + 1) % SIZE];
    } else if (col1 == col2) {
        *c1 = keyTable[(row1 + 1) % SIZE][col1];
        *c2 = keyTable[(row2 + 1) % SIZE][col2];
    } else {
        *c1 = keyTable[row1][col2];
        *c2 = keyTable[row2][col1];
    }
}

void encryptMessage(char message[], char key[], char encrypted[]) {
    char keyTable[SIZE][SIZE];
    char preprocessed[100];
    char digraphsArray[50][2];
    int n;

    preprocessMessage(message, preprocessed);
    generateKeyTable(key, keyTable);
    digraphs(preprocessed, digraphsArray, &n);

    for (int i = 0; i < n; i++) {
        encryptPair(keyTable, digraphsArray[i][0], digraphsArray[i][1], &encrypted[2 * i], &encrypted[2 * i + 1]);
    }
    encrypted[2 * n] = '\0';
}

int main() {
    char message[100], key[100], encrypted[100];

    printf("Enter the message: ");
    gets(message);

    printf("Enter the key: ");
    gets(key);

    encryptMessage(message, key, encrypted);

    printf("Encrypted message: %s\n", encrypted);

    return 0;
}
