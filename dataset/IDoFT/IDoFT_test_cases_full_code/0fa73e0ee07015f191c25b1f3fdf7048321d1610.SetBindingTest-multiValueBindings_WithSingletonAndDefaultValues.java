@Test public void multiValueBindings_WithSingletonAndDefaultValues(){
  final AtomicInteger singletonCounter=new AtomicInteger(100);
  final AtomicInteger defaultCounter=new AtomicInteger(200);
class TestEntryPoint {
    @Inject Set<Integer> objects1;
    @Inject Set<Integer> objects2;
  }
@Module(injects=TestEntryPoint.class) class TestModule {
    @Provides(type=SET) @Singleton Integer a(){
      return singletonCounter.getAndIncrement();
    }
    @Provides(type=SET) Integer b(){
      return defaultCounter.getAndIncrement();
    }
  }
  TestEntryPoint ep=injectWithModule(new TestEntryPoint(),new TestModule());
  assertEquals(set(100,200),ep.objects1);
  assertEquals(set(100,201),ep.objects2);
}
