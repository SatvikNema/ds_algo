#include<iostream>
using namespace std;
struct node{
    int data;
    node *next;
};
node* insert(node *head, int a)
{
    node *newNode = (node*)malloc(sizeof(node));
    newNode->data = a;
    newNode->next = NULL;
    if(head==NULL){
        head = newNode;
    }
    else{
        node *temp = head;
        while(temp->next!=NULL)
        {
            temp = temp->next;
        }
        temp->next = newNode;
    }
    return head;
}
void printList(node *head){
    node *temp = head;
    while(temp!=NULL){
        cout<<temp->data<<" ";
        temp = temp->next;
    }
    cout<<"COMPLTED!\n";
}

void freeLinkedList(node *head)
{
    while(head!=NULL){
        node *temp = head;
        head = head->next;
        free(temp);
    }
}

int main()
{
    node *head = NULL;
    head = insert(head, 2);
    head = insert(head, 5);
    head = insert(head, 10);
    head = insert(head, 14);
    printList(head);

    node *head2 = NULL;
    head2 = insert(head2, 5);
    head2 = insert(head2, 6);
    head2 = insert(head2, 7);
    head2 = insert(head2, 21);
    printList(head2);

    node *temp1 = head;
    node *temp2 = head2;
    node *head3 = NULL;
    // //making a new linked list and doing
    // while(temp1!=NULL and temp2!=NULL)
    // {
    //     if(temp1->data < temp2->data)
    //     {
    //         head3 = insert(head3, temp1->data);
    //         temp1 = temp1->next;
    //     }
    //     else{
    //         head3 = insert(head3, temp2->data);
    //         temp2 = temp2->next;
    //     }
    // }
    // while(temp1!=NULL){
    //     head3 = insert(head3, temp1->data);
    //     temp1 = temp1->next;
    // }
    // while(temp2!=NULL){
    //     head3 = insert(head3, temp2->data);
    //     temp2 = temp2->next;
    // }
    // printList(head3);
    // freeLinkedList(head3);
    //----------------------------------------------------
    cout<<"Without making another linked list\n";
    temp1 = head;
    temp2 = head2;
    head3 = NULL;
    node *swap;
    if(temp1->data < temp2->data){
        head3 = temp1;
        temp1 = temp1->next;
    }
    else{
        head3 = temp2;
        temp2 = temp2->next;
    }
    node *swap2;
    node *swap69 = head3;
    while(temp1!=NULL && temp2!=NULL){
        if(temp1->data < temp2->data){
            swap69->next = temp1;
            temp1 = temp1->next;
        }
        else{
            swap69->next = temp2;
            temp2 = temp2->next;
        }
        swap69 = swap69->next;
        printList(head3);
    }
    if(temp1!=NULL){
        swap69->next = temp1;
    }
    if(temp2!=NULL){
        swap69->next = temp2;
    }
    printList(head3);
    freeLinkedList(head);
    freeLinkedList(head2);
}