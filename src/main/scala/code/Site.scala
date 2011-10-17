package code

import net.liftweb.http._
import bigtop.routes._

object Site extends LiftSite with LiftSiteExtras {

  // Routing table:

  val index    = (                                                    end) >> (doIndex _)
  val add      = ("add"      :/: IntArg    :/: "to"   :/: IntArg  :/: end) >> (doAdd _)
  val multiply = ("multiply" :/: IntArg    :/: "by"   :/: IntArg  :/: end) >> (doMultiply _)
  val square   = ("square"   :/: IntArg                           :/: end) >> (doSquare _)
  val repeat   = ("repeat"   :/: StringArg :/: IntArg :/: "times" :/: end) >> (doRepeat _)
  val append   = ("append"                                        :/: any) >> (doAppend _)
  val static   = ("static"                                        :/: any) >> (doStatic _)
  
  // Implementation:
  
  def doIndex() =
    templateResponse("index" :: Nil)

  def doAdd(a: Int, b: Int) =
    templateResponse("calculation" :: Nil, Calculation("+", List(a, b), a + b))

  def doMultiply(a: Int, b: Int) =
    templateResponse("calculation" :: Nil, Calculation("*", List(a, b), a * b))

  def doSquare(a: Int) =
    multiply(a, a)
  
  def doRepeat(a: String, b: Int) =
    templateResponse("calculation" :: Nil, Calculation("repeat", List(a, b), a * b))
  
  def doAppend(args: List[String]) =
    templateResponse("calculation" :: Nil, Calculation("append", args, args.mkString))
  
  def doStatic(path: List[String]) =
    templateResponse("static" :: path)
  
}
