#ifndef CLASS0_H
#define CLASS0_H

#include <iostream>
#include <vector>

/**
 * クラスのコメント
 */
class Class0 {
public:
	/**
	 * コンストラクタ
	 */
	Class0();
	virtual ~Class0();

	/**
	 * op1
	 *@param x
	 */
	virtual void op1(int x);
	/**
	 * add
	 * @param x
	 * @param y
	 * @return long
	 * @throw error
	 */
	virtual long add(long x, long y);
	long print(const std::string &str);

	mutable int _counter;

	int getFuga() const {
		_counter++;
		return 0;
	}
protected:
	void init();
	void search(void** pointer);

private:
	std::string getDesc();

public:
	unsigned int number;

protected:
	std::vector<int> list;
	const char* name;
	int summary[5];

	/**
	 *コメント
	 */
	volatile void* foo;

private:
	int id;
};
#endif
