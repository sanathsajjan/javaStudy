package com.java.practice.objects;

public class SampleResource {
	private int sampleVariable;

	public int getSampleVariable() {
		return sampleVariable;
	}

	public SampleResource(int sampleVariable) {
		super();
		this.sampleVariable = sampleVariable;
	}

	public void setSampleVariable(int sampleVariable) {
		this.sampleVariable = sampleVariable;
	}

	public void doSomething() {
		sampleVariable += 1;
		System.out.println("ThreadName:" + Thread.currentThread().getName() + "samplevariable:" + sampleVariable);
	}

}
