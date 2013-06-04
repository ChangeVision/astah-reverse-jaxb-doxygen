#include <string>
#include <vector>
#include <list>
#include <iostream>
#include <assert.h>

#include "Class1.h"
#include "Hogehoge.h"

Class1::Class1() {
	this->attr0 = 0;
	this->hoge = new Hogehoge();
}

Class1::~Class1() {
	delete this->hoge;
}

void Class1::op0() {
}
