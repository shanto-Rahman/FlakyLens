@Test public void testSelectByExampleInNotIn(){
  SqlSession sqlSession=MybatisHelper.getSqlSession();
  try {
    CountryMapper mapper=sqlSession.getMapper(CountryMapper.class);
    Example example=new Example(Country.class);
    Set<Integer> set=new HashSet<Integer>();
    set.addAll(Arrays.asList(new Integer[]{1,2,3,4,5,6,7,8,9,10,11}));
    example.createCriteria().andIn("id",set).andNotIn("id",Arrays.asList(new Object[]{11}));
    List<Country> countries=mapper.selectByExample(example);
    Assert.assertEquals(10,countries.size());
  }
  finally {
    sqlSession.close();
  }
}
