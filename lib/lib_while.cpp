//
// Created by theo on 12/12/2023.
//

#include "lib_while.h"

bool toBool(NODE node) {
    return node->m_type == NTREE;
}

void Nil(NODE &res) {
    res = MSNIL();
}

NIL Nil() {
    return MSNIL();
}

void Symbol(NODE &res, string val) {
    SYMB s = MSSYMB();
    s->symb = val;
    res = s;
}

bool isLeaf(NODE &res) {
    return res->m_type != NTREE;
}

void Cons(NODE &res) {
    res = MSNIL();
}

void Cons(NODE &res, NODE T) {
    res = T->clone();
}

void Cons(NODE &res, NODE A, NODE B) {
    TREE tree = MSTREE();
    tree->left_child = A->clone();
    tree->right_child = B->clone();
    res = tree;
}

void hd(NODE &res, NODE &T) {
    if (T->m_type == NTREE) {
        res = static_pointer_cast<CTree>(T)->left_child->clone();
        return;
    }

    res = MSNIL();
}

void tl(NODE &res, NODE &T) {
    if (T->m_type == NTREE) {
        res = static_pointer_cast<CTree>(T)->right_child->clone();
        return;
    }

    res = MSNIL();
}

int toInt(NODE &node) {
    if (node->m_type == NTREE) {
        return 1 + toInt(static_pointer_cast<CTree>(node)->right_child);
    }

    return 0;
}

string toString(NODE &node) {
    if (node->m_type == NTREE) {
        return toString(static_pointer_cast<CTree>(node)->left_child) +
               toString(static_pointer_cast<CTree>(node)->right_child);
    } else if (node->m_type == NSYMB) {
        return static_pointer_cast<CSymb>(node)->symb;
    }

    return "";
}

bool isNil(NODE &node) {
    return node->m_type == NNIL;
}

NODE equals(NODE &A, NODE &B) {
    if (A->m_type == NNIL && B->m_type == NNIL) {
        return MSTRUE();
    } else if (A->m_type == NSYMB && B->m_type == NSYMB) {
        bool r = static_pointer_cast<CSymb>(A)->symb == static_pointer_cast<CSymb>(B)->symb;
        if (r) {
            return MSTRUE();
        } else {
            return MSFALSE();
        }

    } else if (A->m_type == NTREE && B->m_type == NTREE) {
        NODE left = equals(static_pointer_cast<CTree>(A)->left_child, static_pointer_cast<CTree>(B)->left_child);
        NODE right = equals(static_pointer_cast<CTree>(A)->right_child, static_pointer_cast<CTree>(B)->right_child);

        if (toBool(left) && toBool(right)) {
            return MSTRUE();
        }
    }

    return MSFALSE();
}

void ppln(NODE &node) {
    pp(node);
    cout << endl;
}

void pp(NODE &node) {
    if (node->m_type == NTREE) {
        TREE t = static_pointer_cast<CTree>(node);
        if (t->left_child->m_type == NSYMB)
        {
            SYMB s = static_pointer_cast<CSymb>(t->left_child);
            if (s->symb == "int")
            {
                cout << toInt(t->right_child);
                return;
            } else if (s->symb == "string")
            {
                cout << toString(t->right_child);
                return;
            } else if (s->symb == "bool")
            {
                if (toBool(t->right_child))
                {
                    cout << "true";
                } else
                {
                    cout << "false";
                }
                return;
            }
        }

        cout << "(cons ";
        pp(t->left_child);
        cout << " ";
        pp(t->right_child);
        cout << ")";
    } else if (node->m_type == NSYMB) {
        cout << static_pointer_cast<CSymb>(node)->symb;
    } else if (node->m_type == NNIL) {
        cout << "nil";
    }
}