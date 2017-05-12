import org.scalatest.{FlatSpec, MustMatchers}


class TestTest extends FlatSpec with MustMatchers {
    "behavior of test test"

    it should "do a valid test" in {
        "b" mustEqual "b"
    }
}
