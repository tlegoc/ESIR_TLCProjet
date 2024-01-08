#include "lib_while.h"
void add(std::shared_ptr<Node> &Result, std::shared_ptr<Node> Op1, std::shared_ptr<Node> Op2 ) {
	Op1 = EMPTY;
	for (int _ID_for_0 = 0; _ID_for_0<= toInt(Op2); _ID_for_0++ ) {
		std::shared_ptr<Node> reg_0 = std::make_shared<Node>();
		Cons(reg_0, Nil(), Result);
		std::shared_ptr<Node> reg_0 = std::make_shared<Node>();
reg_0 = EMPTY;
		}
	}
	void test(std::shared_ptr<Node> &Result, std::shared_ptr<Node> Op1, std::shared_ptr<Node> Op2 ) {
		std::shared_ptr<Node> reg_1 = std::make_shared<Node>();
		Cons(reg_1);
		std::shared_ptr<Node> reg_1 = std::make_shared<Node>();
reg_1 = EMPTY;
		std::shared_ptr<Node> reg_2 = std::make_shared<Node>();
		Cons(reg_2);
		std::shared_ptr<Node> reg_3 = std::make_shared<Node>();
reg_3 = add(Result, reg_2); 
		std::shared_ptr<Node> reg_4 = std::make_shared<Node>();
		Cons(reg_4);
		std::shared_ptr<Node> reg_5 = std::make_shared<Node>();
reg_5 = add(Result, reg_4); 
		std::shared_ptr<Node> reg_6 = std::make_shared<Node>();
		Cons(reg_6);
		std::shared_ptr<Node> reg_7 = std::make_shared<Node>();
reg_7 = add(Result, reg_6); 
		std::shared_ptr<Node> reg_8 = std::make_shared<Node>();
		Cons(reg_8);
		std::shared_ptr<Node> reg_9 = std::make_shared<Node>();
reg_9 = add(Result, reg_8); 
		std::shared_ptr<Node> reg_10 = std::make_shared<Node>();
		tl(reg_10, Result);
		std::shared_ptr<Node> reg_10 = std::make_shared<Node>();
reg_10 = EMPTY;
		std::shared_ptr<Node> reg_11 = std::make_shared<Node>();
		hd(reg_11, Result);
		std::shared_ptr<Node> reg_11 = std::make_shared<Node>();
reg_11 = EMPTY;
		std::shared_ptr<Node> reg_12 = std::make_shared<Node>();
Nil(reg_12);
		std::shared_ptr<Node> reg_13 = std::make_shared<Node>();
		Cons(reg_13, Result, reg_12);
		std::shared_ptr<Node> reg_14 = std::make_shared<Node>();
		Cons(reg_14, Result, reg_13);
		std::shared_ptr<Node> reg_15 = std::make_shared<Node>();
		Cons(reg_15, Result, reg_14);
		std::shared_ptr<Node> reg_16 = std::make_shared<Node>();
		Cons(reg_16, Result, reg_15);
		std::shared_ptr<Node> reg_16 = std::make_shared<Node>();
reg_16 = EMPTY;
		std::shared_ptr<Node> reg_17 = std::make_shared<Node>();
reg_17 = Result;
		std::shared_ptr<Node> reg_18 = std::make_shared<Node>();
		Cons(reg_18, Result, reg_17);
		std::shared_ptr<Node> reg_19 = std::make_shared<Node>();
		Cons(reg_19, Result, reg_18);
		std::shared_ptr<Node> reg_20 = std::make_shared<Node>();
		Cons(reg_20, Result, reg_19);
		std::shared_ptr<Node> reg_20 = std::make_shared<Node>();
reg_20 = EMPTY;
		while (toBool(Op2)) {
			std::shared_ptr<Node> Test = std::make_shared<Node>();
std::shared_ptr<Node> reg_21 = std::make_shared<Node>();
Nil(reg_21);
			std::shared_ptr<Node> reg_22 = std::make_shared<Node>();
			Cons(reg_22, Result, reg_21);
			std::shared_ptr<Node> reg_22 = std::make_shared<Node>();
reg_22 = EMPTY;
			std::shared_ptr<Node> reg_23 = std::make_shared<Node>();
			Cons(reg_23);
			std::shared_ptr<Node> reg_23 = std::make_shared<Node>();
reg_23 = EMPTY;
			}
		std::shared_ptr<Node> Test = std::make_shared<Node>();
std::shared_ptr<Node> reg_24 = std::make_shared<Node>();
		Cons(reg_24);
		std::shared_ptr<Node> reg_24 = std::make_shared<Node>();
reg_24 = EMPTY;
		}
		void sub(std::shared_ptr<Node> &Result, std::shared_ptr<Node> Op1, std::shared_ptr<Node> Op2 ) {
			Op1 = EMPTY;
			for (int _ID_for_0 = 0; _ID_for_0<= toInt(Op2); _ID_for_0++ ) {
				std::shared_ptr<Node> reg_25 = std::make_shared<Node>();
				tl(reg_25, Result);
				std::shared_ptr<Node> reg_25 = std::make_shared<Node>();
reg_25 = EMPTY;
				}
			}
			void mul(std::shared_ptr<Node> &Result, std::shared_ptr<Node> Op1, std::shared_ptr<Node> Op2 ) {
				for (int _ID_for_0 = 0; _ID_for_0<= toInt(Op1); _ID_for_0++ ) {
					std::shared_ptr<Node> reg_26 = std::make_shared<Node>();
reg_26 = add(Result, Op2); 
					}
				}
				void test2(std::shared_ptr<Node> &Result, std::shared_ptr<Node> Op1, std::shared_ptr<Node> Op2 ) {
					std::shared_ptr<Node> reg_27 = std::make_shared<Node>();
					Cons(reg_27);
					std::shared_ptr<Node> reg_27 = std::make_shared<Node>();
reg_27 = EMPTY;
					std::shared_ptr<Node> reg_28 = std::make_shared<Node>();
					Cons(reg_28);
					std::shared_ptr<Node> reg_29 = std::make_shared<Node>();
reg_29 = add(Result, reg_28); 
					std::shared_ptr<Node> reg_30 = std::make_shared<Node>();
					Cons(reg_30);
					std::shared_ptr<Node> reg_31 = std::make_shared<Node>();
reg_31 = add(Result, reg_30); 
					std::shared_ptr<Node> reg_32 = std::make_shared<Node>();
					Cons(reg_32);
					std::shared_ptr<Node> reg_33 = std::make_shared<Node>();
reg_33 = add(Result, reg_32); 
					std::shared_ptr<Node> reg_34 = std::make_shared<Node>();
					Cons(reg_34);
					std::shared_ptr<Node> reg_35 = std::make_shared<Node>();
reg_35 = add(Result, reg_34); 
					}
					void true_sanitized(std::shared_ptr<Node> &Result ) {
						std::shared_ptr<Node> reg_36 = std::make_shared<Node>();
						Cons(reg_36, Nil(), Nil());
						std::shared_ptr<Node> reg_36 = std::make_shared<Node>();
reg_36 = EMPTY;
						}
						void false_sanitized(std::shared_ptr<Node> &Result ) {
							nil = EMPTY;
							}
							void not_sanitized(std::shared_ptr<Node> &Result, std::shared_ptr<Node> Op1 ) {
								if (toBool(Op1)) {
									std::shared_ptr<Node> reg_37 = std::make_shared<Node>();
reg_37 = false_sanitized(); 
									}
								
else {
									std::shared_ptr<Node> reg_38 = std::make_shared<Node>();
reg_38 = true_sanitized(); 
									}
								}
								void and_sanitized(std::shared_ptr<Node> &Result, std::shared_ptr<Node> Op1, std::shared_ptr<Node> Op2 ) {
									std::shared_ptr<Node> reg_39 = std::make_shared<Node>();
reg_39 = not_sanitized(Op1); 
									if (toBool(reg_39)) {
										std::shared_ptr<Node> reg_40 = std::make_shared<Node>();
reg_40 = false_sanitized(); 
										}
									
else {
										std::shared_ptr<Node> reg_41 = std::make_shared<Node>();
reg_41 = not_sanitized(Op2); 
										if (toBool(reg_41)) {
											std::shared_ptr<Node> reg_42 = std::make_shared<Node>();
reg_42 = false_sanitized(); 
											}
										
else {
											std::shared_ptr<Node> reg_43 = std::make_shared<Node>();
reg_43 = true_sanitized(); 
											}
										}
									}
									void testRetourMultiple(std::shared_ptr<Node> &V1, std::shared_ptr<Node> &V2, std::shared_ptr<Node> Op1, std::shared_ptr<Node> Op2 ) {
										Op1 = EMPTY;
										Op2 = EMPTY;
										}
										void jeVeuxMourir(std::shared_ptr<Node> &Test1, std::shared_ptr<Node> &Test2, std::shared_ptr<Node> Op1, std::shared_ptr<Node> Op2, std::shared_ptr<Node> Op3 ) {
											std::shared_ptr<Node> Test3 = std::make_shared<Node>();
std::shared_ptr<Node> reg_44 = std::make_shared<Node>();
reg_44 = testRetourMultiple(Op1, Op2); 
											Op3 = EMPTY;
											}
											int main() { true_sanitized();return 0; }