
import scala.scalajs.js.annotation.JSExport
import scala.scalajs.js.native
import com.greencatsoft.angularjs.Controller
import com.greencatsoft.angularjs.core.Scope

@JSExport
object HelloController extends Controller  {
  override type ScopeType = HelloWords
  override def initialize(scope: ScopeType) {
    scope.firstHello = "Hello"
    scope.secondHello = "Allo"
  } //End initialize
  
  trait HelloWords extends Scope {
    var firstHello: String = native
    var secondHello: String = native
  }
} //End object HelloController
