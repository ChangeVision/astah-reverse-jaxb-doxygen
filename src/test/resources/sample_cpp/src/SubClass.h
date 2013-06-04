/*
 * SubClass.h
 *
 *  Created on: 2013/05/13
 *      Author: makoto
 */

#ifndef SUBCLASS_H_
#define SUBCLASS_H_

#include "Hogehoge.h"
#include "Class0.h"

namespace cv {
enum ECv {
	ECv_1, ECv_2, ECv_3
};

int cv_int = 10;

namespace astah {

long cv_astah_long = 20;

class SubClass: public Hogehoge, Class0 {
public:
	SubClass();
	virtual ~SubClass();
protected:
	enum ESub {
		ESub_A, ESub_B = 20, ESub_C
	};
	virtual ESub func01(int param);
};

} /* namespace astah */
} /* namespace cv */
#endif /* SUBCLASS_H_ */
