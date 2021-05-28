/*
 ============================================================================
 Name        : list.h
 Author      : Anderson Moreira
 E-mail		 : anderson.moreira@recife.ifpe.edu.br
 Version     : 13/06/2012
 Copyright   :
 Description : implementação das funções de uma lista de inteiros
 ============================================================================
 */

#include <stdlib.h>
#include <stdio.h>
#include "list.h"


list_t* lst_new()
{
	list_t *list;
	list = (list_t*) malloc(sizeof(list_t));
	list->first = NULL;
	return list;
}


void lst_destroy(list_t *list)
{
	free(list); //Libera o espaço na memória da Lista
	printf("lst_destroy\n");
}


void lst_insert(list_t *list, int value)
{
	if(list->first==NULL) //Se for o primeiro valor
	{
		struct lst_iitem *newValue; //Novo valor do tipo node

		newValue = malloc (sizeof (struct lst_iitem));

		newValue->value = value; 

		newValue->next = NULL;

		list->first = newValue; //O primeiro vai ser esse node
	}
	else
	{
		struct lst_iitem *newValue;
		struct lst_iitem *temp;

		newValue = malloc (sizeof (struct lst_iitem));
		temp = malloc (sizeof (struct lst_iitem));

		newValue->value = value;
		newValue->next = NULL;

		temp = list->first;
		while(temp->next!=NULL)
		{
			temp = temp->next;
		}
		temp->next = newValue;
	}
	printf("lst_insert: value=%d\n", value);
}


void lst_remove(list_t *list, int value)
{
	struct lst_iitem *p, *q;
	p = list->first;
	q = (list->first)->next;

	if(p->value == value)
	{
		list->first=q;
		free(p);
	}

	if(list->first!=NULL)
	{
		while(q!=NULL && q->value != value)
		{
			p = q;
			q = q->next;
		}
		
		if(q!=NULL)
		{
			p->next = q->next;
			free(q);
		}

	}

	printf("lst_remove: value=%d\n", value);
}


void lst_print(list_t *list)
{
	printf("lst_print:\n");

	struct lst_iitem *print;

	for(print=list->first; print!=NULL; print = print->next)
	{
		if(print==list->first)
			printf("%d", print->value);
		else
			printf(", %d", print->value);
		
	}
	printf("\n");
}
