
import scala.scalajs.js.JSApp
import scala.scalajs.js.annotation.JSExport

import com.greencatsoft.angularjs.Angular

@JSExport
object SimpleAngularApp extends JSApp  {
  	
  def main(): Unit = {
    val module = Angular.module("hellomvc")
    module.controller(HelloController)
  } //End main
} //End object HelloWorldApp
