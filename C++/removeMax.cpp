#include <iostream>
using namespace std;

int* stripMax(const int arr[], int numElems);

int main() {
    int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    cout << "Original Array (1-10): ";
    for (int i : arr) {
        cout << i << " ";
    }

    int* newArr = stripMax(arr, 10);
    cout << endl << "New Array Without Max: ";
    for (int i = 0; i < 9; i++) {
        cout << newArr[i] << " ";
    }
}

int* stripMax(const int arr[], int numElems) {
    int* newArr = new int[numElems - 1];
    int max = arr[0];
    int maxIndex = 0;

    for (int i = 1; i < numElems; i++) {
        if (arr[i] > max) {
            max = arr[i];
            maxIndex = i;
        }
    }

    for (int i = 0; i < maxIndex; i++) {
        newArr[i] = arr[i];
    }

    for (int i = maxIndex + 1; i < numElems; i++) {
        newArr[i - 1] = arr[i];
    }

    return newArr;
}