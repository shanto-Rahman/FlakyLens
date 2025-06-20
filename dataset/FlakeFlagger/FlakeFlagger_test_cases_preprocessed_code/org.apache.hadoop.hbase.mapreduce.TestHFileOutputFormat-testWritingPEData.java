/** 
 * Run small MR job.
 */
public void testWritingPEData() throws Exception {
assertTrue(job.waitForCompletion(false));
assertTrue(files.length > 0);
}