/** 
 * for example, it will print like this: before a future is create , time is : 2018-06-21 15:06:17 after a future is timeout , time is : 2018-06-21 15:06:22 <p> The exception info print like: Sending request timeout in client-side by scan timer. start time: 2018-06-21 15:13:02.215, end time: 2018-06-21 15:13:07.231...
 */
@Test public void timeoutNotSend() throws Exception {
Thread.sleep(100);
Assert.assertTrue("catch exception is not timeout exception!",e instanceof TimeoutException);
}