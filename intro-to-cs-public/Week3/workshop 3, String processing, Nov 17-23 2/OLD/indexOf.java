
	
////implement indexOf several times, ...
	public static void functionEx() {
		String s = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		System.out.println("s:" + s);	
		
		int start = indexOf(s,'E');
		int end = indexOf(s,'T');
		String result = s.substring(start, end + 1);
		System.out.println("result:" + result);
	}


	//show functions 1 to 7, and explain each one
	public static int indexOf(String s, char c) {
		return indexOf1(s,c);
	}
	
	
	//not good since method return 0 when not found
	//not good since method returns the last occurrence of c, not the first!
	public static int indexOf1(String s, char c) {
		int index = 0;
		int i=0;
		while (i<s.length()) {
			if(s.charAt(i) == c) {
				index=i;
			}
			i++;
		}
		return index;
	}

	
	//good .. but:
	//while is less suitable here than for! with for(A;B;C) this function will be easier to understand
	public static int indexOf2(String s, char c) {
		boolean found = false;
		int index = -1;
		int i=0;//A
		while(i<s.length()) {//B
			if(found==false && s.charAt(i) == c) {
				index=i;
				found=true;
			}
			i++;//C
		}
		return index;
	}
	
	
	//good .. but:
	//method uses unneeded vars and function is longer than it suppose to be
	public static int indexOf3(String s, char c) {
		boolean found = false;
		int index = -1;
		for (int i=0;i<s.length();i++) {
			if(found==false && s.charAt(i) == c) {
				index=i;
				found=true;
			}
		}
		return index;
	}
	
	
	//good .. but:
	//method keep searching after it finds the first occurrence!
	public static int indexOf4(String s, char c) {
		int index = -1;
		for (int i=0;i<s.length();i++) {
			if(index==-1 && s.charAt(i) == c) {
				index=i;
			}
		}
		return index;
	}
	
	
	//good .. but:
	//not good since method does nothing with index var and its kind of confusing
	public static int indexOf5(String s, char c) {
		int index = -1;
		for (int i=0;i<s.length();i++) {
			if(s.charAt(i) == c) {
				return i;
			}
		}
		return index;
	}


	//good .. but:
	//not that good since method have multiple locations with "return" (exit points). in complex algorithms it usually makes debugging harder
	public static int indexOf6(String s, char c) {
		for (int i=0;i<s.length();i++) {
			if(s.charAt(i) == c) {
				return i;
			}
		}
		return -1;
	}
	
	//good
	public static int indexOf7(String s, char c) {
		int index = -1;
		for (int i=0;i<s.length();i++) {
			if(s.charAt(i) == c) {
				index = i;
				break;
			}
		}
		return index;
	}