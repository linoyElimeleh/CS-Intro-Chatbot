/** This class is used in order to find URLs in HTML source code. */
public class FindURLs {
	public static void main(String args[]) {
		String data = "<html><head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=windows-1252\"><title>Computer Science Articles\n" + 
				"</title>\n" + 
				"\n" + 
				"</head><body>\n" + 
				"<br>\n" + 
				"<h2>  Computer Science Articles and items</h2>\n" + 
				"<li> <a href=\"http://www.informationweek.com/hardware/desktop/turings-universal-machine-voted-top-brit/240151643\">\n" + 
				"Turing's Universal Machine Voted Top British Innovation  </a> -\n" + 
				"  Information Week March 25, 2013</li>\n<li> <a href=\"https://www.youtube.com/watch?v=XwIs1nlDQ2I&amp;feature=g-u-u\">\n" + 
				"green bean matherole </a>\n" + 
				" </li>" + 
				"<li> \n" + 
				"<a href=\"http://www.Youtube.com/watch?v=sdzjcBhrgp0&amp;feature=youtu.be\">\n" + 
				"STEM: The choice is yours </a> - SAS video 2012 for MS students.\n" + 
				"</li>\n" + 
				"<li> <a href=\"http://online.wsj.com/article/SB10001424053111903480904576512250915629460.html\">\n" + 
				"Why Software is eating the world \n" + 
				"  </a> - Wall Street Journal, Aug 20, 2011</li>\n" + 
				"<li> <a href=\"http://www.newscientist.com/article/dn20791-robot-mission-impossible-wins-video-prize.html\">\n" + 
				"Robot \"Mission Impossible\" Wins Robot video prize  </a> - New Scientist -\n" + 
				"	      Aug 12, 2011</li>\n" + 
				"<li> <a href=\"http://en.wikipedia.org/wiki/Bob_%28song%29\">\n" + 
				"Wierd Al Yankovic - song Bob is all palindromes - about Bob Dylan  </a></li><li> <a href=\"http://www.YouTube.com/watch?v=oPRfDC8kTqM\"> Women the\n" + 
				"    programmers of tomorrow.\n" + 
				"  </a> - Miami Springs High School video about girls taking computing -\n" + 
				"  June 10, 2013</li>\n" + 
				"<li> <a href=\"http://www.zdnet.com/blog/burnette/oracle-rebrands-java-breaks-eclipse/2012\">\n" + 
				"Java 1.6.0_21 company field changed from Sun to Oracle breaks  applications</a></li>\n" + 
				"<li> <a href=\"http://www.siam.org/careers/matters.php\">\n" + 
				"SIAM Math Matters posters  </a></li>\n" + 
				"</ul>\n" + 
				"\n" + 
				" \n" + 
				"</body></html>";
			
			System.out.println("HTML source code:");
			System.out.println("-----------------------------------------------------------------");
    	    System.out.println(data);
			System.out.println("-----------------------------------------------------------------");
    	    System.out.println("");
    	    System.out.println("First youtube url:");
    	    findFirstYoutubeURL(data);
    	    System.out.println("");
    	    System.out.println("All youtube urls:");
    	    findAllYoutubeURLs(data);
	}
	
	/** Prints the first Youtube URL that appears in the given HTML code.
	 * A Youtube URL begins with the string "\"http", continues with one or
	 * more characters, then comes the string "youtube.com", then come one
	 * or more characters, then comes the string "\"".
	 * For example: "https://www.youtube.com/watch?v=iE7YRHxwoDs".
	 * Note that "youtube" can appear in different lower-case or upper-case
	 * letters like "youtube", "Youtube", "YouTube", and so on...
	 */
	public static void findFirstYoutubeURL(String html) {
		String lower = html.toLowerCase();
		boolean found = false;
		while (!found) {
			int beginIndex = lower.indexOf("\"http");
			//System.out.println(beginIndex);
			int endIndex = lower.indexOf('\"', beginIndex + 1);
			//System.out.println(endIndex);
			String url = lower.substring(beginIndex + 1, endIndex);
			if (url.indexOf("youtube.com") != -1) {
				System.out.println(url);
				found = true;
			}
			lower = lower.substring(endIndex + 1);
		}
	}
	
	/** Prints all the Youtube URLs that appear in the given HTML code.
	 */
	public static void findAllYoutubeURLs(String html) {
		String lower = html.toLowerCase();
		while (lower.indexOf("youtube.com") != -1) {
			int beginIndex = lower.indexOf("\"http");
			int endIndex = lower.indexOf('\"', beginIndex + 1);
			String url = lower.substring(beginIndex + 1, endIndex);
			if (url.indexOf("youtube.com") != -1) {
				System.out.println(url);
			}
			lower = lower.substring(endIndex + 1);
		}
	}
}