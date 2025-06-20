@Test public void test() throws CommandDispatcherException {
assertSame(context,subject.getContext());
assertSame(stages,subject.executeOnGroup(command,nodes));
assertSame(stage,subject.executeOnMember(command,node));
}