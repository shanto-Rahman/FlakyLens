@Test public void updateShouldThrowExceptionWhenAssigneeIsNotSet(){
assertThat(throwable).isInstanceOf(IllegalStateException.class).hasMessage("You cannot update a task where you are not the assignee");
}