/** 
 * Test ruby sass css processor with multi-threads.
 * @author Simon van der Sluis
 * @created Created on Apr 21, 2010
 */
@Test public void shouldBeThreadSafeWhenInitializingProcessor() throws Exception {
  final RubySassCssProcessor processor=new RubySassCssProcessor();
  final Callable<Void> task=new Callable<Void>(){
    @Override public Void call(){
      try {
        processor.process(new StringReader("$side: top;$radius: 10px;.rounded-#{$side} {border-#{$side}-radius: $radius;}"),new StringWriter());
      }
 catch (      final Exception e) {
        throw new RuntimeException(e);
      }
      return null;
    }
  }
;
  runConcurrently(task);
}
