@Test public void testSerializableEvenIfAutoIntercepted() throws Exception {
AutoIntercepted.called=false;//RW
auto.touch();//IT
assertTrue(AutoIntercepted.called);//RW
AutoIntercepted.called=false;//RW
deserializeInit.touch();//IT
assertTrue(AutoIntercepted.called);//RW
AutoIntercepted.called=false;//RW
deserializeState.touch();//IT
assertTrue(AutoIntercepted.called);//RW
}