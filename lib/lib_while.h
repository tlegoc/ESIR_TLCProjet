//
// Created by theo on 12/12/2023.
//

#ifndef LIB_LIB_WHILE_H
#define LIB_LIB_WHILE_H

#include <string>
#include <memory>

struct Node {
    std::shared_ptr<Node> left_child;
    std::shared_ptr<Node> right_child;
    std::string val;

    Node() {
        val = "";
    }

    Node(Node const &copy) {
        left_child = std::make_shared<Node>(*copy.left_child.get());
        right_child = std::make_shared<Node>(*copy.right_child.get());

        val = copy.val;
    }
};

void printNode(std::shared_ptr<Node> node) {

}

void Nil(std::shared_ptr<Node> res);

std::shared_ptr<Node> Nil();

void Symbol(std::shared_ptr<Node> res, std::string val);

bool isLeaf(std::shared_ptr<Node> res);

void Cons(std::shared_ptr<Node> res);

void Cons(std::shared_ptr<Node> res, std::shared_ptr<Node> T);

void Cons(std::shared_ptr<Node> res, std::shared_ptr<Node> A, std::shared_ptr<Node> B);

void hd(std::shared_ptr<Node> res, std::shared_ptr<Node> T);

void tl(std::shared_ptr<Node> res, std::shared_ptr<Node> T);

int toInt(std::shared_ptr<Node> node);

bool toBool(std::shared_ptr<Node> node);

std::string toString(std::shared_ptr<Node> node);
#endif //LIB_LIB_WHILE_H
