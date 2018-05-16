#include<stdio.h>
#include<iostream>
using namespace std;
#include<malloc.h>
#include<stdlib.h>
#include<memory.h>
typedef int ElemType;
typedef  ElemType* Iterator;
typedef struct LNode
{
	ElemType data;
	struct LNode *next;
}LNode,*Linklist;
LNode *Buynode()
{
	LNode *s=(LNode *)malloc(sizeof(LNode));
	if(NULL == s)// if(s = NULL)
	{
		exit(1);
	}
	memset(s,0,sizeof(LNode));
	return s;
}
LNode *CreateHead()
{
	LNode *pt=Buynode();
	return pt;
}
ElemType length(LNode *pt)
{
	int len=0;
	LNode *p=pt->next;
	while(p!=NULL)
	{
		len+=1;
		p=p->next;
	}
	return len;
}
bool isempty(LNode *pt)
{
	if(!length(pt))
	{
		return true;
	}
	return false;
}
void print_list(LNode *pt)
{
	LNode *p = pt->next;
	while(p != NULL)
	{
		cout<<p->data<<"  ";
		p = p->next;
	}
	cout<<endl;
}
void Destorylist(LNode *pt)
{   
	free(pt);
}
void push_front(LNode *pt,ElemType x)
{
	LNode *s=Buynode();
	s->data=x;
	s->next=pt->next;
	pt->next=s;
}
void push_back(LNode *pt,ElemType x)
{
	LNode *s=Buynode();
	LNode *p=pt;
	while(p->next!=NULL)
	{
		p=p->next;
	}
	s->data=x;
	s->next=NULL;
	p->next=s;
	
}
void pop_back(LNode *pt)
{
	    LNode *p=pt;
		LNode *q=pt;
		while(p->next!=NULL)
		{
			q=p;
			p=p->next;
		}
		q->next=NULL;
}
void pop_front(LNode *pt)
{
	LNode *p=pt->next;
	pt->next=p->next;
	free(p);
}
//按位置查找
bool find_num(LNode *pt,ElemType pos)
{
	LNode *p=pt;
	int count=0;
	if(pos<1 || pos>length(pt))
	{
		return false;
	}
	else
	{
	  while(count!=pos)
	  {
		count++;
		p=p->next;
	  }
	  return true;
	}
}
//按值查找
bool find_digit(LNode *pt,ElemType x)
{
	LNode *p=pt->next;
	int i=1;
	while(i<=length(pt))
	{
	   if(p->data==x)
	   {
	       return true;
	   }
	   i++;
	   p=p->next;
	}
	return false;
}
//在pos位置插入x
bool insert(LNode *pt,ElemType pos,ElemType x)
{
	int i=0;
	LNode *p=pt;
	LNode *q=Buynode();	
	if(pos<1 || pos>length(pt)+1)
	{
		return false;
	}
	else
	{
	  while(i<pos-1)
	  {
		i++;
		p=p->next;
	  }
	q->data=x;
	q->next=p->next;
	p->next=q;
	return true;
	}
}
//按位置删除
bool  remove_num(LNode *pt,ElemType pos)
{
	LNode *p=pt->next;
	int i=1;
	LNode *q=p;
	if(!find_num(pt,pos))
	{
		return false;
	}
	while(i<pos-1)
	{
		i++;
		p=p->next;
		q=p;
	}
	p=p->next;
	q->next=p->next;
	free(p);
	return true;
}
//按值删除
bool remove_digit(LNode *pt,ElemType x)
{ 
	LNode *q=pt;
	LNode *p=q->next;
	if(!find_digit(pt,x))
	{
		return false;
	}
	while(p->data!=x)
	{   q=p;
		p=p->next;
	}
	q->next=p->next;
	free(p);
	return true;
}
//删除值为x的所有数字
bool removeall(LNode *pt,ElemType x)
{
	LNode *q=pt;
	LNode *p=q->next;
	if(!find_digit(pt,x))
	{
		
		return false;
	}
	   while(p!=NULL)
	   {  
		  if(p->data==x)
		   {    
			   q->next=p->next;
			   free(p);
			   p=q->next;  
		    }
		  else
		  {
		    q=p;
		    p=p->next; 
		  }         
	   }
	   return true;
}
/*void sort(LNode *pt)
{
	LNode *p=pt->next;
	LNode *q=p;
	if(isempty(pt))
	{
		cout<<"list is empty"<<endl;
	}
	else
	{
	  for(p;p->next!=NULL;p=p->next)
	  {
		for(q;q->next!=NULL;q=q->next)
		{
			if((q->data)>((q->next)->data))
			{
				LNode *s=q->next->next;
				q->next->next=q;
				q->next=s;
			}
		}
	  }
	}
}*/
//逆置的第一种方法
void reverse1(LNode *pt)
{
	LNode *s=pt;
	LNode *p=pt;
	LNode *q=pt->next;
	if(!isempty(pt))
	{
	   while(p->next!=NULL)
	   {
		   p=p->next;
	   }
	     pt->next=q->next;
		 p->next=q;
		 q->next=NULL;
		 s=q;
		 q=pt->next;
	   for(int i=1;i<length(pt)-1;i++)
	   {
	      pt->next=q->next;
		  p->next=q; 
		  q->next=s;
		  s=q;
		  q=pt->next;
	   }
	}
	else
	{
		cout<<"list is empty,cannot reverse"<<endl;
	}
}
//逆置
void reverse2(LNode *pt)
{
	LNode *s=pt;
	LNode *p=pt;
	LNode *q=pt->next;
	if(!isempty(pt))
	{
	   while(p->next!=NULL)
	   {
		   p=p->next;
	   }
	   for(int i=1;i<length(pt);i++)
	   {
	         pt->next=q->next;
		     q->next=p->next;
	         p->next=q;
		     s=q;
		     q=pt;
	   }
	}
	else
	{
		cout<<"list is empty,cannot reverse"<<endl;
	}
}
//用递归逆置
void fun_list(LNode *pt)
{
	LNode *p=pt->next;
	if(p!=NULL)
	{
		fun_list(p);
		cout<<p->data<<"  ";
	}
}
//判断是否有环
bool hacircle(LNode *pt)
{
	LNode *p=pt;
	LNode *q=pt;
	//int i=1;
	while(p!=q)
	{
		p=p->next->next;
		q=q->next;
		if(p==NULL)
		{
			return false;
		}
	}
	return true;
}
int main()
{
	int ar[]={12,23,45,56,67,45,78,89,90,100};
	int br[]={110,34,120,18};
	int n=sizeof(ar)/sizeof(ar[0]);
	int m=sizeof(br)/sizeof(br[0]);
	Linklist  head=NULL;
	head=CreateHead();
	for(int i=0;i<n;i++)
	{
		push_front(head,ar[i]);   
	}
	print_list(head);
	cout<<"len="<<length(head)<<endl;
	for(int i=0;i<m;i++)
	{
		push_back(head,br[i]);
	}
	print_list(head);
	cout<<"len="<<length(head)<<endl;
	if(insert(head,7,20)==true)
	{    print_list(head);
		cout<<"len="<<length(head)<<endl;
	}
	if(find_digit(head,20))
	{
		cout<<"digit:find"<<endl;
	}
	else
	{
		cout<<"digit:not find"<<endl;
	}
	if(find_num(head,12))
	{
		cout<<"num:find"<<endl;
	}
	else
	{
		cout<<"num:not find"<<endl;
	}
	remove_digit(head,20);
	print_list(head);
	cout<<"digit:len="<<length(head)<<endl;
	remove_num(head,4);
	print_list(head);
	cout<<"num:len="<<length(head)<<endl;
	fun_list(head);
	cout<<endl;
	pop_front(head);
	print_list(head);
	cout<<"len="<<length(head)<<endl;
	pop_back(head);
	print_list(head);
	cout<<"len="<<length(head)<<endl;
	if(removeall(head,45))
	{
	  print_list(head);
	  cout<<"len="<<length(head)<<endl;
	}
	else
	{
		cout<<"cannot removeall"<<endl;
	}
    reverse1(head);
	print_list(head);
	cout<<"len="<<length(head)<<endl;
	reverse2(head);
	print_list(head);
	cout<<"len="<<length(head)<<endl;
	if(hacircle(head))
	{
		cout<<"it is a circle"<<endl;
	}
	else
	{
		cout<<"it is not a circle"<<endl;
	}
	
	Destorylist(head);
}