/** 
 * for example, it will print like this: before a future is create , time is : 2018-06-21 15:11:31 after a future is timeout , time is : 2018-06-21 15:11:36 <p> The exception info print like: Waiting server-side response timeout by scan timer. start time: 2018-06-21 15:12:38.337, end time: 2018-06-21 15:12:43.354...
 */
@Test public void timeoutSend() throws Exception {
Thread.sleep(100);
Assert.assertTrue("catch exception is not timeout exception!",e instanceof TimeoutException);
}