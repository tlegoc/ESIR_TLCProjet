#include "lib_while.h"
void true_sanitized(std::shared_ptr<Node> &Result ) {
	std::shared_ptr<Node> reg_0 = std::make_shared<Node>();
	Cons(reg_0, Nil(), Nil());
	Result = reg_0;
	}
	void false_sanitized(std::shared_ptr<Node> &Result ) {
		Nil(Result);
		}
		void not_sanitized(std::shared_ptr<Node> &Result, std::shared_ptr<Node> Op1 ) {
			if (toBool(Op1)) {
				std::shared_ptr<Node> reg_1 = std::make_shared<Node>();
reg_1 = false_sanitized(); 
				Result = reg_1;
				}
			
else {
				std::shared_ptr<Node> reg_2 = std::make_shared<Node>();
reg_2 = true_sanitized(); 
				Result = reg_2;
				}
			}
			void and_sanitized(std::shared_ptr<Node> &Result, std::shared_ptr<Node> Op1, std::shared_ptr<Node> Op2 ) {
				std::shared_ptr<Node> reg_3 = std::make_shared<Node>();
reg_3 = not_sanitized(Op1); 
				if (toBool(reg_3)) {
					std::shared_ptr<Node> reg_4 = std::make_shared<Node>();
reg_4 = false_sanitized(); 
					Result = reg_4;
					}
				
else {
					std::shared_ptr<Node> reg_5 = std::make_shared<Node>();
reg_5 = not_sanitized(Op2); 
					if (toBool(reg_5)) {
						std::shared_ptr<Node> reg_6 = std::make_shared<Node>();
reg_6 = false_sanitized(); 
						Result = reg_6;
						}
					
else {
						std::shared_ptr<Node> reg_7 = std::make_shared<Node>();
reg_7 = true_sanitized(); 
						Result = reg_7;
						}
					}
				}
				int main() { true_sanitized();return 0; }