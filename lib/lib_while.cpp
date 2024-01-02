//
// Created by theo on 12/12/2023.
//

#include "lib_while.h"

#include <utility>

void Nil(std::shared_ptr<Node> res) {
    res = std::make_shared<Node>();
    res->left_child = nullptr;
    res->right_child = nullptr;
    res->val = "";
}

void Symbol(std::shared_ptr<Node> res, std::string val) {
    res = std::make_shared<Node>();
    res->left_child = nullptr;
    res->right_child = nullptr;
    res->val = std::move(val);
}

bool isLeaf(std::shared_ptr<Node> res) {
    return res->left_child == nullptr && res->right_child == nullptr;
}

void Cons(std::shared_ptr<Node> res) {
    Nil(res);
}

void Cons(std::shared_ptr<Node> res, std::shared_ptr<Node> T) {
    res = T;
}

void Cons(std::shared_ptr<Node> res, std::shared_ptr<Node> A, std::shared_ptr<Node> B) {
    res = std::make_shared<Node>();
    res->left_child = A;
    res->right_child = B;
    res->val = "";
}

void hd(std::shared_ptr<Node> res, std::shared_ptr<Node> T) {
    res = T->left_child;
}

void tl(std::shared_ptr<Node> res, std::shared_ptr<Node> T) {
    res = T->right_child;
}


int toInt(std::shared_ptr<Node> node) {
    if(node == nullptr || isLeaf(node)){
        return 0;
    } else {
        return 1 + toInt_rec(node->right_child);
    }
}

bool toBool(std::shared_ptr<Node> node) {
    return !(node == nullptr || isLeaf(node))
}

std::string toString(std::shared_ptr<Node> node) {
    if(node == nullptr) {
        return "";
    }
    else if(isLeaf(node)) {
        return node->val;
    }
    else {
        return node->val + toString(node->right_child);
    }
}