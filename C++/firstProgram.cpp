#include <iostream>
using namespace std;

class FirstClass {
  int n;
  public:
    int getN();
    FirstClass(int theN) { 
      n = theN;
    }
};

int FirstClass::getN() { return n; }

int main() {
  int x = 5;
  cout << "Hello World!" << x << endl;

  string s;
  cin >> s;
  cout << "You said: " << s << endl;

  FirstClass *fc = new FirstClass(10);
  cout << fc->getN() << endl; 
}