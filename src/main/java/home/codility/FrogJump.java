package home.codility;

public class FrogJump {

	// FrogJump
	public int solution(int x , int y , int z) throws Exception {
		if ( y < x || z <= 0) throw new Exception("AAA");
		if ( (y - x) / z == 0 ) return (y -x ) / z ;
		else
			return (y - x ) / z + 1 ;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// FrogJump
    	int result=0;
    	try {
        result = new FrogJump().solution( 7 , 2 , 2) ;
    	} catch ( Exception e) { }
        
    	System.out.println(result);
     }

}
