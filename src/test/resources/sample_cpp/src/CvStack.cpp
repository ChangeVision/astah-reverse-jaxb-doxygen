#include "CvStack.h"

#include <iostream>

namespace cv {
namespace astah {

using namespace std;

template<class K, class V>
CvStack<K, V>::CvStack(K k, V v) :
		m_k(k), m_v(v) {
}

template<class K, class V>
CvStack<K, V>::~CvStack() {
}

template<class K, class V>
template<class U>
void CvStack<K, V>::func(const U& u) {
	cout << this->m_k << ", " << this->m_v << ", " << u << "\n";
}

}/* namespace astah */
} /* namespace cv */
