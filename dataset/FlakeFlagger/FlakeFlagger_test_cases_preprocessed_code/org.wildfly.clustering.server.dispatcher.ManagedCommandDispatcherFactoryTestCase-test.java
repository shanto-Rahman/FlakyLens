@Test public void test(){
assertSame(context,dispatcher1.getContext());
assertSame(dispatcher1,dispatcher2);
fail();
}