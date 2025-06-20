/** 
 * Proves that inspector works only with model snapshot and does not reflect model changes performed after inspector is constructed.
 */
@Test public void shouldReturnSameResultAfterModelChange(){
assertEquals(0,victim.getAllUniqueResources().size());
assertEquals(0,victim.getAllUniqueResources().size());
assertEquals(1,new WroModelInspector(model).getAllUniqueResources().size());
assertEquals(2,new WroModelInspector(model).getAllResources().size());
}