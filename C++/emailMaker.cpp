#include <iostream>
using namespace std;

int main() {
  string name;
  cout << "What is your name?" << endl;
  getline(cin, name);

  string first = name.substr(0, name.find(' '));
  string last = name.substr(name.find(' ') + 1);
  cout << first << "." << last << "@bcp.org" << endl;
}