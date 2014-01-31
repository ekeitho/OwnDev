

/**
 * The test class URLTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class URLTest extends junit.framework.TestCase
{
    /**
     * Default constructor for test class URLTest
     */
    public URLTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    protected void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    protected void tearDown()
    {
    }


	public void testGet()
	{
		URL uRL1 = new URL("http://ekeitho.com?post=13&tag=running");
		System.out.println( uRL1.get("post") );
	}
}


