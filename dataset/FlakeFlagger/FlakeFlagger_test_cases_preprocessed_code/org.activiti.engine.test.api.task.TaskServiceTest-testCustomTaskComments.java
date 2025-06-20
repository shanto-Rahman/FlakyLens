public void testCustomTaskComments(){
if (processEngineConfiguration.getHistoryLevel().isAtLeast(HistoryLevel.ACTIVITY)) {
assertEquals(CommentEntity.TYPE_COMMENT,comment.getType());
assertEquals(customType1,customComment1.getType());
assertEquals(customType2,customComment3.getType());
assertNotNull(taskService.getComment(comment.getId()));
assertNotNull(taskService.getComment(customComment1.getId()));
assertEquals(1,regularComments.size());
assertEquals("This is a regular comment",regularComments.get(0).getFullMessage());
assertEquals(4,allComments.size());
assertEquals(1,type2Comments.size());
assertEquals("This is another custom comment. Type2 this time!",type2Comments.get(0).getFullMessage());
assertEquals(2,taskTypeComments.size());
}
}