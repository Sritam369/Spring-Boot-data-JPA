package seg;

import java.util.Arrays;

public class Test2 {
	 void main() {
		
		String s1 = "egg";
		String s2 = "add";
		boolean flag = true;
		char[] map1 = new char[256];
		char[] map2 = new char[256];
		for(int i=0;i<s1.length();i++) {
			char c1 = s1.charAt(i);
			char c2 = s2.charAt(i);
			if(map1[c1]==0 && map2[c2]==0) {
				map1[c1]=c2;
				map2[c2]=c1;
			}
			else {
				if(map1[c1]!=c2 || map2[c2]!=c1) {
					flag = false;
					break;
				}
			}
		}
		IO.println(flag);
}
}


