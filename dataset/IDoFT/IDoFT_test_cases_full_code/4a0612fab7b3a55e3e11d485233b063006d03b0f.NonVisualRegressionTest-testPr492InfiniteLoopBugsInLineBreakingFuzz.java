/** 
 * Tests the line breaking algorithms against infinite loop bugs by using many combinations of styles and random character sequences.
 */
@Test public void testPr492InfiniteLoopBugsInLineBreakingFuzz() throws IOException {
  final String[] whiteSpace=new String[]{"normal","pre","nowrap","pre-wrap","pre-line"};
  final String[] wordWrap=new String[]{"normal","break-word"};
  final List<char[]> all=createAllCombinations();
  final Random rndm=new Random();
  long seed=rndm.nextLong();
  System.out.println("For NonVisualRegressionTest::testPr492InfiniteLoopBugsInLineBreakingFuzz " + "using a random seed of " + seed + " for Random instance.");
  rndm.setSeed(seed);
  List<Integer> lengths=new ArrayList<>();
  lengths.addAll(Arrays.asList(0,1,2,3,37,79));
  for (int i=0; i < 4; i++) {
    lengths.add(rndm.nextInt(150));
  }
  StringBuilder sb=new StringBuilder();
  for (int i=0; i < 100; i++) {
    for (int j=0; j < whiteSpace.length; j++) {
      for (int k=0; k < wordWrap.length; k++) {
        for (        Integer len : lengths) {
          createCombinationTest(sb,i,whiteSpace[j],wordWrap[k],all,rndm,len);
        }
      }
    }
  }
  runFuzzTest(sb.toString(),false);
  runFuzzTest(sb.toString(),true);
}
