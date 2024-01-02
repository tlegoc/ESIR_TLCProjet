#include "lib_while.h"
private Node add(Node Op1, Node Op2 ) {
	Result = Op1;
	for (int _ID_for_0 = 0; _ID_for_0<= toInt(Op2); _ID_for_0++ ) {
		std::shared_ptr<Node> reg_0 = std::make_shared<Node>();
		Cons(reg_0, nil, Result);
		Result = reg_0;
		}
	return Result;
}
private Node sub(Node Op1, Node Op2 ) {
	Result = Op1;
	for (int _ID_for_0 = 0; _ID_for_0<= toInt(Op2); _ID_for_0++ ) {
		std::shared_ptr<Node> reg_1 = std::make_shared<Node>();
		tl(reg_1, Result);
		Result = reg_1;
		}
	return Result;
}
private Node mul(Node Op1, Node Op2 ) {
	for (int _ID_for_0 = 0; _ID_for_0<= toInt(Op1); _ID_for_0++ ) {
		reg_2 = add(Result, Op2); 
		std::shared_ptr<Node> reg_2 = std::make_shared<Node>();
		Cons(reg_2, add);
		Result = reg_2;
		}
	return Result;
}
private Node test(Node Op1, Node Op2 ) {
	std::shared_ptr<Node> reg_3 = std::make_shared<Node>();
	Cons(reg_3);
	Result = reg_3;
	std::shared_ptr<Node> reg_4 = std::make_shared<Node>();
	Cons(reg_4);
	reg_5 = add(Result, reg_4); 
	std::shared_ptr<Node> reg_5 = std::make_shared<Node>();
	Cons(reg_5, add);
	Result = reg_5;
	std::shared_ptr<Node> reg_6 = std::make_shared<Node>();
	Cons(reg_6);
	reg_7 = add(Result, reg_6); 
	std::shared_ptr<Node> reg_7 = std::make_shared<Node>();
	Cons(reg_7, add);
	Result = reg_7;
	std::shared_ptr<Node> reg_8 = std::make_shared<Node>();
	Cons(reg_8);
	reg_9 = add(Result, reg_8); 
	std::shared_ptr<Node> reg_9 = std::make_shared<Node>();
	Cons(reg_9, add);
	Result = reg_9;
	std::shared_ptr<Node> reg_10 = std::make_shared<Node>();
	Cons(reg_10);
	reg_11 = add(Result, reg_10); 
	std::shared_ptr<Node> reg_11 = std::make_shared<Node>();
	Cons(reg_11, add);
	Result = reg_11;
	return Result;
}
