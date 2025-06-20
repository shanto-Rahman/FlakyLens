/** 
 * print take[14]ms <p></p> This test is based on a Machine with 4 core and 16g memory.
 */
@Test public void testPerformance(){
final Thread mainThread=Thread.currentThread();
System.out.println("take[" + TimeUnit.NANOSECONDS.toMillis(end - start) + "]ms");
LockSupport.unpark(mainThread);
t.start();
LockSupport.park(mainThread);
}