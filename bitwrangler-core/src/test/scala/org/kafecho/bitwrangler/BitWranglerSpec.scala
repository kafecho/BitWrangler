package org.kafecho.bitwrangler

import org.junit.runner.RunWith
import org.scalatest.matchers.ShouldMatchers
import org.scalatest.WordSpec
import org.scalatest.junit.JUnitRunner
import org.scalatest.prop.GeneratorDrivenPropertyChecks
import akka.util.ByteString
import org.kafecho.bitwrangler.macros.BitWrangler

@RunWith(classOf[JUnitRunner])
class BitWranglerSpec extends WordSpec with ShouldMatchers{
	
	"The byte 0x01" must {

	  val bytes = ByteString(0x01)
	  
	  "have 1 in bit at position 7" in {
	    BitWrangler.boolean(bytes,7) should equal (true)
	  }
	  
	  "have 0 in all other positions" in {
	    
	    BitWrangler.boolean(bytes,0) should equal (false)
	    BitWrangler.boolean(bytes,1) should equal (false)
	    BitWrangler.boolean(bytes,2) should equal (false)
	    BitWrangler.boolean(bytes,3) should equal (false)
	    BitWrangler.boolean(bytes,4) should equal (false)
	    BitWrangler.boolean(bytes,5) should equal (false)
	    BitWrangler.boolean(bytes,6) should equal (false)
	  }
	}
	
	"The bytes (0x3C) [0011 1100]" must {

	  val bytes = ByteString(0x3C)
	  
	  "have the value 3 when reading bits 2 and 3" in {
	    BitWrangler.int(bytes,2,2) should equal (3)
	  }

 	  "have the value 3 when reading bits 4 and 5" in {
	    BitWrangler.int(bytes,4,2) should equal (3)
	  }
 	  
   	  "have the value 7 when reading bits 2,3 and 4" in {
	    BitWrangler.int(bytes,2,3) should equal (7)
	  }
 	  
	}

	
}

