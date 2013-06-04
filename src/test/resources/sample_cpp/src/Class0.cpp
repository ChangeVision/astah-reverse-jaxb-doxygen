#include <iostream>
#include <string>

#include "Class0.h"

char* functionA() {
	return NULL;
}

Class0::Class0() {
	std::string str = "asdf";
	this->name = str.c_str();
	this->id = 0;
	this->number = 0;

	for (int i = 0; i < 5; ++i) {
		this->summary[i] = i;
	}
	this->foo = 0;
	this->_counter = 0;
}

/**
 * デストラクタ
 */
Class0::~Class0() {
	std::cout << this->name << std::endl;
}

void Class0::search(void** pointer) {
}

/**
 *op1 cpp
 */
void Class0::op1(int x) {
}

long Class0::add(long x, long y) {
	return 0L;
}

long Class0::print(const std::string &str) {
	return 0L;
}

void Class0::init() {
}

std::string Class0::getDesc() {
	return "";
}

class InnerClassA: public Class0 {
public:
	virtual ~InnerClassA();

	virtual void op0();
	virtual void op1();
};

void InnerClassA::op0() {
}
void InnerClassA::op1() {
}

class InnerClassB: public Class0 {
public:
	virtual ~InnerClassB();

	virtual void op0();
	virtual void op1();
	virtual void op2();
	virtual void op3();
};

void InnerClassB::op0() {
}
void InnerClassB::op1() {
}
void InnerClassB::op2() {
}
void InnerClassB::op3() {
}

class InnerClassC {
public:
	struct InnerClassD {
		int x;
		int y;
	};

	virtual ~InnerClassC();
};
