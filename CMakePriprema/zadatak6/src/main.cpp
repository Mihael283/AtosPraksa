#include <iostream>
#include <cstring>
#include "../include/Professor/Professor.h"
#include "../include/Student/Student.h"
using namespace std;



int main(int argc, char *argv[]){
    string name;
    cout << "Enter student's name: ";
    cin >> name;
    Student Student(name);
    cout << "Enter professors's name: ";
    cin >> name;
    Professor Professor(name);

    cout << "\n";
    cout << "Student's name: " << Student.getName() << "\n";
    cout << "Professors's name: " << Professor.getName() << "\n";
    return 0;
}

