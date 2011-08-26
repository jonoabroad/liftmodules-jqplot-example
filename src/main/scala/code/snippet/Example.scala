package code.snippet

import scala.xml.NodeSeq


import net.liftweb.common._
import net.liftweb.http.S

import net.liftmodules.jqplot._

trait Bs {  implicit def pair2ListAny(p:List[(Any,Any)]): List[List[Any]] = p.map{x => List(x._1,x._2)} }

class LineGraphExample extends Bs {
  
  def render = {
    
    val seriesA = List((1, 1),(2,2),(3,4),(4,8),(5,16),(6,32),(7,64))
    val seriesB = List((64, 1),(32,2),(16,3),(8,4),(4,5),(2,6),(1,7))
      
    val w  = S.attr("w").map(a => a.toInt ).openOr(1024)
    val h  = S.attr("h").map(a => a.toInt ).openOr(768)    
      
    new JqPlot(w,h,Full(Options().title("Line graph")),seriesA,seriesB).toHtml
  }

}
class Dates extends Bs  {
  import java.util.Calendar
  def render = {
    val c = Calendar.getInstance()
    val now = c.getTime
     c.add(Calendar.DATE,-1)
    val then = c.getTime
    c.add(Calendar.DATE,2)
    val soon = c.getTime
    
   val series = List((now,0.0), (then,-1.0), (soon,1.0))
 
   val x = Axis().renderer(DateAxisRenderer())
   
   val s = Series().lineWidth(4).markerOptions(MarkerOption().style(square()))

   val options = Options().title("Date objects").axes(Axes().xaxis(x)).seriesDefault(s)
     
     
    new JqPlot(512,512,Full(options),series).toCssTransformer
  } 
}

class Pie extends Bs  {
  
  def render = {
    val series = List(("Heavy Industry", 12),("Retail", 9), ("Light Industry", 14),("Out of home", 16),("Commuting", 7), ("Orientation", 9))

    val options = Options().title("Pie Chart").seriesDefault(Series().renderer(PieRenderer())) //.legend(Legend().location(EA()))
    
    new JqPlot(512,512,Full(options),series).toCssTransformer
  } 
}
class Bar extends Bs  {

  def render = {
   val seriesA = List((2,1), (4,2), (6,3), (3,4))
   val seriesB = List((5,1), (1,2), (3,3), (4,4))
   val seriesC = List((4,1), (7,2), (1,3), (2,4))
   
   val options = Options().title("Bar chart").seriesDefault(Series().renderer(BarRenderer()).shadowAngle(135)).axes(Axes().yaxis(Axis().renderer(CategoryAxisRenderer())))
   
    new JqPlot(512,512,Full(options),seriesA,seriesB,seriesC).toCssTransformer
  } 
}
class Bubbles extends Bs  {

  def render = {
   val series = List(List(11, 123, 1236, "Acura"), List(45, 92, 1067, "Alfa Romeo"),List(24, 104, 1176, "AM General"), List(50, 23, 610, "Aston Martin Lagonda"),List(18, 17, 539, "Audi"), List(7, 89, 864, "BMW"), List(2, 13, 1026, "Bugatti"))

   val options = Options().title("Bubble Chart").seriesDefault(Series().renderer(BubbleRenderer()))

   new JqPlot(512,512,Full(options),series).toCssTransformer
  } 
}
class OHLC  extends Bs {

  def render = {
   val series = List(List("06/15/2009 16:00:00", 136.01, 139.5, 134.53, 139.48),List("06/08/2009 16:00:00", 143.82, 144.56, 136.04, 136.97),List("06/01/2009 16:00:00", 136.47, 146.4, 136.0, 144.67),List("05/26/2009 16:00:00", 124.76, 135.9, 124.55, 135.81))
   
   val options = Options().title("OHLC").axes(
      Axes().xaxis(Axis().renderer(DateAxisRenderer()))).
      series(List(Series().renderer(OHLCRenderer())))
   
   
    new JqPlot(512,512,Full(options),series).toCssTransformer
  } 
}
class Cosine extends Bs  {
  
  def render = {
   import scala.math._    
    
   val v = 0D to 2*Pi by 0.1
   val series = for { i <- v.toList } yield {(i,cos(i))}
   
   val options = Options().title("Cosine").axes(Axes().xaxis(Axis().label("Angle (radians)")).
		   											   yaxis(Axis().label("Cosine")))
      
    new JqPlot(512,512,Full(options),series).toCssTransformer
  } 
}



 
 
    
     