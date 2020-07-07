#include<iostream>
#include<queue>
using namespace std;
struct node {
    node *left;
    node *right;
    int data;
};

node* insert(node *root, int data){
    if(root==NULL){
        root = (node*)malloc(sizeof(node));
        root->data = data;
        root->left = root->right = NULL;
    }
    else if(data <= root->data){
        root->left = insert(root->left, data);
    }
    else if(data > root->data){
        root->right = insert(root->right, data);
    }
    return root;
}

bool search(node *root, int data){
    if(root==NULL){
        return false;
    }
    if(data == root->data){
        return true;
    }
    else if(data < root->data){
        printf("LEFT\n");
        return search(root->left,data);
    }
    else{
        printf("RIGHT\n");
        return search(root->right,data);
    }
}

//REMEMBER: HEIGHT IS THE NUMBER OF EDGES, NOT NODES!
int height(node *root){
    if(root==NULL){
        return -1;
    }else{
        int leftHeight = height(root->left);
        int rightHeight = height(root->right);
        return (leftHeight>rightHeight?leftHeight:rightHeight)+1;
    }
}

void levelOrderTraversal(node *root){
    if(root==NULL){
        cout<<"There is no tree lmao"<<endl;
    }
    else{
        queue <node*> Q;
        Q.push(root);
        while(!Q.empty()){
            node *curr = Q.front();
            cout<<curr->data<<" ";
            if(curr->left!=NULL){
                Q.push(curr->left);
            }
            if(curr->right!=NULL){
                Q.push(curr->right);
            }
            Q.pop();

        }
    }
}

// node* FindMin(node *root){
//     if(root->left==NULL){
//         return root;
//     }else{
//         return FindMin(root->left);
//     }
// }
node* FindMin(node* root)
{
	while(root->left != NULL) root = root->left;
	return root;
}

node* Delete(node *root, int data) {
    if(root==NULL)
    {
        return root;
    }
    else if(data < root->data)
    {
        root->left = Delete(root->left, data);
    }
    else if(data > root->data)
    {
        root->right = Delete(root->right, data);
    }
    else
    {
        if(root->left == NULL && root->right == NULL) 
        { 
			delete root;
			root = NULL;
		}
		else if(root->left == NULL) 
        {
			struct node *temp = root;
			root = root->right;
			delete temp;
		}
		else if(root->right == NULL) 
        {
			struct node *temp = root;
			root = root->left;
			delete temp;
		}
		else 
        { 
			struct node *temp = FindMin(root->right);
			root->data = temp->data;
			root->right = Delete(root->right,temp->data);
		}
    }
    return root;
}




int main(){
    node *root = NULL;
    root = insert(root, 12);
    root = insert(root, 5);
    root = insert(root, 15);
    root = insert(root, 3);
    root = insert(root, 7);
    root = insert(root, 13);
    root = insert(root, 17);
    root = insert(root, 1);
    root = insert(root, 9);
    // if(search(root, 150)){
    //     cout<<"Found\n";
    // }else{
    //     cout<<"Lol no";
    // }
    // cout<<height(root);
    levelOrderTraversal(root);
    root = Delete(root, 15);
    cout<<"\n";
    levelOrderTraversal(root);
    
}