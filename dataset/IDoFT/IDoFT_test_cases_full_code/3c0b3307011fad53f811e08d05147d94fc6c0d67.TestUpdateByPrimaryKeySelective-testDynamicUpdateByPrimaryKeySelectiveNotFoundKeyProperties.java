/** 
 * 继承类可以使用,但多出来的属性无效
 */
@Test public void testDynamicUpdateByPrimaryKeySelectiveNotFoundKeyProperties(){
  SqlSession sqlSession=MybatisHelper.getSqlSession();
  try {
    CountryMapper mapper=sqlSession.getMapper(CountryMapper.class);
    Key key=new Key();
    key.setId(173);
    key.setCountrycode("CN");
    key.setCountrytel("+86");
    Assert.assertEquals(1,mapper.updateByPrimaryKeySelective(key));
  }
  finally {
    sqlSession.close();
  }
}
