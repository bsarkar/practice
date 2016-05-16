package home.generictests;

// Bettter apprach
public class SingletonExample {

	  private static Object lock = new Object();
	  private static SingletonExample instance;
	 // First approach is as follow
	  
	  public static SingletonExample get_instance1()  // not synchronized
	  {   synchronized( lock )
	      {   if( instance == null )
	              instance =  new SingletonExample();
	          return instance;
	      }
	  }
	  
	  /*
	   The avove apprach is not that good as every call gets a lock even if the instance exits. 
	   Most of the time the instance will actually exists but the code will still lock the lockObject. 
	   Doug Lee has proposed a better double check process where it locks only if no instance and check 
	   again to make sure it wasn't created after the previous check
	   */
	  public static SingletonExample get_instance2()  // not synchronized
	    {   if( instance == null )
	        {   synchronized(  lock)
	            {   if( instance == null )
	                    instance =  new SingletonExample();
	            }
	        }
	        return instance;
	    }
}
