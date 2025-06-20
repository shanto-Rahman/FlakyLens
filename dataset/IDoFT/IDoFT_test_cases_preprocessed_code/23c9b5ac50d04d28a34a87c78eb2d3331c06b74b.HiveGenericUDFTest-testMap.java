@Test public void testMap(){
assertEquals(new HashMap<String,String>(){
{
    put("1","1");
    put("2","2");
    put("3","3");
  }
}
,udf.eval(testInput));
assertEquals(3,result.length);
assertEquals("1",result[0]);
assertEquals("2",result[1]);
assertEquals("3",result[2]);
}