package com.binmma.prac;

public class MyObject{
	private int a;
	public MyObject(int A){
		this.a=A;
	}

	@Override
	public int hashCode(){
		return 0;
	};
	@Override
    public String toString() {
        return String.valueOf(a);
    }
}
