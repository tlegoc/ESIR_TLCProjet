//
// Created by theo on 12/12/2023.
//

#ifndef LIB_LIB_WHILE_H
#define LIB_LIB_WHILE_H

#include <string>
#include <iostream>
#include <memory>

using namespace std;

enum NodeType {
    NTREE,
    NSYMB,
    NNIL
};


#define NODE shared_ptr<INode>
#define TREE shared_ptr<CTree>
#define MSTREE make_shared<CTree>
#define SYMB shared_ptr<CSymb>
#define MSSYMB make_shared<CSymb>
#define NIL shared_ptr<CNil>
#define MSNIL make_shared<CNil>
#define MSTRUE make_shared<CTree>
#define MSFALSE make_shared<CNil>
#define COPY(x) x->clone()

class INode {
public:
    explicit INode(const NodeType type) : m_type(type) {}

    virtual NODE clone() = 0;

    const NodeType m_type;
};

class CTree : public INode {
public:
    NODE left_child = nullptr;
    NODE right_child = nullptr;

    CTree() : INode(NTREE) {}

    NODE clone() override {
        TREE tree = MSTREE();
        tree->left_child = left_child->clone();
        tree->right_child = right_child->clone();

        return tree;
    }

    CTree &operator=(const CTree &other) {
        if (this != &other) {
            left_child = other.left_child->clone();
            right_child = other.right_child->clone();
        }

        return *this;
    }
};

class CSymb : public INode {
public:
    string symb;

    CSymb() : INode(NSYMB) {}

    NODE clone() override {
        SYMB s = MSSYMB();
        s->symb = symb;
        return s;
    }
};

class CNil : public INode {
public:
    CNil() : INode(NNIL) {}

    NODE clone() override {
        return MSNIL();
    }
};

bool toBool(NODE node);

void Nil(NODE &res);

NIL Nil();

void Symbol(NODE &res, string val);

bool isLeaf(NODE &res);

void Cons(NODE &res);

void Cons(NODE &res, NODE T);

void Cons(NODE &res, NODE A, NODE B);

void hd(NODE &res, NODE &T);

void tl(NODE &res, NODE &T);

int toInt(NODE &node);

std::string toString(NODE &node);

bool isNil(NODE &node);

NODE equals(NODE &A, NODE &B);

void pp(NODE &node);

void ppln(NODE &node);

#endif //LIB_LIB_WHILE_H
