/*
This workshop file was written by Avraham Shalev (avraham.shalev@post.idc.ac.il)

GENERAL NOTE (for instructors) about comments in this file:
-------------------------------------------------------------------------------------------------------------------
I wrote several types of comments:
1."//":										output comment
2."///":									commented code
2.more slashes (e.g. "////////":			this comment is followed by a previous comment
3."//DISCUSS:":								intended for you to discuss with students
4."//DISCUSS?:":							intended for you to optionally discuss with students (if time permits, advanced students, etc ..)
5."//ONLY4U:":								intended for you only. not need to discuss with students
-------------------------------------------------------------------------------------------------------------------
*/

class Workshop4 {
	public static void main(String args[]) {
		System.out.println("");//ONLY4U:a blank line before output is usually more eye-friendly in the console

		///stringsReminder();
		///stringsWarmup();
		
		// testSubstring();
		
		///genesEx();
    }
	

	
	public static void stringsReminder() {
		String s = "I think I'm unique. I'm pretty sure. Woho!!";
		System.out.println("s:" + s);//s:I think I'm unique. I'm pretty sure. Woho!!
		System.out.println("s.length():" + s.length());//s.length():43
		System.out.println("s.charAt(6):" + s.charAt(6));//s.charAt(6):k
		
		System.out.println("s.indexOf('W'):" + s.indexOf('W'));//s.indexOf('W'):37
		//DISCUSS: s.indexOf('w') != s.indexOf('W').explain why.
		System.out.println("s.indexOf('w'):" + s.indexOf('w'));//s.indexOf('w'):-1
		
		//DISCUSS: note that string is like array of chars, the index starts from 0 and not 1
		//DISCUSS: note that we have several 'I' in this example.explain why we got index=0 (first occurrence)
		int firstIndex = s.indexOf('I');
		System.out.println("s.indexOf('I'):" + firstIndex);//s.indexOf('I'):0
		//DISCUSS: note that the starting index to start from is included, so we add +1
		int nextIndex = s.indexOf('I', firstIndex + 1);
		System.out.println("s.indexOf('I', 1):" + nextIndex);//s.indexOf('I', 1):8
		
		//DISCUSS: note that indexOf() can get strings
		////////// the returned index is the first char of the string!
		int firstStrIndex = s.indexOf("I'm");
		System.out.println("s.indexOf(\"I'm\"):" + firstStrIndex);//s.indexOf("I'm"):8
		
		//DISCUSS?: note that the starting index to start from is included as before, so we add +3
		int nextStrIndex = s.indexOf("I'm", firstStrIndex + 3);
		System.out.println("s.indexOf(\"I'm\", 3):" + nextStrIndex);//s.indexOf("I'm", 3):20
		
		//DISCUSS: note that without end index function returns untill end of string
		//DISCUSS?: note that even though we used 9 as the in substring(9) and in substring(6,9) every function behaves differently
		/////////// (in substring(9) it includes charAt(9) while in substring(6,9) it doesn't!!!)
		//DISCUSS?: edge cases: what happens when index is negative? or when it overcomes the string bounds? ...
		System.out.println("s.substring(9):" + s.substring(9));//s.substring(9):'m unique. I'm pretty sure. Woho!!
		System.out.println("s.substring(6,9):" + s.substring(6,9));//s.substring(6,9):k I
	}
	

	
	public static void stringsWarmup() {
		String s = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		System.out.println("s:" + s);	
		
		int start = s.indexOf('E');
		int end = s.indexOf('T');
		String result = s.substring(start, end + 1);
		System.out.println("result:" + result);
	}


	
	public static void testSubstring() {
		String s1 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String s2 = "GCDEFGHI";//ONLY4U: in s2, there is a 'G' before and after 'D'. we want the second to be considered
		System.out.println("s1:" + s1);
		System.out.println("s2:" + s2);
		
		char start = 'D';
		char end = 'G';
		
		//DISCUSS: those {first,last} vars are different from those in function substring! names are same but scope is very important!
		String result1 = substring(s1, start, end);
		String result2 = substring(s2, start, end); 
		System.out.println("result1:" + result1);
		System.out.println("result2:" + result2);
	}
	
	//ONLY4U: This method retrieves substring between [start-end] (including both, first occurrences).
	///////// If (startIdx == -1) OR (endIdx == -1) OR (endIdx<startIdx) returns ""
	//DISCUSS?: In general, you can think of edge-cases (this is not the target in this stage): char start = char end, bounderies checks, ..
	public static String substring(String s, char start, char end){
		String result = "";
		int startIndex = s.indexOf(start);
		int endIndex = s.indexOf(end, startIndex + 1); //ONLY4U: "startIndex+1" is dangerous and needs bounderies checks
		
		if((startIndex > -1) && (endIndex > -1) && (startIndex < endIndex)) {
			result = s.substring(startIndex, endIndex + 1);
		}
		
		return result;
	}
	
	
	
