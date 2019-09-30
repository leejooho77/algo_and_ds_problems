package com.juho.algo.prac.ds;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is sample class for N-ary Tree
 * 
 * @author Juho Lee
 * @since Sep 30, 2019
 */
public class NTree {

	public int value;
	public List<NTree> children;
	
	public NTree(int value) {
		this.value = value;
		this.children = new ArrayList<>();
	}
	
}
