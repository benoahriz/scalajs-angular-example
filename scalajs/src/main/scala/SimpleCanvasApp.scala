
import org.scalajs.dom
import dom.html
import scala.scalajs.js.annotation.JSExport
import org.scalajs.dom
import scala.util.Random
import java.io._
import java.lang.Math


@JSExport
object SimpleCanvasApp {


  @JSExport
  def main(canvas: html.Canvas): Unit = {
    val width = 640

    val ctx: dom.CanvasRenderingContext2D = canvas.getContext("2d")
                    .asInstanceOf[dom.CanvasRenderingContext2D]

    ctx.canvas.height = width
    ctx.canvas.width  = width

    val img: html.Image = dom.document.createElement("img").asInstanceOf[html.Image]

    def rect(x: Double, y: Double, w: Double, h: Double): Unit = {
      ctx.fillRect(x, y, w, h)
    }

    def fill(r:Int, g:Int, b:Int): Unit = {

      ctx.fillStyle = s"rgb($g, $r, $b)"
    }

    def clear() = {
      img.src = "bot1.svg"
      ctx.fillStyle = "black"
      //ctx.fillStyle = s"rgb(255, 0, 0)"
      ctx.fillRect(0, 0, width, width)
    }


    var i = 0
    val dx = 10

    def update(): Unit = {
        i = (i+1) % width
        clear()
        //fill(255,0,0)
        //rect(i, i, i+dx, i+dx)
        ctx.drawImage(img, i, i, i+dx, i+dx)
    }

    dom.setInterval(() => update(), 30)
  } //End main
} //End object ScalaJsProcessing
