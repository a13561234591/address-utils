package com.payegis.common;

import lombok.ToString;

@ToString
public class Tuple<L, R> {

	private L left;
	private R right;

	public Tuple() {

	}

	public Tuple(L left, R right) {
		this.left = left;
		this.right = right;
	}

	public void setLeft(L left) {
		this.left = left;
	}

	public L getLeft() {
		return this.left;
	}

	public void setRight(R right) {
		this.right = right;
	}

	public R getRight() {
		return this.right;
	}

}
