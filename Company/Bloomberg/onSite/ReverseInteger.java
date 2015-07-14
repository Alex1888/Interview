package onsite;

public class ReverseInteger {
	public int reverse(int x) {
        int abs = Math.abs(x);
        int ret = 0;
        while(abs > 0){
            if(ret > (Integer.MAX_VALUE - abs % 10)/10){
                return 0;
            }
            ret = ret*10 + abs%10;
            abs /= 10;
        }
        return x < 0 ? -ret : ret;
    }
}