	//ONLY4U: This method should be called each time with another "findGene" method.
	///////// those methods gradually attempt to find genes inside a DNA strand.
	public static void genesEx() {
		//ONLY4U: valid example
		String dna1 = "GGTCCGATGCCTGGGCTCTAGGAAA";
		//ONLY4U: same as dna1 except first "TAG" is not divided by 3 (i removed the 'C' before it and added+changed letters after). second "TAG" is valid
		String dna2 = "GGTCCGATGCCTGGGCTTAGGTAGA";
		//ONLY4U: This is dna1 * 2 in order to test search of 2 genes
		String dna3 = "GGTCCGATGCCTGGGCTCTAGGAAAGGTCCGATGCCTGGGCTCTAGGAAA";
		//ONLY4U: This is dna1 * 4 in order to test search of multiple genes with loop
		String dna4 = "GGTCCGATGCCTGGGCTCTAGGAAAGGTCCGATGCCTGGGCTCTAGGAAAGGTCCGATGCCTGGGCTCTAGGAAAGGTCCGATGCCTGGGCTCTAGGAAA";
		
		System.out.println("dna1:" + dna1);
		System.out.println("dna2:" + dna2);
		System.out.println("dna3:" + dna3);
		System.out.println("dna4:" + dna4);
		
		String result1 = findGene(dna1);
		String result2 = findGene(dna2);
		String result3 = findGene(dna3);
		String result4 = findGene(dna4);
		
		System.out.println("result1:" + result1);
		System.out.println("result2:" + result2);
		System.out.println("result3:" + result3);
		System.out.println("result4:" + result4);
	}
	
	public static String findGene(String dna) {
		return findGene1(dna);
		///return findGene2(dna);
		///return findGene3(dna);
		///return findGene4(dna);
		
		///return findTwoGenes(dna);
		///return findGenes(dna);
	}
	
	//DISCUSS: function does not check gene is valid (length check - divided by 3 - is missing!!!). improve please
	public static String findGene1(String dna) {
		int start = dna.indexOf("ATG");
		if (start == -1) {
			return "";
		}
		int end = dna.indexOf("TAG", start + 3);
		if (end == -1) {
			return "";
		}
		return dna.substring(start, end + 3);
	}

	//DISCUSS: function does not handle case where more "TAG" codons are after the first-found. maybe one of them suits? improve please
	public static String findGene2(String dna) {
		int start = dna.indexOf("ATG");
		if (start == -1) {
			return "";
		}
		int end = dna.indexOf("TAG", start + 3);
		if (end == -1) {
			return "";
		}
		if( (end - start) % 3 != 0) {
			return "";
		}
		
		return dna.substring(start, end + 3);
	}
	
	//DISCUSS: while loop can be exported to another function ("int getSuitableEndingCodonIndex(String dna, int startCodonIndex)")
	public static String findGene3(String dna) {
		int start = dna.indexOf("ATG");
		if (start == -1) {
			return "";
		}
		
		//DISCUSS: explain students that from here, code should be exported to different function - it has a specific target
		int end = dna.indexOf("TAG", start + 3);
		while( end != -1) {
			if( (end - start) % 3 == 0) {
				break;
			}
			else {
				end = dna.indexOf("TAG", end + 3);
			}
		}
		//DISCUSS: end of code that should be exported to another function
		
		if (end == -1) {
			return "";
		}
		
		return dna.substring(start, end + 3);
	}
	
	//DISCUSS?: This function does not handle case where more "ATG" codons are after the first-found.
	//ONLY4U: but stay with this function as good-enough for finding a gene if it exists in the dna strain.
	///////// it will help us with later methods..
	public static String findGene4(String dna) {
		int start = dna.indexOf("ATG");
		if (start == -1) {
			return "";
		}
		
		int end = getSuiatableEndingCodonIndex(dna, start);
		if (end == -1) {
			return "";
		}
		
		return dna.substring(start, end + 3);
	}
	
	//DISCUSS: This function gets the next Ending-codon ("TAG") index that suits (%3==0) the startCodonIndex
	public static int getSuiatableEndingCodonIndex(String dna, int startCodonIndex) {
		int endCodonIndex = startCodonIndex;
		do {
			endCodonIndex = dna.indexOf("TAG", endCodonIndex + 3);
			if( (endCodonIndex - startCodonIndex) % 3 == 0) {
				return endCodonIndex;
			}
		} while( endCodonIndex != -1);
		
		return -1;
	}
	
	//DISCUSS: This function returns 2 genes in one string with "___" seperator
	//DISCUSS: This function does it only for 2 genes. what with 10? 100? 1000000? + DUPLICATING CODE IS BAD!!!!! please use loops
	public static String findTwoGenes(String dna) {
		String firstGene = findGene4(dna);
		if(firstGene.equals("")) {
			return "";
		}
		String retval = firstGene;
		
		int firstGeneLength = firstGene.length();
		int firstGeneIdx = dna.indexOf(firstGene);//ONLY4U: VERY not efficient.should be returned somehow before. but for now it's fine
		
		String dnaLeftover = dna.substring(firstGeneIdx + firstGeneLength);//returns the leftover of the dna
		String secondGene = findGene4(dnaLeftover);
		if(!secondGene.equals("")) {
			retval += "___" + secondGene;
		}
		
		return retval;
	}
	
	//ONLY4U: This is the final method to find all genes - with loop ofcourse
	///////// it's still VERY not efficient. but for now it's fine
	public static String findGenes(String dna) {
		String retval = "";
		String gene = "";
		String dnaLeftover = dna;
		
		do {
			gene = findGene4(dnaLeftover);
			int geneLength = gene.length();
			if(geneLength > 0) {
				int geneIdx = dnaLeftover.indexOf(gene);
				dnaLeftover = dnaLeftover.substring(geneIdx + geneLength);
				
				//ONLY4U: need to remember to get rid of the last "___" in the end
				///////// "___" should be reffered as a constant (e.g. named SEPERATOR)
				retval += gene + "___"; 
			}
		} while(!gene.equals(""));
		
		//DISCUSS?: Get rid of the extra "___" in the end.
		//ONLY4U: this is not a best practice, should be: retval.length() - SEPERATOR.length()
		///////// this SEPERATOR can change in the future and no one know he should change this 3 to it's new length...
		retval = retval.substring(0, retval.length() - 3);
		return retval;
	}
}