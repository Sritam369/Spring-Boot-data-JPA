package seg;

public class Test{

void main() {
	int a = 10234;
	int k = 0;int r=0;
for(int i=a;i!=0;i/=10) {
	
	if(i%10!=0) {
		r = r*10+(i%10);
	}
	k = k*10+r;
}
IO.println(k);
}
}
