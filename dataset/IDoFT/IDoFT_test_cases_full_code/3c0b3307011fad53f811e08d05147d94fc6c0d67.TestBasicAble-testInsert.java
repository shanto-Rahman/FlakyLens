/** 
 * 新增
 */
@Test public void testInsert(){
  SqlSession sqlSession=MybatisHelper.getSqlSession();
  try {
    UserInfoAbleMapper mapper=sqlSession.getMapper(UserInfoAbleMapper.class);
    UserInfoAble userInfo=new UserInfoAble();
    userInfo.setUsername("abel533");
    userInfo.setPassword("123456");
    userInfo.setUsertype("2");
    userInfo.setEmail("abel533@gmail.com");
    Assert.assertEquals(1,mapper.insert(userInfo));
    Assert.assertNotNull(userInfo.getId());
    Assert.assertEquals(6,(int)userInfo.getId());
    userInfo=mapper.selectByPrimaryKey(userInfo.getId());
    Assert.assertNull(userInfo.getEmail());
  }
  finally {
    sqlSession.rollback();
    sqlSession.close();
  }
}
