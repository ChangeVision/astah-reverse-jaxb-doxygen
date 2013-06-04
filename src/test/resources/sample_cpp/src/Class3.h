/*
 * Class3.h
 *
 *  Created on: 2013/05/10
 *      Author: makoto
 */

#ifndef CLASS3_H_
#define CLASS3_H_

#include <string>
#include <vector>
#include "CvStack.h"
#include "Hogehoge.h"

namespace cv {
namespace astah {

class Class3 {
public:
	Class3();
	virtual ~Class3();

	void foo(const unsigned long &sss);

protected:
	std::vector<CvStack<Hogehoge, std::string> > ** m_stack;

	const char* chars;

	static unsigned long count;

	Hogehoge hoges[10];

	static const long* sa;

};

} /* namespace astah */
} /* namespace cv */
#endif /* CLASS3_H_ */

int asdd;

int sub(int x, int y) {
	return x - y;
}
