/** 
 * 继承类可以使用,但多出来的属性无效
 */
@Test public void testDynamicUpdateByPrimaryKeyNotFoundKeyProperties(){
  SqlSession sqlSession=MybatisHelper.getSqlSession();
  try {
    CountryMapper mapper=sqlSession.getMapper(CountryMapper.class);
    Assert.assertEquals(0,mapper.updateByPrimaryKey(new Key()));
    Key key=new Key();
    key.setId(174);
    key.setCountrycode("CN");
    key.setCountrytel("+86");
    Assert.assertEquals(1,mapper.updateByPrimaryKey(key));
  }
  finally {
    sqlSession.close();
  }
}
