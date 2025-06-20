@Test public void testInheritableThreadLocalRunnerSet(){
  final String name="testInheritableThreadLocal";
  AsyncLoadTestModel model=asyncLoadTemplate.execute(new AsyncLoadCallback<AsyncLoadTestModel>(){
    public AsyncLoadTestModel doAsyncLoad(){
      inheritableThreadLocal.set(name);
      return asyncLoadTestService.getRemoteModel("ljhtest",1000);
    }
  }
,2000);
  model.getName();
  Assert.assertEquals(inheritableThreadLocal.get(),name);
}
