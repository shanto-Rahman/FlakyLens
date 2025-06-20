@Test public void testCombiner() throws Exception {
if (!new File(TEST_ROOT_DIR).mkdirs()) {//RO//RW
throw new RuntimeException("Could not create test dir: " + TEST_ROOT_DIR);//RW
}
File in=new File(TEST_ROOT_DIR,"input");//RW
if (!in.mkdirs()) {
}
File out=new File(TEST_ROOT_DIR,"output");//RW
PrintWriter pw=new PrintWriter(new FileWriter(new File(in,"data.txt")));
if (job.isSuccessful()) {
Assert.assertTrue(combinerInputRecords > 0);
Assert.assertTrue(combinerInputRecords > combinerOutputRecords);
BufferedReader br=new BufferedReader(new FileReader(new File(out,"part-r-00000")));
Assert.assertNotNull(line);
Assert.assertNotNull(line);
Assert.assertNull(line);
Assert.assertEquals(expected,output);
Assert.fail("Job failed");
}
}