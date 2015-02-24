ScalaJS + AngularJS built with Gradle
==================

Project Directory Structure (the interesting bits)
|
+- gradle 
   |
   +- wrapper // checkin gradle files
|
+- scalajs
   |
   +- project // includes for sbt plugins
   |
   +- src/main/scala // scalajs source code
|
+- src/main/webapp // scalajs files are copied here
|
+- build.gradle // gradle tasks
|
+- sbt // this is a sbt wrapper: 
    
## How do I run it?

Step 1: Compile Scala to Javascript
```bash
gradlew deployScalaJS
```

Step 2: Run Web Server
```bash
gradlew jettyRun
```

Step 3: Point your browser at: http://localhost:8080/scalajs-angular-example/html/index-fulloptjs.html

## Why
The intent was to make a more obvious build/deploy project for people using ScalaJS.  
A couple important notes:
* If you want cross compilation capability, and a ton of other cool Scala stuff please checkout [Li Haoyi](https://twitter.com/li_haoyi) workbench: https://github.com/lihaoyi/workbench
* You don't *have* to use Scala on the backend when using ScalaJS.  A good old Java/Jetty setup works just fine and is a nice complement to ScalaJS and AngularJS tech stack.

## Running the code
There is only 1 'main'.  This method is auto-detected by extending the JSApp.  This is particularly nice when working with Angular because it will just attach to the 'ng-app' attribute if you pass it the same name in both places.

However if you are trying to run arbitrary HTML/Canvas code you can 'pass' into the compiled Javascript the HTML object...like this:
```javascript
SimpleCanvasApp().main(document.getElementById('canvas'));
```

Just be sure you have a method to catch it in Scala like this:
```scala
@JSExport
object SimpleCanvasApp {
  @JSExport
  def main(canvas: html.Canvas): Unit = ?
}
```

Other DOM objects should work just as well.

## IDEs
The suggested IDE is the Scala IDE (Eclipse).  You can import the project via the 'eclipse' task from SBT.  And have a second project for running the Gradle target.  IntelliJ should work just fine as well with the two projects.  Not sure about other tools.

## Dependencies
https://github.com/paulp/sbt-extras 

This is used as a handy wrapper for SBT.  Also I find it useful to download Scala deps to a local project directory.  This avoids conflicts if you develop Scala day-to-day.


https://github.com/greencatsoft/scalajs-angular

scalajs-angular aims to help developers build AngularJS based applications in type safe manner with Scala language.


https://github.com/scala-js/scala-js-dom

Scala-js-dom provides a nice statically typed interface to the DOM such that it can be called from Scala code without resorting to js.Dynamic. All javascript globals functions, singletons and classes are members of the org.scalajs.dom, org.scalajs.dom.html, org.scalajs.dom.svg, etc. packages.


https://github.com/scalatest/scalatest

Since to 'run' ScalaJS you need to deploy it first.  It's super important to have a way to quickly test your ScalaJS code in place...hence the need for ScalaTest to be integrated into the project.


## A final note, a bit about webjars
For this particular project I ended up largely avoiding using webjars and used just the 'war' format.  However there is a Gradle task to create a webjar from the compiled ScalaJS Javascript if you find that you need it.