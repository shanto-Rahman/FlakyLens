/** 
 * Validate fix for ACT-1896
 */
public void testQueryByActivityIdAndBusinessKeyWithChildren(){
assertEquals(1,query.list().size());
assertEquals(1,query.count());
assertNotNull(execution);
assertEquals("receivePayment",execution.getActivityId());
}