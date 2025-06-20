@Test public void shouldReplaceOnlyOneAndPreserveOtherResources(){
Assert.assertEquals(4,group.getResources().size());
Assert.assertEquals(r0,group.getResources().get(0));
Assert.assertEquals(r1,group.getResources().get(1));
}