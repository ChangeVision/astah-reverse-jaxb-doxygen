#ifndef CLASS1_H
#define CLASS1_H

#include <string>
#include <vector>
#include <list>
#include <iostream>
#include <assert.h>

#include "Class0.h"
#include "Hogehoge.h"

using namespace std;
using namespace cv::astah;

class Class1: public Class0 {
	class InnerA {
		int x;
		int y;
	};

	struct InnerB {
		int r;
		int s;
		InnerA t;
	};

	union InnerC {
		InnerB ooo;
	};

private:
	const unsigned int* attr0;
	vector<vector<string> > strstr;

protected:
	Hogehoge* hoge;

	vector<Hogehoge*> hoges;

public:
	Class1();
	virtual ~Class1();

	virtual void op0();

};
#endif
