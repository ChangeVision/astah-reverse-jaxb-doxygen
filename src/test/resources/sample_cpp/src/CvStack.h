#ifndef CVSTACK_H_
#define CVSTACK_H_

#include <string>
#include "Hogehoge.h"

namespace cv {
namespace astah {

template<class K = std::string, class V = Hogehoge>
class CvStack {
public:
	CvStack(K k, V v);
	virtual ~CvStack();

	template<class U>
	void func(const U& u);

	friend int bar() {
		return 0;
	}

	virtual int add(int x, int y) = 0;

private:
	K m_k;
	V m_v;
};

} /* namespace astah */
} /* namespace cv */
#endif /* CVSTACK_H_ */
