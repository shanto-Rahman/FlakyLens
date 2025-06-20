@Test public void test(){
assertEquals(10,result.one);
assertEquals(20,result.two);
assertEquals(30,result.three);
assertEquals("{one=10, two=20, three=30}",map2.toString());
assertEquals("{one=10, three=30, two=20}",map3.toString());
}