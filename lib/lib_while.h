//
// Created by theo on 12/12/2023.
//

#ifndef LIB_LIB_WHILE_H
#define LIB_LIB_WHILE_H

#include <string>
#include <memory>
#include <iostream>

using namespace std;

class Node {

public:
    Node *left_child;
    Node *right_child;
    string val;

    void setLeft(const Node &node) {
        left_child = new Node(node);
    }

    void setRight(const Node &node) {
        right_child = new Node(node);
    }

    Node() {
        left_child = nullptr;
        right_child = nullptr;
        val = "";
    };

    // Copy
    Node(const Node &node) {
        if (&node == this) {
            return;
        }

        if (node.left_child == nullptr)
            left_child = nullptr;
        else
            left_child = new Node(*node.left_child);

        if (node.right_child == nullptr)
            right_child = nullptr;
        else
            right_child = new Node(*node.right_child);

        val = node.val;
    };

    ~Node() {
        delete left_child;
        delete right_child;
    }

    Node &operator=(const Node &node) {
        if (&node == this) {
            return *this;
        }

        if (node.left_child == nullptr)
            left_child = nullptr;
        else
            left_child = new Node(*node.left_child);

        if (node.right_child == nullptr)
            right_child = nullptr;
        else
            right_child = new Node(*node.right_child);

        val = node.val;
        return *this;
    };
};

void Nil(Node &res);

Node Nil();

void Symbol(Node &res, string val);

bool isLeaf(Node &res);

void Cons(Node &res);

void Cons(Node &res, Node T);

void Cons(Node &res, const Node A, const Node B);

void hd(Node &res, const Node &T);

void tl(Node &res, const Node &T);

int toInt(Node &node);

bool toBool(Node &node);

std::string toString(Node &node);

#endif //LIB_LIB_WHILE_H
