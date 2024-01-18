//
// Created by theo on 12/12/2023.
//

#include <regex>
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

NODE fromInt(int n) {
    if (n == 0) {
        return MSNIL();
    }

    TREE tree = MSTREE();
    tree->left_child = MSNIL();
    tree->right_child = fromInt(n - 1);

    return tree;
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

NODE equals(NODE A, NODE B) {
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
    if (node == nullptr)
    {
        cout << "nullptr";
        return;
    }

    if (node->m_type == NTREE) {
        TREE t = static_pointer_cast<CTree>(node);
        if (t->left_child->m_type == NSYMB) {
            SYMB s = static_pointer_cast<CSymb>(t->left_child);
            if (s->symb == "int") {
                cout << toInt(t->right_child);
                return;
            } else if (s->symb == "string") {
                cout << toString(t->right_child);
                return;
            } else if (s->symb == "bool") {
                if (toBool(t->right_child)) {
                    cout << "true";
                } else {
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

bool isNumber(const string &s) {
    return !s.empty() && std::find_if(s.begin(), s.end(), [](unsigned char c) { return !std::isdigit(c); }) == s.end();
}

// trim from start (in place)
void ltrim(std::string &s) {
    s.erase(s.begin(), std::find_if(s.begin(), s.end(), [](unsigned char ch) {
        return !std::isspace(ch);
    }));
}

// trim from end (in place)
void rtrim(std::string &s) {
    s.erase(std::find_if(s.rbegin(), s.rend(), [](unsigned char ch) {
        return !std::isspace(ch);
    }).base(), s.end());
}

NODE parseString(const string &s, bool &valid) {
    string str = s;
    auto pos = s.find("cons ");
    if (pos != string::npos)
        str.erase(pos, 5);

    // Trick to allow our routine to work
    str = std::regex_replace(str, std::regex("\\("), "( ");
    str = std::regex_replace(str, std::regex("\\)"), " )");
    str = std::regex_replace(str, std::regex("  "), " ");

    rtrim(str);
    ltrim(str);

    if (str[0] == '(' && str[str.size() - 1] == ')') {
        vector<string> separated;
        string current = "";
        int par_count = 0;
        bool building_subtree = false;
        for (int i = 1; i < str.size() - 1; i++) {
            char c = str[i];

            if (c == '(') {
                par_count++;
                building_subtree = true;
            } else if (c == ')') {
                par_count--;
                if (par_count == 0)
                    building_subtree = false;
            }

            if (c == ' ' && !building_subtree && current != "") {
                separated.emplace_back(current);
                current = "";
                continue;
            }

            current += c;
        }

        if (par_count != 0 || building_subtree || separated.size() != 2) {
            cout << "Parametres malformes." << endl;
            valid = false;
            return MSNIL();
        }

        TREE tree = MSTREE();
        tree->left_child = parseString(separated[0], valid);
        tree->right_child = parseString(separated[1], valid);

        return tree;
    } else if (str == "nil")
        return MSNIL();
    else {
        SYMB symb = MSSYMB();

        if (str[0] < 'a' || str[0] > 'z') {
            cout << "Parametres malformes." << endl;
            valid = false;
            return MSNIL();
        }

        for (int i = 1; i < str.size(); i++) {
            if (str[i] >= 'a' && str[i] <= 'z') continue;
            else if (str[i] >= 'A' && str[i] <= 'Z') continue;
            else if (str[i] >= '0' && str[i] <= '9') continue;
            else if (i == str.size() - 1 && (str[i] == '!' || str[i] == '?')) continue;

            cout << "Parametres malformes." << endl;
            valid = false;
            return MSNIL();
        }

        symb->symb = str;

        return symb;
    }
}


bool parseParameters(vector<NODE > &nodes, int argc, char **argv) {

    string current_exec_name = argv[0]; // Name of the current exec program
    string parameters;

    for (int i = 1; i < argc; ++i) {
        parameters += argv[i];
        parameters += " ";
    }

    cout << parameters << endl;

    vector<string> separated;
    string current = "";
    int par_count = 0;
    bool building_subtree = false;
    for (int i = 0; i < parameters.size(); i++) {
        char c = parameters[i];

        if (c == '(') {
            par_count++;
            building_subtree = true;
        } else if (c == ')') {
            par_count--;
            if (par_count == 0)
                building_subtree = false;
        }

        if (c == ' ' && !building_subtree) {
            separated.emplace_back(current);
            current = "";
            continue;
        }

        current += c;
    }

    if (par_count != 0 || building_subtree) {
        cout << "Parametres malformes." << endl;
        return false;
    }

    bool valid = true;
    for (auto &str: separated) {
        if (isNumber(str)) nodes.emplace_back(fromInt(stoi(str)));
        else nodes.emplace_back(parseString(str, valid));
    }

    if (!valid) {
        cout << "Parametres malformes." << endl;
        return false;
    }

    return true;
}