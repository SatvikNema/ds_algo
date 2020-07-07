import java.util.Scanner;
class primesBoi{
	static boolean[] prime;
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int m;
		for(int j=0;j<t;j++){
			// n = sc.nextInt();
			m = sc.nextInt();
			genPrimes(m);
		}
		
	}
	public static void genPrimes(int m){
		prime = new boolean[m+1];
		prime[0] = true;
		prime[1] = true;
		for(int i=2;i<=m;i++){
			if(!prime[i]){
				cancelPrimes(i, m);
			}
		}
		for(int i=0;i<m;i++){
			if(!prime[i]){
				System.out.print(i+" ");
			}
		}
	}
	public static void cancelPrimes(int l, int m){
		for(int i = l*l;i<=m;i+=l){
			prime[i] = true;
		}
	}
}