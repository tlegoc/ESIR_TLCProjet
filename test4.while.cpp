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
		add(Result,Result, reg_2)std::shared_ptr<Node> reg_3 = std::make_shared<Node>();
		Cons(reg_3);
		add(Result,Result, reg_3)std::shared_ptr<Node> reg_4 = std::make_shared<Node>();
		Cons(reg_4);
		add(Result,Result, reg_4)std::shared_ptr<Node> reg_5 = std::make_shared<Node>();
		Cons(reg_5);
		add(Result,Result, reg_5)std::shared_ptr<Node> reg_6 = std::make_shared<Node>();
		tl(reg_6, Result);
		std::shared_ptr<Node> reg_6 = std::make_shared<Node>();
reg_6 = EMPTY;
		std::shared_ptr<Node> reg_7 = std::make_shared<Node>();
		hd(reg_7, Result);
		std::shared_ptr<Node> reg_7 = std::make_shared<Node>();
reg_7 = EMPTY;
		std::shared_ptr<Node> reg_8 = std::make_shared<Node>();
Nil(reg_8);
		std::shared_ptr<Node> reg_9 = std::make_shared<Node>();
		Cons(reg_9, Result, reg_8);
		std::shared_ptr<Node> reg_10 = std::make_shared<Node>();
		Cons(reg_10, Result, reg_9);
		std::shared_ptr<Node> reg_11 = std::make_shared<Node>();
		Cons(reg_11, Result, reg_10);
		std::shared_ptr<Node> reg_12 = std::make_shared<Node>();
		Cons(reg_12, Result, reg_11);
		std::shared_ptr<Node> reg_12 = std::make_shared<Node>();
reg_12 = EMPTY;
		std::shared_ptr<Node> reg_13 = std::make_shared<Node>();
reg_13 = Result;
		std::shared_ptr<Node> reg_14 = std::make_shared<Node>();
		Cons(reg_14, Result, reg_13);
		std::shared_ptr<Node> reg_15 = std::make_shared<Node>();
		Cons(reg_15, Result, reg_14);
		std::shared_ptr<Node> reg_16 = std::make_shared<Node>();
		Cons(reg_16, Result, reg_15);
		std::shared_ptr<Node> reg_16 = std::make_shared<Node>();
reg_16 = EMPTY;
		while (toBool(Op2)) {
			std::shared_ptr<Node> Test = std::make_shared<Node>();
std::shared_ptr<Node> reg_17 = std::make_shared<Node>();
Nil(reg_17);
			std::shared_ptr<Node> reg_18 = std::make_shared<Node>();
			Cons(reg_18, Result, reg_17);
			std::shared_ptr<Node> reg_18 = std::make_shared<Node>();
reg_18 = EMPTY;
			std::shared_ptr<Node> reg_19 = std::make_shared<Node>();
			Cons(reg_19);
			std::shared_ptr<Node> reg_19 = std::make_shared<Node>();
reg_19 = EMPTY;
			}
		std::shared_ptr<Node> Test = std::make_shared<Node>();
std::shared_ptr<Node> reg_20 = std::make_shared<Node>();
		Cons(reg_20);
		std::shared_ptr<Node> reg_20 = std::make_shared<Node>();
reg_20 = EMPTY;
		}
		void sub(std::shared_ptr<Node> &Result, std::shared_ptr<Node> Op1, std::shared_ptr<Node> Op2 ) {
			Op1 = EMPTY;
			for (int _ID_for_0 = 0; _ID_for_0<= toInt(Op2); _ID_for_0++ ) {
				std::shared_ptr<Node> reg_21 = std::make_shared<Node>();
				tl(reg_21, Result);
				std::shared_ptr<Node> reg_21 = std::make_shared<Node>();
reg_21 = EMPTY;
				}
			}
			void mul(std::shared_ptr<Node> &Result, std::shared_ptr<Node> Op1, std::shared_ptr<Node> Op2 ) {
				for (int _ID_for_0 = 0; _ID_for_0<= toInt(Op1); _ID_for_0++ ) {
					add(Result,Result, Op2)}
				}
				void test2(std::shared_ptr<Node> &Result, std::shared_ptr<Node> Op1, std::shared_ptr<Node> Op2 ) {
					std::shared_ptr<Node> reg_22 = std::make_shared<Node>();
					Cons(reg_22);
					std::shared_ptr<Node> reg_22 = std::make_shared<Node>();
reg_22 = EMPTY;
					std::shared_ptr<Node> reg_23 = std::make_shared<Node>();
					Cons(reg_23);
					add(Result,Result, reg_23)std::shared_ptr<Node> reg_24 = std::make_shared<Node>();
					Cons(reg_24);
					add(Result,Result, reg_24)std::shared_ptr<Node> reg_25 = std::make_shared<Node>();
					Cons(reg_25);
					add(Result,Result, reg_25)std::shared_ptr<Node> reg_26 = std::make_shared<Node>();
					Cons(reg_26);
					add(Result,Result, reg_26)}
					void true_sanitized(std::shared_ptr<Node> &Result ) {
						std::shared_ptr<Node> reg_27 = std::make_shared<Node>();
						Cons(reg_27, Nil(), Nil());
						std::shared_ptr<Node> reg_27 = std::make_shared<Node>();
reg_27 = EMPTY;
						}
						void false_sanitized(std::shared_ptr<Node> &Result ) {
							nil = EMPTY;
							}
							void not_sanitized(std::shared_ptr<Node> &Result, std::shared_ptr<Node> Op1 ) {
								if (toBool(Op1)) {
									false(Result)}
								
else {
									true(Result)}
								}
								void and_sanitized(std::shared_ptr<Node> &Result, std::shared_ptr<Node> Op1, std::shared_ptr<Node> Op2 ) {
									not(Result,Op1)if (toBool(EMPTY)) {
										false(Test)}
									
else {
										not(Test,Op2)if (toBool(EMPTY)) {
											false(Result)}
										
else {
											true(Result)}
										}
									}
									void testRetourMultiple(std::shared_ptr<Node> &V1, std::shared_ptr<Node> &V2, std::shared_ptr<Node> Op1, std::shared_ptr<Node> Op2 ) {
										Op1 = EMPTY;
										Op2 = EMPTY;
										}
										void jeVeuxMourir(std::shared_ptr<Node> &Test1, std::shared_ptr<Node> &Test2, std::shared_ptr<Node> Op1, std::shared_ptr<Node> Op2 ) {
											std::shared_ptr<Node> Test3 = std::make_shared<Node>();
std::shared_ptr<Node> Test4 = std::make_shared<Node>();
testRetourMultiple(Result, Result,Op1, Op2)std::shared_ptr<Node> reg_28 = std::make_shared<Node>();
											Cons(reg_28);
											std::shared_ptr<Node> reg_28 = std::make_shared<Node>();
reg_28 = EMPTY;
											std::shared_ptr<Node> reg_30 = std::make_shared<Node>();
											Cons(reg_30, b, Nil());
											std::shared_ptr<Node> reg_29 = std::make_shared<Node>();
											Cons(reg_29, a, reg_30);
											std::shared_ptr<Node> reg_29 = std::make_shared<Node>();
reg_29 = EMPTY;
											}
											int main() { main_sanitized();return 0; }