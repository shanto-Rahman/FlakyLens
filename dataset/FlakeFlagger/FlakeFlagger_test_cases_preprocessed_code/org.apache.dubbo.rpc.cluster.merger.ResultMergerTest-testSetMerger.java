/** 
 * SetMerger test
 * @throws Exception
 */
@Test public void testSetMerger() throws Exception {
Assert.assertEquals(4,result.size());
Assert.assertEquals(new HashSet<String>(){
{
    add(null);
    add("1");
    add("2");
    add("3");
  }
}
,result);
}