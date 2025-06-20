/** 
 * WFLY-7797 
 */
@Test public void testPoolSizeAlternatives() throws Exception {
Assert.assertTrue("Subsystem boot failed!",ks.isSuccessfulBoot());
Assert.assertEquals(response.toString(),"success",response.get("outcome").asString());
}