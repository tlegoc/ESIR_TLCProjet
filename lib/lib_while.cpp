//
// Created by theo on 12/12/2023.
//

#include "lib_while.h"

void Nil(Node &res) {
    cout << "Nil" << endl;
    res = Node();
    res.left_child = nullptr;
    res.right_child = nullptr;
    res.val = "";
}

Node Nil() {
    cout << "Nil" << endl;
    Node res = Node();
    res.left_child = nullptr;
    res.right_child = nullptr;
    res.val = "";
    return res;
}

void Symbol(Node &res, std::string val) {
    cout << "Symbol" << endl;
    res = Node();
    res.left_child = nullptr;
    res.right_child = nullptr;
    res.val = std::move(val);
}

bool isLeaf(Node &res) {
    cout << "isLeaf" << endl;
    return res.left_child == nullptr && res.right_child == nullptr;
}

void Cons(Node &res) {
    cout << "Cons" << endl;
    Nil(res);
}

void Cons(Node &res, Node T) {
    cout << "Cons" << endl;
    res = T;
}

void Cons(Node &res, const Node A, const Node B) {
    cout << "Cons" << endl;
    res = Node();
    res.left_child = new Node(A);
    res.right_child = new Node(B);
    res.val = "";
}

void hd(Node &res, const Node &T) {
    cout << "hd" << endl;
    res = *T.left_child;
}

void tl(Node &res, const Node &T) {
    cout << "tl" << endl;
    res = *T.right_child;
}


int toInt(Node &node) {
    cout << "toInt" << endl;
    if (isLeaf(node)) {
        return 0;
    } else {
        return 1 + toInt(*node.right_child);
    }
}

bool toBool(Node &node) {
    cout << "toBool" << endl;
    return !isLeaf(node);
}

std::string toString(Node &node) {
    cout << "toString" << endl;
    if (isLeaf(node)) {
        return node.val;
    } else {
        return toString(*node.left_child) + toString(*node.right_child);
    }
}