/** 
 * 继承类可以使用,但多出来的属性无效
 */
@Test public void testDynamicSelectNotFoundKeyProperties(){
  SqlSession sqlSession=MybatisHelper.getSqlSession();
  try {
    CountryMapper mapper=sqlSession.getMapper(CountryMapper.class);
    Assert.assertEquals(183,mapper.select(new Key()).size());
    Key key=new Key();
    key.setCountrycode("CN");
    key.setCountrytel("+86");
    Assert.assertEquals(1,mapper.select(key).size());
  }
  finally {
    sqlSession.close();
  }
}
