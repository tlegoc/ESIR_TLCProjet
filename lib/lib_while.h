//
// Created by theo on 12/12/2023.
//

#ifndef LIB_LIB_WHILE_H
#define LIB_LIB_WHILE_H

#include <string>
#include <iostream>

using namespace std;

class Node;

bool toBool(Node &node);

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

    bool isSymbol() {
        return val != "" && val != "int" && val != "bool" && val != "string" && left_child == nullptr && right_child == nullptr;
    }

    Node() {
        left_child = nullptr;
        right_child = nullptr;
        val = "";
    };

    Node(string _val) {
        left_child = nullptr;
        right_child = new Node();
        right_child->val = _val;
        val = "string";
    };

    Node(bool b) {
        if (b) {
            left_child = nullptr;
            right_child = new Node();
            right_child->val = "t";
            val = "bool";
            return;
        }

        left_child = nullptr;
        right_child = nullptr;
        val = "bool";
    }

    Node(int number) {
        if (number == 0) {
            left_child = nullptr;
            right_child = nullptr;
            val = "";
            return;
        }

        left_child = nullptr;
        right_child = new Node(number - 1);
        val = "int";
    }

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

    Node operator==(const Node &node) {
        if (&node == this) {
            Node n = Node("bool");
            n.setRight(Node("t"));
            return n;
        }

        if (node.left_child != nullptr && left_child != nullptr) {
            Node n = *node.left_child == *left_child;
            if (!toBool(n)) {
                return Node();
            }
        }

        if (node.right_child != nullptr && right_child != nullptr) {
            Node n = *node.right_child == *right_child;
            if (!toBool(n)) {
                return Node();
            }
        }

        if (node.val != val)
        {
            return Node();
        }

        Node r = Node("bool");
        r.setRight(Node("t"));
        return r;
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


std::string toString(Node &node);

#endif //LIB_LIB_WHILE_H
