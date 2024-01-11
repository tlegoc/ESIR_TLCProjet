#include "lib_while.h"
void add(std::shared_ptr<Node> &Result, std::shared_ptr<Node> Op1, std::shared_ptr<Node> Op2 ) {
	std::shared_ptr<Node> reg_0 = std::make_shared<Node>();
reg_0 = Op1;
Result = reg_0;
std::shared_ptr<Node> reg_1 = std::make_shared<Node>();
reg_1 = Op2;
for (int _ID_for_0 = 0; _ID_for_0<= toInt(reg_1); _ID_for_0++ ) {
		std::shared_ptr<Node> reg_3 = std::make_shared<Node>();
reg_3 = Nil;
std::shared_ptr<Node> reg_4 = std::make_shared<Node>();
reg_4 = Result;
std::shared_ptr<Node> reg_6 = std::make_shared<Node>();
Cons(reg_6, reg_3, reg_4);
std::shared_ptr<Node> reg_2 = std::make_shared<Node>();
reg_2 = reg_6;
Result = reg_2;
}
	}
	void test(std::shared_ptr<Node> &Result, std::shared_ptr<Node> Op1, std::shared_ptr<Node> Op2 ) {
		std::shared_ptr<Node> reg_7 = std::make_shared<Node>();
reg_7 = Nil;
Result = reg_7;
add(,)std::shared_ptr<Node> reg_8 = std::make_shared<Node>();
reg_8 = Result;
std::shared_ptr<Node> reg_9 = std::make_shared<Node>();
reg_9 = Nil;
Result = reg_10;
add(reg_10,reg_8, reg_9)std::shared_ptr<Node> reg_11 = std::make_shared<Node>();
reg_11 = Result;
std::shared_ptr<Node> reg_12 = std::make_shared<Node>();
reg_12 = Nil;
Result = reg_13;
add(reg_13,reg_11, reg_12)std::shared_ptr<Node> reg_14 = std::make_shared<Node>();
reg_14 = Result;
std::shared_ptr<Node> reg_15 = std::make_shared<Node>();
reg_15 = Nil;
Result = reg_16;
add(reg_16,reg_14, reg_15)std::shared_ptr<Node> reg_17 = std::make_shared<Node>();
reg_17 = Result;
std::shared_ptr<Node> reg_18 = std::make_shared<Node>();
reg_18 = Nil;
Result = reg_19;
std::shared_ptr<Node> reg_21 = std::make_shared<Node>();
reg_21 = Result;
std::shared_ptr<Node> reg_20 = std::make_shared<Node>();
		tl(reg_20, reg_21);
		Result = reg_20;
std::shared_ptr<Node> reg_23 = std::make_shared<Node>();
reg_23 = Result;
std::shared_ptr<Node> reg_22 = std::make_shared<Node>();
		hd(reg_22, reg_23);
		Result = reg_22;
std::shared_ptr<Node> reg_24 = std::make_shared<Node>();
reg_24 = Result;
std::shared_ptr<Node> reg_25 = std::make_shared<Node>();
reg_25 = reg_24;
std::shared_ptr<Node> reg_26 = std::make_shared<Node>();
reg_26 = Result;
std::shared_ptr<Node> reg_27 = std::make_shared<Node>();
reg_27 = reg_26;
std::shared_ptr<Node> reg_28 = std::make_shared<Node>();
reg_28 = Result;
std::shared_ptr<Node> reg_29 = std::make_shared<Node>();
reg_29 = reg_28;
std::shared_ptr<Node> reg_30 = std::make_shared<Node>();
reg_30 = Result;
std::shared_ptr<Node> reg_31 = std::make_shared<Node>();
reg_31 = reg_30;
std::shared_ptr<Node> reg_33 = std::make_shared<Node>();
reg_33 = Nil;
std::shared_ptr<Node> reg_34 = std::make_shared<Node>();
Cons(reg_34, reg_31, reg_33);
std::shared_ptr<Node> reg_35 = std::make_shared<Node>();
Cons(reg_35, reg_29, reg_34);
std::shared_ptr<Node> reg_36 = std::make_shared<Node>();
Cons(reg_36, reg_27, reg_35);
std::shared_ptr<Node> reg_37 = std::make_shared<Node>();
Cons(reg_37, reg_25, reg_36);
Result = reg_37;
std::shared_ptr<Node> reg_39 = std::make_shared<Node>();
reg_39 = Result;
std::shared_ptr<Node> reg_40 = std::make_shared<Node>();
reg_40 = Result;
std::shared_ptr<Node> reg_41 = std::make_shared<Node>();
reg_41 = Result;
std::shared_ptr<Node> reg_43 = std::make_shared<Node>();
reg_43 = Result;
std::shared_ptr<Node> reg_44 = std::make_shared<Node>();
Cons(reg_44, reg_43, Nil);
std::shared_ptr<Node> reg_42 = std::make_shared<Node>();
reg_42 = reg_44;
std::shared_ptr<Node> reg_46 = std::make_shared<Node>();
Cons(reg_46, reg_41, reg_42);
std::shared_ptr<Node> reg_47 = std::make_shared<Node>();
Cons(reg_47, reg_40, reg_46);
std::shared_ptr<Node> reg_48 = std::make_shared<Node>();
Cons(reg_48, reg_39, reg_47);
std::shared_ptr<Node> reg_38 = std::make_shared<Node>();
reg_38 = reg_48;
Result = reg_38;
std::shared_ptr<Node> reg_49 = std::make_shared<Node>();
reg_49 = Op2;
while (toBool(reg_49)) {
			std::shared_ptr<Node> Test = std::make_shared<Node>();
std::shared_ptr<Node> reg_50 = std::make_shared<Node>();
reg_50 = Result;
std::shared_ptr<Node> reg_51 = std::make_shared<Node>();
reg_51 = reg_50;
std::shared_ptr<Node> reg_53 = std::make_shared<Node>();
reg_53 = Nil;
std::shared_ptr<Node> reg_54 = std::make_shared<Node>();
Cons(reg_54, reg_51, reg_53);
Result = reg_54;
std::shared_ptr<Node> reg_55 = std::make_shared<Node>();
reg_55 = Nil;
Test = reg_55;
}
		std::shared_ptr<Node> reg_57 = std::make_shared<Node>();
reg_57 = Result;
add(reg_19,reg_17, reg_18)std::shared_ptr<Node> reg_58 = std::make_shared<Node>();
reg_58 = Result;
std::shared_ptr<Node> reg_59 = std::make_shared<Node>();
reg_59 = Nil;
std::shared_ptr<Node> reg_62 = std::make_shared<Node>();
Cons(reg_62, reg_57, reg_60);
std::shared_ptr<Node> reg_56 = std::make_shared<Node>();
reg_56 = reg_62;
while (toBool(reg_56)) {
			std::shared_ptr<Node> reg_63 = std::make_shared<Node>();
reg_63 = Nil;
Result = reg_63;
}
		std::shared_ptr<Node> Test = std::make_shared<Node>();
std::shared_ptr<Node> reg_64 = std::make_shared<Node>();
reg_64 = Nil;
Test = reg_64;
}
		void sub(std::shared_ptr<Node> &Result, std::shared_ptr<Node> Op1, std::shared_ptr<Node> Op2 ) {
			std::shared_ptr<Node> reg_65 = std::make_shared<Node>();
reg_65 = Op1;
Result = reg_65;
std::shared_ptr<Node> reg_66 = std::make_shared<Node>();
reg_66 = Op2;
for (int _ID_for_0 = 0; _ID_for_0<= toInt(reg_66); _ID_for_0++ ) {
				std::shared_ptr<Node> reg_68 = std::make_shared<Node>();
reg_68 = Result;
std::shared_ptr<Node> reg_67 = std::make_shared<Node>();
				tl(reg_67, reg_68);
				Result = reg_67;
}
			}
			void mul(std::shared_ptr<Node> &Result, std::shared_ptr<Node> Op1, std::shared_ptr<Node> Op2 ) {
				std::shared_ptr<Node> reg_69 = std::make_shared<Node>();
reg_69 = Op1;
for (int _ID_for_0 = 0; _ID_for_0<= toInt(reg_69); _ID_for_0++ ) {
					add(reg_60,reg_58, reg_59)std::shared_ptr<Node> reg_70 = std::make_shared<Node>();
reg_70 = Result;
std::shared_ptr<Node> reg_71 = std::make_shared<Node>();
reg_71 = Op2;
Result = reg_72;
}
				}
				void test2(std::shared_ptr<Node> &Result, std::shared_ptr<Node> Op1, std::shared_ptr<Node> Op2 ) {
					std::shared_ptr<Node> reg_73 = std::make_shared<Node>();
reg_73 = Nil;
Result = reg_73;
add(reg_72,reg_70, reg_71)std::shared_ptr<Node> reg_74 = std::make_shared<Node>();
reg_74 = Result;
std::shared_ptr<Node> reg_75 = std::make_shared<Node>();
reg_75 = Nil;
Result = reg_76;
add(reg_76,reg_74, reg_75)std::shared_ptr<Node> reg_77 = std::make_shared<Node>();
reg_77 = Result;
std::shared_ptr<Node> reg_78 = std::make_shared<Node>();
reg_78 = Nil;
Result = reg_79;
add(reg_79,reg_77, reg_78)std::shared_ptr<Node> reg_80 = std::make_shared<Node>();
reg_80 = Result;
std::shared_ptr<Node> reg_81 = std::make_shared<Node>();
reg_81 = Nil;
Result = reg_82;
add(reg_82,reg_80, reg_81)std::shared_ptr<Node> reg_83 = std::make_shared<Node>();
reg_83 = Result;
std::shared_ptr<Node> reg_84 = std::make_shared<Node>();
reg_84 = Nil;
Result = reg_85;
}
					void true_sanitized(std::shared_ptr<Node> &Result ) {
						std::shared_ptr<Node> reg_87 = std::make_shared<Node>();
reg_87 = Nil;
std::shared_ptr<Node> reg_88 = std::make_shared<Node>();
reg_88 = Nil;
std::shared_ptr<Node> reg_90 = std::make_shared<Node>();
Cons(reg_90, reg_87, reg_88);
std::shared_ptr<Node> reg_86 = std::make_shared<Node>();
reg_86 = reg_90;
Result = reg_86;
}
						void false_sanitized(std::shared_ptr<Node> &Result ) {
							Result = Nil;
}
							void not_sanitized(std::shared_ptr<Node> &Result, std::shared_ptr<Node> Op1 ) {
								std::shared_ptr<Node> reg_91 = std::make_shared<Node>();
reg_91 = Op1;
if (toBool(reg_91)) {
									false(reg_85reg_83, reg_84)Result = reg_92;
}
								
else {
									true(reg_92)Result = reg_93;
}
								}
								void and_sanitized(std::shared_ptr<Node> &Result, std::shared_ptr<Node> Op1, std::shared_ptr<Node> Op2 ) {
									not(reg_93,)std::shared_ptr<Node> reg_94 = std::make_shared<Node>();
reg_94 = Op1;
if (toBool(reg_95)) {
										false(reg_95reg_94)Result = reg_96;
}
									
else {
										not(reg_96,)std::shared_ptr<Node> reg_97 = std::make_shared<Node>();
reg_97 = Op2;
if (toBool(reg_98)) {
											false(reg_98reg_97)Result = reg_99;
}
										
else {
											true(reg_99)Result = reg_100;
}
										}
									}
									void testRetourMultiple(std::shared_ptr<Node> &V1, std::shared_ptr<Node> &V2, std::shared_ptr<Node> Op1, std::shared_ptr<Node> Op2 ) {
										std::shared_ptr<Node> reg_101 = std::make_shared<Node>();
reg_101 = Op1;
V1 = reg_101;
std::shared_ptr<Node> reg_102 = std::make_shared<Node>();
reg_102 = Op2;
V2 = reg_102;
}
										void jeVeuxMourir(std::shared_ptr<Node> &Test1, std::shared_ptr<Node> &Test2, std::shared_ptr<Node> Op1, std::shared_ptr<Node> Op2 ) {
											std::shared_ptr<Node> Test3 = std::make_shared<Node>();
std::shared_ptr<Node> Test4 = std::make_shared<Node>();
testRetourMultiple(reg_100,)std::shared_ptr<Node> reg_103 = std::make_shared<Node>();
reg_103 = Op1;
std::shared_ptr<Node> reg_104 = std::make_shared<Node>();
reg_104 = Op2;
Test1 = reg_105;
Test1 = reg_105;
std::shared_ptr<Node> reg_107 = std::make_shared<Node>();
reg_107 = Nil;
Test2 = reg_107;
std::shared_ptr<Node> reg_109 = std::make_shared<Node>();
reg_109 = a;
std::shared_ptr<Node> reg_111 = std::make_shared<Node>();
reg_111 = b;
std::shared_ptr<Node> reg_112 = std::make_shared<Node>();
reg_112 = Nil;
std::shared_ptr<Node> reg_114 = std::make_shared<Node>();
Cons(reg_114, reg_111, reg_112);
std::shared_ptr<Node> reg_110 = std::make_shared<Node>();
reg_110 = reg_114;
std::shared_ptr<Node> reg_116 = std::make_shared<Node>();
Cons(reg_116, reg_109, reg_110);
std::shared_ptr<Node> reg_108 = std::make_shared<Node>();
reg_108 = reg_116;
Test4 = reg_108;
}
											int main() { main_sanitized();return 0; }