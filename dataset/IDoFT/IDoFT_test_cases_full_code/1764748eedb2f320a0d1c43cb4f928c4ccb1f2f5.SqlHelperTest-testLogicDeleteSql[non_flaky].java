@Test public void testLogicDeleteSql(){
  String wherePKColumns=SqlHelper.wherePKColumns(User.class);
  Assert.assertEquals("<where> AND id = #{id} AND is_valid = 1</where>",wherePKColumns);
  String whereAllIfColumns=SqlHelper.whereAllIfColumns(User.class,false);
  Assert.assertEquals("<where><if test=\"id != null\"> AND id = #{id}</if><if test=\"username != null\"> AND username = #{username}</if> AND is_valid = 1</where>",whereAllIfColumns);
  String isLogicDeletedColumn=SqlHelper.whereLogicDelete(User.class,true);
  Assert.assertEquals(" AND is_valid = 0",isLogicDeletedColumn);
  String notLogicDeletedColumn=SqlHelper.whereLogicDelete(User.class,false);
  Assert.assertEquals(" AND is_valid = 1",notLogicDeletedColumn);
  String updateSetColumns=SqlHelper.updateSetColumns(User.class,null,false,false);
  Assert.assertEquals("<set>is_valid = 1,username = #{username},</set>",updateSetColumns);
}
