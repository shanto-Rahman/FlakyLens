/** 
 * 查询全部
 */
@Test public void testDynamicSelectPage2(){
Assert.assertEquals(183,countryList.size());
Assert.assertEquals(183,(int)countryList.get(0).getId());
}