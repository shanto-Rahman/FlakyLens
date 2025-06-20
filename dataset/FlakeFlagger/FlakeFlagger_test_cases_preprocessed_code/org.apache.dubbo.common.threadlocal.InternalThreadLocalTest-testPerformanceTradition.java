/** 
 * print take[2689]ms <p></p> This test is based on a Machine with 4 core and 16g memory.
 */
@Test public void testPerformanceTradition(){
final Thread mainThread=Thread.currentThread();
caches1[i].set("float.lu");
caches1[i].get();
System.out.println("take[" + TimeUnit.NANOSECONDS.toMillis(end - start) + "]ms");
LockSupport.unpark(mainThread);
t1.start();
LockSupport.park(mainThread);
}