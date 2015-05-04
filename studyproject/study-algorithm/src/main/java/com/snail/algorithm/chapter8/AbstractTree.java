package com.snail.algorithm.chapter8;

import com.snail.algorithm.chapter7.Position;

public abstract class AbstractTree<E> implements Tree<E> {
	public boolean isInternal(Position<E> p){return numChildren(p)>0;}
	public boolean isExternal(Position<E> p){return numChildren(p)==0;}
	public boolean isRoot(Position<E> p){return p==root();}
	public boolean isEmpty(){return size()==0;}
}
