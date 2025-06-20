@Test public void testLogicDeleteSql(){
Assert.assertEquals("<where> AND id = #{id} AND is_valid = 1</where>",wherePKColumns);
Assert.assertEquals("<where><if test=\"id != null\"> AND id = #{id}</if><if test=\"username != null\"> AND username = #{username}</if> AND is_valid = 1</where>",whereAllIfColumns);
Assert.assertEquals(" AND is_valid = 0",isLogicDeletedColumn);
Assert.assertEquals(" AND is_valid = 1",notLogicDeletedColumn);
Assert.assertEquals("<set>is_valid = 1,username = #{username},</set>",updateSetColumns);
}