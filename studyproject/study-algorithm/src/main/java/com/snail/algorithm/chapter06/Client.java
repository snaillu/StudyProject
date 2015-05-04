package com.snail.algorithm.chapter06;

public class Client {
	public static void main(String[] args) {
//		Stack<Integer> s = new ArrayStack<Integer>();
//		s.push(5);
//		s.push(3);
//		System.out.println(s.size());
//		System.out.println(s.pop());
//		System.out.println(s.isEmpty());
//		System.out.println(s.pop());
//		System.out.println(s.isEmpty());
//		System.out.println(s.pop());
//		s.push(7);
		
		String html = "<div><p>This is a tag.</p></div>";
		boolean result = isHTMLMatched(html);
		System.out.println("result="+result);
	}
	
	public static boolean isHTMLMatched(String html){
		Stack<String> buffer = new LinkedStack<String>();
		int j = html.indexOf("<");
		while(j!=-1){
			int k = html.indexOf(">",j+1);
			if(k==-1)
				return false;
			String tag = html.substring(j+1,k);
			if(!tag.startsWith("/"))
				buffer.push(tag);
			else{
				if(buffer.isEmpty())
					return false;
				if(!tag.substring(1).equals(buffer.pop()))
					return false;
			}
			j = html.indexOf("<",k+1);
		}
		
		return buffer.isEmpty();
	}
}
