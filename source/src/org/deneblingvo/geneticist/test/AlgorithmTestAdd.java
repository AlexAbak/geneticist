package org.deneblingvo.geneticist.test;

public class AlgorithmTestAdd implements IAlgorithmTestAdd {

	private int v1;

	private int v2;

	private int v3;

	public void set(int v1, int v2) {
		this.v1 = v1;
		this.v2 = v2;
	}

	public int get() {
		return this.v3;
	}

	public void test() {
v3 = (v1 + v2);

	}

}
