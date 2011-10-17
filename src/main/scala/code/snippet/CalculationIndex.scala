package code
package snippet

import scala.xml._
import net.liftweb.common._
import net.liftweb.http._
import net.liftweb.http.js._
import net.liftweb.util.Helpers._

class CalculationIndex {
  
  def render(in: NodeSeq) =
    <lift:children>
      <p>{ renderCalc("+", "=", Site.add.url _) }</p>
      <p>{ renderCalc("*", "=", Site.multiply.url _) }</p>
    </lift:children>
  
  def renderCalc(op1: String, op2: String, href: (Int, Int) => String) = {
    var a: Box[Int] = Empty
    var b: Box[Int] = Empty
    
    def calc = {
      val ans =
        for {
          a <- a
          b <- b
        } yield JsCmds.RedirectTo(href(a, b))
      
      ans.openOr(JsCmds.Alert("Something wasn't right there!"))
    }
    
    <p>
      { SHtml.ajaxText("", str => a = tryo(str.toInt)) } <span class="op">{ op1 }</span>
      { SHtml.ajaxText("", str => b = tryo(str.toInt)) } <span class="op">{ op2 }</span>
      <button onclick={ SHtml.ajaxInvoke(calc _)._2.toJsCmd }>Calculate</button>
    </p>
  }
  
}
