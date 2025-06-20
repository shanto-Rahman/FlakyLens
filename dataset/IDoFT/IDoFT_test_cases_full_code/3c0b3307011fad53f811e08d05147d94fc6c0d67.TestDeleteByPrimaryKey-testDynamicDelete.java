/** 
 * 主要测试删除
 */
@Test public void testDynamicDelete(){
  SqlSession sqlSession=MybatisHelper.getSqlSession();
  try {
    CountryMapper mapper=sqlSession.getMapper(CountryMapper.class);
    Assert.assertEquals(183,mapper.selectCount(new Country()));
    Country country=mapper.selectByPrimaryKey(100);
    Assert.assertEquals(1,mapper.deleteByPrimaryKey(100));
    Assert.assertEquals(182,mapper.selectCount(new Country()));
    Assert.assertEquals(1,mapper.insert(country));
  }
  finally {
    sqlSession.close();
  }
}
