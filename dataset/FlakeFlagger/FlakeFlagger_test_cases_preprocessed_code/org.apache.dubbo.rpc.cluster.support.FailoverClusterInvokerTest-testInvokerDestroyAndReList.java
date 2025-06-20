/** 
 * When invokers in directory changes after a failed request but just before a retry effort, then we should reselect from the latest invokers before retry.
 */
@Test public void testInvokerDestroyAndReList(){
invoker1.setCallable(callable);//IT
invoker2.setCallable(callable);//IT
}