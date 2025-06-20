@Test public void testOrderBy(){
  SqlSession sqlSession=MybatisHelper.getSqlSession();
  try {
    CountryMapper mapper=sqlSession.getMapper(CountryMapper.class);
    Example example=Example.builder(Country.class).where(Sqls.custom().andBetween("id",50,55)).orderBy("id").orderByAsc("countryname").orderByDesc("countrycode").build();
    List<Country> countries=mapper.selectByExample(example);
    for (    Country country : countries) {
      System.out.println(country.getId() + " " + country.getCountryname()+ " "+ country.getCountrycode());
    }
    Assert.assertEquals(6,countries.size());
  }
  finally {
    sqlSession.close();
  }
}
